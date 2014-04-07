

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaEquipo extends JFrame {

	private JPanel contentPane;
	private JTextField textFavor;
	private JTextField textContra;
	private JTextField textGanados;
	private JTextField textPerdidos;
	private JTextField textEquipo;
	
	private Equipo equipoModificar;
	private JButton LeerDatos;
	private JTextField textposicionJugador;
	private JTextField textNombreJugador;
	private Equipo jugador;

	/**
	 * Create the frame.
	 */
	public VentanaEquipo(Equipo mePasanEquipo) {
		setTitle("Ventana Equipo");
		equipoModificar=mePasanEquipo;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel equipo = new JLabel("Equipo");
		equipo.setBounds(5, 8, 41, 14);
		contentPane.add(equipo);
		
		textEquipo = new JTextField();
		textEquipo.setBounds(51, 5, 148, 20);
		contentPane.add(textEquipo);
		textEquipo.setColumns(10);
		
		JLabel golesFavor = new JLabel("Goles a favor");
		golesFavor.setBounds(5, 36, 103, 14);
		contentPane.add(golesFavor);
		
		textFavor = new JTextField();
		textFavor.setBounds(113, 30, 86, 20);
		contentPane.add(textFavor);
		textFavor.setColumns(10);
		
		JLabel golesContra = new JLabel("Goles en contra");
		golesContra.setBounds(5, 58, 75, 14);
		contentPane.add(golesContra);
		
		textContra = new JTextField();
		textContra.setBounds(113, 55, 86, 20);
		contentPane.add(textContra);
		textContra.setColumns(10);
		
		JLabel partidosGanados = new JLabel("Partidos ganados");
		partidosGanados.setBounds(5, 83, 103, 14);
		contentPane.add(partidosGanados);
		//Boton Leer Datos
		LeerDatos = new JButton("Leer Datos");
		LeerDatos.setBounds(5, 158, 125, 23);
		LeerDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Aqui hacemos que salte al metodo de recuperar datos del fichero.
				recuperarEquipo();
				//Empezamos a decirle que deje los datos que escrivimos anteriormente.
				textEquipo.setText(equipoModificar.getNombre());
				textFavor.setText(String.valueOf((equipoModificar.getgolesFavor())));
				textContra.setText(String.valueOf((equipoModificar.getgolesContra())));
				textGanados.setText(String.valueOf((equipoModificar.getPartidosGanados())));
				textPerdidos.setText(String.valueOf((equipoModificar.getPartidosPerdidos())));

			}
		});
		
		textGanados = new JTextField();
		textGanados.setBounds(113, 80, 86, 20);
		contentPane.add(textGanados);
		textGanados.setColumns(10);
		
		JLabel partidosPerdidos = new JLabel("Partidos perdidos");
		partidosPerdidos.setBounds(5, 108, 103, 14);
		contentPane.add(partidosPerdidos);
		//Boton Guardar datos
		JButton guardarDatos = new JButton("Guardar Datos");
		guardarDatos.setBounds(5, 130, 125, 23);
		guardarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Empezamos a decirle que coja y meta los que escrivimos.			
				equipoModificar.setNombre(textEquipo.getText());
				equipoModificar.setgolesFavor(Integer.parseInt(textFavor.getText()));
				equipoModificar.setgolesContra(Integer.parseInt(textContra.getText()));
				equipoModificar.setPartidosGanados(Integer.parseInt(textGanados.getText()));
				equipoModificar.setPartidosPerdidos(Integer.parseInt(textPerdidos.getText()));
				//Aqui hacemos que salte al metodo de guardar en un fichero.
				guardarEquipo();
			}
		});
		
		textPerdidos = new JTextField();
		textPerdidos.setBounds(113, 105, 86, 20);
		contentPane.add(textPerdidos);
		textPerdidos.setColumns(10);
		contentPane.add(guardarDatos);
		contentPane.add(LeerDatos);
		
		textposicionJugador = new JTextField();
		textposicionJugador.setBounds(174, 207, 47, 20);
		contentPane.add(textposicionJugador);
		textposicionJugador.setColumns(10);
		
		JLabel lblPosicionDelJugador = new JLabel("Posicion del Jugador");
		lblPosicionDelJugador.setBounds(230, 210, 120, 14);
		contentPane.add(lblPosicionDelJugador);
		
		JLabel lblNombreDelJugador = new JLabel("Nombre del Jugador");
		lblNombreDelJugador.setBounds(174, 238, 125, 14);
		contentPane.add(lblNombreDelJugador);
		
		textNombreJugador = new JTextField();
		textNombreJugador.setBounds(174, 265, 86, 20);
		contentPane.add(textNombreJugador);
		textNombreJugador.setColumns(10);
		
		JButton btnMostrarJugador = new JButton("Mostrar Jugador");
		btnMostrarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				jugador.devolberJugador(Integer.parseInt(textposicionJugador.getText()));
				//Esto esta mal en jugador.debolverJugador(0)
				textposicionJugador.setText(String.valueOf((jugador.devolberJugador(Integer.parseInt(textposicionJugador.getText())))));
				
				}
				catch(NumberFormatException error ){
					System.err.println("Error al mostrar el Jugador.");
				}
			}
		});
		btnMostrarJugador.setBounds(5, 206, 148, 21);
		contentPane.add(btnMostrarJugador);
		
		JButton btnNewButton = new JButton("Modificar Jugador");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(5, 234, 148, 20);
		contentPane.add(btnNewButton);
	
	}
	//Configuramos el método para guardar en un fichero lo escrito.
	private void guardarEquipo(){
		//Utilizamos el tipo ObjectOutputStream para poder guardar lo cojido anteriormente.
		ObjectOutputStream salida;
		try
		{
			//Le decimos que cree un archivo llamado archivo de extension .ser.
			salida= new ObjectOutputStream(new FileOutputStream("archivo.ser"));
			salida.writeObject(equipoModificar);
			//
			if (salida !=null)	
				salida.close();
		}//Le decimos que si hay error salga un comentario.
		catch(IOException ioException){
			System.err.println("Error al abrir el archivo.");
		}
	}
		//Configuramos el método para guardar en un fichero lo escrito.
		private void recuperarEquipo(){
			//Utilizamos el tipo ObjectOutputStream para poder guardar lo cojido anteriormente.
			ObjectInputStream entrada;
			try
			{
				//Le decimos que cree un archivo llamado archivo de extension .ser.
				entrada= new ObjectInputStream(new FileInputStream("archivo.ser"));
				equipoModificar=(Equipo)entrada.readObject();
				//
				if (entrada !=null)
					entrada.close();
			}//Le decimos que si hay error salga un comentario.
			catch(IOException ioException){
				System.err.println("Error al abrir el archivo.");
			}
			catch( ClassNotFoundException ClException){
				System.err.println("Error al abrir el archivo.");
			}
	}
}
