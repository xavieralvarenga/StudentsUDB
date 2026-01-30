import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /**
         * Estructura recomendada: HashMap<Llave: Carnet, Valor: Nombre>
         * Esta estructura (Map) actuará como la parte de persistencia (BD)
         * */
        Map<Integer, String> alumnos = new HashMap<>();

        // Pruebas para métodos CRUD previo a crear el menú - [BORRAR]
        alumnos.put(101, "Usuario Alfa");
        alumnos.put(102, "Usuario Beta");

        // Uso de Scanner para recibir entradas del usuario
        Scanner input = new Scanner(System.in);

        // Recorrido de Map con Lambda antes de eliminar(pruebas) - [BORRAR]
        alumnos.forEach((c, n) -> {
            System.out.println("Carnet: " + c + ", Nombre: " + n);
        });

        eliminarAlumno(input, alumnos);

    }

    // --- MÉTODOS ENCAPSULADOS ---

    /**
     * Encapsulación del metodo de búsqueda de alumno por carnet
     * Esto facilita usar la lógica de búsqueda del alumno en el menu principal
     * El método recibe el Map de alumnos como parámetro
     * Para definir en que colección buscar y obtener el valor del nombre del alumno
     * */
    private static void buscarAlumno(Scanner input, Map<Integer, String> alumnos) {
        int carnet;

        //Ejemplo de busqueda de alumnos
        System.out.println("Apartado para buscar alumno por carnet: ");
        System.out.println("Digite el carnet del alumno que desea buscar: ");
        carnet = input.nextInt(); //Lee el carnet ingresado por el usuario y lo almacena en la variable carnet
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
    private static void eliminarAlumno(Scanner input, Map<Integer, String> alumnos) {

        int carnet = 0; // Inicializamos la variable para almacenar el carnet del alumno a eliminar
        boolean datoValido = false; // Bandera para controlar el bucle

        // Bucle de validación: se repetirá mientras 'datoValido' sea falso
        while (!datoValido) {
            try {
                System.out.println("Digite el carnet del alumno que desea eliminar: ");
                carnet = input.nextInt(); // Intenta leer el entero
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
}
