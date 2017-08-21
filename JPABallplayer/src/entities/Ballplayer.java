package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ballplayer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "season")
	private int season;
	
	@Column(name="atBats ")
	private int atBats;
	
	@Column(name="homeRuns ")
	private int homeRuns;
	
	@Column(name="annualSalary")
	private int annualSalary;
	
	@Column(name="atBatsPerHomeRun")
	private Double atBatsPerHomeRun;
	
	@Column(name="name")
	private String name;
	
	
	//gets and sets
	
	public int getId() {
		return id;
	}

	public int getHomeRuns() {
		return homeRuns;
	}


	public void setHomeRuns(int homeRuns) {
		this.homeRuns = homeRuns;
	}


	public int getAnnualSalary() {
		return annualSalary;
	}


	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}


	public Double getAtBatsPerHomeRun() {
		return atBatsPerHomeRun;
	}


	public void setAtBatsPerHomeRun(Double atBatsPerHomeRun) {
		this.atBatsPerHomeRun = atBatsPerHomeRun;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}




	public int getSeason() {
		return season;
	}


	public void setSeason(int season) {
		this.season = season;
	}


	public int getAtBats() {
		return atBats;
	}


	public void setAtBats(int atBats) {
		this.atBats = atBats;
	}

	@Override
	public String toString() {
		return "Ballplayer [id=" + id + ", season=" + season + ", atBats=" + atBats + ", homeRuns=" + homeRuns
				+ ", annualSalary=" + annualSalary + ", atBatsPerHomeRun=" + atBatsPerHomeRun + ", name=" + name + "]";
	}


	
	
	
}
