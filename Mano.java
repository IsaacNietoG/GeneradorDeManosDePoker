public class Mano {
    protected Carta[] manoCartas = new Carta[5];

    public Mano(){
        /**
           Crea un arreglo de cinco Cartas aleatorizado. Tiene la restriccion de que
           no puede albergar cartas repetidas. Esto para emular que en el juego de poker
           real no existen cartas repetidas.
        
           Primero verifica si la carta generada ya existe. (con verificarExistencia)
           y si este es el caso no la agrega a la mano. De otra manera continua agregando
           Cartas nuevas al arreglo hasta que se encuentre lleno. Cuando se encuentra lleno
           la flag manoCompletada se deja en true para dejar de construir la baraja.
        
           Luego, pasamos la mano por un bubbleSort para mejor manipulacion posterior.
        
           @return un objeto Mano con su arreglo de Cartas aleatorizado y organizado por valor.
         */
        boolean manoCompletada = false;
        while(!manoCompletada){
            manoCompletada = true;
            Carta carta = new Carta();
            for(int i=0;i<manoCartas.length;i++){
                if(manoCartas[i]==null && !verificarExistencia(carta)){
                    manoCartas[i] = carta;
                }
                if(manoCartas[i] ==null){
                    manoCompletada = false;
                }
            }
        }
        bubbleSort();
    }

    public boolean verificarExistencia(Carta carta){
        /**
           Busca en el arreglo de Cartas si existe una carta que coincida en palo y valor
           con la carta provista como argumento. Si este es el caso, retorna true, caso
           contrario retorna false.

           @param carta el objeto Carta a comparar con los objetos del arreglo.
           @return la posible existencia de una carta identica en el arreglo.
         */
        for(int i=0; i<manoCartas.length; i++){
            if (manoCartas[i] != null) {
                if ((manoCartas[i].getPaloCarta() == carta.getPaloCarta())
                        && (manoCartas[i].getValorCarta().equals(carta.getValorCarta()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public Carta[] getMano(){
        return manoCartas;
    }
    public String toString(){
        String toString="";
        for (int i = 0; i < manoCartas.length;i++){
            toString += manoCartas[i].toString();
        }
        return toString;
    }

    public void bubbleSort(){
        /**
           Acomoda el arreglo de Cartas de menor a mayor valor numérico. Esto lo hago para
           ahorrar un poco de tiempo en los metodos de checkeo de GeneradorDeManos y para
           un mejor display al usuario.
         */
        Carta temporal;
        for(int i=0; i<manoCartas.length;i++){
            for(int j=1; j<manoCartas.length-i;j++){
                if(manoCartas[j-1].getValorNumerico() > manoCartas[j].getValorNumerico()){
                    temporal = manoCartas[j - 1];
                    manoCartas[j - 1] = manoCartas[j];
                    manoCartas[j] = temporal;
                }
            }
        }
    }
}
