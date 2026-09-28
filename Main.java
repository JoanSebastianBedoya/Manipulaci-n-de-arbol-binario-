import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolInventario inventario = new ArbolInventario();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("=".repeat(60));
        System.out.println("    Bienvenido al sistema de inventario de productos.");
        System.out.println("=".repeat(60));
        

        do {
            System.out.println("\n" + "=".repeat(60));
            System.out.print("Seleccione una opción: ");
            System.out.println("\n\n1. Insertar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Buscar producto por ID");
            System.out.println("0. Salir");
            System.out.println("=".repeat(60) + "\n");

            
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese el ID del producto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\nIngrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    Producto nuevoProducto = new Producto(id, nombre); //creamos el producto, utilizando el constructor de la clase Producto, pasandole como parametros el id y nombre que el usuario ingreso.
                    inventario.insertar(nuevoProducto); // llamamos el metodo que ingresa el producto al arbol, pasandole como parametro el producto que acabamos de crear.
                    break;
                case 2:
                    System.out.println("\n" + "=".repeat(60));
                    System.out.println("Inventario: \n");
                    inventario.inorden(); //llamamos el metodo que recorre el arbol y muestra los productos en orden, no se ingresan parametros. 
                    break;
                case 3:
                    System.out.print("\nIngrese el ID del producto a buscar: ");
                    int idBusqueda = scanner.nextInt();
                    inventario.buscar(idBusqueda);//llamamos el metodo que busca un producto por su id, pasandole como parametro el id que el usuario ingreso.
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0); //el bucle se ejecuta mientras la opcion no sea 0, utilizando la estructura do-while.

        scanner.close();
    }
}
