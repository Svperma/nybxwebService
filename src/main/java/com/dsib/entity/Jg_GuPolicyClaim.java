package com.dsib.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Jg_GuPolicyClaim {
    private String businessno;

    private String riskcode;

    private String insurercode;

    private String reportno;

    private String peino;

    private String policyno;

    private String suppercode;

    private String losscause;

    private String losslocation;

    private Date lossdate;

    private BigDecimal lossamount;

    private BigDecimal allpayamount;

    private Date allpaydate;

    private BigDecimal lossscale;

    private String province;

    private String city;

    private String county;

    private String town;

    private String village;

    private String status;

    private Object flag;

    private Object remark;

    private String updatecode;

    private Date updatetime;

    private String policyflag;

    private String ispoor;

    private String farmertype;

    private String membername;

    private String memberaddress;

    private String identityno;

    private String phonenumber;

    /**
     * 导入模版全字段
     * @param businessno
     * @param riskcode
     * @param insurercode
     * @param reportno
     * @param peino
     * @param policyno
     * @param losscause
     * @param losslocation
     * @param lossdate
     * @param allpayamount
     * @param allpaydate
     * @param lossscale
     * @param province
     * @param city
     * @param county
     * @param status
     * @param updatecode
     * @param updatetime
     * @param policyflag
     * @param ispoor
     * @param farmertype
     * @param membername
     * @param memberaddress
     * @param identityno
     * @param phonenumber
     */
    public Jg_GuPolicyClaim(String businessno, String riskcode,
			String insurercode, String reportno, String peino, String policyno,
			String losscause, String losslocation, Date lossdate,
			BigDecimal allpayamount, Date allpaydate, BigDecimal lossscale,
			String province, String city, String county, String status,
			String updatecode, Date updatetime, String policyflag,
			String ispoor, String farmertype, String membername,
			String memberaddress, String identityno, String phonenumber) {
		super();
		this.businessno = businessno;
		this.riskcode = riskcode;
		this.insurercode = insurercode;
		this.reportno = reportno;
		this.peino = peino;
		this.policyno = policyno;
		this.losscause = losscause;
		this.losslocation = losslocation;
		this.lossdate = lossdate;
		this.allpayamount = allpayamount;
		this.allpaydate = allpaydate;
		this.lossscale = lossscale;
		this.province = province;
		this.city = city;
		this.county = county;
		this.status = status;
		this.updatecode = updatecode;
		this.updatetime = updatetime;
		this.policyflag = policyflag;
		this.ispoor = ispoor;
		this.farmertype = farmertype;
		this.membername = membername;
		this.memberaddress = memberaddress;
		this.identityno = identityno;
		this.phonenumber = phonenumber;
	}

	public Jg_GuPolicyClaim() {
		super();
	}

	public Jg_GuPolicyClaim(String businessno, String riskcode,
			String insurercode, String reportno, String peino, String policyno,
			String suppercode, String losscause, String losslocation,
			Date lossdate, BigDecimal lossamount, BigDecimal allpayamount,
			Date allpaydate, BigDecimal lossscale, String province,
			String city, String county, String town, String village,
			String status, Object flag, Object remark, String updatecode,
			Date updatetime, String policyflag, String ispoor,
			String farmertype, String membername, String memberaddress,
			String identityno, String phonenumber) {
		super();
		this.businessno = businessno;
		this.riskcode = riskcode;
		this.insurercode = insurercode;
		this.reportno = reportno;
		this.peino = peino;
		this.policyno = policyno;
		this.suppercode = suppercode;
		this.losscause = losscause;
		this.losslocation = losslocation;
		this.lossdate = lossdate;
		this.lossamount = lossamount;
		this.allpayamount = allpayamount;
		this.allpaydate = allpaydate;
		this.lossscale = lossscale;
		this.province = province;
		this.city = city;
		this.county = county;
		this.town = town;
		this.village = village;
		this.status = status;
		this.flag = flag;
		this.remark = remark;
		this.updatecode = updatecode;
		this.updatetime = updatetime;
		this.policyflag = policyflag;
		this.ispoor = ispoor;
		this.farmertype = farmertype;
		this.membername = membername;
		this.memberaddress = memberaddress;
		this.identityno = identityno;
		this.phonenumber = phonenumber;
	}

	public String getBusinessno() {
        return businessno;
    }

    public void setBusinessno(String businessno) {
        this.businessno = businessno == null ? null : businessno.trim();
    }

    public String getRiskcode() {
        return riskcode;
    }

    public void setRiskcode(String riskcode) {
        this.riskcode = riskcode == null ? null : riskcode.trim();
    }

    public String getInsurercode() {
        return insurercode;
    }

    public void setInsurercode(String insurercode) {
        this.insurercode = insurercode == null ? null : insurercode.trim();
    }

    public String getReportno() {
        return reportno;
    }

    public void setReportno(String reportno) {
        this.reportno = reportno == null ? null : reportno.trim();
    }

    public String getPeino() {
        return peino;
    }

    public void setPeino(String peino) {
        this.peino = peino == null ? null : peino.trim();
    }

    public String getPolicyno() {
        return policyno;
    }

    public void setPolicyno(String policyno) {
        this.policyno = policyno == null ? null : policyno.trim();
    }

    public String getSuppercode() {
        return suppercode;
    }

    public void setSuppercode(String suppercode) {
        this.suppercode = suppercode == null ? null : suppercode.trim();
    }

    public String getLosscause() {
        return losscause;
    }

    public void setLosscause(String losscause) {
        this.losscause = losscause == null ? null : losscause.trim();
    }

    public String getLosslocation() {
        return losslocation;
    }

    public void setLosslocation(String losslocation) {
        this.losslocation = losslocation == null ? null : losslocation.trim();
    }

    public Date getLossdate() {
        return lossdate;
    }

    public void setLossdate(Date lossdate) {
        this.lossdate = lossdate;
    }

    public BigDecimal getLossamount() {
        return lossamount;
    }

    public void setLossamount(BigDecimal lossamount) {
        this.lossamount = lossamount;
    }

    public BigDecimal getAllpayamount() {
        return allpayamount;
    }

    public void setAllpayamount(BigDecimal allpayamount) {
        this.allpayamount = allpayamount;
    }

    public Date getAllpaydate() {
        return allpaydate;
    }

    public void setAllpaydate(Date allpaydate) {
        this.allpaydate = allpaydate;
    }

    public BigDecimal getLossscale() {
        return lossscale;
    }

    public void setLossscale(BigDecimal lossscale) {
        this.lossscale = lossscale;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town == null ? null : town.trim();
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village == null ? null : village.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Object getFlag() {
        return flag;
    }

    public void setFlag(Object flag) {
        this.flag = flag;
    }

    public Object getRemark() {
        return remark;
    }

    public void setRemark(Object remark) {
        this.remark = remark;
    }

    public String getUpdatecode() {
        return updatecode;
    }

    public void setUpdatecode(String updatecode) {
        this.updatecode = updatecode == null ? null : updatecode.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getPolicyflag() {
        return policyflag;
    }

    public void setPolicyflag(String policyflag) {
        this.policyflag = policyflag == null ? null : policyflag.trim();
    }

    public String getIspoor() {
        return ispoor;
    }

    public void setIspoor(String ispoor) {
        this.ispoor = ispoor == null ? null : ispoor.trim();
    }

    public String getFarmertype() {
        return farmertype;
    }

    public void setFarmertype(String farmertype) {
        this.farmertype = farmertype == null ? null : farmertype.trim();
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername == null ? null : membername.trim();
    }

    public String getMemberaddress() {
        return memberaddress;
    }

    public void setMemberaddress(String memberaddress) {
        this.memberaddress = memberaddress == null ? null : memberaddress.trim();
    }

    public String getIdentityno() {
        return identityno;
    }

    public void setIdentityno(String identityno) {
        this.identityno = identityno == null ? null : identityno.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }
}