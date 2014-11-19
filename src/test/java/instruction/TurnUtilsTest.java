package instruction;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class TurnUtilsTest
{
    @Test
    public void shouldTurnEastWhenFacingNorthAndTurningRight() throws Exception
    {
        Assert.assertThat(TurnUtils.calculateNextRightOrientation(Orientation.N), Matchers.is(Orientation.E));
    }

    @Test
    public void shouldTurnSouthWhenFacingEastAndTurningRight() throws Exception
    {
        Assert.assertThat(TurnUtils.calculateNextRightOrientation(Orientation.E), Matchers.is(Orientation.S));
    }

    @Test
    public void shouldTurnWestWhenFacingSouthAndTurningRight() throws Exception
    {
        Assert.assertThat(TurnUtils.calculateNextRightOrientation(Orientation.S), Matchers.is(Orientation.W));
    }

    @Test
    public void shouldTurnNorthWhenFacingWestAndTurningRight() throws Exception
    {
        Assert.assertThat(TurnUtils.calculateNextRightOrientation(Orientation.W), Matchers.is(Orientation.N));
    }

    @Test
    public void shouldTurnWestWhenFacingNorthAndTurningLeft() throws Exception
    {
        Assert.assertThat(TurnUtils.calculateNextLeftOrientation(Orientation.N), Matchers.is(Orientation.W));
    }

    @Test
    public void shouldTurnSouthWhenFacingWestAndTurningLeft() throws Exception
    {
        Assert.assertThat(TurnUtils.calculateNextLeftOrientation(Orientation.W), Matchers.is(Orientation.S));
    }

    @Test
    public void shouldTurnEastWhenFacingSouthAndTurningLeft() throws Exception
    {
        Assert.assertThat(TurnUtils.calculateNextLeftOrientation(Orientation.S), Matchers.is(Orientation.E));
    }

    @Test
    public void shouldTurnNorthWhenFacingEastAndTurningLeft() throws Exception
    {
        Assert.assertThat(TurnUtils.calculateNextLeftOrientation(Orientation.E), Matchers.is(Orientation.N));
    }
}