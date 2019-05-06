import java.awt.Color;
import java.awt.Graphics;
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
	
	String fileName;	// Le nom du fichier sur lequel la sauvegrade va s'effectuer
	String fileNumber;	// Le numero de la partie
	Boolean New;	// Boolean permettant de savoir si on commence (ou recommence) une partie
	Boolean choice;	// Boolean permettant de savoir si l'utilisateur a fini de choisir
	String IGN;	// In Game Name => nom d'utilisateur
	HashMap<String,String> IDtoIGN;	// HashMap qui associe a un numero de partie un identifiant
	String OSseparator;	// Separateur utilisé lors de l'arborescence de fichier d'un OS
	Color fond = new Color (169,169,169);
	Color ecriture = new Color (139,69,19);

	public NewLoadGame() throws IOException {
		// TODO Auto-generated constructor stub
		super();
		//fenetre en plein ecran
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		//ajout de l'image de fond
		this.setBackgroundImage(this, new File("miniatures/fond_minecraft.jpg"));
		this.choice = false;
		//suppression du Layout
		this.setLayout(null);
		this.addWindowListener(this);
		this.IGN = "";
		
		
		JButton jb;
		
		File file = null;
		this.OSseparator = file.separator;	// initialise le separateur
		
		
		file = new File("miniatures"+OSseparator+"Save");	// Dossier contenant toutes les sauvegardes
		
		File[] files = file.listFiles();	// Liste des sauvegarde
        IDtoIGN = new HashMap<String,String>();
        
        for(File f : files) {
        	String[] split = f.getName().split("_",2);	// le "_" est utiliser ici pour separer le numero de partie de l'IGN
        	IDtoIGN.put(split[0], split[1].substring(0, split[1].length() -4));	// on enleve l'extension ".txt" de fichier a l'IGN
        }
		
		for (int i=1; i<4; i++){
			for (int j=0; j<2;j++){
				if(j==0) {
					jb = new JButton("New Game 0"+i);	// creation des boutons New Game 0X a gauche
				}
				else {
					if(IDtoIGN.containsKey(""+i)) {
						jb = new JButton(IDtoIGN.get(""+i));	// creation des boutons Load Game ayant le nom de l'utilisateur
						jb.setName(""+i+"_"+IDtoIGN.get(""+i));
					}
					else {
						jb = new JButton("Load Game 0"+i);	// creation des boutons Load Game 0X
						jb.setName(""+i+"_");
					}
					
				}
				
				jb.setBackground(this.fond);
				jb.setForeground(this.ecriture);
				jb.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String button = e.getActionCommand();
						
						choice = true; // l'utilisateur vient de faire un choix
						IGN = "";
						
						if(button.startsWith("N")) {	// le boutton est donc un New Game 0X
							New = true;	// on est bien sur une nouvelle partie
							
							IGN = JOptionPane.showInputDialog(null,
									"Entrez le nom de votre partie : ",
	                                "NOM DE LA PARTIE",
	                                JOptionPane.QUESTION_MESSAGE);
							if(IGN == null){
								IGN = "";	// boutton annuler
							}
							
							
							fileNumber = ""+button.charAt(button.length()-1);
							IGN = IGN.substring(0, 16); // Limite la taille des IGN pour ne pas deformer l'inventaire
							fileName =  "Save"+OSseparator+""+fileNumber+"_"+IGN;
							
							for(String number : IDtoIGN.keySet()){	// On va parcourir les IGN des parties existantes
								if(!number.equals(fileNumber)){	// On ne compare avec la meme partie car on va l'ecraser								
									if(IDtoIGN.get(number).equals(IGN)){
										choice = false;	// l'IGN existe deja dans une autres partie
										new ErrorMess(choice);

									}
								}
							}
						}
						else if(button.endsWith("_")) {	// si l'utilisateur charge une partie vide il creer une nouvelle partie
							New = true;
							IGN = JOptionPane.showInputDialog(null,
									"Entrez le nom de votre partie : ",
	                                "NOM DE LA PARTIE",
	                                JOptionPane.QUESTION_MESSAGE);
							
							if(IGN == null){
								IGN = "";	// boutton annuler
							}
							
							fileNumber = ""+button.charAt(button.length()-1);
							IGN = IGN.substring(0, 16); // Limite la taille des IGN pour ne pas deformer l'inventaire
							fileName =  "Save"+OSseparator+button+IGN;
							
							for(String number : IDtoIGN.keySet()){	// On va parcourir les IGN des parties existantes
								if(!number.equals(fileNumber)){	// On ne compare pas avec la meme partie car on va l'ecraser
									if(IDtoIGN.get(number).equals(IGN)){
										choice = false;	// l'IGN existe deja dans une autres partie
										new ErrorMess(choice);
									}
								}
							}
						}
						else {
							New = false;
							IGN = ((JButton) e.getSource()).getText();
							fileName =  "Save"+OSseparator+button;
						}
						
					}					
				});
				//placement du bouton dans la fenetre
				jb.setBounds(300*j+430, 100*i+200, 200, 50);
				jb.setActionCommand(jb.getName());
				//ajout du bouton
				this.add(jb);
				
			}
		}
		
		//placement et ajout du bouton quitter
		JButton quitter= new JButton("Quitter");
		quitter.setBackground(this.fond);
		quitter.setForeground(this.ecriture);
		//placement de quitter dans la fenetre
		quitter.setBounds(150+430, 100*4+200, 200, 50);
		this.add(quitter);
		quitter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		this.pack();
		this.setVisible(true);
	}
	
	public static JPanel setBackgroundImage(JFrame frame, final File img) throws IOException { //ajoute un fond d'ecran
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
