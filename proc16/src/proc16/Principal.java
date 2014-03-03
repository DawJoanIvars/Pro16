package proc16;

public class Principal {

	public static void main(String[] args) {
		//Creamos una manera de pasar equipo
		Equipo equipo=new Equipo("vnc",0, 0, 0, 0);
		//Aqui para abrir la ventana
		VentanaEquipo frame = new VentanaEquipo(equipo);
		frame.setVisible(true);
	}

}
