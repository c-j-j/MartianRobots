package file;

import data.Position;
import instruction.Orientation;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import robot.Robot;
import robot.RobotAction;

import java.io.File;
import java.util.List;

public class MarsInputFileReaderTest
{

    private File file;

    @Before
    public void setUp() throws Exception
    {
        file = new File("someFileName");
        FileUtils.copyInputStreamToFile(getClass().getResourceAsStream("Input.txt"), file);
    }

    @Test
    public void shouldReadUpperCoordinatesFromFile() throws Exception
    {
        MarsInput input = new MarsInputFileReader().read(file);
        Assert.assertThat(input.getUpperXCoordinate(), Matchers.is(5));
        Assert.assertThat(input.getUpperYCoordinate(), Matchers.is(3));
    }

    @Test
    public void shouldReadRobotDetailsWithInstructions() throws Exception
    {
        MarsInput input = new MarsInputFileReader().read(file);
        List<RobotAction> robotActions = input.getRobotActions();

        Assert.assertThat(robotActions, Matchers.hasSize(1));
        RobotAction robotAction = robotActions.get(0);
        Robot robot = robotAction.getRobot();
        Assert.assertThat(robot.getCurrentPosition(), Matchers.is(new Position(1, 1)));
        Assert.assertThat(robot.getCurrentOrientation(), Matchers.is(Orientation.E));
    }
}
