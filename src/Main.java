import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Counter counter;
        //Пытаемся считать сохраненное состояние из существующего файла (десериализация)
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("temp.out"))) {
            counter = (Counter) ois.readObject();
            counter.restart();
        } catch (Exception e) {
            //Создаем новый объект при отсутствии файла
            counter = new Counter();
        }
        Scanner scanner = new Scanner(System.in);
        counter.getInfo();
        String input = scanner.nextLine();
        while (!input.equals("/stop")) { //Считываем команды
            counter.getInfo();
            if (input.equals("/inc")) {
                counter.inc();
            } else if (input.equals("/reset")) {
                counter.reset();
            }
            input = scanner.nextLine();
        }
        counter.stop();
        scanner.close();
        //Записываем состояние счетчика в файл (сериализация)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.out"))) {
            oos.writeObject(counter);
            oos.flush();
        } catch (Exception e) {

        }
    }
}