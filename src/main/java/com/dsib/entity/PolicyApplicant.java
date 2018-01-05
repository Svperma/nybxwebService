package com.dsib.entity;

import java.util.Date;

public class PolicyApplicant {
    private String businessNo;

    private String appliName;

    private String appliAddress;

    private String identifyType;

    private String identifyNumber;

    private Date birthDay;

    private String age;

    private String sex;

    private String insuredIdentity;

    private String postCode;

    private String phoneNumber;

    private String insuredType;

    public PolicyApplicant() {
		super();
	}

	public PolicyApplicant(String businessNo, String appliName,
			String appliAddress, String identifyType, String identifyNumber,
			Date birthDay, String age, String sex, String insuredIdentity,
			String postCode, String phoneNumber, String insuredType) {
		super();
		this.businessNo = businessNo;
		this.appliName = appliName;
		this.appliAddress = appliAddress;
		this.identifyType = identifyType;
		this.identifyNumber = identifyNumber;
		this.birthDay = birthDay;
		this.age = age;
		this.sex = sex;
		this.insuredIdentity = insuredIdentity;
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

    public String getAppliName() {
        return appliName;
    }

    public void setAppliName(String appliName) {
        this.appliName = appliName == null ? null : appliName.trim();
    }

    public String getAppliAddress() {
        return appliAddress;
    }

    public void setAppliAddress(String appliAddress) {
        this.appliAddress = appliAddress == null ? null : appliAddress.trim();
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

    public String getInsuredIdentity() {
        return insuredIdentity;
    }

    public void setInsuredIdentity(String insuredIdentity) {
        this.insuredIdentity = insuredIdentity == null ? null : insuredIdentity.trim();
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