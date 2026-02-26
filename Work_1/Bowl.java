package Work_1;

public class Bowl {

    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        if (amount <= food) {
            food -= amount;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("В миску добавили " + amount + " еды.");
        }
    }

    public void info() {
        System.out.println("В миске осталось " + food + " еды.");
    }
}
