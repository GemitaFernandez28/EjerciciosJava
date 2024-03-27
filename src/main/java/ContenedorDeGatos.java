/**
 * La clase ContenedorDeGatos, contiene los gatos de tipo Gato.
 * y la la clase Gato tiene atributos de nombre, genero, edad, y color.
 * @author GemitaFernandez28
 */


public class ContenedorDeGatos {

    Gato[] michis;
    int tamano;
    // CONSTRUCTOR

    /**
     * Es el único constructor.
     * @param capacidadArray: como parámetro debe indicar la capacidad del array de gatos.
     */

    public ContenedorDeGatos (int capacidadArray){
        //instanciar el array:
        tamano=0;
        michis=new Gato[capacidadArray];
    }
    //METODO PARA AGREGAR GATITOS.

    /**
     * agregaGatos, como dice el nombre agrega los gatos con sus atributos al array.
     *
     * @param gato, recibe un objeto que viene de la clase Gatos.
     */
    public void agregaGatos(Gato gato){
        michis[tamano]=gato;
        tamano++;
    }
    //AHORA PODEMOS AGREGAR LOS OTROS METDOS

    /**
     * cuentaMachos, cuenta  cuántos datos del array
     * de la clase ContenedorDeGatos son machos.
     * @return la cantidad de machos.
     */

    public int cuentaMachos(){
        int contador=0;
        for (int i=0;i<tamano;i++){
            if(michis[i].getGenero().equals("macho")){
                contador++;
            }
        }return contador;
    }

    /**
     * cuentaJovenes, cuenta la cantidad de gatos (de la clase Gatos) jovenes que hay en el array
     * de la clase de ContenedorDeGatos..
     * @return cantidad de gatos jovenes.
     */
    public int cuentaJovenes(){
        int contadorJovenes=0;
        for (int i=0; i<tamano;i++){
            if (michis[i].getEdad()<4){
                contadorJovenes++;
            }
        }return contadorJovenes;
    }

    /**
     * cuentaRojos, cuenta la cantidad de gatos
     * de color rojos que hay en el array(de la clase ContenedorDeGatos)  de objetos gatos.
     * @return la cantidad de gatos rojos.
     */


    public int cuentaRojos(){
        int contadorRojos=0;
        for (int i=0; i<tamano;i++){
            if (michis[i].getColor().equals("rojo")){
                contadorRojos++;
            }
        }
        return contadorRojos;
    }

    /**
     * entrega el primer objeto de la clase Gatos que pille en en array michis.
     * @param nombreDelGato, es el nombre del gato buscado de tipo String.
     * @return entrega el objeto de gato con el nombre especificado con el nombre del gato.
     */


    public Gato getGato(String nombreDelGato){
        for (int i=0; i<tamano;i ++){
            if (michis[i].getNombre().equals(nombreDelGato)){
                return michis[i];
            }
        }return null;
    }

    /**
     * el toString construye una representacion en String de la Clase ContendeorDeGatos.
     * el string esta compuesto por la representacion individual de cada gato contenido en el array.
     * la representacion individual de cada gato se hace por medio de la utilizacion del tosString.
     * @return
     */


    @Override
    public String toString(){
        String str="";
        for (int i=0; i<tamano;i++){
            //objeto a String
            str+=michis[i].toString()+" \n ";
        }return str;
    }

    public static void run(){
        //primero declarar e instanciar el contendedor:
        ContenedorDeGatos cg=new ContenedorDeGatos(10);
        //Ahora hay que agregar gatitos.

        Gato g=new Gato();
        g.setNombre("Sofi");
        g.setEdad(2);
        g.setColor("blanco");
        g.setGenero("hembra");

        //Agregar g al contendor:

        cg.agregaGatos(g);
        //---------------------------------------------------------------------------
        //La unica forma de acceder a sofi es a traves del contenedor.
        // reutilizar la variable g:
         g=new Gato();
        g.setNombre("Perla");
        g.setEdad(15);
        g.setColor("marron");
        g.setGenero("hembra");

        cg.agregaGatos(g);
        //---------------------------------------------------------------------------
         g=new Gato();
        g.setNombre("Lachon");
        g.setEdad(2);
        g.setColor("negro");
        g.setGenero("macho");

        //Agregar g al contendor:

        cg.agregaGatos(g);
        //----------------------------------------------------------------------------
        g=new Gato();

        g.setNombre("Luna");
        g.setEdad(2);
        g.setColor("marron");
        g.setGenero("hembra");

        //Agregar g al contendor:

        cg.agregaGatos(g);
        //----------------------------------------------------------------------------
        g=new Gato();

        g.setNombre("Links");
        g.setEdad(10);
        g.setColor("marron");
        g.setGenero("hembra");

        //Agregar g al contendor:

        cg.agregaGatos(g);
        //---------------------------------------------------------------------------
        //AHORA A PROBAR!!

        System.out.println(cg.toString());
        //entrega la referencia:
        cg.getGato("Sofi").setColor("manchasGrises");

        System.out.println(cg.cuentaMachos());
        System.out.println(cg.cuentaRojos());
        System.out.println(cg.cuentaJovenes());
    }




}
