
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String kind;
        String name;
        // TODO; enable user feeding animals
        //  System.out.println("would you like to feed your animal ?");
        //  System.out.println("yes/no");
        // create function that will return the points of each animal;


        System.out.println("Welcome to the Virtual zoo");
        System.out.println("To continue type 'continue'");


        Map<String, Animal> animalMap = new HashMap<>();

        do {
            System.out.println("Tiger or Cat");
            kind = scanner.nextLine();

            if (kind.equals("Tiger")) {
                System.out.println("name your tiger");
                name = scanner.nextLine();
                Animal tiger = new Tiger(name);
                animalMap.put(name, tiger);
            } else if (kind.equals("Cat")) {
                System.out.println("name your cat");
                name = scanner.nextLine();
                Animal cat = new Cats(name);
                animalMap.put(name, cat);
            }


            System.out.println("Would you like to create another animal? (yes/no)");
            input = scanner.nextLine();

        } while (input.equals("yes"));
        printAnimals(animalMap);


    }

    private static void printAnimals(Map<String, Animal> animalMap) {
        System.out.println("List of animals:");
        for (Map.Entry<String, Animal> entry : animalMap.entrySet()) {
            String name = entry.getKey();
            Animal animal = entry.getValue();
            System.out.println(name + ": " + animal.getKind());
        }
    }

}