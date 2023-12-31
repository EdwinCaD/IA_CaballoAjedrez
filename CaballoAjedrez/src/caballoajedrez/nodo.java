package caballoajedrez;
    
import java.util.ArrayList;

public class nodo {
    private int x,y;
    public ArrayList<Integer> movimientos = new ArrayList<Integer>();
    public ArrayList<nodo> nodosRecorridos = new ArrayList<nodo>();

    ///DECLARACION DE LOS CONSTRUCTORES DE LA CLASE
    public nodo (){
        x=0;
        y=0;
    }
    public nodo (int var1, int var2) {
        x=var1;
        y=var2;
    }
    ///METODOS DE LA CLASE
    public String imprimir(){
        char aux='x'; 
        switch (x){
            case 1 -> aux = 'A';
            case 2 -> aux ='B';
            case 3 -> aux = 'C';
            case 4 -> aux = 'D';
            case 5 -> aux = 'E';
            case 6 -> aux = 'F';
            case 7 -> aux = 'G';
            case 8 -> aux = 'H';
        }
        return "(" + aux +","+y+")";
    }
    ///Metodos get y set de las clases.
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setX(int valor){
        this.x = valor;
    }
    public void setY(int valor){
        this.y = valor;
    }
    ///MOVIMIENTOS DEL CABALLO, CONTANDO EN EL SENTIDO DE LAS MANECILLAS DEL RELOJ
    public nodo arriba1(){
        nodo nuevo = new nodo((this.x -1),(this.y+2));///Se crea un nuevo nodo con las coordenadas del movimiento
        nuevo.movimientos = (ArrayList)(this.movimientos.clone());
        nuevo.movimientos.add(1);
        nuevo.nodosRecorridos = (ArrayList<nodo>)(this.nodosRecorridos.clone());
        nuevo.nodosRecorridos.add(nuevo);
        return nuevo;
    }
    public nodo arriba2(){
        nodo nuevo = new nodo((this.x + 1),(this.y+2));///Se crea un nuevo nodo con las coordenadas del movimiento
        nuevo.movimientos = (ArrayList<Integer>)(this.movimientos.clone());
        nuevo.movimientos.add(2);
         nuevo.nodosRecorridos = (ArrayList<nodo>)(this.nodosRecorridos.clone());
        nuevo.nodosRecorridos.add(nuevo);
        return nuevo;
    }
    public nodo derecha1(){
        nodo nuevo = new nodo((this.x + 2),(this.y + 1)); ///Se cre aun nuevo nodo con las coordenadas del movimiento
        nuevo.movimientos = (ArrayList<Integer>)(this.movimientos.clone());
        nuevo.movimientos.add(3);
         nuevo.nodosRecorridos = (ArrayList<nodo>)(this.nodosRecorridos.clone());
        nuevo.nodosRecorridos.add(nuevo);
        return nuevo;
    }
    public nodo derecha2(){
        nodo nuevo = new nodo((this.x + 2),(this.y - 1)); ///Se cre aun nuevo nodo con las coordenadas del movimiento
        nuevo.movimientos = (ArrayList)(this.movimientos.clone());
        nuevo.movimientos.add(4);
         nuevo.nodosRecorridos = (ArrayList<nodo>)(this.nodosRecorridos.clone());
        nuevo.nodosRecorridos.add(nuevo);
        return nuevo;
    }
    public nodo abajo1(){
        nodo nuevo = new nodo((this.x + 1),(this.y - 2)); ///Se cre aun nuevo nodo con las coordenadas del movimiento
        nuevo.movimientos = (ArrayList<Integer>)(this.movimientos.clone());
        nuevo.movimientos.add(5);
         nuevo.nodosRecorridos = (ArrayList<nodo>)(this.nodosRecorridos.clone());
        nuevo.nodosRecorridos.add(nuevo);
        return nuevo;
    }
    public nodo abajo2(){
        nodo nuevo = new nodo((this.x - 1),(this.y - 2)); ///Se cre aun nuevo nodo con las coordenadas del movimiento
        nuevo.movimientos = (ArrayList<Integer>)(this.movimientos.clone());
        nuevo.movimientos.add(6);
         nuevo.nodosRecorridos = (ArrayList<nodo>)(this.nodosRecorridos.clone());
        nuevo.nodosRecorridos.add(nuevo);
        return nuevo;
    }
    public nodo izquierda1(){
        nodo nuevo = new nodo((this.x - 2),(this.y - 1)); ///Se cre aun nuevo nodo con las coordenadas del movimiento
        nuevo.movimientos = (ArrayList<Integer>)(this.movimientos.clone());
        nuevo.movimientos.add(7);
        nuevo.nodosRecorridos = (ArrayList<nodo>)(this.nodosRecorridos.clone());
        nuevo.nodosRecorridos.add(nuevo);
        return nuevo;
    }
    public nodo izquierda2(){
        nodo nuevo = new nodo((this.x - 2),(this.y + 1)); ///Se cre aun nuevo nodo con las coordenadas del movimiento
        nuevo.movimientos = (ArrayList<Integer>)(this.movimientos.clone());
        nuevo.movimientos.add(8);
        nuevo.nodosRecorridos = (ArrayList<nodo>)(this.nodosRecorridos.clone());
        nuevo.nodosRecorridos.add(nuevo);
        return nuevo;
    }
    public boolean esValido(ArrayList<nodo> historial) {
        if ((this.x >= 1 && this.x <= 8) && (this.y >= 1 && this.y <= 8)) {
            for (nodo nodoLista : historial)
                if ((nodoLista.x == this.x) && (nodoLista.y == this.y))
                    return false;
                    
            return true;
        }
        return false;
    }

}
