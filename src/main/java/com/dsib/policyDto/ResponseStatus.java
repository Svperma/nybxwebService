package com.dsib.policyDto;


/**
 * 响应状态信息ResponseStatusDto
 * @author Administrator
 *
 */
public class ResponseStatus {
	private String policyNo;//请求保单号
	private String responseCode;//响应码
	private String responseMessage;//响应信息
	
	@Override
	public String toString() {
		return "ResponseStatus [policyNo=" + policyNo + ", responseCode="
				+ responseCode + ", responseMessage=" + responseMessage + "]";
	}

	public ResponseStatus() {
		super();
	}
	
	/**
	 * 全参构造函数
	 * @param policyNo
	 * @param responseCode
	 * @param responseMessage
	 */
	public ResponseStatus(String policyNo, String responseCode,
			String responseMessage) {
		super();
		this.policyNo = policyNo;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
}
