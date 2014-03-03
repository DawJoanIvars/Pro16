package proc16;

import java.io.Serializable;

public class Equipo implements Serializable{
	//atibutos del equipo.
	private String nombreEquipo;
	private int golesFavor;
	private int golesContra;
	private int partidosGanados;
	private int partidosPerdidos;
	
	//Esto es para que equipo tenga los atributos.
	public Equipo(String nom,int golesF, int golesC, int paritdosG, int partidosP) {
		// TODO Auto-generated constructor stub
		nombreEquipo=nom;
		golesFavor=golesF;
		golesContra=golesC;
		partidosGanados=paritdosG;
		partidosPerdidos=partidosP;
		//Inicializamos los objetos. 
		nom="";
		golesF=0;
		golesC=0;
		paritdosG=0;
		partidosP=0;
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
}
	