import data.Grid;
import data.Position;
import instruction.ForwardInstruction;
import instruction.Instruction;
import instruction.Orientation;
import instruction.Robot;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RobotTest
{
    @Test
    public void shouldExecuteInstructionWhenRobotNotCurrentlyLost() throws Exception
    {
        Grid grid = new Grid(3, 4);
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(new ForwardInstruction());
        int x = 1;
        int y = 2;
        Position initialPosition = new Position(x, y);
        Orientation initialOrientation = Orientation.NORTH;
        Robot robot = new Robot(initialPosition, initialOrientation);
        robot.executeInstructions(grid, instructions);

        Assert.assertThat(robot.getCurrentPosition(), Matchers.is(initialOrientation.calculateNextForwardPosition(initialPosition)));
    }
}

