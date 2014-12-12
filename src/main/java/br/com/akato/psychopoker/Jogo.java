package br.com.akato.psychopoker;
import java.util.ArrayList;
import java.util.List;

public class Jogo {
	private List<Jogador> jogadores;
	private List<Baralho> baralhos;
	
	public Jogo() {
		this.jogadores = new ArrayList<Jogador>();
		this.baralhos = new ArrayList<Baralho>();
	}
	
//	public void iniciaPartida(String cartas){
//		try{
//			Jogador jogador = new Jogador(montarCartasDoJogador(cartas));
//			CombinacoesDeJogos combi = new CombinacoesDeJogos(jogador);
//			combi.criarPossibilidades();
//			String melhorJogo = combi.retornarJogoDeMaiorRelevancia();
//		} catch (Exception e) {
//			System.out.println("Houve um problema ao dar as cartas no trecho : " );
//			 e.printStackTrace();
//		}
//	}
	
//	return "Mão: 2H 2S 3H 3S 3C Monte: 2D 3D 6C 9C TH Melhor Jogo: four-of-a-kind (quadra)
	public void iniciaPartida(){
		try{
			Jogador jogador;
			for(String cartas:getJogadas()){
				jogador = new Jogador(montarCartasDoJogador(cartas));
				jogador.advinharMelhorMao();
				System.out.println(imprimirResultado(jogador));
			}
		} catch (Exception e) {
			System.out.println("Houve um problema ao dar as cartas no trecho : " );
			 e.printStackTrace();
		}
	}
	
	public String imprimirResultado(Jogador jogador){

		StringBuilder resultado = new StringBuilder("Mão: ");
		for(Carta carta:jogador.getCartasNaMao()){
			resultado.append(carta.getCarta()+" ");
		}
		resultado.append("Monte: ");
		for(Carta carta:jogador.getCartasNoMonte()){
			resultado.append(carta.getCarta()+" ");
		}
		resultado.append("MelhorJogo: " + jogador.getMelhorMao());
		
		resultado.append(jogador.getMelhorMao());
		
		return resultado.toString();
	}
	
	public List<String> getJogadas() throws Exception{

		List<String> entrada = (List<String>) new Leitor().lerEventos();
		return entrada;
	}
	
	
	public List<Carta> montarCartasDoJogador(String cartas){
		Carta cartaTemporaria ;
		List<Carta> cartasDoJogador ;
		cartasDoJogador = new ArrayList<Carta>();
		if(cartas != null && cartas.length()>=25){
			cartas	= cartas.trim();
			String[] todasCartas = cartas.split(" ");
			for(int q=0;q<todasCartas.length;q++){
				cartaTemporaria = new Carta(todasCartas[q]);
				cartasDoJogador.add(cartaTemporaria);
			}
		}
		return cartasDoJogador;
	}

	
	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public List<Baralho> getBaralhos() {
		return baralhos;
	}

	public void setBaralhos(List<Baralho> baralhos) {
		this.baralhos = baralhos;
	}

	public static void main(String[] args) {
		Jogo jogoTeste = new Jogo();
		jogoTeste.iniciaPartida();
//		jogoTeste.iniciaPartida("TH JH QC QD QS QH KH AH 2S 6S");
//		return "Mão: 2H 2S 3H 3S 3C Monte: 2D 3D 6C 9C TH Melhor Jogo: four-of-a-kind (quadra)
//		jogoTeste.iniciaPartida("AH 2C 9S AD 3C QH KS JS JD KD");
		
	}
}
