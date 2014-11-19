package file.builder;

import file.MarsInput;
import instruction.Instruction;
import robot.Robot;
import robot.RobotAction;

import java.util.ArrayList;
import java.util.List;

public class MarsInputBuilder
{
    private int upperXCoordinate;
    private int upperYCoordinate;
    private List<RobotAction> robotActions = new ArrayList<>();

    public MarsInputBuilder withUpperXCoordinate(int upperXCoordinate)
    {
        this.upperXCoordinate = upperXCoordinate;
        return this;
    }

    public MarsInputBuilder withUpperYCoordinate(int upperYCoordinate)
    {
        this.upperYCoordinate = upperYCoordinate;
        return this;
    }

    public MarsInputBuilder withRobotAndInstructions(Robot robot, List<Instruction> instructions)
    {
        robotActions.add(new RobotAction(robot, instructions));
        return this;
    }

    public MarsInput build()
    {
        return new MarsInput(upperXCoordinate, upperYCoordinate, robotActions);
    }
}
