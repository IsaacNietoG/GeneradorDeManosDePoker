import java.util.Random;
public class Carta {

    protected Random randomizador = new Random();
    protected String valorCarta;
    protected int valorNCarta;
    protected char paloCarta;
    static String[] valoresPosibles = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    static char[] palosPosibles = {'C', 'D', 'T', 'P'};
    protected String color;

    public Carta(){
        /**
           Genera una carta con un valor y palo aleatorio entre los provistos en las listas
           estáticas valoresPosibles y palosPosibles.
           No se maneja ninguna restricción para valores repetidos pues eso lo implementaré
           en la clase Mano.

           @return un objeto de tipo Carta con palo y valor aleatorizado.
         */
        int randomValor = randomizador.nextInt(13);
        int randomPalo = randomizador.nextInt(4);
        valorNCarta = randomValor+1;
        valorCarta = valoresPosibles[randomValor];
        paloCarta = palosPosibles[randomPalo];
        switch(randomPalo){
        case 0:
        case 1:
            color = "Rojo";
            break;
        case 2:
        case 3:
            color = "Negro";
            break;
        }
    }

    public int getValorNumerico(){
        return valorNCarta;
    }
    public String getValorCarta(){
        return valorCarta;
    }

    public char getPaloCarta(){
        return paloCarta;
    }

    public void setValorCarta(String valorCarta){
        /**
           Setea la variable valorCarta al valor provisto al metodo. Verifica primero si
           el valor provisto es alguno de los validos que puede tomar una carta. Si este
           no es el caso, no realiza cambio alguno y notifica al usuario de lo mismo.

           @param valorCarta una String que va a ser la que dara el nuevo valor al valorCarta
           de la instancia.
           @return ajusta el valor valorCarta de la instancia en la que se invoque el metodo.
         */
        String temp = this.valorCarta;
        for(int i=0;i<valoresPosibles.length; i++){
            if(valorCarta.equals(valoresPosibles[i])){
                this.valorNCarta = i + 1;
                this.valorCarta = valorCarta;
                System.out.println("Operacion Exitosa");
                break;
            }
        }
        if(temp.equals(this.valorCarta)){
            System.out.println("La operación no se pudo realizar, ya sea porque el valor que quería cambiar ya era el mismo o porque ingresó un valor inválido para esta operación");
        }
    }

    public void setPaloCarta(char paloCarta){
        /**
           Setea la variable paloCarta al valor provisto al metodo. Al igual que el metodo
           setValorCarta, verifica primero si el valor provisto es válido como nuevo valor.

           @param paloCarta un char que será la que dara nuevo valor al paloCarta de la
           instancia.
           @return ajusta el valor paloCarta de la instancia en la que se invoca el método.
         */
        char temp = this.paloCarta;
        for (int i = 0; i < palosPosibles.length; i++) {
            if (paloCarta==palosPosibles[i]) {
                this.paloCarta = paloCarta;
                System.out.println("Operacion Exitosa");
                break;
            }
        }
        if (temp==this.paloCarta) {
            System.out.println(
                    "La operación no se pudo realizar, ya sea porque el valor que quería cambiar ya era el mismo o porque ingresó un valor inválido para esta operación");
        }
    }

    public String getColor(){
        return color;
    }

    public String toString(){
        return "Carta[" + valorCarta+ paloCarta+"]";
    }
}

