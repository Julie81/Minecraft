import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Item {
	public Image image;
	int quantity;
	String name;
	
	public Item(String n){ //test rapide sans image
		name = n;
	}
	
	public Item(String imagePath,String name) throws IOException{
		this.name = name;
		quantity = 0;
		image = ImageIO.read(new File(imagePath));
		
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
