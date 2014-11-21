package br.com.akato.psychopoker;

public enum CartaEnum {
	T(10),J(11),Q(12),K(13),A(14);
	
	public int valorCarta;
	
	CartaEnum(int valor){
		valorCarta = valor;
	}
}
