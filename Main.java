import Analiza.*;

public class Main{

    public static void main(String[] args) {

        //Instanciar analizador sintactico ej. TreeSintact tree=new TreeSintact();
        Sintaxis sintax = new Sintaxis();
        AnalizaLex lex=new AnalizaLex();

        String oracion="they work tomorrow";
        //El pedo es si mete Does 
        String [] oracionArray = oracion.split(" ");

        String pronombres[]={"i","you","he","she","we","they","it"};
        String verbos[]={"eat","like","love","run","jump","work","walk","drink","take","dream","swim"};
        String conectores[]={"dont","do not","do"};

        String tipo=lex.gettipoOracion(oracion);
       // System.out.println(tipo);

        String respuesta=lex.valida(tipo,oracion,verbos,pronombres,conectores);
       // System.out.println(respuesta);
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
            System.out.println("Entro aqui");
        }
    }


}
