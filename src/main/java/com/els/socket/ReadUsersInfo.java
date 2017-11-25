package com.els.socket;

import java.util.List;
import java.util.Map;

public class ReadUsersInfo {

	private Map<String,String> positions;
	
	private String isReady;//0未准备  1已准备
	
	private List<Integer> readersID;



	public Map<String, String> getPositions() {
		return positions;
	}

	public void setPositions(Map<String, String> positions) {
		this.positions = positions;
	}

	public String getIsReady() {
		return isReady;
	}

	public void setIsReady(String isReady) {
		this.isReady = isReady;
	}

	public List<Integer> getReadersID() {
		return readersID;
	}

	public void setReadersID(List<Integer> readersID) {
		this.readersID = readersID;
	}
	
	
}
