

import org.junit.Assert;
import org.junit.Test;

import ecole.Example;


public class ExampleTest {

    @Test
    public void Example() {
        Example example = new Example();

        Assert.assertEquals("Hello World!", example.home());
    }


}
