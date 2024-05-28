package ar.unlam.edu.pb2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestArqueria {

	@Test
	public void queSePuedaRegistrarUnArquero() {

		TorneoArqueria torneo = new TorneoArqueria("Programación Básica II");
		
		Arquero arquero1 = new Arquero(1);
		Arquero arquero2 = new Arquero(2);
		Arquero arquero3 = new Arquero(3);
		Arquero arquero4 = new Arquero(4);
		
		torneo.registrarArquero(1);
		torneo.registrarArquero(2);
		torneo.registrarArquero(3);
		torneo.registrarArquero(4);
		
		Integer valorEsperado = 4;
		Integer valorObtenido = torneo.obtenerCantidadDeArquerosRegistrados();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test 
	public void queSePuedaRegistrarUnTiroValido() throws TiroInvalidoException {
				
		Arquero arquero1 = new Arquero(1);
		
		arquero1.registrarTiro(2, 3);
		arquero1.registrarTiro(4, 5);
		arquero1.registrarTiro(1, 1);
		arquero1.registrarTiro(0, 2);

		Integer valorEsperado = 4;
		Integer valorObtenido = arquero1.getTiros().size();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test (expected = TiroInvalidoException.class)
	public void queLosTirosNoSeanValidosYsePuedanRegistrar() throws TiroInvalidoException{
		
		TorneoArqueria torneo = new TorneoArqueria("Programación Básica II");
		
		Arquero arquero1 = new Arquero(1);
		
		arquero1.registrarTiro(-2, -2);
		arquero1.registrarTiro(-4, -5);
		arquero1.registrarTiro(-2, -2);
		arquero1.registrarTiro(-0, -2);

		Integer valorEsperado = 4;
		Integer valorObtenido = arquero1.getTiros().size();
		
		assertEquals(valorEsperado, valorObtenido);
		
	}
	

	@Test
	public void queSePuedaObtenerElPuntajeTotalDeUnArquero() throws TiroInvalidoException {
				
		Arquero arquero = new Arquero(1);
		
		arquero.registrarTiro(1, 5);
		arquero.registrarTiro(1, 2);
		arquero.registrarTiro(3, 4);

		Integer valorObtenido = arquero.getPuntuacion();
		Integer valorEsperado = 3000;
		
		assertEquals(valorObtenido, valorEsperado);
		
	}
	
	
	@Test
	public void queSePuedaObtenerLosMejoresTirosDeUnArquero() throws TiroInvalidoException {

		Arquero arquero = new Arquero(1);

	    arquero.registrarTiro(3, 3);   
	    arquero.registrarTiro(5, 5);   
	    arquero.registrarTiro(2, 2);   
	    arquero.registrarTiro(8, 8);  
	    arquero.registrarTiro(1, 1);  
	    arquero.registrarTiro(10, 10);

	    List<Tiro> mejoresTiros = arquero.getMejoresTiros(3);

	    List<Tiro> tirosEsperados = Arrays.asList(
	        new Tiro(1, 1),
	        new Tiro(2, 2),
	        new Tiro(3, 3)
	    );

	    assertEquals(tirosEsperados, mejoresTiros);
	}
	
	@Test
	public void queSePuedaCompararArquerosPorPuntuacion() throws TiroInvalidoException {

		Arquero arquero1 = new Arquero(1);
	    Arquero arquero2 = new Arquero(2);

	    arquero1.registrarTiro(5, 5);
	    arquero2.registrarTiro(10, 10);

	    assertTrue(arquero2.compareTo(arquero1) > 0);
	}

	
}
