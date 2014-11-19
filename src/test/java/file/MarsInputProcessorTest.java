package file;

import data.Position;
import file.builder.MarsInputBuilder;
import instruction.Instruction;
import instruction.Orientation;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import robot.Robot;

import java.util.ArrayList;
import java.util.List;

public class MarsInputProcessorTest
{

    public static final Orientation EAST = Orientation.E;
    public static final int UPPER_X_COORDINATE = 3;
    public static final int UPPER_Y_COORDINATE = 3;
    private List<Instruction> instructions;

    @Before
    public void setUp() throws Exception
    {
        instructions = new ArrayList<>();
        instructions.add(Instruction.F);
    }

    @Test
    public void shouldProcessInstructionsAndReturnCoordinateAndOrientationWhenRobotNotLost() throws Exception
    {
        int x = 0;
        int y = 0;
        Robot robot = new Robot(new Position(x, y), EAST);
        MarsInput marsInput = new MarsInputBuilder()
                .withGridSize(UPPER_X_COORDINATE, UPPER_Y_COORDINATE)
                .withRobotAndInstructions(robot, instructions).build();
        String process = new MarsInputProcessor().process(marsInput);

        Assert.assertThat(process, Matchers.is(String.format(MarsInputProcessor.RESULT_FORMAT, x + 1, y, EAST)));
    }

    @Test
    public void shouldProcessInstructionAndReturnLOSTWhenRobotHasGotLost() throws Exception
    {
        Robot robot = new Robot(new Position(UPPER_X_COORDINATE, UPPER_Y_COORDINATE), EAST);
        MarsInput marsInput = new MarsInputBuilder()
                .withGridSize(UPPER_X_COORDINATE, UPPER_Y_COORDINATE)
                .withRobotAndInstructions(robot, instructions).build();

        String process = new MarsInputProcessor().process(marsInput);
        Assert.assertThat(process, Matchers.is(String.format(MarsInputProcessor.RESULT_LOST_FORMAT, UPPER_X_COORDINATE, UPPER_Y_COORDINATE, EAST)));
    }
}