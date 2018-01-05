package com.dsib.entity;

public class DetailedList extends DetailedListKey {
    private String checkType;

    private String checkFlag;

    private String policyNo;

    private String reportNo;

    private String insuredName;

    private String insuredAddress;

    private String identifyType;

    private String identifyNumber;

    private String phoneNumber;

    private String farmerType;

    private String isPoor;

    private String insuredQuantity;

    private String bank;

    private String cardNo;

    private String amount;

    private String premium;

    private String centralAllowance;

    private String provinceAllowance;

    private String cityAllowance;

    private String countyAllowance;

    private String personAllowance;

    private String ohterAllowance;

    private String compensationAmount;

    private String compensation;

    private String compensationQuantity;

    public DetailedList() {
		super();
	}

	public DetailedList(String checkType, String checkFlag, String policyNo,
			String reportNo, String insuredName, String insuredAddress,
			String identifyType, String identifyNumber, String phoneNumber,
			String farmerType, String isPoor, String insuredQuantity,
			String bank, String cardNo, String amount, String premium,
			String centralAllowance, String provinceAllowance,
			String cityAllowance, String countyAllowance,
			String personAllowance, String ohterAllowance,
			String compensationAmount, String compensation,
			String compensationQuantity) {
		super();
		this.checkType = checkType;
		this.checkFlag = checkFlag;
		this.policyNo = policyNo;
		this.reportNo = reportNo;
		this.insuredName = insuredName;
		this.insuredAddress = insuredAddress;
		this.identifyType = identifyType;
		this.identifyNumber = identifyNumber;
		this.phoneNumber = phoneNumber;
		this.farmerType = farmerType;
		this.isPoor = isPoor;
		this.insuredQuantity = insuredQuantity;
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
		this.compensationAmount = compensationAmount;
		this.compensation = compensation;
		this.compensationQuantity = compensationQuantity;
	}

	public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType == null ? null : checkType.trim();
    }

    public String getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag == null ? null : checkFlag.trim();
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

    public String getInsuredQuantity() {
        return insuredQuantity;
    }

    public void setInsuredQuantity(String insuredQuantity) {
        this.insuredQuantity = insuredQuantity == null ? null : insuredQuantity.trim();
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium == null ? null : premium.trim();
    }

    public String getCentralAllowance() {
        return centralAllowance;
    }

    public void setCentralAllowance(String centralAllowance) {
        this.centralAllowance = centralAllowance == null ? null : centralAllowance.trim();
    }

    public String getProvinceAllowance() {
        return provinceAllowance;
    }

    public void setProvinceAllowance(String provinceAllowance) {
        this.provinceAllowance = provinceAllowance == null ? null : provinceAllowance.trim();
    }

    public String getCityAllowance() {
        return cityAllowance;
    }

    public void setCityAllowance(String cityAllowance) {
        this.cityAllowance = cityAllowance == null ? null : cityAllowance.trim();
    }

    public String getCountyAllowance() {
        return countyAllowance;
    }

    public void setCountyAllowance(String countyAllowance) {
        this.countyAllowance = countyAllowance == null ? null : countyAllowance.trim();
    }

    public String getPersonAllowance() {
        return personAllowance;
    }

    public void setPersonAllowance(String personAllowance) {
        this.personAllowance = personAllowance == null ? null : personAllowance.trim();
    }

    public String getOhterAllowance() {
        return ohterAllowance;
    }

    public void setOhterAllowance(String ohterAllowance) {
        this.ohterAllowance = ohterAllowance == null ? null : ohterAllowance.trim();
    }

    public String getCompensationAmount() {
        return compensationAmount;
    }

    public void setCompensationAmount(String compensationAmount) {
        this.compensationAmount = compensationAmount == null ? null : compensationAmount.trim();
    }

    public String getCompensation() {
        return compensation;
    }

    public void setCompensation(String compensation) {
        this.compensation = compensation == null ? null : compensation.trim();
    }

    public String getCompensationQuantity() {
        return compensationQuantity;
    }

    public void setCompensationQuantity(String compensationQuantity) {
        this.compensationQuantity = compensationQuantity == null ? null : compensationQuantity.trim();
    }
}