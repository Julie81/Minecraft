import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class Popup extends Frame implements WindowListener{
	
	public Popup(int x,int y, Dimension d) {
		super();
		this.setPreferredSize(new Dimension(d));
		this.setBackground(new Color(0, 10, 145));
		this.setLocation(x, y);
		Label lb = new Label();
		lb.setForeground(Color.white);
		lb.setText("Random File successfully deleted");
		lb.setAlignment(lb.CENTER);
		this.add(lb);
		this.setSize(d);
		this.pack();
		this.addWindowListener(this);
		this.setVisible(true);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		dispose();
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}