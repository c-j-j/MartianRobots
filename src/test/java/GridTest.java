import data.Grid;
import data.Position;
import instruction.ForwardInstruction;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class GridTest {

    @Test
    public void testGridCanCalculateNextPositionWhenNorthInstructionGiven() throws Exception {
        Grid grid = new Grid(3, 4);

        Position position = grid.calculateNextPosition(0, 0, new ForwardInstruction());

        Assert.assertThat(position.getX(), Matchers.is(1));
    }
}