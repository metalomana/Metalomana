package Work_1;

public class Cat extends Animal {

    private static int catCount = 0;

    private static final int MAX_RUN = 200;
    private boolean satiety = false;
    private int appetite;

    public Cat(String name, int appetite) {
        super(name);
        this.appetite = appetite;
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl) {
        if (bowl.getFood() >= appetite) {
            bowl.decreaseFood(appetite);
            satiety = true;
            System.out.println(name + " поел и теперь сыт.");
        } else {
            System.out.println(name + " не стал есть — недостаточно еды.");
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public static int getCatCount() {
        return catCount;
    }
}