package br.com.akato.psychopoker;
import java.util.ArrayList;
import java.util.List;

public class Jogador {
	private int idJogador;
	private String nomeJogador;
	private List<Carta> cartasNaMao;
	private List<Carta> cartasNoMonte;
	private JogoNaMao jogoIdeal;
	private int relevanciaMelhorJogo;
	private String melhorJogo;
	
	public Jogador(int id){
		this.idJogador = id;
		this.cartasNaMao = new ArrayList<Carta>();
		this.cartasNoMonte = new ArrayList<Carta>();
		this.jogoIdeal = new JogoNaMao();
		
	}
	
	public Jogador(List<Carta> cartas){
		this.idJogador = 1;
		this.nomeJogador = "Psycho Player";
		this.cartasNaMao = new ArrayList<Carta>();
		this.cartasNoMonte = new ArrayList<Carta>();
		this.jogoIdeal = new JogoNaMao();
		this.recebeAsCartas(cartas);
	}
	
	public void recebeAsCartas(List<Carta> cartasRecebidas){
		this.cartasNaMao  = cartasRecebidas.subList(0, 5);
		this.cartasNoMonte = cartasRecebidas.subList(5, 10);
	}

	public Jogador(){
		this.cartasNaMao = new ArrayList<Carta>();
		this.cartasNoMonte = new ArrayList<Carta>();
		
	}

	
	
	public int getIdJogador() {
		return idJogador;
	}

	public void setIdJogador(int idJogador) {
		this.idJogador = idJogador;
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

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(
			String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public JogoNaMao getJogoIdeal() {
		return jogoIdeal;
	}

	public void setJogoIdeal(
			JogoNaMao jogoIdeal) {
		this.jogoIdeal = jogoIdeal;
	}

	public String getMelhorJogo() {
		return melhorJogo;
	}

	public void setMelhorJogo(
			String melhorJogo) {
		this.melhorJogo = melhorJogo;
	}

	public int getRelevanciaMelhorJogo() {
		return relevanciaMelhorJogo;
	}

	public void setRelevanciaMelhorJogo(
			int relevanciaMelhorJogo) {
		this.relevanciaMelhorJogo = relevanciaMelhorJogo;
	}

}