package instruction;

public class TurnRightInstruction implements Instruction {


    @Override
    public void execute(Robot robot) {
        Orientation orientation = robot.getOrientation();
        orientation.turnRight();
    }
}
