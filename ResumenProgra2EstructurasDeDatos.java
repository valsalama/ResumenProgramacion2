package interfaces;
public class ColaEstatica {
	private int ultimo;
	private int primero;
	private int cantidad; //optativo
	//lo guardamos en un array por ahora
	private int[] cola = new int[];
	private static int TAM = 10;
	private int[] cola = new int[TAM];
	public void encolar(int dato) {
		if (cantidad < TAM){
		cola[ultimo]=dato;
		ultimo = ultimo+1;
		cantidad++;
		}
	}
	public int desencolar() { //recordar guardar el núm en el test
		if (cantidad>0) {
		primero = primero+1;
		cantidad--;
		return cola[primero-1];
		}
	}
public Cola(){
	super();
	this.ultimo=0; //es donde tiene que ir el último elemento
	this.primero=0;
	this.cantidad=0;
	}
}
public class ColaPrioridadEstatico {
	private int primero;
	private int ultimo;
	private int cantidad; 
	private int arregloCola[] = new int[5]; ///Array tam FIJO (ESTATICO)
	private int arregloPrioridades[] = new int[5];
	public void encolar(int dato, int prioridad) {
		if (cantidad < 5){ 		
		int i  = cantidad -1; 
		while (  i>=0 &&    arregloPrioridades[i]<prioridad) {
			arregloCola[i+1] = arregloCola[i];
			arregloPrioridades[i+1] = arregloPrioridades[i];
			i = i -1;
		}
		arregloCola[i+1] = dato; 
		arregloPrioridades[i+1] = prioridad; 
		cantidad = cantidad +1; 
		ultimo = ultimo + 1;
		}
	}
	public int desencolar() {
		if ( canti > 0) {
		int elemento = arregloCola[primero];
		primero++;
		cantidad--;	
		return elemento; }
	}
public class ColaDinamica {
	private Nodo primero;
	private Nodo ultimo; 
	private int cantidad; //array no va más
	public void encolar(int dato) {
		Nodo nuevoNodo = new Nodo(dato);
		if(primero != null) { 
				ultimo.siguiente = nuevoNodo; //Encapsulamiente
				ultimo.setSiguiente(nuevoNodo);
				setUltimo(nuevoNodo); 
		}else { 
			primero = nuevoNodo;
		}
		ultimo = nuevoNodo;
		cantidad = cantidad +1;
	}	
public Nodo desencolar() {		
		if(cantidad>0) {
			Nodo  elementoDesencolado  = primero; 
			Nodo  elementoDesencolado = new Nodo(primero.getDato()); 
			primero = primero.getSiguiente();
			cantidad = cantidad -1; 
			elementoDesencolado.setSiguiente(null);
			return elementoDesencolado;
		}else {
			System.out.println("Error no hay elementos");
			return null;
		}
}
public class Pila implements IPila {
	 private static final int MAX_SIZE = 100;
	 private int[] elementos;
	 private int tope;
	 public Pila() {
	     inicializarPila();
	 }
	 public void inicializarPila() {
	     elementos = new int[MAX_SIZE];
	     tope = -1;
	 }
	 public void apilar(int x) {
	     if (!pilaLlena()) {
	         elementos[++tope] = x;
	     } else {
	         throw new RuntimeException("La pila está llena");
	     }
	 }
	 public int desapilar() {
	     if (!pilaVacia()) {
	         return elementos[tope--];
	     } else {
	         throw new RuntimeException("La pila está vacía");
	     }
	 }
	 public boolean pilaVacia() {
	     return tope == -1;
	 }
	 public boolean pilaLlena() {
	     return tope == MAX_SIZE - 1;
	 }
	 public int tope() {
	     if (!pilaVacia()) {
	         return elementos[tope];
	     } else {
	         throw new RuntimeException("La pila está vacía");
	     }
	 }
	 public int tamanio() {
	     return tope + 1;
	 }
	}
public class PilaDinamica implements IPila {
    private static class Nodo {
        int valor;
        Nodo siguiente;
        Nodo(int valor) {
            this.valor = valor;
        }
    }
    private Nodo tope;
    private int tamaño;
    public PilaDinamica() {
        tope = null;
        tamaño = 0;
    }
    public void apilar(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = tope;
        tope = nuevo;
        tamaño++;
    }
    public int desapilar() {
        if (estaVacia()) throw new RuntimeException("Pila vacía");
        int valor = tope.valor;
        tope = tope.siguiente;
        tamaño--;
        return valor;
    }
    public boolean estaVacia() {
        return tope == null;
    }
    public int tamaño() {
        return tamaño;
    }
}
public class ListaEstatica implements ILista {
    private int[] datos;
    private int tamaño;
    private static final int CAPACIDAD_INICIAL = 1000000;
    public ListaEstatica() {
        datos = new int[CAPACIDAD_INICIAL];
        tamaño = 0;
    }
    public void insertarInicio(int valor) {
        if (tamaño == datos.length) throw new RuntimeException("Lista llena");
        for (int i = tamaño; i > 0; i--) {
            datos[i] = datos[i - 1];
        }
        datos[0] = valor;
        tamaño++;
    }
    public void insertarFin(int valor) {
        if (tamaño == datos.length) throw new RuntimeException("Lista llena");
        datos[tamaño] = valor;
        tamaño++;
    }
    public boolean eliminar(int valor) {
        for (int i = 0; i < tamaño; i++) {
            if (datos[i] == valor) {
                for (int j = i; j < tamaño - 1; j++) {
                    datos[j] = datos[j + 1];
                }
                tamaño--;
                return true;
            }
        }
        return false;
    };
public int eliminarPrimero() {
			if ( !estaVacia()) {
			int datoQueVoyAPerder = primero.getDato();
			primero = primero.getSiguiente();
};
			return datoQueVoyAPerder;
    public boolean contiene(int valor) {
        for (int i = 0; i < tamaño; i++) {
            if (datos[i] == valor) return true;
        }
        return false;
    }
    public int obtener(int indice) {
        if (indice < 0 || indice >= tamaño) throw new IndexOutOfBoundsException();
        return datos[indice];
    }
    public int tamaño() {
        return tamaño;
    }
    public void imprimir() {
        for (int i = 0; i < tamaño; i++) {
            System.out.print(datos[i] + " ");
        }
        System.out.println();
    }
}
public class Lista<T>  implements ILista<T> {
	 private INodo<T> primero;
	 public Lista() {
	    this.primero = null;
	    }
	    @Override
	    public void insertar(INodo<T> nodo) {
	        if (esVacia()) {
	            primero = nodo;
	        } else {
	            INodo<T> actual = primero;
	            while (actual.getSiguiente() != null) {
	                actual = actual.getSiguiente();
	            }
	            actual.setSiguiente(nodo);
	            nodo.setAnterior(actual);
	        }
	    }
		public void insertarPrimero(int d) {
			///L-> 23 ->  42  ->  11 ->NUll     (2)
			Nodo nuevoNodo = new Nodo(d);//(2, null)
			if(!estaVacia()) { //NOT es !
				///L--------->  
				/// (2) ->   23 ->  42  ->  11 ->NUll   
				nuevoNodo.setSiguiente(primero);  
				primero = nuevoNodo;
			}else { //Lista vacia
				primero = nuevoNodo;
			}	
		};
		public void insertarUltimo(int d) {
			///L-> 23 ->  42  ->  11 ->NUll     (2)
			Nodo nuevoNodo = new Nodo(d); //resreve memoria
			if(!estaVacia()) {
				INodo actual = primero;
				while (actual.getSiguiente()!=null) {
					actual = actual.getSiguiente();
				}
				actual.setSiguiente(nuevoNodo);
			}else {
				primero = nuevoNodo;
			}
		};
	    @Override
	    public boolean eliminar(T dato) {
	        if (esVacia()) {
	            return false;
	        }
	        INodo<T> actual = primero;
	        while (actual != null) {
	            if (actual.getDato().equals(dato)) {
	                if (actual.getAnterior() != null) {
	                    actual.getAnterior().setSiguiente(actual.getSiguiente());
	                } else {
	                    primero = actual.getSiguiente();
	                }
	                if (actual.getSiguiente() != null) {
	                    actual.getSiguiente().setAnterior(actual.getAnterior());
	                }
	                return true;
	            }
	            actual = actual.getSiguiente();
	        }
	        return false;
	    }
	    @Override
	    public INodo<T> buscar(T dato) {
	        INodo<T> actual = primero;
	        while (actual != null) {
	            if (actual.getDato().equals(dato)) {
	                return actual;
	            }
	            actual = actual.getSiguiente();
	        }
	        return null;
	    }
	    @Override
	    public void imprimir() {
	        INodo<T> actual = primero;
	        while (actual != null) {
	            System.out.print(actual.getDato() + " <-> ");
	            actual = actual.getSiguiente();
	        }
	        System.out.println("null");
	    }
	    @Override
	    public boolean esVacia() {
	        return primero == null;
	    }
	    @Override
	    public int tamanio() {
	        int contador = 0;
	        INodo<T> actual = primero;
	        while (actual != null) {
	            contador++;
	            actual = actual.getSiguiente();
	        }
	        return contador;
	    }
}
public class ListObject {
	///Lista super resumida, para explicar el máximo nivel de 
	///abstracción que se puede conseguir en java
	///Se animan a pasarlo a TDA? 
	private Node primero;
    private static class Node {
        Object dato;
        Node siguiente;
        Node(Object dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    public ListObject() {
        this.primero = null;
    }
    public void insertar(Object dato) {
        Node nuevo = new Node(dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            Node actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }
    public void imprimir() {
        Node actual = primero;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}
//NODOS ARBOLES
//package modelo;
//import interfaces.INodo;
public class Nodo implements INodo {
    private int dato; //Persona ---> T ----> Objets
    private INodo izquierdo;
    private INodo derecho;
    public Nodo(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
    @Override
    public int getDato() {
        return dato;
    }
    @Override
    public void setDato(int dato) {
        this.dato = dato;
    }
    @Override
    public INodo getIzquierdo() {
        return izquierdo;
    }
    @Override
    public void setIzquierdo(INodo izquierdo) {
        this.izquierdo = izquierdo;
    }
    @Override
    public INodo getDerecho() {
        return derecho;
    }
    @Override
    public void setDerecho(INodo derecho) {
        this.derecho = derecho;
    }
}
//MODEL ARBOLES
public class Arbol implements IArbol {
    private INodo raiz;
    public Arbol() {
        this.raiz = null;
    }
    @Override
    public void insertar(int dato) {
        raiz = insertarRec(raiz, dato);
    }
    private INodo insertarRec(INodo nodoRaiz, int dato) {
        if (nodoRaiz == null) {
            return new Nodo(dato);
        }
        if (dato < nodoRaiz.getDato()) { 
            nodoRaiz.setIzquierdo(insertarRec(nodoRaiz.getIzquierdo(), dato));
            
        } else if (dato > nodoRaiz.getDato()) {
            nodoRaiz.setDerecho(insertarRec(nodoRaiz.getDerecho(), dato));
        }
        return nodoRaiz;
    }
    @Override
    public INodo buscar(int dato) {
        return buscarRec(raiz, dato);
    }
    private INodo buscarRec(INodo nodo, int dato) {
        if (nodo == null || nodo.getDato() == dato) { //|| OR
            return nodo;
        }
        if (dato < nodo.getDato()) {
            return buscarRec(nodo.getIzquierdo(), dato);
        } else {
            return buscarRec(nodo.getDerecho(), dato);
        }
    }
    @Override
    public void recorridoInorden() {
        inordenRec(raiz);
    }
    private void inordenRec(INodo nodo) {
        if (nodo != null) {
            inordenRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + " ");
            inordenRec(nodo.getDerecho());
        }
    }
    @Override
    public void recorridoPreorden() {
        preordenRec(raiz);
    }
    private void preordenRec(INodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " "); //visitar la raiz
            preordenRec(nodo.getIzquierdo()); // recorrer Izq
            preordenRec(nodo.getDerecho());
        }
    }
    @Override
    public void recorridoPostorden() {
        postordenRec(raiz);
    }
    private void postordenRec(INodo nodo) {
        if (nodo != null) {
            postordenRec(nodo.getIzquierdo());
            postordenRec(nodo.getDerecho());
            System.out.print(nodo.getDato() + " ");
        }
    }
    @Override
    public void recorridoInordenSinRecursion() {
        Stack<INodo> pila = new Stack<>();
        INodo actual = raiz;
        while (actual != null || !pila.isEmpty()) {
            while (actual != null) {
                pila.push(actual);
                actual = actual.getIzquierdo();
            }
            actual = pila.pop();
            System.out.print(actual.getDato() + " ");
            actual = actual.getDerecho();
        }
    }
    public void insertarIterativo(int dato) {
        if (raiz == null) {
            raiz = new Nodo(dato);
            return;
        }
        INodo actual = raiz;
        INodo padre = null;
        while (actual != null) {
            padre = actual;
            if (dato < actual.getDato()) {
                actual = actual.getIzquierdo();
            } else if (dato > actual.getDato()) {
                actual = actual.getDerecho();
            } else {
                // El dato ya existe, no se inserta duplicado
                return;
            }  
            }
        // Ya tenemos el nodo padre al que se le debe colgar el nuevo nodo
        if (dato < padre.getDato()) {
            padre.setIzquierdo(new Nodo(dato));
        } else {
            padre.setDerecho(new Nodo(dato));
        }
    }
    public void eliminar(int dato) {
        raiz = eliminarRec(raiz, dato);
    }
    private INodo eliminarRec(INodo nodo, int dato) {
        if (nodo == null) return null;
        if (dato < nodo.getDato()) {
            nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), dato));
        } else if (dato > nodo.getDato()) {
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), dato));
        } else {
            // Caso 1: nodo sin hijos
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                return null;
            }
            // Caso 2: un solo hijo
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            }
            if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }
            // Caso 3: dos hijos
            INodo sucesor = encontrarMinimo(nodo.getDerecho());
            nodo.setDato(sucesor.getDato());
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), sucesor.getDato()));
        }
        return nodo;
    }
    private INodo encontrarMinimo(INodo nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo; //clavijo
    }   
}
