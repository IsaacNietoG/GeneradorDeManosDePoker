/**

 */
public class GeneradorDeManos {
    public static String stringManoGenerada = "";
    public static char auxiliarPalo;
    public static char auxiliarPalo2;
    public static char auxiliarPalo3;
    public static int auxiliarValor;
    public static int auxiliarValor2;
    public static int auxiliarValor3;
    public static void main(String[] args){
        System.out.println("Bienvenido al generador de manos de Poker.");
        System.out.println("Se generará una mano de cartas de Poker aleatorizada y se te dirá si recibiste alguna mano buena.");
        int manoEncontrada = 0;

        int debug = Integer.valueOf(args[0]);
        do{

        Mano manoGenerada = new Mano();
        manoEncontrada=0;
        switch(9){
        case 9:
            manoEncontrada = checkEscaleraReal(manoGenerada);
            if(manoEncontrada !=0) break;
        case 8:
            manoEncontrada = checkEscaleraColor(manoGenerada);
            if(manoEncontrada !=0) break;
        case 7:
            manoEncontrada = checkPoker(manoGenerada);
            if (manoEncontrada != 0) break;
        case 6:
            manoEncontrada = checkFull(manoGenerada);
            if (manoEncontrada != 0) break;
        case 5:
            manoEncontrada = checkColor(manoGenerada);
            if (manoEncontrada != 0) break;
        case 4:
            manoEncontrada = checkEscalera(manoGenerada);
            if (manoEncontrada != 0) break;
        case 3:
            manoEncontrada = checkTrio(manoGenerada);
            if (manoEncontrada != 0) break;
        case 2:
            manoEncontrada = checkDoblePareja(manoGenerada);
            if (manoEncontrada != 0) break;
        case 1:
            manoEncontrada = checkPareja(manoGenerada);
            if (manoEncontrada != 0) break;
        case 0:
            manoEncontrada = 0;
        }
        System.out.println(manoGenerada.toString());
        if(manoEncontrada !=0) System.out.println("La mano generada es una: " + stringManoGenerada);
        else System.out.println("No tuviste una buena mano");

        System.out.println();
        }while(debug != manoEncontrada);

    }

    public static int checkEscaleraReal(Mano mano){
        /**
           Verifica si la mano recibida es una Escalera Real.

           Para esto, primero verifica que todas las cartas sean del mismo palo,
           para hacerlo de forma rápida se comparan los palos de todas las cartas con el palo de
           la primera.

           Luego, se verifica si la mano recibida efectitvamente coincide con el orden deseado para
           una escalera real (A,10,J,Q,K)

           En cada verificación se incluye un return 0 en caso fallido. De esta forma, solo llegamos
           al return 1 si todas las verificaciones han sido pasadas correctamente.

           @param mano la mano de cartas a analizar
           @return un int que representa si la mano recibida coincide con lo buscado. Ademas, altera
           la variable global stringManoGenerada si la mano coincide con lo buscado.
         */
        Carta[] arregloMano = mano.getMano();
        char palo = arregloMano[0].getPaloCarta();
        //Verifica si todas las cartas son del mismo color.
        //Si alguna carta es de un palo distinto retorna 0 directo.
        for(int i = 0;i<arregloMano.length; i++){
            if(arregloMano[i].getPaloCarta()!=palo){
                return 0;
            }
        }
        if(arregloMano[0].getValorNumerico()!=1)
            return 0;
        if (arregloMano[1].getValorNumerico() != 10)
            return 0;
        if (arregloMano[2].getValorNumerico() != 11)
            return 0;
        if (arregloMano[3].getValorNumerico() != 12)
            return 0;
        if (arregloMano[4].getValorNumerico() != 13)
            return 0;

        stringManoGenerada = "Escalera real de " + palo;
        return 9;
    }

