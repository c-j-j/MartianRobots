package instruction;

import java.util.HashMap;
import java.util.Map;

public class TurnUtils
{
    private static final Map<Orientation, Orientation> turnRightMoves = new HashMap<Orientation, Orientation>()
    {{
            put(Orientation.N, Orientation.E);
            put(Orientation.E, Orientation.S);
            put(Orientation.S, Orientation.W);
            put(Orientation.W, Orientation.N);
        }};

    private static final Map<Orientation, Orientation> turnLeftMoves = new HashMap<Orientation, Orientation>()
    {{
            put(Orientation.N, Orientation.W);
            put(Orientation.W, Orientation.S);
            put(Orientation.S, Orientation.E);
            put(Orientation.E, Orientation.N);
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
