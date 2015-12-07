package it.codetest.tennis.test;

public class Gioco {
	 
    private Giocatore giocatore1;
    private Giocatore giocatore2;
 
    public Gioco(Giocatore giocatore1, Giocatore giocatore2) {
        this.giocatore1 = giocatore1;
        this.giocatore2 = giocatore2;
    }
 
    public String getPunteggio() {
    	//Ho messo || e non && perchè se un giocatore fa almeno quattro punti e l'altro ne fa meno di tre allora il primo giocatore won 
        if (giocatore1.getPunteggio() >= 3 || giocatore2.getPunteggio() >= 3) {
        	
            if ((giocatore1.getPunteggio()>3 || giocatore2.getPunteggio()>3) && (Math.abs(giocatore2.getPunteggio() - giocatore1.getPunteggio()) >= 2)){
                return getLeaderGiocatore().getNome() + " won";
            } else if (giocatore1.getPunteggio() == giocatore2.getPunteggio()) {
                return "deuce";
            } else if((giocatore1.getPunteggio()>3 || giocatore2.getPunteggio()>3) && (Math.abs(giocatore2.getPunteggio() - giocatore1.getPunteggio()) == 1)){
                return "advantage " + getLeaderGiocatore().getNome();
            }
            else{return giocatore1.getDescrizionePunti() + ", " + giocatore2.getDescrizionePunti();}
        } else {
            return giocatore1.getDescrizionePunti() + ", " + giocatore2.getDescrizionePunti();
        }
    }
 
    public Giocatore getLeaderGiocatore() {
        return (giocatore1.getPunteggio() > giocatore2.getPunteggio()) ? giocatore1 : giocatore2;
    }
 
}
