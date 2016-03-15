import Analiza.*;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        //Instanciar analizador sintactico ej. TreeSintact tree=new TreeSintact();
        Sintaxis sintax = new Sintaxis();
        AnalizaLex lex=new AnalizaLex();
        Scanner sc=new Scanner(System.in);

        System.out.println("Introduzca la oracion");
        String palabra=sc.nextLine();

        String oracion=palabra.toLowerCase();
        //El pedo es si mete Does
        String [] oracionArray = oracion.split(" ");
        System.out.println("La oracion es : "+oracionArray[0] + oracionArray[1]+oracionArray[2]);

        String pronombres[]={"i","you","he","she","we","they","it"};
        String verbos[]={"eat","like","love","run","jump","work","walk","drink","take","dream","swim","want","do"};
        String conectores[]={"dont","do not","do","does not","doesn't","does","don't"};

        String tipo=lex.gettipoOracion(oracion);
        System.out.println(tipo);
       // System.out.println(tipo);

        String respuesta=lex.valida(tipo,oracion,verbos,pronombres,conectores);

        if(respuesta.equals("Oracion Correcta")){
            //System.out.println("correcto "+respuesta);
            String val[] = lex.getValues(tipo,oracionArray,conectores);
            System.out.println("Oracion Afirmativa");
            sintax.oracionAfirmativa(val);
            System.out.println("Oracion Negativa");
            sintax.oracionNegativa(val);
            System.out.println("Pregunta Negativa");
            sintax.preguntaNegativa(val);
            System.out.println("Pregunta");
            sintax.pregunta(val);
        }else{
            String split[]=oracion.split(" ");
            String values[]=lex.getValues(tipo,split,conectores);
            System.out.println(values[0] + " -- " + values[2]);
            System.out.println(respuesta);
        }
    }


}
