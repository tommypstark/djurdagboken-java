public class Animal {

    private String name;
    private String species;
    private double age;

    public Animal(String name, String species, double age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public double getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println("\nNamn:\t" + name);
        System.out.println("Art:\t" + species);
        System.out.println("Ålder:\t" + age + " år");
    }
}
