import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Craft {
	
	Item[] emptyLine= {null,null,null};
	Item[][] items;
	Item res;
	
	public Craft(Item i, Item[][] items){
		this.items = items;
		this.res = i;
	}
	
	public void UpperLeft(){ 
		
		/*
		Methode de transposition des items vers le coin en haut a gauche.
		Permet de réunir sous un même item des configurations differentes de ce même item.
		Ex : Une poutre de pierre est définie comme 3 pierres alignées verticalement.
		 -> Cette méthode permet de définir les 3 positions possibles de cet item ( à gauche, au milieu ou à droite )
		 de sorte que l'utilisateur n'est pas à se soucier du positionnement lorsque le craft est correct.
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
	
	public boolean compareTo(Craft craft){
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				
				if(this.items[i][j] == null && craft.items[i][j] != null){
					return false;
				}
				if(this.items[i][j] != null && craft.items[i][j] == null){
					return false;
				}
				
				if(!((this.items[i][j] == null && craft.items[i][j] == null) || this.items[i][j].compareTo(craft.items[i][j]))){
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
		System.out.println(this.res.name);
	}
}
