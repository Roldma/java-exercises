
public class CashRegister {

    private double cashInRegister;
    private int economicalSold;
    private int gourmetSold;

    public CashRegister() {
        // at start the register has 1000 euros 
        cashInRegister = 1000;
    }

    public double payEconomical(double cashGiven) {
        // price of the economical lunch is 2.50 euros
        // if the given cash is at least the price of the lunch:
        //    the price of lunch is added to register
        //    the amount of sold lunch is incremented by one
        //    method returns cashGiven - lunch price 
        // if not enough money given, all is returned and nothing else happens
        double price = 2.5;

        if (cashGiven >= price) {
            economicalSold += 1;
            cashInRegister += price;
            return cashGiven - price;
        }

        return cashGiven;
    }

    public double payGourmet(double cashGiven) {
        // price of the gourmet lunch is 4.00 euros
        // if the given cash is at least the price of the lunch:
        //    the price of lunch is added to register
        //    the amount of sold lunch is incremented by one
        //    method returns cashGiven - lunch price 
        // if not enough money given, all is returned and nothing else happens
        double price = 4.0;

        if (cashGiven >= price) {
            gourmetSold += 1;
            cashInRegister += price;
            return cashGiven - price;
        }

        return cashGiven;
    }

    public boolean payEconomical(LyyraCard card) {
        boolean enough = false;
        double price = 2.5;
        
        if (card.balance() >= price) {
            enough = true;
            economicalSold += 1;
            card.pay(price);
        }

        return enough;
    }

    public boolean payGourmet(LyyraCard card) {
        boolean enough = false;
        double price = 4.0;
        
        if (card.balance() >= price) {
            enough = true;
            gourmetSold += 1;
            card.pay(price);
        }

        return enough;
    }

    public void loadMoneyToCard(LyyraCard card, double sum) {
        if (sum > 0) {
            card.loadMoney(sum);
            cashInRegister += sum;
        }
        
    }
    
    public String toString() {
        return "money in register " + cashInRegister + " economical lunches sold: " + economicalSold + " gourmet lunches sold: " + gourmetSold;
    }
}
