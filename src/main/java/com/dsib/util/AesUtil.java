package com.dsib.util;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

    public class AesUtil {  
      
    	/** 
         * 密钥算法 
         */  
        private static final String KEY_ALGORITHM = "AES";   
          
        /** 
         * 生成密钥 
         * @return 
         * @throws Exception 
         */  
        private SecretKey geneKey() throws Exception {  
            //获取一个密钥生成器实例  
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);  
            SecureRandom random = new SecureRandom();  
            random.setSeed("51908196".getBytes());//设置加密用的种子，密钥  
            keyGenerator.init(random);  
            SecretKey secretKey = keyGenerator.generateKey();  
            //把上面的密钥存起来  
            Path keyPath = Paths.get("D:/dsib.key");  
            Files.write(keyPath, secretKey.getEncoded());  
            return secretKey;  
        }  
          
        /** 
         * 读取存储的密钥 
         * @param keyPath 
         * @return 
         * @throws Exception 
         */  
        private SecretKey readKey(Path keyPath) throws Exception {  
            //读取存起来的密钥  
            byte[] keyBytes = Files.readAllBytes(keyPath);  
            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, KEY_ALGORITHM);  
            return keySpec;  
        }  
          
        /**
         * 加密方法
         * @param content 要加密的字符串
         * @return
         * @throws Exception
         */
        public String Encrypt(String content) throws Exception {  
            //1、指定算法、获取Cipher对象  
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);//算法是AES  
            //2、生成/读取用于加解密的密钥  
            String path = this.getClass().getResource("/").getPath()+"dsib.key";
            SecretKey secretKey = this.readKey(Paths.get(path.substring(1, path.length())));  
            //3、用指定的密钥初始化Cipher对象，指定是加密模式，还是解密模式  
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);  
            //4、更新需要加密的内容  
//            cipher.update(content.getBytes());  
            //5、进行最终的加解密操作  
//            byte[] result = cipher.doFinal();//加密后的字节数组  
            //也可以把4、5步组合到一起，但是如果保留了4步，同时又是如下这样使用的话，加密的内容将是之前update传递的内容和doFinal传递的内容的和。  
            byte[] result = cipher.doFinal(content.getBytes("utf-8"));  
            String base64Result = new String(new BASE64Encoder().encode(result));//对加密后的字节数组进行Base64编码  
//            System.out.println("加密后====="+base64Result.replaceAll("\r\n", ""));
            return base64Result.replaceAll("\r\n", "");
        }  
          
        /**
         * 解密的方法 
         * @param content 要解密的字符串
         * @return
         * @throws Exception
         */
        public String Decrpyt(String content) throws Exception {  
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);  
            String path = this.getClass().getResource("/").getPath()+"dsib.key";
            SecretKey secretKey = this.readKey(Paths.get(path.substring(1, path.length())));
	        cipher.init(Cipher.DECRYPT_MODE, secretKey);  
	        byte[] byte_content= new BASE64Decoder().decodeBuffer(content);
	        byte[] result = cipher.doFinal(byte_content);//对加密后的字节数组进行解密  
//	        System.out.println("解密后========: " + new String(result));
	        return new String(result,"utf-8");
        }  
          
    }  