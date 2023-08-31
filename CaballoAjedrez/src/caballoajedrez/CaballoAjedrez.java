package caballoajedrez;

import java.util.ArrayList;
import javax.swing.JOptionPane;
public class CaballoAjedrez {
    
    public static void main(String[] args) {
        int x,y;
        x = solicitarX("Ingrese el valor de x (LETRAS MAYUSCULAS) del nodo incial");
        y = solicitarY("Ingrese el valor de y (NUMERO ENTERO) del nodo inicial");
        nodo inicio = new nodo(x,y);
        
        x = solicitarX("Ingrese el valor de x (LETRAS MAYUSCULAS) del nodo final");
        y = solicitarY("Ingrese el valor de y (NUMERO ENTERO) del nodo inicial");
        nodo fin = new nodo(x,y);
        
    }
    
    
    
    
    ///METODOS UTILES AL IMPLEMENTAR EL MAIN (Impresion de texto, solicitud de datos
    public static void imprimir(String texto){
        JOptionPane.showMessageDialog(null, texto, "Bandera",1);
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
         switch(texto){
             case "A" -> valor = 1;
             case "B" -> valor = 2;
             case "C" -> valor = 3;
             case "D" -> valor = 4;
             case "E" -> valor = 5;
             case "F" -> valor = 6;
             case "G" -> valor = 7;
             case "H" -> valor = 8;
             default -> valor=-1;
         }
         return valor;
    }
     public static int solicitarY(String mensaje){
         String texto = JOptionPane.showInputDialog(mensaje);
         int valor=Integer.parseInt(texto);
         return valor;
    }
     public static void busquedaAmplitud(nodo nodoInicial, nodo nodoMeta){
         ArrayList<nodo> listaNodos = new ArrayList();
         ArrayList<nodo> historialNodos = new ArrayList();
         int nivel = 1;
         boolean encontrado = false;
         
         listaNodos.add(nodoInicial);
         historialNodos.add(nodoInicial);
         
         while(!listaNodos.isEmpty() && !encontrado){
         }
     }
    
}

