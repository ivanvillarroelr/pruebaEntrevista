package com.enternet.ejercicios;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;




public class Pruebas {
	// Actualizar por su ruta
	public final static String RUTA = "C:/temp/";
	// Actualizar por su archivo de texto
	public final static String ARCHIVO = "GustavoAdolfoBecquer.txt";
	
	private static void pruebaEjercicio1() {
		
		String palabra;
		String[] resultado;
		
		/*
		 * Prueba 1: Palabra incluye caracteres de no uso español
		 */
		palabra = new String("Palabra 学 -"); 
		resultado = Ejercicio1.toLowerArray(palabra);
		
		// Visualizacion del arreglo
		System.out.println("Prueba 1: "+Arrays.asList(resultado)); 
		
		/*
		 * Prueba 2: Palabra incluye caracteres chinos y mayusculas
		 */
		palabra = new String("MAYUSCULAS 学 -"); 
		resultado = Ejercicio1.toLowerArray(palabra);
		
		// Visualizacion del arreglo
		System.out.println("Prueba 2: "+Arrays.asList(resultado)); 
	}

	private static void pruebaEjercicio2() {
		// Actualizar por su ruta
		String ruta = "C:/temp/";
		// Actualizar por su archivo de texto
		String archivo = "GustavoAdolfoBecquer.txt";
		try {
			System.out.println(Ejercicio2.leerArchivo(ruta, archivo));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void pruebaEjercicio3() {
		String ruta = RUTA;
		String archivo = ARCHIVO;
		
		List<String> auxLista = new ArrayList<String>(); 

		try {
			auxLista = Ejercicio3.leerArchivo(ruta, archivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<auxLista.size();i++) {
			System.out.println(auxLista.get(i)+" "+Collections.frequency(auxLista,auxLista.get(i)));
		}
	}
	
	private static void pruebaEjercicio4() {
		String ruta = RUTA;
		String archivo = ARCHIVO;
		
		List<String> auxLista = new ArrayList<String>(); 

		try {
			auxLista = Ejercicio3.leerArchivo(ruta, archivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Ordena lexicográficamente la lista
		
		Collections.sort(auxLista);
		
		for(int i=0;i<auxLista.size();i++) {
			System.out.println(auxLista.get(i)+" "+Collections.frequency(auxLista,auxLista.get(i)));
		}
	}
	
	private static void pruebaEjercicio5() {
		String ruta = RUTA;
		String archivo = ARCHIVO;
		
		// ArrayList que recupera el valor de retorno del metodo Ejercicio3.leerArchivo(ruta,archivo)
		List<String> auxLista = new ArrayList<String>(); 

		try {
			auxLista = Ejercicio3.leerArchivo(ruta, archivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Mapa que asocia key: palabra a value: ocurrencia
		Map<String,Integer> mapaPalabras = new HashMap<String,Integer>();
		
		for(int i=0;i<auxLista.size();i++) {
			try {
				mapaPalabras.put(auxLista.get(i),Collections.frequency(auxLista,auxLista.get(i)));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// Comparador que permite ordenar de mayor a menor 
		
		Comparator<Entry<String, Integer>> comparadorValor = new Comparator<Entry<String,Integer>>() { 
			@Override 
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) { 
				Integer v1 = e1.getValue(); 
				Integer v2 = e2.getValue(); 
				return v2.compareTo(v1); 
				} 
			};

		// Set de entradas del mapa 
		Set<Entry<String, Integer>> entradas = mapaPalabras.entrySet();
		 
		// El metodo sort requiere una lista, se transforma el set del mapa en lista. 
		List<Entry<String, Integer>> listOfEntries = new ArrayList<Entry<String, Integer>>(entradas);
	    
		// Se inicializa LinkedHashMap que recibira los pares ordenados
		LinkedHashMap<String, Integer> sortedByValue = new LinkedHashMap<String, Integer>(listOfEntries.size());
		
		// Se ordena la lista en base al comparador realizado
		Collections.sort(listOfEntries, comparadorValor);
		
		// Se guarda en un LinkedHashMap (que reconoce el orden de adicion) la key: palabras value: ocurrencia
		for(Entry<String, Integer> entry : listOfEntries){ 
			sortedByValue.put(entry.getKey(), entry.getValue()); 
		} 
		
		// Set de pares ordenados para su iteracion
		Set<Entry<String, Integer>> entrySetSortedByValue = sortedByValue.entrySet(); 
		
		// Iteracion del set ordenado e impresion por pantalla
		for(Entry<String, Integer> mapping : entrySetSortedByValue){ 
			System.out.println(mapping.getKey() + " " + mapping.getValue());
		}

	
	}

	public static void main(String[] args) {
		
		Pruebas.pruebaEjercicio1();
		Pruebas.pruebaEjercicio2();
		Pruebas.pruebaEjercicio3();
		Pruebas.pruebaEjercicio4();
		Pruebas.pruebaEjercicio5();
		
	}
}
