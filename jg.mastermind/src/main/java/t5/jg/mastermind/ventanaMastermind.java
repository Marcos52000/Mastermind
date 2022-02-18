package t5.jg.mastermind;

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

public class ventanaMastermind extends JFrame {

	private static ArrayList<Color> colores = new ArrayList<Color>();
	private static ArrayList<Color> coloresRand = new ArrayList<Color>();
	public static JFrame frame, frame2;
	private static JPanel coloresPanel, combinacionPanel, panelDerecha, panelJuego, niveles, botones, panelResult,
			resultPan, lineaJuego;
	public JMenuBar menuBar;
	public JMenu archivo, ayuda, more;
	public JMenuItem comoJugar, nuevoJuego, salir, acerca;

	// botones colores
	public static JButton color1, color2, color3, color4, color5, color6;
	// botones combinacion secreta
	public static JButton secreta1, secreta2, secreta3, secreta4;
	// botenes jugables
	public static JButton jugar1, jugar2, jugar3, jugar4;
	// botones resultado
	public static JButton result1, result2, result3, result4;
	public static Container cp, cp2;
	public static JButton cancelar, aceptar, comprobar;
	public static JRadioButton principiante, medio, avanzado;
	public static int vidas;

	public static ButtonGroup group;

	public ventanaMastermind() {
		llenarLista();
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
		ayuda = new JMenu("Ayuda");
		more = new JMenu("More");
		acerca = new JMenuItem("Acerca de");
		acerca.addActionListener(acercade);
		nuevoJuego = new JMenuItem("Nueva Partida");
		nuevoJuego.addActionListener(nuevoJuegoAct);
		salir = new JMenuItem("Salir");
		archivo.add(nuevoJuego);
		archivo.add(salir);
		more.add(acerca);
		menuBar.add(archivo);
		menuBar.add(ayuda);
		menuBar.add(more);
		cp.add(menuBar, BorderLayout.NORTH);
		paneles("Principiante");

	}

	// creadores
	public static void acercaDe() {
		JOptionPane.showMessageDialog(null, "Creado por el Grupo 5:Marcos,Pau,Albert");
	}

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
		ArrayList<Color> colorDupe = (ArrayList<Color>) colores.clone();
		int cont = 0;
		switch (nivel) {
		case "Principiante":
			vidas = 10;
			do {
				int valorEntero = (int) Math.floor(Math.random() * (12 - 0) + 0);
				if (coloresRand.contains(colorDupe.get(valorEntero))) {
				} else {
					coloresRand.add(colorDupe.get(valorEntero));
					cont++;
				}
			} while (cont != 4);

			color_fondo(0);
			break;
		case "Medio":
			vidas = 8;
			do {
				int valorEntero = (int) Math.floor(Math.random() * (12 - 0) + 0);
				if (coloresRand.contains(colorDupe.get(valorEntero))) {
				} else {
					coloresRand.add(colorDupe.get(valorEntero));
					cont++;
				}
			} while (cont != 5);

			color_fondo(1);
			break;
		case "Avanzado":
			vidas = 6;
			do {
				int valorEntero = (int) Math.floor(Math.random() * (12 - 0) + 0);
				if (coloresRand.contains(colorDupe.get(valorEntero))) {
				} else {
					coloresRand.add(colorDupe.get(valorEntero));
					cont++;
				}
			} while (cont != 6);
			color_fondo(2);
			break;
		default:
			break;
		}
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
		jugar1.addActionListener(cambiarColor);
		jugar2 = new JButton();
		jugar2.setPreferredSize(new Dimension(30, 30));
		jugar2.setBackground(Color.white);
		jugar2.addActionListener(cambiarColor);
		jugar3 = new JButton();
		jugar3.setPreferredSize(new Dimension(30, 30));
		jugar3.setBackground(Color.white);
		jugar3.addActionListener(cambiarColor);
		jugar4 = new JButton();
		jugar4.setPreferredSize(new Dimension(30, 30));
		jugar4.setBackground(Color.white);
		jugar4.addActionListener(cambiarColor);
		comprobar = new JButton("Comprobar");
		comprobar.addActionListener(comprobarColor);
		lineaJuego.add(jugar1);
		lineaJuego.add(jugar2);
		lineaJuego.add(jugar3);
		lineaJuego.add(jugar4);
		lineaJuego.add(comprobar);
		panelJuego.add(lineaJuego);

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

		// radio Buttons
		principiante = new JRadioButton("Principiante", true);
		medio = new JRadioButton("Medio", false);
		avanzado = new JRadioButton("Avanzado", false);

		// Group the radio buttons.
		group = new ButtonGroup();
		group.add(principiante);
		group.add(medio);
		group.add(avanzado);

		niveles.add(principiante);
		niveles.add(medio);
		niveles.add(avanzado);
		cp2.add(niveles, BorderLayout.CENTER);

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
		cp2.add(botones, BorderLayout.SOUTH);

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

