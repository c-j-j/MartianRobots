package instruction;

import data.Position;

public class ForwardInstruction implements Instruction {
    @Override
    public void execute(Robot robot) {
        Position newPosition = robot.getOrientation().goForward(robot.getCurrentPosition());
        robot.updatePosition(newPosition);
    }
}
