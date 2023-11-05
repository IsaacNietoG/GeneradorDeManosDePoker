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
    public static void main(String[] args){
        System.out.println("Bienvenido al generador de manos de Poker.");
        System.out.println("Se generará una mano de cartas de Poker aleatorizada y se te dirá si recibiste alguna mano buena.");

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
    }

    public static int checkEscaleraReal(Mano mano){
        
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
