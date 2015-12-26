package model;

public class Proposition {
	private int id;
	private String proposition;
	private boolean answer=true;
	
	public Proposition(int id, String proposition) {
		this.id = id;
		this.proposition = proposition;
	}
	public String getProposition() {
		return proposition;
	}
	public void setProposition(String proposition) {
		this.proposition = proposition;
	}
	public boolean isAnswer() {
		return answer;
	}
	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
