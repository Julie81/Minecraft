import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;

public class Memoire extends Canvas{
	int larg=30;
	public Memoire () {
		super();
		this.setPreferredSize(new Dimension(6*larg,4*larg));
	}
	
	public void paint (Graphics g){
		for (int i=0;i<3;i++){
			for (int j=0;j<3;j++){
				g.drawRect(i*larg+10, j*larg+10, larg, larg);
			}
		}
		g.drawRect(4*larg+10, larg+10, larg, larg);
	}
	
}
