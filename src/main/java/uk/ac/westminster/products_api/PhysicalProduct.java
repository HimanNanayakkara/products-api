package uk.ac.westminster.products_api;
//A PhysicalProduct IS-A Product because it is extended from its super class product (inheritance)
public class PhysicalProduct extends Product implements Discountable{
    private double weightKg;
    private String dimensions;
    private double discountedPrice;


    public PhysicalProduct(long id, String name, double price, double weightKg, String dimensions) {
        super(id,name,price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }
    public PhysicalProduct(){}

    @Override
    public String getSummary() {
        return "Physical Product "+getId()+ " weighs "+ weightKg;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public void applyDiscount(double rate) {
        double cappedRate = Math.min(rate, 0.20);
        discountedPrice = getPrice() * (1 - cappedRate);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
