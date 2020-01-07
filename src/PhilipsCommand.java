import java.io.IOException;

public class PhilipsCommand implements Command {
    @Override
    public void execute(Patient patient) throws IOException, InterruptedException {
        MedicalDataEvents medicalDataEvents = new MedicalDataEvents();
        medicalDataEvents.getViaPhilips(patient);
    }


}
