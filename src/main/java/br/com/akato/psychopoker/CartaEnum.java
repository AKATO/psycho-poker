package br.com.akato.psychopoker;

import java.util.Map;
import java.util.TreeMap;

public enum CartaEnum {
	T(10),J(11),Q(12),K(13),A(14);
	
	public int valorCarta;
	static Map<String,CartaEnum> mapaCartaValor;
	CartaEnum(int valor){
		valorCarta = valor;
		
	}
	
	static{
		mapaCartaValor= new TreeMap<String,CartaEnum>();
		mapaCartaValor.put("T", T);
		mapaCartaValor.put("J", J);
		mapaCartaValor.put("Q", Q);
		mapaCartaValor.put("K", K);
		mapaCartaValor.put("A", A);
	}
}
