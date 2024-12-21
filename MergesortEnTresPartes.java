

import java.util.Arrays;

import static java.lang.Math.floor;

public class MergesortEnTresPartes {

    //3 campos A, B C
    int[] A = new int[1000];
    int[] B = new int[1000];
    int[] C = new int[1000];

    public void sortEnTresPartes(int[] O, int low, int high){
        if (high<=low){
            return;
        }
        //low es el indice a partir del cual se quiere sortear
        //tenemos un rango de numeros, y queremos enconrar el indice del
        //primer tcercio y el indice del segundo tecrcio del array
        //fin del primer tercio:
        int i1 = low + (int) floor((high-low)*1/3);
        //fin del segundo tercio
        int i2 = low + (int) floor((high-low)*2/3);

        //lo siguiente es hacer la recursion
        //llamar el metodo dentro de si mismo

        sortEnTresPartes(O,low,i1);
        sortEnTresPartes(O, i1+1,i2);
        sortEnTresPartes(O, i2+1, high);

        //en algun momento no podra seguir dividiendose y tendra qye hacerse el sorteo
        //primero asignemos valores al los arrays
        for (int k = low ; k<=i1; k++){
            A[k-low] = O[k];
        }
        for (int k = i1+1; k<=i2; k++){
            B[k-(i1+1) ] = O[k];
        }
        for (int k = i2+1; k<= high; k++){
            C[k-(i2+1)] = O[k];
        }

        //lo hemos llenado
        //centinelas!!
        A[i1-low+1] = Integer.MAX_VALUE; B[i2-(i1+1)+1]= Integer.MAX_VALUE; C[high-(i2+1)+1] = Integer.MAX_VALUE;

        int a = 0, b = 0, c = 0;
        for (int k=low; k<=high; k++){
            if (A[a]>= B[b] && B[b]>=C[c]){
                O[k] = C[c];
                c++;
            } else if (B[b]>= A[a] && A[a]>= C[c]) {
                O[k] = C[c];
                c++;
            } else if (B[b]>C[c] && C[c]>=A[a]) {
                O[k] = A[a];
                a++;
            } else if (C[c] >= A[a] && A[a]>=B[b]) {
                O[k] = B[b];
                b++;
            } else if (C[c] >= B[b] && B[b] >= A[a]) {
                O[k] = A[a];
                a++;
            }
        }


    }

    public static void run(){
     int[] O = new int[] {3,2,6,1,5,8,10,9};

     MergesortEnTresPartes mergesort = new MergesortEnTresPartes();

     mergesort.sortEnTresPartes(O, 1, 7);

     System.out.println(Arrays.toString(O));


    }

}

