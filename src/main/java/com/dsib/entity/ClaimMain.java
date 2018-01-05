package com.dsib.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ClaimMain {
    private String businessNo;

    private String policyNo;

    private String reportNo;

    private String caseNo;

    private String claimsNo;

    private String insuranceType;

    private String riskCode;

    private String policyFlag;

    private String claimStatus;

    private Date startDate;

    private Date endDate;

    private Date happenDate;

    private Date reportDate;

    private Date caseDate;

    private Date payDate;

    private BigDecimal compensationAmount;

    private BigDecimal compensation;

    private BigDecimal insuredAmount;

    private BigDecimal compensationQuantity;

    private String insuranceCode;

    private String province;

    private String city;

    private String county;

    public ClaimMain(String businessNo, String policyNo, String reportNo,
			String caseNo, String claimsNo, String insuranceType,
			String riskCode, String policyFlag, String claimStatus,
			Date startDate, Date endDate, Date happenDate, Date reportDate,
			Date caseDate, Date payDate, BigDecimal compensationAmount,
			BigDecimal compensation, BigDecimal insuredAmount,
			BigDecimal compensationQuantity, String insuranceCode,
			String province, String city, String county) {
		super();
		this.businessNo = businessNo;
		this.policyNo = policyNo;
		this.reportNo = reportNo;
		this.caseNo = caseNo;
		this.claimsNo = claimsNo;
		this.insuranceType = insuranceType;
		this.riskCode = riskCode;
		this.policyFlag = policyFlag;
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
		this.province = province;
		this.city = city;
		this.county = county;
	}

	public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo == null ? null : businessNo.trim();
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo == null ? null : reportNo.trim();
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo == null ? null : caseNo.trim();
    }

    public String getClaimsNo() {
        return claimsNo;
    }

    public void setClaimsNo(String claimsNo) {
        this.claimsNo = claimsNo == null ? null : claimsNo.trim();
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType == null ? null : insuranceType.trim();
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode == null ? null : riskCode.trim();
    }

    public String getPolicyFlag() {
        return policyFlag;
    }

    public void setPolicyFlag(String policyFlag) {
        this.policyFlag = policyFlag == null ? null : policyFlag.trim();
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus == null ? null : claimStatus.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getHappenDate() {
        return happenDate;
    }

    public void setHappenDate(Date happenDate) {
        this.happenDate = happenDate;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Date getCaseDate() {
        return caseDate;
    }

    public void setCaseDate(Date caseDate) {
        this.caseDate = caseDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getCompensationAmount() {
        return compensationAmount;
    }

    public void setCompensationAmount(BigDecimal compensationAmount) {
        this.compensationAmount = compensationAmount;
    }

    public BigDecimal getCompensation() {
        return compensation;
    }

    public void setCompensation(BigDecimal compensation) {
        this.compensation = compensation;
    }

    public BigDecimal getInsuredAmount() {
        return insuredAmount;
    }

    public void setInsuredAmount(BigDecimal insuredAmount) {
        this.insuredAmount = insuredAmount;
    }

    public BigDecimal getCompensationQuantity() {
        return compensationQuantity;
    }

    public void setCompensationQuantity(BigDecimal compensationQuantity) {
        this.compensationQuantity = compensationQuantity;
    }

    public String getInsuranceCode() {
        return insuranceCode;
    }

    public void setInsuranceCode(String insuranceCode) {
        this.insuranceCode = insuranceCode == null ? null : insuranceCode.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }
}