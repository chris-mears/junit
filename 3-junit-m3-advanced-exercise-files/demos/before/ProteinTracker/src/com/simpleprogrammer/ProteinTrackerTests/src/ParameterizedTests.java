import com.simpleprogrammer.proteintracker.TrackingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


//Sets up Parameterized Test
@RunWith(Parameterized.class)
public class ParameterizedTests {


    //variables set up at class level to keep data through each iteration of the test
    private static TrackingService service = new TrackingService();
    private final int input;
    private final int expected;

    //static method to set up input and expected for tests
    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {5, 5},
                {5, 10},
                {-12, 0},
                {50, 50},
                {1, 51}
        });
    }

    //constructor to connect data to test
    public ParameterizedTests(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    //Test that runs the parameterized test. Will run different methods based off of the input.
    //When test runs will show each iteration of the Parameterized test
    @Test
    public void test() {
        if(input >= 0 )
            service.addProtein(input);
        else
            service.removeProtein(-input);

        assertEquals(expected, service.getTotal());
    }
}
