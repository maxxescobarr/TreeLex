/**
*@author Carlos Maximiliano Ortiz Escobar 143406 (Equipo 2)
*/

package Analiza;

public class AnalizaLex{

  public String[] getValues(String tipoOracion,String[] sentence, String connector[]){

    String[] values= new String[sentence.length+2];
    switch(tipoOracion){
      case "afirmative":
        values[0]=sentence[0];//pronombre
        values[1]=sentence[1];//verbo
        values [2]="";//complemento
        for (int i =2;i<sentence.length ;i++ ) {
            values[2]+=sentence[i]+" ";
        }
        if(sentence[0].equals("he")||sentence[0].equals("she")||sentence[0].equals("it")){
            values[3]="doesn't";
            values[4]="does";
        }else{
            values[3]=connector[0];
            values [4]=connector[2];
        };
        break;
      case "negative":
        if(sentence[0].equals("he")||sentence[0].equals("she")||sentence[0].equals("it")){
            System.out.println();
            values[3]="doesn't";
            values[4]="does";
        }else{
            values[3]=connector[0];
            values [4]=connector[2];
        }
        values[0]=sentence[0];
        values[1]=sentence[2];
        values [2]="";//complemento
        for (int i =3;i<sentence.length ;i++ ) {
            values[2]+=sentence[i]+" ";
        }
        break;
      case "negative interrogative":
        values[0]=sentence[1];
        values[1]=sentence[2];
        values [2]="";//complemento
        for (int i =3;i<sentence.length -1;i++ ) {
            values[2]+=sentence[i]+" ";
        }
        if(sentence[0].equals("he")||sentence[0].equals("she")||sentence[0].equals("it")){
            values[3]="doesn't";
            values[4]="does";
        }else{
            values[3]=connector[0];
            values [4]=connector[2];
        }
        break;
      case "question":
        values[0]=sentence[1];
        values[1]=sentence[2];
        values [2]="";//complemento
        for (int i =3;i<sentence.length - 1 ;i++ ) {
            values[2]+=sentence[i]+" ";
        }
        if(sentence[0].equals("he")||sentence[0].equals("she")||sentence[0].equals("it")){
            values[3]="doesn't";
            values[4]="does";
        }else{
            values[3]=connector[0];
            values [4]=connector[2];
        }
        break;
        }
        return values;
    }

    public String gettipoOracion(String oracion){

        String tipo="";
        int i,j;

        if((oracion.contains("don't") || oracion.contains("dont")) && oracion.contains("?")){
            tipo="negative interrogative";
        }else{
            if((oracion.contains("don't") || oracion.contains("dont")) && !oracion.contains("?")){
                tipo="negative";
            }else{
                if(oracion.contains("do") && oracion.contains("?")){
                    tipo="question";
                }else{
                    tipo="afirmative";
                }
            }
        }

        return tipo;
    }

