**Lógica del árbol:**
la lógica del árbol binario, consiste en posicionar los elementos en una dirección basándonos en si el id del producto es mayor o menor al id de la raíz
Y posteriormente, si es mayor o menor al id del nodo actual, al que llamaremos padre. la ruta inicial de los números se define por la comparación con la raíz y continua con la comparacion
de los nodos que se halle en el camino. 
Dentro del árbol, hay nodos que pueden contener números mayores a el, estos se posicionaran a la derecha del mismo, por lo que podemos encontrarnos con nodos hijos con numero mayores
a su padre. (en este caso el 49 se encuentra mas abajo del 25, pero en recorridos como el inorden, se imprimen primero los menores)

                              50    (raíz)
                           /      \
                          25        x
                         / \       /  \
                        x   49     x    x

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

**Insertar:**
El método insertar, sera quien nos permita agregar un nuevo producto al árbol. El comportamiento de la inserción busca evaluar la existencia de un producto en la izquierda o derecha,
en caso de que ya exista un producto en alguna de la referencia correspondiente se recicla el método evaluando el siguiente nodo. En caso de que no exista un producto, se asigna
el nuevo producto a la izquierda o derecha de el nodo evaluado, siendo esta asignación la entrada del producto al árbol.

                              50    (raíz)
                           /      \
                          25       75
                         / \       / \
                        10 30     60  90

El método insertar se divide en dos partes:

**1. Insertar:** Este método evalúa si la raíz es nula, es decir si hay algún numero dentro del árbol. este método se ejecuta siempre ya que sera también el método de activación de nuestro segundo método.

**2. InsertarRecursivo:** Este método inicia una vez se comprobó si existía previamente una raíz y es quien se encarga de comparar los productos nuevos con los existentes,
basandonse en esta comparativa para ubicarlos a la izquierda o derecha.
La primera condición evalúa si el id del nuevo producto es menor al id del producto actual, si no se cumple esta condición (else) significa que el id del nuevo producto es mayor al id del producto actual.
Dentro de estas condiciones, anidamos otra condición, la cual evalúa si la referencia izquierda o derecha del producto actual es nula o si ya tiene un producto. 
En caso de que sea nula, asignamos el nuevo producto a esa referencia y en caso de que ya haya un id, se ejecuta el método nuevamente pero esta vez el Producto actual no es la raíz si no la referencia izquierda o derecha. 
Cada vez que haya un producto en las referencias, el método se llamara nuevamente actualizando su parámetro producto actual por el de el nodo que estamos evaluando en ese ciclo.
Este escenario ocurre en los 2 casos tanto si el id del nuevo producto es menor o mayor al id del producto actual, ya que en ambos casos, si la referencia izquierda o derecha no es nula, se ejecutara nuevamente el método con el producto actual actualizado.
   
<p align="center">
  <img width="300" alt="imagen" src="https://github.com/user-attachments/assets/10d25077-06f4-4e03-b543-58646efe3e37" />
  <img width="300" alt="imagen" src="https://github.com/user-attachments/assets/d641fb96-4071-4f87-8bf5-123bb1f262f5" />
  <img width="300" alt="imagen" src="https://github.com/user-attachments/assets/4373fdc2-96d7-4780-93f1-121e39f6179d" />
</p>
          
Errores de inserción: En caso de que el id registrado ya existe, el método no modifica las referencias izquierda o derecha. Por el contrario, imprime un mensaje de error y termina la ejecución del método. Esto evita que se creen nodos duplicados en el árbol.
   
<p align="center">
  <img width="500" height="200" alt="imagen" src="https://github.com/user-attachments/assets/2fed0b3a-860b-4048-8bf4-d7be47f59d88" />
</p>
   
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
    
