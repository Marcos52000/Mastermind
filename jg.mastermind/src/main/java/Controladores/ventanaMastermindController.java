package Controladores;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Vistas.seleccionarNivel;
import Vistas.ventanaMastermind;

public class ventanaMastermindController {

	// metodo para rellenr la lista opciones
		public static void llenarLista() { 

			ventanaMastermind.colores.add(Color.yellow);
			ventanaMastermind.colores.add(Color.blue);
			ventanaMastermind.colores.add(Color.cyan);
			ventanaMastermind.colores.add(Color.darkGray);
			ventanaMastermind.colores.add(Color.gray);
			ventanaMastermind.colores.add(Color.green);
			ventanaMastermind.colores.add(Color.lightGray);
			ventanaMastermind.colores.add(Color.magenta);
			ventanaMastermind.colores.add(Color.orange);
			ventanaMastermind.colores.add(Color.pink);
			ventanaMastermind.colores.add(Color.red);
		}

	
	// crear colors
	public static void crea_colores(String nivel) {
		llenarLista();
		ArrayList<Color> colorDupe = (ArrayList<Color>) ventanaMastermind.colores.clone();
		int cont = 0;
		switch (nivel) {
		case "Principiante":
			ventanaMastermind.vidas = 10;
			do {
				int valorEntero = (int) Math.floor(Math.random() * (12 - 0) + 0);
				if (ventanaMastermind.coloresRand.contains(colorDupe.get(valorEntero))) {
				} else {
					ventanaMastermind.coloresRand.add(colorDupe.get(valorEntero));
					cont++;
				}
			} while (cont != 4);

			ventanaMastermind.color_fondo(0);
			break;
		case "Medio":
			ventanaMastermind.vidas = 8;
			do {
				int valorEntero = (int) Math.floor(Math.random() * (12 - 0) + 0);
				if (ventanaMastermind.coloresRand.contains(colorDupe.get(valorEntero))) {
				} else {
					ventanaMastermind.coloresRand.add(colorDupe.get(valorEntero));
					cont++;
				}
			} while (cont != 5);

			ventanaMastermind.color_fondo(1);
			break;
		case "Avanzado":
			ventanaMastermind.vidas = 6;
			do {
				int valorEntero = (int) Math.floor(Math.random() * (12 - 0) + 0);
				if (ventanaMastermind.coloresRand.contains(colorDupe.get(valorEntero))) {
				} else {
					ventanaMastermind.coloresRand.add(colorDupe.get(valorEntero));
					cont++;
				}
			} while (cont != 6);
			ventanaMastermind.color_fondo(2);
			break;
		default:
			break;
		}
	}
	
	public static void comprobarColor() {
		int correcto = 0;
		if (ventanaMastermind.jugar1.getBackground() == ventanaMastermind.secreta1.getBackground()) {
			ventanaMastermind.result1.setBackground(Color.black);
			correcto++;
		} else if (ventanaMastermind.jugar1.getBackground() == ventanaMastermind.secreta2.getBackground()
				|| ventanaMastermind.jugar1.getBackground() == ventanaMastermind.secreta3.getBackground()
				|| ventanaMastermind.jugar1.getBackground() == ventanaMastermind.secreta4.getBackground()) {
			ventanaMastermind.result1.setBackground(Color.white);
		}
		if (ventanaMastermind.jugar2.getBackground() == ventanaMastermind.secreta2.getBackground()) {
			ventanaMastermind.result2.setBackground(Color.black);
			correcto++;
		} else if (ventanaMastermind.jugar2.getBackground() == ventanaMastermind.secreta1.getBackground()
				|| ventanaMastermind.jugar2.getBackground() == ventanaMastermind.secreta3.getBackground()
				|| ventanaMastermind.jugar2.getBackground() == ventanaMastermind.secreta4.getBackground()) {
			ventanaMastermind.result2.setBackground(Color.white);
		}
		if (ventanaMastermind.jugar3.getBackground() == ventanaMastermind.secreta3.getBackground()) {
			ventanaMastermind.result3.setBackground(Color.black);
			correcto++;
		} else if (ventanaMastermind.jugar3.getBackground() == ventanaMastermind.secreta1.getBackground()
				|| ventanaMastermind.jugar3.getBackground() == ventanaMastermind.secreta2.getBackground()
				|| ventanaMastermind.jugar3.getBackground() == ventanaMastermind.secreta4.getBackground()) {
			ventanaMastermind.result3.setBackground(Color.white);
		}
		if (ventanaMastermind.jugar4.getBackground() == ventanaMastermind.secreta4.getBackground()) {
			ventanaMastermind.result4.setBackground(Color.black);
			correcto++;
		} else if (ventanaMastermind.jugar4.getBackground() == ventanaMastermind.secreta1.getBackground()
				|| ventanaMastermind.jugar4.getBackground() == ventanaMastermind.secreta2.getBackground()
				|| ventanaMastermind.jugar4.getBackground() == ventanaMastermind.secreta3.getBackground()) {
			ventanaMastermind.result4.setBackground(Color.white);
		}

		ventanaMastermind.comprobar.setVisible(false);

		if (correcto == 4) {
			JOptionPane.showMessageDialog(null, "Felicidades has acertado la combinacion secreta");
			System.exit(0);
		} else if (ventanaMastermind.vidas >= 1) {
			ventanaMastermind.vidas--;
			ventanaMastermind.crear_linea_bola();
		} else {
			JOptionPane.showMessageDialog(null, "Lo sentimos te has quedado sin vidas");
		}

	}
	
