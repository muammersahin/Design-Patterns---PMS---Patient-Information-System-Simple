import java.io.FileNotFoundException;

public interface MedicalDataFactory {

    CondimentDecarator getVital();
    Measure getImmune();
    Measure getDigestive();
    Measure getNervous();
    Subject getSubject();
    void readFile() throws FileNotFoundException, InterruptedException;
}
