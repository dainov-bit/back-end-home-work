class NumberWork implements Runnable {
    private int start, end, count;

    public NumberWork(int start, int end) {
        this.start = start;
        this.end = end;
        this.count = 0;
    }

    public int getCount() {
        return this.count;
    }

    public boolean searchNumber3(int x) {
        return String.valueOf(x).contains("3");
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (i % 21 == 0 && this.searchNumber3(i)) {  // Используйте логическое "и" (&&)
                this.count++;
            }
        }
    }
}

public class Application {
    public static void main(String[] args) {
        NumberWork nw = new NumberWork(1,2000000);
        NumberWork nw1 = new NumberWork(1, 999999);      // Измените верхнюю границу на 999999
        NumberWork nw2 = new NumberWork(1000000, 2000000);

        Thread t1 = new Thread(nw1);
        Thread t2 = new Thread(nw2);
Thread t = new Thread(nw);

        t1.start();
        t2.start();
t.start();
        try {
            t1.join();
            t2.join();
            t.join();
        } catch (InterruptedException e) {
            System.out.println("Ошибка трех потоков");
        }
int c = nw1.getCount() + nw2.getCount();
        System.out.println("Первый поток: "+ nw1.getCount()+"\n Поток два: "+nw2.getCount()+"\n Результат двух потоков: "+c+"\n Результат третьего потока: "+nw.getCount());

    }
}
