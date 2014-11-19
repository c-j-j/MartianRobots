import main.MarsRobotApplication;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("INPUT");
        String inputFile = "/main/input_sample.txt";
        System.out.println(IOUtils.toString(Main.class.getResourceAsStream(inputFile)));
        String results = new MarsRobotApplication().process(inputFile);
        System.out.println("____________________________________________");
        System.out.println("OUTPUT");
        System.out.println(results);
    }
}
