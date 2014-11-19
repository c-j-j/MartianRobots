package robot;

import instruction.Instruction;

import java.util.List;

public class RobotAction
{
    private final Robot robot;
    private final List<Instruction> instructions;

    public RobotAction(Robot robot, List<Instruction> instructions)
    {
        this.robot = robot;
        this.instructions = instructions;
    }

    public Robot getRobot()
    {
        return robot;
    }

    public List<Instruction> getInstructions()
    {
        return instructions;
    }
}
