package instruction;

import data.Position;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import robot.Robot;

public class TurnRightInstructionTest
{

    public static final int X = 1;
    public static final int Y = 2;

    @Test
    public void shouldUpdateRobotOrientationWhenTurningRight() throws Exception
    {
        Position initialPosition = new Position(X, Y);
        Orientation initialOrientation = Orientation.N;
        Robot robot = new Robot(initialPosition, initialOrientation);
        Instruction.R.execute(robot);

        Assert.assertThat(robot.getCurrentOrientation(), Matchers.is(TurnUtils.calculateNextRightOrientation(initialOrientation)));
    }
}