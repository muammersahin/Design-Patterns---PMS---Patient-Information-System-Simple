import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class MedicalData {
    public CondimentDecarator vital;
    public Measure immune;
    public Measure nervous;
    public Measure digestive;

    public abstract void preapare() throws IOException, InterruptedException;

    public abstract void notifyObservers(CondimentDecarator vital, Measure digestive, Measure nervous, Measure immune) throws IOException, InterruptedException;

}
