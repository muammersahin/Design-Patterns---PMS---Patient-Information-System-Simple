import java.io.IOException;

public interface Observer {
    void update(CondimentDecarator vital, Measure digestive, Measure nervous, Measure immune) throws IOException;
}
