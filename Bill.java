import java.util.Scanner;

public class Bill {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Dish dishesObj = new Dish(); 
        boolean flag = true;

        do {
            System.out.println("Enter your choices:");
            System.out.println("1. Add Dishes\t2. Remove Dishes\t3. Search Dishes\t4. Get Bill\t5. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("How many items do you want to add? ");
                    int count = sc.nextInt();
                    Dish[] dish = new Dish[count];
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter dish name: ");
                        String name = sc.next();
                        int price = (int) (Math.random() * 300); 
                        System.out.print("Enter quantity: ");
                        int quantity = sc.nextInt();
                        dish[i] = Dish.creatObj(name, price, quantity);
                    }
                    Dish.addDishes(dish); 
                    break;
                }
                case 2: {
                    dishesObj.removeDishes(); 
                    break;
                }
                case 3: {
                    System.out.print("Enter the dish name to search: ");
                   
                    String food = sc.next();
            
                    dishesObj.searchDish(food);
                    break;
                }
                case 4: {
                    dishesObj.generateBill(); 
                    break;
                }
                case 5: {
                    System.out.println("Exiting the program. Thank you!");
                    flag = false; 
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        } while (flag);

        sc.close(); 
    }
}
