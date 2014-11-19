package main;

import file.MarsInput;
import file.MarsInputFileReader;
import file.MarsInputProcessor;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class MarsRobotApplication
{
    public String process(String filename)
    {
        File inputFile = new File("inputFile");
        try
        {
            FileUtils.copyInputStreamToFile(getClass().getResourceAsStream(filename), inputFile);
            MarsInput marsInput = new MarsInputFileReader().read(inputFile);
            return new MarsInputProcessor().process(marsInput);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
