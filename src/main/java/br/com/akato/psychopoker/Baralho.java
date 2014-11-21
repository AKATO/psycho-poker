package br.com.akato.psychopoker;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Baralho {
	public static final String[] CARTAS_ALTAS = { "T", "J", "Q", "K", "A" };
	public static final String[] NAIPES = { "C", "D", "S", "H" };

	private List<Carta> cartas ;

	
	public Baralho(){
		this.cartas = montarBaralho();
	}
	
	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}

	public List<Carta> montarBaralho() {
		Carta carta;
		List<Carta> baralho = new ArrayList<Carta>(52);

		for (int n = 0; n < NAIPES.length; n++) {
			for (int j = 2; j <= 14; j++) {
				if (j < 10) {
					carta = new Carta("" + j + NAIPES[n]);
					baralho.add(carta);
				} else {
					carta = new Carta(CARTAS_ALTAS[j - 10] + NAIPES[n]);
					baralho.add(carta);

				}
			}
		}
		return embaralharCartas(baralho);

	}

	public List<Carta> embaralharCartas(List<Carta> baralhoOrdenado) {
		Random cortesNoBaralho = new Random();
		int vezes = cortesNoBaralho.nextInt(51);
		for (int v = 0; v < vezes; v++) {
			for (int j = 0; j < 52; j++) {
				if (j == 0) {
					Carta aux = baralhoOrdenado.get(vezes);
					baralhoOrdenado.set(vezes, baralhoOrdenado.get(j));
					baralhoOrdenado.set(j, aux);
				} else if (j % 2 == 0) {
					Carta aux = baralhoOrdenado.get(j);
					baralhoOrdenado.set(j, baralhoOrdenado.get(j + 1));
					baralhoOrdenado.set(j, aux);
				} else if (j % 3 == 0 || j % 7 == 0 || j % 11 == 0) {
					Carta aux = baralhoOrdenado.get(51 - vezes);
					baralhoOrdenado.set(51 - vezes, baralhoOrdenado.get(j));
					baralhoOrdenado.set(j, aux);
				} else {
					Carta aux = baralhoOrdenado.get(51 - 1);
					baralhoOrdenado.set(51 - 1, baralhoOrdenado.get(j));
					baralhoOrdenado.set(j, aux);
				}
			}
		}
		return baralhoOrdenado;

	}


}
