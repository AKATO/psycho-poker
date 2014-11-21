package br.com.akato.psychopoker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JogoNaMao {
	private List<Carta> cartas;

	private int relevanciaDoJogo;

	public JogoNaMao() {
		this.cartas = new ArrayList<Carta>();
		this.relevanciaDoJogo = 1;
	}
	

	public JogoNaMao(List<Carta> cartas) {
		this.cartas = new ArrayList<Carta>();
		this.cartas = cartas;
		this.relevanciaDoJogo = 1;
	}
	
	public void imprimeJogoNaMao(){

		for(int i=0;i<5;i++){
			System.out.print(  this.getCartas().get(i).getCarta() +":");
		}
		System.out.println();
		
	}
	
	public void ordenaJogo(){
		Collections.sort(this.cartas);
	}
	
	
	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}

	public int getRelevanciaDoJogo() {
		return relevanciaDoJogo;
	}

	public void setRelevanciaDoJogo(int relevanciaDoJogo) {
		this.relevanciaDoJogo = relevanciaDoJogo;
	}
	
	public String toString(){
		String retorno = "";
		try{
			for(int i=0;i<this.cartas.size();i++){
				retorno += this.getCartas().get(i).getCarta();
			}
			return retorno;
		}catch(Exception e){
			return retorno;
		}
		}


	


}
