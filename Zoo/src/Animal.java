public abstract class Animal {
    private String kind;
    private String name;
    private String sound;
    int points;

    public Animal(String kind, String name,String sound) {
        this.kind = kind;
        this.name = name;
        this.points = 0;
        this.sound=sound;
    }

    int getPoints() {
        return points;
    }

    String getName() {
        return name;
    }

    String getKind() {
        return kind;
    }
    public void makeSound(){
        System.out.println(sound);
    }

    public abstract void eat(String food);

}

