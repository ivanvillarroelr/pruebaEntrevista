package com.enternet.ejercicios;

import com.enternet.ejercicios.Normalizador;

public class Ejercicio1 {

	public static String[] toLowerArray(String palabra) {
		String[] arregloRespuesta;
		palabra = Normalizador.limpiarPalabra(palabra);
		arregloRespuesta=palabra.toLowerCase().split("\\s");
		return arregloRespuesta;
	}
}
