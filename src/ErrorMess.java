import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ErrorMess extends Frame implements WindowListener{
	
	public ErrorMess(String mess) {
		super();
		this.setTitle(mess);
		Label m = new Label("L'objet que vous essayez de créer n'existe pas.");
		m.setBackground(new Color(139,108,66));
		m.setVisible(true);
		m.setFont(new Font("Arial",Font.BOLD,16));
		m.setForeground(Color.white);
		this.add(m);
		this.addWindowListener(this);
		this.setVisible(true);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	public ErrorMess(ArrayList<Item> itemManquant) {
		super();
		this.setTitle("Not wealthy enough...");
		this.setVisible(true);
		this.setBackground(new Color(139,108,66));
		this.addWindowListener(this);
		
		//Layout
		GridBagLayout gd = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(gd);
		
		Label m = new Label("Action impossible : Les ressources suivantes ne sont pas en quantité suffisante.");
		m.setBackground(new Color(139,108,66));
		m.setVisible(true);
		m.setFont(new Font("Arial",Font.BOLD,16));
		m.setForeground(Color.white);
		gbc.gridx=0;
		gbc.gridy=0;
		this.add(m,gbc);
		
		Box objets = Box.createHorizontalBox();
		for(int i=0;i<itemManquant.size();i++){
			JLabel p = new JLabel();
			ImageIcon icon = new ImageIcon(itemManquant.get(i).path);
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance( 90, 90,  java.awt.Image.SCALE_SMOOTH ) ;
			icon = new ImageIcon(newimg);
			p.setIcon(icon);
			p.setBackground(null);
			p.setVisible(true);
			p.setOpaque(true);
			objets.add(p);
		}
		gbc.gridy=1;
		this.add(objets,gbc);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
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
		this.dispose();
		
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
