import data.Grid;
import data.Position;
import instruction.Instruction;
import instruction.Orientation;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
        Position lastKnownPosition = new Position(UPPER_X_COORDINATE, UPPER_Y_COORDINATE);
        Instruction forward = Instruction.FORWARD;
        Orientation north = Orientation.NORTH;
        grid.registerLostMove(lastKnownPosition, north, forward);
        List<Grid.LostMove> lostMoves = grid.getLostMoves();

        Assert.assertThat(lostMoves, Matchers.hasSize(1));

        Grid.LostMove lostMove = lostMoves.get(0);
        Assert.assertThat(lostMove.getPosition(), Matchers.is(lastKnownPosition));
        Assert.assertThat(lostMove.getInstruction(), Matchers.is(forward));
        Assert.assertThat(lostMove.getOrientation(), Matchers.is(north));
    }

    @Test
    public void shouldReturnTrueWhenNextMoveHasLostAPreviousRobot() throws Exception
    {
        Position lastKnownPosition = new Position(UPPER_X_COORDINATE, UPPER_Y_COORDINATE);
        Instruction forward = Instruction.FORWARD;
        Orientation north = Orientation.NORTH;
        grid.registerLostMove(lastKnownPosition, north, forward);

        Assert.assertThat(grid.willNextMoveLoseRobot(lastKnownPosition, north, forward), Matchers.is(true));
    }

    @Test
    public void shouldReturnFalseWhenNextMoveHasNotLostAPreviousRobot() throws Exception
    {
        Position lastKnownPosition = new Position(UPPER_X_COORDINATE, UPPER_Y_COORDINATE);
        Instruction forward = Instruction.FORWARD;
        Orientation north = Orientation.NORTH;
        grid.registerLostMove(lastKnownPosition, north, forward);

        int x = UPPER_X_COORDINATE - 1;
        Assert.assertThat(grid.willNextMoveLoseRobot(new Position(x, UPPER_Y_COORDINATE), north, forward), Matchers.is(false));
    }
}