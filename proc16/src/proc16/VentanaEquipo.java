package proc16;

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

public class VentanaEquipo extends JFrame {

	private JPanel contentPane;
	private JTextField textFavor;
	private JTextField textContra;
	private JTextField textGanados;
	private JTextField textPerdidos;
	private JTextField textEquipo;
	
	private Equipo equipoModificar;
	private JButton LeerDatos;

	/**
	 * Create the frame.
	 */
	public VentanaEquipo(Equipo mePasanEquipo) {
		equipoModificar=mePasanEquipo;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 268, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel equipo = new JLabel("Equipo");
		equipo.setBounds(10, 30, 46, 14);
		contentPane.add(equipo);
		
		JLabel golesFavor = new JLabel("Goles a favor");
		golesFavor.setBounds(10, 80, 94, 14);
		contentPane.add(golesFavor);
		
		JLabel golesContra = new JLabel("Goles en contra");
		golesContra.setBounds(10, 105, 94, 14);
		contentPane.add(golesContra);
		
		JLabel partidosGanados = new JLabel("Partidos ganados");
		partidosGanados.setBounds(10, 154, 111, 14);
		contentPane.add(partidosGanados);
		
		JLabel partidosPerdidos = new JLabel("Partidos perdidos");
		partidosPerdidos.setBounds(10, 179, 111, 14);
		contentPane.add(partidosPerdidos);
		
		textEquipo = new JTextField();
		textEquipo.setBounds(82, 27, 102, 20);
		contentPane.add(textEquipo);
		textEquipo.setColumns(10);
		
		textFavor = new JTextField();
		textFavor.setBounds(131, 74, 53, 20);
		contentPane.add(textFavor);
		textFavor.setColumns(10);
		
		textContra = new JTextField();
		textContra.setBounds(131, 102, 53, 20);
		contentPane.add(textContra);
		textContra.setColumns(10);
		
		textGanados = new JTextField();
		textGanados.setBounds(131, 151, 53, 20);
		contentPane.add(textGanados);
		textGanados.setColumns(10);
		
		textPerdidos = new JTextField();
		textPerdidos.setBounds(131, 176, 53, 20);
		contentPane.add(textPerdidos);
		textPerdidos.setColumns(10);
		//Boton Guardar datos
		JButton guardarDatos = new JButton("Guardar Datos");
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
		guardarDatos.setBounds(10, 247, 117, 23);
		contentPane.add(guardarDatos);
		//Boton Leer Datos
		LeerDatos = new JButton("Leer Datos");
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
		LeerDatos.setBounds(146, 247, 96, 23);
		contentPane.add(LeerDatos);
	
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
