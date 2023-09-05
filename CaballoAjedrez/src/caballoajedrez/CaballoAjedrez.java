package caballoajedrez;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CaballoAjedrez {

    public static void main(String[] args) {
        int x, y;
        debuggMessage("Mensaje de debug de entrada: ");
        x = solicitarX("Ingrese el valor de x (LETRAS A - H) del nodo INICIAL");
        y = solicitarY("Ingrese el valor de y (NUMERO ENTERO) del nodo INICIAL");

        nodo inicio = new nodo(x, y);
        debuggMessage(inicio.imprimir());

        debuggMessage("Mensaje 2 de debug de entrada: ");
        x = solicitarX("Ingrese el valor de x (LETRAS A - H) del nodo FINAL");
        y = solicitarY("Ingrese el valor de y (NUMERO ENTERO) del nodo FINAL");

        nodo fin = new nodo(x, y);
        debuggMessage(fin.imprimir());
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

    public static void debuggMessage(String mensaje) {
        System.out.println(mensaje);
    }

    public static int solicitarX(String mensaje) {
        String texto = JOptionPane.showInputDialog(mensaje);
        int valor = 0;
        switch (texto) {
            case "A", "a":
                valor = 1;
                break;
            case "B", "b":
                valor = 2;
                break;
            case "C", "c":
                valor = 3;
                break;
            case "D", "d":
                valor = 4;
                break;
            case "E", "e":
                valor = 5;
                break;
            case "F", "f":
                valor = 6;
                break;
            case "G", "g":
                valor = 7;
                break;
            case "H", "h":
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
                imprimir("Se ha encontrado la meta");
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
                    if (aux.esValido(historialNodos)) {
                        listaNodos.add(aux);
                        historialNodos.add(aux);
                        debuggMessage("Se ha introducido el hijo " + aux.imprimir() + " a la lista");
                    }
                }
                debuggMessage("Mensajes de debug de lista de nodos y movimientos: ");
            }
            nivel++;
            debuggMessage("Se ha terminado la iteracion... iniciando la " + nivel + " Iteracion");
        }

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
            debuggMessage("Mensaje de debugg relacionado a la lista de nodos recorridos");
            for (nodo aux : meta.nodosRecorridos) {
                debuggMessage(aux.imprimir());
            }
            imprimir(mensajeEncontrado);
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
            /// APLICACION DE LA INTERFAZ GRÁFICA DE USUARIO QUE REPRESENTA LOS MOVIMIENTOS
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        }
    }
}