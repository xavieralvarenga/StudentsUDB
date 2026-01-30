import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /**
         * Estructura recomendada: HashMap<Llave: Carnet, Valor: Nombre>
         * Esta estructura (Map) actuará como la parte de persistencia (BD)
         * */
        Map<String, String> alumnos = new HashMap<>();

        // Uso de Scanner para recibir entradas del usuario
        Scanner input = new Scanner(System.in);

        //Variables
        String nombre;
        String carnet;

        //Variable a utilizar en el menu en validación de switch
        int opcion = 0;

    }

    /**
     * Encapsulación del metodo de búsqueda de alumno por carnet
     * Esto facilita usar la lógica de búsqueda del alumno en el menu principal
     * El método recibe el Map de alumnos como parámetro
     * Para definir en que colección buscar y obtener el valor del nombre del alumno
     * */
    private static void buscarAlumno(Scanner input, Map<String, String> alumnos) {
        String carnet;

        //Ejemplo de busqueda de alumnos
        System.out.println("Apartado para buscar alumno por carnet: ");
        System.out.println("Digite el carnet del alumno que desea buscar: ");
        carnet = input.nextLine(); //Lee el carnet ingresado por el usuario y lo almacena en la variable carnet

        // Verificamos si la llave (carnet) existe dentro del mapa
        if(alumnos.containsKey(carnet)){
           String nombreAlumno = alumnos.get(carnet);
           System.out.println("Carnet : " + carnet);
           System.out.println("Nombre : " + nombreAlumno);

        }else{
            System.out.println("Alumno no encontrado");
        }
    }
}
