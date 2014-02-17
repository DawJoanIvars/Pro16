
//Añadimos el extends para que tenga los atributos de Persona.
public class Trabajador extends Persona{
	//Creamos Vacaciones
	private int Vacaciones=0;
	public Trabajador() {
		// TODO Auto-generated constructor stub
	}
	//Hacemos visible las vacaciones.
		public int getVacaciones(){
			return Vacaciones;
		}
		public void setVacaciones(int editarVacaciones){
			Vacaciones=editarVacaciones;
		}
		
}