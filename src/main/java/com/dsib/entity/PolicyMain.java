package com.dsib.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PolicyMain {
    private String businessNo;

    private String policyNo;

    private String insuranceType;

    private String riskCode;

    private String policyFlag;

    private Date startDate;

    private Date endDate;

    private String arguesolution;

    private String arbitboardName;

    private String insuredCount;

    private String insuredQuantity;

    private BigDecimal sumAmount;

    private BigDecimal sumPremium;

    private String policyType;

    private Date signDate;

    private String specialProvisions;

    private String insurerCode;

    private BigDecimal centralAllowance;

    private BigDecimal provinceAllowance;

    private BigDecimal cityAllowance;

    private BigDecimal countyAllowance;

    private BigDecimal personAllowance;

    private BigDecimal otherAllowance;

    private String province;

    private String city;

    private String county;

    private String town;

    public PolicyMain() {
		super();
	}

	public PolicyMain(String businessNo, String policyNo, String insuranceType,
			String riskCode, String policyFlag, Date startDate, Date endDate,
			String arguesolution, String arbitboardName, String insuredCount,
			String insuredQuantity, BigDecimal sumAmount,
			BigDecimal sumPremium, String policyType, Date signDate,
			String specialProvisions, String insurerCode,
			BigDecimal centralAllowance, BigDecimal provinceAllowance,
			BigDecimal cityAllowance, BigDecimal countyAllowance,
			BigDecimal personAllowance, BigDecimal otherAllowance,
			String province, String city, String county, String town) {
		super();
		this.businessNo = businessNo;
		this.policyNo = policyNo;
		this.insuranceType = insuranceType;
		this.riskCode = riskCode;
		this.policyFlag = policyFlag;
		this.startDate = startDate;
		this.endDate = endDate;
		this.arguesolution = arguesolution;
		this.arbitboardName = arbitboardName;
		this.insuredCount = insuredCount;
		this.insuredQuantity = insuredQuantity;
		this.sumAmount = sumAmount;
		this.sumPremium = sumPremium;
		this.policyType = policyType;
		this.signDate = signDate;
		this.specialProvisions = specialProvisions;
		this.insurerCode = insurerCode;
		this.centralAllowance = centralAllowance;
		this.provinceAllowance = provinceAllowance;
		this.cityAllowance = cityAllowance;
		this.countyAllowance = countyAllowance;
		this.personAllowance = personAllowance;
		this.otherAllowance = otherAllowance;
		this.province = province;
		this.city = city;
		this.county = county;
		this.town = town;
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

    public String getArguesolution() {
        return arguesolution;
    }

    public void setArguesolution(String arguesolution) {
        this.arguesolution = arguesolution == null ? null : arguesolution.trim();
    }

    public String getArbitboardName() {
        return arbitboardName;
    }

    public void setArbitboardName(String arbitboardName) {
        this.arbitboardName = arbitboardName == null ? null : arbitboardName.trim();
    }

    public String getInsuredCount() {
        return insuredCount;
    }

    public void setInsuredCount(String insuredCount) {
        this.insuredCount = insuredCount == null ? null : insuredCount.trim();
    }

    public String getInsuredQuantity() {
        return insuredQuantity;
    }

    public void setInsuredQuantity(String insuredQuantity) {
        this.insuredQuantity = insuredQuantity == null ? null : insuredQuantity.trim();
    }

    public BigDecimal getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(BigDecimal sumAmount) {
        this.sumAmount = sumAmount;
    }

    public BigDecimal getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(BigDecimal sumPremium) {
        this.sumPremium = sumPremium;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType == null ? null : policyType.trim();
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getSpecialProvisions() {
        return specialProvisions;
    }

    public void setSpecialProvisions(String specialProvisions) {
        this.specialProvisions = specialProvisions == null ? null : specialProvisions.trim();
    }

    public String getInsurerCode() {
        return insurerCode;
    }

    public void setInsurerCode(String insurerCode) {
        this.insurerCode = insurerCode == null ? null : insurerCode.trim();
    }

    public BigDecimal getCentralAllowance() {
        return centralAllowance;
    }

    public void setCentralAllowance(BigDecimal centralAllowance) {
        this.centralAllowance = centralAllowance;
    }

    public BigDecimal getProvinceAllowance() {
        return provinceAllowance;
    }

    public void setProvinceAllowance(BigDecimal provinceAllowance) {
        this.provinceAllowance = provinceAllowance;
    }

    public BigDecimal getCityAllowance() {
        return cityAllowance;
    }

    public void setCityAllowance(BigDecimal cityAllowance) {
        this.cityAllowance = cityAllowance;
    }

    public BigDecimal getCountyAllowance() {
        return countyAllowance;
    }

    public void setCountyAllowance(BigDecimal countyAllowance) {
        this.countyAllowance = countyAllowance;
    }

    public BigDecimal getPersonAllowance() {
        return personAllowance;
    }

    public void setPersonAllowance(BigDecimal personAllowance) {
        this.personAllowance = personAllowance;
    }

    public BigDecimal getOtherAllowance() {
        return otherAllowance;
    }

    public void setOtherAllowance(BigDecimal otherAllowance) {
        this.otherAllowance = otherAllowance;
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

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town == null ? null : town.trim();
    }
}