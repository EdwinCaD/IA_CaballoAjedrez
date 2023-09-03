package caballoajedrez;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CaballoAjedrez {

    public static void main(String[] args) {
        int x, y;
        System.out.println("Mensaje de debug de entrada: ");
        x = solicitarX("Ingrese el valor de x (LETRAS MAYUSCULAS) del nodo incial");
        y = solicitarY("Ingrese el valor de y (NUMERO ENTERO) del nodo inicial");
        
        nodo inicio = new nodo(x, y);
        imprimir(inicio.imprimir());
        System.out.println("Mensaje 2 de debug de entrada: ");
        x = solicitarX("Ingrese el valor de x (LETRAS MAYUSCULAS) del nodo final");
        y = solicitarY("Ingrese el valor de y (NUMERO ENTERO) del nodo inicial");
        nodo fin = new nodo(x, y);
        imprimir(fin.imprimir());
        busquedaAmplitud(inicio, fin);

    }

    /// METODOS UTILES AL IMPLEMENTAR EL MAIN (Impresion de texto, solicitud de
    /// datos
    public static void imprimir(String texto) {
        JOptionPane.showMessageDialog(null, texto, "Bandera", 1);
    }

    public static void advertencia(String texto) {
        JOptionPane.showMessageDialog(null, texto, "Advertencia", 2);
    }

    public static void error(String texto) {
        JOptionPane.showMessageDialog(null, texto, "Error", 0);
    }

    public static int solicitarX(String mensaje) {
        String texto = JOptionPane.showInputDialog(mensaje);
        int valor = 0;
        switch (texto) {
            case "A":
                valor = 1;
                break;
            case "B":
                valor = 2;
                break;
            case "C":
                valor = 3;
                break;
            case "D":
                valor = 4;
                break;
            case "E":
                valor = 5;
                break;
            case "F":
                valor = 6;
                break;
            case "G":
                valor = 7;
                break;
            case "H":
                valor = 8;
                break;
            default:
                valor = -1;
                break;
        }
        return valor;
    }

    public static int solicitarY(String mensaje) {
        String texto = JOptionPane.showInputDialog(mensaje);
        int valor = Integer.parseInt(texto);
        return valor;
    }

    /// Funcion para verificar si existe historial del nodo creado
    public static boolean existeHistorial(nodo x, ArrayList<nodo> historial) {
        for (nodo y : historial) { // para cada nodo en la lista
            if (y.getX() == x.getX() && y.getY() == x.getY()) { // Si es igual al nodo que buscamos
                return true;// Se regresa verdadero
            }
        }
        return false;/// De lo contrario, se regresa falso.
    }

    public static void busquedaAmplitud(nodo nodoInicial, nodo nodoMeta) {
        ArrayList<nodo> listaNodos = new ArrayList<nodo>();
        ArrayList<nodo> historialNodos = new ArrayList<nodo>();
        int nivel = 1;
        boolean encontrado = false;

        listaNodos.add(nodoInicial);
        historialNodos.add(nodoInicial);

        while (!listaNodos.isEmpty() && !encontrado) {
            nodo auxiliar, hijo;

            /// INICIO DEL ALGORITMO
            auxiliar = listaNodos.get(0);
            if (auxiliar.getX() == nodoMeta.getX() && auxiliar.getY() == nodoMeta.getY()) {
                encontrado = true;
            } else {
                ArrayList<nodo> listaAuxiliar = new ArrayList<nodo>();
                listaNodos.remove(0);
                /// Creacion y verificacion de los hijos
                hijo = auxiliar.arriba1();
                listaAuxiliar.add(hijo);
                hijo = auxiliar.arriba2();
                listaAuxiliar.add(hijo);
                hijo = auxiliar.derecha1();
                listaAuxiliar.add(hijo);
                hijo = auxiliar.derecha2();
                listaAuxiliar.add(hijo);
                hijo = auxiliar.abajo1();
                listaAuxiliar.add(hijo);
                hijo = auxiliar.abajo2();
                listaAuxiliar.add(hijo);
                hijo = auxiliar.izquierda1();
                listaAuxiliar.add(hijo);
                hijo = auxiliar.izquierda2();
                listaAuxiliar.add(hijo);

                for (nodo aux : listaAuxiliar) {
                    if (!existeHistorial(aux, historialNodos) && aux.esValido()) {
                        listaNodos.add(aux);
                        historialNodos.add(aux);
                        System.out.println("Se ha inroducido el hijo " + aux.imprimir() + " a la lista");
                    }
                }
                System.out.println("Mensajes de debug de lista de nodos y movimientos: ");
            }
            nivel++;
            System.out.println("Se ha terminado la iteracion... iniciando la " + nivel + " Iteracion");
        }
        System.out.println(listaNodos.get(0).imprimir());
        if (encontrado) {
            String mensajeEncontrado = "Camino tomado: \n";
            nodo meta = listaNodos.get(0);
            for (int movimiento : meta.movimientos) {
                switch (movimiento) {
                    case 1:
                        mensajeEncontrado += "Mover arriba a la izquierda \n";
                        break;
                    case 2:
                        mensajeEncontrado += "Mover arriba a la derecha \n";
                        break;
                    case 3:
                        mensajeEncontrado += "Mover a la derecha arriba \n";
                        break;
                    case 4:
                        mensajeEncontrado += "Mover a la derecha abajo \n";
                        break;
                    case 5:
                        mensajeEncontrado += "Mover abajo a la derecha \n";
                        break;
                    case 6:
                        mensajeEncontrado += "Mover abajo a la izquierda \n";
                        break;
                    case 7:
                        mensajeEncontrado += "Mover a la izquierda abajo \n";
                        break;
                    case 8:
                        mensajeEncontrado += "Mover a la izquierda arriba \n";
                        break;
                    default:
                        mensajeEncontrado += "Hubo un error al recuperar el texto...";
                        break;
                }

            }
            imprimir(mensajeEncontrado);
        }
    }

}
