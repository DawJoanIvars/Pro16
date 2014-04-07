

public class Principal {

	public static void main(String[] args) {
		//Creamos una manera de pasar equipo
		Equipo equipo=new Equipo("vnc",0, 0, 0, 0);
		Liga a=new Liga();
		//Aqui para abrir la ventana		
		VentanaLiga frame = new VentanaLiga(a);
		frame.setVisible(true);
	}

}
 