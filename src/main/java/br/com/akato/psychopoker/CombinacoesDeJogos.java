package br.com.akato.psychopoker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CombinacoesDeJogos {
	public static final int HIGHEST = 1;
	public static final int ONE_PAIR = 2;
	public static final int TWO_PAIRS = 3;
	public static final int THREE_OF_A_KIND = 4;
	public static final int STRAIGHT = 5;
	public static final int FLUSH = 6;
	public static final int FULL_HOUSE = 7;
	public static final int FOUR_OF_A_KIND = 8;
	public static final int STRAIGHT_FLUSH = 9;
	
	private Map<Integer, String> jogosPorRelevancia;
	private List<JogoNaMao> possiveisJogosFormados;
	
	public CombinacoesDeJogos(){
		
		this.jogosPorRelevancia = new TreeMap<Integer,String>();
		this.possiveisJogosFormados = new ArrayList<JogoNaMao>();
	}
	
	public void imprimeCartasDaMaoEDoMonte(List<Carta> listaDaMao, List<Carta> listaDoMonte){
		System.out.print("Mao: ");
		for(int i=0;i<5;i++){System.out.print(  listaDaMao.get(i).getCarta() +":");}
		System.out.print("  Monte: ");
		for(int i=0;i<5;i++){System.out.print(  listaDoMonte.get(i).getCarta() +":");}
		System.out.print("  ");
	}

	
	public void adicionarSequenciasDeCartasGeradas(List<Carta> sequenciaAdicionada){
		
		JogoNaMao jogoNaMaoTemporarios = new JogoNaMao(sequenciaAdicionada);
		this.possiveisJogosFormados.add(jogoNaMaoTemporarios);
		validarCartas(jogoNaMaoTemporarios);
	}
	
	public void validarCartas(JogoNaMao jogoParaValidacao){
		JogoNaMao jogoNaMao = new JogoNaMao(jogoParaValidacao.getCartas());
		Collections.sort(jogoNaMao.getCartas());
		
		JogoNaMao jogoValidado = new JogoNaMao();
		jogoValidado = verificarCombinacoes(jogoNaMao);
		if(!this.jogosPorRelevancia.containsKey(jogoValidado.getRelevanciaDoJogo())){	
			this.jogosPorRelevancia.put(jogoValidado.getRelevanciaDoJogo(), jogoValidado.toString());
		}
	}
	
	public String retornarJogoDeMaiorRelevancia(){
		if(this.jogosPorRelevancia.isEmpty()!=true){
				if(this.jogosPorRelevancia.containsKey(9)){
					return "9-"+this.jogosPorRelevancia.get(9);
				}else if(this.jogosPorRelevancia.containsKey(8)){
					return "8-"+this.jogosPorRelevancia.get(8);
				}else if(this.jogosPorRelevancia.containsKey(7)){
					return "7-"+this.jogosPorRelevancia.get(7);
				}else if(this.jogosPorRelevancia.containsKey(6)){
					return "6-"+this.jogosPorRelevancia.get(6);
				}else if(this.jogosPorRelevancia.containsKey(5)){
					return "5-"+this.jogosPorRelevancia.get(5);
				}else if(this.jogosPorRelevancia.containsKey(4)){
					return "4"+this.jogosPorRelevancia.get(4);
				}else if(this.jogosPorRelevancia.containsKey(3)){
					return "3-"+this.jogosPorRelevancia.get(3);
				}else if(this.jogosPorRelevancia.containsKey(2)){
					return "2-"+this.jogosPorRelevancia.get(2);
				}else if(this.jogosPorRelevancia.containsKey(1)){
					return "1-"+this.jogosPorRelevancia.get(1);
				}else return null; 	
	}else return null;
	}
	
	public JogoNaMao verificarCombinacoes(JogoNaMao jogoNovo){
		JogoNaMao jogoNaMao = new JogoNaMao(jogoNovo.getCartas());
		List<Carta> cartas = jogoNaMao.getCartas();

		int seq = 0;
		int contFlush=0;
		int cartasIguais1=0;
		int cartasIguais2=0;
		int valorCartaIgual1=0;
		@SuppressWarnings("unused")
		int valorCartaIgual2=0;
		
		int aux;
		int cont;
		for(int n=0;n<5;n++){
			aux = cartas.get(n).getValor();
			cont=0;
			for(int j=0;j<5;j++){
				if(aux==cartas.get(j).getValor()){
				cont ++;
				}
			}
			if(cont>=2){
				if(valorCartaIgual1==0){ cartasIguais1 = cont; valorCartaIgual1=aux;}
				else if(valorCartaIgual1!=0 && valorCartaIgual1==aux)continue;
				else{cartasIguais2 = cont;valorCartaIgual2=aux;}
			}
		}
		
		for(int i=0;i<4;i++){
			if(cartas.get(i).getValor()+1 == cartas.get(i+1).getValor())
				seq ++ ;
			if(cartas.get(i).getValorRelevanciaNaipe() == cartas.get(i+1).getValorRelevanciaNaipe())
				contFlush ++;
		}
		
		
		if(seq==4){
			jogoNaMao.setRelevanciaDoJogo(STRAIGHT);
			if(contFlush==4){
				jogoNaMao.setRelevanciaDoJogo(STRAIGHT_FLUSH);
			}
		}else if(cartasIguais1==4)
			jogoNaMao.setRelevanciaDoJogo(FOUR_OF_A_KIND);
		else if(cartasIguais1==3 || cartasIguais2==3){
			if(cartasIguais1==3 && cartasIguais2==2){
				jogoNaMao.setRelevanciaDoJogo(FULL_HOUSE);
			}else if(cartasIguais1==2 || cartasIguais2==3){
				jogoNaMao.setRelevanciaDoJogo(FULL_HOUSE);
			}else if(contFlush==4){
				jogoNaMao.setRelevanciaDoJogo(FLUSH);
			}
			else{
				jogoNaMao.setRelevanciaDoJogo(THREE_OF_A_KIND);
			}
		}else if(cartasIguais1==2 && cartasIguais2==2){
			jogoNaMao.setRelevanciaDoJogo(TWO_PAIRS);
		}else if(cartasIguais1==2){
			jogoNaMao.setRelevanciaDoJogo(ONE_PAIR);
		}else{
			jogoNaMao.setRelevanciaDoJogo(HIGHEST);
		}
		return jogoNaMao;
	}
	public void outrasPossibilidades(List<Carta> listaDaMao, List<Carta> listaDoMonte){
		List<Carta> monte = new ArrayList<Carta>();
		monte.addAll(listaDoMonte);
		List<Carta> trocandoTodas = new ArrayList<Carta>();
		trocandoTodas.addAll(listaDoMonte);
		List<Carta> mao = new ArrayList<Carta>();
		List<Carta> auxList = new ArrayList<Carta>();
		List<Carta> auxList2 = new ArrayList<Carta>();
		List<Carta> auxList3 = new ArrayList<Carta>();
		mao.addAll(listaDaMao);
		for(int i =0;i<5;i++){
			mao.remove(i);
			mao.add(monte.get(0));
			adicionarSequenciasDeCartasGeradas(mao);
			auxList.addAll(mao);
			for(int j=0;j<4;j++){
				auxList.remove(j);
				auxList.add(monte.get(1));
				adicionarSequenciasDeCartasGeradas(auxList);
				auxList2.addAll(auxList);
				for(int k=0;k<3;k++){
					auxList2.remove(k);
					auxList2.add(monte.get(2));
					adicionarSequenciasDeCartasGeradas(auxList2);
					auxList3.addAll(auxList2);
					for(int l=0;l<2;l++){
						auxList3.remove(l);
						auxList3.add(monte.get(3));
						adicionarSequenciasDeCartasGeradas(auxList3);
					}
					auxList3.clear();//$
					
					auxList2.clear();
					auxList2.addAll(auxList);
				}
				auxList2.clear();//$
				
				auxList.clear();
				auxList.addAll(mao);
			}
			auxList.clear();//$
			
			mao.clear();
			mao.addAll(listaDaMao);
		}
		adicionarSequenciasDeCartasGeradas(trocandoTodas);
	}
	
	public List<JogoNaMao> getPossiveisJogosFormados() {
		return possiveisJogosFormados;
	}

	public void setPossiveisJogosFormados(List<JogoNaMao> possiveisJogosFormados) {
		this.possiveisJogosFormados = possiveisJogosFormados;
	}

}