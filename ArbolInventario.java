public class ArbolInventario {
    
    private Producto raiz;

    public void insertar(Producto nuevo){
        if (raiz == null) {
            raiz = nuevo;
            System.out.println("\nProducto insertado correctamente.");
            return;
        } 

       insertarRecursivo(nuevo, raiz);


    }

    
    
    
    public void insertarRecursivo(Producto nuevo, Producto actual){
        if (nuevo.getId() == actual.getId()) {
            System.out.println("\nEl producto con ID: " + nuevo.getId() + " ya existe en el inventario.");
            return;
        }
       
        else if (nuevo.getId() < actual.getId()) {
            if (actual.getIzquierdo() == null) {
                actual.setIzquierdo(nuevo);
                System.out.println("\nProducto insertado correctamente.");

            } else {  
                insertarRecursivo(nuevo, actual.getIzquierdo());
            }

        } else {
            if (actual.getDerecho() == null) {
                actual.setDerecho(nuevo);
                System.out.println("\nProducto insertado correctamente.");
            } else {   
                insertarRecursivo(nuevo, actual.getDerecho());
            }   
        }
    }

    

    public void inorden() {
        if (raiz == null) {
            return;
        }

        inordenRecursivo(raiz);
    }

    private void inordenRecursivo(Producto actual) {
        if (actual.getIzquierdo() != null) {
            inordenRecursivo(actual.getIzquierdo());
        } 

        System.out.println("\nID: " + actual.getId() + " - Nombre: " + actual.getNombre());

        if (actual.getDerecho() != null) {
            inordenRecursivo(actual.getDerecho());
        }
    }


    public void buscar(int id){
        if (raiz == null) {
            System.out.println("\nNo hay id registrados, el inventario esta vacio");
            return;
        }
        
        buscarRecursivo(id, raiz);

    }

    private void buscarRecursivo(int id, Producto actual){
       
        if (actual.getId() == id) {
            System.out.println("=".repeat(60) + "\n\nID: " + actual.getId() + " \nNombre: " + actual.getNombre());
            return;
        }

        if (id < actual.getId()) {
            if (actual.getIzquierdo() != null) {
                buscarRecursivo(id, actual.getIzquierdo());
            } else {
                System.out.println("=".repeat(60) + "\nNo se encontro el producto con ID: " + id);
            }
        } else {
            
            if (actual.getDerecho() != null) {
                buscarRecursivo(id, actual.getDerecho());
            } else {
                System.out.println("=".repeat(60) + "\nNo se encontro el producto con ID: " + id);
            }
        } 


    }
}

//Notas personales

//Logica del arbol:
//la logica del arbol binario, consiste en posicionar los elementos en una direccion basandonos en si el id del producto es mayor o menor al id de la raiz
//Y posteriormente, si es mayor o menor al id del nodo actual, al que llamaremos padre. la ruta inicial de los numeros se define por la comparacion con la raiz.
//sin embargo dentro del arbol, hay ids que puden ser mayores al padre, estos se posicionaran a la derecha del mismo y es en la logica del inorden donde crearemos un sistema
//que nos imprima los datos en orden. Usando la siguiente logica: Izquierda (menor que el padre) > Padre > Derecha (mayor que el padre).

//Insertar:
//El metodo insertar, sera quien nos permita agregar un nuevo producto al arbol. El comportamiento de la insercion busca evalua la existencia de un atributo izquierda o derecha
//siendo esta la condicion para reciclar el metodo y evaluar el siguiente nodo o asignarle a la izquierda o derecha de el nodo evaluado el nuevo producto.
//
//                              50    (raiz)
//                           /     \
//                          25      75
//                         / \     / \
//                        10 30   60 90
//
//El metodo insertar se divide en dos partes.

//1. Insertar: Este metodo evalua si la raiz es nula, es decir si hay algun numero dentro del arbol. este metodo se ejecuta siempre ya que sera tambien el metodo de activacion de nuestro segundo metodo.
//2. InsertarRecursivo: Este metodo inicia una vez se comprobo si existia previamente una raiz y es quien se encarga de comparar los productos nuevos con los existentes,
//basandonse en esta comparativa para ubicarlos a la izquierda o derecha.
//La primera condicion evalua si el id es del nuevo producto es menor al id del producto actual y su else que ejecuta la logica en caso de que el id del nuevo producto sea mayor al id del producto actual.
//dentro de estas condicciones, anidamos otra condicion, la cual evalua si la referencia izquierda o derecha del producto actual es nula o si ya tiene un producto. 
//En caso de que sea nula, asignamos el nuevo producto a esa referencia y en caso de que ya haya un id, se ejcuta el metodo nuevamente pero esta vez el Producto actual no es la raiz si no la referencia izquierda o derecha. 
//Cada vez que haya un producto en las referencias, el metodo se llamara nuevamente actualizando su parametro producto actual por el de el nodo que estamos evaluando en ese ciclo.
//Este escenario ocurre en los 2 casos tanto si el id del nuevo producto es menor o mayor al id del producto actual, ya que en ambos casos, si la referencia izquierda o derecha no es nula, se ejecutara nuevamente el metodo con el producto actual actualizado.

