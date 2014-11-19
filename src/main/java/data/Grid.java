package data;

import instruction.Instruction;
import instruction.Orientation;

import java.util.ArrayList;
import java.util.List;

public class Grid
{
    public static final int ZERO_COORDINATE = 0;
    private final int upperXCoordinate;
    private final int upperYCoordinate;
    private final List<LostMove> lostMoves;

    public Grid(int upperXCoordinate, int upperYCoordinate)
    {
        this.upperXCoordinate = upperXCoordinate;
        this.upperYCoordinate = upperYCoordinate;
        lostMoves = new ArrayList<>();
    }

    public boolean isPositionOnGrid(Position position)
    {
        int x = position.getX();
        int y = position.getY();

        if (x > upperXCoordinate || y > upperYCoordinate)
        {
            return false;
        } else if (x < ZERO_COORDINATE || y < ZERO_COORDINATE)
        {
            return false;
        } else
        {
            return true;
        }
    }

    public void registerLostMove(Position lastKnownPosition, Orientation orientation, Instruction instruction)
    {
        lostMoves.add(new LostMove(lastKnownPosition, orientation, instruction));
    }

    public List<LostMove> getLostMoves()
    {
        return lostMoves;
    }

    public boolean willNextMoveLoseRobot(Position currentPosition, Orientation currentOrientation, Instruction nextInstruction)
    {
        return lostMoves.contains(new LostMove(currentPosition, currentOrientation, nextInstruction));
    }

    public class LostMove{

        private final Position position;
        private final Orientation orientation;
        private final Instruction instruction;

        public LostMove(Position position, Orientation orientation, Instruction instruction)
        {
            this.position = position;
            this.orientation = orientation;
            this.instruction = instruction;
        }

        public Position getPosition()
        {
            return position;
        }

        public Orientation getOrientation()
        {
            return orientation;
        }

        public Instruction getInstruction()
        {
            return instruction;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LostMove lostMove = (LostMove) o;

            if (instruction != lostMove.instruction) return false;
            if (orientation != lostMove.orientation) return false;
            if (position != null ? !position.equals(lostMove.position) : lostMove.position != null) return false;

            return true;
        }

        @Override
        public int hashCode()
        {
            int result = position != null ? position.hashCode() : 0;
            result = 31 * result + (orientation != null ? orientation.hashCode() : 0);
            result = 31 * result + (instruction != null ? instruction.hashCode() : 0);
            return result;
        }
    }
}
