import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Coffee coffee1 = new Coffee("Espresso", 15.0, 0.2, 0.05, 0.1, 0.02, 8);
        Coffee coffee2 = new Coffee("Latte", 18.0, 0.3, 0.07, 0.15, 0.03, 9);
        Coffee coffee3 = new Coffee("Cappuccino", 17.5, 0.25, 0.06, 0.12, 0.02, 7);
        Coffee coffee4 = new Coffee("Americano", 12.0, 0.1, 0.03, 0.05, 0.01, 6);
        Coffee coffee5 = new Coffee("Mocha", 20.0, 0.35, 0.08, 0.2, 0.04, 10);

        CoffeeSet coffeeSet = new CoffeeSet();
        System.out.println("Initial set is empty: " + coffeeSet.isEmpty());
        System.out.println("Initial size: " + coffeeSet.size());

        coffeeSet.add(coffee1);
        System.out.println("\nAdded Espresso. Size: " + coffeeSet.size());

        coffeeSet.add(coffee2);
        coffeeSet.add(coffee3);
        System.out.println("\nAdded Latte and Cappuccino. Size: " + coffeeSet.size());

        System.out.println("\nContains Latte: " + coffeeSet.contains(coffee2));
        System.out.println("Contains Americano (not added yet): " + coffeeSet.contains(coffee4));

        System.out.println("\nIterating over CoffeeSet:");
        for (Coffee coffee : coffeeSet) {
            System.out.println(coffee);
        }

        coffeeSet.remove(coffee2);
        System.out.println("\nRemoved Latte. Size: " + coffeeSet.size());
        System.out.println("Contains Latte after removal: " + coffeeSet.contains(coffee2));

        System.out.println("\nAdding a collection of Americano and Mocha.");
        coffeeSet.addAll(Arrays.asList(coffee4, coffee5));
        System.out.println("Size after addAll: " + coffeeSet.size());

        ArrayList<Coffee> duplicateCollection = new ArrayList<>();
        duplicateCollection.add(coffee1);
        duplicateCollection.add(coffee3);
        coffeeSet.addAll(duplicateCollection);
        System.out.println("\nTried to add duplicates. Size remains: " + coffeeSet.size());

        System.out.println("\nIterating after addAll:");
        for (Coffee coffee : coffeeSet) {
            System.out.println(coffee);
        }

        coffeeSet.clear();
        System.out.println("\nCleared CoffeeSet. Size: " + coffeeSet.size());
        System.out.println("Is empty after clear: " + coffeeSet.isEmpty());
    }
}
