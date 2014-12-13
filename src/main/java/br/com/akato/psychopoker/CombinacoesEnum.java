package br.com.akato.psychopoker;

import java.util.Map;
import java.util.TreeMap;

public enum CombinacoesEnum {
	HIGHEST(1,"HIGHEST(Maior Carta)"),
	ONE_PAIR(2,"ONE-PAIR(Um Par)"),
	TWO_PAIRS(3,"TWO-PAIRS(Dois Pares)"),
	THREE_OF_A_KIND(4,"THREE-OF-A-KIND(Uma Trinca)"),
	STRAIGHT(5,"STRAIGHT(Sequencia)"),
	FLUSH(6,"FLUSH(Todas do Mesmo Naipe)"),
	FULL_HOUSE(7,"FULL-HOUSE( Dupla + Trinca)"),
	FOUR_OF_A_KIND(8,"FOUR-OF-A-KIND(Uma Quadra)"),
	STRAIGHT_FLUSH(9,"STRAIGHT-FLUSH(Sequencia Do Mesmo Naipe)");
	
	CombinacoesEnum(int valor,String descricao){
		this.relevancia = valor;
		this.descricao = descricao;
	}

	String descricao;
	int relevancia;
	
	static Map<Integer, CombinacoesEnum> mapaDeCombinacao;
	
	static{     
		mapaDeCombinacao= new TreeMap<Integer,CombinacoesEnum>();
		mapaDeCombinacao.put(1,HIGHEST);
		mapaDeCombinacao.put(2,ONE_PAIR);
		mapaDeCombinacao.put(3,TWO_PAIRS);
		mapaDeCombinacao.put(4,THREE_OF_A_KIND);
		mapaDeCombinacao.put(5,STRAIGHT);
		mapaDeCombinacao.put(6,FLUSH);
		mapaDeCombinacao.put(7,FULL_HOUSE);
		mapaDeCombinacao.put(8,FOUR_OF_A_KIND);
		mapaDeCombinacao.put(9,STRAIGHT_FLUSH);
	}
	
}
