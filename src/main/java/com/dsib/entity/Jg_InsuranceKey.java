package com.dsib.entity;

public class Jg_InsuranceKey {
    private String policyno;

    private String serialno;

	public Jg_InsuranceKey() {
		super();
	}

	public Jg_InsuranceKey(String policyno) {
		super();
		this.policyno = policyno;
	}

	public String getPolicyno() {
        return policyno;
    }

    public void setPolicyno(String policyno) {
        this.policyno = policyno == null ? null : policyno.trim();
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno == null ? null : serialno.trim();
    }
}