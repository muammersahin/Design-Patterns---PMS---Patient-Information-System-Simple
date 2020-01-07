import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class PMSApplication {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of the patient: ");
        String patientName = in.nextLine();

        Observer o = new DisplayData();
        Subject s = new Measuarements();
        Patient patient = new Patient(patientName, s);
        patient.getSubject().registerObserver(o);
        Alarm alarm = new Alarm();
        AlarmAdapter alarmAdapter = new AlarmAdapter(alarm);

        System.out.println("Sensors:\n-------------\n1 - )  Philips Healthcare\n2 - )  General Electric Healthcare");
        String s1 = in.nextLine();

        SingletonCommandService.getInstance().setPatient(patient);

        if(s1.equalsIgnoreCase("1")){
            SingletonCommandService.getInstance().setRemoteControlCommand(0, new PhilipsCommand());
        }else {
            SingletonCommandService.getInstance().setRemoteControlCommand(0, new GenericCommand());
        }

        SingletonCommandService.getInstance().setRemoteControlCommand(1, alarmAdapter);
        SingletonCommandService.getInstance().getRemoteControl().startWasPushed(0);

    }

}
