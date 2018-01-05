package com.dsib.util;

/**
 * 读取数字证书RSA密钥对工具类
 * 
 * 
 */
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Enumeration;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
public class RsaUtil {

	/**
	 * 从KEYSTORE文件中取得公钥
	 * 
	 * @param keyStoreFile
	 * @param storeFilePass
	 * @param keyAlias
	 * @return
	 * @throws Exception
	 */
	public PublicKey getPubKeyFromKS(String keyStoreFile, String storeFilePass,
			String keyAlias) throws Exception {

		// 读取密钥是所要用到的工具类
		KeyStore ks;
		// 公钥类所对应的类
		PublicKey pubkey = null;
		// 得到实例对象
		ks = KeyStore.getInstance("JKS");
		FileInputStream fin;
		// 读取JKS文件
		fin = new FileInputStream(keyStoreFile);
		// 读取公钥
		ks.load(fin, storeFilePass.toCharArray());
		java.security.cert.Certificate cert = ks.getCertificate(keyAlias);
		pubkey = cert.getPublicKey();

		return pubkey;
	}

	/**
	 * 从公钥证书中读取公钥
	 * 
	 * @param crtFileName
	 * @return
	 * @throws Exception
	 */
	public PublicKey getPubKeyFromCRT(String crtFileName) throws Exception {
		InputStream is = new FileInputStream(crtFileName);
		CertificateFactory cf = CertificateFactory.getInstance("x509");
		Certificate cerCert = cf.generateCertificate(is);
		return cerCert.getPublicKey();
	}

	/**
	 * 通过PFX文件获得公钥
	 * 
	 * @param PFX文件路径
	 * @param PublicKey
	 * @return
	 */
	public PublicKey getPukformPfx(String strPfx, String strPassword)
			throws Exception {
		PublicKey pubkey = null;
		KeyStore ks = getKsformPfx(strPfx, strPassword);
		String keyAlias = getAlsformPfx(strPfx, strPassword);
		Certificate cert = ks.getCertificate(keyAlias);
		pubkey = cert.getPublicKey();
		return pubkey;
	}

	/**
	 * 从KEYSTORE文件中取得私钥
	 * 
	 * @param keyStoreFile
	 * @param storeFilePass
	 * @param keyAlias
	 * @param keyAliasPass
	 * @return
	 * @throws Exception
	 */
	public PrivateKey getPriKeyFromKS(String keyStoreFile,
			String storeFilePass, String keyAlias, String keyAliasPass)
			throws Exception {
		KeyStore ks;
		PrivateKey prikey = null;
		ks = KeyStore.getInstance("JKS");
		FileInputStream fin;
		fin = new FileInputStream(keyStoreFile);
		// 先打开文件
		ks.load(fin, storeFilePass.toCharArray());
		// 通过别名和密码得到私钥
		prikey = (PrivateKey) ks.getKey(keyAlias, keyAliasPass.toCharArray());
		return prikey;
	}

	/**
	 * 通过PFX文件获得私钥
	 * 
	 * @param 文件路径
	 * @param PFX密码
	 * @return PrivateKey
	 */
	public PrivateKey getPvkformPfx(String strPfx, String strPassword)
			throws Exception {
		PrivateKey prikey = null;
		char[] nPassword = null;
		if ((strPassword == null) || strPassword.trim().equals("")) {
			nPassword = null;
		} else {
			nPassword = strPassword.toCharArray();
		}
		KeyStore ks = getKsformPfx(strPfx, strPassword);
		String keyAlias = getAlsformPfx(strPfx, strPassword);
		prikey = (PrivateKey) ks.getKey(keyAlias, nPassword);
		return prikey;
	}

	/**
	 * 通过PFX文件获得KEYSTORE
	 * 
	 * @param 文件路径
	 * @param PFX密码
	 * @return KeyStore
	 */
	public static KeyStore getKsformPfx(String strPfx, String strPassword)
			throws Exception {
		FileInputStream fis = null;
		Security
				.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

		KeyStore ks = KeyStore.getInstance("PKCS12", "BC");
		fis = new FileInputStream(strPfx);
		char[] nPassword = null;
		if ((strPassword == null) || strPassword.trim().equals("")) {
			nPassword = null;
		} else {
			nPassword = strPassword.toCharArray();
		}
		ks.load(fis, nPassword);
		if (null != fis) {

			fis.close();

		}
		return ks;

	}

	/**
	 * 通过PFX文件获得别名
	 * 
	 * @param 文件路径
	 * @param PFX密码
	 * @return 别名
	 */
	public static String getAlsformPfx(String strPfx, String strPassword)
			throws Exception {
		String keyAlias = null;
		KeyStore ks = getKsformPfx(strPfx, strPassword);
		Enumeration<String> enumas = ks.aliases();
		keyAlias = null;
		// we are readin just one certificate.
		if (enumas.hasMoreElements()) {
			keyAlias = (String) enumas.nextElement();
		}
		return keyAlias;
	}

	/**
	 * 用私钥对文件进行加密
	 * 
	 */
	public byte[] encryptWithPrv(byte[] date, PrivateKey PriKey, boolean needEncode) throws Exception {
		RSAPrivateKey priKey = (RSAPrivateKey) PriKey;
		//  用私钥对数据流进行加密
		byte[] result = encrypt(priKey, date);
		return result;
	}
	
