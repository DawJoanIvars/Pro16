package proc16;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
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
	private Equipo equipoModificar=new Equipo("",0, 0, 0, 0);

	/**
	 * Create the frame.
	 */
	public VentanaEquipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 261, 319);
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
		
		JButton guardarDatos = new JButton("Guardar Datos");
		guardarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				equipoModificar.setNombre(textEquipo.getText());
				equipoModificar.setgolesFavor(Integer.parseInt(textFavor.getText()));
				equipoModificar.setgolesContra(Integer.parseInt(textContra.getText()));
				equipoModificar.setPartidosGanados(Integer.parseInt(textGanados.getText()));
				equipoModificar.setPartidosPerdidos(Integer.parseInt(textPerdidos.getText()));
				guardarEquipo();
			}
		});
		guardarDatos.setBounds(10, 247, 117, 23);
		contentPane.add(guardarDatos);
	
	}
	
	private void guardarEquipo(){
		//
		ObjectOutputStream salida;
		try
		{
			salida= new ObjectOutputStream(new FileOutputStream("archivo.ser"));
			salida.writeObject(equipoModificar);
			if (salida !=null)
				salida.close();
		}
		catch(IOException ioException){
			System.err.println("Error al abrir el archivo.");
		}
	}
}
