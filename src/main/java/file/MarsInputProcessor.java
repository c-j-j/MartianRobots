package file;

import data.Grid;
import data.Position;
import robot.Robot;
import robot.RobotAction;

public class MarsInputProcessor
{
    public static final String RESULT_FORMAT = "%d %d %s\n";
    public static final String RESULT_LOST_FORMAT = "%d %d %s LOST\n";

    public String process(MarsInput marsInput)
    {
        Grid grid = new Grid(marsInput.getUpperXCoordinate(), marsInput.getUpperYCoordinate());

        StringBuilder resultBuilder = new StringBuilder();
        for (RobotAction robotAction : marsInput.getRobotActions())
        {
            Robot robot = robotAction.getRobot();
            robot.executeInstructions(grid, robotAction.getInstructions());
            if (!robot.isLost())
            {
                Position finalPosition = robot.getCurrentPosition();
                resultBuilder.append(String.format(RESULT_FORMAT, finalPosition.getX(), finalPosition.getY(), robot.getCurrentOrientation()));
            } else
            {
                Position lastKnownPosition = robot.getPreviousPosition();
                resultBuilder.append(String.format(RESULT_LOST_FORMAT, lastKnownPosition.getX(), lastKnownPosition.getY(), robot.getCurrentOrientation()));
            }
        }
        return resultBuilder.toString();
    }
}
