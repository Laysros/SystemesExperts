package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import model.Regle;
import model.Proposition;

public class Moteur {
	List<Regle> base_de_regles;//toutes les regles possibles R1, R1, R3
	List<Proposition> base_de_faits = new ArrayList<Proposition>();//toutes les proposition : poil, nage, 
	List<Proposition> base_terminaux = new ArrayList<Proposition>();//Toutes les proposition termaux : tigre
	List<Proposition> base_conclusions = new ArrayList<Proposition>();////Toutes les proposition conclusions: mammifere, canivore
	
	public Moteur() {
		Initialeur initialeur = new Initialeur();// initial l'objet
		base_de_regles = initialeur.getRegleList();// passer la liste de regles à base_de_regles
		initConclusion();//Initialiser la liste de conclusions
		boucleFaitsTerminaux();//Commencer le systeme pour trouver l'animal
		
	}
	private void initConclusion() {
		for(Regle regle:base_de_regles){
			if(!base_conclusions.contains(regle.getConclusion())){//trouver la partie conclusion
				base_conclusions.add(regle.getConclusion());//ajouter une regle a la liste
			}
		}
		
	}
	private boolean boucleFaitsTerminaux() {
		List<Proposition> faits_terminaux = new ArrayList<Proposition>();
		for(Regle regle: base_de_regles){
			Proposition conclusion = regle.getConclusion();			
			if(isFaitConclustion(conclusion) && !faits_terminaux.contains(conclusion)){
				faits_terminaux.add(conclusion);//ajouter une proposition a la partie conclusion qui est la proposition terminale: Tigre, guepard
			}
		}
		base_terminaux = faits_terminaux;
		for(Proposition con:faits_terminaux){//TODO change to while loop, 
			if(etablirUnFait(con)){//
				if(valeurFaitBase(con)){//
					System.out.println("Animal "+ con.getProposition() + ".\nAnimal est prouvé "+ valeurFaitBase(con));// Montrer animal trouvé
					System.out.println("-------------System is terminated-----------------");//Terminer le systeme
					return true;
				}
				
			}
		}
		System.out.println("Aucun fait terminal n'a été prouvé");
		return false;
	}
	private boolean isFaitConclustion(Proposition conclusion) {
		for(Regle regle:base_de_regles){
			if(regle.getPropositions().contains(conclusion)){
				return false;
			}
		}
		return true;
	}
	//Verifier si la proposition peux etre deductible
	private boolean valeurFaitBase(Proposition fait) {
		for(Regle regle:base_de_regles){
			if(regle.getConclusion().equals(fait)){
				if(base_de_faits.containsAll(regle.getPropositions())){
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean etablirUnFait(Proposition fait) {
		if(base_de_faits.contains(fait)){//propposition demandable
			return true;
		}
		List<Regle> des_regles = new ArrayList<Regle>();//Tous les regles de base_de_regles qui comportent le_fait en partie conclusion
		for (Regle regle:base_de_regles) {
			if(regle.getConclusion().equals(fait)){
				des_regles.add(regle);
			}
		}
		if(des_regles.isEmpty() && !base_conclusions.contains(fait)){//Fait demandle
			System.out.println("Pouvez-vous affirmer que l'animal " + fait.getProposition() + " est vrai(o,n)?");
			Scanner scanner = new Scanner(System.in);
			char answer = scanner.nextLine().charAt(0);
			boolean tmp = fait.isAnswer();			
			fait.setAnswer(answer=='o');
			base_de_faits.add(fait);
			return tmp==fait.isAnswer();//retourner comparant entre la valeur d'entrée et la valeur de proposition de regle.
		}else{//Fait deductible
			return exploiterLesRegles(des_regles, fait);
		}	
	}
	private boolean exploiterLesRegles(List<Regle> les_regles, Proposition fait) {
		// 
		for(Regle regle:les_regles){//regle qui cmportent le_fait en partie conclusion
			if(exploiterUneRegle(regle, fait)){
				return true;
			}
		}
		return false;
	}
	private boolean exploiterUneRegle(Regle la_regle, Proposition le_fait) {
		for(Proposition un_fait:la_regle.getPropositions() ){
			if(!etablirUnFait(un_fait)){
				base_de_regles.remove(la_regle);// enlever la regle inconnue
				return false;
			}
			if(base_de_faits.contains(le_fait)){
				return false;
			}
		}
		System.out.print("Animal ");
		for(Proposition p:la_regle.getPropositions()){
			System.out.print(p.getProposition() + "(" + p.isAnswer() + "), ");//Affichier les proposition faisant la conclusion deductible
		}
		la_regle.getConclusion().setAnswer(true);
		base_de_faits.add(la_regle.getConclusion());
		for(Proposition p:base_de_faits){
			if(base_terminaux.contains(p)){
				return true;
			}
		}
		System.out.println(" a permis d'établir " + le_fait.getProposition() + " " );//valeurFaitBase(le_fait));
		base_de_regles.remove(la_regle);
		return true;
	}
	
}
