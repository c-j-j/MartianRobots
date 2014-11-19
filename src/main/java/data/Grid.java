package data;

public class Grid
{
    public static final int ZERO_COORDINATE = 0;
    private final int upperXCoordinate;
    private final int upperYCoordinate;

    public Grid(int upperXCoordinate, int upperYCoordinate)
    {
        this.upperXCoordinate = upperXCoordinate;
        this.upperYCoordinate = upperYCoordinate;
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
}
