package com.dsib.claimDto;
/**
 * 响应状态信息responseStatusDto
 * @author Administrator
 *
 */
public class ResponseStatus {
	private String policyNo;//请求保单号
	private String reportNo;//请求报案号
	private String responseCode;//响应码
	private String responseMessage;//响应信息
	
	@Override
	public String toString() {
		return "ResponseStatus [policyNo=" + policyNo + ", reportNo="
				+ reportNo + ", responseCode=" + responseCode
				+ ", responseMessage=" + responseMessage + "]";
	}
	public ResponseStatus() {
		super();
	}
	/**
	 * 全参构造
	 * @param policyNo
	 * @param reportNo
	 * @param responseCode
	 * @param responseMessage
	 */
	public ResponseStatus(String policyNo, String reportNo,
			String responseCode, String responseMessage) {
		super();
		this.policyNo = policyNo;
		this.reportNo = reportNo;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getReportNo() {
		return reportNo;
	}
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
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
