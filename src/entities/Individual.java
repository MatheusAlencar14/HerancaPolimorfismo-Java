package entities;

public class Individual extends TaxPayer{

    private Double healthExpenditures;

    public Individual() {
        super();
    }

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double tax() {
        double tax = 0;
        if (getAnualIncome() < 20000.00) {
            tax = getAnualIncome() * 0.15;
        } else {
            tax = getAnualIncome() * 0.25;
        }

        if (getHealthExpenditures() > 0) {
            tax = tax - (getHealthExpenditures() * 0.50);
        }
        return tax;
    }
}
