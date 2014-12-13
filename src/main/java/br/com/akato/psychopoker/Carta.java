package br.com.akato.psychopoker;
import static br.com.akato.psychopoker.CartaEnum.mapaCartaValor;;

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
		String ref = codigo.substring(0, 1);
		if(mapaCartaValor.containsKey(ref)){
			return mapaCartaValor.get(ref).valorCarta;
		}else {
			return Integer.parseInt(ref);
			}
	}
	
	private String atribuirNaipeCarta(String codigo){
		String valorNaipe=	codigo.substring(1, 2).equals("C") ? "PAUS" : (codigo
				.substring(1, 2).equals("D") ? "OURO" : (codigo.substring(1, 2)
				.equals("S") ? "ESPADA" : "COPAS"));
		
		return valorNaipe;
		
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carta == null) ? 0 : carta.hashCode());
		result = prime * result + ((naipe == null) ? 0 : naipe.hashCode());
		result = prime * result + valor;
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
		if (naipe == null) {
			if (other.naipe != null)
				return false;
		} else if (!naipe.equals(other.naipe))
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}

}