**Recorrer inorden:**
El método inorden evalúa si la raíz es nula, caso contrario, ejecuta el método inordenRecursivo. el método inordenRecursivo es quien se encarga de recorrer el árbol y mostrar los datos de los productos en orden.
Como explicamos anteriormente, la lógica del inorden es: Izquierda (menor que el padre) > Padre > Derecha (mayor que el padre).
el método inicia y evalúa si la izquierda tiene un producto (!=null) si es así, inicia otro método inordenRecursivo, pasando como parámetro el producto que se hallaba a la izquierda.
cada vez que llamemos el método va a entrar en todos los nodos izquierdos hasta que llegue a un nodo que no tenga un producto a la izquierda, en ese momento imprimirá el id y nombre del producto actual.
Una vez lo imprima va a evaluar si el producto actual tiene un producto a la derecha, si es así, ejecutara nuevamente el método inordenRecursivo pasando como parámetro el producto que se hallaba a la derecha.

                               50    (raíz)
                            /      \
                           /        \
                          25        75
                         / \        / \
                        10 30      60 90
                       / \ 
                      5  15

Usemos como ejemplo este árbol, la primera ejecución del método inicia en la raíz (50). entonces evalúa si la izquierda tiene un producto.
si hay un producto a la izquierda, ejecuta el método pero esta vez evaluamos la izquierda de 50, que es 25.
cuando evaluemos 25, ejecutamos, nuevamente el método y evaluamos si 25 tiene un producto a la izquierda, que es 10.
cuando evaluemos 10, ejecutamos nuevamente el método y evaluamos si 10 tiene un producto a la izquierda, que es 5.
cuando evaluemos 5, este ya no tiene un producto a su izquierda, entonces imprimimos el id de y el nombre de 5 (impresión: 5).
aunque ejecutemos otros métodos esto no interrumpe los métodos ejecutados anteriormente.
El método 10 sigue ejecutándose, entonces como ya termino el método de 5 salta a la siguiente linea de el método de 10, que es imprimir el id y nombre de 10 (impresión: 5, 10).
el método de 10 tiene una 3 linea, que evalúa si hay un producto a la derecha, si es así ejecuta nuevamente el método pero esta vez evaluando la derecha de 10, que es 15.
el método de 15 evalúa si tiene elementos a la izquierda, en caso de que no imprime el id y nombre de 15 (impresión: 5, 10, 15) y evalúa si tiene elementos a la derecha, en caso de que no termina el método.
cuando el método 10 termina en su totalidad (evaluó 5 (izquierda), imprimió 10, evaluó 15 (derecha)).
el método 25 sigue con su siguiente linea que es imprimir el id y nombre de 25 (impresión: 5, 10, 15, 25), luego evalúa si hay un producto a la derecha, si es así ejecuta nuevamente el método pero esta vez evaluando la derecha de 25, que es 30.
30 no tiene elementos a la izquierda, entonces imprime el id y nombre de 30 (impresión: 5, 10, 15, 25, 30) y evalúa si tiene elementos a la derecha, en caso de que no termina el método.
y una vez termine el método de 30, termina también el método de 25 y el método inicial que fue con la raíz sigue su curso, imprime y evalúa su derecha. Siguiendo exactamente la misma lógica.

  
  <p align="center">
    <img width="557" height="495" alt="imagen" src="https://github.com/user-attachments/assets/460bd90f-150a-490d-ad01-7cd8c1188e16" />
  </p>
         
**Errores de inorden:** El primer método inorden, evalúa si la raíz es nula, en caso de que lo sea, imprime un mensaje de error y termina la ejecución del método. Esto evita que se ejecute el método inordenRecursivo con un producto nulo.
                     
<p align="center">
  <img width="559" height="226" alt="imagen" src="https://github.com/user-attachments/assets/4fc83fea-e145-4339-9184-895743d8e6e3" />
</p>
   
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
    
