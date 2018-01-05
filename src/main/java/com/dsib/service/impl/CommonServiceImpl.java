package com.dsib.service.impl;

import java.math.BigDecimal;
import java.security.PrivateKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsib.dao.ClaimInsuredMapper;
import com.dsib.dao.ClaimMainMapper;
import com.dsib.dao.DetailedListMapper;
import com.dsib.dao.Jg_GuPolicyClaimMapper;
import com.dsib.dao.Jg_GuPolicyMainMapper;
import com.dsib.dao.Jg_InsuranceMapper;
import com.dsib.dao.PolicyApplicantMapper;
import com.dsib.dao.PolicyInsuranceMapper;
import com.dsib.dao.PolicyInsuredMapper;
import com.dsib.dao.PolicyItemKindMapper;
import com.dsib.dao.PolicyMainMapper;
import com.dsib.dao.PolicyOrganizerMapper;
import com.dsib.entity.ClaimInsured;
import com.dsib.entity.ClaimMain;
import com.dsib.entity.DetailedList;
import com.dsib.entity.Jg_GuPolicyClaim;
import com.dsib.entity.Jg_GuPolicyMain;
import com.dsib.entity.Jg_Insurance;
import com.dsib.entity.Jg_InsuranceKey;
import com.dsib.entity.PolicyApplicant;
import com.dsib.entity.PolicyInsurance;
import com.dsib.entity.PolicyInsured;
import com.dsib.entity.PolicyItemKind;
import com.dsib.entity.PolicyMain;
import com.dsib.entity.PolicyOrganizer;
import com.dsib.policyDto.Applicant;
import com.dsib.policyDto.Insurance;
import com.dsib.policyDto.Insured;
import com.dsib.policyDto.ItemKind;
import com.dsib.policyDto.Main;
import com.dsib.policyDto.Organizer;
import com.dsib.policyDto.Request;
import com.dsib.policyDto.Response;
import com.dsib.policyDto.ResponseStatus;
import com.dsib.service.CommonService;
import com.dsib.util.AesUtil;
import com.dsib.util.RsaUtil;
import com.dsib.util.WriteFileToFile;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
@Service("commonService")
public class CommonServiceImpl implements CommonService{
	
	@Autowired
	private PolicyApplicantMapper policyApplicantMapper;
	@Autowired
	private PolicyMainMapper policyMainMapper;
	@Autowired 
	private PolicyOrganizerMapper policyOrganizerMapper;
	@Autowired 
	private PolicyInsuranceMapper policyInsuranceMapper;
	@Autowired
	private PolicyInsuredMapper policyInsuredMapper;
	@Autowired
	private PolicyItemKindMapper policyItemKindMapper;
	@Autowired
	private ClaimMainMapper claimMainMapper;
	@Autowired
	private ClaimInsuredMapper claimInsuredMapper;
	@Autowired
	private Jg_GuPolicyMainMapper jg_GuPolicyMainMapper;
	@Autowired
	private Jg_GuPolicyClaimMapper jg_GuPolicyClaimMapper;
	@Autowired
	private Jg_InsuranceMapper jg_InsuranceMapper;
	@Autowired
	private DetailedListMapper detailedListMapper;
	
//	private String keyStorePath = "dsib.keystore";//rsa加密用到的
	
	private static Logger log = Logger.getLogger(CommonServiceImpl.class.getName());
	/**
	 * 保单信息处理方法
	 * @param requestXml
	 * @return
	 */
	public String savePolicy(String requestXml){
		String resultFlag = "";
		String checkResult = "";
		String responseXml ="";
		AesUtil aesUtil = new AesUtil();
//		System.out.println("解密前收到的报文======"+requestXml);
		WriteFileToFile write = new WriteFileToFile();//记录收到的报文
		log.debug("解密前收到的报文:===="+requestXml);
		if(requestXml==null||"null".equals(requestXml)){
			resultFlag="N";
			checkResult="报文获取失败！未收到报文";
			Response response = new Response();
			System.out.println("解密后收到的报文======"+requestXml);
			ResponseStatus responseStatus = new ResponseStatus("报文获取失败", resultFlag , checkResult);
			response.setResponseStatus(responseStatus);
			XStream xs = new XStream();
			xs.alias("Response", Response.class);
			xs.alias("ResponseStatus", ResponseStatus.class);
			responseXml = "<?xml version='1.0' encoding='GBK'?> \n"
					+ xs.toXML(response);
			System.out.println("加密前返回的报文======"+responseXml);
			try {
				responseXml = aesUtil.Encrypt(responseXml);
			} catch (Exception e) {
				e.printStackTrace();
				saveLog(e,responseXml);
			}
			//加密结束
			System.out.println("加密后返回的报文======"+responseXml);
			return responseXml;
		}
		requestXml = requestXml.replace(" ", "+");//服务器会转义+号为空格                                                                                                                                                                                                                                                                                                                                                                                               
		//解密逻辑开始
		try {
			requestXml = aesUtil.Decrpyt(requestXml);
		} catch (Exception e1) {
			e1.printStackTrace();
			resultFlag="N";
			checkResult="报文解密失败";
			Response response = new Response();
			System.out.println("解密后收到的报文======"+requestXml);
			ResponseStatus responseStatus = new ResponseStatus("报文解密失败", resultFlag , checkResult);
			response.setResponseStatus(responseStatus);
			XStream xs = new XStream();
			xs.alias("Response", Response.class);
			xs.alias("ResponseStatus", ResponseStatus.class);
			responseXml = "<?xml version='1.0' encoding='GBK'?> \n"
					+ xs.toXML(response);
			System.out.println("加密前返回的报文======"+responseXml);
			saveLog(e1,responseXml);
			try {
				responseXml = aesUtil.Encrypt(responseXml);
			} catch (Exception e) {
				e.printStackTrace();
				saveLog(e,responseXml);
			}
			//加密结束
			System.out.println("加密后返回的报文======"+responseXml);
			return responseXml;
		}
		//解密逻辑结束
		Request request = null;
		XStream stream = new XStream(new DomDriver());
		try {
		stream.alias("Request", Request.class);
		stream.alias("Main", Main.class);
		stream.alias("Organizer", Organizer.class);
		stream.alias("Applicant", Applicant.class);
		stream.alias("Insured", Insured.class);
		stream.alias("Insurance", Insurance.class);
		stream.alias("ItemKind", ItemKind.class);
		request = (Request) stream.fromXML(requestXml);
		} catch (Exception e) {
			e.printStackTrace();
			resultFlag="N";
			checkResult="报文格式错误";
			Response response = new Response();
//			System.out.println("解密后收到的报文======"+requestXml);
			ResponseStatus responseStatus = new ResponseStatus("报文解析失败", resultFlag , checkResult);
			response.setResponseStatus(responseStatus);
			XStream xs = new XStream();
			xs.alias("Response", Response.class);
			xs.alias("ResponseStatus", ResponseStatus.class);
			responseXml = "<?xml version='1.0' encoding='GBK'?> \n"
					+ xs.toXML(response);
			System.out.println("加密前返回的报文======"+responseXml);
			saveLog(e,responseXml);
			try {
				responseXml = aesUtil.Encrypt(responseXml);
			} catch (Exception e1) {
				e1.printStackTrace();
				saveLog(e1,responseXml);
			}
			System.out.println("加密后返回的报文======"+responseXml);
			return responseXml;
		}
		//此处应有校验及入库操作
		checkResult = checkPolicyManager(request);
		if("".equals(checkResult)){//校验成功入库
			try {
				resultFlag = insertPolicyManger(request);
				checkResult = "成功";
			} catch (Exception e) {
				e.printStackTrace();
				write.write(requestXml, request.getMain().getPolicyNo()+"Policy");
				resultFlag="N";
				checkResult="数据异常,入库失败请校验！";
				Response response = new Response();
//				System.out.println("解密后收到的报文======"+requestXml);
				ResponseStatus responseStatus = new ResponseStatus(request.getMain().getPolicyNo(), resultFlag , checkResult);
				response.setResponseStatus(responseStatus);
				XStream xs = new XStream();
				xs.alias("Response", Response.class);
				xs.alias("ResponseStatus", ResponseStatus.class);
				responseXml = "<?xml version='1.0' encoding='GBK'?> \n" + xs.toXML(response);
				write.write(responseXml, request.getMain().getPolicyNo()+"PolicyResult");//记录返回的报文
				System.out.println("加密前返回的报文======"+responseXml);
				saveLog(e,responseXml);
				try {
					responseXml = aesUtil.Encrypt(responseXml);
				} catch (Exception e1) {
					e1.printStackTrace();
					saveLog(e1,responseXml);
				}
				System.out.println("加密后返回的报文======"+responseXml);
				return responseXml;
			}
		}else{//校验失败返回错误信息
			resultFlag = "N";
		}
		write.write(requestXml, request.getMain().getPolicyNo()+"Policy");
//		System.out.println("解密后收到的报文======"+requestXml);
		log.debug("解密后收到的报文为:===="+responseXml);
		Response response = new Response();
		ResponseStatus responseStatus = new ResponseStatus(request.getMain().getPolicyNo(), resultFlag , checkResult);
		response.setResponseStatus(responseStatus);
		XStream xs = new XStream();
		xs.alias("Response", Response.class);
		xs.alias("ResponseStatus", ResponseStatus.class);
		responseXml = "<?xml version='1.0' encoding='GBK'?> \n"
				+ xs.toXML(response);
		write.write(responseXml, request.getMain().getPolicyNo()+"PolicyResult");//记录返回的报文
		System.out.println("加密前返回的报文======"+responseXml);
		try {
			responseXml = aesUtil.Encrypt(responseXml);
		} catch (Exception e) {
			e.printStackTrace();
			saveLog(e,responseXml);
		}
		log.debug("调用成功返回报文为:===="+responseXml);
		System.out.println("加密后返回的报文======"+responseXml);
		return responseXml;
	}
	/**
	 * 理赔信息处理方法
	 * @param requestXml
	 * @return
	 */
	public String saveClaim(String requestXml){
		String resultFlag = "";
		String checkResult = "";
		String responseXml = "";
		AesUtil aesUtil = new AesUtil();
		WriteFileToFile write = new WriteFileToFile();//记录收到的报文
		if(requestXml==null||"null".equals(requestXml)){
			resultFlag="N";
			checkResult="报文获取失败！未收到报文";
			com.dsib.claimDto.Response response = new com.dsib.claimDto.Response();
			com.dsib.claimDto.ResponseStatus responseStatus = new com.dsib.claimDto.ResponseStatus("报文获取失败",
					"报文获取失败", resultFlag, checkResult);
			response.setResponseStatus(responseStatus);
			XStream xs = new XStream();
			xs.alias("Response", com.dsib.claimDto.Response.class);
			xs.alias("ResponseStatus", com.dsib.claimDto.ResponseStatus.class);
			responseXml = "<?xml version='1.0' encoding='GBK'?> \n"
					+ xs.toXML(response);
			System.out.println("加密前返回的报文======"+responseXml);
			//加密逻辑开始
			try {
				responseXml = aesUtil.Encrypt(responseXml);
			} catch (Exception e2) {
				e2.printStackTrace();
				saveLog(e2,responseXml);
			}
			//加密结束
			return responseXml;
		}
//		System.out.println("解密前收到的报文======"+requestXml);
		log.debug("解密前收到的报文======"+requestXml);
		requestXml = requestXml.replace(" ", "+");//服务器会转义+号为空格
		//解密逻辑开始
		try {
			requestXml = aesUtil.Decrpyt(requestXml);
		} catch (Exception e1) {
			e1.printStackTrace();
			resultFlag="N";
			checkResult="报文解密失败";
//			System.out.println("解密后收到的报文======"+requestXml);
			com.dsib.claimDto.Response response = new com.dsib.claimDto.Response();
			com.dsib.claimDto.ResponseStatus responseStatus = new com.dsib.claimDto.ResponseStatus("报文解密失败",
					"报文解密失败", resultFlag, checkResult);
			response.setResponseStatus(responseStatus);
			XStream xs = new XStream();
			xs.alias("Response", com.dsib.claimDto.Response.class);
			xs.alias("ResponseStatus", com.dsib.claimDto.ResponseStatus.class);
			responseXml = "<?xml version='1.0' encoding='GBK'?> \n"
					+ xs.toXML(response);
			System.out.println("加密前返回的报文======"+responseXml);
			saveLog(e1,responseXml);
			//加密逻辑开始
			try {
				responseXml = aesUtil.Encrypt(responseXml);
			} catch (Exception e2) {
				e2.printStackTrace();
				saveLog(e2,responseXml);
			}
			//加密结束
			return responseXml;
		}
		//解密逻辑结束
		com.dsib.claimDto.Request request = null;
		XStream stream = new XStream(new DomDriver());
		try {
		stream.alias("Request", com.dsib.claimDto.Request.class);
		stream.alias("Main", com.dsib.claimDto.Main.class);
		stream.alias("Insured", com.dsib.claimDto.Insured.class);
		request = (com.dsib.claimDto.Request) stream.fromXML(requestXml);
		} catch (Exception e) {
			e.printStackTrace();
			resultFlag="N";
			checkResult="报文格式错误";
//			System.out.println("解密后收到的报文======"+requestXml);
			com.dsib.claimDto.Response response = new com.dsib.claimDto.Response();
			com.dsib.claimDto.ResponseStatus responseStatus = new com.dsib.claimDto.ResponseStatus("报文解析失败",
					"报文解析失败", resultFlag, checkResult);
			response.setResponseStatus(responseStatus);
			XStream xs = new XStream();
			xs.alias("Response", com.dsib.claimDto.Response.class);
			xs.alias("ResponseStatus", com.dsib.claimDto.ResponseStatus.class);
			responseXml = "<?xml version='1.0' encoding='GBK'?> \n"
					+ xs.toXML(response);
			System.out.println("加密前返回的报文======"+responseXml);
			saveLog(e,responseXml);
			//加密逻辑开始
			try {
				responseXml = aesUtil.Encrypt(responseXml);
			} catch (Exception e2) {
				e2.printStackTrace();
				saveLog(e2,responseXml);
			}
			//加密结束
			return responseXml;
		}
		//此处应有校验及入库操作
		checkResult = checkClaimManager(request);
		resultFlag = "";
		if("".equals(checkResult)){//校验成功入库
			try {
				resultFlag = insertClaimManager(request);
				checkResult = "成功";
			} catch (Exception e) {
				e.printStackTrace();
				write.write(requestXml, "P="+request.getMain().getPolicyNo()+"C="+request.getMain().getReportNo()+"Claim");
				resultFlag="N";
				checkResult="数据异常,入库失败请校验！";
//				System.out.println("解密后收到的报文======"+requestXml);
				com.dsib.claimDto.Response response = new com.dsib.claimDto.Response();
				com.dsib.claimDto.ResponseStatus responseStatus = new com.dsib.claimDto.ResponseStatus(request.getMain().getPolicyNo(),
						request.getMain().getReportNo(), resultFlag, checkResult);
				response.setResponseStatus(responseStatus);
				XStream xs = new XStream();
				xs.alias("Response", com.dsib.claimDto.Response.class);
				xs.alias("ResponseStatus", com.dsib.claimDto.ResponseStatus.class);
				responseXml = "<?xml version='1.0' encoding='GBK'?> \n"
						+ xs.toXML(response);
				System.out.println("加密前返回的报文======"+responseXml);
				write.write(responseXml, request.getMain().getPolicyNo()+"ClaimResult");//记录返回的报文
				saveLog(e,responseXml);
				//加密逻辑开始
				try {
					responseXml = aesUtil.Encrypt(responseXml);
				} catch (Exception e2) {
					e2.printStackTrace();
					saveLog(e2,responseXml);
				}
				//加密结束
				return responseXml;
			}
		}else{//校验失败返回错误信息
			resultFlag = "N";
		}
		write.write(requestXml, "P="+request.getMain().getPolicyNo()+"C="+request.getMain().getReportNo()+"Claim");
//		System.out.println("解密后收到的报文======"+requestXml);
		log.debug("解密后收到的报文======"+requestXml);
		com.dsib.claimDto.Response response = new com.dsib.claimDto.Response();
		com.dsib.claimDto.ResponseStatus responseStatus = new com.dsib.claimDto.ResponseStatus(request.getMain().getPolicyNo(),
				request.getMain().getReportNo(), resultFlag, checkResult);
		response.setResponseStatus(responseStatus);
		XStream xs = new XStream();
		xs.alias("Response", com.dsib.claimDto.Response.class);
		xs.alias("ResponseStatus", com.dsib.claimDto.ResponseStatus.class);
		responseXml = "<?xml version='1.0' encoding='GBK'?> \n"
				+ xs.toXML(response);
		write.write(responseXml, "P="+request.getMain().getPolicyNo()+"C="+request.getMain().getReportNo()+"ClaimResult");//记录返回的报文
		System.out.println("加密前返回的报文======"+responseXml);
		log.debug("加密前返回的报文======"+responseXml);
		//加密逻辑开始
		try {
			responseXml = aesUtil.Encrypt(responseXml);
		} catch (Exception e) {
			e.printStackTrace();
			saveLog(e,responseXml);
		}
		//加密结束
		System.out.println("加密后返回的报文======"+responseXml);
		log.debug("加密后返回的报文======"+responseXml);
		return responseXml;
	}
	
