package pk_SuperBuscaMinasTest;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pk_SuperBuscaMinas.BotonMina;
import pk_SuperBuscaMinas.BotonMina.Estado;
import pk_SuperBuscaMinas.BotonMina.Valor;
import pk_SuperBuscaMinas.Coordenadas;
import pk_SuperBuscaMinas.MatrizBotones;
import pk_SuperBuscaMinas.Util.Posicion;

public class MatrizBotonesTest {

	private static MatrizBotones matriz;
	private static BotonMina boton;
	
	@BeforeClass
	public static void inicio() {
		
		System.out.println("***************** Inicio Prueba MatrizBotones ****************\n");
		
//		System.out.println("Matriz prueba 6 x 6 con 6 minas en las posiciones\n");
//		System.out.println("[0,0] [0,2] [4,1] [4,3] [5,1] [5,5]\n");
		
		// Creamos la matriz de 6x6
//		matriz = new MatrizBotones(6, 6);
//		
//		// Añadimos 6 minas en las posiciones indicadas
//		matriz.getBoton(0, 0).setValor(Valor.MINA);
//		matriz.getListaPosicionMinas().add(new Coordenadas(0, 0));
//		matriz.getBoton(0, 2).setValor(Valor.MINA);
//		matriz.getListaPosicionMinas().add(new Coordenadas(0, 2));
//		matriz.getBoton(4, 1).setValor(Valor.MINA);
//		matriz.getListaPosicionMinas().add(new Coordenadas(4, 1));
//		matriz.getBoton(4, 3).setValor(Valor.MINA);
//		matriz.getListaPosicionMinas().add(new Coordenadas(4, 3));
//		matriz.getBoton(5, 1).setValor(Valor.MINA);
//		matriz.getListaPosicionMinas().add(new Coordenadas(5, 1));
//		matriz.getBoton(5, 5).setValor(Valor.MINA);
//		matriz.getListaPosicionMinas().add(new Coordenadas(5, 5));

		System.out.println("Matriz prueba 5 x 5 con 6 minas en las posiciones\n");
		System.out.println("[0,0] [0,1] [0,2] [1,0] [4,0] [4,1]\n");
		matriz = new MatrizBotones(5, 5);
		
		// Añadimos 6 minas en las posiciones indicadas
		matriz.getBoton(0, 0).setValor(Valor.MINA);
		matriz.getListaPosicionMinas().add(new Coordenadas(0, 0));
		matriz.getBoton(1, 0).setValor(Valor.MINA);
		matriz.getListaPosicionMinas().add(new Coordenadas(1, 0));
		matriz.getBoton(4, 0).setValor(Valor.MINA);
		matriz.getListaPosicionMinas().add(new Coordenadas(4, 0));
		matriz.getBoton(0, 1).setValor(Valor.MINA);
		matriz.getListaPosicionMinas().add(new Coordenadas(0, 1));
		matriz.getBoton(0, 2).setValor(Valor.MINA);
		matriz.getListaPosicionMinas().add(new Coordenadas(0, 2));
		matriz.getBoton(4, 1).setValor(Valor.MINA);
		matriz.getListaPosicionMinas().add(new Coordenadas(4, 1));
		
	
		// Actualizamos el número de minas en las casillas adyacentes
		
		matriz.actualizaNumMinasAdyacentes();
		
		// Mostramos 
		matriz.imprimir();

	}

	@AfterClass
	public static void fin() {
		System.out.println("***************** Fin Prueba MatrizBotones ****************");
	}
	@Test
	public void testMuestraMinas() {
		
		System.out.println("Método MuestraMinas\n");
		
		Estado estado = Estado.MINA;
		// Creamos la lista de coordenadas de las minas
		List<Coordenadas> listaMinas = matriz.getListaPosicionMinas();
		
		// Ejecutamos el método que muestra las minas
		matriz.muestraMinas();
		for (Coordenadas coordenadas : listaMinas) {
			assertEquals(matriz.getBoton(coordenadas).getEstado(), estado);
		}
		
		// Mostramos la matriz
		matriz.imprimir();
		
	}

