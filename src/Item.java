import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import javax.imageio.ImageIO;


public class Item {
	int quantity;
	String path;
	String name;
	int generation;
	Color variation; // couleur modelisant la variation de la quantite
	String ID; //"nombre" entre 00 et 98 , 99 etant le manque d'item
	Craft craft;
	ArrayList<Item> lock;
	
	public Item(String n){ //test rapide sans image
		name = n;
	}
	
	public Item(String imagePath,String name) throws IOException{ //methode sans UID pour faire des test
		this.name = name;
		quantity = 0;
		this.path = imagePath;
		generation = 0;
	}
	
	public Item(String imagePath,String name,String ID) throws IOException{
		this.name = name;
		quantity = 0;
		this.path = imagePath;
		generation = 0;
		this.ID = ID;
		this.craft = null;
		this.generation = -1;
		this.lock = new ArrayList<Item>();
	}
	
	public void add_Resources(int q){
		quantity += q;
		this.variation = Color.green;
	}
	
	public void setCraft(Craft craft) {
		this.craft = craft;
	}
	
	public int generation() {
		if(generation >= 0) {
			return generation;
		}
		if(this.craft == null) {
			generation = 0;
			return generation;
		}
		else {
			generation = this.craft.getMaxGeneration()+1;
			return generation;
		}
	}

	public void del_Resources(int q) {
		quantity = quantity - q;
		if (quantity == 0) {
			this.variation = Color.red;
		}
		else{
			this.variation = Color.cyan;
		}
	}
}
