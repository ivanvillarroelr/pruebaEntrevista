package com.enternet.ejercicios;

import java.text.Normalizer;

public class Normalizador {
	
	public static String limpiarPalabra(String palabra){
		palabra = sacarAcentos(palabra);
	    // remueve todos los caracteres que no son ASCII
		palabra = palabra.replaceAll("[^\\x00-\\x7F]", " ");
	    // remueve los caracteres de control ASCII
		palabra = palabra.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", " ");
	    // remueve los caracteres unicode no imprimibles
		palabra = palabra.replaceAll("\\p{C}", " ");
	    return palabra;
	}
	
	public static String sacarPuntuacion(String palabra) {
		// remueve las comas
		palabra = palabra.replace("," , "");
		// remueve los puntos 
		palabra = palabra.replace("." , "");
		
		//remueve las exclamaciones
		palabra = palabra.replace("!", "");
		
		//remueve los semicolon
		palabra = palabra.replace(";", "");
		
		//remueve las exclamaciones
		palabra = palabra.replace("?", "");
		return palabra;
	}
	
    private static String sacarAcentos(String palabra){
        return palabra == null ? null :
            Normalizer.normalize(palabra, Normalizer.Form.NFD)
                    .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
