package instruction;

import data.Position;

public enum Orientation
{
    N
            {
                @Override
                public Position calculateNextForwardPosition(Position currentPosition)
                {

                    int newYCoordinate = currentPosition.getY() + 1;
                    return new Position(currentPosition.getX(), newYCoordinate);
                }
            },
    E
            {
                @Override
                public Position calculateNextForwardPosition(Position currentPosition)
                {
                    int newXCoordinate = currentPosition.getX() + 1;
                    return new Position(newXCoordinate, currentPosition.getY());
                }
            },
    S
            {
                @Override
                public Position calculateNextForwardPosition(Position currentPosition)
                {
                    int newYCoordinate = currentPosition.getY() - 1;
                    return new Position(currentPosition.getX(), newYCoordinate);
                }
            },
    W
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