	/**
	 * 清单信息处理方法
	 * @param requestXml
	 * @return
	 */
	public String saveDetailedList(String requestXml){
		String resultFlag = "";
		String checkResult = "";
		String responseXml = "";
		AesUtil aesUtil = new AesUtil();
		if(requestXml==null||"null".equals(requestXml)){
			resultFlag="N";
			checkResult="报文获取失败！未收到报文";
			com.dsib.detailListDto.Response response = new com.dsib.detailListDto.Response();
			com.dsib.detailListDto.ResponseStatus responseStatus = new com.dsib.detailListDto.ResponseStatus("报文获取失败",
					"报文获取失败","报文获取失败", resultFlag, checkResult);
			response.setResponseStatus(responseStatus);
			XStream xs = new XStream();
			xs.alias("Response", com.dsib.detailListDto.Response.class);
			xs.alias("ResponseStatus", com.dsib.detailListDto.ResponseStatus.class);
			responseXml = "<?xml version='1.0' encoding='GBK'?> \n"
					+ xs.toXML(response);
			System.out.println("加密前返回的报文======"+responseXml);
			//加密逻辑开始
			try {
				responseXml = aesUtil.Encrypt(responseXml);
			} catch (Exception e2) {
				e2.printStackTrace();
				saveLog(e2,responseXml);
			}
			//加密结束
			return responseXml;
		}
//		System.out.println("解密前收到的报文======"+requestXml);
		log.debug("解密前收到的报文======"+requestXml);
		requestXml = requestXml.replace(" ", "+");//服务器会转义+号为空格
		//解密逻辑开始
		try {
			requestXml = aesUtil.Decrpyt(requestXml);
		} catch (Exception e1) {
			e1.printStackTrace();
			resultFlag="N";
			checkResult="报文解密失败";
//			System.out.println("解密后收到的报文======"+requestXml);
			com.dsib.detailListDto.Response response = new com.dsib.detailListDto.Response();
			com.dsib.detailListDto.ResponseStatus responseStatus = new com.dsib.detailListDto.ResponseStatus("报文解密失败",
					"报文解密失败","报文解密失败", resultFlag, checkResult);
			response.setResponseStatus(responseStatus);
			XStream xs = new XStream();
			xs.alias("Response", com.dsib.detailListDto.Response.class);
			xs.alias("ResponseStatus", com.dsib.detailListDto.ResponseStatus.class);
			responseXml = "<?xml version='1.0' encoding='GBK'?> \n"
					+ xs.toXML(response);
			System.out.println("加密前返回的报文======"+responseXml);
			saveLog(e1,responseXml);
			//加密逻辑开始
			try {
				responseXml = aesUtil.Encrypt(responseXml);
			} catch (Exception e2) {
				e2.printStackTrace();
				saveLog(e2,responseXml);
			}
			//加密结束
			return responseXml;
		}
		//解密逻辑结束
		com.dsib.detailListDto.Request request = null;
		XStream stream = new XStream(new DomDriver());
		try {
		stream.alias("Request", com.dsib.detailListDto.Request.class);
		stream.alias("Main", com.dsib.detailListDto.Main.class);
		request = (com.dsib.detailListDto.Request) stream.fromXML(requestXml);
		} catch (Exception e) {
			e.printStackTrace();
			resultFlag="N";
			checkResult="报文格式错误";
//			System.out.println("解密后收到的报文======"+requestXml);
			com.dsib.detailListDto.Response response = new com.dsib.detailListDto.Response();
			com.dsib.detailListDto.ResponseStatus responseStatus = new com.dsib.detailListDto.ResponseStatus("报文解析失败",
					"报文解析失败","报文解析失败", resultFlag, checkResult);
			response.setResponseStatus(responseStatus);
			XStream xs = new XStream();
			xs.alias("Response", com.dsib.detailListDto.Response.class);
			xs.alias("ResponseStatus", com.dsib.detailListDto.ResponseStatus.class);
			responseXml = "<?xml version='1.0' encoding='GBK'?> \n"
					+ xs.toXML(response);
			System.out.println("加密前返回的报文======"+responseXml);
			saveLog(e,responseXml);
			//加密逻辑开始
			try {
				responseXml = aesUtil.Encrypt(responseXml);
			} catch (Exception e2) {
				e2.printStackTrace();
				saveLog(e2,responseXml);
			}
			//加密结束
			return responseXml;
		}
		//此处应有校验及入库操作
		checkResult = checkDetailListManager(request);
		resultFlag = "";
		if("".equals(checkResult)){//校验成功入库
			try {
				resultFlag = insertDetailListManager(request);
				checkResult = "成功";
			} catch (Exception e) {
				e.printStackTrace();
				resultFlag="N";
				checkResult="数据异常,入库失败请校验！";
//				System.out.println("解密后收到的报文======"+requestXml);
				com.dsib.detailListDto.Response response = new com.dsib.detailListDto.Response();
				com.dsib.detailListDto.ResponseStatus responseStatus = new com.dsib.detailListDto.ResponseStatus();
				if("1".equals(request.getMainList().get(0).getCheckType())){
					responseStatus = new com.dsib.detailListDto.ResponseStatus(request.getMainList().get(0).getPolicyNo(),
							"保单清单无报案号",String.valueOf(request.getMainList().size()),resultFlag, checkResult);
				}else{
					responseStatus = new com.dsib.detailListDto.ResponseStatus(request.getMainList().get(0).getPolicyNo(),
							request.getMainList().get(0).getReportNo(),String.valueOf(request.getMainList().size()), resultFlag, checkResult);
				}
				response.setResponseStatus(responseStatus);
				XStream xs = new XStream();
				xs.alias("Response", com.dsib.detailListDto.Response.class);
				xs.alias("ResponseStatus", com.dsib.detailListDto.ResponseStatus.class);
				responseXml = "<?xml version='1.0' encoding='GBK'?> \n"
						+ xs.toXML(response);
				System.out.println("加密前返回的报文======"+responseXml);
				saveLog(e,responseXml);
				//加密逻辑开始
				try {
					responseXml = aesUtil.Encrypt(responseXml);
				} catch (Exception e2) {
					e2.printStackTrace();
					saveLog(e2,responseXml);
				}
				//加密结束
				return responseXml;
			}
		}else{//校验失败返回错误信息
			resultFlag = "N";
		}
		WriteFileToFile write = new WriteFileToFile();//记录收到的报文
//		System.out.println("解密后收到的报文======"+requestXml);
		log.debug("解密后收到的报文======"+requestXml);
		write.write(requestXml, request.getMainList().get(0).getPolicyNo()+"DetailList");
		com.dsib.detailListDto.Response response = new com.dsib.detailListDto.Response();
		com.dsib.detailListDto.ResponseStatus responseStatus = new com.dsib.detailListDto.ResponseStatus();
		if("1".equals(request.getMainList().get(0).getCheckType())){
			responseStatus = new com.dsib.detailListDto.ResponseStatus(request.getMainList().get(0).getPolicyNo(),
					"保单清单无报案号",String.valueOf(request.getMainList().size()),resultFlag, checkResult);
		}else{
			responseStatus = new com.dsib.detailListDto.ResponseStatus(request.getMainList().get(0).getPolicyNo(),
					request.getMainList().get(0).getReportNo(),String.valueOf(request.getMainList().size()), resultFlag, checkResult);
		}
		response.setResponseStatus(responseStatus);
		XStream xs = new XStream();
		xs.alias("Response", com.dsib.detailListDto.Response.class);
		xs.alias("ResponseStatus", com.dsib.detailListDto.ResponseStatus.class);
		responseXml = "<?xml version='1.0' encoding='GBK'?> \n"
				+ xs.toXML(response);
		write.write(responseXml, request.getMainList().get(0).getPolicyNo()+"DetailList");//记录返回的报文
		System.out.println("加密前返回的报文======"+responseXml);
		log.debug("加密前返回的报文======"+responseXml);
		//加密逻辑开始
		try {
			responseXml = aesUtil.Encrypt(responseXml);
		} catch (Exception e) {
			e.printStackTrace();
			saveLog(e,responseXml);
		}
		//加密结束
		System.out.println("加密后返回的报文======"+responseXml);
		log.debug("加密后返回的报文======"+responseXml);
		return responseXml;
	}
	
