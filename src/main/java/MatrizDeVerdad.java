/**
 * Esta clase es una representacion de una matriz con diferentes metodos para hacer operaciones con ella.
 * con atriubutos una matriz llamada miMatriz, y las dimesiones de las filas y las columnas.
 * @author GemitaFernandez28
 */



public class MatrizDeVerdad {
    private float[][] miMatriz; //matriz base.
    private int dimFila;   //dimension de la fila de la matriz.
    private int dimColumna; //dimension de la columna de la matriz.

    /**
     * Esto es el CONSTRUCTOR,
     * que tiene como finalidad inicializar la matriz con ceros, y las dimesiones
     * de la fila y la columna.
     * @param dimFila (tipo int ), es la dimension de la fila de la matriz.
     * @param dimColumna (tipo int ), es la dimension de la columna de la matriz.
     */

    public MatrizDeVerdad(int dimFila, int dimColumna){
        //AHORA INICIALIZAR LA MATRIZ.
        //miMatriz esta inicialida con ceros.
        miMatriz=new float[dimFila][dimColumna];
        this.dimFila=dimFila;
        this.dimColumna=dimColumna;
    }

    /**
     * Coloca los valores a la matriz que se habia inicializado.
     * @param i (tipo int), indice fila de la matriz.
     * @param j (tipo int), indice columna de la matriz.
     * @param valor (tipo float), es el valor que yo le quiero colocar a la matriz, dadas las indices
     * i y j.
     */
    public void colocarValores(int i, int j, float valor){
        miMatriz[i][j]=valor;
    }
    public float getValor(int i, int j){
        return miMatriz[i][j];
    }
    public int getDimensionFila(){
        return dimFila;
    }
    public int getDimensionColumna(){
        return dimColumna;
    }

    /**
     * Metodo que sirve para sumar una matriz con otra.
     * No retorna nada.
     * @param otraMatriz (tipo MatrizDerdad), es la matriz que se sumara con miMatriz.
     */


    public void sumaAmiMatriz(MatrizDeVerdad otraMatriz) {
        if (this.dimFila == otraMatriz.getDimensionFila() &
                this.dimColumna == otraMatriz.getDimensionColumna()) {
            for (int i = 0; i < dimFila; i++) {
                for (int j = 0; j < dimColumna; j++) {
                    miMatriz[i][j] += otraMatriz.getValor(i, j);
                }
            }

        }
    }

    /**
     * Lo mismo que lo anterior solo que ahora con resta!!!!!
     * @param otraMatriz
     */
    public void restaAmiMatriz(MatrizDeVerdad otraMatriz) {
        if (this.dimFila == otraMatriz.getDimensionFila() &
                this.dimColumna == otraMatriz.getDimensionColumna()) {
            for (int i = 0; i < getDimensionFila(); i++) {
                for (int j = 0; j < dimColumna; j++) {
                    miMatriz[i][j] -= otraMatriz.getValor(i, j);

                }
            }
        }
    }

    /**
     * Este metodo multiplica una matriz con otra.
     * @param otraMatriz (tipo MatrizDeVerdad), es el restultado de multipplicar las matrices.
     */
    public void multiplicaAmiMatriz(MatrizDeVerdad otraMatriz){
        if (this.dimFila==otraMatriz.getDimensionFila()&
            this.dimColumna==otraMatriz.getDimensionColumna()){
            int suma=0;
            for (int i=0; i<dimFila;i++){
                for (int j=0; i<dimColumna;i++){
                    for (int k=0; k<dimColumna; k++){
                        suma+=miMatriz[i][k]*otraMatriz.getValor(k,j);
                    }miMatriz[i][j]=suma;
                }
            }
        }
    }