		comprobarColor();

	}

	public static void comprobarColor() {
		int correcto = 0;
		if (jugar1.getBackground() == secreta1.getBackground()) {
			result1.setBackground(Color.black);
			correcto++;
		} else if (jugar1.getBackground() == secreta2.getBackground()
				|| jugar1.getBackground() == secreta3.getBackground()
				|| jugar1.getBackground() == secreta4.getBackground()) {
			result1.setBackground(Color.white);
		}
		if (jugar2.getBackground() == secreta2.getBackground()) {
			result2.setBackground(Color.black);
			correcto++;
		} else if (jugar2.getBackground() == secreta1.getBackground()
				|| jugar2.getBackground() == secreta3.getBackground()
				|| jugar2.getBackground() == secreta4.getBackground()) {
			result2.setBackground(Color.white);
		}
		if (jugar3.getBackground() == secreta3.getBackground()) {
			result3.setBackground(Color.black);
			correcto++;
		} else if (jugar3.getBackground() == secreta1.getBackground()
				|| jugar3.getBackground() == secreta2.getBackground()
				|| jugar3.getBackground() == secreta4.getBackground()) {
			result3.setBackground(Color.white);
		}
		if (jugar4.getBackground() == secreta4.getBackground()) {
			result4.setBackground(Color.black);
			correcto++;
		} else if (jugar4.getBackground() == secreta1.getBackground()
				|| jugar4.getBackground() == secreta2.getBackground()
				|| jugar4.getBackground() == secreta3.getBackground()) {
			result4.setBackground(Color.white);
		}

		comprobar.setVisible(false);

		if (correcto == 4) {
			JOptionPane.showMessageDialog(null, "Felicidades has acertado la combinacion secreta");
			System.exit(0);
		} else if (vidas >= 1) {
			vidas--;
			crear_linea_bola();
		} else {
			JOptionPane.showMessageDialog(null, "Lo sentimos te has quedado sin vidas");
		}

	}

	// Action Listeners

	ActionListener nuevoJuegoAct = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			borrar_componentes();
		}

	};

	// funcion cambiar color de los botones al hacer click
	static ActionListener comprobarColor = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			resultPixel();
		}
	};

	static ActionListener aceptarNivel = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (principiante.isSelected()) {
				frame2.dispose();
				ventanaMastermind v1 = new ventanaMastermind();
				coloresRand.clear();
				paneles("Principiante");
			} else if (medio.isSelected()) {
				frame2.dispose();
				ventanaMastermind v1 = new ventanaMastermind();
				coloresRand.clear();
				paneles("Medio");
			} else if (avanzado.isSelected()) {
				frame2.dispose();
				ventanaMastermind v1 = new ventanaMastermind();
				coloresRand.clear();
				paneles("Avanzado");
			}

		}

	};

	static ActionListener cancelarNivel = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame2.dispose();
			System.exit(ABORT);
		}
	};

	static ActionListener cambiarColor = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(jugar1)) {
				if (jugar1.getBackground() == Color.white) {
					jugar1.setBackground(coloresRand.get(0));
				} else {
					for (int i = 0; i < coloresRand.size(); i++) {
						if (jugar1.getBackground().equals(coloresRand.get(i))) {
							if (i == coloresRand.size() - 1) {
								jugar1.setBackground(coloresRand.get(0));
							} else {
								i++;
								jugar1.setBackground(coloresRand.get(i));
							}
						}
					}
				}

			}
			if (e.getSource().equals(jugar2)) {
				if (jugar2.getBackground() == Color.white) {
					jugar2.setBackground(coloresRand.get(0));
				} else {
					for (int i = 0; i < coloresRand.size(); i++) {
						if (jugar2.getBackground().equals(coloresRand.get(i))) {
							if (i == coloresRand.size() - 1) {
								jugar2.setBackground(coloresRand.get(0));
							} else {
								i++;
								jugar2.setBackground(coloresRand.get(i));
							}
						}
					}
				}

			}
			if (e.getSource().equals(jugar3)) {
				if (jugar3.getBackground() == Color.white) {
					jugar3.setBackground(coloresRand.get(0));
				} else {
					for (int i = 0; i < coloresRand.size(); i++) {
						if (jugar3.getBackground().equals(coloresRand.get(i))) {
							if (i == coloresRand.size() - 1) {
								jugar3.setBackground(coloresRand.get(0));
							} else {
								i++;
								jugar3.setBackground(coloresRand.get(i));
							}
						}
					}
				}

			}
			if (e.getSource().equals(jugar4)) {
				if (jugar4.getBackground() == Color.white) {
					jugar4.setBackground(coloresRand.get(0));
				} else {
					for (int i = 0; i < coloresRand.size(); i++) {
						if (jugar4.getBackground().equals(coloresRand.get(i))) {
							if (i == coloresRand.size() - 1) {
								jugar4.setBackground(coloresRand.get(0));
							} else {
								i++;
								jugar4.setBackground(coloresRand.get(i));
							}
						}
					}
				}

			}

		}
	};

	static ActionListener acercade = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("hola");
			acercaDe();
		}
	};

}
