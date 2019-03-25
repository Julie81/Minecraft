import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;


public class Minecraft extends Frame implements WindowListener {
	
	public static void main(String[] args) throws IOException {
		
		new Minecraft();

	}
	
	public Minecraft() {
		this.setLayout(new BorderLayout());
		
		Inventaire inv = new Inventaire();
		this.add(inv, BorderLayout.WEST);
		
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
