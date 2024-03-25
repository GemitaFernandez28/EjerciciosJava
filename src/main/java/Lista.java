import java.util.Scanner;

/**
 * Representacion de una lista, la cual tieen varias funcionalidades.
 * Una lista con una cierta capacidad, el cual registra la cantidad de espacios usados.
 *
 * @author Gemi
 */
public class Lista {
    /**
     * El arreglo que contiene la informacion de la clase.
     */
    private int[] lista;
    /**
     * La cantidad de espacios usados en lista.
     */
    private int tamano;

    /**
     * Constructor el cual recibe la capacidad de la clase.
     *
     * @param l int, la capcidad de la lista. El tamaño maximo del arreglo
     */
    public Lista(int l) {
        this.lista = new int[l];
        tamano = 0;
    }// FIN del CONSTRUCTOR

    /**
     * Agrega valores a la lista. Entrega un mensaje en caso que el tamaño supere la capacidad de la lista.
     *
     * @param v int, valor a ingresar al arreglo.
     */
    public void agregaValores(int v) {
        if (tamano < lista.length) {
            lista[tamano] = v;
            tamano++;
        } else {
            System.out.println("Por favor no envie mas numeros");
        }
    }

    /**
     * Entrega valor guardado en lista correspondiente al indice parametro.
     *
     * @param i int, indice del valor a entregar.
     * @return valor correspondiente al indice entregado
     */
    public int get(int i) {
        return lista[i];
    }

    /**
     * Verifica si lista puede recibir mas valores.
     *
     * @return boolean, true si el largo de lista es estrictamente mayor que el tamaño actual, false en caso contrario
     */
    public boolean hayEspacio() {
        return lista.length > tamano;
    }

    /**
     * El tamaño actual de la lista. Getter de tamano.
     *
     * @return tamano int, variable privada tamano
     */
    public int getTamano() {
        return tamano;
    }

    /**
     * Entrega la capcacidad maxmima de la lista.
     *
     * @return capacidad maxima de la lista
     */
    public int getCapacidad() {
        return lista.length;
    }

    /**
     * Verifica si valor existe dentro de la lista.
     *
     * @param valor int, valor a probar si es contenido en lista.
     * @return boolean, true si valor pertenece a lista, false en caso que no.
     */
    public boolean contiene(int valor) {
        return indiceDe(valor) != -1;
    }


    /**
     * Encuentra y regresa el indice correspondiente al valor entregado como argumento.
     * De no encontrar un indice, se regresa -1.
     *
     * @param valor int, valor el cual se busca el indice correspondiente
     * @return indice correspondiente al valor, si valor no esta presente entrega -1
     */
    public int indiceDe(int valor) {
        int indice = -1;
        for (int j = 0; j < tamano; j++) {

            if (lista[j] == valor) {
                indice = j;
                break;
            }
        }
        return indice;
    }


    /**
     * Ordena los valores de la lista en un orden especificado.
     *
     * @param orden int, indica orden del ordenamiento, 0 es de menor a amayor, otro valor sera mayor a menor
     */
    public void ordena(int orden) {
        switch (orden) {
            default:
            case 1: // mayor a menor
                for (int i = 0; i < tamano; i++) {
                    for (int j = 0; j < tamano; j++) {
                        if (lista[i] >= lista[j] && i < j) {
                            int aux;
                            aux = lista[i];
                            lista[i] = lista[j];
                            lista[j] = aux;
                        }
                    }
                }
                break;
            case 0: // menor a mayor
                for (int i = 0; i < tamano; i++) {
                    for (int j = 0; j < tamano; j++) {
                        if (lista[i] >= lista[j]) {
                            int aux;
                            aux = lista[i];
                            lista[i] = lista[j];
                            lista[j] = aux;
                        }
                    }
                }
                break;
        }
    }

    /**
     * Remueve un espacio de la lista.
     * Los valores se corren un espacio a la izquierda.
     * Modifica el tamaño actual, mantiene la capacidad intacta.
     *
     * @param indice int, indice del espacio a remover
     */
    public void remueve(int indice) {
        for (int i = indice; i < tamano - 1; i++) {
            lista[i] = lista[i + 1];
        }
        tamano = tamano - 1;
    }

    /**
     * Remueve el valor entregado si se encuentra en la lista.
     * Regresa un booelano si se efectuo la removicion.
     *
     * @param valor int, valor a remover de la lista
     * @return boolean, true si el valor se encuentra en la lista, false si on esncuentra
     */
    public boolean remueveSi(int valor) {
        int indice = indiceDe(valor);
        if (indice == -1) {
            return false;
        } else {
            remueve(indice);
            return true;
        }
    }

    /**
     * Verifica si una lista provista posee mismos valores que la lista actual.
     * Verifica si ambas listas tienen mismo tamaño.
     *
     * @param lista2 Lista, instancia de Lista con la cual se compararan los valores
     * @return boolean, true si ambas listas poseen iguales valores, false si no.
     */
    public boolean igual(Lista lista2) {
        if (tamano == lista2.getTamano()) {
            return false;
        } else {
            int[] lista1 = this.lista;
            boolean bandera = true;
            for (int i = 0; i < tamano; i++) {
                if (lista1[i] != lista2.get(i)) {
                    bandera = false;
                    break;
                }

            }
            return bandera;
        }
    }

    /**
     * Regresa una representacion String de la lista.
     *
     * @return una representacion String de la lista.
     */
    @Override
    public String toString() {
        String cadena = " ";
        for (int i = 0; i < tamano; i++) {
            cadena += lista[i] + " , ";
        }
        return cadena;
    }
}