import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class NewLoadGame extends Frame implements WindowListener{
	
	String fileName;
	Boolean New;
	Boolean choice;
	String [] Load= {"Load Game 01", "Load Game 02", "Load Game 03"};
	String IGN;
	String OSseparator;

	public NewLoadGame() {
		// TODO Auto-generated constructor stub
		super();
		this.choice = false;
		this.setLayout(new GridLayout(3, 2));
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
				
				jb.setPreferredSize(new Dimension(300,100));
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
				this.add(jb);
			}
		}
		
		this.pack();
		this.setVisible(true);
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
