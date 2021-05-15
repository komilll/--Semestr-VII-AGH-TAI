package pl.agh.servicedatabase.persistence;

public class MealDatabaseRecord {
    public String name;
    public Double caloricity;

    public MealDatabaseRecord(String name, Double caloricity) {
        this.name = name;
        this.caloricity = caloricity;
    }
}
