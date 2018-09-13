package utiles;

public class Aleatorio {
    public static double doubleAleatorio(int min, int max){
        return Math.random() * (max-min) + min;
    }
    public static int intAleatorio(int min, int max){
        return (int) doubleAleatorio(min, max);
    }
    public static int mesAleatorio(){
        int mes[] = {1 , 2 , 12};
    	
        return mes[(int) (Math.random() * 3)];
    }
    public static char charAleatorio(){
        char a;
        if (Math.random() >= 0.5){
            // letras may√∫sculas
            a = (char) intAleatorio(97, 123);
        } else {
            // letras min√∫sculas
            a = (char) intAleatorio(65, 91);
        }
        return a;
    }
    public static String stringAleatorio(int tam){
        String res = "";
        for(int i = 0; i < tam; i++){
            res = res + charAleatorio();
        }
        return res;
    }
    
    public static String razaAleatorio(){
        // ejemplo para definir un valor aleatorio entre varias posibilidades
        // en este caso nombres
        String arr[] = {"Labrador", "Caniche", "Snauzer", "Terrier", "Callejero","Ovejero", "Beagle", "Rottweiler","DÛberman",
        				"Bulldog", "Golden Retriever", "Pastor Alem·n", "Yorhshire Terrier" };
        return arr[intAleatorio(0, arr.length - 1)];
    }
    public static String nombreAleatorio(){
        // ejemplo para definir un valor aleatorio entre varias posibilidades
        // en este caso nombres
        String arr[] = {"Jorge", "Sintia", "Franz", "Pedro", "Laucha", "Agustina", "Flor","Emmanuel","Diego"};
        return arr[intAleatorio(0, arr.length - 1)];
    }
    public static char genero(){
        // ejemplo para definir un valor aleatorio entre varias posibilidades
        
        char arr[] = {'H' , 'M'};
        char c;
        if(Math.random() >= 0.5)
        	c = arr[0];
        else
        	c = arr[1];
        return c;
    }
}
