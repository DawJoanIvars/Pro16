package proc16;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaLiga extends JFrame {

	private JPanel contentPane;
	private JTextField textNomreLiga;
	private JTextField textNumeroEquipos;
	private JTextField textEquipomodificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLiga frame = new VentanaLiga();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLiga() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnombreLiga = new JLabel("Nombre de la Liga");
		lblnombreLiga.setBounds(41, 33, 127, 14);
		contentPane.add(lblnombreLiga);
		
		JLabel lblnumeroEquipos = new JLabel("Numero de Equipos");
		lblnumeroEquipos.setBounds(264, 33, 99, 14);
		contentPane.add(lblnumeroEquipos);
		
		JLabel lblEqu = new JLabel("Equipo a modificar");
		lblEqu.setBounds(41, 116, 99, 14);
		contentPane.add(lblEqu);
		
		textNomreLiga = new JTextField();
		textNomreLiga.setBounds(41, 58, 86, 20);
		contentPane.add(textNomreLiga);
		textNomreLiga.setColumns(10);
		
		textNumeroEquipos = new JTextField();
		textNumeroEquipos.setBounds(264, 58, 86, 20);
		contentPane.add(textNumeroEquipos);
		textNumeroEquipos.setColumns(10);
		
		textEquipomodificar = new JTextField();
		textEquipomodificar.setBounds(41, 141, 86, 20);
		contentPane.add(textEquipomodificar);
		textEquipomodificar.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(41, 197, 89, 23);
		contentPane.add(btnModificar);
	}
}
