package com.dsib.entity;

import java.math.BigDecimal;

public class ClaimInsured extends ClaimInsuredKey {
    private String insuredName;

    private String insuredAddress;

    private String identifyType;

    private String identifyNumber;

    private String phoneNumber;

    private String farmerType;

    private String isPoor;

    private BigDecimal compensationAmount;

    private BigDecimal compensation;

    private BigDecimal insuredAmount;

    private BigDecimal compensationQuantity;

    public ClaimInsured(String insuredName, String insuredAddress,
			String identifyType, String identifyNumber, String phoneNumber,
			String farmerType, String isPoor, BigDecimal compensationAmount,
			BigDecimal compensation, BigDecimal insuredAmount,
			BigDecimal compensationQuantity) {
		super();
		this.insuredName = insuredName;
		this.insuredAddress = insuredAddress;
		this.identifyType = identifyType;
		this.identifyNumber = identifyNumber;
		this.phoneNumber = phoneNumber;
		this.farmerType = farmerType;
		this.isPoor = isPoor;
		this.compensationAmount = compensationAmount;
		this.compensation = compensation;
		this.insuredAmount = insuredAmount;
		this.compensationQuantity = compensationQuantity;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
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
}