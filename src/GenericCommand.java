import java.io.IOException;

public class GenericCommand implements Command {
    @Override
    public void execute(Patient patient) throws IOException, InterruptedException {
        MedicalDataEvents medicalDataEvents = new MedicalDataEvents();
        medicalDataEvents.getViaGeneric(patient);
    }
}
