package integration;

import main.MarsRobotApplication;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class MarsRobotIntegrationTest
{
    @Test
    public void testSampleInputAgainstApplication() throws Exception
    {
        MarsRobotApplication marsRobotApplication = new MarsRobotApplication();

        String results = marsRobotApplication.process("./input_sample.txt");

        String[] lines = results.split("\n");
        Assert.assertThat(lines[0], Matchers.is("1 1 E"));
        Assert.assertThat(lines[1], Matchers.is("3 3 N LOST"));
        Assert.assertThat(lines[2], Matchers.is("2 3 S"));
    }
}
