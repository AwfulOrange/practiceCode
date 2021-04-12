import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        try {
                    TimeUnit.SECONDS.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        System.out.println("Hello World!");
    }
}
