package pk_SuperBuscaMinasTest;


import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import pk_SuperBuscaMinas.BotonMina;
import pk_SuperBuscaMinas.BotonMina.Estado;

@RunWith(Parameterized.class)
public class BotonMinaTest {

	private int val;
	private Estado estado;
	private static BotonMina boton;
	
	public BotonMinaTest(Estado estado) {
		this.estado = estado;
	}
	
	@Parameters
	public static List<Estado> recogeLista() {
		return Arrays.asList(Estado.values());
	}
	
	@BeforeClass
	public static void inicio() {
		System.out.println("***************** Inicio Prueba BotonMina ****************\n");
		boton = new BotonMina();
		
	}
	
	@Before
	public void inicioBefore() {
		// En cada iteración, inicializamos el botón a Val=Vacio y Estado = Boton
		boton.cambiarAspecto(Estado.BOTON);
	}

	@AfterClass
	public static void fin() {
		System.out.println("***************** Fin Prueba BotonMina ****************\n");
	}
	
	@Test
	public void testCambiarAspecto() {
		
		System.out.println("Boton Inicial: " + boton.toString());
		System.out.println("Nuevo estado:  " + this.estado);
		boton.cambiarAspecto(this.estado);
		System.out.println("Boton Final:   " + boton.toString() + "\n");
	}
	

}
