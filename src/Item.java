import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

public class Item {
	int quantity; // sa quantite
	String path; // chemin local de l'image le representant
	String name; // nom de l'item
	int generation;
	Color variation; // couleur modelisant la variation de la quantite
	String ID; //"nombre" entre 00 et 98 ; 99 => item vide
	int x; // position colonne dans l'inventaire
	int y; // position ligne dans l'inventaire
	Craft craft; // recette associe
	ArrayList<Item> lock; // liste item necessaire pour debloquer cet item
	
	public Item(String imagePath,String name,String ID) throws IOException{
		this.name = name;
		quantity = 0;
		this.path = imagePath;
		this.ID = ID;
		this.craft = null;
		this.generation = -1;
		this.lock = new ArrayList<Item>(); // pas d'item bloquant pour le moment
	}
	
	public void add_Resources(int q){  // incrementation de q de la quantite de l'item select
		quantity += q;
		this.variation = Color.green; // la variation est croissante donc verte
	}
	
	public void setCraft(Craft craft) { // attribution du craft
		this.craft = craft; 
	}
	
	public int generation() {  // renvoi la generation de l'item
		
		if(generation >= 0) {
			return generation;
		}
		
		if(this.craft == null) { // l'item est une ressource naturelle et a donc peut etre un lock
			generation = 0;
			for(int i=0;i< this.lock.size();i++) {
				generation = Math.max(generation,lock.get(i).generation()+1); 
			}
			// calcul de la generation avec le max de ces items bloquants
			return generation;
		}
		
		else {
			generation = this.craft.getMaxGeneration()+1;
			return generation;
		}
	}

	public void del_Resources(int q) { // decrementation de q de la quantite de l'item select
		quantity = quantity - q;
		if (quantity == 0) {
			this.variation = Color.red; // reserve de l'item vide => mise en valeur
		}
		else{
			this.variation = Color.cyan; // simple notification de decrementation de quantite
		}
	}
	
	public boolean unlock() { // renvoi un booleen indiquant si l'item est disponible ou non
		boolean lock = false;
		for(int i=0;i<this.lock.size();i++) { // parcours des items bloquants
			lock |= (this.lock.get(i).quantity==0); // verification de la possession de ces items
		}
		return !lock;
	}
}
