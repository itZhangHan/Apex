package com.els.socket;

public class GameMessage {

	private String playerId;
	// 玩家姓名
	private String playerName;
	// 玩家头像
	private String playerImg;
	// 分数
	private String score;
	// 行数
	private Integer lines;
	// 道具名称
	private String propsName;
	// 道具发起人
	private String fromPlayer;
	// 道具攻击人
	private String toPlayer;
	// 道具使用次数
	private String count;
	// 道具状态
	private String propsStatus;// 1增益 2减益

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
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

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
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

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getPropsStatus() {
		return propsStatus;
	}

	public void setPropsStatus(String propsStatus) {
		this.propsStatus = propsStatus;
	}

}
