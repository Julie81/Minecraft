import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NewLoadGame extends JFrame implements WindowListener{
	
	String fileName;
	Boolean New;
	Boolean choice;
	String [] Load= {"Load Game 01", "Load Game 02", "Load Game 03"};
	String IGN;
	String OSseparator;

	public NewLoadGame() throws IOException {
		// TODO Auto-generated constructor stub
		super();
		this.setBackgroundImage(this, new File("miniatures/fond_minecraft.jpg"));
		this.choice = false;
		this.setLayout(new GridLayout(5, 4));
		GridBagConstraints gbc = new GridBagConstraints();
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(dimension);
		this.addWindowListener(this);
		this.IGN = "";
		
		
		JButton jb;
		
		//file loader
		
		File file = null;
		this.OSseparator = file.separator;
		
		
		file = new File("miniatures"+OSseparator+"Save");
		
		File[] files = file.listFiles();
        HashMap<String,String> IDtoIGN = new HashMap<String,String>();
        
        for(File f : files) {
        	String[] split = f.getName().split("_");
        	IDtoIGN.put(split[0], split[1].replaceAll(".txt", ""));
        }
		
		for (int i=1; i<4; i++){
			for (int j=0; j<2;j++){
				if(j==0) {
					jb = new JButton("New Game 0"+i);
				}
				else {
					if(IDtoIGN.containsKey("itemID0"+i)) {
						jb = new JButton(IDtoIGN.get("itemID0"+i));
						jb.setName("itemID0"+i+"_"+IDtoIGN.get("itemID0"+i));
					}
					else {
						jb = new JButton(Load[i-1]);
						jb.setName("itemID0"+i+"_");
					}
					
				}
				
				jb.setPreferredSize(new Dimension(20,50));
				jb.setBackground(Color.DARK_GRAY);
				jb.setForeground(Color.WHITE);
				jb.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String button = e.getActionCommand();
						if(button.startsWith("N")) {
							New = true;
							IGN = JOptionPane.showInputDialog(null,
									"Entrez le nom de votre partie : ",
	                                "NOM DE LA PARTIE",
	                                JOptionPane.QUESTION_MESSAGE);
							try{
								IGN = IGN.replace('_', ' ');	// interdir l'utilisation de _
							}catch(Exception e1){
								IGN = "";	//utilisation du boutton annuler
							}
							fileName =  "Save"+OSseparator+"itemID0"+button.charAt(button.length()-1)+"_"+IGN;
							}
						else if(button.endsWith("_")) {
							New = true;
							IGN = JOptionPane.showInputDialog(null,
									"Entrez le nom de votre partie : ",
	                                "NOM DE LA PARTIE",
	                                JOptionPane.QUESTION_MESSAGE);
							try{
								IGN = IGN.replace('_', ' ');	// interdir l'utilisation de _
							}catch(Exception e1){
								IGN = "";	//utilisation du boutton annuler
							}
							fileName =  "Save"+OSseparator+button+IGN;
						}
						else {
							New = false;
							IGN = " "; // L'IGN existe deja donc on autorise l'acces au document
							fileName =  "Save"+OSseparator+button;
						}
						choice = true;
					}
					
					
				});
				jb.setActionCommand(jb.getName());
				gbc.gridx=(i+1)*100;
				gbc.gridy=(j+1)*300;
				//this.add(jb,gbc);
			}
		}
		Label blanc=new Label("");
		blanc.setPreferredSize(new Dimension (900,900));
		gbc.gridx=0;
		gbc.gridy=0;
		//this.add(blanc,gbc);
		
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	
	public static JPanel setBackgroundImage(JFrame frame, final File img) throws IOException { 
		JPanel panel = new JPanel() { 
			private static final long serialVersionUID = 1;
			private BufferedImage buf = ImageIO.read(img);
			@Override protected void paintComponent(Graphics g)
			{ super.paintComponent(g); g.drawImage(buf, 0,0, this.getWidth(),this.getHeight(), null); }
		};
		frame.setContentPane(panel); 
		return panel; }
	
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
		// TODO Auto-generated method stub
		System.exit(0);
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
