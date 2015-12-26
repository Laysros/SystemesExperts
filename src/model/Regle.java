package model;

import java.util.List;

public class Regle {
	private List<Proposition> propositions;
	private Proposition conclusion;
	
	
	
	public Regle(List<Proposition> propositions, Proposition conclusion) {
		this.propositions = propositions;
		this.conclusion = conclusion;
	}
	public List<Proposition> getPropositions() {
		return propositions;
	}
	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}
	public Proposition getConclusion() {
		return conclusion;
	}
	public void setConclusion(Proposition conclusion) {
		this.conclusion = conclusion;
	}
	
	
	
}
