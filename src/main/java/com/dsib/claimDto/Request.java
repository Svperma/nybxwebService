package com.dsib.claimDto;

import java.util.List;

/**
 * 理赔信息主体类
 * @author Administrator
 *
 */
public class Request {
	private Main Main;//理赔基本信息MainDTO
	private List<Insured> Insureds;//被保险人信息InsuredDTO
	public Main getMain() {
		return Main;
	}
	public void setMain(Main Main) {
		this.Main = Main;
	}
	public List<Insured> getInsureds() {
		return Insureds;
	}
	public void setInsureds(List<Insured> insureds) {
		Insureds = insureds;
	}
	
}
