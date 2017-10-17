import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Electronic ordering system for a restaurant
 * @author mdalton31
 * @version 1
 */
public class Restaurant {
    /**
     * Main method requests order
     * @param args foodFile drinkFile e.g. Food.txt Drink.txt
     */
    public static void main(String[] args) {
        //throw IllegalArgumentException if program run improperly
        if (args.length != 2) {
            throw new IllegalArgumentException("Two arguments required.\n"
                + "Proper use: java Restaurant Food.txt Drinks.txt");
        }
        String foodFile = args[0];
        String drinkFile = args[1];
        //Prompt input
        System.out.print("Enter food item: ");
        Scanner sc = new Scanner(System.in);
        String foodIn = sc.nextLine();
        //Prompt input
        System.out.print("Enter drink item: ");
        String drinkIn = sc.nextLine();
        //Check order
        try {
            checkOrder(foodIn, drinkIn, foodFile, drinkFile);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (FoodNotFoundException e) {
            System.out.println(e.getMessage());
            main(new String[] {foodFile, drinkFile});
        } catch (DrinkNotFoundException e) {
            System.out.println(e.getMessage());
            main(new String[] {foodFile, drinkFile});
        } catch (FoodAndDrinkNotFoundException e) {
            System.out.println(e.getMessage());
            main(new String[] {foodFile, drinkFile});
        }
        sc.close();
    }
    /**
     * checkOrder() processes order
     * @param food food input to check
     * @param drink drink input to check
     * @param foodFile file of list of supported food items
     * @param drinkFile file of list of supported drink items
     * @throws FoodNotFoundException food not found in foodFile
     * @throws DrinkNotFoundException drink not found in drinkFile
     * @throws FoodAndDrinkNotFoundException both food and drink not found
     * @throws FileNotFoundException foodFile and/or drinkFile not in directory
     */
    public static void checkOrder(String food, String drink,
        String foodFile, String drinkFile)
        throws FileNotFoundException, FoodNotFoundException,
        DrinkNotFoundException, FoodAndDrinkNotFoundException {
        if (!(checkFood(food, foodFile)) && !(checkDrink(drink, drinkFile))) {
            throw new FoodAndDrinkNotFoundException(String.format(
                "Our food menu doesn't have %s "
                + "and our drink menu doesn't have %s!",
                food, drink));
        } else if (!(checkFood(food, foodFile))) {
            throw new FoodNotFoundException(String.format(
                "Our food menu doesn't have %s!", food));
        } else if (!(checkDrink(drink, drinkFile))) {
            throw new DrinkNotFoundException(String.format(
                "Our drink menu doesn't have %s!", drink));
        } else {
            System.out.println("Order sucessful!");
        }
    }

    /**
     * checkFood() parses menu and returns if food available
     * @param food food input to check
     * @param foodFile file of list of supported food items
     * @return true if food found in foodFile
     * @throws FileNotFoundException foodFile not in directory
     */
    public static boolean checkFood(String food, String foodFile)
        throws FileNotFoundException {
        Scanner scF = new Scanner(new File(foodFile));
        ArrayList<String> accepted = new ArrayList<>();
        while (scF.hasNextLine()) {
        //parse food item from each line and add to list
            String currLine = scF.nextLine();
            accepted.add(currLine);
        }
        scF.close();
        return accepted.contains(food);
    }

    /**
     * parses menu and returns if drink available
     * @param drink drink input to check
     * @param drinkFile file of list of supported drink items
     * @return true if drink found in drinkFile
     * @throws FileNotFoundException drinkFile not in directory
     */
    public static boolean checkDrink(String drink, String drinkFile)
        throws FileNotFoundException {
        Scanner scF = new Scanner(new File(drinkFile));
        ArrayList<String> accepted = new ArrayList<>();
        while (scF.hasNextLine()) {
        //parse drink item from each line and add to list
            String currLine = scF.nextLine();
            accepted.add(currLine);
        }
        scF.close();
        return accepted.contains(drink);
    }
}