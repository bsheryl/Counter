import java.io.Serializable;

public class Counter implements Serializable {
    private int count;

    public Counter() {
        count = 0;
    }

    public void inc() {
        ++count;
        System.out.println(count);
    }

    public void stop() {
        System.out.println(count);
        System.out.println("Завершаю работу");
    }

    public void restart() {
        System.out.println("Счетчик загружен, значение '" + count +"'");
    }

    public void reset() {
        count = 0;
        System.out.println("Счетчик обнулился");
    }

    public void getInfo() {
        System.out.println("/inc - увеличить значение счетчика на единицу");
        System.out.println("/stop - завершить работу приложения");
        System.out.println("/reset - обнулить счетчик");
    }
}
