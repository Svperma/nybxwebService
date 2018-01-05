package com.dsib.service;

public interface CommonService {
	/**
	 * 供客户端调用的保单传入方法
	 * @param requestXml
	 * @return
	 */
	public String savePolicy(String requestXml);
	/**
	 * 供客户端调用的理赔传入方法
	 * @param requestXml
	 * @return
	 */
	public String saveClaim(String requestXml);
	/**
	 * 供客户端调用的清单传入方法
	 * @param requestXml
	 * @return
	 */
	public String saveDetailedList(String requestXml);
}
