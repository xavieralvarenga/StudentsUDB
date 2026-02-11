EjemploCollection.java
import java.util.Collection;
import java.util.HashSet;

public class EjemploCollection {

    public static void main(String[] args) {

        // Declaración de Collection usando HashSet
        Collection<String> miColeccion = new HashSet<>();

        // Agrega elementos
        miColeccion.add("Manzana");
        miColeccion.add("Banana");
        miColeccion.add("Naranja");
        miColeccion.add("Manzana"); // No se agregará (duplicado)

        // Muestra elementos
        System.out.println("Elementos en la colección:");
        System.out.println(miColeccion);

        // Elimina un elemento
        miColeccion.remove("Banana");
        System.out.println("Después de eliminar 'Banana':");
        System.out.println(miColeccion);

        // Muestra el tamaño
        System.out.println("Cantidad de elementos: " + miColeccion.size());
    }
}
