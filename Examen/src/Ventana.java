import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;


public class Ventana extends JFrame {

	private JPanel contentPane;
	//Definimos p para poder ver la clase Trabajador, que tiene herencia de Persona.
	private Trabajador p;
	private JTextField textNombre;
	private JTextField textVacaciones;
	private JTextField textEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		//Añadimos p que sea igual a la clase trabajador.
		p = new Trabajador();
		setTitle("Programa de la empresa.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//De manera gráfica añadimos los botones, nombres, etc.
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(40, 33, 75, 14);
		contentPane.add(lblNombre);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(182, 105, 46, 14);
		contentPane.add(lblEstado);
		
		JLabel lblVacaciones = new JLabel("Vacaciones");
		lblVacaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblVacaciones.setBounds(301, 33, 75, 14);
		contentPane.add(lblVacaciones);
		
		textNombre = new JTextField();
		textNombre.setBounds(10, 58, 133, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textVacaciones = new JTextField();
		textVacaciones.setBounds(271, 58, 133, 20);
		contentPane.add(textVacaciones);
		textVacaciones.setColumns(10);
		
		textEstado = new JTextField();
		textEstado.setEditable(false);
		textEstado.setHorizontalAlignment(SwingConstants.CENTER);
		textEstado.setBounds(51, 130, 299, 62);
		contentPane.add(textEstado);
		textEstado.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar  Datos");
		btnGuardar.addActionListener(new ActionListener() {
		//Empezamos a configurar las acciones del boton Guardar Datos.
			public void actionPerformed(ActionEvent arg0) {
				//Añadimos objetos donde guardar los datos.
				String Nom;
				int Vac;
				//Para que la informacion vaya a get/set de Nombre ponemos:
				Nom=textNombre.getText();
				p.setNombre(Nom);
				Nom=p.getNombre();
				//Para evitar errores ponemos:
				try{
					Vac=Integer.parseInt(textVacaciones.getText());
					p.setVacaciones(Vac);
					//Para que si hay anteriormente informacion se renueve con el texto en blanco.
					textEstado.setText("");
				}
				//Si hay un caracter saltará el error.
				catch (NumberFormatException error ){
					//Añadimos el mensaje que mostrará si hay error.
					textEstado.setText("THAS EQUIVOCAO");
				}
			}
		});
		btnGuardar.setBounds(40, 215, 133, 23);
		contentPane.add(btnGuardar);
		
		JButton btnEstado = new JButton("Estado");
		btnEstado.addActionListener(new ActionListener() {
		//Empezamos a configurar las acciones del boton Estado.
			public void actionPerformed(ActionEvent arg0) {
				//Añadimos objetos donde guardar los datos.
				String Nom;
				int Vac;
				//Para que la informacion vaya a get/set de Nombre ponemos:
				Nom=textNombre.getText();
				p.setNombre(""+Nom);
				Nom=p.getNombre();
				//Para evitar errores ponemos:
				try{
					Vac=Integer.parseInt(textVacaciones.getText());
					p.setVacaciones(Vac);
					//Pondremos que si es menor a 5 salga un mensaje y si es mallor otro.
					if (p.getVacaciones() <=  5){
						textEstado.setText("El trabajador " + p.getNombre() + " no tiene casi vacaciones");
						}
					
					else {
						textEstado.setText("El trabajador " + p.getNombre() + " le quedan aún vacaciones");
						}
				}
				//Añadimos el mensaje que mostrará si hay error.
				catch (NumberFormatException error2 ){
					textEstado.setText("THAS EQUIVOCAO");
				}
				
			}
		});
		btnEstado.setBounds(271, 215, 105, 23);
		contentPane.add(btnEstado);
	}
}
