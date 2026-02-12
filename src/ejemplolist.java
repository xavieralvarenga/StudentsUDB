import java.util.ArrayList;
import java.util.List;

public class ejemplolist {

    public static void main(String[] args) {

        // Lista de estudiantes inscritos
        List<String> estudiantes = new ArrayList<>();

        // Agregar estudiantes
        estudiantes.add("Jhoan");
        estudiantes.add("Xavier");
        estudiantes.add("Andy");
        estudiantes.add("Edward");

        System.out.println(" Lista inicial de estudiantes:");
        mostrarLista(estudiantes);

        // Agregar estudiante con el mismo nombre ( LIST- Colección ordenada que permite duplicados)
        estudiantes.add(1, "Edward");
        System.out.println("\n Después de agregar a Edward :");
        mostrarLista(estudiantes);

        // Eliminar estudiante que se dio de baja (LIST - Elimina la primera ocurrencia del objeto)
        estudiantes.remove("Edward");
        System.out.println("\n Después de eliminar a Edward:");
        mostrarLista(estudiantes);

       

        // Mostrar cantidad total
        System.out.println("\n Total de estudiantes en la materia: " + estudiantes.size());
    }

    // metodo para mostrar la lista numerada
    public static void mostrarLista(List<String> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i));
        }
    }
}
