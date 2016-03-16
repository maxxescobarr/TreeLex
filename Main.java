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
        String pronombres[]={"i","you","he","she","we","they","it"};
        String verbos[]={"eat","like","love","run","jump","work","walk","drink","take","dream","swim","want","do","play"};
        String conectores[]={"dont","do not","do","does not","doesn't","does","don't"};

        String tipo=lex.gettipoOracion(oracion);
        System.out.println("\n\n");
        System.out.println("-------------------------------------------------");
        System.out.println("El tipo de oracion introducida es : "+tipo+"\n");
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");
       // System.out.println(tipo);

        String respuesta=lex.valida(tipo,oracion,verbos,pronombres,conectores);

        if(respuesta.equals("Oracion Correcta")){
            //System.out.println("correcto "+respuesta);
            String val[] = lex.getValues(tipo,oracionArray,conectores);
            System.out.println("\n---->Oracion Afirmativa<----");
            sintax.oracionAfirmativa(val);
            System.out.println("\n---->Oracion Negativa<----");
            sintax.oracionNegativa(val);
            System.out.println("\n---->Pregunta Negativa<----");
            sintax.preguntaNegativa(val);
            System.out.println("\n---->Pregunta<----");
            sintax.pregunta(val);
        }else{
            String split[]=oracion.split(" ");
            String values[]=lex.getValues(tipo,split,conectores);
            System.out.println(respuesta);
        }
    }


}
