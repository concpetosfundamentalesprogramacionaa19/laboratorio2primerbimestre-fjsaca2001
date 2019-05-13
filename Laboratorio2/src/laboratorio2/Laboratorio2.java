/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio2;
import java.util.Scanner;

/**
 *
 * @author Frank J. Saca Q,
 */
public class Laboratorio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner (System.in);
        // declaracion de una vandera con el fi de no hacer infinito el programa
        boolean bandera = false ;
        int hijos,p = 1;
        // declaracion de arreglos para guardar los datos segun el usuario desee
        String padres [];
        // se inicia en un valor muy grande el arreglo ya que no puede iniciar en cero
        padres = new String [10000];
        float sueldos [];
        sueldos = new float [10000];
        int n_hijos[];
        n_hijos = new int [100000];
        float g_pasajes[];
        g_pasajes = new float [100000];
        float g_salidas[];
        g_salidas = new float [100000];
        float g_bar[];
        g_bar = new float [100000];
        float p_final[];
        p_final = new float [100000];
        float b_final[];
        b_final = new float [100000];
        float s_final[];
        s_final = new float [100000];
        float finals[];
        finals = new float [100000];
        
        String n_padres;
        // Ciclo hacer - repetir mientras el cual sirve para que la orden se haga por lo menos una vez
        do{
            
            for (int i = 1 ; i<=p ; i++){
                // se vuelve a iniciar la variable con un false para evitar que el ciclo sea infinito
                bandera = false;
                // requerimiento de daots al usuario
                System.out.printf("Ingese Su nombre y apellido: ");
                padres[i] = entrada.nextLine();
                System.out.printf("Ingrese Su sueldo familiar: ");
                sueldos[i] = entrada.nextFloat();
                System.out.printf("Ingrese el numero de hijos: ");
                n_hijos[i] = entrada.nextInt();
                hijos = n_hijos[i];
                    for (int c = 1; c <= hijos; c++){
                        //requerimiento de datos por hijo
                        System.out.printf("Hijo # %d",c);
                        System.out.print("\nIngrese el gasto semanal en Pasajes: ");
                        g_pasajes[c] = entrada.nextFloat();
                        System.out.print("\nIngrese el gasto semanal en Bar: ");
                        g_bar[c] = entrada.nextFloat();
                        System.out.print("\nIngrese el gasto semanal en Salidas: ");
                        g_salidas[c] = entrada.nextFloat();
                    }
                entrada.nextLine();
                //solicitud al usuario si desea ingresar mas datos
                System.out.printf("Ingrese 's' para agregar otro padre de familia o 'n' para continuar ..." );
                n_padres = entrada.nextLine();
                if (n_padres.equals("s")){
                    bandera = true;
                    p++;
            }
         }
        }while(bandera == true);
        // presentacion de datos
        for (int i = 1 ; i <= p ; i++ ){
            System.out.printf("\nReporte %d\n",i);
            System.out.printf("\nNombre de Padre de Familia: %s",padres[i]);
            System.out.printf("\nSueldo semanal: $%.2f",sueldos[i]);
            System.out.printf("\nReporte de Gastos");
            System.out.printf("\nPersona                         Pasaje                                   Bar                         Salidas");
            for(int c = 1; c<=n_hijos[i] ; c++){
            System.out.printf("\nHijo %d                          %.2f                                      %.2f                        %.2f\n"
                    ,c,g_pasajes[c],g_bar[c],g_salidas[c]);
                for(int j = 1; j <= n_hijos[i]; j++){
                    // calculo de la suma de los valores finales
                p_final[j] += g_pasajes[c];
                b_final[j] += g_bar[c];
                s_final[j] += g_salidas[c];
                }
            }
            System.out.printf("\nTotales                          %.2f                                     %.2f                     %.2f"
                    ,p_final[i],b_final[i],s_final[i]);
            finals[i] = p_final[i] + b_final[i] + s_final[i];
            // compribacion para verificar si alcanzo o falta el sueldo 
            if(finals[i] < sueldos [i]){
                System.out.printf("\nEl padre de familia %s le alcanza el dinero semanal, para sus gastos",padres[i]);
            }else{
                System.out.printf("\nEl padre de familia %s le falta el dinero semanal, para sus gastos",padres[i]);
                }
            // cierre del reporte
            System.out.printf("\n\nFin del reporte %d\n",i);
            }
        }
    }
