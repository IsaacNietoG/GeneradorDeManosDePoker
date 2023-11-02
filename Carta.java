import java.util.Random;
public class Carta {

    protected Random randomizador = new Random();
    protected String valorCarta;
    protected char paloCarta;
    protected String[] valoresPosibles = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "0", "J", "Q", "K" };
    protected char[] palosPosibles = {'C', 'D', 'T', 'P'};

    public Carta(){
        valorCarta = valoresPosibles[randomizador.nextInt(12)];
        paloCarta = valoresPosibles[randomizador.nextInt(3)];
    }

    public char getValorCarta(){
        return valorCarta;
    }
}