	@Test
	public void testHayBoton() {
		
		System.out.println("Método HayBoton\n");
		
		
		// Botón posición [0,0]
		System.out.println("Caso botón situado en la esquina superior izquierda");
		Coordenadas coord = new Coordenadas(0,0);
		boton = matriz.getBoton(coord);
		
		assertTrue(matriz.hayBoton(boton, Posicion.DER));
		assertTrue(matriz.hayBoton(boton, Posicion.INF));
		assertTrue(matriz.hayBoton(boton, Posicion.INF_DER));
		assertFalse(matriz.hayBoton(boton, Posicion.INF_IZQ));
		assertFalse(matriz.hayBoton(boton, Posicion.IZQ));
		assertFalse(matriz.hayBoton(boton, Posicion.SUP));
		assertFalse(matriz.hayBoton(boton, Posicion.SUP_DER));
		assertFalse(matriz.hayBoton(boton, Posicion.SUP_IZQ));
		
		System.out.println("Caso botón situado en la esquina superior derecha");
		//coord.setFila(0); coord.setColumna(5);
		coord.setFila(0); coord.setColumna(4);
		boton = matriz.getBoton(coord);

		assertFalse(matriz.hayBoton(boton, Posicion.DER));
		assertTrue(matriz.hayBoton(boton, Posicion.INF));
		assertFalse(matriz.hayBoton(boton, Posicion.INF_DER));
		assertTrue(matriz.hayBoton(boton, Posicion.INF_IZQ));
		assertTrue(matriz.hayBoton(boton, Posicion.IZQ));
		assertFalse(matriz.hayBoton(boton, Posicion.SUP));
		assertFalse(matriz.hayBoton(boton, Posicion.SUP_DER));
		assertFalse(matriz.hayBoton(boton, Posicion.SUP_IZQ));

		System.out.println("Caso botón situado en la esquina inferior izquierda");
		//coord.setFila(5); coord.setColumna(0);
		coord.setFila(4); coord.setColumna(0);
		boton = matriz.getBoton(coord);

		assertTrue(matriz.hayBoton(boton, Posicion.DER));
		assertFalse(matriz.hayBoton(boton, Posicion.INF));
		assertFalse(matriz.hayBoton(boton, Posicion.INF_DER));
		assertFalse(matriz.hayBoton(boton, Posicion.INF_IZQ));
		assertFalse(matriz.hayBoton(boton, Posicion.IZQ));
		assertTrue(matriz.hayBoton(boton, Posicion.SUP));
		assertTrue(matriz.hayBoton(boton, Posicion.SUP_DER));
		assertFalse(matriz.hayBoton(boton, Posicion.SUP_IZQ));

		System.out.println("Caso botón situado en la esquina inferior derecha");
		//coord.setFila(5); coord.setColumna(5);
		coord.setFila(4); coord.setColumna(4);
		boton = matriz.getBoton(coord);

		assertFalse(matriz.hayBoton(boton, Posicion.DER));
		assertFalse(matriz.hayBoton(boton, Posicion.INF));
		assertFalse(matriz.hayBoton(boton, Posicion.INF_DER));
		assertFalse(matriz.hayBoton(boton, Posicion.INF_IZQ));
		assertTrue(matriz.hayBoton(boton, Posicion.IZQ));
		assertTrue(matriz.hayBoton(boton, Posicion.SUP));
		assertFalse(matriz.hayBoton(boton, Posicion.SUP_DER));
		assertTrue(matriz.hayBoton(boton, Posicion.SUP_IZQ));
		
		System.out.println("Caso botón situado en centro de la matriz\n");
		coord.setFila(2); coord.setColumna(2);
		boton = matriz.getBoton(coord);

		assertTrue(matriz.hayBoton(boton, Posicion.DER));
		assertTrue(matriz.hayBoton(boton, Posicion.INF));
		assertTrue(matriz.hayBoton(boton, Posicion.INF_DER));
		assertTrue(matriz.hayBoton(boton, Posicion.INF_IZQ));
		assertTrue(matriz.hayBoton(boton, Posicion.IZQ));
		assertTrue(matriz.hayBoton(boton, Posicion.SUP));
		assertTrue(matriz.hayBoton(boton, Posicion.SUP_DER));
		assertTrue(matriz.hayBoton(boton, Posicion.SUP_IZQ));
	}
	
	
	@Test
	public void testRecursivoDestapaBotonesAdyacentes() {
		
		// Para que vuelva a crear la matriz como al principio y le añada las mismas minas
		inicio();
		
		System.out.println("Método RecursivoDestapaBotonesAdyacentes\n");

		
		// Prueba 1: Simulo el click en un botón con valor NUMERO (2, 0) por ejemplo, por lo que no debería destapar adyacentes
		matriz.getBoton(2, 0).cambiarAspecto(Estado.NUMERO);
		matriz.recursivoDestapaBotonesAdyacentes(matriz.getBoton(2, 0));
		// Prueba 2: Simulo el click en un botón con valor VACIO (5,0) por ejemplo, por lo que debe destapar
		matriz.getBoton(3, 3).cambiarAspecto(Estado.PULSADO);
		matriz.recursivoDestapaBotonesAdyacentes(matriz.getBoton(3, 3));
		
		// Mostramos la matriz
		matriz.imprimir();

	}
	

	
}
