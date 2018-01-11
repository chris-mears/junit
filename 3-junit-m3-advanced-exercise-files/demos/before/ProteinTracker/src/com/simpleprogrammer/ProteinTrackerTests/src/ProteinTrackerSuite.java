import org.junit.runner.RunWith;
import org.junit.runners.Suite;


//Annotation to set up a suite and run multiple test classes
@RunWith(Suite.class)
@Suite.SuiteClasses({
        HelloJUnitTest.class,
        TrackingServiceTests.class
})
public class ProteinTrackerSuite {

}
