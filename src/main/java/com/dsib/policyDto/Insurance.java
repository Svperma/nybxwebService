package com.dsib.policyDto;
/**
 *投保清单信息InsuranceDTO
 */
public class Insurance {
	private String insuredCode;	//	序号
	private String insuredName;	//	被保险人姓名
	private String insuredAddress;	//	被保险人联系地址
	private String phoneNumber;	//	被保险人联系电话
	private String identifyType;	//	被保险人证件类型
	private String identifyNumber;	//	被保险人证件号码
	private String insuredQuantity;	//	投保数量
	private String farmerType;	//	农户类型
	private String isPoor;	//	是否建档立卡贫苦户
	private String bank	;//	“一卡通”开户行
	private String cardNo;	//	“一卡通”账号
	private String amount;	//	保额
	private String premium;	//	保费
	private String centralAllowance;	//	中央财政补贴额
	private String provinceAllowance;	//	省级财政补贴额
	private String cityAllowance;	//	地市财政补贴额
	private String countyAllowance;	//	县区财政补贴额
	private String personAllowance;	//	用户自交
	private String ohterAllowance;	//	其他
	
	@Override
	public String toString() {
		return "Insurance [insuredCode=" + insuredCode + ", insuredName="
				+ insuredName + ", insuredAddress=" + insuredAddress
				+ ", phoneNumber=" + phoneNumber + ", identifyType="
				+ identifyType + ", identifyNumber=" + identifyNumber
				+ ", insuredQuantity=" + insuredQuantity + ", farmerType="
				+ farmerType + ", isPoor=" + isPoor + ", bank=" + bank
				+ ", cardNo=" + cardNo + ", amount=" + amount + ", premium="
				+ premium + ", centralAllowance=" + centralAllowance
				+ ", provinceAllowance=" + provinceAllowance
				+ ", cityAllowance=" + cityAllowance + ", countyAllowance="
				+ countyAllowance + ", personAllowance=" + personAllowance
				+ ", ohterAllowance=" + ohterAllowance + "]";
	}
	public Insurance() {
		super();
	}
	/**
	 * 全参构造
	 * @param insuredCode
	 * @param insuredName
	 * @param insuredAddress
	 * @param phoneNumber
	 * @param identifyType
	 * @param identifyNumber
	 * @param insuredQuantity
	 * @param farmerType
	 * @param isPoor
	 * @param bank
	 * @param cardNo
	 * @param amount
	 * @param premium
	 * @param centralAllowance
	 * @param provinceAllowance
	 * @param cityAllowance
	 * @param countyAllowance
	 * @param personAllowance
	 * @param ohterAllowance
	 */
	public Insurance(String insuredCode, String insuredName,
			String insuredAddress, String phoneNumber, String identifyType,
			String identifyNumber, String insuredQuantity, String farmerType,
			String isPoor, String bank, String cardNo, String amount,
			String premium, String centralAllowance, String provinceAllowance,
			String cityAllowance, String countyAllowance,
			String personAllowance, String ohterAllowance) {
		super();
		this.insuredCode = insuredCode;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public String getInsuredQuantity() {
		return insuredQuantity;
	}
	public void setInsuredQuantity(String insuredQuantity) {
		this.insuredQuantity = insuredQuantity;
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
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	public String getCentralAllowance() {
		return centralAllowance;
	}
	public void setCentralAllowance(String centralAllowance) {
		this.centralAllowance = centralAllowance;
	}
	public String getProvinceAllowance() {
		return provinceAllowance;
	}
	public void setProvinceAllowance(String provinceAllowance) {
		this.provinceAllowance = provinceAllowance;
	}
	public String getCityAllowance() {
		return cityAllowance;
	}
	public void setCityAllowance(String cityAllowance) {
		this.cityAllowance = cityAllowance;
	}
	public String getCountyAllowance() {
		return countyAllowance;
	}
	public void setCountyAllowance(String countyAllowance) {
		this.countyAllowance = countyAllowance;
	}
	public String getPersonAllowance() {
		return personAllowance;
	}
	public void setPersonAllowance(String personAllowance) {
		this.personAllowance = personAllowance;
	}
	public String getOhterAllowance() {
		return ohterAllowance;
	}
	public void setOhterAllowance(String ohterAllowance) {
		this.ohterAllowance = ohterAllowance;
	}
	
}
