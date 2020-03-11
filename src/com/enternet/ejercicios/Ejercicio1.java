package com.enternet.ejercicios;

import com.enternet.ejercicios.Normalizador;

/**
 * 
 * @author <a href="mailto:felipevillarroel88@gmail.com"> Ivan Felipe Villarroel</a>
 *
 */
public class Ejercicio1 {

	public static String[] toLowerArray(String palabra) {
		String[] arregloRespuesta;
		palabra = Normalizador.limpiarPalabra(palabra);
		arregloRespuesta=palabra.toLowerCase().split("\\s");
		return arregloRespuesta;
	}
}
