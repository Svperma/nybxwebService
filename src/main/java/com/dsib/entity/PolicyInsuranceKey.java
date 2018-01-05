package com.dsib.entity;

public class PolicyInsuranceKey {
    private String businessNo;

    private String insuredCode;

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo == null ? null : businessNo.trim();
    }

    public String getInsuredCode() {
        return insuredCode;
    }

    public void setInsuredCode(String insuredCode) {
        this.insuredCode = insuredCode == null ? null : insuredCode.trim();
    }
}