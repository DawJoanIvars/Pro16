import java.io.Serializable;

public class Equipo implements Serializable{
	//atibutos del equipo.
	private String nombreEquipo;
	private int golesFavor;
	private int golesContra;
	private int partidosGanados;
	private int partidosPerdidos;
	private String jugadores[];
	
	//Esto es para que equipo tenga los atributos.
	public Equipo(String nom,int golesF, int golesC, int paritdosG, int partidosP) {
		// TODO Auto-generated constructor stub
		//Inicializamos los privates.
		nombreEquipo=nom;
		golesFavor=golesF;
		golesContra=golesC;
		partidosGanados=paritdosG;
		partidosPerdidos=partidosP;
		jugadores= new String [10];
		for (int i=0;i<jugadores.length;i++){
			jugadores[i]="";
		
		jugadores[0]="Pepe";
		jugadores[1]="pro";
		}
	}
	
	public void modificarJugador(int posicionJugador, String nombreNuevo){
			
		jugadores[posicionJugador]=nombreNuevo;
	}
	
	public String devolberJugador(int posicionJugador){
		return jugadores[posicionJugador];	
		
	}
	
	public Equipo()
	{
		nombreEquipo="";
		golesFavor=0;
		golesContra=0;
		partidosGanados=0;
		partidosPerdidos=0;		
	}
	
	
	public void setNombre(String nombre){
		nombreEquipo=nombre;
	}
	public String getNombre(){
		return nombreEquipo;
	}
	
	public void setgolesFavor(int golesF){
		golesFavor=golesF;
	}
	public int getgolesFavor(){
		return golesFavor;
	}
	
	public void setgolesContra(int golesC){
		golesContra=golesC;
	}
	public int getgolesContra(){
		return golesContra;
	}
	
	public void setPartidosGanados(int partidosG){
		partidosGanados=partidosG;
	}
	public int getPartidosGanados(){
		return partidosGanados;
	}
	
	public void setPartidosPerdidos(int partidosP){
		partidosPerdidos=partidosP;
	}
	public int getPartidosPerdidos(){
		return partidosPerdidos;
	}
	public String toString(){
		return nombreEquipo;
	}
}
	