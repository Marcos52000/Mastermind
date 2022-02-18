package t5.jg.mastermind;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

public class PictureBox extends JButton {

	/**
	 * 
	 */

	public PictureBox(String nombre) { // contructor por defecto
		super();
		this.setBorder(null);
		this.setOpaque(true);
		this.setContentAreaFilled(false);
		this.setBackground(Color.yellow);
		this.setForeground(Color.BLACK);
		this.setPreferredSize(new Dimension(30, 30));
		this.setOpaque(true);
		this.setSize(30, 30);
		this.setName(nombre);
		
		
	}

	public void setColor(Color c) {
		this.setBackground(c);
		this.setForeground(Color.BLACK);
	}

	public PictureBox copiar(PictureBox p) {
		PictureBox aux = new PictureBox("aux");
		aux.setBackground(p.getBackground());
		return aux;
	}
	
	public Color getColor() {
        Color color = this.getBackground();
        return color;
    }
	
    
}
