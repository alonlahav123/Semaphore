import java.util.ArrayList;

public class Mainer {
    public static void main(String[] args) {
        ArrayList<MyThread> allThreads = new ArrayList<>();
        int size = 100;
        Semaphore s = new Semaphore(5);

        for(int i = 0; i < size; i++) {
            MyThread e = new MyThread(s);
            e.start();
            allThreads.add(e);
        }

        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //s.notifyAll();
        }

    }
}
