package lab;

abstract class Beverage {
    public void PrepareRecipe()
    {
        BoilWater();
        Brew();
        PourInCup();
        AddCondiments();
    }

    private void BoilWater()
    {
        System.out.println("Voda...");
    }

    private void PourInCup()
    {
        System.out.println("Cup...");
    }

    protected abstract void Brew();
    protected abstract void AddCondiments();
}

class Tea extends Beverage{
    protected void Brew(){
        System.out.println("Tea loading...");
    }

    protected void AddCondiments(){
        System.out.println("Adding lemon...");
    }
}
class Coffee extends Beverage {
    protected void Brew(){
        System.out.println("Coffee loading...");
    }

    protected void AddCondiments(){
        System.out.println("Adding milk and sugar...");
    }
}
class Main1{
    public static void main(String[] args) {
        Beverage tea = new Tea();
        Beverage coffee = new Coffee();

        tea.Brew();
        tea.AddCondiments();

        System.out.println("------------");

        coffee.Brew();
        coffee.AddCondiments();
    }
}