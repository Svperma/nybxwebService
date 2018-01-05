package com.dsib.entity;

public class PolicyItemKindKey {
    private String businessNo;

    private String itemKindNo;

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo == null ? null : businessNo.trim();
    }

    public String getItemKindNo() {
        return itemKindNo;
    }

    public void setItemKindNo(String itemKindNo) {
        this.itemKindNo = itemKindNo == null ? null : itemKindNo.trim();
    }
}