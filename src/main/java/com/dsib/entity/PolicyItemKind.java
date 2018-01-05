package com.dsib.entity;

import java.math.BigDecimal;

public class PolicyItemKind extends PolicyItemKindKey {
    private String itemType;

    private String itemTypeName;

    private String kindCode;

    private String kindName;

    private String unit;

    private BigDecimal quantity;

    private BigDecimal unitAmount;

    private BigDecimal amount;

    private BigDecimal insuranceRates;

    private BigDecimal premium;

    private String flag;

    public PolicyItemKind() {
		super();
	}

	public PolicyItemKind(String itemType, String itemTypeName,
			String kindCode, String kindName, String unit, BigDecimal quantity,
			BigDecimal unitAmount, BigDecimal amount,
			BigDecimal insuranceRates, BigDecimal premium, String flag) {
		super();
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

	public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName == null ? null : itemTypeName.trim();
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode == null ? null : kindCode.trim();
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName == null ? null : kindName.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(BigDecimal unitAmount) {
        this.unitAmount = unitAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getInsuranceRates() {
        return insuranceRates;
    }

    public void setInsuranceRates(BigDecimal insuranceRates) {
        this.insuranceRates = insuranceRates;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }
}