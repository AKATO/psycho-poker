package br.com.akato.psychopoker;
import java.util.ArrayList;
import java.util.List;

public class Jogo {
	private List<Jogador> jogadores;
	private List<Baralho> baralhos;
	private int quantidadeJogadores;

	public int getQuantidadeJogadores() {
		return quantidadeJogadores;
	}

	public void setQuantidadeJogadores(int quantidadeJogadores) {
		this.quantidadeJogadores = quantidadeJogadores;
	}

	public Jogo(int quantidadeJogadores) {
		this.quantidadeJogadores = quantidadeJogadores;
		this.jogadores = new ArrayList<Jogador>();
		this.baralhos = new ArrayList<Baralho>();
	}
	
	public Jogo() {
		this.jogadores = new ArrayList<Jogador>();
		this.baralhos = new ArrayList<Baralho>();
	}
		
	public void iniciaPartida(){
		populaPartida();
		dasAsCartas();
	}
	
	public void iniciaPartida(String cartas){
		Carta cartaTemporaria ;
		List<Carta> cartasDoJogador ;
		try {
		cartasDoJogador = new ArrayList<Carta>();
		if(cartas != null && cartas.length()>=25){
			cartas	= cartas.trim();
			String[] todasCartas = cartas.split(" ");
			for(int q=0;q<todasCartas.length;q++){
				cartaTemporaria = new Carta(todasCartas[q]);
				cartasDoJogador.add(cartaTemporaria);
			}
			Jogador jogadorPontual = new Jogador(cartasDoJogador);
			CombinacoesDeJogos combi = new CombinacoesDeJogos();
			combi.imprimeCartasDaMaoEDoMonte(jogadorPontual.getCartasNaMao(),jogadorPontual.getCartasNoMonte());
			combi.outrasPossibilidades(jogadorPontual.getCartasNaMao(),jogadorPontual.getCartasNoMonte());
			
			String melhorJogo = combi.retornarJogoDeMaiorRelevancia();
			jogadorPontual.setMelhorJogo(melhorJogo.substring(2));
			jogadorPontual.setRelevanciaMelhorJogo(Integer.parseInt(melhorJogo.substring(0,1)));
			System.out.print(" Melhor Jogo: " + getJogoFormado(jogadorPontual.getRelevanciaMelhorJogo()) + " . ");
		
		}
		} catch (Exception e) {
			System.out.println("Houve um problema ao dar as cartas no trecho : " );
			 e.printStackTrace();
		}
		
		
	}
	
	public String getJogoFormado(int valor){
			switch(valor){
			
			case 1 : return "HIGHEST(Maior Carta)";
			case 2 : return  "ONE-PAIR(Um Par)";
			case 3 : return  "TWO-PAIRS(Dois Pares)";
			case 4 : return "THREE-OF-A-KIND(Uma Trinca)";
			case 5 : return "STRAIGHT(Sequencia)";
			case 6 : return "FLUSH(Todas do Mesmo Naipe)";
			case 7 : return "FULL-HOUSE( Dupla + Trinca)";
			case 8 : return "FOUR-OF-A-KIND(Uma Quadra)";
			case 9 : return "STRAIGHT-FLUSH(Sequencia Do Mesmo Naipe)";
			
			}
			return "Maior Carta";

	}
	
	public void populaPartida(){
		for(int i=0;i< getQuantidadeJogadores();i++){
			this.jogadores.add(new Jogador(i));
			this.baralhos.add(new Baralho());
		}
	}
	

	public void dasAsCartas() {
		int jogadorIndex = 0;
		for (Baralho baralho : getBaralhos()) {
			this.getBaralhos().set(jogadorIndex, baralho);
			this.getJogadores().get(jogadorIndex).getCartasNaMao().addAll(baralho.getCartas().subList(0, 5));
			this.getJogadores().get(jogadorIndex).getCartasNoMonte().addAll(baralho.getCartas().subList(5, 10));
			jogadorIndex ++;
		}
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
		jogoTeste.iniciaPartida("TH JH QC QD QS QH KH AH 2S 6S");
//		jogoTeste.iniciaPartida("AH 2C 9S AD 3C QH KS JS JD KD");
		
	}
}
