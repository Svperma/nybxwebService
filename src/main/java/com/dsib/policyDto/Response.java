package com.dsib.policyDto;
/**
 * 此类为总类储存处理之后给保险公司返回的数据
 * @author Administrator
 *
 */
public class Response {
	private ResponseStatus responseStatus;

	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	
}
