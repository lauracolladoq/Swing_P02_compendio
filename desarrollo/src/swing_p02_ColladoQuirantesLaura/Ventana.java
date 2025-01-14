/**
 * Ventana.java
 * 14 oct 2024 20:22:39
 * @author Laura Collado Quirantes
 */
package swing_p02_ColladoQuirantesLaura;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

// TODO: Auto-generated Javadoc
/**
 * La Clase Ventana.
 */
public class Ventana extends JFrame {

	/** El nombre. */
	private String nombre;
	
	/** La etiqueta. */
	private JLabel etiqueta;

	/**
	 * Instanciar una nueva ventana.
	 */
	public Ventana() {
		super("Swing Práctica 02 - Collado Quirantes Laura");
		this.setBounds(50, 50, 600, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Mostrar mensaje de advertencia
		MyIcon icon = new MyIcon();
		JOptionPane.showMessageDialog(this, "Estás ejecutando una aplicación Java", "Advertencia",
				JOptionPane.WARNING_MESSAGE, icon);

		// Preguntar el nombre al usuario
		nombre = JOptionPane.showInputDialog("¿Cuál es tu nombre?");

		// Saludar al usuario con su nombre
		if (nombre != null && !nombre.trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hola " + nombre, "Saludo", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "No introduciste ningún nombre", "Error", JOptionPane.ERROR_MESSAGE);
		}

		// Mostrar opciones
		String[] opciones = { "Teclado", "Ratón", "Monitor" };
		int seleccion = JOptionPane.showOptionDialog(this, "Selecciona una opción:", "Opciones",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		// Crear la etiqueta que muestra la opción elegida
		etiqueta = new JLabel("", SwingConstants.CENTER);
		this.add(etiqueta, BorderLayout.CENTER);

		if (seleccion == 0) {
			etiqueta.setText("Has seleccionado el teclado.");
		} else if (seleccion == 1) {
			etiqueta.setText("Has seleccionado el ratón.");
		} else if (seleccion == 2) {
			etiqueta.setText("Has seleccionado el monitor.");
		} else {
			etiqueta.setText("No seleccionaste ninguna opción.");
		}

		// Confirmar la selección
		int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás de acuerdo con tu selección?", "Confirmación",
				JOptionPane.YES_NO_OPTION);

		// Si el usuario no está de acuerdo se vacía la etiqueta
		if (confirmacion == JOptionPane.NO_OPTION) {
			etiqueta.setText("");
		}

		this.setVisible(true);
	}

	/**
	 * La Clase MyIcon.
	 */
	// Icono de taza de java
	private class MyIcon implements Icon {
		
		/**
		 * Pintar icono
		 *
		 * @param c de c
		 * @param g de g
		 * @param x de x
		 * @param y de y
		 */
		@Override
		public void paintIcon(Component c, Graphics g, int x, int y) {
			try {
				Image imagen = ImageIO.read(getClass().getResource("/recursos/taza.png"));
				g.drawImage(imagen, x, y, c);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(c, "Imagen No Encontrada", "Atención", JOptionPane.WARNING_MESSAGE);
			}
		}

		/**
		 * Obtener el ancho del icono
		 *
		 * @return el ancho del icono
		 */
		@Override
		public int getIconWidth() {
			return 50;
		}

		/**
		 *  Obtener el alto del icono
		 *
		 * @return el alto del icono
		 */
		@Override
		public int getIconHeight() {
			return 50;
		}
	}

}
