package instruction;

import data.Position;
import robot.Robot;

public enum Instruction
{
    F
            {
                @Override
                public void execute(Robot robot)
                {
                    Position newPosition = robot.getCurrentOrientation().calculateNextForwardPosition(robot.getCurrentPosition());
                    robot.updatePosition(newPosition);
                }
            },
    R
            {
                @Override
                public void execute(Robot robot)
                {
                    Orientation newOrientation = TurnUtils.calculateNextRightOrientation(robot.getCurrentOrientation());
                    robot.updateOrientation(newOrientation);
                }
            },
    L
            {
                @Override
                public void execute(Robot robot)
                {
                    Orientation newOrientation = TurnUtils.calculateNextLeftOrientation(robot.getCurrentOrientation());
                    robot.updateOrientation(newOrientation);
                }
            };

    public abstract void execute(Robot robot);

}
