package file;

import data.Position;
import file.builder.MarsInputBuilder;
import instruction.Instruction;
import instruction.Orientation;
import org.apache.commons.io.FileUtils;
import robot.Robot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        for (int index = 0; index < robotInstructions.length; index = index + 3)
        {
            String robotDetailsLine = robotInstructions[index];
            Robot robot = assembleRobot(robotDetailsLine);
            List<Instruction> instructions = assembleInstructions(robotInstructions[index + 1]);

            marsInputBuilder.withRobotAndInstruction(robot, instructions);
        }
    }

    private List<Instruction> assembleInstructions(String robotInstruction)
    {
        List<Instruction> instructions = new ArrayList<>();

        for (Character instructionLetter : robotInstruction.toCharArray())
        {
            instructions.add(Instruction.valueOf(instructionLetter.toString()));
        }
        return instructions;
    }

    private Robot assembleRobot(String robotDetailsLine)
    {
        String[] robotDetails = robotDetailsLine.split(" ");

        int initialXCoordinate = Integer.valueOf(robotDetails[0]);
        int initialYCoordinate = Integer.valueOf(robotDetails[1]);
        Orientation orientation = Orientation.valueOf(robotDetails[2]);
        return new Robot(new Position(initialXCoordinate, initialYCoordinate), orientation);
    }

    private void readGridCoordinates(String line, MarsInputBuilder marsInputBuilder)
    {
        String[] tokens = line.split(" ");
        marsInputBuilder
                .withUpperXCoordinate(Integer.valueOf(tokens[0]))
                .withUpperYCoordinate(Integer.valueOf(tokens[1]));
    }
}
