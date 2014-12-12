package br.com.akato.psychopoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static br.com.akato.psychopoker.CombinacoesEnum.HIGHEST;
import static br.com.akato.psychopoker.CombinacoesEnum.ONE_PAIR;
import static br.com.akato.psychopoker.CombinacoesEnum.TWO_PAIRS;
import static br.com.akato.psychopoker.CombinacoesEnum.THREE_OF_A_KIND;
import static br.com.akato.psychopoker.CombinacoesEnum.STRAIGHT;
import static br.com.akato.psychopoker.CombinacoesEnum.FLUSH;
import static br.com.akato.psychopoker.CombinacoesEnum.FULL_HOUSE;
import static br.com.akato.psychopoker.CombinacoesEnum.STRAIGHT_FLUSH;
import static br.com.akato.psychopoker.CombinacoesEnum.FOUR_OF_A_KIND;

public class CombinacoesDeJogos {

	int seq,contFlush,cartasIguais1,cartasIguais2,valorCartaIgual1,valorCartaIgual2;
	private Map<Integer, String> jogosPorRelevancia;
	private Jogador jogador;
	
	
//	public CombinacoesDeJogos() {
//		this.jogosPorRelevancia = new TreeMap<Integer, String>();
//	}
	public CombinacoesDeJogos(Jogador jogador) {
		this.jogosPorRelevancia = new TreeMap<Integer, String>();
		this.jogador = jogador;
	}
	
	
	public CombinacoesDeJogos(List<String> jogadas) {
		this.jogosPorRelevancia = new TreeMap<Integer, String>();
		this.jogador = jogador;
	}
	
	

	public void adicionarSequenciasDeCartasGeradas(	List<Carta> sequenciaAdicionada) {
		Mao mao = new Mao(sequenciaAdicionada);
		validarCartas(mao);
	}

	public void validarCartas(Mao jogoParaValidacao) {
		Mao jogoNaMao = new Mao(jogoParaValidacao.getCartas());
		Collections.sort(jogoNaMao.getCartas());
		Mao jogoValidado = new Mao();
		jogoValidado = verificarCombinacoes(jogoNaMao);
		if (!this.jogosPorRelevancia.containsKey(jogoValidado.getRelevanciaDoJogo())) {
			this.jogosPorRelevancia.put(jogoValidado.getRelevanciaDoJogo(),jogoValidado.toString());
		}
	}

	public boolean isStraightFlush() {
		if (seq == 4 && contFlush == 4)	return true;
		else return false;
	}
	public boolean isStraight() {
		if (seq == 4)return true;
		else return false;
	}
	public boolean isFourOfAKind() {
		if (cartasIguais1 == 4)	return true;
		else return false;
	}
	public boolean isFullHouse() {
		if ((cartasIguais1 == 3 && cartasIguais2 == 2)	|| (cartasIguais1 == 2 && cartasIguais2 == 3)) return true;
		else return false;
	}
	public boolean isFlush() {
		if (contFlush == 4)return true;
		else return false;
	}
	public boolean isThreeOfAKind() {
		if (cartasIguais1 == 3 || cartasIguais2 == 3)return true;
		else return false;
	}
	public boolean isTwoPairs() {if (cartasIguais1 == 2 && cartasIguais2 == 2)return true;
		else return false;
	}
	public boolean isOnePair() {
		if (cartasIguais1 == 2)	return true;
		else return false;
	}

	public int maoDeMaiorRelevancia() {
		if (!this.jogosPorRelevancia.isEmpty()) {		
			for (int i = 9; i >= 1; i++) {
				if (this.jogosPorRelevancia.containsKey(i)) {
					return i;
				}
			}
		}
		return 1;
	}

	
	public String decricaoDaMelhorMao(){
		return CombinacoesEnum.mapaDeCombinacao.get(this.maoDeMaiorRelevancia()).descricao;
	}
	
	public int identificaRelevancia() {
		int relevancia;
		relevancia = (int) (isStraightFlush() ? STRAIGHT_FLUSH.relevancia
				: (isFourOfAKind() ? FOUR_OF_A_KIND.relevancia
						: (isStraight() ? STRAIGHT.relevancia
								: (isFullHouse() ? FULL_HOUSE.relevancia
										: (isFlush() ? FLUSH.relevancia
												: (isThreeOfAKind() ? THREE_OF_A_KIND.relevancia
														: (isTwoPairs() ? TWO_PAIRS.relevancia
																: (isOnePair() ? ONE_PAIR.relevancia
																		: HIGHEST.relevancia))))))));
		return relevancia;
	}

	public Mao verificarCombinacoes(Mao jogoNovo) {
		Mao jogoNaMao = new Mao(jogoNovo.getCartas());
		identificaCombinacoes(jogoNaMao.getCartas());
		jogoNaMao.setRelevanciaDoJogo(identificaRelevancia());
		return jogoNaMao;
	}

	public void criarPossibilidades() {
		List<Carta> monte = new ArrayList<Carta>();
		monte.addAll(this.jogador.getCartasNoMonte());
		List<Carta> mao = new ArrayList<Carta>();
		List<Carta> auxList = new ArrayList<Carta>();
		List<Carta> auxList2 = new ArrayList<Carta>();
		List<Carta> auxList3 = new ArrayList<Carta>();
		mao.addAll(this.jogador.getCartasNaMao());
		for (int i = 0; i < 5; i++) {
			mao.remove(i);
			mao.add(monte.get(0));
			adicionarSequenciasDeCartasGeradas(mao);
			auxList.addAll(mao);
			for (int j = 0; j < 4; j++) {
				auxList.remove(j);
				auxList.add(monte.get(1));
				adicionarSequenciasDeCartasGeradas(auxList);
				auxList2.addAll(auxList);
				for (int k = 0; k < 3; k++) {
					auxList2.remove(k);
					auxList2.add(monte.get(2));
					adicionarSequenciasDeCartasGeradas(auxList2);
					auxList3.addAll(auxList2);
					for (int l = 0; l < 2; l++) {
						auxList3.remove(l);
						auxList3.add(monte.get(3));
						adicionarSequenciasDeCartasGeradas(auxList3);
					}
					auxList3.clear();// $
					auxList2.clear();
					auxList2.addAll(auxList);
				}
				auxList2.clear();// $
				auxList.clear();
				auxList.addAll(mao);
			}
			auxList.clear();// $
			mao.clear();
			mao.addAll(jogador.getCartasNaMao());
		}
		adicionarSequenciasDeCartasGeradas(jogador.getCartasNoMonte());
	}

	public void identificaCombinacoes(List<Carta> cartas) {
		int aux;int cont;
		seq = 0;
		contFlush = 0;
		cartasIguais1 = 0;
		cartasIguais2 = 0;
		valorCartaIgual1 = 0;
		valorCartaIgual2 = 0;
		for (int n = 0; n < 5; n++) {
			aux = cartas.get(n).getValor();
			cont = 0;
			for (int j = 0; j < 5; j++) {
				if (aux == cartas.get(j).getValor()) {
					cont++;
				}
			}
			if (cont >= 2) {
				if (valorCartaIgual1 == 0) {
					cartasIguais1 = cont;
					valorCartaIgual1 = aux;
				} else if (valorCartaIgual1 != 0 && valorCartaIgual1 == aux)
					continue;
				else {
					cartasIguais2 = cont;
					valorCartaIgual2 = aux;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			if (cartas.get(i).getValor() + 1 == cartas.get(i + 1).getValor())seq++;
			if (cartas.get(i).getValorRelevanciaNaipe() == cartas.get(i + 1).getValorRelevanciaNaipe())	contFlush++;
		}
	}
}