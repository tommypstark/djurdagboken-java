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

    public void findAnimal(String name) {
        boolean found = false;

        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                System.out.print("\n\u001B[92mDjur hittat:\u001B[0m");
                animal.printInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("\n\u001B[91mInget djur hittades.\u001B[0m");
        }
    }

    public void removeAnimal(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                animals.remove(animal);
                System.out.print("\n\u001B[92mDjuret har tagits bort.\u001B[0m\n");
                return;
            }
        }

        System.out.print("\n\u001B[91mInget djur hittades.\u001B[0m\n");
    }


}
