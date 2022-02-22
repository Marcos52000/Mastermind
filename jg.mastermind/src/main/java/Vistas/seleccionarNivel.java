package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;

import Controladores.seleccionarNivelController;

public class seleccionarNivel extends JFrame {
	public static JFrame frame2;
	public static Container cp2;
	public static JPanel niveles,botones;
	public static JButton aceptar,cancelar;
	public static JRadioButton principiante, medio, avanzado ;
	public static ButtonGroup group;

	public seleccionarNivel() {
		
	frame2=new JFrame();
	frame2.setTitle("Seleccion Nivel");
	// Definimos el size de la ventana
	frame2.setBounds(500,500,500,200);
	// hacemos que la ventana sea visible
	frame2.setVisible(true);
	// Operacion que cuando se cierre la ventana terminara la aplicacion
	frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
	// Creamos el panel
	cp2=frame2.getContentPane();

	niveles=new JPanel(new GridLayout(0,1));niveles.setBorder(new BevelBorder(BevelBorder.LOWERED,null,null,null,null));niveles.setBackground(Color.WHITE);niveles.setBounds(88,38,186,228);

	// radio Buttons
	principiante=new JRadioButton("Principiante",true);medio=new JRadioButton("Medio",false);avanzado=new JRadioButton("Avanzado",false);

	// Group the radio buttons.
	group=new ButtonGroup();
	group.add(principiante);
	group.add(medio);
	group.add(avanzado);

	niveles.add(principiante);
	niveles.add(medio);
	niveles.add(avanzado);
	cp2.add(niveles,BorderLayout.CENTER);

	botones=new JPanel();
	aceptar=new JButton("Aceptar");
	aceptar.addActionListener(seleccionarNivelController.aceptarNivel);
	aceptar.setFont(new Font("Tahoma",Font.PLAIN,13));
	aceptar.setBounds(53,290,94,25);botones.add(aceptar);

	cancelar=new JButton("Cancelar");
	cancelar.addActionListener(seleccionarNivelController.cancelarNivel);
	cancelar.setFont(new Font("Tahoma",Font.PLAIN,13));
	cancelar.setBounds(199,288,94,28);botones.add(cancelar);
	cp2.add(botones,BorderLayout.SOUTH);
	}
}
