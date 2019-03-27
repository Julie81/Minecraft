import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Item {
	public Image image;
	int quantity;
	String name;
	int generation;
	String UID; //"nombre" entre 01 et 99 , 00 étant le manque d'item
	
	public Item(String n){ //test rapide sans image
		name = n;
	}
	
	public Item(String imagePath,String name) throws IOException{ //methode sans UID pour faire des test
		this.name = name;
		quantity = 0;
		image = ImageIO.read(new File(imagePath));
		generation = 0;
	}
	
	public Item(String imagePath,String name,int UID) throws IOException{
		this.name = name;
		quantity = 0;
		image = ImageIO.read(new File(imagePath));
		generation = 0;
		this.UID = UID+"";
	}
	
	public Item(String imagePath,String name,int generation,int UID) throws IOException{
		this.name = name;
		quantity = 0;
		image = ImageIO.read(new File(imagePath));
		this.generation = generation;
		this.UID = UID+"";
	}
	
	
	public void add_Resources(){
		quantity++;
	}
	
	public void delete_Ressources(){
		quantity = 0;
	}
	
	public boolean compareTo(Item item){
		return this.name.equals(item.name);
				
	}
}
