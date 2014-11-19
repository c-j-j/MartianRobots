package instruction;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class TurnUtilsTest
{
    @Test
    public void shouldTurnEastWhenFacingNorthAndTurningRight() throws Exception
    {
        Assert.assertThat(TurnUtils.calculateNextRightOrientation(Orientation.NORTH), Matchers.is(Orientation.EAST));
    }

    @Test
    public void shouldTurnSouthWhenFacingEastAndTurningRight() throws Exception
    {
        Assert.assertThat(TurnUtils.calculateNextRightOrientation(Orientation.EAST), Matchers.is(Orientation.SOUTH));
    }

    @Test
    public void shouldTurnWestWhenFacingSouthAndTurningRight() throws Exception
    {
        Assert.assertThat(TurnUtils.calculateNextRightOrientation(Orientation.SOUTH), Matchers.is(Orientation.WEST));
    }

    @Test
    public void shouldTurnNorthWhenFacingWestAndTurningRight() throws Exception
    {
        Assert.assertThat(TurnUtils.calculateNextRightOrientation(Orientation.WEST), Matchers.is(Orientation.NORTH));
    }

    @Test
    public void shouldTurnWestWhenFacingNorthAndTurningLeft() throws Exception
    {
        Assert.assertThat(TurnUtils.calculateNextLeftOrientation(Orientation.NORTH), Matchers.is(Orientation.WEST));
    }

    @Test
    public void shouldTurnSouthWhenFacingWestAndTurningLeft() throws Exception
    {
        Assert.assertThat(TurnUtils.calculateNextLeftOrientation(Orientation.WEST), Matchers.is(Orientation.SOUTH));
    }

    @Test
    public void shouldTurnEastWhenFacingSouthAndTurningLeft() throws Exception
    {
        Assert.assertThat(TurnUtils.calculateNextLeftOrientation(Orientation.SOUTH), Matchers.is(Orientation.EAST));
    }

    @Test
    public void shouldTurnNorthWhenFacingEastAndTurningLeft() throws Exception
    {
        Assert.assertThat(TurnUtils.calculateNextLeftOrientation(Orientation.EAST), Matchers.is(Orientation.NORTH));
    }
}