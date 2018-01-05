package com.dsib.policyDto;

import java.util.List;

/**
 * 农险保单总大类
 * @author Administrator
 *
 */
public class Request {
	private Main Main;
	private Organizer Organizer;
	private Applicant Applicant;
	private Insured Insured;
	private List<Insurance> InsuranceList;
	private List<ItemKind> ItemKinds;
	public Main getMain() {
		return Main;
	}
	public void setMain(Main main) {
		Main = main;
	}
	public Organizer getOrganizer() {
		return Organizer;
	}
	public void setOrganizer(Organizer organizer) {
		Organizer = organizer;
	}
	public Applicant getApplicant() {
		return Applicant;
	}
	public void setApplicant(Applicant applicant) {
		Applicant = applicant;
	}
	public Insured getInsured() {
		return Insured;
	}
	public void setInsured(Insured insured) {
		Insured = insured;
	}
	public List<Insurance> getInsuranceList() {
		return InsuranceList;
	}
	public void setInsuranceList(List<Insurance> insuranceList) {
		InsuranceList = insuranceList;
	}
	public List<ItemKind> getItemKinds() {
		return ItemKinds;
	}
	public void setItemKinds(List<ItemKind> itemKinds) {
		ItemKinds = itemKinds;
	}
	
}
