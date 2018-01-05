package com.dsib.entity;

public class Jg_Insurance extends Jg_InsuranceKey {
    private String insuredname;

    private String insuredaddress;

    private String phonenumber;

    private String identifytype;

    private String identifynumber;

    private String insuredquantity;

    private String farmertype;

    private String ispoor;

    private String bank;

    private String cardno;

    private String amount;

    private String premium;

    private String centralallowance;

    private String provinceallowance;

    private String cityallowance;

    private String countyallowance;

    private String personallowance;

    private String ohterallowance;

	public Jg_Insurance() {
		super();
	}

	public Jg_Insurance(String insuredname, String insuredaddress,
			String phonenumber, String identifytype, String identifynumber,
			String insuredquantity, String farmertype, String ispoor,
			String bank, String cardno, String amount, String premium,
			String centralallowance, String provinceallowance,
			String cityallowance, String countyallowance,
			String personallowance, String ohterallowance) {
		super();
		this.insuredname = insuredname;
		this.insuredaddress = insuredaddress;
		this.phonenumber = phonenumber;
		this.identifytype = identifytype;
		this.identifynumber = identifynumber;
		this.insuredquantity = insuredquantity;
		this.farmertype = farmertype;
		this.ispoor = ispoor;
		this.bank = bank;
		this.cardno = cardno;
		this.amount = amount;
		this.premium = premium;
		this.centralallowance = centralallowance;
		this.provinceallowance = provinceallowance;
		this.cityallowance = cityallowance;
		this.countyallowance = countyallowance;
		this.personallowance = personallowance;
		this.ohterallowance = ohterallowance;
	}

	public String getInsuredname() {
        return insuredname;
    }

    public void setInsuredname(String insuredname) {
        this.insuredname = insuredname == null ? null : insuredname.trim();
    }

    public String getInsuredaddress() {
        return insuredaddress;
    }

    public void setInsuredaddress(String insuredaddress) {
        this.insuredaddress = insuredaddress == null ? null : insuredaddress.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getIdentifytype() {
        return identifytype;
    }

    public void setIdentifytype(String identifytype) {
        this.identifytype = identifytype == null ? null : identifytype.trim();
    }

    public String getIdentifynumber() {
        return identifynumber;
    }

    public void setIdentifynumber(String identifynumber) {
        this.identifynumber = identifynumber == null ? null : identifynumber.trim();
    }

    public String getInsuredquantity() {
        return insuredquantity;
    }

    public void setInsuredquantity(String insuredquantity) {
        this.insuredquantity = insuredquantity == null ? null : insuredquantity.trim();
    }

    public String getFarmertype() {
        return farmertype;
    }

    public void setFarmertype(String farmertype) {
        this.farmertype = farmertype == null ? null : farmertype.trim();
    }

    public String getIspoor() {
        return ispoor;
    }

    public void setIspoor(String ispoor) {
        this.ispoor = ispoor == null ? null : ispoor.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium == null ? null : premium.trim();
    }

    public String getCentralallowance() {
        return centralallowance;
    }

    public void setCentralallowance(String centralallowance) {
        this.centralallowance = centralallowance == null ? null : centralallowance.trim();
    }

    public String getProvinceallowance() {
        return provinceallowance;
    }

    public void setProvinceallowance(String provinceallowance) {
        this.provinceallowance = provinceallowance == null ? null : provinceallowance.trim();
    }

    public String getCityallowance() {
        return cityallowance;
    }

    public void setCityallowance(String cityallowance) {
        this.cityallowance = cityallowance == null ? null : cityallowance.trim();
    }

    public String getCountyallowance() {
        return countyallowance;
    }

    public void setCountyallowance(String countyallowance) {
        this.countyallowance = countyallowance == null ? null : countyallowance.trim();
    }

    public String getPersonallowance() {
        return personallowance;
    }

    public void setPersonallowance(String personallowance) {
        this.personallowance = personallowance == null ? null : personallowance.trim();
    }

    public String getOhterallowance() {
        return ohterallowance;
    }

    public void setOhterallowance(String ohterallowance) {
        this.ohterallowance = ohterallowance == null ? null : ohterallowance.trim();
    }
}