**Buscar por id:** 
El método buscar, evalúa si la raíz es nula, en caso de que no lo sea, ejecuta el método buscarRecursivo.
El método buscarRecursivo es el encargado de recorrer el árbol y buscar el producto con el id que le pasamos como parámetro.
Gracias a la lógica del árbol, donde posicionamos los productos a la izquierda o derecha dependiendo de si su id es mayor o menor al nodo al padre. 
No tenemos que recorrer todos los nodos del árbol, si no avanzar por las ramas por medio de comparaciones, lo que hace que la búsqueda sea mucho mas rápida.
la búsqueda empieza y evalúa si el id que buscamos es mayor o menor a la raíz. si es menor significa que debe estar a la izquierda, si es mayor significa que solo puede estar en la derecha.
En este ejemplo daremos por hecho de que es menor. así que una vez comparemos los valores, el la condición tiene otra condición anidad que evalúa si la izquierda de la raíz tiene un producto.
en caso de que si, tenemos que buscar dentro de la izquierda, haber si ella tiene el id que buscamos. entonces llamamos otra vez el método, pero esta vez no evaluamos la raíz, si no la izquierda de la raíz.
el método es igual, primero compara si nuestro id es mayor o menor que el id del id del producto que evaluamos. para así saber si vamos por la izquierda o por la derecha. 
como nuestros id sigue siendo menor, entonces evaluamos si la izquierda de este producto ya tiene un producto. en caso de que si, llamamos nuevamente el método y lo repetimos hasta que no hayan mas productos.

**Este método solo puede terminar de 2 formas:**
1. El id coincide con algún id de algún producto, en ese caso imprime el id y nombre del producto encontrado.
2. El id no ha coincidido con ningún id y llegamos a un producto que ya no tiene referencias izquierda o derecha, es decir que si no lo encontramos ahí, ya no hay mas en donde buscar.

                               50    (raíz)
                            /      \
                           /        \
                          25        75
                         / \        / \
                        10 30      60 90
                       / \ 
                      5  15

Utilicemos nuevamente este ejemplo, supongamos que queremos buscar el id 15. 
el método inicia en la raíz, como 15 es menor que 50, entonces se ejecuta esta condición. Esta condición contiene otra condición, la cual evalúa si la izquierda de 50 es nula. entonces como hay un producto (25)
llamamos nuevamente el método pero esta vez evaluando la izquierda de 50, que es 25.
sucede lo mismo, 15 es menor que 25, y 25 tiene un producto a la izquierda (10), entonces llamamos nuevamente el método pero esta vez evaluando la izquierda de 25, que es 10.
en este caso 15 es mayor que 10, entonces evaluamos la derecha de 10, que tiene un producto (15), entonces llamamos nuevamente el método pero esta vez evaluando la derecha de 10, que es 15.
y es aquí en el método de 15 donde hayamos la condición (actual.getId() == id) la cual evalúa si el id del método y el id que buscamos son iguales. Entonces finalizamos la búsqueda, imprimiendo el id y el nombre del producto.

Imaginemos por un momento que el numero es el 17 y no el 15. se ejecuta todo el proceso, pero en el momento que llegue a 15 al ver que 17 es mayor que 15 y 15 no tiene un numero a su derecha, entonces finaliza la búsqueda.
Anunciando que el numero no se encontró en el árbol. 
           
            
<p align="center">
  <img width="425" height="880" alt="imagen" src="https://github.com/user-attachments/assets/09642549-d075-47ca-807c-16e476c992b9" />
  <img width="425" height="880" alt="imagen" src="https://github.com/user-attachments/assets/6122958a-6634-47d5-82c7-a461a61ac418" />
</p>

**Errores de búsqueda:** El primer método buscar, evalúa si la raíz es nula, en caso de que lo sea, imprime un mensaje de error y termina la ejecución del método. Esto evita que se ejecute el método buscarRecursivo con un producto nulo.
                      
<p align="center">
  <img width="557" height="192" alt="imagen" src="https://github.com/user-attachments/assets/4046dea8-162d-490b-b9bb-23df2e29cca9" />
</p>
             
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
       
**Video:**
https://drive.google.com/file/d/1bLT2nMLMRlajJFN8j5d9MRA5wMcLFpOV/view?usp=sharing
