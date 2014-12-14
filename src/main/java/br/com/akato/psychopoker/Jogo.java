package br.com.akato.psychopoker;
import java.util.ArrayList;
import java.util.List;

public class Jogo {
	private List<Jogador> jogadores;
	
	public Jogo() {
		this.jogadores = new ArrayList<Jogador>();
	}
	
	public void iniciaPartida(){
		try{
			Jogador jogador;
			for(String cartas:getJogadas()){
				jogador = new Jogador(montarCartasDoJogador(cartas));
				jogador.advinharMelhorMao();
				this.jogadores.add(jogador);
			}
			imprimirResultados();
		} catch (Exception e) {
			System.out.println("Houve um problema ao dar as cartas no trecho : " );
			 e.printStackTrace();
		}
	}
	
	public void imprimirResultados(){
		StringBuilder resultado ;
		for(Jogador jogador:this.jogadores){
			resultado = new StringBuilder("Mão: ");
			for(Carta carta:jogador.getCartasNaMao()){
				resultado.append(carta.getCarta()+" ");
			}
			resultado.append("Monte: ");
			for(Carta carta:jogador.getCartasNoMonte()){
				resultado.append(carta.getCarta()+" ");
			}
			resultado.append("MelhorJogo: " + jogador.getMelhorMao());
		System.out.println(resultado.toString());
		}
		
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

	public static void main(String[] args) {
		Jogo jogoTeste = new Jogo();
		jogoTeste.iniciaPartida();
		
	}
}
