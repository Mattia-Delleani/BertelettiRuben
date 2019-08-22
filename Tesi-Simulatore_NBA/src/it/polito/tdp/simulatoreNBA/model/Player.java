package it.polito.tdp.simulatoreNBA.model;


public class Player {
	
	private String name;
	private String team;
	private Integer age;
	private Double points;
	private Double blocks;
	private Double steals;
	private Double assists;
	private Double rebounds;
	private Double freeThrowsPercentage;
	private Double freeThrowsAttempts;
	private Double threePointsPercentage;
	private Double threePointsAttempts;
	private Double fieldGoalsPercentage;
	private Double fieldGoalAttempts;
	private Double minutePlayed;
	private Boolean injured;
	
	public Player(String name, String team, Integer age, Double points, Double blocks, Double steals, Double assists,
			Double rebounds, Double freeThrowsPercentage, Double freeThrowsAttempts, Double threePointsPercentage,
			Double threePointsAttempts, Double fieldGoalsPercentage, Double fieldGoalAttempts, Double minutePlayed) {
		super();
		this.name = name;
		this.team = team;
		this.age = age;
		this.points = points;
		this.blocks = blocks;
		this.steals = steals;
		this.assists = assists;
		this.rebounds = rebounds;
		this.freeThrowsPercentage = freeThrowsPercentage;
		this.freeThrowsAttempts = freeThrowsAttempts;
		this.threePointsPercentage = threePointsPercentage;
		this.threePointsAttempts = threePointsAttempts;
		this.fieldGoalsPercentage = fieldGoalsPercentage;
		this.fieldGoalAttempts = fieldGoalAttempts;
		this.minutePlayed = minutePlayed;
		this.injured = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	public Double getBlocks() {
		return blocks;
	}

	public void setBlocks(Double blocks) {
		this.blocks = blocks;
	}

	public Double getSteals() {
		return steals;
	}

	public void setSteals(Double steals) {
		this.steals = steals;
	}

	public Double getAssists() {
		return assists;
	}

	public void setAssists(Double assists) {
		this.assists = assists;
	}

	public Double getRebounds() {
		return rebounds;
	}

	public void setRebounds(Double rebounds) {
		this.rebounds = rebounds;
	}

	public Double getFreeThrowsPercentage() {
		return freeThrowsPercentage;
	}

	public void setFreeThrowsPercentage(Double freeThrowsPercentage) {
		this.freeThrowsPercentage = freeThrowsPercentage;
	}

	public Double getFreeThrowsAttempts() {
		return freeThrowsAttempts;
	}

	public void setFreeThrowsAttempts(Double freeThrowsAttempts) {
		this.freeThrowsAttempts = freeThrowsAttempts;
	}

	public Double getThreePointsPercentage() {
		return threePointsPercentage;
	}

	public void setThreePointsPercentage(Double threePointsPercentage) {
		this.threePointsPercentage = threePointsPercentage;
	}

	public Double getThreePointsAttempts() {
		return threePointsAttempts;
	}

	public void setThreePointsAttempts(Double threePointsAttempts) {
		this.threePointsAttempts = threePointsAttempts;
	}

	public Double getFieldGoalsPercentage() {
		return fieldGoalsPercentage;
	}

	public void setFieldGoalsPercentage(Double fieldGoalsPercentage) {
		this.fieldGoalsPercentage = fieldGoalsPercentage;
	}

	public Double getFieldGoalAttempts() {
		return fieldGoalAttempts;
	}

	public void setFieldGoalAttempts(Double fieldGoalAttempts) {
		this.fieldGoalAttempts = fieldGoalAttempts;
	}

	public Double getMinutePlayed() {
		return minutePlayed;
	}

	public void setMinutePlayed(Double minutePlayed) {
		this.minutePlayed = minutePlayed;
	}

	public Boolean getInjured() {
		return injured;
	}

	public void setInjured(Boolean injured) {
		this.injured = injured;
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
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name + " - Team: " + team;
	}
	
	
	
	
	
	
	
	

	

	
	
	
	
	

}
