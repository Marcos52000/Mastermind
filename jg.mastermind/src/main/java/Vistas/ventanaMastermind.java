package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import Controladores.ventanaMastermindController;

public class ventanaMastermind extends JFrame {

	public static ArrayList<Color> colores = new ArrayList<Color>();
	public static ArrayList<Color> coloresRand = new ArrayList<Color>();
	public static JFrame frame;
	private static JPanel coloresPanel, combinacionPanel, panelDerecha, panelJuego, panelResult,resultPan, lineaJuego;
	public JMenuBar menuBar;
	public JMenu archivo, more;
	public JMenuItem comoJugar, nuevoJuego, acerca;

	// botones colores
	public static JButton color1, color2, color3, color4, color5, color6;
	// botones combinacion secreta
	public static JButton secreta1, secreta2, secreta3, secreta4;
	// botenes jugables
	public static JButton jugar1, jugar2, jugar3, jugar4;
	// botones resultado
	public static JButton result1, result2, result3, result4;
	public static Container cp;
	public static JButton comprobar;
	public static int vidas;


	public ventanaMastermind() {
		ventanaMastermindController.llenarLista();
		frame = new JFrame();
		frame.setTitle("MasterMind");
		// Definimos el size de la ventana
		frame.setBounds(300, 300, 900, 500);
		// hacemos que la ventana sea visible
		frame.setVisible(true);
		// Operacion que cuando se cierre la ventana terminara la aplicacion
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Creamos el panel
		cp = frame.getContentPane();

		// menu
		menuBar = new JMenuBar();
		archivo = new JMenu("Archivo");
		more = new JMenu("More");
		acerca = new JMenuItem("Acerca de");
		acerca.addActionListener(ventanaMastermindController.acercade);
		nuevoJuego = new JMenuItem("Nueva Partida");
		nuevoJuego.addActionListener(ventanaMastermindController.nuevoJuegoAct);
		archivo.add(nuevoJuego);
		more.add(acerca);
		menuBar.add(archivo);
		menuBar.add(more);
		cp.add(menuBar, BorderLayout.NORTH);
		paneles("Principiante");

	}

	// creadores
	public static void acercaDe() {
		JOptionPane.showMessageDialog(null, "Creado por el Grupo 5:Marcos,Pau,Albert");
	}

	// juego
	public static void paneles(String nivel) {
		// panel juego

		panelJuego = new JPanel();
		panelJuego.setLayout(new GridLayout(10, 1));
		crear_linea_bola();
		cp.add(panelJuego, BorderLayout.WEST);

		// panel comprobacion
		panelResult = new JPanel();
		panelResult.setLayout(new GridLayout(10, 1));
		cp.add(panelResult, BorderLayout.CENTER);

		// panel colores
		panelDerecha = new JPanel();
		panelDerecha.setLayout(new GridLayout(2, 1));
		coloresPanel = new JPanel();
		coloresPanel.setBorder(new TitledBorder("Colores"));
		ventanaMastermindController.crea_colores(nivel);
		panelDerecha.add(coloresPanel);

		// panel combinacion secreta
		combinacionPanel = new JPanel();
		combinacionPanel.setBorder(new TitledBorder("Combinacion Secreta"));
		crea_solucion(nivel);
		panelDerecha.add(combinacionPanel);
		cp.add(panelDerecha, BorderLayout.EAST);

	}



	// printar los colores con los que se puede jugar
	public static void color_fondo(int i) {
		color1 = new JButton();
		color1.setPreferredSize(new Dimension(30, 30));
		color1.setBackground(coloresRand.get(0));
		color2 = new JButton();
		color2.setPreferredSize(new Dimension(30, 30));
		color2.setBackground(coloresRand.get(1));
		color3 = new JButton();
		color3.setPreferredSize(new Dimension(30, 30));
		color3.setBackground(coloresRand.get(2));
		color4 = new JButton();
		color4.setPreferredSize(new Dimension(30, 30));
		color4.setBackground(coloresRand.get(3));
		coloresPanel.add(color1);
		coloresPanel.add(color2);
		coloresPanel.add(color3);
		coloresPanel.add(color4);
		if (i == 1) {
			color5 = new JButton();
			color5.setPreferredSize(new Dimension(30, 30));
			color5.setBackground(coloresRand.get(4));
			coloresPanel.add(color5);
		} else if (i == 2) {
			color5 = new JButton();
			color6 = new JButton();
			color5.setPreferredSize(new Dimension(30, 30));
			color6.setPreferredSize(new Dimension(30, 30));
			color5.setBackground(coloresRand.get(4));
			color6.setBackground(coloresRand.get(5));
			coloresPanel.add(color5);
			coloresPanel.add(color6);
		}
	}

