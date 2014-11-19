import data.Grid;
import data.Position;
import instruction.InstructionSet;
import instruction.Orientation;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GridTest
{

    public static final int UPPER_X_COORDINATE = 3;
    public static final int UPPER_Y_COORDINATE = 4;
    private Grid grid;

    @Before
    public void setUp() throws Exception
    {
        grid = new Grid(UPPER_X_COORDINATE, UPPER_Y_COORDINATE);
    }

    @Test
    public void shouldReturnTrueWhenPositionIsOnUpperRightOfGrid() throws Exception
    {
        Assert.assertThat(grid.isPositionOnGrid(new Position(UPPER_X_COORDINATE, UPPER_Y_COORDINATE)), Matchers.is(true));
    }

    @Test
    public void shouldReturnTrueWhenPositionIsOnLowerLeftOfGrid() throws Exception
    {
        Assert.assertThat(grid.isPositionOnGrid(new Position(Grid.ZERO_COORDINATE, Grid.ZERO_COORDINATE)), Matchers.is(true));
    }

    @Test
    public void shouldReturnFalseWhenPositionHasXCoordinateGreaterThanGridSize() throws Exception
    {
        int x = UPPER_X_COORDINATE + 1;
        Assert.assertThat(grid.isPositionOnGrid(new Position(x, UPPER_Y_COORDINATE)), Matchers.is(false));
    }

    @Test
    public void shouldReturnFalseWhenPositionHasYCoordinateGreaterThanGridSize() throws Exception
    {
        int y = UPPER_Y_COORDINATE + 1;
        Assert.assertThat(grid.isPositionOnGrid(new Position(UPPER_X_COORDINATE, y)), Matchers.is(false));
    }

    @Test
    public void shouldReturnFalseWhenPositionHasXCoordinateLowerThanZero() throws Exception
    {
        int x = Grid.ZERO_COORDINATE - 1;
        Assert.assertThat(grid.isPositionOnGrid(new Position(x, UPPER_Y_COORDINATE)), Matchers.is(false));
    }

    @Test
    public void shouldReturnFalseWhenPositionHasYCoordinateLowerThanZero() throws Exception
    {
        int y = Grid.ZERO_COORDINATE - 1;
        Assert.assertThat(grid.isPositionOnGrid(new Position(UPPER_X_COORDINATE, y)), Matchers.is(false));
    }

    @Test
    public void shouldRegisterAPositionAndInstructionThatWillPreventNextRobotBeingLost() throws Exception
    {
        grid.registerLostMove(new Position(UPPER_X_COORDINATE,UPPER_Y_COORDINATE), Orientation.NORTH, InstructionSet.FORWARD);
    }
}