	/**
	 *保单信息校验 
	 * @param request
	 * @return
	 */
	private String checkPolicyManager(Request request){
		if("".equals(request.getMain().getPolicyNo())||request.getMain().getPolicyNo()==null){
			return "保单号不能为空";
		}else{
			if(request.getMain().getPolicyNo().length()>28){
				return "保单号长度过长";
			}
		}
		if("".equals(request.getMain().getInsuranceType())||request.getMain().getInsuranceType()==null){
			return "保险类型不能为空";
		}else{
			if(request.getMain().getInsuranceType().length()>10){
				return "保险类型长度过长";
			}
		}
		if("".equals(request.getMain().getRiskCode())||request.getMain().getRiskCode()==null){
			return "险种代码不能为空";
		}else{
			if(request.getMain().getRiskCode().length()>10){
				return "险种代码长度过长";
			}
		}
		if("".equals(request.getMain().getPolicyFlag())||request.getMain().getPolicyFlag()==null){
			return "是否政策性保险不能为空";
		}else{
			if(request.getMain().getPolicyFlag().length()>2){
				return "是否政策性保险长度过长";
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if("".equals(request.getMain().getStartDate())||request.getMain().getStartDate()==null){
			return "起保日期不能为空";
		}else{
			try {
				@SuppressWarnings("unused")
				Date date = sdf.parse(request.getMain().getStartDate());
			} catch (Exception e) {
				return "起保日期格式不正确";
			}
		}
		if("".equals(request.getMain().getEndDate())||request.getMain().getEndDate()==null){
			return "终保日期不能为空";
		}else{
			try {
				@SuppressWarnings("unused")
				Date date = sdf.parse(request.getMain().getEndDate());
			} catch (Exception e) {
				return "终保日期格式不正确";
			}
		}
		if("".equals(request.getMain().getArgueSolution())||request.getMain().getArgueSolution()==null){
			return "争议解决方式不能为空";
		}else{
			if("2".equals(request.getMain().getArbitBoardName())){
				return "仲裁委员会名称不能为空";
			}
			if(request.getMain().getArgueSolution().length()>2){
				return "争议解决方式长度过长";
			}
		}
		Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$"); 
		if("".equals(request.getMain().getInsuredCount())||request.getMain().getInsuredCount()==null){
			return "投保人数不能为空";
		}else{
			Matcher isNum = pattern.matcher(request.getMain().getInsuredCount());
			 if(!isNum.matches()){
				 return "投保人数必须为数字";
			 }
			 if(request.getMain().getInsuredCount().length()>28){
				 return "投保人数长度过长";
			 }
		}
		if("".equals(request.getMain().getInsuredQuantity())||request.getMain().getInsuredQuantity()==null){
			return "投保数量不能为空";
		}else{
			Matcher isNum = pattern.matcher(request.getMain().getInsuredQuantity());
			if(!isNum.matches()){
				return "投保数量必须为数字";
			}
			if(request.getMain().getInsuredQuantity().length()>28){
				return "投保数量长度过长";
			}
		}
		if("".equals(request.getMain().getSumAmount())||request.getMain().getSumAmount()==null){
			return "总保额不能为空";
		}else{
			Matcher isNum = pattern.matcher(request.getMain().getSumAmount());
			if(!isNum.matches()){
				return "总保额必须为数字";
			}
			if(request.getMain().getSumAmount().length()>28){
				return "总保额长度过长";
			}
		}
		if("".equals(request.getMain().getSumPremium())||request.getMain().getSumPremium()==null){
			return "总保费不能为空";
		}else{
			Matcher isNum = pattern.matcher(request.getMain().getSumPremium());
			if(!isNum.matches()){
				return "总保费必须为数字";
			}
			if(request.getMain().getSumPremium().length()>28){
				return "总保费长度过长";
			}
		}
		if("".equals(request.getMain().getPolicyType())||request.getMain().getPolicyType()==null){
			return "保单类型代码不能为空";
		}else{
			if(request.getMain().getPolicyType().length()>2){
				return "保单类型代码长度过长";
			}
		}
		if("".equals(request.getMain().getSignDate())||request.getMain().getSignDate()==null){
			return "出单日期不能为空";
		}else{
			try {
				@SuppressWarnings("unused")
				Date date = sdf.parse(request.getMain().getSignDate());
			} catch (Exception e) {
				return "出单日期格式不正确";
			}
		}
		if(!"".equals(request.getMain().getSpecialProvisions())&&request.getMain().getSpecialProvisions()!=null){
			if(request.getMain().getSpecialProvisions().length()>2000){
				return "特别约定信息长度过长";
			}
		}
		if("".equals(request.getMain().getInsurerCode())||request.getMain().getInsurerCode()==null){
			return "保险公司代码不能为空";
		}else{
			if(request.getMain().getInsurerCode().length()>10){
				return "保险公司代码长度过长";
			}
		}
		if("".equals(request.getMain().getCentralAllowance())||request.getMain().getCentralAllowance()==null){
			return "中央财政补贴额不能为空";
		}else{
			Matcher isNum = pattern.matcher(request.getMain().getCentralAllowance());
			if(!isNum.matches()){
				return "中央财政补贴额必须为数字";
			}
			if(request.getMain().getCentralAllowance().length()>28){
				return "中央财政补贴额长度过长";
			}
		}
		if("".equals(request.getMain().getPersonAllowance())||request.getMain().getPersonAllowance()==null){
			return "省级财政补贴额不能为空";
		}else{
			Matcher isNum = pattern.matcher(request.getMain().getPersonAllowance());
			if(!isNum.matches()){
				return "省级财政补贴额必须为数字";
			}
			if(request.getMain().getPersonAllowance().length()>28){
				return "省级财政补贴额长度过长";
			}
		}
		if("".equals(request.getMain().getCityAllowance())||request.getMain().getCityAllowance()==null){
			return "地市财政补贴额不能为空";
		}else{
			Matcher isNum = pattern.matcher(request.getMain().getCityAllowance());
			if(!isNum.matches()){
				return "地市财政补贴额必须为数字";
			}
			if(request.getMain().getCityAllowance().length()>28){
				return "地市财政补贴额长度过长";
			}
		}
		if("".equals(request.getMain().getCountyAllowance())||request.getMain().getCountyAllowance()==null){
			return "县区财政补贴额不能为空";
		}else{
			Matcher isNum = pattern.matcher(request.getMain().getCountyAllowance());
			if(!isNum.matches()){
				return "县区财政补贴额必须为数字";
			}
			if(request.getMain().getCountyAllowance().length()>28){
				return "县区财政补贴额长度过长";
			}
		}
		if("".equals(request.getMain().getPersonAllowance())||request.getMain().getPersonAllowance()==null){
			return "用户自交额不能为空";
		}else{
			Matcher isNum = pattern.matcher(request.getMain().getPersonAllowance());
			if(!isNum.matches()){
				return "用户自交额必须为数字";
			}
			if(request.getMain().getPersonAllowance().length()>28){
				return "用户自交额长度过长";
			}
		}
		if("".equals(request.getMain().getOtherAllowance())||request.getMain().getOtherAllowance()==null){
			return "其他额不能为空";
		}else{
			Matcher isNum = pattern.matcher(request.getMain().getOtherAllowance());
			if(!isNum.matches()){
				return "其他额必须为数字";
			}
			if(request.getMain().getOtherAllowance().length()>28){
				return "其他额长度过长";
			}
		}
		if("".equals(request.getMain().getProvince())||request.getMain().getProvince()==null){
			return "省不能为空";
		}else{
			Matcher isNum = pattern.matcher(request.getMain().getProvince());
			if(!isNum.matches()){
				return "省代码格式错误";
			}
			if(request.getMain().getProvince().length()>6){
				return "省长度过长";
			}
		}
		if("".equals(request.getMain().getCity())||request.getMain().getCity()==null){
			return "市不能为空";
		}else{
			Matcher isNum = pattern.matcher(request.getMain().getCity());
			if(!isNum.matches()){
				return "市代码格式错误";
			}
			if(request.getMain().getCity().length()>6){
				return "市长度过长";
			}
		}
		if("".equals(request.getMain().getCounty())||request.getMain().getCounty()==null){
			return "区/县不能为空";
		}else{
			Matcher isNum = pattern.matcher(request.getMain().getCounty());
			if(!isNum.matches()){
				return "区/县代码格式错误";
			}
			if(request.getMain().getCounty().length()>6){
				return "区/县长度过长";
			}
		}
		if("".equals(request.getMain().getTown())||request.getMain().getTown()==null){
//			return "乡镇不能为空";
		}else{
			Matcher isNum = pattern.matcher(request.getMain().getTown());
			if(!isNum.matches()){
				return "乡镇代码格式错误";
			}
			if(request.getMain().getTown().length()>28){
				return "乡镇长度过长";
			}
		}
		if(request.getOrganizer()!=null){
			
			if("".equals(request.getOrganizer().getOrganizerName())||request.getOrganizer().getOrganizerName()==null){
				return "投保组织者名称不能为空";
			}else{
				if(request.getOrganizer().getOrganizerName().length()>100){
					return "投保组织者名称长度过长";
				}
			}
			if(!"".equals(request.getOrganizer().getOrganizerAddress())&&request.getOrganizer().getOrganizerAddress()!=null){
				if(request.getOrganizer().getOrganizerAddress().length()>200){
					return "投保组织者地址长度过长";
				}
			}
			if("".equals(request.getOrganizer().getIdentifyType())||request.getOrganizer().getIdentifyType()==null){
				return "投保组织者证件类型不能为空";
			}else{
				Matcher isNum = pattern.matcher(request.getOrganizer().getIdentifyType());
				if(!isNum.matches()){
					return "投保组织者证件类型格式错误";
				}
				if(request.getOrganizer().getIdentifyType().length()>2){
					return "投保组织者证件类型长度过长";
				}
			}
			if("".equals(request.getOrganizer().getIdentifyNumber())||request.getOrganizer().getIdentifyNumber()==null){
				return "投保组织者证件号码不能为空";
			}else{
//				Matcher isNum = pattern.matcher(request.getOrganizer().getIdentifyNumber());
//				if(!isNum.matches()){
//					return "投保组织者证件号码格式错误";
//				}
				if(request.getOrganizer().getIdentifyNumber().length()>28){
					return "投保组织者证件号码长度过长";
				}
			}
			if(!"".equals(request.getOrganizer().getPostCode())&&request.getOrganizer().getPostCode()!=null){
				if(request.getOrganizer().getPostCode().length()>6){
					return "投保组织者邮编长度过长";
				}
			}
			if(!"".equals(request.getOrganizer().getContactName())&&request.getOrganizer().getContactName()!=null){
				if(request.getOrganizer().getContactName().length()>100){
					return "投保组织者联系人姓名长度过长";
				}
			}
			if(!"".equals(request.getOrganizer().getPhoneNumber())&&request.getOrganizer().getPhoneNumber()!=null){
				if(request.getOrganizer().getPhoneNumber().length()>15){
					return "投保组织者联系人联系电话长度过长";
				}
			}
		}
		if("".equals(request.getApplicant().getAppliName())||request.getApplicant().getAppliName()==null){
			return "投保人姓名不能为空";
		}else{
			if(request.getApplicant().getAppliName().length()>100){
				return "投保人姓名长度过长";
			}
		}
		if(!"".equals(request.getApplicant().getAppliAddress())&&request.getApplicant().getAppliAddress()!=null){
			if(request.getApplicant().getAppliAddress().length()>200){
				return "投保人联系地址长度过长";
			}
		}
		if("".equals(request.getApplicant().getIdentifyType())||request.getApplicant().getIdentifyType()==null){
			return "投保人证件类型不能为空";
		}else{
			Matcher isNum = pattern.matcher(request.getApplicant().getIdentifyType());
			if(!isNum.matches()){
				return "投保人证件类型格式错误";
			}
			if(request.getApplicant().getIdentifyType().length()>2){
				return "投保人证件类型长度过长";
			}
		}
		if("".equals(request.getApplicant().getIdentifyNumber())||request.getApplicant().getIdentifyNumber()==null){
			return "投保人证件号码不能为空";
		}else{
//			Matcher isNum = pattern.matcher(request.getApplicant().getIdentifyNumber());
//			if(!isNum.matches()){
//				return "投保人证件号码格式错误";
//			}
			if(request.getApplicant().getIdentifyNumber().length()>28){
				return "投保人证件号码长度过长";
			}
		}
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		if(!"".equals(request.getApplicant().getBirthday())&&request.getApplicant().getBirthday()!=null){
			try {
				@SuppressWarnings("unused")
				Date date = sdf2.parse(request.getApplicant().getBirthday());
			} catch (Exception e) {
				return "投保人出生日期格式不正确";
			}
		}
		if(!"".equals(request.getApplicant().getAge())&&request.getApplicant().getAge()!=null){
			Matcher isNum = pattern.matcher(request.getApplicant().getAge());
			if(!isNum.matches()){
				return "投保人年龄格式错误";
			}
			if(request.getApplicant().getAge().length()>3){
				return "投保人年龄长度过长";
			}
		}
		if(!"".equals(request.getApplicant().getSex())&&request.getApplicant().getSex()!=null){
			Matcher isNum = pattern.matcher(request.getApplicant().getSex());
			if(!isNum.matches()){
				return "投保人性别格式错误";
			}
			if(request.getApplicant().getSex().length()>2){
				return "投保人性别长度过长";
			}
		}
		if(!"".equals(request.getApplicant().getInsuredIdentity())&&request.getApplicant().getInsuredIdentity()!=null){
			Matcher isNum = pattern.matcher(request.getApplicant().getInsuredIdentity());
			if(!isNum.matches()){
				return "与被保险人关系格式错误";
			}
			if(request.getApplicant().getInsuredIdentity().length()>10){
				return "与被保险人关系长度过长";
			}
		}
		if(!"".equals(request.getApplicant().getPostCode())&&request.getApplicant().getPostCode()!=null){
			Matcher isNum = pattern.matcher(request.getApplicant().getPostCode());
			if(!isNum.matches()){
				return "投保人邮编格式错误";
			}
			if(request.getApplicant().getPostCode().length()>30){
				return "投保人邮编长度过长";
			}
		}
		if(!"".equals(request.getApplicant().getPhoneNumber())&&request.getApplicant().getPhoneNumber()!=null){
			if(request.getApplicant().getPhoneNumber().length()>15){
				return "投保人联系电话长度过长";
			}
		}
		if(!"".equals(request.getApplicant().getInsuredType())&&request.getApplicant().getInsuredType()!=null){
			Matcher isNum = pattern.matcher(request.getApplicant().getInsuredType());
			if(!isNum.matches()){
				return "关系人类型格式错误";
			}
			if(request.getApplicant().getInsuredType().length()>2){
				return "关系人类型长度过长";
			}
		}else{
			return "关系人类型不能为空";
		}
		if(request.getInsured()!=null){
			if("".equals(request.getInsured().getInsuredCode())||request.getInsured().getInsuredCode()==null){
				return "被保险人信息序号不能为空";
			}else{
				if(request.getInsured().getInsuredCode().length()>28){
					return "被保险人信息序号长度过长";
				}
			}
			if("".equals(request.getInsured().getInsuredName())||request.getInsured().getInsuredName()==null){
				return "被保险人信息被保险人姓名不能为空";
			}else{
				if(request.getInsured().getInsuredName().length()>200){
					return "被保险人信息被保险人姓名长度过长";
				}
			}
			if(!"".equals(request.getInsured().getAppliIdentity())&&request.getInsured().getAppliIdentity()!=null){
				Matcher isNum = pattern.matcher(request.getInsured().getAppliIdentity());
				if(!isNum.matches()){
					return "被保险人信息与投保人关系格式错误";
				}
				if(request.getInsured().getAppliIdentity().length()>4){
					return "被保险人信息与投保人关系长度过长";
				}
			}
			if(!"".equals(request.getInsured().getInsuredAddress())&&request.getInsured().getInsuredAddress()!=null){
				if(request.getInsured().getInsuredAddress().length()>100){
					return "被保险人信息与投保人关系长度过长";
				}
			}
			if(!"".equals(request.getInsured().getIdentifyType())&&request.getInsured().getIdentifyType()!=null){
				Matcher isNum = pattern.matcher(request.getInsured().getIdentifyType());
				if(!isNum.matches()){
					return "被保险人信息被保险人证件类型格式错误";
				}
				if(request.getInsured().getIdentifyType().length()>2){
					return "被保险人信息被保险人证件类型长度过长";
				}
			}else{
				return "被保险人信息被保险人证件类型不能为空";
			}
			if(!"".equals(request.getInsured().getIdentifyNumber())&&request.getInsured().getIdentifyNumber()!=null){
//				Matcher isNum = pattern.matcher(request.getInsured().getIdentifyNumber());
//				if(!isNum.matches()){
//					return "被保险人信息被保险人证件号码格式错误";
//				}
				if(request.getInsured().getIdentifyNumber().length()>28){
					return "被保险人信息被保险人证件号码长度过长";
				}
			}else{
				return "被保险人信息被保险人证件号码不能为空";
			}
			if(!"".equals(request.getInsured().getBirthday())&&request.getInsured().getBirthday()!=null){
				try {
					@SuppressWarnings("unused")
					Date date = sdf2.parse(request.getInsured().getBirthday());
				} catch (Exception e) {
					return "被保险人信息被保险人出生日期格式不正确";
				}
			}
			if(!"".equals(request.getInsured().getAge())&&request.getInsured().getAge()!=null){
				Matcher isNum = pattern.matcher(request.getInsured().getAge());
				if(!isNum.matches()){
					return "被保险人信息被保险人年龄格式错误";
				}
				if(request.getInsured().getAge().length()>3){
					return "被保险人信息被保险人年龄长度过长";
				}
			}
			if(!"".equals(request.getInsured().getSex())&&request.getInsured().getSex()!=null){
				Matcher isNum = pattern.matcher(request.getInsured().getSex());
				if(!isNum.matches()){
					return "被保险人信息被保险人性别格式错误";
				}
				if(request.getInsured().getSex().length()>2){
					return "被保险人信息被保险人性别长度过长";
				}
			}
			if(!"".equals(request.getInsured().getPostCode())&&request.getInsured().getPostCode()!=null){
				Matcher isNum = pattern.matcher(request.getInsured().getPostCode());
				if(!isNum.matches()){
					return "被保险人信息被保险人邮编格式错误";
				}
				if(request.getInsured().getPostCode().length()>6){
					return "被保险人信息被保险人邮编长度过长";
				}
			}
			if(!"".equals(request.getInsured().getPhoneNumber())&&request.getInsured().getPhoneNumber()!=null){
//				Matcher isNum = pattern.matcher(request.getInsured().getPhoneNumber());
//				if(!isNum.matches()){
//					return "被保险人信息被保险人联系电话格式错误";
//				}
				if(request.getInsured().getPhoneNumber().length()>15){
					return "被保险人信息被保险人联系电话长度过长";
				}
			}
			if(!"".equals(request.getInsured().getInsuredType())&&request.getInsured().getInsuredType()!=null){
				Matcher isNum = pattern.matcher(request.getInsured().getInsuredType());
				if(!isNum.matches()){
					return "被保险人信息关系人类型格式错误";
				}
				if(request.getInsured().getInsuredType().length()>2){
					return "被保险人信息关系人类型长度过长";
				}
			}else{
				return "被保险人信息关系人类型不能为空";
			}
		}
		List<Insurance> Insurances = request.getInsuranceList();
		if(Insurances==null&&!"PAIC".equals(request.getMain().getInsurerCode())){
			return "投保清单不能为空!";
		}
		if(Insurances!=null){
			for(int i=0;i<Insurances.size();i++){
				Insurance insurance = Insurances.get(i);
				if(!"".equals(insurance.getInsuredCode())&&insurance.getInsuredCode()!=null){
					Matcher isNum = pattern.matcher(insurance.getInsuredCode());
					if(!isNum.matches()){
						return "投保清单信息第"+(i+1)+"条序号格式错误";
					}
					for(int s=0;s<i;s++){
						if(Insurances.get(s).getInsuredCode().equals(insurance.getInsuredCode())){
							return "投保清单信息第"+(i+1)+"条被保险人序号重复出现";
						}
					}
					if(insurance.getInsuredCode().length()>28){
						return "投保清单信息第"+(i+1)+"条序号长度过长";
					}
				}else{
					return "投保清单信息第"+(i+1)+"条序号不能为空";
				}
				if(!"".equals(insurance.getInsuredName())&&insurance.getInsuredName()!=null){
					if(insurance.getInsuredName().length()>200){
						return "投保清单信息第"+(i+1)+"条被保险人姓名长度过长";
					}
				}else{
					return "投保清单信息第"+(i+1)+"条被保险人姓名不能为空";
				}
				if(!"".equals(insurance.getInsuredAddress())&&insurance.getInsuredAddress()!=null){
					if(insurance.getInsuredAddress().length()>100){
						return "投保清单信息第"+(i+1)+"条被保险人联系地址长度过长";
					}
				}
				if(!"".equals(insurance.getPhoneNumber())&&insurance.getPhoneNumber()!=null){
//					Matcher isNum = pattern.matcher(insurance.getPhoneNumber());
//					if(!isNum.matches()){
//						return "投保清单信息第"+(i+1)+"条被保险人联系电话格式错误";
//					}
					if(insurance.getPhoneNumber().length()>15){
						return "投保清单信息第"+(i+1)+"条被保险人联系电话长度过长";
					}
				}
				if(!"".equals(insurance.getIdentifyType())&&insurance.getIdentifyType()!=null){
					Matcher isNum = pattern.matcher(insurance.getIdentifyType());
					if(!isNum.matches()){
						return "投保清单信息第"+(i+1)+"条被保险人证件类型格式错误";
					}
					if(insurance.getIdentifyType().length()>2){
						return "投保清单信息第"+(i+1)+"条被保险人证件类型长度过长";
					}
				}else{
					return "投保清单信息第"+(i+1)+"条被保险人证件类型不能为空";
				}
				if(!"".equals(insurance.getIdentifyNumber())&&insurance.getIdentifyNumber()!=null){
//					for(int s=0;s<i;s++){
//						if(Insurances.get(s).getIdentifyNumber().equals(insurance.getIdentifyNumber())){
//							return "投保清单信息第"+(i+1)+"条被保险人证件号码重复出现";
//						}
//					}
					if(insurance.getIdentifyNumber().length()>28){
						return "投保清单信息第"+(i+1)+"条被保险人证件号码长度过长";
					}
				}else{
					return "投保清单信息第"+(i+1)+"条被保险人证件号码不能为空";
				}
				if(!"".equals(insurance.getInsuredQuantity())&&insurance.getInsuredQuantity()!=null){
					Matcher isNum = pattern.matcher(insurance.getInsuredQuantity());
					if(!isNum.matches()){
						return "投保清单信息第"+(i+1)+"条投保数量格式错误";
					}
					if(insurance.getInsuredQuantity().length()>28){
						return "投保清单信息第"+(i+1)+"条投保数量长度过长";
					}
				}else{
					return "投保清单信息第"+(i+1)+"条投保数量不能为空";
				}
				if(!"".equals(insurance.getFarmerType())&&insurance.getFarmerType()!=null){
					Matcher isNum = pattern.matcher(insurance.getFarmerType());
					if(!isNum.matches()){
						return "投保清单信息第"+(i+1)+"条农户类型格式错误";
					}
					if(insurance.getFarmerType().length()>2){
						return "投保清单信息第"+(i+1)+"条农户类型长度过长";
					}
				}else{
					return "投保清单信息第"+(i+1)+"条农户类型不能为空";
				}
				if(!"".equals(insurance.getIsPoor())&&insurance.getIsPoor()!=null){
					Matcher isNum = pattern.matcher(insurance.getIsPoor());
					if(!isNum.matches()){
						return "投保清单信息第"+(i+1)+"条是否建档立卡贫苦户格式错误";
					}
					if(insurance.getIsPoor().length()>2){
						return "投保清单信息第"+(i+1)+"条是否建档立卡贫苦户长度过长";
					}
				}else{
					return "投保清单信息第"+(i+1)+"条是否建档立卡贫苦户不能为空";
				}
				if(!"".equals(insurance.getBank())&&insurance.getBank()!=null){
					if(insurance.getBank().length()>28){
						return "投保清单信息第"+(i+1)+"条一卡通开户行长度过长";
					}
				}
				if(!"".equals(insurance.getCardNo())&&insurance.getCardNo()!=null){
					Matcher isNum = pattern.matcher(insurance.getCardNo());
					if(!isNum.matches()){
						return "投保清单信息第"+(i+1)+"条一卡通账号格式错误";
					}
					if(insurance.getCardNo().length()>28){
						return "投保清单信息第"+(i+1)+"条一卡通账号长度过长";
					}
				}
				if(!"".equals(insurance.getAmount())&&insurance.getAmount()!=null){
					Matcher isNum = pattern.matcher(insurance.getAmount());
					if(!isNum.matches()){
						return "投保清单信息第"+(i+1)+"条保额格式错误";
					}
					if(insurance.getAmount().length()>28){
						return "投保清单信息第"+(i+1)+"条保额长度过长";
					}
				}else{
					return "投保清单信息第"+(i+1)+"条保额不能为空";
				}
				if(!"".equals(insurance.getPremium())&&insurance.getPremium()!=null){
					Matcher isNum = pattern.matcher(insurance.getPremium());
					if(!isNum.matches()){
						return "投保清单信息第"+(i+1)+"条保费格式错误";
					}
					if(insurance.getPremium().length()>28){
						return "投保清单信息第"+(i+1)+"条保费长度过长";
					}
				}else{
					return "投保清单信息第"+(i+1)+"条保费不能为空";
				}
				if(!"".equals(insurance.getPremium())&&insurance.getPremium()!=null){
					Matcher isNum = pattern.matcher(insurance.getPremium());
					if(!isNum.matches()){
						return "投保清单信息第"+(i+1)+"条保费格式错误";
					}
					if(insurance.getPremium().length()>28){
						return "投保清单信息第"+(i+1)+"条保费长度过长";
					}
				}else{
					return "投保清单信息第"+(i+1)+"条保费不能为空";
				}
				if(!"".equals(insurance.getCentralAllowance())&&insurance.getCentralAllowance()!=null){
					Matcher isNum = pattern.matcher(insurance.getCentralAllowance());
					if(!isNum.matches()){
						return "投保清单信息第"+(i+1)+"条中央财政补贴额格式错误";
					}
					if(insurance.getCentralAllowance().length()>28){
						return "投保清单信息第"+(i+1)+"条中央财政补贴额长度过长";
					}
				}else{
					return "投保清单信息第"+(i+1)+"条中央财政补贴额不能为空";
				}
				if(!"".equals(insurance.getProvinceAllowance())&&insurance.getProvinceAllowance()!=null){
					Matcher isNum = pattern.matcher(insurance.getProvinceAllowance());
					if(!isNum.matches()){
						return "投保清单信息第"+(i+1)+"条省级财政补贴额格式错误";
					}
					if(insurance.getProvinceAllowance().length()>28){
						return "投保清单信息第"+(i+1)+"条省级财政补贴额长度过长";
					}
				}else{
					return "投保清单信息第"+(i+1)+"条省级财政补贴额不能为空";
				}
				if(!"".equals(insurance.getCityAllowance())&&insurance.getCityAllowance()!=null){
					Matcher isNum = pattern.matcher(insurance.getCityAllowance());
					if(!isNum.matches()){
						return "投保清单信息第"+(i+1)+"条地市财政补贴额格式错误";
					}
					if(insurance.getCityAllowance().length()>28){
						return "投保清单信息第"+(i+1)+"条地市财政补贴额长度过长";
					}
				}else{
					return "投保清单信息第"+(i+1)+"条地市财政补贴额不能为空";
				}
				if(!"".equals(insurance.getCityAllowance())&&insurance.getCityAllowance()!=null){
					Matcher isNum = pattern.matcher(insurance.getCityAllowance());
					if(!isNum.matches()){
						return "投保清单信息第"+(i+1)+"条县区财政补贴额格式错误";
					}
					if(insurance.getCityAllowance().length()>28){
						return "投保清单信息第"+(i+1)+"条县区财政补贴额长度过长";
					}
				}else{
					return "投保清单信息第"+(i+1)+"条县区财政补贴额不能为空";
				}
				if(!"".equals(insurance.getPersonAllowance())&&insurance.getPersonAllowance()!=null){
					Matcher isNum = pattern.matcher(insurance.getPersonAllowance());
					if(!isNum.matches()){
						return "投保清单信息第"+(i+1)+"条用户自交格式错误";
					}
					if(insurance.getPersonAllowance().length()>28){
						return "投保清单信息第"+(i+1)+"条用户自交长度过长";
					}
				}else{
					return "投保清单信息第"+(i+1)+"条用户自交不能为空";
				}
				if(!"".equals(insurance.getOhterAllowance())&&insurance.getOhterAllowance()!=null){
					Matcher isNum = pattern.matcher(insurance.getOhterAllowance());
					if(!isNum.matches()){
						return "投保清单信息第"+(i+1)+"条其他格式错误";
					}
					if(insurance.getOhterAllowance().length()>28){
						return "投保清单信息第"+(i+1)+"条其他长度过长";
					}
				}else{
					return "投保清单信息第"+(i+1)+"条其他不能为空";
				}
			}
		}
		List<ItemKind> itemKinds = request.getItemKinds();
		if(itemKinds!=null){
			for(int j=0;j<itemKinds.size();j++){
				ItemKind itemKind = itemKinds.get(j);
				if(!"".equals(itemKind.getItemKindNo())&&itemKind.getItemKindNo()!=null){
					Matcher isNum = pattern.matcher(itemKind.getItemKindNo());
					if(!isNum.matches()){
						return "险别信息第"+(j+1)+"条险别序号格式错误";
					}
					for(int s=0;s<j;s++){
						if(itemKinds.get(s).getItemKindNo().equals(itemKind.getItemKindNo())){
							return "险别信息第"+(j+1)+"条险别序号重复出现";
						}
					}
					if(itemKind.getItemKindNo().length()>28){
						return "险别信息第"+(j+1)+"条险别序号长度过长";
					}
				}else{
					return "险别信息第"+(j+1)+"条险别序号不能为空";
				}
				if(!"".equals(itemKind.getItemType())&&itemKind.getItemType()!=null){
					if(itemKind.getItemType().length()>8){
						return "险别信息第"+(j+1)+"条保险标的项目长度过长";
					}
					if("Z001".equals(itemKind.getItemType())){//为其他则必传
						if(itemKind.getItemTypeName()==null||"".equals(itemKind.getItemTypeName())){
							return "险别信息第"+(j+1)+"条保险标的具体项目不能为空";
						}
					}
				}else{
					return "险别信息第"+(j+1)+"条保险标的项目不能为空";
				}
				if(!"".equals(itemKind.getKindCode())&&itemKind.getKindCode()!=null){
					if(itemKind.getKindCode().length()>8){
						return "险别信息第"+(j+1)+"条险别代码长度过长";
					}
				}
				if(!"".equals(itemKind.getKindName())&&itemKind.getKindName()!=null){
					if(itemKind.getKindName().length()>28){
						return "险别信息第"+(j+1)+"条险别名称长度过长";
					}
				}
				if(!"".equals(itemKind.getUnit())&&itemKind.getUnit()!=null){
					Matcher isNum = pattern.matcher(itemKind.getUnit());
					if(!isNum.matches()){
						return "险别信息第"+(j+1)+"条单位格式错误";
					}
					if(itemKind.getUnit().length()>2){
						return "险别信息第"+(j+1)+"条单位长度过长";
					}
				}
				if(!"".equals(itemKind.getQuantity())&&itemKind.getQuantity()!=null){
					Matcher isNum = pattern.matcher(itemKind.getQuantity());
					if(!isNum.matches()){
						return "险别信息第"+(j+1)+"条保险数量格式错误";
					}
					if(itemKind.getQuantity().length()>28){
						return "险别信息第"+(j+1)+"条保险数量长度过长";
					}
				}else{
					return "险别信息第"+(j+1)+"条保险数量不能为空";
				}
				if(!"".equals(itemKind.getUnitAmount())&&itemKind.getUnitAmount()!=null){
					Matcher isNum = pattern.matcher(itemKind.getUnitAmount());
					if(!isNum.matches()){
						return "险别信息第"+(j+1)+"条单位保险金额格式错误";
					}
					if(itemKind.getUnitAmount().length()>28){
						return "险别信息第"+(j+1)+"条单位保险金额长度过长";
					}
				}else{
					return "险别信息第"+(j+1)+"条单位保险金额不能为空";
				}
				if(!"".equals(itemKind.getAmount())&&itemKind.getAmount()!=null){
					Matcher isNum = pattern.matcher(itemKind.getAmount());
					if(!isNum.matches()){
						return "险别信息第"+(j+1)+"条保险金额格式错误";
					}
					if(itemKind.getAmount().length()>28){
						return "险别信息第"+(j+1)+"条保险金额长度过长";
					}
				}else{
					return "险别信息第"+(j+1)+"条保险金额不能为空";
				}
				if(!"".equals(itemKind.getInsuranceRates())&&itemKind.getInsuranceRates()!=null){
					Matcher isNum = pattern.matcher(itemKind.getInsuranceRates());
					if(!isNum.matches()){
						return "险别信息第"+(j+1)+"条保险金额格式错误";
					}
					if(itemKind.getInsuranceRates().length()>28){
						return "险别信息第"+(j+1)+"条保险金额长度过长";
					}
				}else{
					return "险别信息第"+(j+1)+"条保险金额不能为空";
				}
				if(!"".equals(itemKind.getPremium())&&itemKind.getPremium()!=null){
					Matcher isNum = pattern.matcher(itemKind.getPremium());
					if(!isNum.matches()){
						return "险别信息第"+(j+1)+"条保险费格式错误";
					}
					if(itemKind.getPremium().length()>28){
						return "险别信息第"+(j+1)+"条保险费长度过长";
					}
				}else{
					return "险别信息第"+(j+1)+"条保险费不能为空";
				}
				if(!"".equals(itemKind.getFlag())&&itemKind.getFlag()!=null){
					Matcher isNum = pattern.matcher(itemKind.getFlag());
					if(!isNum.matches()){
						return "险别信息第"+(j+1)+"条标志位格式错误";
					}
					if(itemKind.getFlag().length()>2){
						return "险别信息第"+(j+1)+"条标志位长度过长";
					}
				}else{
					return "险别信息第"+(j+1)+"条标志位不能为空";
				}
		}
		}
		return "";
	}
	
	/**
	 *理赔信息校验 
	 * @param request
	 * @return
	 */
	private String checkClaimManager(com.dsib.claimDto.Request request){
		if(request.getMain().getPolicyNo()!=null&&!"".equals(request.getMain().getPolicyNo())){
			if(request.getMain().getPolicyNo().length()>28){
				return "保单号长度过长";
			}
		}else{
			return "保单号不能为空";
		}
		if(request.getMain().getReportNo()!=null&&!"".equals(request.getMain().getReportNo())){
			if(request.getMain().getReportNo().length()>28){
				return "报案号长度过长";
			}
		}else{
			return "报案号不能为空";
		}
		if(request.getMain().getCaseNo()!=null&&!"".equals(request.getMain().getCaseNo())){
			if(request.getMain().getCaseNo().length()>28){
				return "结案号长度过长";
			}
		}
		if(request.getMain().getClaimsNo()!=null&&!"".equals(request.getMain().getClaimsNo())){
			if(request.getMain().getClaimsNo().length()>28){
				return "赔案号长度过长";
			}
		}
		if(request.getMain().getInsuranceType()!=null&&!"".equals(request.getMain().getInsuranceType())){
			if(request.getMain().getInsuranceType().length()>2){
				return "保险类型长度过长";
			}
		}else{
			return "保险类型不能为空";
		}
		if(request.getMain().getRiskCode()!=null&&!"".equals(request.getMain().getRiskCode())){
			if(request.getMain().getRiskCode().length()>8){
				return "险种代码长度过长";
			}
		}else{
			return "险种代码不能为空";
		}
		if(request.getMain().getPolicyFlag()!=null&&!"".equals(request.getMain().getPolicyFlag())){
			if(request.getMain().getPolicyFlag().length()>2){
				return "是否政策性保险长度过长";
			}
		}else{
			return "是否政策性保险不能为空";
		}
		if(request.getMain().getClaimStatus()!=null&&!"".equals(request.getMain().getClaimStatus())){
			if(request.getMain().getClaimStatus().length()>2){
				return "理赔状态长度过长";
			}
		}else{
			return "理赔状态不能为空";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(request.getMain().getStartDate()!=null&&!"".equals(request.getMain().getStartDate())){
			try {
				@SuppressWarnings("unused")
				Date date = sdf.parse(request.getMain().getStartDate());
			} catch (Exception e) {
				return "起保日期格式不正确";
			}
		}else{
			return "起保日期不能为空";
		}
		if(request.getMain().getEndDate()!=null&&!"".equals(request.getMain().getEndDate())){
			try {
				@SuppressWarnings("unused")
				Date date = sdf.parse(request.getMain().getEndDate());
			} catch (Exception e) {
				return "终保日期格式不正确";
			}
		}else{
			return "终保日期不能为空";
		}
		if(request.getMain().getHappenDate()!=null&&!"".equals(request.getMain().getHappenDate())){
			try {
				@SuppressWarnings("unused")
				Date date = sdf.parse(request.getMain().getHappenDate());
			} catch (Exception e) {
				return "出险日期格式不正确";
			}
		}else{
			return "出险日期不能为空";
		}
		if(request.getMain().getReportDate()!=null&&!"".equals(request.getMain().getReportDate())){
			try {
				@SuppressWarnings("unused")
				Date date = sdf.parse(request.getMain().getReportDate());
			} catch (Exception e) {
				return "报案日期格式不正确";
			}
		}else{
			return "报案日期不能为空";
		}
		if(request.getMain().getCaseDate()!=null&&!"".equals(request.getMain().getCaseDate())){
			try {
				@SuppressWarnings("unused")
				Date date = sdf.parse(request.getMain().getCaseDate());
			} catch (Exception e) {
				return "结案日期格式不正确";
			}
		}
		if(request.getMain().getPayDate()!=null&&!"".equals(request.getMain().getPayDate())){
			try {
				@SuppressWarnings("unused")
				Date date = sdf.parse(request.getMain().getPayDate());
			} catch (Exception e) {
				return "支付日期格式不正确";
			}
		}
		Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$"); 
		if(request.getMain().getCompensationAmount()!=null&&!"".equals(request.getMain().getCompensationAmount())){
			Matcher isNum = pattern.matcher(request.getMain().getCompensationAmount());
			if(!isNum.matches()){
				return "总赔付金额必须为数字";
			}
			if(request.getMain().getCompensationAmount().length()>28){
				return "总赔付金额长度过长";
			}
		}else{
			return "总赔付金额不能为空";
		}
		if(request.getMain().getCompensation()!=null&&!"".equals(request.getMain().getCompensation())){
			Matcher isNum = pattern.matcher(request.getMain().getCompensation());
			if(!isNum.matches()){
				return "已赔付金额必须为数字";
			}
			if(request.getMain().getCompensation().length()>28){
				return "已赔付金额长度过长";
			}
		}else{
			return "已赔付金额不能为空";
		}
		if(request.getMain().getInsuredAmount()!=null&&!"".equals(request.getMain().getInsuredAmount())){
			Matcher isNum = pattern.matcher(request.getMain().getInsuredAmount());
			if(!isNum.matches()){
				return "承保数量必须为数字";
			}
			if(request.getMain().getInsuredAmount().length()>28){
				return "承保数量长度过长";
			}
		}
		if(request.getMain().getCompensationQuantity()!=null&&!"".equals(request.getMain().getCompensationQuantity())){
			Matcher isNum = pattern.matcher(request.getMain().getCompensationQuantity());
			if(!isNum.matches()){
				return "赔付数量必须为数字";
			}
			if(request.getMain().getCompensationQuantity().length()>28){
				return "赔付数量长度过长";
			}
		}
		if(request.getMain().getInsuranceCode()!=null&&!"".equals(request.getMain().getInsuranceCode())){
			if(request.getMain().getInsuranceCode().length()>8){
				return "保险公司代码长度过长";
			}
		}else{
			return "保险公司代码不能为空";
		}
		if(request.getMain().getProvince()==null||"".equals(request.getMain().getProvince())){
			return "省不能为空";
		}else{
			if(request.getMain().getProvince().length()>6){
				return "省代码长度过长";
			}
		}
		if(request.getMain().getCity()==null||"".equals(request.getMain().getCity())){
			return "市不能为空";
		}else{
			if(request.getMain().getCity().length()>6){
				return "市代码长度过长";
			}
		}
		if(request.getMain().getCounty()==null||"".equals(request.getMain().getCounty())){
			return "区县不能为空";
		}else{
			if(request.getMain().getCounty().length()>6){
				return "区县代码长度过长";
			}
		}
		List<com.dsib.claimDto.Insured> insureds = request.getInsureds();
		if(insureds==null&&!"PAIC".equals(request.getMain().getInsuranceCode())){
			return "被保险人信息不能为空！";
		}
		for(int i=0;i<insureds.size();i++){
			com.dsib.claimDto.Insured insured = insureds.get(i);
			if(insured.getInsuredCode()!=null&&!"".equals(insured.getInsuredCode())){
				Matcher isNum = pattern.matcher(insured.getInsuredCode());
				if(!isNum.matches()){
					return "被保险人信息第"+(i+1)+"条序号必须为数字";
				}
				for(int s=0;s<i;s++){
					if(insureds.get(s).getInsuredCode().equals(insured.getInsuredCode())){
						return "被保险人信息第"+(i+1)+"条序号重复出现";
					}
				}
				if(insured.getInsuredCode().length()>28){
					return "被保险人信息第"+(i+1)+"条序号长度过长";
				}
			}else{
				return "被保险人信息第"+(i+1)+"条序号不能为空";
			}
			if(insured.getInsuredName()!=null&&!"".equals(insured.getInsuredName())){
				if(insured.getInsuredName().length()>200){
					return "被保险人信息第"+(i+1)+"条被保险人姓名长度过长";
				}
			}else{
				return "被保险人信息第"+(i+1)+"条被保险人姓名不能为空";
			}
			if(insured.getInsuredAddress()!=null&&!"".equals(insured.getInsuredAddress())){
				if(insured.getInsuredAddress().length()>100){
					return "被保险人信息第"+(i+1)+"条被保险人联系地址长度过长";
				}
			}
			if(insured.getIdentifyType()!=null&&!"".equals(insured.getIdentifyType())){
				Matcher isNum = pattern.matcher(insured.getIdentifyType());
				if(!isNum.matches()){
					return "被保险人信息第"+(i+1)+"条被保险人证件类型不正确";
				}
				if(insured.getIdentifyType().length()>2){
					return "被保险人信息第"+(i+1)+"条被保险人证件类型长度过长";
				}
			}else{
				return "被保险人信息第"+(i+1)+"条被保险人证件类型不能为空";
			}
			if(insured.getIdentifyNumber()!=null&&!"".equals(insured.getIdentifyNumber())){
				if(insured.getIdentifyNumber().length()>28){
					return "被保险人信息第"+(i+1)+"条被保险人证件号码长度过长";
				}
			}else{
				return "被保险人信息第"+(i+1)+"条被保险人证件号码不能为空";
			}
			if(insured.getPhoneNumber()!=null&&!"".equals(insured.getPhoneNumber())){
				if(insured.getPhoneNumber().length()>15){
					return "被保险人信息第"+(i+1)+"条被保险人联系电话长度过长";
				}
			}
			if(insured.getFarmerType()!=null&&!"".equals(insured.getFarmerType())){
				Matcher isNum = pattern.matcher(insured.getFarmerType());
				if(!isNum.matches()){
					return "被保险人信息第"+(i+1)+"条农户类型必须为数字";
				}
				if(insured.getFarmerType().length()>2){
					return "被保险人信息第"+(i+1)+"条农户类型长度过长";
				}
			}else{
				return "被保险人信息第"+(i+1)+"条农户类型不能为空";
			}
			if(insured.getIsPoor()!=null&&!"".equals(insured.getIsPoor())){
				Matcher isNum = pattern.matcher(insured.getIsPoor());
				if(!isNum.matches()){
					return "被保险人信息第"+(i+1)+"条是否建档立卡贫苦户必须为数字";
				}
				if(insured.getIsPoor().length()>2){
					return "被保险人信息第"+(i+1)+"条是否建档立卡贫苦户长度过长";
				}
			}
			if(insured.getCompensationAmount()!=null&&!"".equals(insured.getCompensationAmount())){
				Matcher isNum = pattern.matcher(insured.getCompensationAmount());
				if(!isNum.matches()){
					return "被保险人信息第"+(i+1)+"条赔付金额必须为数字";
				}
				if(insured.getCompensationAmount().length()>28){
					return "被保险人信息第"+(i+1)+"条赔付金额长度过长";
				}
			}else{
				return "被保险人信息第"+(i+1)+"条赔付金额不能为空";
			}
			if(insured.getCompensation()!=null&&!"".equals(insured.getCompensation())){
				Matcher isNum = pattern.matcher(insured.getCompensation());
				if(!isNum.matches()){
					return "被保险人信息第"+(i+1)+"条已赔付金额必须为数字";
				}
				if(insured.getCompensation().length()>28){
					return "被保险人信息第"+(i+1)+"条已赔付金额长度过长";
				}
			}else{
				return "被保险人信息第"+(i+1)+"条已赔付金额不能为空";
			}
			if(insured.getInsuredAmount()!=null&&!"".equals(insured.getInsuredAmount())){
				Matcher isNum = pattern.matcher(insured.getInsuredAmount());
				if(!isNum.matches()){
					return "被保险人信息第"+(i+1)+"条承保数量必须为数字";
				}
				if(insured.getInsuredAmount().length()>28){
					return "被保险人信息第"+(i+1)+"条承保数量长度过长";
				}
			}
			if(insured.getCompensationQuantity()!=null&&!"".equals(insured.getCompensationQuantity())){
				Matcher isNum = pattern.matcher(insured.getCompensationQuantity());
				if(!isNum.matches()){
					return "被保险人信息第"+(i+1)+"条赔付数量必须为数字";
				}
				if(insured.getCompensationQuantity().length()>28){
					return "被保险人信息第"+(i+1)+"条赔付数量长度过长";
				}
			}
		}
		return "";
	}
	/**
	 * 清单数据校验
	 * @param request
	 * @return
	 */
	private String checkDetailListManager(com.dsib.detailListDto.Request request){
		Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
		List<com.dsib.detailListDto.Main> insureds = request.getMainList();
		if(insureds==null){
			return "清单列表为空";
		}
		for(int i=0;i<insureds.size();i++){
			com.dsib.detailListDto.Main insured = insureds.get(i);
			if(insured.getCheckType()!=null&&!"".equals(insured.getCheckType())){
				if(!"1".equals(insured.getCheckType())&&!"2".equals(insured.getCheckType())){
					return "清单列表第"+(i+1)+"条调用类型不正确";
				}
				if(insured.getCheckType().length()>2){
					return "清单列表第"+(i+1)+"条调用类型长度过长";
				}
			}else{
				return "清单列表第"+(i+1)+"条调用类型不能为空";
			}
			if(insured.getCheckFlag()!=null&&!"".equals(insured.getCheckFlag())){
				if(!"1".equals(insured.getCheckFlag())&&!"2".equals(insured.getCheckFlag())){
					return "清单列表第"+(i+1)+"条调用状态不正确";
				}
				if(insured.getCheckFlag().length()>2){
					return "清单列表第"+(i+1)+"条调用状态长度过长";
				}
			}else{
				return "清单列表第"+(i+1)+"条调用状态不能为空";
			}
			if(insured.getInsuredCode()!=null&&!"".equals(insured.getInsuredCode())){
				Matcher isNum = pattern.matcher(insured.getInsuredCode());
				if(!isNum.matches()){
					return "清单列表第"+(i+1)+"条序号必须为数字";
				}
				for(int s=0;s<i;s++){
					if(insureds.get(s).getInsuredCode().equals(insured.getInsuredCode())){
						return "清单列表第"+(i+1)+"条序号重复出现";
					}
				}
				if(insured.getInsuredCode().length()>28){
					return "清单列表第"+(i+1)+"条序号长度过长";
				}
			}else{
				return "清单列表第"+(i+1)+"条序号不能为空";
			}
			if(insured.getPolicyNo()!=null&&!"".equals(insured.getPolicyNo())){
				if(insured.getPolicyNo().length()>28){
					return "清单列表第"+(i+1)+"保单号长度过长";
				}
			}else{
				return "清单列表第"+(i+1)+"保单号不能为空";
			}
			if(insured.getInsuredName()!=null&&!"".equals(insured.getInsuredName())){
				if(insured.getInsuredName().length()>200){
					return "清单列表第"+(i+1)+"条被保险人姓名长度过长";
				}
			}else{
				return "清单列表第"+(i+1)+"条被保险人姓名不能为空";
			}
			if(insured.getInsuredAddress()!=null&&!"".equals(insured.getInsuredAddress())){
				if(insured.getInsuredAddress().length()>100){
					return "清单列表第"+(i+1)+"条被保险人联系地址长度过长";
				}
			}
			if(insured.getIdentifyType()!=null&&!"".equals(insured.getIdentifyType())){
				Matcher isNum = pattern.matcher(insured.getIdentifyType());
				if(!isNum.matches()){
					return "清单列表第"+(i+1)+"条被保险人证件类型必须为数字";
				}
				if(insured.getIdentifyType().length()>2){
					return "清单列表第"+(i+1)+"条被保险人证件类型长度过长";
				}
			}else{
				return "清单列表第"+(i+1)+"条被保险人证件类型不能为空";
			}
			if(insured.getIdentifyNumber()!=null&&!"".equals(insured.getIdentifyNumber())){
				if(insured.getIdentifyNumber().length()>28){
					return "清单列表第"+(i+1)+"条被保险人证件号码长度过长";
				}
			}else{
				return "清单列表第"+(i+1)+"条被保险人证件号码不能为空";
			}
			if(insured.getPhoneNumber()!=null&&!"".equals(insured.getPhoneNumber())){
				if(insured.getPhoneNumber().length()>15){
					return "清单列表第"+(i+1)+"条被保险人联系电话长度过长";
				}
			}
			if(insured.getFarmerType()!=null&&!"".equals(insured.getFarmerType())){
				Matcher isNum = pattern.matcher(insured.getFarmerType());
				if(!isNum.matches()){
					return "清单列表第"+(i+1)+"条农户类型必须为数字";
				}
				if(insured.getFarmerType().length()>2){
					return "清单列表第"+(i+1)+"条农户类型长度过长";
				}
			}else{
				return "清单列表第"+(i+1)+"条农户类型不能为空";
			}
			if(insured.getIsPoor()!=null&&!"".equals(insured.getIsPoor())){
				Matcher isNum = pattern.matcher(insured.getIsPoor());
				if(!isNum.matches()){
					return "清单列表第"+(i+1)+"条是否建档立卡贫苦户必须为数字";
				}
				if(insured.getIsPoor().length()>2){
					return "清单列表第"+(i+1)+"条是否建档立卡贫苦户长度过长";
				}
			}
			if(insured.getInsuredQuantity()!=null&&!"".equals(insured.getInsuredQuantity())){
				Matcher isNum = pattern.matcher(insured.getInsuredQuantity());
				if(!isNum.matches()){
					return "清单列表第"+(i+1)+"条投保数量必须为数字";
				}
				if(insured.getInsuredQuantity().length()>28){
					return "清单列表第"+(i+1)+"条投保数量长度过长";
				}
			}
			if("2".equals(insured.getCheckType())){
				if(insured.getReportNo()!=null&&!"".equals(insured.getReportNo())){
					if(insured.getReportNo().length()>28){
						return "清单列表第"+(i+1)+"报案号长度过长";
					}
					List<Jg_GuPolicyClaim> temp = jg_GuPolicyClaimMapper.findByReportNo(request.getMainList().get(0).getReportNo());
					if(temp==null||temp.size()==0){
						return "上传清单列表需要先上传理赔主信息!";
					}
				}else{
					return "清单列表第"+(i+1)+"报案号不能为空";
				}
				if(insured.getCompensationAmount()!=null&&!"".equals(insured.getCompensationAmount())){
					Matcher isNum = pattern.matcher(insured.getCompensationAmount());
					if(!isNum.matches()){
						return "清单列表第"+(i+1)+"条赔付金额必须为数字";
					}
					if(insured.getCompensationAmount().length()>28){
						return "清单列表第"+(i+1)+"条赔付金额长度过长";
					}
				}else{
					return "清单列表第"+(i+1)+"条赔付金额不能为空";
				}
				if(insured.getCompensation()!=null&&!"".equals(insured.getCompensation())){
					Matcher isNum = pattern.matcher(insured.getCompensation());
					if(!isNum.matches()){
						return "清单列表第"+(i+1)+"条已赔付金额必须为数字";
					}
					if(insured.getCompensation().length()>28){
						return "清单列表第"+(i+1)+"条已赔付金额长度过长";
					}
				}else{
					return "清单列表第"+(i+1)+"条已赔付金额不能为空";
				}
				if(insured.getCompensationQuantity()!=null&&!"".equals(insured.getCompensationQuantity())){
					Matcher isNum = pattern.matcher(insured.getCompensationQuantity());
					if(!isNum.matches()){
						return "清单列表第"+(i+1)+"条赔付数量必须为数字";
					}
					if(insured.getCompensationQuantity().length()>28){
						return "清单列表第"+(i+1)+"条赔付数量长度过长";
					}
				}
			}else{
				if(!"".equals(insured.getBank())&&insured.getBank()!=null){
					if(insured.getBank().length()>28){
						return "清单列表第"+(i+1)+"条一卡通开户行长度过长";
					}
				}
				if(!"".equals(insured.getCardNo())&&insured.getCardNo()!=null){
					Matcher isNum = pattern.matcher(insured.getCardNo());
					if(!isNum.matches()){
						return "清单列表第"+(i+1)+"条一卡通账号格式错误";
					}
					if(insured.getCardNo().length()>28){
						return "清单列表第"+(i+1)+"条一卡通账号长度过长";
					}
				}
				if(!"".equals(insured.getAmount())&&insured.getAmount()!=null){
					Matcher isNum = pattern.matcher(insured.getAmount());
					if(!isNum.matches()){
						return "清单列表第"+(i+1)+"条保额格式错误";
					}
					if(insured.getAmount().length()>28){
						return "清单列表第"+(i+1)+"条保额长度过长";
					}
				}else{
					return "清单列表第"+(i+1)+"条保额不能为空";
				}
				if(!"".equals(insured.getPremium())&&insured.getPremium()!=null){
					Matcher isNum = pattern.matcher(insured.getPremium());
					if(!isNum.matches()){
						return "清单列表第"+(i+1)+"条保费格式错误";
					}
					if(insured.getPremium().length()>28){
						return "清单列表第"+(i+1)+"条保费长度过长";
					}
				}else{
					return "清单列表第"+(i+1)+"条保费不能为空";
				}
				if(!"".equals(insured.getPremium())&&insured.getPremium()!=null){
					Matcher isNum = pattern.matcher(insured.getPremium());
					if(!isNum.matches()){
						return "清单列表第"+(i+1)+"条保费格式错误";
					}
					if(insured.getPremium().length()>28){
						return "清单列表第"+(i+1)+"条保费长度过长";
					}
				}else{
					return "清单列表第"+(i+1)+"条保费不能为空";
				}
				if(!"".equals(insured.getCentralAllowance())&&insured.getCentralAllowance()!=null){
					Matcher isNum = pattern.matcher(insured.getCentralAllowance());
					if(!isNum.matches()){
						return "清单列表第"+(i+1)+"条中央财政补贴额格式错误";
					}
					if(insured.getCentralAllowance().length()>28){
						return "清单列表第"+(i+1)+"条中央财政补贴额长度过长";
					}
				}else{
					return "清单列表第"+(i+1)+"条中央财政补贴额不能为空";
				}
				if(!"".equals(insured.getProvinceAllowance())&&insured.getProvinceAllowance()!=null){
					Matcher isNum = pattern.matcher(insured.getProvinceAllowance());
					if(!isNum.matches()){
						return "清单列表第"+(i+1)+"条省级财政补贴额格式错误";
					}
					if(insured.getProvinceAllowance().length()>28){
						return "清单列表第"+(i+1)+"条省级财政补贴额长度过长";
					}
				}else{
					return "清单列表第"+(i+1)+"条省级财政补贴额不能为空";
				}
				if(!"".equals(insured.getCityAllowance())&&insured.getCityAllowance()!=null){
					Matcher isNum = pattern.matcher(insured.getCityAllowance());
					if(!isNum.matches()){
						return "清单列表第"+(i+1)+"条地市财政补贴额格式错误";
					}
					if(insured.getCityAllowance().length()>28){
						return "清单列表第"+(i+1)+"条地市财政补贴额长度过长";
					}
				}else{
					return "清单列表第"+(i+1)+"条地市财政补贴额不能为空";
				}
				if(!"".equals(insured.getCityAllowance())&&insured.getCityAllowance()!=null){
					Matcher isNum = pattern.matcher(insured.getCityAllowance());
					if(!isNum.matches()){
						return "清单列表第"+(i+1)+"条县区财政补贴额格式错误";
					}
					if(insured.getCityAllowance().length()>28){
						return "清单列表第"+(i+1)+"条县区财政补贴额长度过长";
					}
				}else{
					return "清单列表第"+(i+1)+"条县区财政补贴额不能为空";
				}
				if(!"".equals(insured.getPersonAllowance())&&insured.getPersonAllowance()!=null){
					Matcher isNum = pattern.matcher(insured.getPersonAllowance());
					if(!isNum.matches()){
						return "清单列表第"+(i+1)+"条用户自交格式错误";
					}
					if(insured.getPersonAllowance().length()>28){
						return "清单列表第"+(i+1)+"条用户自交长度过长";
					}
				}else{
					return "清单列表第"+(i+1)+"条用户自交不能为空";
				}
				if(!"".equals(insured.getOhterAllowance())&&insured.getOhterAllowance()!=null){
					Matcher isNum = pattern.matcher(insured.getOhterAllowance());
					if(!isNum.matches()){
						return "清单列表第"+(i+1)+"条其他格式错误";
					}
					if(insured.getOhterAllowance().length()>28){
						return "清单列表第"+(i+1)+"条其他长度过长";
					}
				}else{
					return "清单列表第"+(i+1)+"条其他不能为空";
				}
			}
		}
		return "";
	}
	
	/**
	 * 保单数据入库
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@Transactional
	private String insertPolicyManger(Request request) throws Exception{
		//查询是否是已存在的数据
//		PolicyMain tempPolicyMain = policyMainMapper.findByPolicyNo(request.getMain().getPolicyNo());
		Jg_GuPolicyMain tempJg_GuPolicyMain = jg_GuPolicyMainMapper.findByPolicyNo(request.getMain().getPolicyNo());
		// 生成业务号
		String businessNo = new Long(new Date().getTime()).toString();
		businessNo = businessNo
				+ Long.toString(getRandom(100000000, 999999999));
		businessNo = businessNo.substring(0, 20);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		PolicyMain policyMain = new PolicyMain(businessNo, request.getMain().getPolicyNo(), request.getMain().getInsuranceType(), 
				request.getMain().getRiskCode(), request.getMain().getPolicyFlag(), sdf.parse(request.getMain().getStartDate()), 
				sdf.parse(request.getMain().getEndDate()),request.getMain().getArgueSolution(), 
				request.getMain().getArbitBoardName(),request.getMain().getInsuredCount(),request.getMain().getInsuredQuantity(), 
				new BigDecimal(request.getMain().getSumAmount()),
				new BigDecimal(request.getMain().getSumPremium()),
				request.getMain().getPolicyType(), sdf.parse(request.getMain().getSignDate()),
				request.getMain().getSpecialProvisions(), request.getMain().getInsurerCode(), 
				new BigDecimal(request.getMain().getCentralAllowance()),
				new BigDecimal(request.getMain().getProvinceAllowance()),
				new BigDecimal(request.getMain().getCityAllowance()),
				new BigDecimal(request.getMain().getCountyAllowance()),
				new BigDecimal(request.getMain().getPersonAllowance()),
				new BigDecimal(request.getMain().getOtherAllowance()),
				request.getMain().getProvince(), request.getMain().getCity(),
				request.getMain().getCounty(), request.getMain().getTown());
		PolicyOrganizer policyOrganizer = null;
		if(request.getOrganizer()!=null){
			policyOrganizer = new PolicyOrganizer(businessNo, request.getOrganizer().getOrganizerName(), 
					request.getOrganizer().getOrganizerAddress(), request.getOrganizer().getIdentifyType(),
					request.getOrganizer().getIdentifyNumber(), request.getOrganizer().getPostCode(), 
					request.getOrganizer().getContactName(), request.getOrganizer().getPhoneNumber());
		}
		Date bdate = null;
		if(request.getApplicant().getBirthday()!=null&&!"".equals(request.getApplicant().getBirthday())){
			bdate = sdf2.parse(request.getApplicant().getBirthday());
		}
		PolicyApplicant policyApplicant = new PolicyApplicant(businessNo, request.getApplicant().getAppliName(),
				request.getApplicant().getAppliAddress(), request.getApplicant().getIdentifyType(), 
				request.getApplicant().getIdentifyNumber(), bdate, 
				request.getApplicant().getAge(), request.getApplicant().getSex(), 
				request.getApplicant().getInsuredIdentity(), request.getApplicant().getPostCode(), 
				request.getApplicant().getPhoneNumber(), request.getApplicant().getInsuredType());
		bdate = null;
		if(request.getInsured().getBirthday()!=null&&!"".equals(request.getInsured().getBirthday())){
			bdate = sdf2.parse(request.getInsured().getBirthday());
		}
		PolicyInsured policyInsured = null;
		if(request.getInsured()!=null){
			policyInsured = new PolicyInsured(businessNo, request.getInsured().getInsuredCode(), 
					request.getInsured().getInsuredName(), request.getInsured().getAppliIdentity(),
					request.getInsured().getInsuredAddress(), request.getInsured().getIdentifyType(),
					request.getInsured().getIdentifyNumber(), bdate, 
					request.getInsured().getAge(), request.getInsured().getSex(), request.getInsured().getPostCode(),
					request.getInsured().getPhoneNumber(), request.getInsured().getInsuredType());
		}
		List<PolicyInsurance> insurances = new ArrayList<PolicyInsurance>();
		if(request.getInsuranceList()!=null){
			for(int i=0;i<request.getInsuranceList().size();i++){
				Insurance insurance = request.getInsuranceList().get(i);
				PolicyInsurance policyInsurance = new PolicyInsurance(insurance.getInsuredName(), insurance.getInsuredAddress(),
						insurance.getPhoneNumber(), insurance.getIdentifyType(), insurance.getIdentifyNumber(),
						insurance.getInsuredQuantity(), insurance.getFarmerType(), insurance.getIsPoor(), insurance.getBank(),
						insurance.getCardNo(), new BigDecimal(insurance.getAmount()), new BigDecimal(insurance.getPremium()),
						new BigDecimal(insurance.getCentralAllowance()), new BigDecimal(insurance.getProvinceAllowance()),
						new BigDecimal(insurance.getCityAllowance()), new BigDecimal(insurance.getCountyAllowance()), 
						new BigDecimal(insurance.getPersonAllowance()), new BigDecimal(insurance.getOhterAllowance()));
				policyInsurance.setBusinessNo(businessNo);
				policyInsurance.setInsuredCode(insurance.getInsuredCode());
				insurances.add(policyInsurance);
			}
		}
		List<PolicyItemKind> itemKinds = new ArrayList<PolicyItemKind>(); 
		if(request.getItemKinds()!=null){
			for(int i=0;i<request.getItemKinds().size();i++){
				ItemKind itemKind = request.getItemKinds().get(i);
				PolicyItemKind policyItemKind = new PolicyItemKind(itemKind.getItemType(), itemKind.getItemTypeName(), 
						itemKind.getKindCode(), itemKind.getKindName(), itemKind.getUnit(), 
						new BigDecimal(itemKind.getQuantity()), new BigDecimal(itemKind.getUnitAmount()),
						new BigDecimal(itemKind.getAmount()), new BigDecimal(itemKind.getInsuranceRates()),
						new BigDecimal(itemKind.getPremium()), itemKind.getFlag());
				policyItemKind.setBusinessNo(businessNo);
				policyItemKind.setItemKindNo(itemKind.getItemKindNo());
				itemKinds.add(policyItemKind);
			}
		}
		//监管表数据处理
		Jg_GuPolicyMain jg_GuPolicyMain = null;
//		if(tempJg_GuPolicyMain!=null){
//			jg_GuPolicyMain = getJgMain(request,tempJg_GuPolicyMain.getBusinessno());
//		}else{
			jg_GuPolicyMain = getJgMain(request,businessNo);
//		}
		//监管清单处理
		List<Jg_Insurance> jg_Insurances = getJgIns(request, request.getMain().getPolicyNo());
		jg_InsuranceMapper.deleteByPolicyNo(new Jg_InsuranceKey(request.getMain().getPolicyNo()));
		//入库
		policyMainMapper.insertSelective(policyMain);
		if(policyOrganizer!=null){
			policyOrganizerMapper.insertSelective(policyOrganizer);
		}
		policyApplicantMapper.insertSelective(policyApplicant);
		if(policyInsured!=null){
			policyInsuredMapper.insertSelective(policyInsured);
		}
		if(insurances.size()>0){
			for(int i=0;i<insurances.size();i++){
				policyInsuranceMapper.insertSelective(insurances.get(i));
			}
		}
		if(itemKinds.size()>0){
			for(int i=0;i<itemKinds.size();i++){
				policyItemKindMapper.insertSelective(itemKinds.get(i));
			}
		}
		if(tempJg_GuPolicyMain!=null){
			if(jg_GuPolicyMain.getSpreadsheetpremium().doubleValue()==0){//保费为0代表全额退保或保单注销
				jg_GuPolicyMainMapper.deleteByPrimaryKey(tempJg_GuPolicyMain.getBusinessno());
			}else{
				jg_GuPolicyMainMapper.deleteByPrimaryKey(tempJg_GuPolicyMain.getBusinessno());
				jg_GuPolicyMainMapper.insertSelective(jg_GuPolicyMain);
//				//如果已经存在则更新
//				jg_GuPolicyMainMapper.updateByPrimaryKeySelective(jg_GuPolicyMain);
				if(jg_Insurances.size()>0){
					for(int i=0;i<jg_Insurances.size();i++){
						jg_InsuranceMapper.insertSelective(jg_Insurances.get(i));
					}
				}
			}
		}else{
			jg_GuPolicyMainMapper.insertSelective(jg_GuPolicyMain);
			if(jg_Insurances.size()>0){
				for(int i=0;i<jg_Insurances.size();i++){
					jg_InsuranceMapper.insertSelective(jg_Insurances.get(i));
				}
			}
		}
		return "Y";
	}
	
	/**
	 *理赔数据入库
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@Transactional
	private String insertClaimManager(com.dsib.claimDto.Request request) throws Exception{
		//查询是否是已存在的数据
//		ClaimMain tempClaimMain = claimMainMapper.findByReportNo(request.getMain().getReportNo());
		// 生成业务号
		String businessNo = new Long(new Date().getTime()).toString();
		businessNo = businessNo
				+ Long.toString(getRandom(100000000, 999999999));
		businessNo = businessNo.substring(0, 20);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date bdate = null;
		Date tdate = null;
		if(request.getMain().getCaseDate()!=null&&!"".equals(request.getMain().getCaseDate())){
			bdate = sdf.parse(request.getMain().getCaseDate());
		}
		if(request.getMain().getPayDate()!=null&&!"".equals(request.getMain().getPayDate())){
			tdate = sdf.parse(request.getMain().getPayDate());
		}
		BigDecimal minsuredAmount = null;
		BigDecimal mcompensationQuantity = null;
		if(request.getMain().getInsuredAmount()!=null&&!"".equals(request.getMain().getInsuredAmount())){
			minsuredAmount = new BigDecimal(request.getMain().getInsuredAmount());
		}
		if(request.getMain().getCompensationQuantity()!=null&&!"".equals(request.getMain().getCompensationQuantity())){
			mcompensationQuantity = new BigDecimal(request.getMain().getCompensationQuantity());
		}
		ClaimMain claimMain = new ClaimMain(businessNo, request.getMain().getPolicyNo(), request.getMain().getReportNo(),
				request.getMain().getCaseNo(), request.getMain().getClaimsNo(), request.getMain().getInsuranceType(),
				request.getMain().getRiskCode(), request.getMain().getPolicyFlag(), request.getMain().getClaimStatus(),
				sdf.parse(request.getMain().getStartDate()), sdf.parse(request.getMain().getEndDate()),
				sdf.parse(request.getMain().getHappenDate()), sdf.parse(request.getMain().getReportDate()),
				bdate, tdate,new BigDecimal(request.getMain().getCompensationAmount()), 
				new BigDecimal(request.getMain().getCompensation()),minsuredAmount, mcompensationQuantity,
				request.getMain().getInsuranceCode(),request.getMain().getProvince(),request.getMain().getCity(),request.getMain().getCounty());
		List<ClaimInsured> insureds = new ArrayList<ClaimInsured>();
		if(request.getInsureds()!=null){
			for(int i=0;i<request.getInsureds().size();i++){
				BigDecimal insuredAmount = null;
				BigDecimal compensationQuantity = null;
				com.dsib.claimDto.Insured insured = request.getInsureds().get(i);
				if(insured.getInsuredAmount()!=null&&!"".equals(insured.getInsuredAmount())){
					insuredAmount = new BigDecimal(insured.getInsuredAmount());
				}
				if(insured.getCompensationQuantity()!=null&&!"".equals(insured.getCompensationQuantity())){
					compensationQuantity = new BigDecimal(insured.getCompensationQuantity());
				}
				ClaimInsured claimInsured = new ClaimInsured(insured.getInsuredName(), insured.getInsuredAddress(),
						insured.getIdentifyType(), insured.getIdentifyNumber(), insured.getPhoneNumber(),
						insured.getFarmerType(), insured.getIsPoor(),
						new BigDecimal(insured.getCompensationAmount()),
						new BigDecimal(insured.getCompensation()), insuredAmount, 
						compensationQuantity);
				claimInsured.setBusinessNo(businessNo);
				claimInsured.setInsuredCode(insured.getInsuredCode());
				insureds.add(claimInsured);
			}
		}
		//监管表数据处理
		List<Jg_GuPolicyClaim> jg_GuPolicyClaims = getJgClaim(request);
		jg_GuPolicyClaimMapper.deleteByReportNo(request.getMain().getReportNo());
		// 入库
		claimMainMapper.insertSelective(claimMain);
		if(request.getInsureds()!=null){
			for(int i=0;i<insureds.size();i++){
				claimInsuredMapper.insertSelective(insureds.get(i));
			}
		}
		for(int i=0;i<jg_GuPolicyClaims.size();i++){
			jg_GuPolicyClaimMapper.insertSelective(jg_GuPolicyClaims.get(i));
		}
		return "Y";
	}
	
	/**
	 * 清单数据入库
	 * @param request
	 * @return
	 */
	@Transactional
	private String insertDetailListManager(com.dsib.detailListDto.Request request){
		String businessNo = new Long(new Date().getTime()).toString();
		businessNo = businessNo
				+ Long.toString(getRandom(100000000, 999999999));
		businessNo = businessNo.substring(0, 20);
		if("1".equals(request.getMainList().get(0).getCheckType())){//保单清单
			List<DetailedList> mainList = new ArrayList<DetailedList>();
			List<Jg_Insurance> jg_Insurances = new ArrayList<Jg_Insurance>();
			for(int i=0;i<request.getMainList().size();i++){
				DetailedList detailedList = new DetailedList(request.getMainList().get(i).getCheckType(),
						request.getMainList().get(i).getCheckFlag(), request.getMainList().get(i).getPolicyNo(), 
						request.getMainList().get(i).getReportNo(), request.getMainList().get(i).getInsuredName(), 
						request.getMainList().get(i).getInsuredAddress(), request.getMainList().get(i).getIdentifyType(), 
						request.getMainList().get(i).getIdentifyNumber(), request.getMainList().get(i).getPhoneNumber(), 
						request.getMainList().get(i).getFarmerType(), request.getMainList().get(i).getIsPoor(),
						request.getMainList().get(i).getInsuredQuantity(), request.getMainList().get(i).getBank(),
						request.getMainList().get(i).getCardNo(), request.getMainList().get(i).getAmount(), 
						request.getMainList().get(i).getPremium(),request.getMainList().get(i).getCentralAllowance(),
						request.getMainList().get(i).getProvinceAllowance(), request.getMainList().get(i).getCityAllowance(),
						request.getMainList().get(i).getCountyAllowance(), request.getMainList().get(i).getPersonAllowance(), 
						request.getMainList().get(i).getOhterAllowance(), request.getMainList().get(i).getCompensationAmount(), 
						request.getMainList().get(i).getCompensation(), request.getMainList().get(i).getCompensationQuantity());
				detailedList.setBusinessNo(businessNo);
				detailedList.setInsuredCode(request.getMainList().get(i).getInsuredCode());
				mainList.add(detailedList);
				Jg_Insurance insurance = new Jg_Insurance(request.getMainList().get(i).getInsuredName(), 
						request.getMainList().get(i).getInsuredAddress(), request.getMainList().get(i).getPhoneNumber(),
						request.getMainList().get(i).getIdentifyType(),request.getMainList().get(i).getIdentifyNumber(),
						request.getMainList().get(i).getInsuredQuantity(),
						request.getMainList().get(i).getFarmerType(), request.getMainList().get(i).getIsPoor(),
						request.getMainList().get(i).getBank(), request.getMainList().get(i).getCardNo(),
						request.getMainList().get(i).getAmount(), request.getMainList().get(i).getPremium(), 
						request.getMainList().get(i).getCentralAllowance(), request.getMainList().get(i).getProvinceAllowance(),
						request.getMainList().get(i).getCityAllowance(),
						request.getMainList().get(i).getCountyAllowance(), request.getMainList().get(i).getPersonAllowance(), 
						request.getMainList().get(i).getOhterAllowance());
				insurance.setPolicyno(request.getMainList().get(i).getPolicyNo());
				insurance.setSerialno(getBusinessNo());
				jg_Insurances.add(insurance);
			}
			for(int i=0;i<mainList.size();i++){
				detailedListMapper.insertSelective(mainList.get(i));
			}
			if("1".equals(request.getMainList().get(0).getCheckFlag())){//新增
				jg_InsuranceMapper.deleteByPolicyNo(new Jg_InsuranceKey(request.getMainList().get(0).getPolicyNo()));
				for(int i=0;i<jg_Insurances.size();i++){
					jg_InsuranceMapper.insertSelective(jg_Insurances.get(i));
				}
			}else{//续传
				for(int i=0;i<jg_Insurances.size();i++){
					jg_InsuranceMapper.insertSelective(jg_Insurances.get(i));
				}
			}
		}else{//理赔清单
			List<DetailedList> mainList = new ArrayList<DetailedList>();
			List<Jg_GuPolicyClaim> jg_GuPolicyClaims = new ArrayList<Jg_GuPolicyClaim>();
			Jg_GuPolicyClaim hisClaim = jg_GuPolicyClaimMapper.findByReportNo(request.getMainList().get(0).getReportNo()).get(0);
			for(int i=0;i<request.getMainList().size();i++){
				DetailedList detailedList = new DetailedList(request.getMainList().get(i).getCheckType(),
						request.getMainList().get(i).getCheckFlag(), request.getMainList().get(i).getPolicyNo(), 
						request.getMainList().get(i).getReportNo(), request.getMainList().get(i).getInsuredName(), 
						request.getMainList().get(i).getInsuredAddress(), request.getMainList().get(i).getIdentifyType(), 
						request.getMainList().get(i).getIdentifyNumber(), request.getMainList().get(i).getPhoneNumber(), 
						request.getMainList().get(i).getFarmerType(), request.getMainList().get(i).getIsPoor(),
						request.getMainList().get(i).getInsuredQuantity(), request.getMainList().get(i).getBank(),
						request.getMainList().get(i).getCardNo(), request.getMainList().get(i).getAmount(), 
						request.getMainList().get(i).getPremium(),request.getMainList().get(i).getCentralAllowance(),
						request.getMainList().get(i).getProvinceAllowance(), request.getMainList().get(i).getCityAllowance(),
						request.getMainList().get(i).getCountyAllowance(), request.getMainList().get(i).getPersonAllowance(), 
						request.getMainList().get(i).getOhterAllowance(), request.getMainList().get(i).getCompensationAmount(), 
						request.getMainList().get(i).getCompensation(), request.getMainList().get(i).getCompensationQuantity());
				detailedList.setBusinessNo(businessNo);
				detailedList.setInsuredCode(request.getMainList().get(i).getInsuredCode());
				mainList.add(detailedList);
				String compensationQuantity = request.getMainList().get(i).getCompensationQuantity();
				if("".equals(compensationQuantity)||compensationQuantity==null){
					compensationQuantity = "0";
				}
				Jg_GuPolicyClaim jg_GuPolicyClaim = new Jg_GuPolicyClaim(getBusinessNo(), hisClaim.getRiskcode(), hisClaim.getInsurercode(), 
						request.getMainList().get(i).getReportNo(),hisClaim.getPeino(), 
						request.getMainList().get(i).getPolicyNo(), null, null, hisClaim.getLossdate(), 
						new BigDecimal(request.getMainList().get(i).getCompensationAmount()), hisClaim.getAllpaydate(), 
						new BigDecimal(compensationQuantity), hisClaim.getProvince(), hisClaim.getCity(), hisClaim.getCounty(),
						hisClaim.getStatus(), hisClaim.getInsurercode(), new Date(), hisClaim.getPolicyflag(), 
						request.getMainList().get(i).getIsPoor(), request.getMainList().get(i).getFarmerType(), 
						request.getMainList().get(i).getInsuredName(), request.getMainList().get(i).getInsuredAddress(), 
						request.getMainList().get(i).getIdentifyNumber(), request.getMainList().get(i).getPhoneNumber());
				jg_GuPolicyClaims.add(jg_GuPolicyClaim);
			}
			for(int i=0;i<mainList.size();i++){
				detailedListMapper.insertSelective(mainList.get(i));
			}
			if("1".equals(request.getMainList().get(0).getCheckFlag())){//新增
				jg_GuPolicyClaimMapper.deleteByReportNo(request.getMainList().get(0).getReportNo());
				for(int i=0;i<jg_GuPolicyClaims.size();i++){
					jg_GuPolicyClaimMapper.insertSelective(jg_GuPolicyClaims.get(i));
				}
			}else{//续传
				for(int i=0;i<jg_GuPolicyClaims.size();i++){
					jg_GuPolicyClaimMapper.insertSelective(jg_GuPolicyClaims.get(i));
				}
			}
		}
		return "Y";
	}
	
	/**
	 * 生成农险平台的保单对象
	 * @param request
	 * @param businessNo 
	 * @return
	 * @throws ParseException 
	 */
	private Jg_GuPolicyMain getJgMain(Request request, String businessNo) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Jg_GuPolicyMain guPolicyMain = new Jg_GuPolicyMain(businessNo, request.getMain().getPolicyNo(), 
				request.getMain().getRiskCode(), request.getMain().getRiskCode().substring(0, 1),request.getMain().getInsurerCode(), 
				sdf.parse(request.getMain().getStartDate()), sdf.parse(request.getMain().getEndDate()),
				sdf.parse(request.getMain().getSignDate()), new BigDecimal(request.getMain().getSumPremium()), 
				new BigDecimal(request.getMain().getSumPremium()), new BigDecimal(request.getMain().getInsuredQuantity()),
				new BigDecimal(request.getMain().getSumAmount()), request.getMain().getCounty(), request.getMain().getCity(),
				request.getMain().getProvince(), request.getInsured().getIdentifyNumber(), new Date(), "3", "接口导入", new Date(),
				request.getMain().getRiskCode(), request.getInsured().getInsuredName(), request.getInsured().getInsuredAddress(),
				request.getInsured().getIdentifyNumber(), new BigDecimal(request.getMain().getCentralAllowance()), 
				new BigDecimal(request.getMain().getProvinceAllowance()),new BigDecimal(request.getMain().getCityAllowance()),
				new BigDecimal(request.getMain().getCountyAllowance()), new BigDecimal(request.getMain().getPersonAllowance()),
				new BigDecimal(request.getMain().getOtherAllowance()), null, null, 
				request.getMain().getInsuredCount(), 
				request.getApplicant().getAppliName(), request.getApplicant().getIdentifyType(), request.getApplicant().getIdentifyNumber(),
				request.getApplicant().getAppliName(), request.getApplicant().getPhoneNumber());
		return guPolicyMain;
	}
	/**
	 * 生成农险平台的理赔对象
	 * @param request
	 * @return
	 * @throws ParseException 
	 */
	private List<Jg_GuPolicyClaim> getJgClaim(com.dsib.claimDto.Request request) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Jg_GuPolicyClaim> jg_GuPolicyClaims = new ArrayList<Jg_GuPolicyClaim>();
		if(request.getInsureds()!=null){
			for(int i=0;i<request.getInsureds().size();i++){
				String compensationQuantity = request.getInsureds().get(i).getCompensationQuantity();
				if("".equals(compensationQuantity)||compensationQuantity==null){
					compensationQuantity = "0";
				}
				Date paydDate = null;
				if(!"".equals(request.getMain().getPayDate())&&request.getMain().getPayDate()!=null){
					paydDate = sdf.parse(request.getMain().getPayDate());
				}
				Jg_GuPolicyClaim guPolicyClaim = new Jg_GuPolicyClaim(getBusinessNo(), request.getMain().getRiskCode(), request.getMain().getInsuranceCode(),
						request.getMain().getReportNo(), request.getMain().getClaimsNo(), request.getMain().getPolicyNo(),
						null, null, sdf.parse(request.getMain().getHappenDate()),new BigDecimal(request.getInsureds().get(i).getCompensationAmount()),
						paydDate, new BigDecimal(compensationQuantity),
						request.getMain().getProvince(), request.getMain().getCity(), 
						request.getMain().getCounty(), request.getMain().getClaimStatus(),
						request.getMain().getInsuranceCode(), new Date(), request.getMain().getPolicyFlag(), 
						request.getMain().getIsPoor(), request.getInsureds().get(i).getFarmerType(), 
						request.getInsureds().get(i).getInsuredName(), request.getInsureds().get(i).getInsuredAddress(), 
						request.getInsureds().get(i).getIdentifyNumber(), request.getInsureds().get(i).getPhoneNumber());
				jg_GuPolicyClaims.add(guPolicyClaim);
			}
		}else{
			Date paydDate = null;
			if(!"".equals(request.getMain().getPayDate())&&request.getMain().getPayDate()!=null){
				paydDate = sdf.parse(request.getMain().getPayDate());
			}
			Jg_GuPolicyClaim guPolicyClaim = new Jg_GuPolicyClaim(getBusinessNo(), request.getMain().getRiskCode(), request.getMain().getInsuranceCode(),
					request.getMain().getReportNo(), request.getMain().getClaimsNo(), request.getMain().getPolicyNo(),
					null, null, sdf.parse(request.getMain().getHappenDate()),null,
					paydDate, null,
					request.getMain().getProvince(), request.getMain().getCity(), 
					request.getMain().getCounty(), request.getMain().getClaimStatus(),
					request.getMain().getInsuranceCode(), new Date(), request.getMain().getPolicyFlag(), 
					null, null,null, null,null, null);
			jg_GuPolicyClaims.add(guPolicyClaim);
		}
		return jg_GuPolicyClaims;
	}
	/**
	 * 生成农险平台的清单对象
	 * @param request
	 * @param policyno
	 * @return
	 */
	private List<Jg_Insurance> getJgIns(Request request, String policyno){
		List<Jg_Insurance> jg_Insurances = new ArrayList<Jg_Insurance>();
		if(request.getInsuranceList()!=null&&!"".equals(request.getInsuranceList())){
			if(request.getInsuranceList().size()>0){
				for(int i=0;i<request.getInsuranceList().size();i++){
					Jg_Insurance jg_Insurance = new Jg_Insurance(request.getInsuranceList().get(i).getInsuredName(),
							request.getInsuranceList().get(i).getInsuredAddress(), request.getInsuranceList().get(i).getPhoneNumber(),
							request.getInsuranceList().get(i).getIdentifyType(), request.getInsuranceList().get(i).getIdentifyNumber(),
							request.getInsuranceList().get(i).getInsuredQuantity(),
							request.getInsuranceList().get(i).getFarmerType(), request.getInsuranceList().get(i).getIsPoor(),
							request.getInsuranceList().get(i).getBank(),request.getInsuranceList().get(i).getCardNo(),
							request.getInsuranceList().get(i).getAmount(), request.getInsuranceList().get(i).getPremium(),
							request.getInsuranceList().get(i).getCentralAllowance(), request.getInsuranceList().get(i).getProvinceAllowance(),
							request.getInsuranceList().get(i).getCityAllowance(), request.getInsuranceList().get(i).getCountyAllowance(),
							request.getInsuranceList().get(i).getPersonAllowance(), request.getInsuranceList().get(i).getOhterAllowance());
					jg_Insurance.setPolicyno(policyno);
					jg_Insurance.setSerialno(getBusinessNo());
					jg_Insurances.add(jg_Insurance);
				}
			}
		}
		return jg_Insurances;
	}
	/**
	 * 直接获取一个业务号
	 * @return
	 */
	private String getBusinessNo(){
		String businessNo = new Long(new Date().getTime()).toString();
		businessNo = businessNo
				+ Long.toString(getRandom(100000000, 999999999));
		businessNo = businessNo.substring(0, 20);
		return businessNo;
	}
	
	/**
	 * 生成业务号
	 * @param min
	 * @param max
	 * @return
	 */
	private long getRandom(final long min, final long max) {
		Random rand = new Random();
		long tmp = Math.abs(rand.nextInt());
		return tmp % (max - min + 1) + min;

	}
	/**
	 * 保存日志
	 * @param e
	 * @param resultStr
	 */
	private void saveLog(Exception e,String resultStr){
		log.error("error",e);
		log.error("返回报文:===="+resultStr);
	}
}
