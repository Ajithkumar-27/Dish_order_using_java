import java.io.FileWriter;
import java.io.IOException;

public class Dish {
    private String dName;
    private int dPrice;
    private int qty;
    static Dish[] dishes;
    Dish(){}
    private Dish(String dName, int dPrice,int qty){
        this.dName=dName;
        this.dPrice=dPrice;
        this.qty=qty;
    }
public String getName(){
    return dName;
}
public int getPrice(){
    return dPrice;
}
public int getQty(){
    return qty;
}
public static Dish creatObj(String dName, int dPrice,int qty){
    return new Dish(dName,dPrice,qty);
}

public static void addDishes(Dish...dish){
    if(dishes==null){
        dishes=new Dish[dish.length];
    for(int i=0;i<dish.length;i++){
        dishes[i]=dish[i];
    }
    System.out.println("Your dishes are added");
    }
    else{
        System.out.println("dishes are already in the bill");
    }
}
public void removeDishes() {
    if (dishes != null) { 
        dishes = null;
        System.out.println("Dishes are removed from the bill.");
    } else {
        System.out.println("Dishes are already empty.");
    }
}



public void searchDish(String str){
    if(dishes!=null){
        
    for(int i=0;i<dishes.length;i++){
        if (dishes[i].getName().equalsIgnoreCase(str)) {
            System.out.println("your dish is present");
        }
    }}
        else{
            System.out.println("your dish is not present");
        }
    
}
public void generateBill(){
    
    if (dishes != null) {
        try (FileWriter writer = new FileWriter("Bill.txt")) { 
                        int sum = 0;
            writer.write("****************************************************************\n");
            writer.write("*                         BILL                                 *\n");
            writer.write("****************************************************************\n");
            writer.write(String.format("%-20s %-10s %-10s %-10s\n", "Dishes", "Price", "Quantity", "Total"));
            writer.write("----------------------------------------------------------------\n");
    
            for (int i = 0; i < dishes.length; i++) {
                int total = dishes[i].dPrice * dishes[i].qty;
                sum += total;
                writer.write(String.format("%-20s %-10d %-10d %-10d\n", dishes[i].dName, dishes[i].dPrice, dishes[i].qty, total));
            }
    
            writer.write("----------------------------------------------------------------\n");
            writer.write(String.format("%-40s %-10d\n", "Total Amount:", sum));
            writer.write("****************************************************************\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("An error occurred while writing the bill to the file.");
        }
    }
    
    else{
        System.out.println("NO items in the bill....Please add items");
    }

}
}
