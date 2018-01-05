package com.dsib.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Jg_GuPolicyMain {
    private String businessno;

    private String plancode;

    private String proposalno;

    private String policyno;

    private String riskcode;

    private String classcode;

    private String insurercode;

    private Date startdate;

    private Date enddate;

    private Date signdate;

    private BigDecimal spreadsheetpremium;

    private BigDecimal actualpremium;

    private BigDecimal quantity;

    private BigDecimal personpremium;

    private BigDecimal sumamount;

    private BigDecimal discount;

    private BigDecimal sumdiscount;

    private BigDecimal sumsubprem;

    private String county;

    private String specialprovisions;

    private String town;

    private String city;

    private String province;

    private String arguesolution;

    private String arbitboardname;

    private BigDecimal endorsetimes;

    private String renewalflag;

    private String previouspolicyno;

    private String payflag;

    private String paybillno;

    private String memberid;

    private Date inputdate;

    private String underwritecode;

    private Date underwriteenddate;

    private String underdirections;

    private String status;

    private String updatecode;

    private Date updatetime;

    private String remark;

    private String village;

    private String agriculturecode;

    private String membername;

    private String memberaddress;

    private String identityno;

    private String plantarea;

    private BigDecimal centralallowance;

    private BigDecimal provinceallowance;

    private BigDecimal cityallowance;

    private BigDecimal countyallowance;

    private BigDecimal personallowance;

    private BigDecimal ohterallowance;

    private String ispoor;

    private String farmertype;

    private String insuredcount;

    private String organizername;

    private String identifytype;

    private String identifynumber;

    private String contactname;

    private String phonenumber;

    public Jg_GuPolicyMain() {
		super();
	}

    /**
     * 农险平台导入模版全字段
     * @param businessno
     * @param policyno
     * @param riskcode
     * @param classcode
     * @param insurercode
     * @param startdate
     * @param enddate
     * @param signdate
     * @param spreadsheetpremium
     * @param actualpremium
     * @param quantity
     * @param sumamount
     * @param county
     * @param city
     * @param province
     * @param memberid
     * @param inputdate
     * @param status
     * @param updatecode
     * @param updatetime
     * @param agriculturecode
     * @param membername
     * @param memberaddress
     * @param identityno
     * @param centralallowance
     * @param provinceallowance
     * @param cityallowance
     * @param countyallowance
     * @param personallowance
     * @param ohterallowance
     * @param ispoor
     * @param farmertype
     * @param insuredcount
     * @param organizername
     * @param identifytype
     * @param identifynumber
     * @param contactname
     * @param phonenumber
     */
	public Jg_GuPolicyMain(String businessno, String policyno, String riskcode,
			String classcode, String insurercode, Date startdate, Date enddate,
			Date signdate, BigDecimal spreadsheetpremium,
			BigDecimal actualpremium, BigDecimal quantity,
			BigDecimal sumamount, String county, String city, String province,
			String memberid, Date inputdate, String status, String updatecode,
			Date updatetime, String agriculturecode, String membername,
			String memberaddress, String identityno,
			BigDecimal centralallowance, BigDecimal provinceallowance,
			BigDecimal cityallowance, BigDecimal countyallowance,
			BigDecimal personallowance, BigDecimal ohterallowance,
			String ispoor, String farmertype, String insuredcount,
			String organizername, String identifytype, String identifynumber,
			String contactname, String phonenumber) {
		super();
		this.businessno = businessno;
		this.policyno = policyno;
		this.riskcode = riskcode;
		this.classcode = classcode;
		this.insurercode = insurercode;
		this.startdate = startdate;
		this.enddate = enddate;
		this.signdate = signdate;
		this.spreadsheetpremium = spreadsheetpremium;
		this.actualpremium = actualpremium;
		this.quantity = quantity;
		this.sumamount = sumamount;
		this.county = county;
		this.city = city;
		this.province = province;
		this.memberid = memberid;
		this.inputdate = inputdate;
		this.status = status;
		this.updatecode = updatecode;
		this.updatetime = updatetime;
		this.agriculturecode = agriculturecode;
		this.membername = membername;
		this.memberaddress = memberaddress;
		this.identityno = identityno;
		this.centralallowance = centralallowance;
		this.provinceallowance = provinceallowance;
		this.cityallowance = cityallowance;
		this.countyallowance = countyallowance;
		this.personallowance = personallowance;
		this.ohterallowance = ohterallowance;
		this.ispoor = ispoor;
		this.farmertype = farmertype;
		this.insuredcount = insuredcount;
		this.organizername = organizername;
		this.identifytype = identifytype;
		this.identifynumber = identifynumber;
		this.contactname = contactname;
		this.phonenumber = phonenumber;
	}

	public Jg_GuPolicyMain(String businessno, String plancode,
			String proposalno, String policyno, String riskcode,
			String classcode, String insurercode, Date startdate, Date enddate,
			Date signdate, BigDecimal spreadsheetpremium,
			BigDecimal actualpremium, BigDecimal quantity,
			BigDecimal personpremium, BigDecimal sumamount,
			BigDecimal discount, BigDecimal sumdiscount, BigDecimal sumsubprem,
			String county, String specialprovisions, String town, String city,
			String province, String arguesolution, String arbitboardname,
			BigDecimal endorsetimes, String renewalflag,
			String previouspolicyno, String payflag, String paybillno,
			String memberid, Date inputdate, String underwritecode,
			Date underwriteenddate, String underdirections, String status,
			String updatecode, Date updatetime, String remark, String village,
			String agriculturecode, String membername, String memberaddress,
			String identityno, String plantarea, BigDecimal centralallowance,
			BigDecimal provinceallowance, BigDecimal cityallowance,
			BigDecimal countyallowance, BigDecimal personallowance,
			BigDecimal ohterallowance, String ispoor, String farmertype,
			String insuredcount, String organizername, String identifytype,
			String identifynumber, String contactname, String phonenumber) {
		super();
		this.businessno = businessno;
		this.plancode = plancode;
		this.proposalno = proposalno;
		this.policyno = policyno;
		this.riskcode = riskcode;
		this.classcode = classcode;
		this.insurercode = insurercode;
		this.startdate = startdate;
		this.enddate = enddate;
		this.signdate = signdate;
		this.spreadsheetpremium = spreadsheetpremium;
		this.actualpremium = actualpremium;
		this.quantity = quantity;
		this.personpremium = personpremium;
		this.sumamount = sumamount;
		this.discount = discount;
		this.sumdiscount = sumdiscount;
		this.sumsubprem = sumsubprem;
		this.county = county;
		this.specialprovisions = specialprovisions;
		this.town = town;
		this.city = city;
		this.province = province;
		this.arguesolution = arguesolution;
		this.arbitboardname = arbitboardname;
		this.endorsetimes = endorsetimes;
		this.renewalflag = renewalflag;
		this.previouspolicyno = previouspolicyno;
		this.payflag = payflag;
		this.paybillno = paybillno;
		this.memberid = memberid;
		this.inputdate = inputdate;
		this.underwritecode = underwritecode;
		this.underwriteenddate = underwriteenddate;
		this.underdirections = underdirections;
		this.status = status;
		this.updatecode = updatecode;
		this.updatetime = updatetime;
		this.remark = remark;
		this.village = village;
		this.agriculturecode = agriculturecode;
		this.membername = membername;
		this.memberaddress = memberaddress;
		this.identityno = identityno;
		this.plantarea = plantarea;
		this.centralallowance = centralallowance;
		this.provinceallowance = provinceallowance;
		this.cityallowance = cityallowance;
		this.countyallowance = countyallowance;
		this.personallowance = personallowance;
		this.ohterallowance = ohterallowance;
		this.ispoor = ispoor;
		this.farmertype = farmertype;
		this.insuredcount = insuredcount;
		this.organizername = organizername;
		this.identifytype = identifytype;
		this.identifynumber = identifynumber;
		this.contactname = contactname;
		this.phonenumber = phonenumber;
	}

	public String getBusinessno() {
        return businessno;
    }

    public void setBusinessno(String businessno) {
        this.businessno = businessno == null ? null : businessno.trim();
    }

    public String getPlancode() {
        return plancode;
    }

    public void setPlancode(String plancode) {
        this.plancode = plancode == null ? null : plancode.trim();
    }

    public String getProposalno() {
        return proposalno;
    }

    public void setProposalno(String proposalno) {
        this.proposalno = proposalno == null ? null : proposalno.trim();
    }

    public String getPolicyno() {
        return policyno;
    }

    public void setPolicyno(String policyno) {
        this.policyno = policyno == null ? null : policyno.trim();
    }

    public String getRiskcode() {
        return riskcode;
    }

    public void setRiskcode(String riskcode) {
        this.riskcode = riskcode == null ? null : riskcode.trim();
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode == null ? null : classcode.trim();
    }

    public String getInsurercode() {
        return insurercode;
    }

    public void setInsurercode(String insurercode) {
        this.insurercode = insurercode == null ? null : insurercode.trim();
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Date getSigndate() {
        return signdate;
    }

    public void setSigndate(Date signdate) {
        this.signdate = signdate;
    }

    public BigDecimal getSpreadsheetpremium() {
        return spreadsheetpremium;
    }

    public void setSpreadsheetpremium(BigDecimal spreadsheetpremium) {
        this.spreadsheetpremium = spreadsheetpremium;
    }

    public BigDecimal getActualpremium() {
        return actualpremium;
    }

    public void setActualpremium(BigDecimal actualpremium) {
        this.actualpremium = actualpremium;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPersonpremium() {
        return personpremium;
    }

    public void setPersonpremium(BigDecimal personpremium) {
        this.personpremium = personpremium;
    }

    public BigDecimal getSumamount() {
        return sumamount;
    }

    public void setSumamount(BigDecimal sumamount) {
        this.sumamount = sumamount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getSumdiscount() {
        return sumdiscount;
    }

    public void setSumdiscount(BigDecimal sumdiscount) {
        this.sumdiscount = sumdiscount;
    }

    public BigDecimal getSumsubprem() {
        return sumsubprem;
    }

    public void setSumsubprem(BigDecimal sumsubprem) {
        this.sumsubprem = sumsubprem;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getSpecialprovisions() {
        return specialprovisions;
    }

    public void setSpecialprovisions(String specialprovisions) {
        this.specialprovisions = specialprovisions == null ? null : specialprovisions.trim();
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town == null ? null : town.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getArguesolution() {
        return arguesolution;
    }

    public void setArguesolution(String arguesolution) {
        this.arguesolution = arguesolution == null ? null : arguesolution.trim();
    }

    public String getArbitboardname() {
        return arbitboardname;
    }

    public void setArbitboardname(String arbitboardname) {
        this.arbitboardname = arbitboardname == null ? null : arbitboardname.trim();
    }

    public BigDecimal getEndorsetimes() {
        return endorsetimes;
    }

    public void setEndorsetimes(BigDecimal endorsetimes) {
        this.endorsetimes = endorsetimes;
    }

    public String getRenewalflag() {
        return renewalflag;
    }

    public void setRenewalflag(String renewalflag) {
        this.renewalflag = renewalflag == null ? null : renewalflag.trim();
    }

    public String getPreviouspolicyno() {
        return previouspolicyno;
    }

    public void setPreviouspolicyno(String previouspolicyno) {
        this.previouspolicyno = previouspolicyno == null ? null : previouspolicyno.trim();
    }

    public String getPayflag() {
        return payflag;
    }

    public void setPayflag(String payflag) {
        this.payflag = payflag == null ? null : payflag.trim();
    }

    public String getPaybillno() {
        return paybillno;
    }

    public void setPaybillno(String paybillno) {
        this.paybillno = paybillno == null ? null : paybillno.trim();
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid == null ? null : memberid.trim();
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    public String getUnderwritecode() {
        return underwritecode;
    }

    public void setUnderwritecode(String underwritecode) {
        this.underwritecode = underwritecode == null ? null : underwritecode.trim();
    }

    public Date getUnderwriteenddate() {
        return underwriteenddate;
    }

    public void setUnderwriteenddate(Date underwriteenddate) {
        this.underwriteenddate = underwriteenddate;
    }

    public String getUnderdirections() {
        return underdirections;
    }

    public void setUnderdirections(String underdirections) {
        this.underdirections = underdirections == null ? null : underdirections.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village == null ? null : village.trim();
    }

    public String getAgriculturecode() {
        return agriculturecode;
    }

    public void setAgriculturecode(String agriculturecode) {
        this.agriculturecode = agriculturecode == null ? null : agriculturecode.trim();
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

    public String getPlantarea() {
        return plantarea;
    }

    public void setPlantarea(String plantarea) {
        this.plantarea = plantarea == null ? null : plantarea.trim();
    }

    public BigDecimal getCentralallowance() {
        return centralallowance;
    }

    public void setCentralallowance(BigDecimal centralallowance) {
        this.centralallowance = centralallowance;
    }

    public BigDecimal getProvinceallowance() {
        return provinceallowance;
    }

    public void setProvinceallowance(BigDecimal provinceallowance) {
        this.provinceallowance = provinceallowance;
    }

    public BigDecimal getCityallowance() {
        return cityallowance;
    }

    public void setCityallowance(BigDecimal cityallowance) {
        this.cityallowance = cityallowance;
    }

    public BigDecimal getCountyallowance() {
        return countyallowance;
    }

    public void setCountyallowance(BigDecimal countyallowance) {
        this.countyallowance = countyallowance;
    }

    public BigDecimal getPersonallowance() {
        return personallowance;
    }

    public void setPersonallowance(BigDecimal personallowance) {
        this.personallowance = personallowance;
    }

    public BigDecimal getOhterallowance() {
        return ohterallowance;
    }

    public void setOhterallowance(BigDecimal ohterallowance) {
        this.ohterallowance = ohterallowance;
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

    public String getInsuredcount() {
        return insuredcount;
    }

    public void setInsuredcount(String insuredcount) {
        this.insuredcount = insuredcount == null ? null : insuredcount.trim();
    }

    public String getOrganizername() {
        return organizername;
    }

    public void setOrganizername(String organizername) {
        this.organizername = organizername == null ? null : organizername.trim();
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

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname == null ? null : contactname.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }
}