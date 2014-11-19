package file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class MarsInputFileReader
{
    public MarsInput read(File file) throws IOException
    {
        String fileContents = FileUtils.readFileToString(file);

        String[] lines = fileContents.split("\n");
        String firstLine = lines[0];

        String[] tokens = firstLine.split(" ");
        return new MarsInput(Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]));

    }
}
