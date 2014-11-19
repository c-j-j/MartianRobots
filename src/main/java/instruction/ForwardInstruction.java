package instruction;

import data.Position;

public class ForwardInstruction implements Instruction {
    @Override
    public void execute(Robot robot) {
        Position newPosition = robot.getCurrentOrientation().calculateNextForwardPosition(robot.getCurrentPosition());
        robot.updatePosition(newPosition);
    }
}
