/**
 * La clase Gato es la representacion de un gato, y es caracterizada por nombre color, edad y genero.
 *@author GemitaFernandez28
 */
public class Gato {
    private String nombre;
    private int edad;
    private String color;
    private String genero;

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getColor() {
        return color;
    }

    public String getGenero() {
        return genero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String toString(){
        return "gatito "+ nombre+" tiene "+edad+" años "+" de color "+color+"y tiene genero "+genero;
    }


    /**
     * el método equals sirve para ver si dos instancias de Gatos son iguales o no.
     * @param o de tipo Object, instancia con la que se compara con la clase Gato.
     * @return de tipo boolean, el método entrega true si los gatos tienen los mismos atributos, y falso de
     * lo contrario.
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        //debo probar si object es una instancia de gato

        if (o instanceof Gato) {

            //guardar la instancia en una nueva variable.

            Gato gato2 = (Gato) o;

            //Ahora al fin podemos verificar

            return nombre.equals(gato2.getNombre())
                    & edad == (gato2.getEdad())
                    & color.equals(gato2.getColor())
                    & genero.equals(gato2.getGenero());
        }else{return false;}

    }












}
