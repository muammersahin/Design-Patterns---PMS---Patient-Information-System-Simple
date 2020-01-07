import java.io.IOException;

public class DisplayData implements Observer{

    @Override
    public void update(CondimentDecarator vital, Measure digestive, Measure nervous, Measure immune) throws IOException {
        System.out.println("\nVital:" + vital.getMeasurement() + "\nDigestive:" + digestive.getMeasurement() + "\nNervous:" + nervous.getMeasurement() + "\nImmune:" + immune.getMeasurement());
        final String os = System.getProperty("os.name");
    }


}
