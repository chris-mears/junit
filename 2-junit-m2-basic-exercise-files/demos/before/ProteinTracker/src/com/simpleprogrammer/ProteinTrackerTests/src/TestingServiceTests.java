import com.simpleprogrammer.proteintracker.InvalidGoalException;
import org.junit.*;
import com.simpleprogrammer.proteintracker.TrackingService;
import static org.junit.Assert.*;

public class TestingServiceTests {

    private TrackingService service;

    //Used to run a method before all test. Must be a static method
    @BeforeClass
    public static void before() {
        System.out.println("Before Class");
    }

    //Used to run a method after all test. Must be a static method
    @AfterClass
    public static void after() {
        System.out.println("After Class");
    }

    /*
    This before method will run before each test in the suite
    The System.out.println is to show the before running for each test
    */
    @Before
    public void setUp() {
        System.out.println("Before");
        service = new TrackingService();
    }

    /*
    This will run after each test using System.out to demo
    Most likely useful in dropping a test database
    */
    @After
    public void tearDown() {
        System.out.println("After");
    }

    @Test
    public void newTrackingServiceTotalIsZero() {
        assertEquals("Tracking service total was not zero", 0, service.getTotal());
    }

    @Test
    //@Ignore - allows us to ignore a test when we need to.
    public void whenAddingProteinTotalIncreasesByThatAmount() {
        service.addProtein(10);
        assertEquals("Portien amount was not correct", 10, service.getTotal());
    }

    @Test
    public void whenRemovingProteinTotalRemainsZero() {
        service.removeProtein(5);
        assertEquals(0, service.getTotal());
    }

    //Test that will expect an exception
    @Test(expected = InvalidGoalException.class)
    public void whenGoalIsSetToLessThenZeroExceptionIsThrown() throws InvalidGoalException {
        service.setGoal(-5);
    }

    //Test setup for a timeout if the test takes longer than 200ms it will fail
    @Test(timeout = 200)
    public void basTest() {
        for(int i = 0; i < 100000; i++) {
            service.addProtein(1);
        }
    }
}
