package com.enternet.ejercicios;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Ejercicio2 {
	
	public static String leerArchivo(String ruta, String archivo) throws FileNotFoundException{
		
		String archivoRecorrido = "";
		int contador = 0;
		
        // Abrir el archivo
        FileReader fr = new FileReader(ruta.concat(archivo));
        Scanner lector = new Scanner(fr);
        
        while(lector.hasNextLine()){
        	++contador;
        	archivoRecorrido+=(contador+".- "+lector.nextLine()+"\n");
        }

        // Cerrar el archivo
        lector.close();
        
        // Devuelve el archivo recorrido para su display
        return archivoRecorrido;
	}
}