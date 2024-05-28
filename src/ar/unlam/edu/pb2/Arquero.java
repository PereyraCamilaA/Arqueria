package ar.unlam.edu.pb2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Arquero implements Puntuacion, Comparable<Arquero> {
    private Integer numeroParticipante;
    private List<Tiro> tiros;

    public Arquero(Integer numeroParticipante) {
        this.numeroParticipante = numeroParticipante;
        this.tiros = new ArrayList<>();
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public void registrarTiro(Integer x, Integer y) throws TiroInvalidoException {
        Tiro tiro = new Tiro(x, y);
        if (x<0 && y<0 || tiro.getDistanciaAlCentro() > 50) {
            throw new TiroInvalidoException("Coordenadas de tiro inválidas.");
        }
        
        tiros.add(tiro);
    }

    public List<Tiro> getMejoresTiros(int cantidad) {
        List<Tiro> tirosOrdenados = new ArrayList<>(tiros);
        tirosOrdenados.sort(Comparator.comparingDouble(Tiro::getDistanciaAlCentro));
        return tirosOrdenados.subList(0, Math.min(cantidad, tirosOrdenados.size()));
    }

    @Override
    public Integer getPuntuacion() {
        int puntuacionTotal = 0;
        for (Tiro tiro : tiros) {
            puntuacionTotal += tiro.getPuntuacion();
        }
        return puntuacionTotal;
    }

    @Override
    public int compareTo(Arquero otro) {
        return Integer.compare(otro.getPuntuacion(), this.getPuntuacion());
    }

	public List<Tiro> getTiros() {
		return tiros;
	}

	public void setTiros(List<Tiro> tiros) {
		this.tiros = tiros;
	}

	public void setNumeroParticipante(Integer numeroParticipante) {
		this.numeroParticipante = numeroParticipante;
	}
    
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Arquero otro = (Arquero) obj;
	    return Objects.equals(numeroParticipante, otro.numeroParticipante);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(numeroParticipante);
	}
    
}
