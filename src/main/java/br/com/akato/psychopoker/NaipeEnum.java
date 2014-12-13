package br.com.akato.psychopoker;

import java.util.Map;
import java.util.TreeMap;

public enum NaipeEnum {
	PAUS("C","PAUS"),OURO("D","OURO"),ESPADA("S","ESPADA"),COPAS("H","COPAS");
	
	String codigo;
	String naipe;
	static Map<String,NaipeEnum> mapaNaipe;
	NaipeEnum(String codigo, String naipe){
		this.codigo = codigo;
		this.naipe = naipe;
	}
	
	static{
		mapaNaipe = new TreeMap<String,NaipeEnum>();
		mapaNaipe.put("C",PAUS);
		mapaNaipe.put("D",OURO);
		mapaNaipe.put("S",ESPADA);
		mapaNaipe.put("H",COPAS);
	}
}