    public static int checkEscaleraColor(Mano mano){
        /**
         * Verifica si la mano recibida es una escalera de color.
         * 
         * Primero verifica si todas las cartas son del mismo palo con la misma tecnica
         * que usa
         * checkEscaleraReal.
         *
         * Luego, verifica si las cartas de la mano efectivamente son consecutivas en su
         * valor.
         *
         * @param mano la mano de cartas a analizar
         * @return un int que representa si la mano recibida coincide con lo buscado.
         *         Ademas, altera
         *         la variable global stringManoGenerada si la mano coincide con lo
         *         buscado.
         */
        Carta[] arregloMano = mano.getMano();
        char palo = arregloMano[0].getPaloCarta();
        // Verifica si todas las cartas son del mismo color.
        // Si alguna carta es de un palo distinto retorna 0 directo.
        for (int i = 0; i < arregloMano.length; i++) {
            if (arregloMano[i].getPaloCarta() != palo) {
                return 0;
            }
        }
        for(int i=1;i<arregloMano.length;i++){
            int valorBuscado = arregloMano[i-1].getValorNumerico()+1;
            if(arregloMano[i].getValorNumerico()!=valorBuscado)
                return 0;
        }

        stringManoGenerada = "Escalera de color de " + palo;
        return 8;
    }

    public static int checkPoker(Mano mano) {
        /**
         * Verifica si la mano recibida es un poker.
         * 
         * Guarda el valor de la primera y ultima carta y los compara con el resto de
         * cartas de la mano
         * guarda el numero de coincidencias de valores en dos variables contador, y si
         * alguna de estas variables
         * contador es igual a 4 entonces retorna el resultado necesario.
         * 
         * No se considera el caso en el que alguno de los contadores llegue a 5 porque
         * es imposible de lograr
         * en la implementacion actual pues solo hay 4 palos y no existe repetición de
         * cartas.
         * 
         * @param mano la mano de cartas a analizar
         * @return un int que representa si la mano recibida coincide con lo buscado.
         *         Ademas, altera
         *         la variable global stringManoGenerada si la mano coincide con lo
         *         buscado.
         */
        Carta[] arregloMano = mano.getMano();
        auxiliarPalo = arregloMano[0].getPaloCarta();
        auxiliarPalo2 = arregloMano[4].getPaloCarta();
        auxiliarValor = arregloMano[0].getValorNumerico();
        auxiliarValor2 = arregloMano[4].getValorNumerico();
        int contador1=0;
        int contador2=0;
        for(int i=0;i<arregloMano.length;i++){
            if(arregloMano[i].getValorNumerico()==auxiliarValor)
                contador1++;
            if(arregloMano[i].getValorNumerico() ==auxiliarValor2)
                contador2++;
        }
        if(contador1 == 4){
            stringManoGenerada = "Poker de " + auxiliarPalo;
            return 7;
        }
        if(contador2 == 4){
            stringManoGenerada = "Poker de " + auxiliarPalo2;
            return 7;
        }
        return 0;
    }

    public static int checkFull(Mano mano) {
        /**
         * Verifica si la mano recibida es un full.
         * 
         * Guarda el valor de la primera y ultima carta y los compara con el resto de
         * cartas de la mano
         * guarda el numero de coincidencias de valores en dos variables contador, y si
         * los contadores llegan a 3 y 2 (no importa cuales) entonces tenemos lo que
         * buscamos.
         * 
         * No se considera el caso en el que alguno de los contadores llegue a 5 porque
         * es imposible de lograr
         * en la implementacion actual pues solo hay 4 palos y no existe repetición de
         * cartas.
         * 
         * @param mano la mano de cartas a analizar
         * @return un int que representa si la mano recibida coincide con lo buscado.
         *         Ademas, altera
         *         la variable global stringManoGenerada si la mano coincide con lo
         *         buscado.
         */
        Carta[] arregloMano = mano.getMano();
        auxiliarPalo = arregloMano[0].getPaloCarta();
        auxiliarPalo2 = arregloMano[4].getPaloCarta();
        auxiliarValor = arregloMano[0].getValorNumerico();
        auxiliarValor2 = arregloMano[4].getValorNumerico();
        int contador1 = 0;
        int contador2 = 0;
        for (int i = 0; i < arregloMano.length; i++) {
            if (arregloMano[i].getValorNumerico() == auxiliarValor)
                contador1++;
            if (arregloMano[i].getValorNumerico() == auxiliarValor2)
                contador2++;
        }
        if (contador1 == 3 && contador2 == 2) {
            stringManoGenerada = "Full de " + arregloMano[0].getValorCarta() + " y " + arregloMano[4].getValorCarta();
            return 6;
        }
        if (contador2 == 2 && contador1 == 3) {
            stringManoGenerada = "Full de " + arregloMano[4].getValorCarta() + " y " + arregloMano[0].getValorCarta();
            return 6;
        }
        return 0;
    }

