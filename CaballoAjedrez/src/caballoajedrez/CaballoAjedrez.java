package caballoajedrez;

import javax.swing.JOptionPane;
public class CaballoAjedrez {
    
    public static void main(String[] args) {
        int x,y;
        x = solicitar("Ingrese el valor de x (LETRAS MAYUSCULAS)");
        y = solicitar("Ingrese el valor de y (NUMERO ENTERO)");
        nodo prueba1 = new nodo(x,y);
        
        ///PRUEBA DE LOS OPERADORES
        //Arriba 1
        nodo hijo = prueba1.arriba1();
        if(hijo.esValido()){
            imprimir(hijo.imprimir());
        }else{
           advertencia("Las coordenadas no existen");
        }
        
        //Arriba 2
        hijo = prueba1.arriba2();
        if(hijo.esValido()){
            imprimir(hijo.imprimir());
        }else{
           advertencia("Las coordenadas no existen");
        }
        
        //Derecha 1
        hijo = prueba1.derecha1();
        if(hijo.esValido()){
            imprimir(hijo.imprimir());
        }else{
           advertencia("Las coordenadas no existen");
        }
        
        //Derecha 2
        hijo = prueba1.derecha2();
        if(hijo.esValido()){
            imprimir(hijo.imprimir());
        }else{
           advertencia("Las coordenadas no existen");
        }
        
        //Abajo 1
        hijo = prueba1.abajo1();
        if(hijo.esValido()){
            imprimir(hijo.imprimir());
        }else{
           advertencia("Las coordenadas no existen");
        }
        
        //Abajo 2
        hijo = prueba1.abajo2();
        if(hijo.esValido()){
            imprimir(hijo.imprimir());
        }else{
           advertencia("Las coordenadas no existen");
        }
        
        //Izquierda 1
        hijo = prueba1.izquierda1();
        if(hijo.esValido()){
            imprimir(hijo.imprimir());
        }else{
           advertencia("Las coordenadas no existen");
        }
        
        //Izquierda 2
        hijo = prueba1.izquierda2();
        if(hijo.esValido()){
            imprimir(hijo.imprimir());
        }else{
           advertencia("Las coordenadas no existen");
        }
        
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
    public static int solicitar(String mensaje){
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
         }
         return valor;
    }
    
}
