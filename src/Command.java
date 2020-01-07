import java.io.FileNotFoundException;
import java.io.IOException;

public interface Command {

    void execute(Patient patient) throws IOException, InterruptedException;

}
