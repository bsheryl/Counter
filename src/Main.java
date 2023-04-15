import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Counter counter;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("temp.out"))) {
            counter = (Counter) ois.readObject();
        } catch (Exception e) {
            counter = new Counter();
        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("/stop")) {
            if (input.equals("/inc")) {
                counter.inc();
            } else if (input.equals("/reset")) {
                counter.reset();
            }
            input = scanner.nextLine();
        }
        counter.stop();
        scanner.close();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.out"))) {
            oos.writeObject(counter);
            oos.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}