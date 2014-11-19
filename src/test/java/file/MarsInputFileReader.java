package file;

import data.Position;
import file.builder.MarsInputBuilder;
import instruction.Orientation;
import org.apache.commons.io.FileUtils;
import robot.Robot;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class MarsInputFileReader
{
    public MarsInput read(File file) throws IOException
    {
        String fileContents = FileUtils.readFileToString(file);

        String[] lines = fileContents.split("\n");
        MarsInputBuilder marsInputBuilder = new MarsInputBuilder();
        readGridCoordinates(lines[0], marsInputBuilder);
        readRobotDetailsAndInstructions(lines, marsInputBuilder);
        return marsInputBuilder
                .build();
    }

    private void readRobotDetailsAndInstructions(String[] lines, MarsInputBuilder marsInputBuilder)
    {
        String[] robotInstructions = Arrays.copyOfRange(lines, 1, lines.length);
        for (int index = 0; index < robotInstructions.length; index = +2)
        {
            String robotDetailsLine = robotInstructions[index];

            String[] robotDetails = robotDetailsLine.split(" ");

            int initialXCoordinate = Integer.valueOf(robotDetails[0]);
            int initialYCoordinate = Integer.valueOf(robotDetails[1]);
            Orientation orientation = Orientation.valueOf(robotDetails[2]);
            Robot robot = new Robot(new Position(initialXCoordinate, initialYCoordinate), orientation);
            marsInputBuilder.withRobotAndInstruction(robot);
        }
    }

    private void readGridCoordinates(String line, MarsInputBuilder marsInputBuilder)
    {
        String[] tokens = line.split(" ");
        marsInputBuilder
                .withUpperXCoordinate(Integer.valueOf(tokens[0]))
                .withUpperYCoordinate(Integer.valueOf(tokens[1]));
    }
}
