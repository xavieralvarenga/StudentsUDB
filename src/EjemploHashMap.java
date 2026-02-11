import java.util.HashMap;
import java.util.Map;

public class EjemploHashMap {

    /**
     * Programa para gestionar un diccionario de empleados. La clave será el ID (empleado)
     * Y el valor será su Nombre. El programa nos ayudará a repasar los siguientes puntos:
     *
     * 1. Declaración de un HashMap
     * 2. Agregar valores a un HashMap
     * 3. Eliminar valores de un HashMap
     * 4. Mostrar los valores del HashMap (Con estructura y sin estructura)
     *
     * */

    public static void main(String[] args) {

        // 1. DECLARACIÓN
        // Usamos la interfaz Map y la implementación HashMap
        Map<Integer,String> listaEmpleados = new HashMap<Integer,String>();

        // 2. ASIGNACIÓN DE VALORES (put) - Empleado ID -> Nombre
        listaEmpleados.put(101, "Xavier Alvarenga");
        listaEmpleados.put(102, "Francisco Cortéz");
        listaEmpleados.put(103, "Carla Soto");

        //Impresión inicial de claves y valores sin estructura
        System.out.println("--- Empleados iniciales ---");
        System.out.println(listaEmpleados);

        // 3. ELIMINACIÓN DE VALORES (remove)
        listaEmpleados.remove(102);

        // 4. MOSTRAR RESULTADOS
        System.out.println("\n--- Diccionario después de cambios ---");

        // Iteramos para mostrarlo de forma elegante usando forEach y una expresión lambda
        /**
         * forEach es un método que permite recorrer colecciones o mapas ejecutando una acción para cada elemento.
         *
         * Una lambda es una función anónima que se puede usar para implementar métodos funcionales de forma concisa.
         * (parámetro) -> { cuerpo de la función }
         * */
        listaEmpleados.forEach((clave, valor) -> {
            System.out.println("ID: " + clave + " -> Nombre: " + valor);
        });
    }
}
