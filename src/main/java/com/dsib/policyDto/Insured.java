package com.dsib.policyDto;
/**
 * 被保险人信息InsuredDTO
 */
public class Insured {
	private String insuredCode;
	private String insuredName;
	private String appliIdentity;
	private String insuredAddress;
	private String identifyType;
	private String identifyNumber;
	private String birthday;
	private String age;
	private String sex;
	private String postCode;
	private String phoneNumber;
	private String insuredType;
	
	@Override
	public String toString() {
		return "Insured [insuredCode=" + insuredCode + ", insuredName="
				+ insuredName + ", appliIdentity=" + appliIdentity
				+ ", insuredAddress=" + insuredAddress + ", identifyType="
				+ identifyType + ", identifyNumber=" + identifyNumber
				+ ", birthday=" + birthday + ", age=" + age + ", sex=" + sex
				+ ", postCode=" + postCode + ", phoneNumber=" + phoneNumber
				+ ", insuredType=" + insuredType + "]";
	}
	public Insured() {
		super();
	}
	/**
	 * 全参构造
	 * @param insuredCode
	 * @param insuredName
	 * @param appliIdentity
	 * @param insuredAddress
	 * @param identifyType
	 * @param identifyNumber
	 * @param birthday
	 * @param age
	 * @param sex
	 * @param postCode
	 * @param phoneNumber
	 * @param insuredType
	 */
	public Insured(String insuredCode, String insuredName,
			String appliIdentity, String insuredAddress, String identifyType,
			String identifyNumber, String birthday, String age, String sex,
			String postCode, String phoneNumber, String insuredType) {
		super();
		this.insuredCode = insuredCode;
		this.insuredName = insuredName;
		this.appliIdentity = appliIdentity;
		this.insuredAddress = insuredAddress;
		this.identifyType = identifyType;
		this.identifyNumber = identifyNumber;
		this.birthday = birthday;
		this.age = age;
		this.sex = sex;
		this.postCode = postCode;
		this.phoneNumber = phoneNumber;
		this.insuredType = insuredType;
	}
	public String getInsuredCode() {
		return insuredCode;
	}
	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getAppliIdentity() {
		return appliIdentity;
	}
	public void setAppliIdentity(String appliIdentity) {
		this.appliIdentity = appliIdentity;
	}
	public String getInsuredAddress() {
		return insuredAddress;
	}
	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
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
