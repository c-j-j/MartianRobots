package instruction;

public class TurnRightInstruction implements Instruction
{
    @Override
    public void execute(Robot robot)
    {
        Orientation newOrientation = TurnUtils.calculateNextRightOrientation(robot.getCurrentOrientation());
        robot.updateOrientation(newOrientation);
    }
}
