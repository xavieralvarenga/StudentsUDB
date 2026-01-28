import java.util.*; // Importa todas las clases del paquete java.util para usar colecciones

public class Investigacion {
    public static void main(String[] args) {

        /* --------------------------------------------------------
         * COLLECTION (La interfaz raíz)
         * Nota: Usamos HashSet como implementación común. No permite duplicados.
         * -------------------------------------------------------- */

        /* Declaración */
        Collection<String> miColeccion = new HashSet<>();

        /* Asignación de valores */
        miColeccion.add("Elemento A");
        miColeccion.add("Elemento B");
        miColeccion.addAll(Arrays.asList("Elemento C", "Elemento D"));

        /* Eliminación de valores */
        miColeccion.remove("Elemento A"); // Elimina por objeto
        miColeccion.clear(); // Limpia toda la colección


        /* --------------------------------------------------------
         * LIST (Colección ordenada que permite duplicados)
         * Implementación común: ArrayList.
         * -------------------------------------------------------- */

        /* Declaración */
        List<String> miLista = new ArrayList<>();

        /* Asignación de valores */
        miLista.add("Java");
        miLista.add("Python");
        miLista.add(1, "C++"); // Inserta en un índice específico

        /* Eliminación de valores */
        miLista.remove(1); // Elimina por índice
        miLista.remove("Java"); // Elimina la primera ocurrencia del objeto


        /* --------------------------------------------------------
         * MAP (Estructura de Clave -> Valor)
         * No hereda de Collection, pero es parte del framework.
         * -------------------------------------------------------- */

        /* Declaración */
        Map<Integer, String> miMapa = new HashMap<>();

        /* Asignación de valores */
        miMapa.put(101, "Usuario Alfa");
        miMapa.put(102, "Usuario Beta");
        miMapa.putIfAbsent(103, "Usuario Gamma"); // Solo agrega si la clave no existe

        /* Eliminación de valores */
        miMapa.remove(101); // Elimina la entrada asociada a la clave 101

        // También se puede eliminar validando el valor:
        miMapa.remove(102, "Usuario Beta");
    }
}
