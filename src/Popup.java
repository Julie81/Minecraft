import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;

public class Popup{
	Frame pop;
	
	public Popup(int x,int y, Dimension d) {
		pop = new Frame();
		pop.setPreferredSize(new Dimension(d));
		this.pop.setBackground(new Color(0, 10, 145));
		pop.setLocation(x, y);
		Label lb = new Label();
		lb.setForeground(Color.white);
		lb.setText("Random File successfully deleted");
		lb.setAlignment(lb.CENTER);
		pop.add(lb);
		pop.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
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
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				pop.dispose();
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		pop.setSize(d);
		pop.pack();
		this.pop.setVisible(true);
	}
}