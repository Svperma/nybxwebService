package com.dsib.policyDto;


/**
 * 投保人信息ApplicantDTO
 * @author Administrator
 *
 */
public class Applicant {
	private String appliName;//投保人姓名
	private String appliAddress;//投保人联系地址
	private String identifyType;//投保人证件类型
	private String identifyNumber;//投保人证件号码
	private String birthday;//投保人出生日期
	private String age;//投保人年龄
	private String sex;//投保人性别
	private String insuredIdentity;//与被保险人关系
	private String postCode;//投保人邮编
	private String phoneNumber;//投保人联系电话
	private String insuredType;//关系人类型
	
 	@Override
	public String toString() {
		return "applicant [appliName=" + appliName + ", appliAddress="
				+ appliAddress + ", identifyType=" + identifyType
				+ ", identifyNumber=" + identifyNumber + ", birthday="
				+ birthday + ", age=" + age + ", sex=" + sex
				+ ", insuredIdentity=" + insuredIdentity + ", postCode="
				+ postCode + ", phoneNumber=" + phoneNumber + ", insuredType="
				+ insuredType + "]";
	}

	public Applicant() {
		super();
	}
	
	/**
	 * 全参构造函数
	 * @param appliName
	 * @param appliAddress
	 * @param identifyType
	 * @param identifyNumber
	 * @param birthday
	 * @param age
	 * @param sex
	 * @param insuredIdentity
	 * @param postCode
	 * @param phoneNumber
	 * @param insuredType
	 */
	public Applicant(String appliName, String appliAddress,
			String identifyType, String identifyNumber, String birthday,
			String age, String sex, String insuredIdentity, String postCode,
			String phoneNumber, String insuredType) {
		super();
		this.appliName = appliName;
		this.appliAddress = appliAddress;
		this.identifyType = identifyType;
		this.identifyNumber = identifyNumber;
		this.birthday = birthday;
		this.age = age;
		this.sex = sex;
		this.insuredIdentity = insuredIdentity;
		this.postCode = postCode;
		this.phoneNumber = phoneNumber;
		this.insuredType = insuredType;
	}
	public String getAppliName() {
		return appliName;
	}
	public void setAppliName(String appliName) {
		this.appliName = appliName;
	}
	public String getAppliAddress() {
		return appliAddress;
	}
	public void setAppliAddress(String appliAddress) {
		this.appliAddress = appliAddress;
	}
	public String getIdentifyType() {
		return identifyType;
	}
	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getInsuredIdentity() {
		return insuredIdentity;
	}
	public void setInsuredIdentity(String insuredIdentity) {
		this.insuredIdentity = insuredIdentity;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getInsuredType() {
		return insuredType;
	}
	public void setInsuredType(String insuredType) {
		this.insuredType = insuredType;
	}
	
}
