package it.polito.tdp.simulatoreNBA.model;

public class PlayerAVGStats implements Comparable<PlayerAVGStats>{
	
	private String name;
	private Integer ngames;
	private Double point;
	private Double assist;
	private Double rebounds;
	private Double steal;
	private Double block;
	private Integer fgAttempts;
	private Integer fgDone;
	private Integer threeAttempts;
	private Integer threeDone;
	private Integer freeAttempts;
	private Integer freeDone;
	private String fgAvg;
	private String threeAvg;
	private String freeAvg;
	
	public PlayerAVGStats(String name, Integer nGames, Double point, Double assist, Double rebounds, Double block) {
		super();
		this.name = name;
		this.ngames = nGames;
		this.point = point;
		this.assist = assist;
		this.rebounds = rebounds;
		this.block = block;
		this.fgAttempts = 0;
		this.fgDone = 0;
		this.freeDone = 0;
		this.freeAttempts = 0;
		this.threeAttempts = 0;
		this.threeDone = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNgames() {
		return ngames;
	}

	public void setNgames(Integer nGames) {
		this.ngames = nGames;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

	public Double getAssist() {
		return assist;
	}

	public void setAssist(Double assist) {
		this.assist = assist;
	}

	public Double getRebounds() {
		return rebounds;
	}

	public void setRebounds(Double rebounds) {
		this.rebounds = rebounds;
	}

	public Double getSteal() {
		return steal;
	}

	public void setSteal(Double steal) {
		this.steal = steal;
	}

	public Double getBlock() {
		return block;
	}

	public void setBlock(Double block) {
		this.block = block;
	}	

	public Integer getFgAttempts() {
		return fgAttempts;
	}

	public void setFgAttempts(Integer fgAttempts) {
		this.fgAttempts = fgAttempts;
	}

	public Integer getFgDone() {
		return fgDone;
	}

	public void setFgDone(Integer fgDone) {
		this.fgDone = fgDone;
	}

	public Integer getThreeAttempts() {
		return threeAttempts;
	}

	public void setThreeAttempts(Integer threeAttempts) {
		this.threeAttempts = threeAttempts;
	}

	public Integer getThreeDone() {
		return threeDone;
	}

	public void setThreeDone(Integer threeDone) {
		this.threeDone = threeDone;
	}

	public Integer getFreeAttempts() {
		return freeAttempts;
	}

	public void setFreeAttempts(Integer freeAttempts) {
		this.freeAttempts = freeAttempts;
	}

	public Integer getFreeDone() {
		return freeDone;
	}

	public void setFreeDone(Integer freeDone) {
		this.freeDone = freeDone;
	}

	public String getFgAvg() {
		return fgAvg;
	}

	public void setFgAvg(String fgAvg) {
		this.fgAvg = fgAvg;
	}

	public String getThreeAvg() {
		return threeAvg;
	}

	public void setThreeAvg(String threeAvg) {
		this.threeAvg = threeAvg;
	}

	public String getFreeAvg() {
		return freeAvg;
	}

	public void setFreeAvg(String freeAvg) {
		this.freeAvg = freeAvg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerAVGStats other = (PlayerAVGStats) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return String.format(
				"PlayerAVGStats -> name = %s, ngames = %s, point = %s, assist = %s, rebounds = %s, steal = %s, block = %s, fgAvg = %s, threeAvg = %s, freeAvg = %s",
				name, ngames, point, assist, rebounds, steal, block, fgAvg, threeAvg, freeAvg);
	}

	@Override
	public int compareTo(PlayerAVGStats o) {
		return o.point.compareTo(this.point);
	}
	
	
	
	
	
	

}
