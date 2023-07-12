package entities;

public class ImportedProduct extends Product {

    private Double customsFee;

    public ImportedProduct() {
    }

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag() {
        return getName() + " R$: " + totalPrice() + " (Taxa alfandegária: R$ "
                + String.format("%.2f", customsFee) + ")";
    }

    public Double totalPrice() {
        return getPrice() + customsFee;
    }
}
