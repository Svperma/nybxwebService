package com.dsib.claimDto;
/**
 * 理赔基本信息MainDTO
 * @author Administrator
 *
 */
public class Main {
	private String policyNo;//保单号
	private String reportNo;//报案号
	private String caseNo;//结案号
	private String claimsNo;//赔案号
	private String insuranceType;//保险类型
	private String riskCode;//险种代码
	private String policyFlag;//是否政策性保险
	private String isPoor;//是否建档立卡贫困户
	private String claimStatus;//理赔状态
	private String startDate;//起保日期
	private String endDate;//终保日期
	private String happenDate;//出险日期
	private String reportDate;//报案日期
	private String caseDate;//结案日期
	private String payDate;//支付日期
	private String compensationAmount;//总赔付金额
	private String compensation;//已赔付金额
	private String insuredAmount;//承保数量
	private String compensationQuantity;//赔付数量
	private String insuranceCode;//保险公司代码
	private String province;//	省
	private String city;//	市
	private String county;//	区县
	
	@Override
	public String toString() {
		return "Main [policyNo=" + policyNo + ", reportNo=" + reportNo
				+ ", caseNo=" + caseNo + ", claimsNo=" + claimsNo
				+ ", insuranceType=" + insuranceType + ", riskCode=" + riskCode
				+ ", policyFlag=" + policyFlag + ", isPoor=" + isPoor
				+ ", claimStatus=" + claimStatus + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", happenDate=" + happenDate
				+ ", reportDate=" + reportDate + ", caseDate=" + caseDate
				+ ", payDate=" + payDate + ", compensationAmount="
				+ compensationAmount + ", compensation=" + compensation
				+ ", insuredAmount=" + insuredAmount
				+ ", compensationQuantity=" + compensationQuantity
				+ ", insuranceCode=" + insuranceCode + "]";
	}

	/**
	 * 全参构造
	 * @param policyNo
	 * @param reportNo
	 * @param caseNo
	 * @param claimsNo
	 * @param insuranceType
	 * @param riskCode
	 * @param policyFlag
	 * @param isPoor
	 * @param claimStatus
	 * @param startDate
	 * @param endDate
	 * @param happenDate
	 * @param reportDate
	 * @param caseDate
	 * @param payDate
	 * @param compensationAmount
	 * @param compensation
	 * @param insuredAmount
	 * @param compensationQuantity
	 * @param insuranceCode
	 */
	public Main(String policyNo, String reportNo, String caseNo,
			String claimsNo, String insuranceType, String riskCode,
			String policyFlag, String isPoor, String claimStatus,
			String startDate, String endDate, String happenDate,
			String reportDate, String caseDate, String payDate,
			String compensationAmount, String compensation,
			String insuredAmount, String compensationQuantity,
			String insuranceCode) {
		super();
		this.policyNo = policyNo;
		this.reportNo = reportNo;
		this.caseNo = caseNo;
		this.claimsNo = claimsNo;
		this.insuranceType = insuranceType;
		this.riskCode = riskCode;
		this.policyFlag = policyFlag;
		this.isPoor = isPoor;
		this.claimStatus = claimStatus;
		this.startDate = startDate;
		this.endDate = endDate;
		this.happenDate = happenDate;
		this.reportDate = reportDate;
		this.caseDate = caseDate;
		this.payDate = payDate;
		this.compensationAmount = compensationAmount;
		this.compensation = compensation;
		this.insuredAmount = insuredAmount;
		this.compensationQuantity = compensationQuantity;
		this.insuranceCode = insuranceCode;
	}


	public Main() {
		super();
	}
	
	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
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
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public String getClaimsNo() {
		return claimsNo;
	}
	public void setClaimsNo(String claimsNo) {
		this.claimsNo = claimsNo;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getPolicyFlag() {
		return policyFlag;
	}
	public void setPolicyFlag(String policyFlag) {
		this.policyFlag = policyFlag;
	}
	public String getIsPoor() {
		return isPoor;
	}
	public void setIsPoor(String isPoor) {
		this.isPoor = isPoor;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getHappenDate() {
		return happenDate;
	}
	public void setHappenDate(String happenDate) {
		this.happenDate = happenDate;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public String getCaseDate() {
		return caseDate;
	}
	public void setCaseDate(String caseDate) {
		this.caseDate = caseDate;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getCompensationAmount() {
		return compensationAmount;
	}
	public void setCompensationAmount(String compensationAmount) {
		this.compensationAmount = compensationAmount;
	}
	public String getCompensation() {
		return compensation;
	}
	public void setCompensation(String compensation) {
		this.compensation = compensation;
	}
	public String getInsuredAmount() {
		return insuredAmount;
	}
	public void setInsuredAmount(String insuredAmount) {
		this.insuredAmount = insuredAmount;
	}
	public String getCompensationQuantity() {
		return compensationQuantity;
	}
	public void setCompensationQuantity(String compensationQuantity) {
		this.compensationQuantity = compensationQuantity;
	}

	public String getInsuranceCode() {
		return insuranceCode;
	}

	public void setInsuranceCode(String insuranceCode) {
		this.insuranceCode = insuranceCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}
	
}
