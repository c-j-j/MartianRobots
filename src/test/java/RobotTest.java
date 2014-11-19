import data.Grid;
import data.Position;
import instruction.*;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RobotTest
{
    @Test
    public void testRobotInstruction() throws Exception
    {
        Grid grid = new Grid(3, 4);
        List<Instruction> instructions = new ArrayList<Instruction>();
        instructions.add(new ForwardInstruction());
        instructions.add(new TurnRightInstruction());
        Robot robot = null;
        robot.executeInstructions(grid, instructions);

        Position position = robot.getCurrentPosition();

        Assert.assertThat(position.getX(), Matchers.is(1));
        Assert.assertThat(position.getY(), Matchers.is(2));
    }
}

