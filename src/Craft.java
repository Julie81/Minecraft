import java.util.HashMap;

public class Craft { // recette d'un item 
	
	Item[] emptyLine= {null,null,null}; // raccourci pour indiquer une ligne vide
	Item[][] items; // la fameuse recette
	Item item; // l'item correspondant 
	
	public Craft(Item i, Item[][] items){ // Constructeur a partir du nom de l'item et d'une matrice 3x3 d'items
		this.items = items;
		this.item = i;
	}

	
	public HashMap<Item,Integer> quantityNeeded() { // table des liens entre un item et sa quantite
		HashMap<Item,Integer> quantityNeeded = new HashMap<Item,Integer>(); // initialisation hashmap vide
		for(Item[] itemLine : this.items) { // selection des lignes de la matrice
			for(Item item : itemLine) { // parcours des items de la ligne selectionnee
				if(item != null) { // si la case est vide on passe a l'item suivant de la ligne
					if(quantityNeeded.containsKey(item)) { // on observe une occurence de plus
						quantityNeeded.put(item, quantityNeeded.get(item)+1); // on incremente la quantite necessaire de l'item
					}
					else { // on observe notre premiere occurence de cet item
						quantityNeeded.put(item,1);
					}
				}
			}
		}
		return quantityNeeded; // renvoi la hashmap des items et des occurences associees
	}
	
	public int getMaxGeneration() { // renvoi de la generation max des items du crafts
		int maxGen = 0; // initialisation de la generation maximale a 1
		// parcours de la matrice pour calculer la generation max des items presents dans le craft
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(this.items[i][j] != null) {
					maxGen = Math.max(maxGen,this.items[i][j].generation()); // on recherche la generation de l'item
				}
			}
		}
		return maxGen;
	}
	
	public String getCraftUID() { // compile les UID des items du craft pour creer une cle unique identifiant le craft et la renvoi
		String ID = ""; // initialisation au mot vide
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(this.items[i][j] != null) {
					ID += this.items[i][j].ID; // superposition des UID des items
				}
				else {
					ID += "99"; // UID de l'item null
				}
			}
		}
		return ID;
	}
	
	public void UpperLeft(){ 
		
		/*
		Methode de transposition des items vers le coin en haut a gauche.
		Permet de reunir sous un meme item des configurations differentes mais equivalentes.
		Ex : Une fleche est definie comme le vecteur colonne ( pierre, baton, plume ).
		 -> Cette methode permet de definir les 3 positions possibles de cet item (a gauche, au milieu ou a droite )
		 de sorte que l'utilisateur n'est pas a se soucier du positionnement lorsque le craft est correct.
		*/
		
		int cptUpper = 0; // nombre de ligne analyse
		
		//Upper
		while(items[0][0] == null && items[0][1] == null && items[0][2] == null && cptUpper<2){ // cptUpper est le variant qui fait sortir de la boucle 
			// on decale tout vers le haut
			items[0] = items[1];
			items[1] = items[2];
			items[2] = emptyLine;
			cptUpper++; // on a analyse une ligne de plus
		}
		
		int cptLeft = 0;  // nombre de colonne analyse
		
		//left
		while(items[0][0] == null && items[1][0] == null && items[2][0] == null && cptLeft<2){ // cptLeft est le variant qui fait sortir de la boucle 
			// on decale tout vers la gauche
			for(int i=0;i<3;i++){
				for(int j=1;j<3;j++){
					items[i][j-1] = items[i][j];
				}
				items[i][2] = null;
			}
			cptLeft++; // on a analyse une colonne de plus
		}
	}

// FONCTIONS DE TESTS
	
	public void afficher() {  // affiche toutes les informations concernant le craft ( matrice de craft et nom de l'item )
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
	}
}
