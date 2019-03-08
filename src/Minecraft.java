import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;


public class Minecraft extends Frame implements WindowListener {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
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
		
		new Minecraft();

	}
	
	public Minecraft() {
		this.setLayout(new BorderLayout());
		
		Inventaire inv = new Inventaire();
		this.add(inv, BorderLayout.SOUTH);
		
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
		//System.exit(0);
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
