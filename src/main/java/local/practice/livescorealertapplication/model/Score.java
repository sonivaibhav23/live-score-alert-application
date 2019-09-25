package local.practice.livescorealertapplication.model;

import java.io.Serializable;

public class Score implements Serializable {

	private int runs;
	private int wickets;
	private double overs;

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public double getOvers() {
		return overs;
	}

	public void setOvers(double overs) {
		this.overs = overs;
	}

	@Override
	public String toString() {
		return "Score{" + "runs=" + runs + ", wickets=" + wickets + ", overs=" + overs + '}';
	}
}
