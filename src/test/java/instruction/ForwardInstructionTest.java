package instruction;

import data.Position;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import robot.Robot;

public class ForwardInstructionTest
{
    public static final int X = 1;
    public static final int Y = 2;

    @Test
    public void shouldUpdateRobotsPositionByGoingForward() throws Exception
    {
        Position initialPosition = new Position(X, Y);
        Orientation orientation = Orientation.N;
        Robot robot = new Robot(initialPosition, orientation);
        Instruction.F.execute(robot);

        Assert.assertThat(robot.getCurrentPosition(), Matchers.is(orientation.calculateNextForwardPosition(initialPosition)));
    }
}