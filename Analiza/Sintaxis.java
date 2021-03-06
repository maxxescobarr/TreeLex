/**
*@author Julio Cesar De Buen Hernandez 143460
*/

package Analiza;

public class Sintaxis{

	Nodo raiz;
	String recorrido = "";

	public Sintaxis(){

	}

	public void oracionAfirmativa(String oracion[]){
		raiz = null;
		Nodo pronombre = new Nodo(oracion[0]);
		Nodo verbo = new Nodo(oracion[1]);
		Nodo complemento = new Nodo(oracion[2]);
		if(raiz == null)
			raiz = pronombre;
		raiz.izq = verbo;
		raiz.der = complemento;
		preOrder(raiz);
		System.out.println(recorrido);
		System.out.println("");
		recorrido = "";
		dibujarArbol(raiz);
		//System.out.println(dibujo);
	}

	public void oracionNegativa(String oracion[]){
		raiz = null;
		Nodo pronombre = new Nodo(oracion[0]);
		Nodo verbo = new Nodo(oracion[1]);
		Nodo complemento = new Nodo(oracion[2]);
		Nodo conector = new Nodo(oracion[3]);
		if(raiz == null)
			raiz = pronombre;
		raiz.izq = conector;
		raiz.der = verbo;
		verbo.izq = complemento;
		//debug(raiz);
		preOrder(raiz);
		System.out.println(recorrido);
		System.out.println("");
		recorrido = "";
		dibujarArbol(raiz);

	}

	public void preguntaNegativa(String oracion[]){
		raiz = null;
		Nodo pronombre = new Nodo(oracion[0]);
		Nodo verbo = new Nodo(oracion[1]);
		Nodo complemento = new Nodo(oracion[2]);
		Nodo conector = new Nodo(oracion[3]);
		Nodo pregunta = new Nodo("?");
		if(raiz == null)
			raiz = conector;
		raiz.izq = pronombre;
		raiz.der = verbo;
		verbo.izq = complemento;
		verbo.der = pregunta;
		preOrder(raiz);
		//debug(raiz);
		System.out.println(recorrido);
		System.out.println("");
		recorrido = "";
		dibujarArbol(raiz);

	}

	public void pregunta(String oracion[]){
		raiz = null;
		Nodo pronombre = new Nodo(oracion[0]);
		Nodo verbo = new Nodo(oracion[1]);
		Nodo complemento = new Nodo(oracion[2]);
		Nodo conector = new Nodo(oracion[4]);
		Nodo pregunta = new Nodo("?");
		if(raiz == null)
			raiz = conector;
		raiz.izq = pronombre;
		raiz.der = verbo;
		verbo.izq = complemento;
		verbo.der = pregunta;
		preOrder(raiz);
		//debug(raiz);
		System.out.println(recorrido);
		System.out.println("");
		recorrido = "";
		dibujarArbol(raiz);
		
	}


	public void preOrder(Nodo recorrer) {
        if (recorrer != null) {
            //System.out.println(recorrer.datos);
            recorrido += " "+ recorrer.datos.toString();
            preOrder(recorrer.izq);
            preOrder(recorrer.der);
        }

    }

    public void debug(Nodo raiz){
        String parent="",left="",right="";

        if(raiz.datos!=null){
            parent =raiz.datos.toString();
        }
        if(raiz.izq !=null){
            left =raiz.izq.datos.toString();
        }
        if(raiz.der !=null){
            right =raiz.der.datos.toString();
        }
        System.out.println("Parent :"+parent+" Left:"+left+" Rigth:"+right);
        if(raiz.izq !=null){
            debug(raiz.izq);
        }
        if(raiz.der !=null){
            debug(raiz.der);
        }
    }
	String dibujo = " ";

	public void dibujarArbol(Nodo root){
		if (root != null) {
            //System.out.println(recorrer.datos);
            //dibujo = " "+ root.datos.toString();
			System.out.print(root.datos);
			if(root.izq != null){
				System.out.print("("+root.izq.datos+")");
			}
			if(root.der != null){
				System.out.print("("+root.der.datos+")");
			}
			System.out.println();
			dibujarArbol(root.izq);
            dibujarArbol(root.der);
        }
	}


	class Nodo{
		Nodo izq;
		Nodo der;
		Object conectorIzq;
		Object conectorDer;
		Object datos;
		boolean esRama;
		boolean esHoja;
		String oracion;

		public Nodo(Object oracion){
			this.datos = oracion;
			this.izq = null;
			this.der = null;
		}

	}
}
