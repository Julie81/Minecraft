import java.io.IOException;
import java.util.HashMap;
import java.util.Set;


public class Minecraft {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("hi");
		Item i1 = new Item("i1");
		Item i2 = new Item("i2");
		Item[][] item1 = {{null,null,null},{i1,i1,null},{i2,null,null}};
		Item[][] item2 = {{i1,i1,null},{i2,null,null},{null,null,null}};
		Item[][] item3 = {{null,i1,i1},{null,i2,null},{null,null,null}};
		Item[][] item4 = {{null,null,null},{null,i1,i1},{null,i2,null}};
		
		Craft c1 = new Craft(item1);
		Craft c2 = new Craft(item2);
		Craft c3 = new Craft(item3);
		Craft c4 = new Craft(item4);

		//test de la emthode upperleft
		/*
		System.out.println(c1.compareTo(c2));
		c1.UpperLeft();
		System.out.println(c1.compareTo(c2));
		System.out.println();
		System.out.println(c3.compareTo(c2));
		c3.UpperLeft();
		System.out.println(c3.compareTo(c2));
		System.out.println();
		System.out.println(c4.compareTo(c2));
		c4.UpperLeft();
		System.out.println(c4.compareTo(c2));*/
		
		//test de structure de donne à utiliser
		/*
		c1.UpperLeft();
		HashMap<Craft, Item> ht = new HashMap<Craft,Item>();
		ht.put(c2,i1);
		Set<Craft> crafts = ht.keySet();
		for(Craft craft : crafts){
			if(c1.compareTo(craft)){
				System.out.println("here");
				System.out.println();
			}
		}*/

	}

}
