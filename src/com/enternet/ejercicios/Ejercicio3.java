package com.enternet.ejercicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author <a href="mailto:felipevillarroel88@gmail.com"> Ivan Felipe Villarroel</a>
 *
 */
public class Ejercicio3 {
	
	public static String[] toLowerArraySinPuntos(String palabra) {
		String[] arregloRespuesta;
		palabra = Normalizador.limpiarPalabra(palabra);
		palabra = Normalizador.sacarPuntuacion(palabra);
		arregloRespuesta=palabra.toLowerCase().split("\\s");
		return arregloRespuesta;
	}

	public static List<String> leerArchivo(String ruta, String archivo) throws FileNotFoundException{
		
		String archivoRecorrido = "";

		int contador = 0;
		
        // Abrir el archivo
        FileReader fr = new FileReader(ruta.concat(archivo));
        Scanner lector = new Scanner(fr);
        
        while(lector.hasNextLine()){
        	++contador;
        	archivoRecorrido+=(lector.nextLine()+"\n");
        }

        // Cerrar el archivo
        lector.close();
        
        // Utiliza la clase Ejercicio1 para limpiar los caracteres ajenos al espa�ol y crear arreglo

        List<String> auxLista = Arrays.asList(Ejercicio3.toLowerArraySinPuntos(archivoRecorrido));   
        
        // Devuelve el archivo recorrido para su display
        return auxLista;
	}
	
	
}
