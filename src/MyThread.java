public class MyThread extends Thread {
    private Semaphore s;

    public MyThread(Semaphore s) {
        this.s = s;
    }

    @Override
    public void run() {
        while(true) {
            if(s.getKey()) {
                System.out.println(this.getName());
                try {
                    Thread.sleep((int)(Math.random()*1500)+1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                s.releaseKey();
                synchronized (s) {
                    s.notifyAll();
                    try {
                        s.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                try {
                    synchronized (s) {
                        s.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public int getNum() {
        String name = this.getName();
        return Integer.parseInt(name.substring(7));
    }

}