    /**
     * Igual que a "multiplicaAmiMatriz", PERO QUE NO ME MODIFIQUE LA MATRIZ,
     * sino que me entrega otra.
     * @param otraMatriz (tipo MatrizDeVerdad), matriz resultado del producto
     * de las matrices.
     * @return (tipo MatrizDeVerdad), regresa una nueva matriz, resultado de la
     * multiplicacion de matrices.
     */
    public MatrizDeVerdad multiplicaAmiMatriz2(MatrizDeVerdad otraMatriz){
        if (this.dimFila==otraMatriz.getDimensionFila()&
        this.dimColumna==otraMatriz.getDimensionColumna()){
            MatrizDeVerdad miMatriz2=new MatrizDeVerdad(dimFila,dimColumna);
            float suma=0;
            for (int i=0; i<dimFila;i++){
                for (int j=0; j<dimColumna;j++){
                    for (int k=0; k<dimFila; k++){
                        suma+=miMatriz[i][k]*otraMatriz.getValor(k,j);


                    }miMatriz2.colocarValores(i,j,suma);
                }

            }return miMatriz2;

        }else{
            return null;
        }
    }

    /**
     * Convierte una matriz en la matriz identidad,
     * no retorna nada.
     */

    public void convierteaIdentidad(){
        for (int i=0; i<dimFila;i++){
            for (int j=0; j<dimColumna;j++){
                if(i==j){
                    miMatriz[i][j]=1;
                }else{
                    miMatriz[i][j]=0;
                }
            }
        }
    }

    /**
     * Es la representacion en string de la matriz.
     * @return (tipo String), retorna la cadena de Srings.
     */


    public String toString(){
        String cadena="";
        for (int i=0; i<dimFila;i++){
            for (int j=0; j<dimColumna;j++){
                 cadena+=miMatriz[i][j]+"    ";
            }cadena+="\n";

        }return cadena;

    }

    /**Multplica una matriz con un vector (ojo, que en el nombre del metodo lo puse en orden contrario)
     * @param v (tipo VectorDeVerdad), es el vector con el que se hara la operacion.
     * @return, retorna un vector, resultado del producto entre matriz con vector
     */


    public VectorDeVerdad multiplicaVectorConMatriz(VectorDeVerdad v){
        VectorDeVerdad vi=new VectorDeVerdad(dimColumna);
        float suma=0;
        for (int i=0; i<dimFila;i++){
            suma=0; //recuerda que la suma se debe resetear.
            for(int j=0; j<dimColumna;j++){
                suma+=miMatriz[i][j]*v.getCoordenadas(j);
            }vi.cambiaValor(i,(int )suma);
        }return vi;
    }

        public static void run(){
        //Primero tengo que instanciar un objeto;
            VectorDeVerdad miVector=new VectorDeVerdad(4);
            //osea lo de arriba es un vector de 4 elementos, todos ceros.
            //Ahora tengo que agregar algunos valores, cambiavalor(i,n);
            miVector.cambiaValor(0,1);
            miVector.cambiaValor(1,2);
            miVector.cambiaValor(2,10);
            miVector.cambiaValor(3,8);
            //Ahora instanciemos el otro construcor de VectorDeVerdad;
            //instanciar primero un array.

            float[] coord=new float[]{2,3,8,12};
            VectorDeVerdad miVector2=new VectorDeVerdad(coord);
            miVector.sumar(miVector2);
            System.out.println(miVector.toString());

            miVector.restar(miVector2);
            System.out.println(miVector.toString());
            System.out.println("el producto interno es "+ miVector2.productorInterno(miVector2));
            System.out.print(miVector.multiplicaVectores(miVector2).toString());

            MatrizDeVerdad B=new MatrizDeVerdad(3,3);
            B.colocarValores(0,0,1);
            B.colocarValores(0,1,4);
            B.colocarValores(0,2,6);
            B.colocarValores(1,0,8);
            B.colocarValores(1,1,1);
            B.colocarValores(1,2,3);
            B.colocarValores(2,0,2);
            B.colocarValores(2,1,4);
            B.colocarValores(2,2,3);

            B.sumaAmiMatriz(B);
            System.out.println(B.toString());

            MatrizDeVerdad D=new MatrizDeVerdad(3,3);

            D.colocarValores(0,1,2);
            D.colocarValores(2,2,4);
            D.colocarValores(1,2,5);

            B.restaAmiMatriz(D);
            System.out.println(B.toString());


            B.convierteaIdentidad();
            System.out.println(B.toString());

            B.multiplicaVectorConMatriz(miVector2);
            System.out.println(B.multiplicaVectorConMatriz(miVector2).toString());

    }




}

