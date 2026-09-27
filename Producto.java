public class Producto {
    private int id;
    private String nombre;
    private Producto izquierdo;
    private Producto derecho;

    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto getIzquierdo() {
        return izquierdo;
    }

    public Producto getDerecho() {
        return derecho;
    }

    public void setIzquierdo(Producto izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(Producto derecho) {
        this.derecho = derecho;
    }
    
}


//Notas personales para entender el codigo y su funcionamiento, facilitar el razonamiento y aclarar conceptos.

//Creamos la estructura del producto, que a su vez es un nodo del arbol binario.
//Usamos un encapsulamiento de datos y un constructor para asignarle un valor (id y nombre) mediante su creacion,
//creando una estructura de nodo similar a la vista en la actividad pasada de Pizza-Track.
//A su vez creamos los metodos get para acceder a los datos y set para modificar las referencias

// Referencias; izquierdo y derecho, son los que nor permiten llegar a los nodos hijos del arbol binario, que a su vez son productos, y que a su vez pueden tener sus propios hijos, creando asi un arbol binario de productos
// Nodo: clase que representa un elemento del arbol binario, en este caso un producto
// get(variable): metodo que permite acceder a los datos del nodo, en este caso el id, nombre y las referencias a los nodos hijos
//set(variable): metodo que permite modificar las referencias a los nodos hijos, en este caso izquierdo y derecho
