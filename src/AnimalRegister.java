import java.util.ArrayList;
import java.util.List;

public class AnimalRegister {

    private List<Animal> animals = new ArrayList<>();

    public void createAnimal(String name, String species, double age) {
        Animal animal = new Animal(name, species, age);
        animals.add(animal);

    }

    public void printAll() {
        if (animals.isEmpty()) {
            System.out.println("\n\u001B[91mDet finns inga sparade djur.\u001B[0m");
            return;
        }

        System.out.print("\n\u001B[92mVisar alla djur:\u001B[0m");

        for (Animal animal : animals) {
            animal.printInfo();
        }
    }

}
