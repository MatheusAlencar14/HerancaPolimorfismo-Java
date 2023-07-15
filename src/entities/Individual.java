package entities;

public class Individual extends TaxPayer{

    private Double healthExpenditures;

    public Individual() {
        super();
    }

    public Individual(String name, Double annualIncome, Double healthExpenditures) {
        super(name, annualIncome);
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
        if (getAnnualIncome() < 20000.00) {
            tax = getAnnualIncome() * 0.15;
        } else {
            tax = getAnnualIncome() * 0.25;
        }
        //Expressão condicional ternária: Mesmo resultado do If acima, porém em uma linha ***
        //double tax = (getAnnualIncome() < 20000.00) ? getAnnualIncome() * 0.15 : getAnnualIncome() * 0.25;

        if (getHealthExpenditures() > 0) {
            tax -= getHealthExpenditures() * 0.50;
        }
        return tax;
    }
}
