
package it.codetest.tennis.test;

import org.junit.Test;


import java.util.stream.IntStream;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestGiocatore{
    @Test
    public void pointsChePossonoEssereAggiuntiACiascunGiocatore() {
        Giocatore andrea = new Giocatore("Andrea");
        Giocatore mario = new Giocatore("Sarah");
        System.out.println("FANTASTIC");
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            andrea.faPunto();
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            mario.faPunto();
        });
        assertThat(andrea, hasProperty("punteggio", is(3)));
        assertThat(mario, hasProperty("punteggio", is(4)));
        
        
    }
    
   // @Test
    /*public void ShouldAdd() {
        // this is wrong, and should fail
        assertEquals(3, Calculator.add(1, 1));
    }*/
}








































































































































