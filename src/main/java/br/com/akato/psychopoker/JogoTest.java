package br.com.akato.psychopoker;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.akato.psychopoker.Jogo;
import br.com.akato.psychopoker.Leitor;

public class JogoTest {

	@Mock
	Leitor leitor;
	
	Jogo object;
	
	@Before
	public void init() throws Exception{
		initMocks(this);
		when(leitor.lerEventos()).thenReturn(criarEventos());
		
		object = new Jogo();
	}
	
	
	@Test
	public void validarStraightFlush()throws Exception{
		object.iniciaPartida();
		
		Assert.assertEquals(object.getJogadores().get(0).getRelevanciaMelhorMao(), 9);
	}
	
	@Test
	public void validarFourOfAKind()throws Exception{
		object.iniciaPartida();
		
		Assert.assertEquals(object.getJogadores().get(1).getRelevanciaMelhorMao(), 8);
	}
	
	@Test
	public void validarFullHouse()throws Exception{
		object.iniciaPartida();
		
		Assert.assertEquals(object.getJogadores().get(2).getRelevanciaMelhorMao(), 7);
	}
	
	@Test
	public void validarFlush()throws Exception{
		object.iniciaPartida();
		
		Assert.assertEquals(object.getJogadores().get(3).getRelevanciaMelhorMao(), 6);
	}
	
	@Test
	public void validarStraight()throws Exception{
		object.iniciaPartida();
		
		Assert.assertEquals(object.getJogadores().get(4).getRelevanciaMelhorMao(), 5);
	}
	
	@Test
	public void validarTreeOfAKind()throws Exception{
		object.iniciaPartida();
		
		Assert.assertEquals(object.getJogadores().get(5).getRelevanciaMelhorMao(), 4);
	}
	
	@Test
	public void validaTwoPairs()throws Exception{
		object.iniciaPartida();
		
		Assert.assertEquals(object.getJogadores().get(6).getRelevanciaMelhorMao(), 3);
	}
	
	@Test
	public void validarOnePair()throws Exception{
		object.iniciaPartida();
		
		Assert.assertEquals(object.getJogadores().get(7).getRelevanciaMelhorMao(), 2);
	}
	
	
	@Test
	public void validarHighest()throws Exception{
		object.iniciaPartida();
		
		Assert.assertEquals(object.getJogadores().get(8).getRelevanciaMelhorMao(), 1);
	}
	
	public Collection<String> criarEventos(){
		return asList("TH JH QC QD QS QH KH AH 2S 6S",
				"2H 2S 3H 3S 3C 2D 3D 6C 9C TH",
				"2H 2S 3H 3S 3C 2D 9C 3D 6C TH",
				"2H AD 5H AC 7H AH 6H 9H 4H 3C",
				"AC 2D 9C 3S KD 5S 4D KS AS 4C",
				"KS AH 2H 3C 4H KC 2C TC 2D AS",
				"AH 2C 9S AD 3C QH KS JS JD KD",
				"6C 9C 8C 2D 7C 2H TC 4C 9S AH",
				"3D 5S 2H QD TD 6S KH 9H AD QH");
		
	}
}
