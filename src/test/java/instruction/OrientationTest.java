package instruction;

import data.Position;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class OrientationTest
{
    @Test
    public void shouldIncrementYAxisWhenInNorthOrientation() throws Exception
    {
        int y = 1;
        int x = 0;
        Position nextForwardPosition = Orientation.N.calculateNextForwardPosition(new Position(x, y));

        Assert.assertThat(nextForwardPosition.getX(), Matchers.is(x));
        Assert.assertThat(nextForwardPosition.getY(), Matchers.is(++y));
    }

    @Test
    public void shouldDecrementYAxisWhenInSouthOrientation() throws Exception
    {
        int y = 1;
        int x = 2;
        Position nextForwardPosition = Orientation.S.calculateNextForwardPosition(new Position(x, y));

        Assert.assertThat(nextForwardPosition.getX(), Matchers.is(x));
        Assert.assertThat(nextForwardPosition.getY(), Matchers.is(--y));
    }

    @Test
    public void shouldIncrementXAxisWhenInEastOrientation() throws Exception
    {
        int y = 1;
        int x = 0;
        Position nextForwardPosition = Orientation.E.calculateNextForwardPosition(new Position(x, y));

        Assert.assertThat(nextForwardPosition.getX(), Matchers.is(++x));
        Assert.assertThat(nextForwardPosition.getY(), Matchers.is(y));
    }

    @Test
    public void shouldDecrementXAxisWhenInWestOrientation() throws Exception
    {
        int y = 1;
        int x = 3;
        Position nextForwardPosition = Orientation.W.calculateNextForwardPosition(new Position(x, y));

        Assert.assertThat(nextForwardPosition.getX(), Matchers.is(--x));
        Assert.assertThat(nextForwardPosition.getY(), Matchers.is(y));
    }
}
