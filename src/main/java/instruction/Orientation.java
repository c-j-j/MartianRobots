package instruction;

import data.Position;

public enum Orientation
{
    NORTH
            {
                @Override
                public Position calculateNextForwardPosition(Position currentPosition)
                {

                    int newYCoordinate = currentPosition.getY() + 1;
                    return new Position(currentPosition.getX(), newYCoordinate);
                }
            },
    EAST
            {
                @Override
                public Position calculateNextForwardPosition(Position currentPosition)
                {
                    int newXCoordinate = currentPosition.getX() + 1;
                    return new Position(newXCoordinate, currentPosition.getY());
                }
            },
    SOUTH
            {
                @Override
                public Position calculateNextForwardPosition(Position currentPosition)
                {
                    int newYCoordinate = currentPosition.getY() - 1;
                    return new Position(currentPosition.getX(), newYCoordinate);
                }
            },
    WEST
            {
                @Override
                public Position calculateNextForwardPosition(Position currentPosition)
                {
                    int newXCoordinate = currentPosition.getX() - 1;
                    return new Position(newXCoordinate, currentPosition.getY());
                }
            };

    public abstract Position calculateNextForwardPosition(Position currentPosition);
}
