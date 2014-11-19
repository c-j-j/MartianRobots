package file;

import robot.RobotAction;

import java.util.List;

public class MarsInput
{
    private final int upperXCoordinate;
    private final int upperYCoordinate;
    private final List<RobotAction> robotActions;

    public MarsInput(int upperXCoordinate, int upperYCoordinate, List<RobotAction> robotActions)
    {
        this.upperXCoordinate = upperXCoordinate;
        this.upperYCoordinate = upperYCoordinate;
        this.robotActions = robotActions;
    }

    public int getUpperXCoordinate()
    {
        return upperXCoordinate;
    }

    public int getUpperYCoordinate()
    {
        return upperYCoordinate;
    }

    public List<RobotAction> getRobotActions()
    {
        return robotActions;
    }
}
