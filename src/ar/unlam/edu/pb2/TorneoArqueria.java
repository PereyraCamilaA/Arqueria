package ar.unlam.edu.pb2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TorneoArqueria {

    ArrayList<Arquero>arqueros = new ArrayList<Arquero>();

    private String nombre;
    
    public TorneoArqueria(String nombre) {
    	this.nombre = nombre;
    }
    
    public Arquero getArquero(int numeroParticipante) {
        for (Arquero arquero : arqueros) {
            if (arquero.getNumeroParticipante() == numeroParticipante) {
                return arquero;
            }
        }
        return null;
    }

    public void registrarArquero(Integer numeroParticipante) {
        Arquero arquero = new Arquero(numeroParticipante);
        arqueros.add(arquero);
    }

    public List<Arquero> getArquerosCalificados() {
        List<Arquero> arquerosCalificados = new ArrayList<>();
        for (Arquero arquero : arqueros) {
            if (arquero.getMejoresTiros(5).size() >= 5) {
                arquerosCalificados.add(arquero);
            }
        }
        return arquerosCalificados;
    }

    public List<Arquero> getPodio() {
        List<Arquero> arquerosCalificados = getArquerosCalificados();
        arquerosCalificados.sort(Comparator.naturalOrder());
        return arquerosCalificados.subList(0, Math.min(3, arquerosCalificados.size()));
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer obtenerCantidadDeArquerosRegistrados() {
		return arqueros.size();	
	}
    
    
}
    

