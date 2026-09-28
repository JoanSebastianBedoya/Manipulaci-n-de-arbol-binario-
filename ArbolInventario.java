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
            System.out.println("\nNo hay productos registrados, el inventario esta vacio");
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
//
//Errores de insercion: En caso de que el id registrado ya existe, el metodo no modifica las referencias izquierda o derecha. Por el contrario, imprime un mensaje de error y termina la ejecucion del metodo. Esto evita que se creen nodos duplicados en el arbol.
//
//Recorrer inorden: El metodo inorden evalua si la raiz es nula, caso contrario, ejecuta el metodo inordenRecursivo. el metodo inordenRecursivo es quien se encarga de recorrer el arbol y mostrar los datos de los productos en orden.
//Como explicamos anterioremente, la logica del inorden es: Izquierda (menor que el padre) > Padre > Derecha (mayor que el padre).
//el metodo inicia y evalua si la izquierda tiene un producto (!= null) si es asi, inicia otro metodo inordenRecursivo, pasando como parametro el producto que se hayaba a la izquierda.
//cada vez que llamemos el metodo va a entrar en todos los nodos izquierdos hasta que llegue a un nodo que no tenga un producto a la izquierda, en ese momento imprimira el id y nombre del producto actual.
//Una vez lo imprima va a evaluar si el producto actual tiene un producto a la derecha, si es asi, ejecutara nuevamente el metodo inordenRecursivo pasando como parametro el producto que se hayaba a la derecha.
//
//                               50    (raiz)
//                            /      \
//                           /        \
//                          25        75
//                         / \        / \
//                        10 30      60 90
//                       / \ 
//                      5  15
//
//Usemos como ejemplo este arbol, la primera ejecucion del metodo inicia en la raiz (50). entonces evalua si la izquierda tiene un producto.
//si hay un producto a la izquierda, ejecuta el metodo pero esta vez evaluamos la izqueirda de 50, que es 25.
//cuando evaluemos 25, ejecutamos, nuevamente el metodo y evaluamos si 25 tiene un producto a la izquierda, que es 10.
//cuando evaluemos 10, ejecutamos nuevamente el metodo y evaluamos si 10 tiene un producto a la izquierda, que es 5.
//cuando evaluemos 5, este ya no tiene un producto a su izquierda, entonces imprimimos el id de y el nombre de 5 (impresion: 5).
//aunque ejecutemos otros metodos esto no interrumpe los metodos ejecutados anteriormente.
//El metodo 10 sigue ejecutandose, entonces como ya termino el metodo de 5 salta a la siguiente linea de el metodo de 10, que es imprimir el id y nombre de 10 (impresion: 5, 10).
//el metodo de 10 tiene una 3 linea, que evalua si hay un producto a la derecha, si es asi ejecuta nuevamente el metodo pero esta vez evaluando la derecha de 10, que es 15.
//el metodo de 15 evalua si tiene elementos a la izquierda, en caso de que no imprime el id y nombre de 15 (impresion: 5, 10, 15) y evalua si tiene elementos a la derecha, en caso de que no termina el metodo.
//cuando el metodo 10 termina en su totalidad (evaluo 5 (izquierda), imprimio 10, evaluo 15 (derecha)).
//el metodo 25 sigue con su siguiente linea que es imprimir el id y nombre de 25 (impresion: 5, 10, 15, 25), luego evalua si hay un producto a la derecha, si es asi ejecuta nuevamente el metodo pero esta vez evaluando la derecha de 25, que es 30.
//30 no tiene elementos a la izquierda, entonces imprime el id y nombre de 30 (impresion: 5, 10, 15, 25, 30) y evalua si tiene elementos a la derecha, en caso de que no termina el metodo.
//y una vez termine el metodo de 30, termina tambien el metodo de 25 y el metodo inicial que fue con la raiz sigue su curso, imprime y evalua su derecha. Siguiendo exactamente la misma logica.
//
//errores de inorden: El primer metodo inorden, evalua si la raiz es nula, en caso de que lo sea, imprime un mensaje de error y termina la ejecucion del metodo. Esto evita que se ejecute el metodo inordenRecursivo con un producto nulo.
//
//
//Buscar por id: El metodo buscar, evalua si la raiz es nula, en caso de que no lo sea, ejecuta el metodo buscarRecursivo.
//El metodo buscarRecursivo es el encargado de recorrer el arbol y buscar el producto con el id que le pasamos como parametro.
//Gracias a la logica del arbol, donde posicionamos los productos a la izquierda o derecha dependiendo de si su id es mayor o menor al nodo al padre. 
//No tenemos que recorrer todos los nodos del arbol, si no avanzar por las ramas por medio de comparaciones, lo que hace que la busqueda sea mucho mas rapida.
//la busqueda empieza y evalua si el id que buscamoss es mayor o menor a la raiz. si es menor significa que debe estar a la izquierda, si es mayor significa que solo puede estar en la derecha.
//En este ejemplo daremos por hecho de que es menor. asi que una vez comparemos los valores, el la condicion tiene otra condicion anidad que evalua si la izquierda de la raiz tiene un producto.
//en caso de que si, tenemos que buscar dentro de la izquierda, haber si ella tiene el id que buscamos. entonces llamamos otra vez el metodo, pero esta vez no evaluamos la raiz, si no la izquierda de la raiz.
//el metodo es igual, primero compara si nuestro id es mayor o menor que el id del id del producto que evaluamos. para asi saber si vamos por la izquierda o por la derecha. 
//como nuestros id sigue siendo menor, entonces evaluamos si la izquierda de este producto ya tiene un producto. en caso de que si, llamamos nuevamente el metodo y lo repetimos hasta que no hayan mas productos.
//
//este metodo solo puede terminar de 2 formas:
//1. el id coincide con algun id de algun producto, en ese caso imprime el id y nombre del producto encontrado.
//2. el id no ha coincidido con ningun id y llegamos a un producto que ya no tiene referencias izquierda o derecha, es decir que si no lo encontramos ahi, ya no hay mas en donde buscar.
//
//                               50    (raiz)
//                            /      \
//                           /        \
//                          25        75
//                         / \        / \
//                        10 30      60 90
//                       / \ 
//                      5  15
//
//Utilicemos nuevamente este ejemplo, supongamos que queremos buscar el id 15. 
//el metodo inicia en la raiz, como 15 es menor que 50, entonces se ejecuta esta condicion. Esta condicion contiene otra condicion, la cual evalua si la izquierda de 50 es nula. entonces como hay un producto (25)
//llamamos nuevamente el metodo pero esta vez evaluando la izquierda de 50, que es 25.
//succede lo mismo, 15 es menor que 25, y 25 tiene un producto a la izquierda (10), entonces llamamos nuevamente el metodo pero esta vez evaluando la izquierda de 25, que es 10.
//en este caso 15 es mayor que 10, entonces evaluamos la derecha de 10, que tiene un producto (15), entonces llamamos nuevamente el metodo pero esta vez evaluando la derecha de 10, que es 15.
//y es aqui en el metodo de 15 donde hayamos la condicion (actual.getId() == id) la cual evalua si el id del metodo y el id que buscamos son iguales. Entonces finalizamos la busqueda, imprimiendo el id y el nombre del producto.
//
//Imaginemos por un momento que el numero es el 17 y no el 15. se ejecuta todo el proceso, pero en el momento que llegue a 15 al ver que 17 es mayor que 15 y 15 no tiene un numero a su derecha, entonces finaliza la busqueda.
//Anunciando que el numero no se encontro en el arbol.
//
//Errores de busqueda: El primer metodo buscar, evalua si la raiz es nula, en caso de que lo sea, imprime un mensaje de error y termina la ejecucion del metodo. Esto evita que se ejecute el metodo buscarRecursivo con un producto nulo.
//
//
//


