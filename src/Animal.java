public class Animal {

    //privata fält:
    private String name;
    private String species;
    private double age;

    //konstruktor:
    public Animal(String name, String species, double age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    //getters:
    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public double getAge() {
        return age;
    }

    //visa info:
    public void printInfo() {
        System.out.println("Namn: " + name);
        System.out.println("Art: " + species);
        System.out.println("Ålder: " + age);
    }
}
