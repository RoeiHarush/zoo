public class Tiger extends Animal {


    public Tiger(String name) {
        super("Tiger", name, "ROAR");
    }

    @Override
    public void eat(String food) {
        switch (food) {
            case "Banana" -> {
                System.out.println(super.getKind() + " is eating banana");
                points += 1;
            }
            case "Meat" -> {
                System.out.println(super.getKind() + " Eats Meat");
                points += 10;
            }
            case "Fish" -> {
                System.out.println(super.getKind() + " eats Fish");
                points += 10;
            }
            case "Chocolate" -> {
                System.out.println(super.getKind() + " can't eat chocolate");
                points -= 10;
            }
        }

    }
}


