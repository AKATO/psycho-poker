package br.com.akato.psychopoker;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
	private List<Carta> cartasNaMao;
	private List<Carta> cartasNoMonte;
	private String melhorMao;
	private int relevanciaMelhorMao;
	
	public Jogador(List<Carta> cartas) {
		this.cartasNaMao = new ArrayList<Carta>();
		this.cartasNoMonte = new ArrayList<Carta>();
		this.recebeAsCartas(cartas);
	}

	public void recebeAsCartas(List<Carta> cartasRecebidas) {
		this.cartasNaMao = cartasRecebidas.subList(0, 5);
		this.cartasNoMonte = cartasRecebidas.subList(5, 10);
	}

	public Jogador() {
		this.cartasNaMao = new ArrayList<Carta>();
		this.cartasNoMonte = new ArrayList<Carta>();

	}

	public List<Carta> getCartasNoMonte() {
		return cartasNoMonte;
	}

	public void setCartasNoMonte(List<Carta> cartasNoMonte) {
		this.cartasNoMonte = cartasNoMonte;
	}

	public List<Carta> getCartasNaMao() {
		return cartasNaMao;
	}

	public void setCartasNaMao(List<Carta> cartasNaMao) {
		this.cartasNaMao = cartasNaMao;
	}
	
	
	public List<Carta> getTodasAsCartas(){
		List<Carta> todasCartas= new ArrayList<Carta>();
		todasCartas.addAll(this.getCartasNaMao());
		todasCartas.addAll(this.getCartasNoMonte());
		return todasCartas;
	}
	public void advinharMelhorMao(){
		CombinacoesDeJogos combinacoes = new CombinacoesDeJogos(this);
		combinacoes.criarPossibilidades();
		this.melhorMao = combinacoes.decricaoDaMelhorMao();
		this.relevanciaMelhorMao = combinacoes.relevanciaDaMelhorMao();
	}

	public String getMelhorMao() {
		return melhorMao;
	}

	public int getRelevanciaMelhorMao() {
		return relevanciaMelhorMao;
	}

}
