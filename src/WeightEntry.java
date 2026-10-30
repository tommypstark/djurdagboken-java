import java.time.LocalDate;

public class WeightEntry {
    private LocalDate date;
    private int weight;

    public WeightEntry(LocalDate date, int weight) {
        this.date = date;
        this.weight = weight;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getWeight() {
        return weight;
    }
}