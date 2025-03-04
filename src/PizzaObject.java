import java.util.ArrayList;

public class PizzaObject {
    private ArrayList<String> Toppings;
    private String Size;
    private String Crust;
    //Constructor
    public PizzaObject(String Crust,String Size) {
        Toppings = new ArrayList<>();
        this.Size = Size;
        this.Crust = Crust;
    }
    //Topping Methods
    public ArrayList<String> getToppings() {
        return Toppings;
    }
    public void addToppings(String Topping) {
        Toppings.add(Topping);
    }
    public void removeToppings(String Topping) {
        Toppings.remove(Topping);
    }
    public int NumberofToppings(){
        return Toppings.size();
    }

    //Size Methods
    public String getSize() {
        return Size;
    }
    public void setSize(String Size) {
        this.Size = Size;
    }
    //Crust Methods
    public String getCrust() {
        return Crust;
    }
    public void setCrust(String Crust) {
        this.Crust = Crust;
    }
    //Other Methods
    public String DisplayPizza(){
        double Total, Subtotal, SalesTax;
        int ToppingCost;
        double SizeCost = 0;
        switch(Size){
            case "Small":
                SizeCost = 8;
                break;
            case "Medium":
                SizeCost = 12;
                break;
            case "Large":
                SizeCost = 16;
                break;
            case "Super":
                SizeCost = 20;
                break;
            default:
                SizeCost = 8;
        }
        ToppingCost = Toppings.size();
        Subtotal = SizeCost + ToppingCost;
        SalesTax = Subtotal * 0.07;
        Total = Subtotal + SalesTax;
        StringBuilder Receipt = new StringBuilder();
        Receipt.append("------------ PIZZA ORDER RECEIPT ------------\n");
        Receipt.append(String.format("%-5s %10s %15.2f\n",Size,Crust,SizeCost));
        Receipt.append("Toppings:\n");
        if(!Toppings.isEmpty()){
            for(String topping : Toppings){
                Receipt.append(String.format("%-10s %1.2f\n",topping,1.00));
            }
        }
        else{
            Receipt.append("No toppings found\n");
        }
        Receipt.append(String.format("%-10s %1.2f\n","Subtotal:",Subtotal));
        Receipt.append(String.format("%-10s %1.2f\n","SalesTax:",SalesTax));
        Receipt.append(String.format("%-10s %1.2f\n","Total:",Total));

        return Receipt.toString();
    }

}
