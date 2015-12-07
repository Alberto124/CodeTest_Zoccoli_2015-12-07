package it.codetest.tennis.test;

import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.stream.IntStream;

public class TestGioco {
	
	Giocatore andrea;
	Giocatore mario;
	Gioco gioco;

	@Before
	public void primaGiocoTest() {
		andrea = new Giocatore("andrea");
		mario = new Giocatore("mario");
		gioco = new Gioco(andrea, mario);
	}

	@Test
	public void lovePerPunteggio0() {
		Gioco gioco = new Gioco(andrea, mario);
		assertThat(gioco, hasProperty("punteggio", is("love, love")));
	}

	@Test
	public void fifteenPerPunteggio1() {
		mario.faPunto();
		assertThat(gioco, hasProperty("punteggio", is("love, fifteen")));
	}

	@Test
	public void thirtyPerPunteggio2() {
		andrea.faPunto();
		andrea.faPunto();
		mario.faPunto();
		assertThat(gioco, hasProperty("punteggio", is("thirty, fifteen")));
	}

	@Test
	public void fortyPerPunteggio3() {
		IntStream.rangeClosed(1, 3).forEach((Integer) -> {
			andrea.faPunto();
		});
		assertThat(gioco, hasProperty("punteggio", is("forty, love")));
	}

	@Test
	public void advantageConAlmenoTrePuntiFattiEUnGiocatoreHaunPuntoInPiuRispettoAllAvversario() {
		IntStream.rangeClosed(1, 3).forEach((Integer) -> {
			andrea.faPunto();
		});
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			mario.faPunto();
		});
		assertThat(gioco, hasProperty("punteggio", is("advantage mario")));
	}

	@Test
	public void deuceQuandoAlmenoTrePuntiSonoStatiFattiDaCiascunGiocatoreEIPunteggiSonoUguali() {
		for (int indice = 1; indice <= 3; indice++) {
			andrea.faPunto();
		}
		for (int indice = 1; indice <= 3; indice++) {
			mario.faPunto();
		}
		assertThat(gioco, hasProperty("punteggio", is("deuce")));
		andrea.faPunto();
		assertThat(gioco, hasProperty("punteggio", is(not("deuce"))));
		mario.faPunto();
		assertThat(gioco, hasProperty("punteggio", is("deuce")));
	}

	@Test
	public void wonSeUnGiocatoreHaFattoAlmenoQuattroPuntiInTotaleEConAlmenoDuePuntiInPiuRispettoAllAvversario() {
		for (int indice = 1; indice <= 3; indice++) {
			andrea.faPunto();
		}
		for (int indice = 1; indice <= 2; indice++) {
			mario.faPunto();
		}
		assertThat(gioco, hasProperty("punteggio", is(not("andrea won"))));
		assertThat(gioco, hasProperty("punteggio", is(not("mario won"))));
		andrea.faPunto();
		//andrea ha fatto piu di tre punti(quattro) e mario ha fatto meno di tre punti  
		assertThat(gioco, hasProperty("punteggio", is("andrea won")));
	}

}