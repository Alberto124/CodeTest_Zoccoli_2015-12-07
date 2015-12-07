package it.codetest.tennis.test;



import java.util.Arrays;
import java.util.List;

public class Giocatore {

    public static final List<String> descrizionePunti = Arrays.asList("love", "fifteen", "thirty", "forty");
		
	private int punteggio;
    private String nome;
   
    public Giocatore(String nome) {
        this.nome = nome;
        
    }
    
    public void faPunto() {
        this.punteggio = this.punteggio + 1;
       
    }
    
    public int getPunteggio() {
        return punteggio;
    }
    
    public String getNome() {
        return nome;
    }

    public String getDescrizionePunti(){
        return descrizionePunti.get(punteggio);
    }

}