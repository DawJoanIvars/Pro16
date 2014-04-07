


import java.io.Serializable;
import java.util.ArrayList;

public class Liga implements Serializable {
	private int numEquipos;
    private ArrayList<Equipo> equipos=new ArrayList<Equipo>();
    private String nombreLiga;
    
	public Liga() {
		// TODO Auto-generated constructor stub
		 numEquipos=0;
	     nombreLiga="Liga Futbol Española";
		}
	
	
	public Liga(int numero, String nombre){
		 numEquipos=numero;
	     nombreLiga=nombre;
		}
	public void setNombre(String nombre){
        nombreLiga=nombre;
	}
	public String getNombre(){
        return nombreLiga;

	}
	
	public int getnumEquipos(){
        return numEquipos;

	}
	public Equipo getEquipo(int posicion) {
        return equipos.get(posicion);

	}
	  public void newEquipo()
	    {
	        equipos.add(new Equipo());
	        numEquipos++;
	    }
	  public void deleteEquipo(int posicion)
	    {
	        equipos.remove(posicion);
	    }
}