    public static int checkColor(Mano mano) {
        /**
           Verifica si la mano recibida es una Color

           Solamente verifica si todas las cartas son del mismo color.

           @param mano la mano de cartas a analizar.
           @return un int que representea si la mano recibida coincide con lo buscado.
           ademas altera la variable global stringManoGenerada si la mano coincide en lo buscado.
         */
        Carta[] arregloMano = mano.getMano();
        String color = arregloMano[0].getColor();
        // Verifica si todas las cartas son del mismo color.
        // Si alguna carta es de un color distinto retorna 0 directo.
        for (int i = 0; i < arregloMano.length; i++) {
            if (!arregloMano[i].getColor().equals(color)) {
                return 0;
            }
        }
        stringManoGenerada = "Color de " + color;
        return 5;
    }

    public static int checkEscalera(Mano mano) {
        /**
         * Verifica si la mano recibida es una Escalera.
         * 
         * Recicla el procedimiento de checkEscaleraColor pero sin la verificacion
         * de que sean del mismo palo.
         *
         * @param mano la mano de cartas a analizar.
         * @return un int que representea si la mano recibida coincide con lo buscado.
         *         ademas altera la variable global stringManoGenerada si la mano
         *         coincide en lo buscado.
         * 
         */
        Carta[] arregloMano = mano.getMano();
        if(arregloMano[0].getValorNumerico()==1 && arregloMano[1].getValorNumerico() ==10 && arregloMano[2].getValorNumerico() == 11 && arregloMano[3].getValorNumerico() == 12 && arregloMano[4].getValorNumerico() == 13){
            stringManoGenerada = "Escalera";
            return 1;
        }
        for (int i = 1; i < arregloMano.length; i++) {
            int valorBuscado = arregloMano[i - 1].getValorNumerico() + 1;
            if (arregloMano[i].getValorNumerico() != valorBuscado)
                return 0;
        }

        stringManoGenerada = "Escalera";
        return 4;

    }

    public static int checkTrio(Mano mano) {
        /**
           Verifica si la mano recibida es un Trio

           Para esto
           primero guarda tres valores distintos (la maxima cantidad posible de valores distintos
           en una mano Trio) y guarda la cantidad de coincidencias con estos valores. Si alguna de estas
           coincidencias llega a 3 entonces tenemos un trio y lo retorna como tal.

           @param mano la mano que analizará
           @return lo mismo que los demas metodos check
         */
        Carta[] arregloMano = mano.getMano();
        auxiliarValor2=0;
        auxiliarValor3=0;
        auxiliarPalo = arregloMano[0].getPaloCarta();
        auxiliarValor = arregloMano[0].getValorNumerico();
        int contador=0;
        int contador2=0;
        int contador3=0;
        for(int i = 0; i<arregloMano.length; i++){
            if(arregloMano[i].getValorNumerico() != auxiliarValor){
                if(arregloMano[i].getValorNumerico() != auxiliarValor2 && auxiliarValor2!=0){
                    auxiliarPalo3 = arregloMano[i].getPaloCarta();
                    auxiliarValor3 = arregloMano[i].getValorNumerico();
                }else{
                    auxiliarValor2 = arregloMano[i].getValorNumerico();
                    auxiliarPalo2 = arregloMano[i].getPaloCarta();
                }
            }
        }

        for(int i = 0; i<arregloMano.length; i++){
            if(arregloMano[i].getValorNumerico()==auxiliarValor){
                contador++;
            }else if(arregloMano[i].getValorNumerico()==auxiliarValor2){
                contador2++;
            }else if(arregloMano[i].getValorNumerico()==auxiliarValor3){
                contador3++;
            }
        }

        if(contador == 3 || contador2 == 3 || contador3 == 3){
            if(contador == 3){
                stringManoGenerada = "Trio de " + auxiliarValor;
                return 3;
            }
            if(contador2 == 3){
                stringManoGenerada = "Trio de " + auxiliarValor2;
                return 3;
            }
            if (contador3 == 3) {
                stringManoGenerada = "Trio de " + auxiliarValor3;
                return 3;
            }
        }
        return 0;
    }

