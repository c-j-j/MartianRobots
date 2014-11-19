package instruction;

import data.Position;

public enum Instruction
{
    FORWARD
            {
                @Override
                public void execute(Robot robot)
                {
                    Position newPosition = robot.getCurrentOrientation().calculateNextForwardPosition(robot.getCurrentPosition());
                    robot.updatePosition(newPosition);
                }
            },
    RIGHT
            {
                @Override
                public void execute(Robot robot)
                {
                    Orientation newOrientation = TurnUtils.calculateNextRightOrientation(robot.getCurrentOrientation());
                    robot.updateOrientation(newOrientation);
                }
            },
    LEFT
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
