package com.dsib.policyDto;


/**
 * 险别信息ItemKindDTO
 * @author Administrator
 *
 */
public class ItemKind {
	private String itemKindNo;//险别序号
	private String itemType;//保险标的项目
	private String itemTypeName;//保险标的具体项目
	private String kindCode;//险别代码
	private String kindName;//险别名称
	private String unit;//单位
	private String quantity;//保险数量
	private String unitAmount;//单位保险金额
	private String amount;//保险金额
	private String insuranceRates;//保险费率
	private String premium;//保险费
	private String flag;//标志位
	
	@Override
	public String toString() {
		return "itemKind [itemKindNo=" + itemKindNo + ", itemType=" + itemType
				+ ", itemTypeName=" + itemTypeName + ", kindCode=" + kindCode
				+ ", kindName=" + kindName + ", unit=" + unit + ", quantity="
				+ quantity + ", unitAmount=" + unitAmount + ", amount="
				+ amount + ", insuranceRates=" + insuranceRates + ", premium="
				+ premium + ", flag=" + flag + "]";
	}

	public ItemKind() {
		super();
	}
	
	/**
	 * 全参构造函数
	 * @param itemKindNo
	 * @param itemType
	 * @param itemTypeName
	 * @param kindCode
	 * @param kindName
	 * @param unit
	 * @param quantity
	 * @param unitAmount
	 * @param amount
	 * @param insuranceRates
	 * @param premium
	 * @param flag
	 */
	public ItemKind(String itemKindNo, String itemType, String itemTypeName,
			String kindCode, String kindName, String unit, String quantity,
			String unitAmount, String amount, String insuranceRates,
			String premium, String flag) {
		super();
		this.itemKindNo = itemKindNo;
		this.itemType = itemType;
		this.itemTypeName = itemTypeName;
		this.kindCode = kindCode;
		this.kindName = kindName;
		this.unit = unit;
		this.quantity = quantity;
		this.unitAmount = unitAmount;
		this.amount = amount;
		this.insuranceRates = insuranceRates;
		this.premium = premium;
		this.flag = flag;
	}
	public String getItemKindNo() {
		return itemKindNo;
	}
	public void setItemKindNo(String itemKindNo) {
		this.itemKindNo = itemKindNo;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemTypeName() {
		return itemTypeName;
	}
	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}
	public String getKindCode() {
		return kindCode;
	}
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnitAmount() {
		return unitAmount;
	}
	public void setUnitAmount(String unitAmount) {
		this.unitAmount = unitAmount;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getInsuranceRates() {
		return insuranceRates;
	}
	public void setInsuranceRates(String insuranceRates) {
		this.insuranceRates = insuranceRates;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
