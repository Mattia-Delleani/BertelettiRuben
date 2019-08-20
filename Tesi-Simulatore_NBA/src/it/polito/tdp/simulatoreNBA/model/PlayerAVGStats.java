package it.polito.tdp.simulatoreNBA.model;

public class PlayerAVGStats implements Comparable<PlayerAVGStats>{
	
	private String name;
	private Integer nGames;
	private Double point;
	private Double assist;
	private Double rebounds;
	private Double steal;
	private Double block;
	
	public PlayerAVGStats(String name, Integer nGames, Double point, Double assist, Double rebounds, Double steal) {
		super();
		this.name = name;
		this.nGames = nGames;
		this.point = point;
		this.assist = assist;
		this.rebounds = rebounds;
		this.steal = steal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getnGames() {
		return nGames;
	}

	public void setnGames(Integer nGames) {
		this.nGames = nGames;
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
				"PlayerAVGStats -> name = %s, nGames = %s, point = %s, assist = %s, rebounds = %s, steal = %s, block = %s",
				name, nGames, point, assist, rebounds, steal, block);
	}

	@Override
	public int compareTo(PlayerAVGStats o) {
		return o.point.compareTo(this.point);
	}
	
	
	
	
	
	

}
