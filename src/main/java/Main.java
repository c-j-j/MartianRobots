import main.MarsRobotApplication;

public class Main
{
    public static void main(String[] args)
    {
        String results = new MarsRobotApplication().process("/main/input_sample.txt");
        System.out.println(results);
    }
}
