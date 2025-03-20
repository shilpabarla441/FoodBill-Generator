import java.util.Scanner;
// Base Food Item Class
class FoodItem {
    protected String type;
    protected boolean extraCheese = false;
    protected boolean extraToppings = false;
    protected boolean takeaway = false;
    protected int basePrice;
    protected int cheesePrice = 50;
    protected int toppingPrice = 70;
    protected int takeawayPrice = 20;

    public FoodItem(String type) {
        this.type = type.toLowerCase();
    }

    public void addExtraCheese() {
        extraCheese = true;
    }

    public void addExtraToppings() {
        extraToppings = true;
    }

    public void addTakeaway() {
        takeaway = true;
    }

    public void generateBill() {
        int totalPrice = basePrice;

        System.out.println("\n--- Bill ---");
        System.out.println("Item Type: " + capitalize(type));
        System.out.println("Base Price: ₹" + basePrice);

        if (extraCheese) {
            System.out.println("Extra Cheese: ₹" + cheesePrice);
            totalPrice += cheesePrice;
        }

        if (extraToppings) {
            System.out.println("Extra Toppings: ₹" + toppingPrice);
            totalPrice += toppingPrice;
        }

        if (takeaway) {
            System.out.println("Takeaway Charge: ₹" + takeawayPrice);
            totalPrice += takeawayPrice;
        }

        System.out.println("------------------");
        System.out.println("Total Price: ₹" + totalPrice);
    }

    protected String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

// Pizza Class
class Pizza extends FoodItem {
    public Pizza(String type) {
        super(type);
        switch (this.type) {
            case "veg":
                basePrice = 300;
                break;
            case "nonveg":
                basePrice = 400;
                break;
            case "deluxe veg":
                basePrice = 500;
                break;
            case "deluxe nonveg":
                basePrice = 600;
                break;
            default:
                System.out.println("Invalid pizza type! Defaulting to Veg Pizza.");
                this.type = "veg";
                basePrice = 300;
                break;
        }
    }
}

// Burger Class
class Burger extends FoodItem {
    public Burger(String type) {
        super(type);
        switch (this.type) {
            case "veg burger":
                basePrice = 150;
                break;
            case "nonveg burger":
                basePrice = 200;
                break;
            case "deluxe veg burger":
                basePrice = 250;
                break;
            case "deluxe nonveg burger":
                basePrice = 300;
                break;
            default:
                System.out.println("Invalid burger type! Defaulting to Veg Burger.");
                this.type = "veg burger";
                basePrice = 150;
                break;
        }
    }
}

// KFC Class
class KFC extends FoodItem {
    public KFC(String type) {
        super(type);
        switch (this.type) {
            case "popcorn chicken":
                basePrice = 180;
                break;
            case "zinger burger":
                basePrice = 250;
                break;
            case "chicken bucket":
                basePrice = 500;
                break;
            case "crispy strips":
                basePrice = 300;
                break;
            default:
                System.out.println("Invalid KFC item! Defaulting to Popcorn Chicken.");
                this.type = "popcorn chicken";
                basePrice = 180;
                break;
        }
    }
}

// Main Class
public class FoodBillGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Food Ordering System!");
        System.out.println("Available Categories:");
        System.out.println("1. Pizza: Veg, NonVeg, Deluxe Veg, Deluxe NonVeg");
        System.out.println("2. Burger: Veg Burger, NonVeg Burger, Deluxe Veg Burger, Deluxe NonVeg Burger");
        System.out.println("3. KFC: Popcorn Chicken, Zinger Burger, Chicken Bucket, Crispy Strips");

        System.out.print("\nEnter the category (Pizza/Burger/KFC): ");
        String category = scanner.nextLine().toLowerCase();

        FoodItem foodItem;
        if (category.equals("pizza")) {
            System.out.print("Enter the type of pizza you want: ");
            String pizzaType = scanner.nextLine();
            foodItem = new Pizza(pizzaType);
        } else if (category.equals("burger")) {
            System.out.print("Enter the type of burger you want: ");
            String burgerType = scanner.nextLine();
            foodItem = new Burger(burgerType);
        } else if (category.equals("kfc")) {
            System.out.print("Enter the type of KFC item you want: ");
            String kfcType = scanner.nextLine();
            foodItem = new KFC(kfcType);
        } else {
            System.out.println("Invalid category! Defaulting to Veg Pizza.");
            foodItem = new Pizza("veg");
        }

        System.out.println("\nDo you want to add extra cheese? (yes/no)");
        String cheeseChoice = scanner.nextLine();
        if (cheeseChoice.equalsIgnoreCase("yes")) {
            foodItem.addExtraCheese();
        }

        System.out.println("Do you want to add extra toppings? (yes/no)");
        String toppingChoice = scanner.nextLine();
        if (toppingChoice.equalsIgnoreCase("yes")) {
            foodItem.addExtraToppings();
        }

        System.out.println("Do you want takeaway service? (yes/no)");
        String takeawayChoice = scanner.nextLine();
        if (takeawayChoice.equalsIgnoreCase("yes")) {
            foodItem.addTakeaway();
        }

        foodItem.generateBill();
        scanner.close();
    }
}