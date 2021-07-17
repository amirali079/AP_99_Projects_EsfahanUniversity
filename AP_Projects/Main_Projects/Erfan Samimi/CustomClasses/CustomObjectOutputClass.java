package Main.CustomClasses;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class CustomObjectOutputClass extends ObjectOutputStream {


    public CustomObjectOutputClass(OutputStream out) throws IOException {
        super (out);
    }
    @Override
    protected void writeStreamHeader(){}
}