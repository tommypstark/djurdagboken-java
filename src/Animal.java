import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Animal {

    private String name;
    private String species;
    private LocalDate birthDate;
    private List<WeightEntry> weightHistory = new ArrayList<>();

    public Animal(String name, String species, LocalDate birthDate) {
        this.name = name;
        this.species = species;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<WeightEntry> getWeightHistory() {
        return List.copyOf(weightHistory);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void printInfo() {
        Period age = Period.between(birthDate, LocalDate.now());
        WeightEntry latest = weightHistory.get(weightHistory.size() - 1);

        System.out.println("\nNamn:\t" + name);
        System.out.println("Art:\t" + species);
        System.out.println("Född:\t" + birthDate);
        System.out.println("Ålder:\t" + age.getYears() + " år, " + age.getMonths() + " månader");
        System.out.println("Vikt:\t" + latest.getWeight() + " g");
    }

    public void addWeightEntry(WeightEntry entry) {
        weightHistory.add(entry);
    }
}