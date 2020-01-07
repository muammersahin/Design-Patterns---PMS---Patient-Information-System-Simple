import java.util.ArrayList;
import java.util.Iterator;

public class Measuarements implements Subject, Iterator {

    private ArrayList<Observer> observers = new ArrayList<>();
    private int currentIndex = 0;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(observers.indexOf(o));
    }

    @Override
    public boolean hasNext() {
        return observers.size() > currentIndex;
    }

    @Override
    public Object next() {
        Observer observer = observers.get(currentIndex);
        currentIndex++;
        return observer;
    }

    @Override
    public void sifirla(){
        currentIndex = 0;
    }

}
