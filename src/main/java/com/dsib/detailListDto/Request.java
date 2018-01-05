package com.dsib.detailListDto;

import java.util.List;

/**
 * 清单信息主体类
 * @author Administrator
 *
 */
public class Request {
	private List<Main> MainList;//清单基本信息MainDTO

	public List<Main> getMainList() {
		return MainList;
	}

	public void setMainList(List<Main> mainList) {
		MainList = mainList;
	}
	
}
