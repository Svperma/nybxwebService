package com.dsib.policyDto;

/**
 * 保单基本信息MainDTO
 * @author Administrator
 *
 */
public class Main {
	private String policyNo;//保单号
	private String insuranceType;//保险类型
	private String riskCode;//保险类型
	private String policyFlag;//是否政策性保险
	private String startDate;//起保日期
	private String endDate;//终保日期
	private String argueSolution;//争议解决方式
	private String arbitBoardName;//仲裁委员会名称
	private String insuredCount;//投保人数
	private String insuredQuantity;//投保数量
	private String sumAmount;//总保额
	private String sumPremium;//总保费
	private String policyType;//保单类型代码
	private String signDate;//出单日期 
	private String specialProvisions;//特别约定信息
	private String insurerCode;//保险公司代码
	private String centralAllowance;//中央财政补贴额
	private String provinceAllowance;//省级财政补贴额
	private String cityAllowance;//地市财政补贴额
	private String countyAllowance;//县区财政补贴额
	private String personAllowance;//用户自交
	private String otherAllowance;//其他
	private String province;//省
	private String city;//市
	private String county;//区/县
	private String town;// 乡镇
	
	@Override
	public String toString() {
		return "Main [policyNo=" + policyNo + ", insuranceType="
				+ insuranceType + ", riskCode=" + riskCode + ", policyFlag="
				+ policyFlag + ", startDate=" + startDate + ", endDate="
				+ endDate + ", argueSolution=" + argueSolution
				+ ", arbitBoardName=" + arbitBoardName + ", insuredCount="
				+ insuredCount + ", insuredQuantity=" + insuredQuantity
				+ ", sumAmount=" + sumAmount + ", sumPremium=" + sumPremium
				+ ", policyType=" + policyType + ", signDate=" + signDate
				+ ", specialProvisions=" + specialProvisions + ", insurerCode="
				+ insurerCode + ", centralAllowance=" + centralAllowance
				+ ", provinceAllowance=" + provinceAllowance
				+ ", cityAllowance=" + cityAllowance + ", countyAllowance="
				+ countyAllowance + ", personAllowance=" + personAllowance
				+ ", otherAllowance=" + otherAllowance + ", province="
				+ province + ", city=" + city + ", county=" + county
				+ ", town=" + town + "]";
	}
	public Main() {
		super();
	}
	/**
	 * 	全参构造
	 * @param policyNo
	 * @param insuranceType
	 * @param riskCode
	 * @param policyFlag
	 * @param startDate
	 * @param endDate
	 * @param argueSolution
	 * @param arbitBoardName
	 * @param insuredCount
	 * @param insuredQuantity
	 * @param sumAmount
	 * @param sumPremium
	 * @param policyType
	 * @param signDate
	 * @param specialProvisions
	 * @param insurerCode
	 * @param centralAllowance
	 * @param provinceAllowance
	 * @param cityAllowance
	 * @param countyAllowance
	 * @param personAllowance
	 * @param otherAllowance
	 * @param province
	 * @param city
	 * @param county
	 * @param town
	 */
	public Main(String policyNo, String insuranceType, String riskCode,
			String policyFlag, String startDate, String endDate,
			String argueSolution, String arbitBoardName, String insuredCount,
			String insuredQuantity, String sumAmount, String sumPremium,
			String policyType, String signDate, String specialProvisions,
			String insurerCode, String centralAllowance,
			String provinceAllowance, String cityAllowance,
			String countyAllowance, String personAllowance,
			String otherAllowance, String province, String city, String county,
			String town) {
		super();
		this.policyNo = policyNo;
		this.insuranceType = insuranceType;
		this.riskCode = riskCode;
		this.policyFlag = policyFlag;
		this.startDate = startDate;
		this.endDate = endDate;
		this.argueSolution = argueSolution;
		this.arbitBoardName = arbitBoardName;
		this.insuredCount = insuredCount;
		this.insuredQuantity = insuredQuantity;
		this.sumAmount = sumAmount;
		this.sumPremium = sumPremium;
		this.policyType = policyType;
		this.signDate = signDate;
		this.specialProvisions = specialProvisions;
		this.insurerCode = insurerCode;
		this.centralAllowance = centralAllowance;
		this.provinceAllowance = provinceAllowance;
		this.cityAllowance = cityAllowance;
		this.countyAllowance = countyAllowance;
		this.personAllowance = personAllowance;
		this.otherAllowance = otherAllowance;
		this.province = province;
		this.city = city;
		this.county = county;
		this.town = town;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getPolicyFlag() {
		return policyFlag;
	}
	public void setPolicyFlag(String policyFlag) {
		this.policyFlag = policyFlag;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getArgueSolution() {
		return argueSolution;
	}
	public void setArgueSolution(String argueSolution) {
		this.argueSolution = argueSolution;
	}
	public String getArbitBoardName() {
		return arbitBoardName;
	}
	public void setArbitBoardName(String arbitBoardName) {
		this.arbitBoardName = arbitBoardName;
	}
	public String getInsuredCount() {
		return insuredCount;
	}
	public void setInsuredCount(String insuredCount) {
		this.insuredCount = insuredCount;
	}
	public String getInsuredQuantity() {
		return insuredQuantity;
	}
	public void setInsuredQuantity(String insuredQuantity) {
		this.insuredQuantity = insuredQuantity;
	}
	public String getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(String sumAmount) {
		this.sumAmount = sumAmount;
	}
	public String getSumPremium() {
		return sumPremium;
	}
	public void setSumPremium(String sumPremium) {
		this.sumPremium = sumPremium;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public String getSignDate() {
		return signDate;
	}
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
	public String getSpecialProvisions() {
		return specialProvisions;
	}
	public void setSpecialProvisions(String specialProvisions) {
		this.specialProvisions = specialProvisions;
	}
	public String getInsurerCode() {
		return insurerCode;
	}
	public void setInsurerCode(String insurerCode) {
		this.insurerCode = insurerCode;
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
	public String getOtherAllowance() {
		return otherAllowance;
	}
	public void setOtherAllowance(String otherAllowance) {
		this.otherAllowance = otherAllowance;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	
}
