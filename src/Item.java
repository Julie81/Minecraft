import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Item {
	int quantity;
	String path;
	String name;
	int generation;
	String ID; //"nombre" entre 01 et 99 , 00 étant le manque d'item
	
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
	}
	
	public Item(String imagePath,String name,int generation,String ID) throws IOException{
		this.name = name;
		quantity = 0;
		this.path = imagePath;
		this.generation = generation;
		this.ID = ID;
	}
	
	
	public void add_Resources(){
		quantity++;
	}
	
	public void delete_Ressources(){
		quantity = 0;
	}
}
