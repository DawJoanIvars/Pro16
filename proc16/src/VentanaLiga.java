

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLiga extends JFrame {

	private JPanel contentPane;
	private JTextField textNomreLiga;
	private JTextField textNumeroEquipos;
	private JTextField textEquipomodificar;
	private Liga liga;
	private Equipo equipo;

	

	/**
	 * Create the frame.
	 */
	public VentanaLiga(Liga a) {
		setTitle("Ventana Liga");
		liga=a;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 303, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnombreLiga = new JLabel("Nombre de la Liga");
		lblnombreLiga.setBounds(41, 45, 127, 14);
		contentPane.add(lblnombreLiga);
		
		JLabel lblnumeroEquipos = new JLabel("Numero de Equipos");
		lblnumeroEquipos.setBounds(174, 45, 99, 14);
		contentPane.add(lblnumeroEquipos);
		
		JLabel lblEqu = new JLabel("Equipo a modificar");
		lblEqu.setBounds(41, 141, 99, 14);
		contentPane.add(lblEqu);
		
		textNomreLiga = new JTextField();
		textNomreLiga.setBounds(41, 70, 86, 20);
		contentPane.add(textNomreLiga);
		textNomreLiga.setColumns(10);
		
		textNumeroEquipos = new JTextField();
		textNumeroEquipos.setEditable(false);
		textNumeroEquipos.setBounds(174, 70, 86, 20);
		contentPane.add(textNumeroEquipos);
		textNumeroEquipos.setColumns(10);
		
		textEquipomodificar = new JTextField();
		textEquipomodificar.setBounds(41, 166, 86, 20);
		contentPane.add(textEquipomodificar);
		textEquipomodificar.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Creamos una manera de pasar equipo
				Equipo equipo=new Equipo("vnc",0, 0, 0, 0);
				//Aqui para abrir la ventana y que no cierre todo
				VentanaEquipo frame = new VentanaEquipo(equipo);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnModificar.setBounds(106, 241, 89, 23);
		contentPane.add(btnModificar);
	}
}
