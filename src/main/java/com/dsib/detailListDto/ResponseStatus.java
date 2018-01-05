package com.dsib.detailListDto;
/**
 * 响应状态信息responseStatusDto
 * @author Administrator
 *
 */
public class ResponseStatus {
	private String policyNo;//请求保单号
	private String reportNo;//请求报案号
	private String count;//条数
	private String responseCode;//响应码
	private String responseMessage;//响应信息
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
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
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
	@Override
	public String toString() {
		return "ResponseStatus [policyNo=" + policyNo + ", reportNo="
				+ reportNo + ", count=" + count + ", responseCode="
				+ responseCode + ", responseMessage=" + responseMessage + "]";
	}
	public ResponseStatus(String policyNo, String reportNo, String count,
			String responseCode, String responseMessage) {
		super();
		this.policyNo = policyNo;
		this.reportNo = reportNo;
		this.count = count;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	public ResponseStatus() {
		super();
	}
	
}
