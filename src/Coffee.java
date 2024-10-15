/**
 * Represents a coffee product with details such as name, price, weight, volume, and quality rating.
 * The class also provides methods to calculate total weight, total volume, and price/weight ratio.
 */
public class Coffee {
    /** The name of the coffee product. */
    protected String name;
    
    /** The price of the coffee product. */
    protected double price;
    
    /** The weight of the coffee content. */
    protected double coffeeWeight;
    
    /** The weight of the packaging. */
    protected double packagingWeight;
    
    /** The volume of the coffee content. */
    protected double coffeeVolume;
    
    /** The volume of the packaging. */
    protected double packagingVolume;
    
    /** The quality rating of the coffee product, rated from 0 to 10. */
    protected int qualityRating;

    /**
     * Constructs a new Coffee object with the specified properties.
     *
     * @param name the name of the coffee product
     * @param price the price of the coffee product
     * @param coffeeWeight the weight of the coffee content
     * @param packagingWeight the weight of the packaging
     * @param coffeeVolume the volume of the coffee content
     * @param packagingVolume the volume of the packaging
     * @param qualityRating the quality rating of the coffee product, rated from 0 to 10
     * @throws NullPointerException if the name is null or empty
     * @throws IllegalArgumentException if price is <= 0, or if any weight or volume is negative,
     *                                  or if quality rating is not between 0 and 10
     */
    public Coffee(String name, double price, double coffeeWeight, double packagingWeight,
                  double coffeeVolume, double packagingVolume, int qualityRating) {
        setName(name);
        setPrice(price);
        setCoffeeWeight(coffeeWeight);
        setPackagingWeight(packagingWeight);
        setCoffeeVolume(coffeeVolume);
        setPackagingVolume(packagingVolume);
        setQualityRating(qualityRating);
    }

    /**
     * Returns the state of the coffee (e.g., "Ground", "Whole Bean").
     *
     * @return the state of the coffee, default is "Ground"
     */
    public String getState() {
        return "Ground";
    }

    /**
     * Calculates and returns the price-to-weight ratio of the coffee product.
     *
     * @return the price-to-weight ratio
     * @throws ArithmeticException if total weight is zero
     */
    public double getPriceWeightRatio() {
        double totalWeight = getTotalWeight();
        if (totalWeight == 0) {
            throw new ArithmeticException("Total weight cannot be zero when calculating price/weight ratio.");
        }
        return price / totalWeight;
    }

    /**
     * Calculates and returns the total weight of the coffee product (coffee + packaging).
     *
     * @return the total weight of the coffee product
     */
    public double getTotalWeight() {
        return coffeeWeight + packagingWeight;
    }

    /**
     * Calculates and returns the total volume of the coffee product (coffee + packaging).
     *
     * @return the total volume of the coffee product
     */
    public double getTotalVolume() {
        return coffeeVolume + packagingVolume;
    }

    /**
     * Returns the name of the coffee product.
     *
     * @return the name of the coffee product
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the coffee product.
     *
     * @return the price of the coffee product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the weight of the coffee content.
     *
     * @return the coffee weight
     */
    public double getCoffeeWeight() {
        return coffeeWeight;
    }

    /**
     * Returns the weight of the packaging.
     *
     * @return the packaging weight
     */
    public double getPackagingWeight() {
        return packagingWeight;
    }

    /**
     * Returns the volume of the coffee content.
     *
     * @return the coffee volume
     */
    public double getCoffeeVolume() {
        return coffeeVolume;
    }

    /**
     * Returns the volume of the packaging.
     *
     * @return the packaging volume
     */
    public double getPackagingVolume() {
        return packagingVolume;
    }

    /**
     * Returns the quality rating of the coffee product.
     *
     * @return the quality rating, between 0 and 10
     */
    public int getQualityRating() {
        return qualityRating;
    }

    /**
     * Sets the name of the coffee product.
     *
     * @param name the new name of the coffee product
     * @throws NullPointerException if the name is null or empty
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    /**
     * Sets the price of the coffee product.
     *
     * @param price the new price of the coffee product
     * @throws IllegalArgumentException if the price is less than or equal to 0
     */
    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }
        this.price = price;
    }

    /**
     * Sets the weight of the coffee content.
     *
     * @param coffeeWeight the new coffee weight
     * @throws IllegalArgumentException if the coffee weight is negative
     */
    public void setCoffeeWeight(double coffeeWeight) {
        if (coffeeWeight < 0) {
            throw new IllegalArgumentException("Coffee weight cannot be negative.");
        }
        this.coffeeWeight = coffeeWeight;
    }

    /**
     * Sets the weight of the packaging.
     *
     * @param packagingWeight the new packaging weight
     * @throws IllegalArgumentException if the packaging weight is negative
     */
    public void setPackagingWeight(double packagingWeight) {
        if (packagingWeight < 0) {
            throw new IllegalArgumentException("Packaging weight cannot be negative.");
        }
        this.packagingWeight = packagingWeight;
    }

    /**
     * Sets the volume of the coffee content.
     *
     * @param coffeeVolume the new coffee volume
     * @throws IllegalArgumentException if the coffee volume is negative
     */
    public void setCoffeeVolume(double coffeeVolume) {
        if (coffeeVolume < 0) {
            throw new IllegalArgumentException("Coffee volume cannot be negative.");
        }
        this.coffeeVolume = coffeeVolume;
    }

    /**
     * Sets the volume of the packaging.
     *
     * @param packagingVolume the new packaging volume
     * @throws IllegalArgumentException if the packaging volume is negative
     */
    public void setPackagingVolume(double packagingVolume) {
        if (packagingVolume < 0) {
            throw new IllegalArgumentException("Packaging volume cannot be negative.");
        }
        this.packagingVolume = packagingVolume;
    }

    /**
     * Sets the quality rating of the coffee product.
     *
     * @param qualityRating the new quality rating, must be between 0 and 10
     * @throws IllegalArgumentException if the quality rating is not between 0 and 10
     */
    public void setQualityRating(int qualityRating) {
        if (qualityRating < 0 || qualityRating > 10) {
            throw new IllegalArgumentException("Quality rating must be between 0 and 10.");
        }
        this.qualityRating = qualityRating;
    }

    /**
     * Returns a string representation of the coffee product, including details about its weight,
     * volume, quality rating, and price/weight ratio.
     *
     * @return a string representation of the coffee product
     */
    @Override
    public String toString() {
        return String.format(
            "-------------------------------\n" +
            "Name: %s\n" +
            "Price: $%.2f\n" +
            "Coffee Weight: %.2f kg\n" +
            "Packaging Weight: %.2f kg\n" +
            "Total Weight: %.2f kg\n" +
            "Coffee Volume: %.2f L\n" +
            "Packaging Volume: %.2f L\n" +
            "Total Volume: %.2f L\n" +
            "Quality Rating: %d\n" +
            "State: %s\n" +
            "Price/Weight Ratio: $%.2f\n" +
            "-------------------------------",
            name, price, coffeeWeight, packagingWeight, getTotalWeight(), coffeeVolume, packagingVolume,
            getTotalVolume(), qualityRating, getState(), getPriceWeightRatio());
    }
}