import Analiza.*;

public class Main{

    public static void main(String[] args) {

        //Instanciar analizador sintactico ej. TreeSintact tree=new TreeSintact();
        AnalizaLex lex=new AnalizaLex();


        String oracion="do you eat hamburguesa ?";

        String pronombres[]={"i","you","he","she","we","they","it"};
        String verbos[]={"eat","like","love","run","jump","work","walk","drink","take","dream","swim"};
        String conectores[]={"dont","do not","do"};

        String tipo=lex.gettipoOracion(oracion);
        System.out.println(tipo);

        String respuesta=lex.valida(tipo,oracion,verbos,pronombres,conectores);

        if(!respuesta.equals("Oracion Correcta")){
            System.out.println(respuesta);
        }else{
            String split[]=oracion.split(" ");
            String values[]=lex.getValues(tipo,split,conectores);
            System.out.println(values[0] + " -- " + values[2]);
            System.out.println("Entro aqui");
        }
    }


}
