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
        System.out.println("\nNamn:\t" + name);
        System.out.println("Art:\t" + species);
        System.out.println("Ålder:\t" + age + " år");
    }
}
