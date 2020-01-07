import java.util.Iterator;

public interface Subject extends Iterator {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void sifirla();
}