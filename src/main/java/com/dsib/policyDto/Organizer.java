package com.dsib.policyDto;


/**
 * 投保组织者信息OrganizerDTO
 * @author Administrator
 *
 */
public class Organizer {
	private String organizerName;//投保组织者名称
	private String organizerAddress;//投保组织者地址
	private String identifyType;//投保组织者证件类型
	private String identifyNumber;//投保组织者证件号码
	private String postCode;//投保组织者邮编
	private String contactName;//联系人姓名
	private String phoneNumber;//联系人联系电话
	
	@Override
	public String toString() {
		return "organizer [organizerName=" + organizerName
				+ ", organizerAddress=" + organizerAddress + ", identifyType="
				+ identifyType + ", identifyNumber=" + identifyNumber
				+ ", postCode=" + postCode + ", contactName=" + contactName
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	public Organizer() {
		super();
	}
	
	/**
	 * 全参构造函数
	 * @param organizerName
	 * @param organizerAddress
	 * @param identifyType
	 * @param identifyNumber
	 * @param postCode
	 * @param contactName
	 * @param phoneNumber
	 */
	public Organizer(String organizerName, String organizerAddress,
			String identifyType, String identifyNumber, String postCode,
			String contactName, String phoneNumber) {
		super();
		this.organizerName = organizerName;
		this.organizerAddress = organizerAddress;
		this.identifyType = identifyType;
		this.identifyNumber = identifyNumber;
		this.postCode = postCode;
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
	}
	public String getOrganizerName() {
		return organizerName;
	}
	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}
	public String getOrganizerAddress() {
		return organizerAddress;
	}
	public void setOrganizerAddress(String organizerAddress) {
		this.organizerAddress = organizerAddress;
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
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
