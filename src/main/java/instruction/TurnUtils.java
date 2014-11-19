package instruction;

import java.util.HashMap;
import java.util.Map;

public class TurnUtils
{
    private static final Map<Orientation, Orientation> turnRightMoves = new HashMap<Orientation, Orientation>()
    {{
            put(Orientation.NORTH, Orientation.EAST);
            put(Orientation.EAST, Orientation.SOUTH);
            put(Orientation.SOUTH, Orientation.WEST);
            put(Orientation.WEST, Orientation.NORTH);
        }};

    private static final Map<Orientation, Orientation> turnLeftMoves = new HashMap<Orientation, Orientation>()
    {{
            put(Orientation.NORTH, Orientation.WEST);
            put(Orientation.WEST, Orientation.SOUTH);
            put(Orientation.SOUTH, Orientation.EAST);
            put(Orientation.EAST, Orientation.NORTH);
        }};


    public static Orientation calculateNextRightOrientation(Orientation orientation)
    {
        return turnRightMoves.get(orientation);
    }

    public static Orientation calculateNextLeftOrientation(Orientation orientation)
    {
        return turnLeftMoves.get(orientation);
    }
}
