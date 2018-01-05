package com.dsib.entity;

import java.math.BigDecimal;

public class PolicyInsurance extends PolicyInsuranceKey {
    private String insuredName;

    private String insuredAddress;

    private String phoneNumber;

    private String identifyType;

    private String identifyNumber;

    private String insuredQuantity;

    private String farmerType;

    private String isPoor;

    private String bank;

    private String cardNo;

    private BigDecimal amount;

    private BigDecimal premium;

    private BigDecimal centralAllowance;

    private BigDecimal provinceAllowance;

    private BigDecimal cityAllowance;

    private BigDecimal countyAllowance;

    private BigDecimal personAllowance;

    private BigDecimal ohterAllowance;

    
    public PolicyInsurance() {
		super();
	}

	public PolicyInsurance(String insuredName, String insuredAddress,
			String phoneNumber, String identifyType, String identifyNumber,
			String insuredQuantity, String farmerType, String isPoor,
			String bank, String cardNo, BigDecimal amount, BigDecimal premium,
			BigDecimal centralAllowance, BigDecimal provinceAllowance,
			BigDecimal cityAllowance, BigDecimal countyAllowance,
			BigDecimal personAllowance, BigDecimal ohterAllowance) {
		super();
		this.insuredName = insuredName;
		this.insuredAddress = insuredAddress;
		this.phoneNumber = phoneNumber;
		this.identifyType = identifyType;
		this.identifyNumber = identifyNumber;
		this.insuredQuantity = insuredQuantity;
		this.farmerType = farmerType;
		this.isPoor = isPoor;
		this.bank = bank;
		this.cardNo = cardNo;
		this.amount = amount;
		this.premium = premium;
		this.centralAllowance = centralAllowance;
		this.provinceAllowance = provinceAllowance;
		this.cityAllowance = cityAllowance;
		this.countyAllowance = countyAllowance;
		this.personAllowance = personAllowance;
		this.ohterAllowance = ohterAllowance;
	}

	public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName == null ? null : insuredName.trim();
    }

    public String getInsuredAddress() {
        return insuredAddress;
    }

    public void setInsuredAddress(String insuredAddress) {
        this.insuredAddress = insuredAddress == null ? null : insuredAddress.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getIdentifyType() {
        return identifyType;
    }

    public void setIdentifyType(String identifyType) {
        this.identifyType = identifyType == null ? null : identifyType.trim();
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber == null ? null : identifyNumber.trim();
    }

    public String getInsuredQuantity() {
        return insuredQuantity;
    }

    public void setInsuredQuantity(String insuredQuantity) {
        this.insuredQuantity = insuredQuantity == null ? null : insuredQuantity.trim();
    }

    public String getFarmerType() {
        return farmerType;
    }

    public void setFarmerType(String farmerType) {
        this.farmerType = farmerType == null ? null : farmerType.trim();
    }

    public String getIsPoor() {
        return isPoor;
    }

    public void setIsPoor(String isPoor) {
        this.isPoor = isPoor == null ? null : isPoor.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
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

    public BigDecimal getOhterAllowance() {
        return ohterAllowance;
    }

    public void setOhterAllowance(BigDecimal ohterAllowance) {
        this.ohterAllowance = ohterAllowance;
    }
}