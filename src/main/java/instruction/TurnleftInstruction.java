package instruction;

public class TurnleftInstruction implements Instruction
{
    @Override
    public void execute(Robot robot)
    {
        Orientation newOrientation = TurnUtils.calculateNextLeftOrientation(robot.getCurrentOrientation());
        robot.updateOrientation(newOrientation);
    }
}
