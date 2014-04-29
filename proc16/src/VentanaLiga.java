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

import javax.swing.JComboBox;

public class VentanaLiga extends JFrame {

	private JPanel contentPane;
	private JTextField textNomreLiga;
	private JTextField textNumeroEquipos;
	private Liga liga;
	private Equipo equipo;
	
	JComboBox<Equipo> comboBox = new JComboBox<Equipo>();

	

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
		
		JLabel lblEqu = new JLabel("Equipo");
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
		
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		comboBox.setBounds(41, 166, 145, 20);
		contentPane.add(comboBox);
		
		JButton btnAñadir = new JButton("Añadir");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Añadir equipos
				//comboBox.addItem(new Equipo("Valencia",0,0,0,0));
				VentanaEquipo frame = new VentanaEquipo(new Equipo(),comboBox, liga);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnAñadir.setBounds(21, 225, 86, 23);
		contentPane.add(btnAñadir);
		
		JButton Modificar = new JButton("Modificar");
		Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaEquipo frame = new VentanaEquipo((Equipo)comboBox.getSelectedItem(),comboBox, liga);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		Modificar.setBounds(123, 225, 89, 23);
		contentPane.add(Modificar);
	}
}
