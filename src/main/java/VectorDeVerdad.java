/**
 * Descripcion de la clase: VectorDeVerdad, es la clase que representan los vectores de una dimension
 * donde se debe entregar la dimension y las coordenadas, que tiene como metodos una amplia gama
 * de operaciones con estos vectores.
 * Esta clase trabaja en conjunto con otra clase llamada MatrizDeVerdad.
 * @author GemitaFernandez28
 */

public class VectorDeVerdad {
    private int dimension; //esta es la dimesion del vector
    private float[] coordenadas; //estas son los valores del vector



    /**
     * Esto es el Primer CONSTRUCOR
     * Que tiene como mision inicializar la dimesion y las coordendas
     * las coordenandas no se pueden escribir asi como asi, lo crea como un objeto de vector inicializado con
     * puros ceros.
     * @param dimension int, representa literalmente la dimension del vector, asi como en fisica.
     */
    public VectorDeVerdad(int dimension){
        this.dimension=dimension;
        this.coordenadas=new float[dimension];
    }
     //----------------------------------------------------------------------------------------------------
    /**
     * Este es el segundo CONSTRUCTOR
     * Este constructor recibe un array ya hecho (que se escribirá en el run)
     * El array se inyectan los valores del array  como los valores iniciales del vector
     * de la clase VectorDeVerdad.
     * @param coordenadas son el array ya listo para pasarselo al vector de la clase.
     */


    public VectorDeVerdad(float[] coordenadas){
        //hay que instanciar coordenadas y pasarles los valores.
        this.dimension= coordenadas.length;
        this.coordenadas=new float[coordenadas.length];
        //Ahora pasarlo a los valores.
        for (int i=0; i<dimension; i++) {
            this.coordenadas[i] = coordenadas[i];

        }
    }//FIN DE CONSTRUCOR

    //METODOS------------------------------------------------------------------------------------------


    public int getDimension(){
        return dimension;
    }

    /**
     *Es un getter
     * @param i a partir del indicice del vector que yo quiera
     * @return que me regresa la coordenada correspondiente al indice.
     */
    public float getCoordenadas(int i){
    return coordenadas[i];
    }

    /**
     * Sumar es un metodo que me sirve para sumar un vector  intanciado con otro vector ya instanciado.
     * @param otroVector de tipo VectorDeVerdad, es el vector con el cual se suma.
     */


    public void sumar(VectorDeVerdad otroVector){
        if(this.dimension==otroVector.getDimension()){
            for (int i=0; i<dimension;i++){
                this.coordenadas[i]=this.coordenadas[i]+otroVector.getCoordenadas(i);
            }
        }
    }

    /**
     * Lo mismo que la suma de arriba pero ahora con resta!!!!!
     * @param otroVector
     */
    public void restar(VectorDeVerdad otroVector){
        if (this.dimension==otroVector.getDimension()){
            for (int i=0; i<dimension;i++){
                this.coordenadas[i]=this.coordenadas[i]-otroVector.getCoordenadas(i);
            }
        }
    }


    /**
     * Realiza producto inteno(asi como en cienciasFisicas) de un vector con otro.
     * @param otroVector de tipo VectorDeVerdad, es con el que se hara el producto
     * @return el resultado numerico del producto interno de dos vectores.
     * y retorna -1 cuando no se cumple la condicion del if (que los vectores debem tener la misma dimension)
     */

    public float productorInterno(VectorDeVerdad otroVector){
        if(this.dimension==otroVector.getDimension()){
            float suma=0; float producto=1;
            for (int i=0; i <dimension;i++){
                producto=this.coordenadas[i]*otroVector.getCoordenadas(i);
                suma +=producto;

            }return suma;

        }return -1;

    }


    /**
     * Es una representacion como string del vector
     * @return, retorna la cadena en cuestion.
     */

    @Override
    public String toString(){
        String cadena="";
        for (int i=0; i<dimension;i++){
            cadena+=coordenadas[i]+ "    \n";
        }return cadena;
    }

    /**
     * Cambia los valores del vector.
     * @param i es la posicion a la que quiero meterle valores
     * @param n es el valor que quiero introducir.
     */


    public void cambiaValor(int i,int n){
        // i es indice del array
        //n es el valor a colocar
        this.coordenadas[i]=n;
    }
    // METODO MIXTO CON LA CLASE MatrizDeVerdad.

    /**
     * Multiplica dos vectores de la misma clase.
     * calcula el resultado de mulipicar un vector vertical con uno horizontal, formando una matriz.
     * @param otroVector, vector ya listo e instanciado.
     * @return de tipo: MatrizDeVerdad, retorna la matriz resultante.
     */


    public MatrizDeVerdad multiplicaVectores(VectorDeVerdad otroVector){
        MatrizDeVerdad matriz=new MatrizDeVerdad(dimension,dimension);
            for(int i=0; i<dimension;i++){
                for(int j=0; j<dimension;j++){
                    matriz.colocarValores(i,j,coordenadas[i]*otroVector.getCoordenadas(j));
                }
            }return matriz;
    }




}
