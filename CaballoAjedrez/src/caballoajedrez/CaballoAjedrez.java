package caballoajedrez;

import java.util.ArrayList;
import javax.swing.JOptionPane;
public class CaballoAjedrez {
    
    public static void main(String[] args) {
        int x,y;
        ///Llamada a funciones de ingreso de datos
        x = solicitarX("Ingrese el valor de x (LETRAS MAYUSCULAS) del nodo incial");
        y = solicitarY("Ingrese el valor de y (NUMERO ENTERO) del nodo inicial");
        nodo inicio = new nodo(x,y); ///Inicializacion del nodo inicial

        ///Llamada a funciones de ingreso de datos
        x = solicitarX("Ingrese el valor de x (LETRAS MAYUSCULAS) del nodo final");
        y = solicitarY("Ingrese el valor de y (NUMERO ENTERO) del nodo inicial");
        nodo fin = new nodo(x,y); ///Inicializacion del nodo final
        
    } ///Fin de main
    
    
    
    
    ///METODOS UTILES AL IMPLEMENTAR EL MAIN (Impresion de texto, solicitud de datos, metodo de busqueda)
    public static void imprimir(String texto){
        JOptionPane.showMessageDialog(null, texto, "Salida de texto",1);
    }
    public static void advertencia(String texto){
        JOptionPane.showMessageDialog(null, texto, "Advertencia",2);
    }
    public static void error(String texto){
        JOptionPane.showMessageDialog(null, texto, "Error",0);
    }
    public static int solicitarX(String mensaje){
         String texto = JOptionPane.showInputDialog(mensaje);
         int valor=0;
        ///Convierte el valor literal a su equivalente en entero mediante un switch
         switch(texto){
             case "A" -> valor = 1;
             case "B" -> valor = 2;
             case "C" -> valor = 3;
             case "D" -> valor = 4;
             case "E" -> valor = 5;
             case "F" -> valor = 6;
             case "G" -> valor = 7;
             case "H" -> valor = 8;
             default -> valor=-1; ///En caso de que se haya ingresado un dato invalido, el valor sera -1
         }
         return valor; ///Se retorna el valor
    }
     public static int solicitarY(String mensaje){ ///Solicita el ingreso de datos de Y
         String texto = JOptionPane.showInputDialog(mensaje);
         int valor=Integer.parseInt(texto); ///Realiza la conversion de String a Integer
         //////////////////////////////////////APLICAR CONTROL DE EXCEPCIONES////////////////////////////////////////
         return valor;///Se retorna el valor convertido
    }

    ///INICIA METODO DE BUSQUEDA POR AMPLITUD
     public static void busquedaAmplitud(nodo nodoInicial, nodo nodoMeta){
         ///Declaracion de las listas y variables a utilizar en el algoritmo
         ArrayList<nodo> listaNodos = new ArrayList(); 
         ArrayList<nodo> historialNodos = new ArrayList();
         int nivel = 1;
         boolean encontrado = false;

         ///Inicializacion de las listas con el nodo inicial
         listaNodos.add(nodoInicial);
         historialNodos.add(nodoInicial);
         
         while(!listaNodos.isEmpty() && !encontrado){ ///Mientras que la lista no esta vacia y no se ha encontrado el nodo meta...
             
         }
     }
    
}

