package instruction;

import data.Position;

import java.util.HashMap;
import java.util.Map;

public class TurnRightInstruction implements Instruction {

    Map<Orientation, Orientation> turnRightMoves = new HashMap<Orientation, Orientation>() {{
        put(Orientation.NORTH, Orientation.EAST);
        put(Orientation.EAST, Orientation.SOUTH);
        put(Orientation.SOUTH, Orientation.WEST);
        put(Orientation.WEST, Orientation.NORTH);
    }};

    @Override
    public void execute(Robot robot) {
        Orientation newOrientation = turnRightMoves.get(robot.getOrientation());
        robot.setOrientation(newOrientation);
    }
}
