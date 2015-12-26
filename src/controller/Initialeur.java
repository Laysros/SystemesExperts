package controller;

import java.util.ArrayList;
import java.util.List;

import model.Regle;
import model.Proposition;

public class Initialeur {
	List<Proposition> propositionList;
	List<Regle> regles = new ArrayList<Regle>();
	public Initialeur(){
		initQuestion();
		setQuestion();
	}
	
	public void initQuestion(){
		propositionList = new ArrayList<Proposition>();
		propositionList.add(new Proposition(0,"a poils"));
		propositionList.add(new Proposition(1,"est mammifere"));
		propositionList.add(new Proposition(2,"donne lait"));
		propositionList.add(new Proposition(3,"mange viande"));
		propositionList.add(new Proposition(4,"est carnivore"));
		propositionList.add(new Proposition(5,"a dents pointues"));
		propositionList.add(new Proposition(6,"a griffes"));
		propositionList.add(new Proposition(7,"a yeux vers avant"));
		propositionList.add(new Proposition(8,"a sabots"));
		propositionList.add(new Proposition(9,"est ongule"));
		propositionList.add(new Proposition(10,"a taches sombres"));
		propositionList.add(new Proposition(11,"est guepard"));
		propositionList.add(new Proposition(12,"a couleur brune"));
		propositionList.add(new Proposition(13,"a raises noires "));
		propositionList.add(new Proposition(14,"est tigre"));
		propositionList.add(new Proposition(15,"a long cou"));
		propositionList.add(new Proposition(16,"a longues pattes"));
		propositionList.add(new Proposition(17,"est girafe"));
		propositionList.add(new Proposition(18,"est zebre"));
		propositionList.add(new Proposition(19,"a plumes"));
		propositionList.add(new Proposition(20,"oiseaux"));
		propositionList.add(new Proposition(21,"vole"));
		propositionList.add(new Proposition(22,"ponds oeufs"));
		propositionList.add(new Proposition(23,"est noir et blanc"));
		propositionList.add(new Proposition(24,"est autruche"));
		propositionList.add(new Proposition(25,"nage"));
		propositionList.add(new Proposition(26,"est pinguoin"));
		propositionList.add(new Proposition(27,"est aigle"));
		propositionList.add(new Proposition(28,"est baleine"));
		
	}
	public void setQuestion(){
		//Regle1
		List<Proposition> proposition1 = new ArrayList<Proposition>();
		proposition1.add(propositionList.get(0));
		regles.add(new Regle(proposition1, propositionList.get(1)));
		//Regle2
		List<Proposition> proposition2 = new ArrayList<Proposition>();
		proposition2.add(propositionList.get(2));
		regles.add(new Regle(proposition2, propositionList.get(1)));
		//Regle 3
		List<Proposition> proposition3 = new ArrayList<Proposition>();
		proposition3.add(propositionList.get(3));
		regles.add(new Regle(proposition3, propositionList.get(4)));
		//Regle 4
		List<Proposition> proposition4 = new ArrayList<Proposition>();
		proposition4.add(propositionList.get(5));
		proposition4.add(propositionList.get(6));
		proposition4.add(propositionList.get(7));
		regles.add(new Regle(proposition4, propositionList.get(4)));
		//Regle 5
		List<Proposition> proposition5 = new ArrayList<Proposition>();
		proposition5.clear();
		proposition5.add(propositionList.get(1));
		proposition5.add(propositionList.get(8));
		regles.add(new Regle(proposition5, propositionList.get(9)));
		//Regle 6 n'est pas deductible
		//Regle 7
		List<Proposition> proposition7 = new ArrayList<Proposition>();
		proposition7.add(propositionList.get(1));
		proposition7.add(propositionList.get(4));
		proposition7.add(propositionList.get(12));
		proposition7.add(propositionList.get(10));
		regles.add(new Regle(proposition7, propositionList.get(11)));
		//Regle 8
		List<Proposition> proposition8 = new ArrayList<Proposition>();
		proposition8.add(propositionList.get(1));
		proposition8.add(propositionList.get(4));
		proposition8.add(propositionList.get(12));
		proposition8.add(propositionList.get(13));
		regles.add(new Regle(proposition8, propositionList.get(14)));
		//Regle 9
		List<Proposition> proposition9 = new ArrayList<Proposition>();
		proposition9.add(propositionList.get(9));
		proposition9.add(propositionList.get(15));
		proposition9.add(propositionList.get(16));
		proposition9.add(propositionList.get(10));
		regles.add(new Regle(proposition9, propositionList.get(17)));
		//Regle 10
		List<Proposition> proposition10 = new ArrayList<Proposition>();
		proposition10.add(propositionList.get(9));
		proposition10.add(propositionList.get(13));
		regles.add(new Regle(proposition10, propositionList.get(18)));
		//Regle 11
		List<Proposition> proposition11 = new ArrayList<Proposition>();
		proposition11.add(propositionList.get(19));
		regles.add(new Regle(proposition11, propositionList.get(20)));

		//Regle 12
		List<Proposition> proposition12 = new ArrayList<Proposition>();
		proposition12.add(propositionList.get(21));
		proposition12.add(propositionList.get(22));
		regles.add(new Regle(proposition12, propositionList.get(20)));
		//Regle 13
		List<Proposition> proposition13 = new ArrayList<Proposition>();
		proposition13.add(propositionList.get(20));
		proposition13.add(propositionList.get(21));//Ne vole pas
		proposition13.get(1).setAnswer(false);
		proposition13.add(propositionList.get(15));
		proposition13.add(propositionList.get(16));
		proposition13.add(propositionList.get(23));
		regles.add(new Regle(proposition13, propositionList.get(24)));
		//Regle 14
		List<Proposition> proposition14 = new ArrayList<Proposition>();
		proposition14.add(propositionList.get(20));
		proposition14.add(propositionList.get(21));//Ne vole pas
		proposition13.get(1).setAnswer(false);
		proposition14.add(propositionList.get(25));
		proposition14.add(propositionList.get(23));
		regles.add(new Regle(proposition14, propositionList.get(26)));

		//Regle 15
		List<Proposition> proposition15 = new ArrayList<Proposition>();
		proposition15.add(propositionList.get(20));
		proposition15.add(propositionList.get(4));
		regles.add(new Regle(proposition15, propositionList.get(27)));
		
		//Regle 16
		List<Proposition> proposition16 = new ArrayList<Proposition>();
		proposition16.add(propositionList.get(2));
		proposition16.add(propositionList.get(25));
		regles.add(new Regle(proposition16, propositionList.get(28)));


	}
	public List<Regle>getRegleList(){
		return regles;
	}
	
}
