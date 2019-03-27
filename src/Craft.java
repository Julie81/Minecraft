import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Craft {
	
	Item[] emptyLine= {null,null,null};
	Item[][] items;
	Item item;
	
	public Craft(Item i, Item[][] items){
		this.items = items;
		this.item = i;
	}
	
	public int minQuantity() {
		int min = -1;
		for(Item[] itemLine : this.items) {
			for(Item item : itemLine) {
				if(item != null) {
					if(min<0) {
						min = item.quantity;
					}
					else {
						min = Math.min(min,item.quantity);
					}
				}
			}
		}
		return min;
	}
	
	public int getMaxGeneration() {
		int maxGen = 0;
		for(int i=0;i<3;i++){
			for(int j=1;j<3;j++){
				if(this.items[i][j] != null) {
					maxGen = Math.max(maxGen,this.items[i][j].generation);
				}
			}
		}
		return maxGen;
	}
	
	public String getCraftUID() {
		String UID = "";
		for(int i=0;i<3;i++){
			for(int j=1;j<3;j++){
				if(this.items[i][j] != null) {
					UID += this.items[i][j].UID;
				}
				else {
					UID += "00";
				}
			}
		}
		return UID;
	}
	
	public void UpperLeft(){ 
		
		/*
		Methode de transposition des items vers le coin en haut a gauche.
		Permet de r�unir sous un m�me item des configurations differentes de ce m�me item.
		Ex : Une poutre de pierre est d�finie comme 3 pierres align�es verticalement.
		 -> Cette m�thode permet de d�finir les 3 positions possibles de cet item ( � gauche, au milieu ou � droite )
		 de sorte que l'utilisateur n'est pas � se soucier du positionnement lorsque le craft est correct.
		*/
		
		int cptUpper = 0;
		
		//Upper
		while(items[0][0] == null && items[0][1] == null && items[0][2] == null && cptUpper<2){
			items[0] = items[1];
			items[1] = items[2];
			items[2] = emptyLine;
			cptUpper++;
		}
		
		int cptLeft = 0;
		
		//left
		while(items[0][0] == null && items[1][0] == null && items[2][0] == null && cptLeft<2){
			for(int i=0;i<3;i++){
				for(int j=1;j<3;j++){
					items[i][j-1] = items[i][j];
				}
				items[i][2] = null;
			}
			cptLeft++;
		}
	}
	
	public boolean compareTo(Item[][] craft){
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				
				if(this.items[i][j] == null && craft[i][j] != null){
					return false;
				}
				if(this.items[i][j] != null && craft[i][j] == null){
					return false;
				}
				
				if(!((this.items[i][j] == null && craft[i][j] == null) || this.items[i][j].compareTo(craft[i][j]))){
						return false;
				}

			}
		}
		return true;
	}
	
	public void afficher() {  // affiche toutes les informations concernant le craft ( matrice de craft, nom de l'item et bientot son image )
		for(int i=0;i<3;i++){
			String lign = "";
			for(int j=0;j<3;j++){
				if(this.items[i][j]!=null){
					lign += this.items[i][j].name + "|";
				}
				else {
					lign += "None" +"|";
				}
			}
			System.out.println(lign);
		}
		System.out.println("---------------------");
		System.out.println(this.item.name);
	}
}
