import java.io.FileNotFoundException;
import java.io.IOException;

public class GenericMedicalData extends MedicalData {

    private MedicalDataFactory medicalDataFactory;

    public GenericMedicalData(MedicalDataFactory medicalDataFactory) {
        this.medicalDataFactory = medicalDataFactory;
    }

    @Override
    public void preapare() throws IOException, InterruptedException {
        System.out.println("\nGeneric medical data sensor is being used");
        CounterSingleton.getInstance(false).incCurrentIndex();
        medicalDataFactory.readFile();
        vital = medicalDataFactory.getVital();
        immune = medicalDataFactory.getImmune();
        digestive = medicalDataFactory.getDigestive();
        nervous = medicalDataFactory.getNervous();
        notifyObservers(vital, digestive, nervous, immune);
    }

    @Override
    public void notifyObservers(CondimentDecarator vital, Measure digestive, Measure nervous, Measure immune) throws IOException, InterruptedException {
        if (Integer.parseInt(vital.getMeasurement()) < 3 || Integer.parseInt(vital.getMeasurement()) > 10) {
            System.out.println("Something goes wrong:" + CounterSingleton.getInstance(true).count());
            SingletonCommandService.getInstance().getRemoteControl().startWasPushed(1);
        }

        while (medicalDataFactory.getSubject().hasNext()) {
            Object ob = medicalDataFactory.getSubject().next();
            if (Integer.parseInt(vital.getMeasurement()) < 3 || Integer.parseInt(vital.getMeasurement()) > 10) {
                vital.setUpper();
                digestive.setUpper();
                immune.setUpper();
                nervous.setUpper();
            }
            ((Observer) ob).update(vital, digestive, nervous, immune);
        }
    }

}
