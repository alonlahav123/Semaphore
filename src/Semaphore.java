import java.util.ArrayList;

public class Semaphore {
    private int keys;
    private ArrayList<Integer> queue;

    public Semaphore(int keys) {
        this.keys = keys;
        queue = new ArrayList<>();
    }

    public boolean getKey() {
        if(keys > 0) {
            this.keys--;
            return true;
        }
        return false;
    }

    public void releaseKey() {
        this.keys++;
    }

    public void joinQueue(int threadNum) {
        queue.add(threadNum);
    }

    public boolean firstInQueue(int threadNum) {
        if(queue.get(0) == threadNum) {
            queue.remove(0);
            return true;
        }
        return false;
    }

}
