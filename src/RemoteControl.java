import java.io.FileNotFoundException;
import java.io.IOException;

public class RemoteControl {

    Command commands[];
    Patient patient;

    public RemoteControl(Patient patient) {
        commands = new Command[2];
        for (int i = 0; i < commands.length; i++) {
            commands[i] = new Command() {
                @Override
                public void execute(Patient patient) throws FileNotFoundException, InterruptedException {
                    System.out.println("Nothing executed");
                }
            };
        }
        this.patient = patient;
    }

    public void setCommand(int index, Command command) {
        commands[index] = command;
    }

    public void startWasPushed(int index) throws IOException, InterruptedException {
        if(commands[index] instanceof AlarmAdapter){
            commands[index].execute(patient);
        }else {
            while (true) {
                commands[index].execute(patient);
                patient.getSubject().sifirla();
                if (CounterSingleton.getInstance(false).getCurrentIndex() < 8) {
                    Thread.sleep(3000);
                } else {
                    return;
                }
            }
        }
    }

    public int getCommandLenght(){
        return commands.length;
    }

    public void setPatient(Patient patient){
        this.patient = patient;
    }

}
