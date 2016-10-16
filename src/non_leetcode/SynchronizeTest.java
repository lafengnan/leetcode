package non_leetcode;

/**
 * Created by lafengnan on 16/10/14.
 */
public class SynchronizeTest {
    final int x;
    int y;
    static SynchronizeTest f;

    public SynchronizeTest() {
        x = 3;
        y = 4;
    }

    public static void writer() {
        f = new SynchronizeTest();
    }

    public static void reader() {
        if (f != null) {
            int i = f.x, j = f.y;
            System.out.println(i);
            System.out.println(j);
        }
    }

    public static void main(String... args) {
        Runnable wJob = new Runnable() {
            @Override
            public void run() {
                SynchronizeTest.writer();
            }
        };

        Runnable rJob = new Runnable() {
            @Override
            public void run() {
                SynchronizeTest.reader();
            }
        };

        for (int i = 0; i < 1; i++) {
            Thread t1 = new Thread(wJob);
            Thread t2 = new Thread(rJob);

            t2.start();
            t1.start();
        }

    }
}
