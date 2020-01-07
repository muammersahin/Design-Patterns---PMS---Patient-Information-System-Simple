import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhilipsHealthCareFactory implements MedicalDataFactory {

    private CondimentDecarator vital;
    private Measure immune;
    private Measure digestive;
    private Measure nervous;
    private Measure respiratory;
    private Measure cardioVascular;
    private Subject subject;

    public PhilipsHealthCareFactory(Subject s) {
        subject = s;
    }

    public void readFile() throws FileNotFoundException, InterruptedException {

        File f = new File("philipsmedicaldatas.txt");
        Scanner s = new Scanner(f);
        int index = 1;
        while (s.hasNextLine()) {
            if (CounterSingleton.getInstance(false).getCurrentIndex() == index + 1) {
                digestive = new Digestive();
                nervous = new Nervous();
                immune = new Immune();

                String veri = s.nextLine();
                String[] split = veri.split(",");
                respiratory = new Respiratory();
                respiratory.setMeasurement("0");
                vital = new Vital(respiratory);

                if (!split[1].equalsIgnoreCase("null")) {
                    respiratory = new Respiratory();
                    respiratory.setMeasurement(split[1]);
                    vital = new Vital(respiratory);
                }

                if (!split[2].equalsIgnoreCase("null")) {
                    cardioVascular = new CardioVascular();
                    cardioVascular.setMeasurement(split[2]);
                    vital = new Vital(cardioVascular);
                }

                vital.setMeasurement(split[0]);

                digestive.setMeasurement(split[3]);
                nervous.setMeasurement(split[4]);
                immune.setMeasurement(split[5]);
            } else {
                s.nextLine();
            }
            index++;
        }
    }


    @Override
    public CondimentDecarator getVital() {
        return vital;
    }

    @Override
    public Measure getImmune() {
        return immune;
    }

    @Override
    public Measure getDigestive() {
        return digestive;
    }

    @Override
    public Measure getNervous() {
        return nervous;
    }

    @Override
    public Subject getSubject() {
        return subject;
    }
}
