package ar.unlam.edu.pb2;

import java.util.Objects;

public class Tiro implements Puntuacion{
	
	    private Integer x;
	    private Integer y;
	    
	    public Tiro(Integer x, Integer y) {
			this.x = x;
			this.y = y;
		}

		public Integer getX() {
			return x;
		}

		public void setX(Integer x) {
			this.x = x;
		}

		public Integer getY() {
			return y;
		}

		public void setY(Integer y) {
			this.y = y;
		}


		public Double getDistanciaAlCentro() {
	        return Math.sqrt(x * x + y * y);
	    }

	    @Override
	    public Integer getPuntuacion() {
	        Double distancia = getDistanciaAlCentro();
	        if (distancia <= 10) {
	            return 1000;
	        } else if (distancia <= 20) {
	            return 500;
	        } else if (distancia <= 30) {
	            return 200;
	        } else if (distancia <= 40) {
	            return 100;
	        } else if (distancia <= 50) {
	            return 50;
	        } else {
	            return 0;
	        }
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }
	        Tiro otro = (Tiro) obj;
	        return x == otro.x && y == otro.y;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(x, y);
	    }
	}
	    

