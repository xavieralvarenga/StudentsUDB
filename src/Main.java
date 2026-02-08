import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
         * Estructura recomendada: HashMap<Llave: Carnet, Valor: Nombre>
         * Esta estructura (Map) actuará como la parte de persistencia (BD)
         * */
        Map<String, String> alumnos = new HashMap<>();
        // Uso de Scanner para recibir entradas del usuario
        Scanner input = new Scanner(System.in);
        int opcion;

        //Apartado para el menu
        do{
            //Aqui tiene que ir el menu
            System.out.println("\n====================================");
            System.out.println("      MENÚ DE GESTIÓN (CRUD)        ");
            System.out.println("====================================");
            System.out.println("1. Agregar alumno");
            System.out.println("2. Buscar alumno");
            System.out.println("3. Actualizar alumno");
            System.out.println("4. Eliminar alumno");
            System.out.println("5. Mostrar todos");
            System.out.println("6. Salir");
            System.out.println("====================================");

            try {
                System.out.print("Ingrese el opcion: ");
                opcion = input.nextInt();

                switch (opcion) {
                    case 1:
                        //Crear el apartado para agregar alumno
                        System.out.print("Ingrese el alumno: ");
                        System.out.print("Ingrese el nombre: ");
                        String nombre = input.next();
                        System.out.print("Ingrese el carnet: ");
                        String carnet = input.next();

                        alumnos.put(carnet, nombre);
                        System.out.println("El alumno se ha agregado correctamente");
                        break;
                    case 2:
                        //apartado para buscar alumnos
                        buscarAlumno(input, alumnos);
                        break;
                    case 3:
                        //apartado para actualizar alumno
                        actualizarAlumno(input, alumnos);
                        break;
                    case 4:
                        //apartado para eliminar alumno
                        eliminarAlumno(input,alumnos);
                        break;
                    case 5:
                        //mostrar todos los alumnos
                        mostrarAlumnos(alumnos);
                        break;
                }

            }catch (Exception e) {
                System.out.println("Error: Por favor, ingresa solo números.");
                //Limpia el escaner
                input.next();
                //Reinicio del proceso
                opcion = 0;
            }
        }while(opcion != 6);


    }

    // --- MÉTODOS ENCAPSULADOS ---

    /**
     * Encapsulación del metodo de búsqueda de alumno por carnet
     * Esto facilita usar la lógica de búsqueda del alumno en el menu principal
     * El método recibe el Map de alumnos como parámetro
     * Para definir en que colección buscar y obtener el valor del nombre del alumno
     * */
    private static void buscarAlumno(Scanner input, Map<String, String> alumnos) {


        //Ejemplo de busqueda de alumnos
        System.out.println("Apartado para buscar alumno por carnet: ");
        System.out.println("Digite el carnet del alumno que desea buscar: ");
        String carnet = input.next(); //Lee el carnet ingresado por el usuario y lo almacena en la variable carnet
        input.nextLine();

        // Verificamos si la llave (carnet) existe dentro del mapa
        if(alumnos.containsKey(carnet)){
           String nombreAlumno = alumnos.get(carnet);
           System.out.println("Carnet : " + carnet);
           System.out.println("Nombre : " + nombreAlumno);

        }else{
            System.out.println("Alumno no encontrado");
        }
    }

    /**
     * Realiza la eliminación de un estudiante del registro utilizando su carnet como identificador.
     * * Aplicando buenas prácticas de POO:
     * 1. Valida la existencia del alumno antes de confirmar la acción.
     * 2. Gestiona el buffer del Scanner para evitar saltos de línea inesperados.
     * 3. Utiliza tipos de retorno de la API de Map para verificar el éxito de la operación.
     */
    private static void eliminarAlumno(Scanner input, Map<String, String> alumnos) {

        String carnet = input.nextLine(); // Inicializamos la variable para almacenar el carnet del alumno a eliminar
        boolean datoValido = false; // Bandera para controlar el bucle

        // Bucle de validación: se repetirá mientras 'datoValido' sea falso
        while (!datoValido) {
            try {
                System.out.println("Digite el carnet del alumno que desea eliminar: ");
                carnet = input.next(); // Intenta leer el entero
                input.nextLine();         // Limpia el buffer (el "Enter" sobrante)
                datoValido = true;        // Si llega aquí, el dato es correcto y saldrá del bucle
            } catch (Exception e) {
                // Si el usuario ingresa letras, se dispara esta sección
                System.out.println("Error: El carnet debe ser un valor numérico. Intente de nuevo.");
                input.nextLine();         // LIMPIEZA CLAVE: elimina el texto erróneo del buffer
            }
        }
        // Al salir del bucle, ya tenemos la seguridad de que 'carnet' es un número válido.

        /* *  Lógica de Negocio: Intentar remover el elemento.
         * El método .remove(key) de Map devuelve el valor eliminado si existe,
         * o devuelve 'null' si la llave no fue encontrada.
         */
        String alumnoEliminado = alumnos.remove(carnet);

        // Salida de datos: Mensajes condicionales según el requerimiento de la guía
        if (alumnoEliminado != null) {
            // Mensaje de éxito si el retorno no fue nulo
            System.out.println("Eliminación de alumno exitosa. (Se eliminó a: " + alumnoEliminado + ")");
        } else {
            // Mensaje específico requerido para cuando el registro no existe
            System.out.println("Alumno no ha sido encontrado en el sistema.");
        }

        //  Fase de depuración (Temporal): Visualización mediante Java 8 Lambda
        // Solo se ejecuta si hay elementos restantes en el mapa.
        if (!alumnos.isEmpty()) {
            System.out.println("\n--- Registros restantes en el sistema ---");
            alumnos.forEach((id, nombre) ->
                    System.out.println("Carnet: " + id + " | Alumno: " + nombre)
            );
        }
    }

    /*
    *   Metodo para mostrar/listar todos los alumnos
    *   Aplicando Guard Clause para validar si el HashMap de alumnos esta vacio antes de mostrar informacion
    *  */
    private static void mostrarAlumnos(Map<String, String> alumnos) {
        if (alumnos.isEmpty()) {
            System.out.print("\n No hay alumnos ingresados en el sistema");
            return;
        }

        System.out.print("\n--- Alumnos ingresados en el sistema ---");

        alumnos.forEach((id, nombre) -> System.out.print("\n Carnet: " + id + " | Alumno: " + nombre));
    }

    private static void actualizarAlumno(Scanner input, Map<String, String> alumnos) {
        System.out.println("\n--- Apartado para actualizar datos de alumno ---");
        input.nextLine();
        System.out.print("Digite el carnet del alumno que desea modificar: ");
        String carnet = input.nextLine();
        if(alumnos.containsKey(carnet)){
            System.out.println("Alumno encontrado: " + alumnos.get(carnet));
            System.out.print("Ingrese el nuevo nombre completo: ");
            String nuevoNombre = input.nextLine();

            alumnos.put(carnet, nuevoNombre);
            System.out.println("Datos actualizados con exito ");
        }else {
            System.out.println("Alumno no encontrado");
        }
    }
}
