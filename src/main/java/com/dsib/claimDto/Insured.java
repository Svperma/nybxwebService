package com.dsib.claimDto;
/**
 * 被保险人信息InsuredDTO
 * @author Administrator
 *
 */
public class Insured {
	private String insuredCode;//序号
	private String insuredName;//被保险人姓名
	private String insuredAddress;//被保险人联系地址
	private String identifyType;//被保险人证件类型
	private String identifyNumber;//被保险人证件号码
	private String phoneNumber;//被保险人联系电话
	private String farmerType;//农户类型
	private String isPoor;//是否建档立卡贫苦户
	private String compensationAmount;//赔付金额
	private String compensation;//已赔付金额	
	private String insuredAmount;//承保数量
	private String compensationQuantity;//	赔付数量
	
	@Override
	public String toString() {
		return "Insured [insuredCode=" + insuredCode + ", insuredName="
				+ insuredName + ", insuredAddress=" + insuredAddress
				+ ", identifyType=" + identifyType + ", identifyNumber="
				+ identifyNumber + ", phoneNumber=" + phoneNumber
				+ ", farmerType=" + farmerType + ", isPoor=" + isPoor
				+ ", compensationAmount=" + compensationAmount
				+ ", compensation=" + compensation + ", insuredAmount="
				+ insuredAmount + ", compensationQuantity="
				+ compensationQuantity + "]";
	}
	public Insured() {
		super();
	}
	/**
	 * 全参构造
	 * @param insuredCode
	 * @param insuredName
	 * @param insuredAddress
	 * @param identifyType
	 * @param identifyNumber
	 * @param phoneNumber
	 * @param farmerType
	 * @param isPoor
	 * @param compensationAmount
	 * @param compensation
	 * @param insuredAmount
	 * @param compensationQuantity
	 */
	public Insured(String insuredCode, String insuredName,
			String insuredAddress, String identifyType, String identifyNumber,
			String phoneNumber, String farmerType, String isPoor,
			String compensationAmount, String compensation,
			String insuredAmount, String compensationQuantity) {
		super();
		this.insuredCode = insuredCode;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFarmerType() {
		return farmerType;
	}
	public void setFarmerType(String farmerType) {
		this.farmerType = farmerType;
	}
	public String getIsPoor() {
		return isPoor;
	}
	public void setIsPoor(String isPoor) {
		this.isPoor = isPoor;
	}
	public String getCompensationAmount() {
		return compensationAmount;
	}
	public void setCompensationAmount(String compensationAmount) {
		this.compensationAmount = compensationAmount;
	}
	public String getCompensation() {
		return compensation;
	}
	public void setCompensation(String compensation) {
		this.compensation = compensation;
	}
	public String getInsuredAmount() {
		return insuredAmount;
	}
	public void setInsuredAmount(String insuredAmount) {
		this.insuredAmount = insuredAmount;
	}
	public String getCompensationQuantity() {
		return compensationQuantity;
	}
	public void setCompensationQuantity(String compensationQuantity) {
		this.compensationQuantity = compensationQuantity;
	}
	
}
