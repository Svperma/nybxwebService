package com.dsib.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.dsib.service.CommonService;
/**
 * http://localhost:8080/nybxwebService/rest/application.wadl 描述文件地址
 * @author mxt
 */
@Component
@Scope("prototype")
@Path("/nybx")
public class RestfulService {

	@Autowired
	CommonService commonService;
	
	/**
	 * 供客户端调用的保单传入方法
	 * @param requestXml
	 * @return
	 */
	@POST
	@Path("/savePolicy")
	@Produces(MediaType.TEXT_PLAIN + ";charset=GBK")
	public String savePolicy(@FormParam("policyManager") String requestXml) {
		long startTime=System.currentTimeMillis();
		System.out.println("进入保单保存方法");
		String reString = commonService.savePolicy(requestXml);
		long endTime=System.currentTimeMillis();
		System.out.println("保单方法运行时间： "+(startTime-endTime)+"ms");
//		return commonService.savePolicy(requestXml);
		return reString;
	}
	
	/**
	 * 供客户端调用的理赔传入方法
	 * @param requestXml
	 * @return
	 */
	@POST
	@Path("/saveClaim")
	@Produces(MediaType.TEXT_PLAIN + ";charset=GBK")
	public String saveClaim(@FormParam("claimManager") String requestXml) {
		System.out.println("进入理赔保存方法");
		return commonService.saveClaim(requestXml);
	}
	
	/**
	 * 供客户端调用的清单传入方法
	 * @param requestXml
	 * @return
	 */
	@POST
	@Path("/saveDetailedList")
	@Produces(MediaType.TEXT_PLAIN + ";charset=GBK")
	public String saveDetailedList(@FormParam("detailedListManager") String requestXml) {
		long startTime=System.currentTimeMillis();
		System.out.println("进入清单保存方法");
		String reString = commonService.saveDetailedList(requestXml);
		long endTime=System.currentTimeMillis();
		System.out.println("清单方法运行时间： "+(startTime-endTime)+"ms");
//		return commonService.saveDetailedList(requestXml);
		return reString;
	}
	
	@GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String webTest() {
        return "测试调用成功";
    }

}