    public static int checkDoblePareja(Mano mano) {
        /**
           Verifica si la mano recibida es un Doble Par

           Para esto primero guarda tres valores distintos (la maxima cantidad posible de valores distintos
           en una mano Doble Par) y guarda la cantidad de coincidencias con estos valores. Luego retorna si existen
           dos contadores que hayan llegado a 2.

           @param mano la mano que analizará
           @return lo mismo que los demas metodos check
         */
        Carta[] arregloMano = mano.getMano();
        auxiliarValor2=0;
        auxiliarValor3=0;
        auxiliarPalo = arregloMano[0].getPaloCarta();
        auxiliarValor = arregloMano[0].getValorNumerico();
        int contador=0;
        int contador2=0;
        int contador3=0;
        for(int i = 0; i<arregloMano.length; i++){
            if(arregloMano[i].getValorNumerico() != auxiliarValor){
                if(arregloMano[i].getValorNumerico() != auxiliarValor2 && auxiliarValor2!=0){
                    auxiliarPalo3 = arregloMano[i].getPaloCarta();
                    auxiliarValor3 = arregloMano[i].getValorNumerico();
                }else{
                    auxiliarValor2 = arregloMano[i].getValorNumerico();
                    auxiliarPalo2 = arregloMano[i].getPaloCarta();
                }
            }
        }

        for(int i = 0; i<arregloMano.length; i++){
            if(arregloMano[i].getValorNumerico()==auxiliarValor){
                contador++;
            }else if(arregloMano[i].getValorNumerico()==auxiliarValor2){
                contador2++;
            }else if(arregloMano[i].getValorNumerico()==auxiliarValor3){
                contador3++;
            }
        }

        if(contador == 2){
            if(contador2 == 2){
                stringManoGenerada = "Doble par de " + auxiliarValor + " y " + auxiliarValor2;
                return 2;
            }
            if(contador3 == 2){
                stringManoGenerada = "Doble par de " + auxiliarValor + " y " + auxiliarValor3;
                return 2;
            }
        }
        if (contador2 == 2) {
            if (contador == 2) {
                stringManoGenerada = "Doble par de " + auxiliarValor2 + " y " + auxiliarValor;
                return 2;
            }
            if (contador3 == 2) {
                stringManoGenerada = "Doble par de " + auxiliarValor2 + " y " + auxiliarValor3;
                return 2;
            }
        }
        if (contador3 == 2) {
            if (contador2 == 2) {
                stringManoGenerada = "Doble par de " + auxiliarValor3 + " y " + auxiliarValor2;
                return 2;
            }
            if (contador == 2) {
                stringManoGenerada = "Doble par de " + auxiliarValor3 + " y " + auxiliarValor;
                return 2;
            }
        }
        return 0;
    }

    public static int checkPareja(Mano mano) {
        Carta[] arregloMano = mano.getMano();
        for(int i=0; i<arregloMano.length; i++){
            for(int j = i+1; j< arregloMano.length; j++){
                if(arregloMano[i].getValorNumerico()==arregloMano[j].getValorNumerico()){
                    stringManoGenerada = "Par de " + arregloMano[i].getValorNumerico();
                    return 1;
                }
            }
        }
        return 0;
    }
}