	// funcion nueva partida
		public static void borrar_componentes() {
			ventanaMastermind.frame.dispose();
			seleccionarNivel s1 = new seleccionarNivel();

		}
		
		// Action Listeners

		public static ActionListener nuevoJuegoAct = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				borrar_componentes();
			}

		};

		// funcion cambiar color de los botones al hacer click
		public static ActionListener comprobarColor = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaMastermind.resultPixel();
			}
		};
		
		public static ActionListener cambiarColor = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(ventanaMastermind.jugar1)) {
					if (ventanaMastermind.jugar1.getBackground() == Color.white) {
						ventanaMastermind.jugar1.setBackground(ventanaMastermind.coloresRand.get(0));
					} else {
						for (int i = 0; i < ventanaMastermind.coloresRand.size(); i++) {
							if (ventanaMastermind.jugar1.getBackground().equals(ventanaMastermind.coloresRand.get(i))) {
								if (i == ventanaMastermind.coloresRand.size() - 1) {
									ventanaMastermind.jugar1.setBackground(ventanaMastermind.coloresRand.get(0));
								} else {
									i++;
									ventanaMastermind.jugar1.setBackground(ventanaMastermind.coloresRand.get(i));
								}
							}
						}
					}

				}
				if (e.getSource().equals(ventanaMastermind.jugar2)) {
					if (ventanaMastermind.jugar2.getBackground() == Color.white) {
						ventanaMastermind.jugar2.setBackground(ventanaMastermind.coloresRand.get(0));
					} else {
						for (int i = 0; i < ventanaMastermind.coloresRand.size(); i++) {
							if (ventanaMastermind.jugar2.getBackground().equals(ventanaMastermind.coloresRand.get(i))) {
								if (i == ventanaMastermind.coloresRand.size() - 1) {
									ventanaMastermind.jugar2.setBackground(ventanaMastermind.coloresRand.get(0));
								} else {
									i++;
									ventanaMastermind.jugar2.setBackground(ventanaMastermind.coloresRand.get(i));
								}
							}
						}
					}

				}
				if (e.getSource().equals(ventanaMastermind.jugar3)) {
					if (ventanaMastermind.jugar3.getBackground() == Color.white) {
						ventanaMastermind.jugar3.setBackground(ventanaMastermind.coloresRand.get(0));
					} else {
						for (int i = 0; i < ventanaMastermind.coloresRand.size(); i++) {
							if (ventanaMastermind.jugar3.getBackground().equals(ventanaMastermind.coloresRand.get(i))) {
								if (i == ventanaMastermind.coloresRand.size() - 1) {
									ventanaMastermind.jugar3.setBackground(ventanaMastermind.coloresRand.get(0));
								} else {
									i++;
									ventanaMastermind.jugar3.setBackground(ventanaMastermind.coloresRand.get(i));
								}
							}
						}
					}

				}
				if (e.getSource().equals(ventanaMastermind.jugar4)) {
					if (ventanaMastermind.jugar4.getBackground() == Color.white) {
						ventanaMastermind.jugar4.setBackground(ventanaMastermind.coloresRand.get(0));
					} else {
						for (int i = 0; i < ventanaMastermind.coloresRand.size(); i++) {
							if (ventanaMastermind.jugar4.getBackground().equals(ventanaMastermind.coloresRand.get(i))) {
								if (i == ventanaMastermind.coloresRand.size() - 1) {
									ventanaMastermind.jugar4.setBackground(ventanaMastermind.coloresRand.get(0));
								} else {
									i++;
									ventanaMastermind.jugar4.setBackground(ventanaMastermind.coloresRand.get(i));
								}
							}
						}
					}

				}

			}
		};
		
		

		public static ActionListener acercade = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaMastermind.acercaDe();
			}
		};

}
