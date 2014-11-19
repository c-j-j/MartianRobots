package file;

import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class MarsInputFileReaderTest
{
    @Test
    public void shouldReadUpperCoordinatesFromFile() throws Exception
    {
        File file = new File("someFileName");
        FileUtils.copyInputStreamToFile(getClass().getResourceAsStream("Input.txt"), file);
        MarsInput input = new MarsInputFileReader().read(file);
        Assert.assertThat(input.getUpperXCoordinate(), Matchers.is(5));
        Assert.assertThat(input.getUpperYCoordinate(), Matchers.is(3));
    }
}
