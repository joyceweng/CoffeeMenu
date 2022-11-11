package group3;

import java.io.Serializable;

/**
 * Data class represents one order
 *
 * @author Phuoc Nguyen
 * @author Joyce Weng
 * @author Tammy H Le
 * @version 12/06/2020
 */
public class CoffeeOrder implements Comparable<CoffeeOrder>, Serializable {

    //constants for size
    final static double SMALL_PRICE = 1.00;
    final static double LARGE_PRICE = 2.00;
    //constants for coffee flavor 
    final static double VANILLA_PRICE = 2.99;
    final static double FRENCH_VANILLA_PRICE = 3.49;
    final static double CARAMEL_PRICE = 2.99;
    final static double MOCHA_PRICE = 3.99;
    final static double HAZELNUT_PRICE = 3.49;
    //privates fields 
    private String name;
    private boolean isCold;
    private String coffeeFlavor;
    private boolean isLarge;
    private double price;

    /**
     * Constructor with no private fields
     */
    public CoffeeOrder() {
        name = "";
        isCold = false;
        coffeeFlavor = "";
        isLarge = false;
        price = 0.00;
    }

    /**
     * Constructor with all private fields
     *
     * @param name String
     * @param isCold boolean
     * @param coffeeFlavor String
     * @param isLarge boolean
     */
    public CoffeeOrder(String name, boolean isCold, String coffeeFlavor, boolean isLarge) {
        this.name = name;
        this.isCold = isCold;
        this.coffeeFlavor = coffeeFlavor;
        this.isLarge = isLarge;
    }

    /**
     * Provides access to customer's name
     *
     * @return the customer's name
     */
    public String getName() {
        return name;
    }

    /**
     * Allow customer's name to be set
     *
     * @param name the customer's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Provides access to coffee type (Hot or Iced)
     *
     * @return the coffee type
     */
    public String getCoffeeTemp() {
        if (isCold == true) {
            return "Iced";
        } else {
            return "Hot";
        }
    }

    /**
     * Allow coffee type to be set
     *
     * @param isCold the coffee type
     */
    public void setCoffeeIsCold(boolean isCold) {
        this.isCold = isCold;
    }

    /**
     * Provides access to the coffee flavor
     *
     * @return the coffee flavor
     */
    public String getCoffeeFlavor() {
        return coffeeFlavor;
    }

    /**
     * Allow Coffee flavor to be set
     *
     * @param coffeeFlavor the coffee flavor
     */
    public void setCoffeeFlavor(String coffeeFlavor) {
        this.coffeeFlavor = coffeeFlavor;
    }

    /**
     * Provides access to the the coffee size
     *
     * @return the coffee size
     */
    public String getCoffeeSize() {
        if (isLarge == true) {
            return "Large";
        } else {
            return "Small";
        }
    }

    /**
     * Allow the coffee size to be set
     *
     * @param isLarge the coffee size
     */
    public void setCoffeeIsLarge(boolean isLarge) {
        this.isLarge = isLarge;
    }

    /**
     * Provides access to the price
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Allow the price to be set
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Calculate the price for each size and vanilla
     *
     * @return the price
     */
    public double calculate() {
        if (isLarge == false) {
            switch (coffeeFlavor) {
                case "vanilla":
                    price = SMALL_PRICE + VANILLA_PRICE;
                    break;
                case "french vanilla":
                    price = SMALL_PRICE + FRENCH_VANILLA_PRICE;
                    break;
                case "caramel":
                    price = SMALL_PRICE + CARAMEL_PRICE;
                    break;
                case "mocha":
                    price = SMALL_PRICE + MOCHA_PRICE;
                    break;
                case "hazelnut":
                    price = SMALL_PRICE + HAZELNUT_PRICE;
                    break;
                default:
                    break;
            }
        } else {
            switch (coffeeFlavor) {
                case "vanilla":
                    price = LARGE_PRICE + VANILLA_PRICE;
                    break;
                case "french vanilla":
                    price = LARGE_PRICE + FRENCH_VANILLA_PRICE;
                    break;
                case "caramel":
                    price = LARGE_PRICE + CARAMEL_PRICE;
                    break;
                case "mocha":
                    price = LARGE_PRICE + MOCHA_PRICE;
                    break;
                case "hazelnut":
                    price = LARGE_PRICE + HAZELNUT_PRICE;
                    break;
                default:
                    break;
            }
        }
        return price;
    }

    /**
     * compare two orders with the same name
     *
     * @param o CoffeeOrder
     * @return int
     */
    @Override
    public int compareTo(CoffeeOrder o) {
        if (o != null) {
            return this.name.compareTo(o.name);
        }
        return 1;
    }
}
