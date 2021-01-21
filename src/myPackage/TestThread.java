package myPackage;

public class TestThread implements Runnable{
    public int sum;

    public TestThread() {
        this.sum = 1000;
    }

    public synchronized void outMonay() throws InterruptedException {
        if (sum > 0) {
            Thread.sleep(1000);
            sum = sum - 1000;
            System.out.println(sum);
        } else {
            System.out.println("money empty");
        }
    }

    @Override
    public void run() {
        try {
            outMonay();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestThread t = new TestThread();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.start();
        t2.start();
    }
}
// Sync : trong truong hop cac luong chay song song neu co 1 luong truy cap vao du lieu truoc thi ko ok, cho cung truy cap;

// (key) dung cho Ham;