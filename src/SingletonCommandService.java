public class SingletonCommandService {

    private static RemoteControl remoteControl;

    private static Patient patient;

    private SingletonCommandService(RemoteControl remoteControl) {
        this.remoteControl = remoteControl;
    }

    public synchronized static SingletonCommandService getInstance() {
        if (remoteControl == null) {
            patient = new Patient("isimsiz", new Subject() {
                @Override
                public void registerObserver(Observer o) {

                }

                @Override
                public void removeObserver(Observer o) {

                }

                @Override
                public void sifirla() {

                }

                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public Object next() {
                    return null;
                }
            });
            remoteControl = new RemoteControl(patient);
        }
        remoteControl.setPatient(patient);
        return new SingletonCommandService(remoteControl);
    }

    public void setPatient(Patient patient) {
        SingletonCommandService.patient = patient;
    }

    public void setRemoteControlCommand(int index, Command command){
        remoteControl.setCommand(index, command);
    }

    public RemoteControl getRemoteControl(){
        return remoteControl;
    }

}
