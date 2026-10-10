import java.util.ArrayList;
import java.util.List;

public class AnimalRegister {

    private List<Animal> animals = new ArrayList<>();

    public void createAnimal(String name, String species, double age) {
        Animal animal = new Animal(name, species, age);
        animals.add(animal);

    }

    public void printAll() {
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            animal.printInfo();
        }
    }

}
