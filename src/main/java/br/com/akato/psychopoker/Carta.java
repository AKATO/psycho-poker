package br.com.akato.psychopoker;
import static br.com.akato.psychopoker.CartaEnum.mapaCartaValor;
import static br.com.akato.psychopoker.NaipeEnum.mapaNaipe;
public class Carta{
	private String carta;
	private String naipe;
	private int valor;

	public Carta(String codigo) {
		this.carta = codigo;
		this.valor = atribuirValorCarta(codigo);
		this.naipe = atribuirNaipeCarta(codigo);
	}

	public String getCarta() {
		return carta;
	}

	public String getNaipe() {
		return naipe;
	}

	public int getValor() {
		return valor;
	}
	
	private int atribuirValorCarta(String codigo){
		if(mapaCartaValor.containsKey(codigo.substring(0,1))){
			return mapaCartaValor.get(codigo.subSequence(0, 1)).valorCarta;
		}else {
			return Integer.parseInt(codigo.substring(0,1));
			}
	}
	
	private String atribuirNaipeCarta(String codigo){
		return mapaNaipe.get(codigo.substring(1,2)).naipe;	
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carta == null) ? 0 : carta.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		if (carta == null) {
			if (other.carta != null)
				return false;
		} else if (!carta.equals(other.carta))
			return false;
		
		return true;
	}

}