	// crear solucion
	public static void crea_solucion(String nivel) {
		switch (nivel) {
		case "Principiante":
			Color combinacionSecreta[] = new Color[4];
			for (int i = 0; i < 4; i++) {
				int valorEntero = (int) Math.floor(Math.random() * (4 - 0) + 0);
				combinacionSecreta[i] = coloresRand.get(valorEntero);
			}
			secreta1 = new JButton();
			secreta1.setPreferredSize(new Dimension(30, 30));
			secreta1.setBackground(combinacionSecreta[0]);
			secreta2 = new JButton();
			secreta2.setPreferredSize(new Dimension(30, 30));
			secreta2.setBackground(combinacionSecreta[1]);
			secreta3 = new JButton();
			secreta3.setPreferredSize(new Dimension(30, 30));
			secreta3.setBackground(combinacionSecreta[2]);
			secreta4 = new JButton();
			secreta4.setPreferredSize(new Dimension(30, 30));
			secreta4.setBackground(combinacionSecreta[3]);
			combinacionPanel.add(secreta1);
			combinacionPanel.add(secreta2);
			combinacionPanel.add(secreta3);
			combinacionPanel.add(secreta4);
			break;

		case "Medio":
			Color combinacionSecreta2[] = new Color[5];
			for (int i = 0; i < 4; i++) {
				int valorEntero = (int) Math.floor(Math.random() * (5 - 0) + 0);
				combinacionSecreta2[i] = coloresRand.get(valorEntero);
			}
			secreta1 = new JButton();
			secreta1.setPreferredSize(new Dimension(30, 30));
			secreta1.setBackground(combinacionSecreta2[0]);
			secreta2 = new JButton();
			secreta2.setPreferredSize(new Dimension(30, 30));
			secreta2.setBackground(combinacionSecreta2[1]);
			secreta3 = new JButton();
			secreta3.setPreferredSize(new Dimension(30, 30));
			secreta3.setBackground(combinacionSecreta2[2]);
			secreta4 = new JButton();
			secreta4.setPreferredSize(new Dimension(30, 30));
			secreta4.setBackground(combinacionSecreta2[3]);
			combinacionPanel.add(secreta1);
			combinacionPanel.add(secreta2);
			combinacionPanel.add(secreta3);
			combinacionPanel.add(secreta4);
			break;

		case "Avanzado":
			Color combinacionSecreta3[] = new Color[6];
			for (int i = 0; i < 4; i++) {
				int valorEntero = (int) Math.floor(Math.random() * (6 - 0) + 0);

				combinacionSecreta3[i] = coloresRand.get(valorEntero);
			}
			secreta1 = new JButton();
			secreta1.setPreferredSize(new Dimension(30, 30));
			secreta1.setBackground(combinacionSecreta3[0]);
			secreta2 = new JButton();
			secreta2.setPreferredSize(new Dimension(30, 30));
			secreta2.setBackground(combinacionSecreta3[1]);
			secreta3 = new JButton();
			secreta3.setPreferredSize(new Dimension(30, 30));
			secreta3.setBackground(combinacionSecreta3[2]);
			secreta4 = new JButton();
			secreta4.setPreferredSize(new Dimension(30, 30));
			secreta4.setBackground(combinacionSecreta3[3]);
			combinacionPanel.add(secreta1);
			combinacionPanel.add(secreta2);
			combinacionPanel.add(secreta3);
			combinacionPanel.add(secreta4);
			break;
		default:
			break;
		}
	}

	// funcion crea linea de juego
	public static void crear_linea_bola() {
		lineaJuego = new JPanel();
		jugar1 = new JButton();
		jugar1.setPreferredSize(new Dimension(30, 30));
		jugar1.setBackground(Color.white);
		jugar1.addActionListener(ventanaMastermindController.cambiarColor);
		jugar2 = new JButton();
		jugar2.setPreferredSize(new Dimension(30, 30));
		jugar2.setBackground(Color.white);
		jugar2.addActionListener(ventanaMastermindController.cambiarColor);
		jugar3 = new JButton();
		jugar3.setPreferredSize(new Dimension(30, 30));
		jugar3.setBackground(Color.white);
		jugar3.addActionListener(ventanaMastermindController.cambiarColor);
		jugar4 = new JButton();
		jugar4.setPreferredSize(new Dimension(30, 30));
		jugar4.setBackground(Color.white);
		jugar4.addActionListener(ventanaMastermindController.cambiarColor);
		comprobar = new JButton("Comprobar");
		comprobar.addActionListener(ventanaMastermindController.comprobarColor);
		lineaJuego.add(jugar1);
		lineaJuego.add(jugar2);
		lineaJuego.add(jugar3);
		lineaJuego.add(jugar4);
		lineaJuego.add(comprobar);
		panelJuego.add(lineaJuego);

	}

	public static void resultPixel() {
		resultPan = new JPanel();
		result1 = new JButton();
		result1.setPreferredSize(new Dimension(30, 30));
		result2 = new JButton();
		result2.setPreferredSize(new Dimension(30, 30));
		result3 = new JButton();
		result3.setPreferredSize(new Dimension(30, 30));
		result4 = new JButton();
		result4.setPreferredSize(new Dimension(30, 30));
		resultPan.add(result1);
		resultPan.add(result2);
		resultPan.add(result3);
		resultPan.add(result4);
		panelResult.add(resultPan);
		ventanaMastermindController.comprobarColor();

	}





	

	

}
