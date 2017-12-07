package com.els.socket;

public class GameMessage {

	private Integer playerId;
	// 玩家姓名
	private String playerName;
	// 玩家头像
	private String playerImg;
	// 分数
	private Integer score;
	// 行数
	private Integer lines;
	// 道具名称
	private String propsName;
	// 道具发起人
	private String fromPlayer;
	// 道具攻击人
	private String toPlayer;
	// 道具使用次数
	private Integer count;
	// 道具状态
	private Integer propsStatus;// 0无状态 1增益 2减益
	// 排行榜
	private Integer runkIng;

	public Integer getRunkIng() {
		return runkIng;
	}

	public void setRunkIng(Integer runkIng) {
		this.runkIng = runkIng;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerImg() {
		return playerImg;
	}

	public void setPlayerImg(String playerImg) {
		this.playerImg = playerImg;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getLines() {
		return lines;
	}

	public void setLines(Integer lines) {
		this.lines = lines;
	}

	public String getPropsName() {
		return propsName;
	}

	public void setPropsName(String propsName) {
		this.propsName = propsName;
	}

	public String getFromPlayer() {
		return fromPlayer;
	}

	public void setFromPlayer(String fromPlayer) {
		this.fromPlayer = fromPlayer;
	}

	public String getToPlayer() {
		return toPlayer;
	}

	public void setToPlayer(String toPlayer) {
		this.toPlayer = toPlayer;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPropsStatus() {
		return propsStatus;
	}

	public void setPropsStatus(Integer propsStatus) {
		this.propsStatus = propsStatus;
	}

}