    public String valida(String tipo, String oracion, String verbo[], String[] pronombres, String[] conectores){

        String resultado="";
        boolean containverb=false,containpronombre=false,containconector=false,question=false;
        String verb="",pronombre="",conector="";
        String oracionP[] = oracion.split(" ");
        switch(tipo){
            case "afirmative":
                for(int i=0;i<oracionP.length;i++){
                    for(int j=0;j<pronombres.length;j++){
                        if(oracionP[i].equals(pronombres[j])){
                            containpronombre=true;
                            pronombre=pronombres[j];
                        }
                    }
                    for(int j=0;j<verbo.length;j++){
                        if(oracionP[i].equals(verbo[j])){
                            containverb=true;
                            verb=verbo[j];
                        }
                    }
                }

               // System.out.println("----------------------------------------------\n");
                //System.out.println("Pronombre: "+pronombre+" Verbo: "+verb);
                //System.out.println(oracionP[0] + " " + oracionP[1]);

                if(containpronombre && containverb){
                    if(pronombre.equals(oracionP[0])&&verb.equals(oracionP[1])){
                        resultado="Oracion Correcta";
                    }else{
                        resultado="Oracion en orden incorrecto";
                    }
                }else{
                    resultado="La oracion esta incorrecta";
                }
                break;

            case "negative":

                for(int i=0;i<oracionP.length;i++){
                    for(int j=0;j<pronombres.length;j++){
                        if(oracionP[i].equals(pronombres[j])){
                            containpronombre=true;
                            pronombre=pronombres[j];
                        }
                    }
                    for(int j=0;j<verbo.length;j++){
                        if(oracionP[i].equals(verbo[j])){
                            containverb=true;
                            verb=verbo[j];
                        }
                    }
                    for(int j=0;j<conectores.length;j++){
                        if(oracionP[i].equals(conectores[j])){
                            containconector=true;
                            conector=conectores[j];
                        }
                    }
                }
            //    System.out.println("----------------------------------------------\n");
              //  System.out.println("Pronombre: "+pronombre+" Verbo: "+verb + " Conector : " + conector);
                //System.out.println(oracionP[0] + " " + oracionP[1])
                System.out.println(containconector+":"+containpronombre+":"+containconector);
                if(containconector && containpronombre && containverb){
                     if(oracionP[0].equals(pronombre) && oracionP[1].equals(conector) && oracionP[2].equals(verb)){
                         resultado="Oracion Correcta";
                 }else{
                     resultado="La sentencia no esta en el orden correcto";
                    }
                 }else{
                 resultado="la sentencia esta incompleta";
                 }
                 break;

            case "negative interrogative":
                for(int i=0;i<oracionP.length;i++){
                    for(int j=0;j<pronombres.length;j++){
                        if(oracionP[i].equals(pronombres[j])){
                            containpronombre=true;
                            pronombre=pronombres[j];
                        }
                    }
                    for(int j=0;j<verbo.length;j++){
                        if(oracionP[i].equals(verbo[j])){
                            containverb=true;
                            verb=verbo[j];
                        }
                    }
                    for(int j=0;j<conectores.length;j++){
                        if(oracionP[i].equals(conectores[j])){
                            containconector=true;
                            conector=conectores[j];
                        }
                    }
                }

        //        System.out.println("----------------------------------------------\n");
          //      System.out.println("Pronombre: "+pronombre+" Verbo: "+verb + " Conector : " + conector);
            //    System.out.println(oracionP[0] + " " + oracionP[1]);
                 if(containconector && containpronombre && containverb){
                     if(oracionP[0].equals(conector) && oracionP[1].equals(pronombre) && oracionP[2].equals(verb)){
                         resultado="Oracion Correcta";
                     }else{
                         resultado="La sentencia no esta en el orden correcto";
                     }
                 }else{
                     resultado="la sentencia esta incompleta";
                 }
                 break;

            case "question":

                if(oracion.contains("?")){
                    question=true;
                }

                for(int i=0;i<oracionP.length;i++){
                    for(int j=0;j<pronombres.length;j++){
                        if(oracionP[i].contains(pronombres[j])){
                            containpronombre=true;
                            pronombre=pronombres[j];
                        }
                    }
                    for(int j=0;j<verbo.length;j++){
                        if(oracionP[i].equals(verbo[j])){
                            containverb=true;
                            verb=verbo[j];
                        }
                    }
                    for(int j=0;j<conectores.length;j++){
                        if(oracionP[i].equals(conectores[j])){
                            containconector=true;
                            conector=conectores[j];
                        }
                    }
                }

                if(containconector && containpronombre && containverb && question){
                    if(oracionP[0].equals(conector) && oracionP[1].equals(pronombre) && oracionP[2].equals(verb)){
                        resultado="Oracion Correcta";
                    }else{
                        resultado="La sentencia no esta en el orden correcto";
                    }
                }else resultado="La sentencia esta incompleta";

                break;
        }
        return resultado;
    }
}
