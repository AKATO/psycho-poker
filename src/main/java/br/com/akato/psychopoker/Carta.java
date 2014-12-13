package br.com.akato.psychopoker;
public class Carta{
	private String carta;
	private String naipe;
	private int valor;

	public Carta(String codigo) {
		this.carta = codigo;
		this.valor = (codigo.substring(0, 1).equals("T")) ? CartaEnum.T.valorCarta
				: (codigo.substring(0, 1).equals("J") ? CartaEnum.J.valorCarta
						: (codigo.substring(0, 1).equals("Q") ? CartaEnum.Q.valorCarta
								: (codigo.substring(0, 1).equals("K") ? CartaEnum.K.valorCarta
										: (codigo.substring(0, 1).equals("A") ? CartaEnum.A.valorCarta
												: Integer.parseInt(codigo
														.substring(0, 1))))));
		this.naipe = codigo.substring(1, 2).equals("C") ? "PAUS" : (codigo
				.substring(1, 2).equals("D") ? "OURO" : (codigo.substring(1, 2)
				.equals("S") ? "ESPADA" : "COPAS"));

	}

	public String getCarta() {
		return carta;
	}

	public void setCarta(String carta) {
		this.carta = carta;
	}

	public String getNaipe() {
		return naipe;
	}

	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
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
