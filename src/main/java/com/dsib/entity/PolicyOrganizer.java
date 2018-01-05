package com.dsib.entity;

public class PolicyOrganizer {
    private String businessNo;

    private String organizerName;

    private String organizerAddress;

    private String identifyType;

    private String identifyNumber;

    private String postCode;

    private String contactName;

    private String phoneNumber;

    public PolicyOrganizer() {
		super();
	}

	public PolicyOrganizer(String businessNo, String organizerName,
			String organizerAddress, String identifyType,
			String identifyNumber, String postCode, String contactName,
			String phoneNumber) {
		super();
		this.businessNo = businessNo;
		this.organizerName = organizerName;
		this.organizerAddress = organizerAddress;
		this.identifyType = identifyType;
		this.identifyNumber = identifyNumber;
		this.postCode = postCode;
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
	}

	public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo == null ? null : businessNo.trim();
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName == null ? null : organizerName.trim();
    }

    public String getOrganizerAddress() {
        return organizerAddress;
    }

    public void setOrganizerAddress(String organizerAddress) {
        this.organizerAddress = organizerAddress == null ? null : organizerAddress.trim();
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

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }
}