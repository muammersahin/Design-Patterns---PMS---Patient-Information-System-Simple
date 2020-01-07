public class CounterSingleton {

    private static int count = -1;
    private static int currentIndex = 0;

    private CounterSingleton() {
    }

    public synchronized static CounterSingleton getInstance(boolean vital) {
        if (count == -1)
            count++;
        else if (vital)
            count++;
        if (currentIndex == 0)
            currentIndex++;
        return new CounterSingleton();
    }

    public int count() {
        return count;
    }

    public void incCurrentIndex() {
        currentIndex++;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

}
