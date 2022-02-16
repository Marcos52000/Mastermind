package t5.jg.mastermind;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ventanaMastermind extends JFrame implements ActionListener {

	private static ArrayList<Color> colores = new ArrayList<Color>();
	private static ArrayList<Color> coloresRand = new ArrayList<Color>();
	public static JFrame frame, frame2;
	private static JPanel coloresPanel, combinacionPanel, panelDerecha, panelJuego, niveles,botones;
	public JMenuBar menuBar;
	public JMenu archivo,ayuda, more;
	public JMenuItem comoJugar, nuevoJuego, salir;
	public static PictureBox p1, p2, p3, p4,p5,p6;
	public static Container cp, cp2;
	public static JButton cancelar, aceptar;
	public static JRadioButton principiante,medio,avanzado;

	public static ButtonGroup group;

	public ventanaMastermind() {
		llenarLista();
		frame = new JFrame();
		frame.setTitle("MasterMind");
		// Definimos el size de la ventana
		frame.setBounds(500, 500, 500, 200);
		// hacemos que la ventana sea visible
		frame.setVisible(true);
		// Operacion que cuando se cierre la ventana terminara la aplicacion
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Creamos el panel
		cp = frame.getContentPane();

		// menu
		menuBar = new JMenuBar();
		archivo = new JMenu("Archivo");
		ayuda = new JMenu("Ayuda");
		nuevoJuego = new JMenuItem("Nueva Partida");
		nuevoJuego.addActionListener(nuevoJuegoAct);
		salir = new JMenuItem("Salir");
		archivo.add(nuevoJuego);
		archivo.add(salir);
		menuBar.add(archivo);
		menuBar.add(ayuda);
		cp.add(menuBar, BorderLayout.NORTH);
		paneles("Principiante");

	}

	public static void paneles(String nivel) {
		// panel juego

		panelJuego = new JPanel();
		crear_linea_bola();
		cp.add(panelJuego);

		// panel colores
		panelDerecha = new JPanel();
		panelDerecha.setLayout(new GridLayout(2, 1));
		coloresPanel = new JPanel();
		coloresPanel.setBorder(new TitledBorder("Colores"));
		crea_colores(nivel);
		panelDerecha.add(coloresPanel);

		// panel combinacion secreta
		combinacionPanel = new JPanel();
		combinacionPanel.setBorder(new TitledBorder("Combinacion Secreta"));
		crea_solucion(nivel);
		panelDerecha.add(combinacionPanel);
		cp.add(panelDerecha, BorderLayout.EAST);

	}

	// crear colors
	public static void crea_colores(String nivel) {
		llenarLista();
		switch (nivel) {
		case "Principiante":

			ArrayList<Color> colorDupe = (ArrayList<Color>) colores.clone();

			for (int i = 0; i < 4; i++) {
				int valorEntero = (int) Math.floor(Math.random() * (11 - 0) + 0);
				coloresRand.add(colorDupe.get(valorEntero));
				colorDupe.remove(valorEntero);
			}
			p1 = new PictureBox();
			p1.setBackground(coloresRand.get(0));
			p2 = new PictureBox();
			p2.setBackground(coloresRand.get(1));
			p3 = new PictureBox();
			p3.setBackground(coloresRand.get(2));
			p4 = new PictureBox();
			p4.setBackground(coloresRand.get(3));
			coloresPanel.add(p1);
			coloresPanel.add(p2);
			coloresPanel.add(p3);
			coloresPanel.add(p4);
			break;
		case "Medio":
			ArrayList<Color> colorDupe2 = (ArrayList<Color>) colores.clone();

			for (int i = 0; i < 5; i++) {
				int valorEntero = (int) Math.floor(Math.random() * (11 - 0) + 0);
				coloresRand.add(colorDupe2.get(valorEntero));
				colorDupe2.remove(valorEntero);
			}
			p1 = new PictureBox();
			p1.setBackground(coloresRand.get(0));
			p2 = new PictureBox();
			p2.setBackground(coloresRand.get(1));
			p3 = new PictureBox();
			p3.setBackground(coloresRand.get(2));
			p4 = new PictureBox();
			p4.setBackground(coloresRand.get(3));
			p5 = new PictureBox();
			p5.setBackground(coloresRand.get(4));
			coloresPanel.add(p1);
			coloresPanel.add(p2);
			coloresPanel.add(p3);
			coloresPanel.add(p4);
			coloresPanel.add(p5);
			break;
		default:
			break;
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

			p1 = new PictureBox();
			p1.setBackground(combinacionSecreta[0]);
			p2 = new PictureBox();
			p2.setBackground(combinacionSecreta[1]);
			p3 = new PictureBox();
			p3.setBackground(combinacionSecreta[2]);
			p4 = new PictureBox();
			p4.setBackground(combinacionSecreta[3]);
			combinacionPanel.add(p1);
			combinacionPanel.add(p2);
			combinacionPanel.add(p3);
			combinacionPanel.add(p4);
			break;

		case "Medio":
			Color combinacionSecreta2[] = new Color[5];
			for (int i = 0; i < 4; i++) {
				int valorEntero = (int) Math.floor(Math.random() * (5 - 0) + 0);

				combinacionSecreta2[i] = coloresRand.get(valorEntero);
			}

			p1 = new PictureBox();
			p1.setBackground(combinacionSecreta2[0]);
			p2 = new PictureBox();
			p2.setBackground(combinacionSecreta2[1]);
			p3 = new PictureBox();
			p3.setBackground(combinacionSecreta2[2]);
			p4 = new PictureBox();
			p4.setBackground(combinacionSecreta2[3]);
			p5 = new PictureBox();
			p5.setBackground(combinacionSecreta2[4]);
			combinacionPanel.add(p1);
			combinacionPanel.add(p2);
			combinacionPanel.add(p3);
			combinacionPanel.add(p4);
			combinacionPanel.add(p5);
			break;
		default:
			break;
		}
	}

	// funcion crea linea de juego
	public static void crear_linea_bola() {
		p1 = new PictureBox();
		p1.setBackground(Color.white);
		p2 = new PictureBox();
		p2.setBackground(Color.white);
		p3 = new PictureBox();
		p3.setBackground(Color.white);
		p4 = new PictureBox();
		p4.setBackground(Color.white);
		JButton comprobar = new JButton("Comprobar");
		panelJuego.add(p1);
		panelJuego.add(p2);
		panelJuego.add(p3);
		panelJuego.add(p4);
		panelJuego.add(comprobar);

	}

	// funcion nueva partida
	public static void borrar_componentes() {
		frame.dispose();
		selec_nivel();
		
	}
	
	
	// funcion que lanza ventana para seleccionar nivel
	public static void selec_nivel() {
		frame2 = new JFrame();
		frame2.setTitle("Seleccion Nivel");
		// Definimos el size de la ventana
		frame2.setBounds(500, 500, 500, 200);
		// hacemos que la ventana sea visible
		frame2.setVisible(true);
		// Operacion que cuando se cierre la ventana terminara la aplicacion
		frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Creamos el panel
		cp2 = frame2.getContentPane();

		niveles = new JPanel(new GridLayout(0, 1));
		niveles.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		niveles.setBackground(Color.WHITE);
		niveles.setBounds(88, 38, 186, 228);
		
		//radio Buttons
		principiante = new JRadioButton("Principiante",true);
		medio = new JRadioButton("Medio",false);
		avanzado = new JRadioButton("Avanzado",false);

		// Group the radio buttons.
		group = new ButtonGroup();
		group.add(principiante);
		group.add(medio);
		group.add(avanzado);
		
		niveles.add(principiante);
		niveles.add(medio);
		niveles.add(avanzado);
		cp2.add(niveles,BorderLayout.CENTER);

		
		botones = new JPanel();
		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(aceptarNivel);
		aceptar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		aceptar.setBounds(53, 290, 94, 25);
		botones.add(aceptar);

		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(cancelarNivel);
		cancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cancelar.setBounds(199, 288, 94, 28);
		botones.add(cancelar);
		cp2.add(botones,BorderLayout.SOUTH);
		
	}

	public static void llenarLista() { // metodo para rellenr la lista opciones

		colores.add(Color.yellow);
		colores.add(Color.blue);
		colores.add(Color.cyan);
		colores.add(Color.darkGray);
		colores.add(Color.gray);
		colores.add(Color.green);
		colores.add(Color.lightGray);
		colores.add(Color.magenta);
		colores.add(Color.orange);
		colores.add(Color.pink);
		colores.add(Color.red);
	}

	
	
	
	
	
	// Action Listeners 
	
	
	ActionListener nuevoJuegoAct = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			borrar_componentes();
		}

	};
	
	static ActionListener aceptarNivel = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			   if(principiante.isSelected()) {
	                frame2.dispose();
	                ventanaMastermind v1 = new ventanaMastermind();
	    			for (int i = 0; i < coloresRand.size(); i++) {
	    				coloresRand.remove(i);
	    			}
	    			paneles("Principiante");
	            }
	            else if (medio.isSelected()) {
	                frame2.dispose();
	                ventanaMastermind v1 = new ventanaMastermind();
	    			for (int i = 0; i < coloresRand.size(); i++) {
	    				coloresRand.remove(i);
	    			}
	    			paneles("Medio");
	            }
	            else if (avanzado.isSelected()) {
	                frame2.dispose();
	                ventanaMastermind v1 = new ventanaMastermind();
	    			for (int i = 0; i < coloresRand.size(); i++) {
	    				coloresRand.remove(i);
	    			}
	    			paneles("Avanzado");
	            }
			
		}
		
	};
	
	static ActionListener cancelarNivel = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame2.dispose();
			System.exit(ABORT);
		}
	};

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