	public static RSAPrivateKey generateRSAPrivateKey(byte[] modulus,
			byte[] privateExponent) throws Exception {
		KeyFactory keyFac = null;
		keyFac = KeyFactory.getInstance("RSA",
				new org.bouncycastle.jce.provider.BouncyCastleProvider());
		// getInstance(String algorithm, Provider provider)
		// 为指定提供程序中的指定算法生成KeyFactory 对象
		RSAPrivateKeySpec prvKeySpec = new RSAPrivateKeySpec(new BigInteger(
				modulus), new BigInteger(privateExponent));
		return (RSAPrivateKey) keyFac.generatePrivate(prvKeySpec);
		
	}

	
	/**
	 * 用私钥进行解密 <br><pre>
	 * 创建时间：2015年8月6日 上午9:27:13 </pre>
	 * @param String src					要解密的源数据
	 * @param String sInCharset		源数据的编码
	 * @param String sOutCharset	解密后数据的编码
	 * @param PrivateKey PriKey	私钥
	 * @param boolean needBase64Decode		是否需要Base64转码
	 * @param boolean isBefore	    true表示 先转码后解密，false表示先解密后转码
	 * @return byte[] 解密后的明文
	 * @throws 异常类型 说明
	 */
	public String decryptWithPrv(String src,String sInCharset, String sOutCharset,
			PrivateKey PriKey,
			boolean needBase64Decode,boolean isBefore) throws Exception {
		byte[] bNeedDecrytdata=null;
		bNeedDecrytdata = src.getBytes(sInCharset);
		if (needBase64Decode && isBefore) {
			bNeedDecrytdata= Base64.decodeBase64(src);
		}
		byte[] bOutData = decryptWithPrv(bNeedDecrytdata, PriKey);
		if (needBase64Decode && (!isBefore)) {
			bOutData = Base64.decodeBase64(bOutData);
		}
		String sOut = new String(bOutData,sInCharset);
		return new String(sOut.getBytes(),sOutCharset);
	}

	/**
	 * 用私钥进行解密 <br><pre>
	 * 创建时间：2015年8月6日 上午9:27:13 </pre>
	 * @param byte[] srcData 			要解密的源数据
	 * @param PrivateKey PriKey 	私钥
	 * @return byte[] 解密后的明文
	 * @throws 异常类型 说明
	 */
	//**************************************************************************
	public byte[] decryptWithPrv(byte[] srcData, PrivateKey PriKey) throws Exception {

		RSAPrivateKey rsaPriKey = (RSAPrivateKey) PriKey;
		byte[] prvModBytes = rsaPriKey.getModulus().toByteArray();
		byte[] prvExpBytes = rsaPriKey.getPrivateExponent().toByteArray();
		RSAPrivateKey recoveryPrvKey = generateRSAPrivateKey(prvModBytes,
				prvExpBytes);
		// 用私钥对byte流进行解密
		byte[] data = decrypt(recoveryPrvKey, srcData);
		return data;
	}

	
	/**
	 * 用公钥进行解密
	 */
	public byte[] decryptWithPub(byte[] date, PublicKey pubKey,
			boolean needDecode) throws Exception {
		// 从私钥pfx中取得公钥
		RSAPublicKey rsaPubKey = (RSAPublicKey) pubKey;
		byte[] pubModBytes = rsaPubKey.getModulus().toByteArray();
		byte[] pubPubExpBytes = rsaPubKey.getPublicExponent().toByteArray();
		RSAPublicKey recoveryPubKey = generateRSAPublicKey(pubModBytes,
				pubPubExpBytes);
		// 用公钥对byte流进行解密
		byte[] data = decrypt(recoveryPubKey, date);
		return data;
	}

	/**
	 * @param modulus
	 * @param publicExponent
	 * @return
	 * @throws Exception
	 */
	public static RSAPublicKey generateRSAPublicKey(byte[] modulus,
			byte[] publicExponent) throws Exception {
		KeyFactory keyFac = null;
		keyFac = KeyFactory.getInstance("RSA",
				new org.bouncycastle.jce.provider.BouncyCastleProvider());
		// 为指定提供程序中的指定算法生成KeyFactory 对象
		RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(new BigInteger(
				modulus), new BigInteger(publicExponent));
		return (RSAPublicKey) keyFac.generatePublic(pubKeySpec);
		// generatePublic(KeySpec keySpec) 根据所提供的密钥规范（密钥材料）生成公钥对象。
	}
	/**
	 * 加密数据
	 * @param key 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(Key key, byte[] data) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA",new org.bouncycastle.jce.provider.BouncyCastleProvider());
		cipher.init(Cipher.ENCRYPT_MODE, key);
		int blockSize = cipher.getBlockSize();
		int outputSize = cipher.getOutputSize(data.length);// 获得加密块加密后块大小
		int leavedSize = data.length % blockSize;
		int blocksSize = leavedSize != 0 ? data.length / blockSize + 1
				: data.length / blockSize;
		byte[] raw = new byte[outputSize * blocksSize];
		int i = 0;
		while (data.length - i * blockSize > 0) {
			if (data.length - i * blockSize > blockSize)
				cipher.doFinal(data, i * blockSize, blockSize, raw, i
						* outputSize);
			else
				cipher.doFinal(data, i * blockSize,
						data.length - i * blockSize, raw, i * outputSize);
			i++;
		}
		return raw;
	}

	/**
	 * 解密数据
	 * @param Key  key
	 * @param byte[] raw
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(Key key, byte[] raw) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA",new org.bouncycastle.jce.provider.BouncyCastleProvider());
		cipher.init(cipher.DECRYPT_MODE, key);
		int blockSize = cipher.getBlockSize();
		ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
		int j = 0;
		while (raw.length - j * blockSize > 0) {
			bout.write(cipher.doFinal(raw, j * blockSize, blockSize));
			j++;
		}
		return bout.toByteArray();
	}
}
