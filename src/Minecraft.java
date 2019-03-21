import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;


public class Minecraft extends Frame implements WindowListener {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//* Test pour la partie de Nathan
		 
		Item i1 = new Item("i1");
		Item i2 = new Item("i2");
		Item[][] item1 = {{null,null,null},{i1,i1,null},{i2,null,null}};
		Item[][] item2 = {{i1,i1,null},{i2,null,null},{null,null,null}};
		Item[][] item3 = {{null,i1,i1},{null,i2,null},{null,null,null}};
		Item[][] item4 = {{null,null,null},{null,i1,i1},{null,i2,null}};
		
		Craft c1 = new Craft(i1,item1);
		Craft c2 = new Craft(i1,item2);
		Craft c3 = new Craft(i1,item3);
		Craft c4 = new Craft(i1,item4);
		//*/
		
		/*
		Item g1 = new Item("miniatures/pierre.jpg" ,"Pierre");
		Item g2 = new Item("miniatures/bloc_de_pierre.png" ,"Bloc de Pierre");
		Item g3 = new Item("miniatures/pierre.jpg" ,"Poutre de Pierre");
		Item g4 = new Item("miniatures/pierre.jpg", "Mur de Pierre");
		
		Item[][] BP = {{g1,g1,null},{g1,g1,null},{null,null,null}};
		Item[][] P = {{g2,null,null},{g2,null,null},{g2,null,null}}; 
		Item[][] MP = {{g3,g3,g3},{null,null,null},{null,null,null}}; 
		
		Craft c1 = new Craft(g2,BP); // craft d'un bloc de pierre
		Craft c2 = new Craft(g3,P); // craft d'une poutre de pierre
		Craft c3 = new Craft(g4,MP); // craft d'un mur de pierre
		
		System.out.println("Nos crafts possibles � partir de la pierre :");
		System.out.println("");
		c1.afficher();
		System.out.println("-----");
		c2.afficher();
		System.out.println("-----");
		c3.afficher();*/
		
		
		//test de la methode upperleft
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
		System.out.println(c4.compareTo(c2));
		//*/
		
		//test de structure de donne à utiliser
		//*
		c1.UpperLeft();
		HashMap<Craft, Item> ht = new HashMap<Craft,Item>();
		ht.put(c2,i1);
		Set<Craft> crafts = ht.keySet();
		for(Craft craft : crafts){
			if(c1.compareTo(craft.items)){
				System.out.println("here");
				System.out.println(ht.get(craft).image);
			}
		}//*/

		
		new Minecraft();

	}
	
	public Minecraft() {
		this.setLayout(new BorderLayout());
		
		Inventaire inv = new Inventaire();
		this.add(inv, BorderLayout.SOUTH);
		
		Recolte rec = new Recolte();
		this.add(rec,BorderLayout.EAST);
		
		this.addWindowListener(this);
		this.setTitle ("Table de craft Minecraft");
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
