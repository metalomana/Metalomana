package Work_1;

public class Main {
    public static void main(String[] args) {

        Dog bobik = new Dog("Бобик");
        bobik.run(150);
        bobik.swim(5);

        Cat[] cats = {
                new Cat("Барсик", 10),
                new Cat("Мурзик", 15),
                new Cat("Рыжик", 7)
        };

        Bowl bowl = new Bowl(20);
        bowl.info();

        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        bowl.info();

        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isSatiety());
        }

        System.out.println("Животных создано: " + Animal.getAnimalCount());
        System.out.println("Собак создано: " + Dog.getDogCount());
        System.out.println("Котов создано: " + Cat.getCatCount());

        bowl.addFood(15);
        bowl.info();
    }
}
