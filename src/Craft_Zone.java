import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.ImageIcon;

public class Craft_Zone extends Panel{
	int larg=80;
	int quantite=1;
	
	public Craft_Zone() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 5;
		gbc.gridwidth = 7;
		
		for (int i=0; i<3; i++){
			gbc.gridy = i*larg;
			
			for (int j=0; j<3;j++){

				gbc.gridx = (j+1)*larg;
				JitmButton b = new JitmButton(null);
				b.setPreferredSize(new Dimension(larg,larg));
				b.setBackground(Color.WHITE);
				b.setText("");
				this.add(b,gbc);
			}
		}
		
		gbc.gridx = 0;
		gbc.gridy=larg;
		Button b = new Button("recharger");
		b.setBackground(Color.lightGray);
		b.setPreferredSize(new Dimension(80,30));
		this.add(b,gbc);
		
		gbc.gridx = 4*larg+20;
		gbc.gridy=larg;
		Label q = new Label(Integer.toString(quantite));
		this.add(q,gbc);
		
		gbc.gridx = 4*larg;;
		gbc.gridy=2*larg;
		Button plus= new Button("+");
		plus.setPreferredSize(new Dimension(30,30));
		plus.setBackground(Color.lightGray);
		this.add(plus,gbc);
		
		gbc.gridx = 4*larg+20;;
		gbc.gridy=2*larg;
		Button moins = new Button("-");
		moins.setPreferredSize(new Dimension(30,30));
		moins.setBackground(Color.lightGray);
		this.add(moins,gbc);
		
		gbc.gridx = 5*larg;;
		gbc.gridy=larg;
		Button craft = new Button("craft");
		craft.setPreferredSize(new Dimension(50,30));
		craft.setBackground(Color.lightGray);
		this.add(craft,gbc);
	}

}
