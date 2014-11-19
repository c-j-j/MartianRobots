package instruction;

import data.Position;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class TurnleftInstructionTest
{
    public static final int X = 2;
    public static final int Y = 2;

    @Test
    public void shouldUpdateRobotOrientationWhenTurningLeft() throws Exception
    {
        Position initialPosition = new Position(X, Y);
        Orientation initialOrientation = Orientation.NORTH;
        Robot robot = new Robot(initialPosition, initialOrientation);
        InstructionSet.LEFT.execute(robot);

        Assert.assertThat(robot.getCurrentOrientation(), Matchers.is(TurnUtils.calculateNextLeftOrientation(initialOrientation)));
    }
}