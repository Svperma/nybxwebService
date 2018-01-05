package com.dsib.entity;

import java.util.Date;

public class PolicyInsured {
    private String businessNo;

    private String insuredCode;

    private String insuredName;

    private String appliiDentity;

    private String insuredAddress;

    private String identifyType;

    private String identifyNumber;

    private Date birthDay;

    private String age;

    private String sex;

    private String postCode;

    private String phoneNumber;

    private String insuredType;

    public PolicyInsured() {
		super();
	}

	public PolicyInsured(String businessNo, String insuredCode,
			String insuredName, String appliiDentity, String insuredAddress,
			String identifyType, String identifyNumber, Date birthDay,
			String age, String sex, String postCode, String phoneNumber,
			String insuredType) {
		super();
		this.businessNo = businessNo;
		this.insuredCode = insuredCode;
		this.insuredName = insuredName;
		this.appliiDentity = appliiDentity;
		this.insuredAddress = insuredAddress;
		this.identifyType = identifyType;
		this.identifyNumber = identifyNumber;
		this.birthDay = birthDay;
		this.age = age;
		this.sex = sex;
		this.postCode = postCode;
		this.phoneNumber = phoneNumber;
		this.insuredType = insuredType;
	}

	public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo == null ? null : businessNo.trim();
    }

    public String getInsuredCode() {
        return insuredCode;
    }

    public void setInsuredCode(String insuredCode) {
        this.insuredCode = insuredCode == null ? null : insuredCode.trim();
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName == null ? null : insuredName.trim();
    }

    public String getAppliiDentity() {
        return appliiDentity;
    }

    public void setAppliiDentity(String appliiDentity) {
        this.appliiDentity = appliiDentity == null ? null : appliiDentity.trim();
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getInsuredType() {
        return insuredType;
    }

    public void setInsuredType(String insuredType) {
        this.insuredType = insuredType == null ? null : insuredType.trim();
    }
}