import com.simpleprogrammer.proteintracker.TrackingService;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

//Sets up class to run tests as theories
@RunWith(Theories.class)
public class TrackingServiceTheories {

    //Sets up the data point to run in the theory
    @DataPoints
    public static int[] data() {
        return new int[] {
                1, 5, 10, 15, 20, 50, -4
        };
    }

    //Theory that checks DataPoint against assertion
    @Theory
    public void positiveValuersShouldAlwaysHavePositiveTotals(int value) {
        TrackingService service = new TrackingService();
        service.addProtein(value);
        //makes assumption on the data and if it isn't true then it will ignore data
        Assume.assumeTrue(value > 0);

        assertTrue(service.getTotal() > 0);
    }
}
