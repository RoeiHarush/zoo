
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        System.out.println("Welcome to the Virtual zoo");
        System.out.println("in order to create new animal press '1'");
        System.out.println("in order to feed animal press'2'");
        System.out.println("in order to print information about animal press'3'");
        System.out.println("to see the weakest animal in the zoo press '4'");
        System.out.println("to see the strongest animal in the zoo press '5'");
        System.out.println("to see all the statistics about the animals in the zoo press '6'");
        System.out.println("to see all the animals in the zoo press '7'");
        System.out.println("in order to exit the code press '8'");
        while (!input.equals("8")) {
            input = scanner.nextLine();
            switch (input) {
                case "1" -> createAnimal();
                case "2" -> feedAnimals(animalMap);
                case "3" -> getAnimal(animalMap);
                case "4" -> printWeakest(animalMap);
                case "5"-> printStrongest(animalMap);
                case "6"-> animalStatistics(animalMap);
                case "7" -> printAnimals(animalMap);

            }

        }


    }

    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Animal> animalMap = new HashMap<>();


    private static void createAnimal() {
        String kind;
        String name;
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
    }

    private static void printAnimals(Map<String, Animal> animalMap) {
        System.out.println("List of animals:");
        for (Map.Entry<String, Animal> entry : animalMap.entrySet()) {
            String name = entry.getKey();
            Animal animal = entry.getValue();
            System.out.println(name + ": " + animal.getKind() + " has " + animal.getPoints() + " Points");
        }
    }
    private static void animalStatistics(Map<String, Animal> animalMap) {
        Map<String, Integer> animalCount = new HashMap<>();
        int totalCount = 0;
        int totalPoints = 0;

        for (Map.Entry<String, Animal> entry : animalMap.entrySet()) {
            Animal animal = entry.getValue();
            String kind = animal.getKind();
            animalCount.put(kind, animalCount.getOrDefault(kind, 0) + 1);
            totalCount++;
            totalPoints += animal.getPoints();
        }

        System.out.println("Number of animals of each kind:");
        for (Map.Entry<String, Integer> entry : animalCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Total number of animals: " + totalCount);
        System.out.println("Average points of all animals: " + (totalPoints / totalCount));

        Animal weakestAnimal = null;
        int weakestPoints = Integer.MAX_VALUE;

        for (Map.Entry<String, Animal> entry : animalMap.entrySet()) {
            Animal currentAnimal = entry.getValue();
            int currentPoints = currentAnimal.getPoints();

            if (currentPoints < weakestPoints) {
                weakestAnimal = currentAnimal;
                weakestPoints = currentPoints;
            }
        }

        if (weakestAnimal == null) {
            System.out.println("Error: no animals found in the map.");

        }
        Animal strongestanimal = null;
        int strongestPoints = Integer.MIN_VALUE;

        for (Map.Entry<String, Animal> entry : animalMap.entrySet()) {
            Animal currentAnimal = entry.getValue();
            int currentPoints = currentAnimal.getPoints();

            if (currentPoints > strongestPoints) {
                strongestanimal = currentAnimal;
                strongestPoints = currentPoints;
            }
        }

        if (strongestanimal == null) {
            System.out.println("Error: no animals found in the map.");
        }


    }
    private static void printWeakest(Map<String, Animal> animalMap) {
        Animal weakestAnimal = null;
        int weakestPoints = Integer.MAX_VALUE;

        for (Map.Entry<String, Animal> entry : animalMap.entrySet()) {
            Animal currentAnimal = entry.getValue();
            int currentPoints = currentAnimal.getPoints();

            if (currentPoints < weakestPoints) {
                weakestAnimal = currentAnimal;
                weakestPoints = currentPoints;
            }
        }

        if (weakestAnimal == null) {
            System.out.println("Error: no animals found in the map.");
            return;
        }

        System.out.println("The weakest animal is: " + weakestAnimal.getName());
        System.out.println("With points: " + weakestPoints);
    }
    private static void printStrongest(Map<String, Animal> animalMap) {
        Animal strongestanimal = null;
        int strongestPoints = Integer.MIN_VALUE;

        for (Map.Entry<String, Animal> entry : animalMap.entrySet()) {
            Animal currentAnimal = entry.getValue();
            int currentPoints = currentAnimal.getPoints();

            if (currentPoints > strongestPoints) {
                strongestanimal = currentAnimal;
                strongestPoints = currentPoints;
            }
        }

        if (strongestanimal == null) {
            System.out.println("Error: no animals found in the map.");
            return;
        }

        System.out.println("The Strongest animal is: " + strongestanimal.getName());
        System.out.println("With points: " + strongestPoints);
    }

    private static void getAnimal(Map<String, Animal> animalMap) {
        String animalName = scanner.nextLine();
        if (animalMap.containsKey(animalName)) {
            Animal animal = animalMap.get(animalName);
            System.out.println(animalName + ": " + animal.getKind() + " has " + animal.getPoints() + " Points");
        } else {
            System.out.println("Animal not found");

        }

    }


    private static void feedAnimals(Map<String, Animal> animalMap) {
        System.out.println("Now feed your animals");
        System.out.println();
        System.out.println("Which animal do you want to feed?");
        String animalName = scanner.nextLine();
        Animal animal = animalMap.get(animalName);

        if (animal == null) {
            System.out.println("Error: animal not found in the map.");
            return;
        }

        System.out.println("What food do you want to give the animal?");
        String food = scanner.nextLine();

        try {
            animal.eat(food);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: invalid food.");
        }
    }


}