import java.io.IOException;

public class MedicalDataEvents {

    public void getViaPhilips(Patient patient) throws IOException, InterruptedException {
        MedicalDataFactory medicalDataFactory = new PhilipsHealthCareFactory(patient.getSubject());
        MedicalData medicalData = new PhilipsMedicalData(medicalDataFactory);

        for(int clear = 0; clear < 1000; clear++)
        {
            System.out.println("\b") ;
        }

        System.out.println("-----------------------------------------------\n" + patient.getName() + " :");
        medicalData.preapare();
    }

    public void getViaGeneric(Patient patient) throws IOException, InterruptedException {
        MedicalDataFactory medicalDataFactory = new GeneralElectricHealthCareFactory(patient.getSubject());
        MedicalData medicalData = new GenericMedicalData(medicalDataFactory);

        for(int clear = 0; clear < 1000; clear++)
        {
            System.out.println("\b") ;
        }

        System.out.println("-----------------------------------------------\n" + patient.getName() + " :");
        medicalData.preapare();
    }


}
