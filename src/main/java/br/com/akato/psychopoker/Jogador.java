package br.com.akato.psychopoker;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
	private List<Carta> cartasNaMao;
	private List<Carta> cartasNoMonte;
	private JogoNaMao jogoIdeal;

	public Jogador(List<Carta> cartas) {
		this.cartasNaMao = new ArrayList<Carta>();
		this.cartasNoMonte = new ArrayList<Carta>();
		this.jogoIdeal = new JogoNaMao();
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

	public JogoNaMao getJogoIdeal() {
		return jogoIdeal;
	}

	public void setJogoIdeal(JogoNaMao jogoIdeal) {
		this.jogoIdeal = jogoIdeal;
	}

}
