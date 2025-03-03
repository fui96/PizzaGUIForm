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
        return null;
    }

}
