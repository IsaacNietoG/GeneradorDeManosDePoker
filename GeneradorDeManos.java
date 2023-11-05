/**
   TO-DO LIST

   Dentro de la clase Juego:
   - Crear el main. El cual generará una mano (con su constructor) y va a iterar sobre ella para verificar si
   entra dentro de alguna de las manos esperadas. Aplicará un metodo para cada mano posible y retornará un
   display de la mano generada junto con el respectivo mensaje dependiendo de qué tipo de mano es la mano generada.
   - Crear los metodos para verificar manos. Estos serán metodos que iterarán sobre cada carta del arreglo para
   verificar si se crean las condiciones esperadas dentro del mismo para retornar que efectivamente la mano es de ese tipo
   - Crear el metodo checkEscaleraReal
   - Crear el metodo checkEscaleraColor
   - Crear el metodo checkPocker
   - Crear el metodo checkFull
   - Crear el metodo checkColor
   - Crear el metodo checkEscalera
   - Crear el metodo checkTrio
   - Crear el metodo checkDoblePareja
   - Crear el metodo checkPareja
 */
public class GeneradorDeManos {
    public static String stringManoGenerada = "";
    public static void main(String[] args){
        System.out.println("Bienvenido al generador de manos de Poker.");
        System.out.println("Se generará una mano de cartas de Poker aleatorizada y se te dirá si recibiste alguna mano buena.");

        int debug =100;
        do{
        Mano manoGenerada = new Mano();
        int manoEncontrada=0;
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

        debug--;
        }while(debug !=0);

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
        return 1;
    }

    public static int checkEscaleraColor(Mano mano){
        
    }

    public static int checkPoker(Mano mano) {

    }

    public static int checkFull(Mano mano) {

    }

    public static int checkColor(Mano mano) {

    }

    public static int checkEscalera(Mano mano) {

    }

    public static int checkTrio(Mano mano) {

    }

    public static int checkDoblePareja(Mano mano) {

    }

    public static int checkPareja(Mano mano) {

    }
}
