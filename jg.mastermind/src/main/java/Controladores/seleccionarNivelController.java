package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vistas.*;

public class seleccionarNivelController {

	
	//action que dependiendo el nievel crea una partida
		public static ActionListener aceptarNivel = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (seleccionarNivel.principiante.isSelected()) {
					seleccionarNivel.frame2.dispose();
					ventanaMastermind v1 = new ventanaMastermind();
					ventanaMastermind.coloresRand.clear();
					ventanaMastermind.paneles("Principiante");
				} else if (seleccionarNivel.medio.isSelected()) {
					seleccionarNivel.frame2.dispose();
					ventanaMastermind v1 = new ventanaMastermind();
					ventanaMastermind.coloresRand.clear();
					ventanaMastermind.paneles("Medio");
				} else if (seleccionarNivel.avanzado.isSelected()) {
					seleccionarNivel.frame2.dispose();
					ventanaMastermind v1 = new ventanaMastermind();
					ventanaMastermind.coloresRand.clear();
					ventanaMastermind.paneles("Avanzado");
				}

			}

		};

		public static ActionListener cancelarNivel = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seleccionarNivel.frame2.dispose();
				System.exit(0);
			}
		};
}
