import java.util.Collection;
import java.util.HashSet;

public class ejemplocollection {

    public static void main(String[] args) {

        // Declaración de Collection usando HashSet
        Collection<String> miColeccion = new HashSet<>();

        // Agrega los elementos
        miColeccion.add("Manzana");
        miColeccion.add("Jocote");
        miColeccion.add("Guineo");
        miColeccion.add("Naranja");
        miColeccion.add("Manzana"); // No se agregará (duplicado)

        // Muestra los elementos
        System.out.println("Elementos en la colección:");
        System.out.println(miColeccion);

        // Elimina un elemento
        miColeccion.remove("Guineo");
        System.out.println("Después de eliminar  'Guineo':");
        System.out.println("nos quedan solo " + miColeccion);

        // Muestra el tamaño
        System.out.println("Cantidad de elementos: " + miColeccion.size());
    }
}
