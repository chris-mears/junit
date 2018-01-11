import static org.junit.Assert.*;

import org.junit.*;

import com.simpleprogrammer.proteintracker.InvalidGoalException;
import com.simpleprogrammer.proteintracker.TrackingService;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.hamcrest.CoreMatchers.*;

public class TrackingServiceTests {

	private TrackingService service;
	@BeforeClass
	public static void before()
	{
		System.out.println("Before Class");
	}
	
	@AfterClass
	public static void after()
	{
		System.out.println("After Class");
	}
	
	@Before
	public void setUp() 
	{
		System.out.println("Before");
		service = new TrackingService();
	}
	
	@After
	public void tearDown()
	{
		System.out.println("After");
	}
	

	@Test
	@Category(GoodTestsCategory.class)
	public void NewTrackingServiceTotalIsZero()
	{
		assertEquals("Tracking service total was not zero", 0, service.getTotal());
	}
	
	@Test
	@Category(GoodTestsCategory.class)
	public void WhenAddingProteinTotalIncreasesByThatAmount() 
	{
		service.addProtein(10);
		assertEquals(10, service.getTotal());
		//same as assert above
		assertThat(service.getTotal(), is(10));
		//asertion that checks all assertions inside the allOf
		assertThat(service.getTotal(), allOf(is(10), instanceOf(Integer.class)));
	}
	
	@Test
	@Category(GoodTestsCategory.class)
	public void WhenRemovingProteinTotalRemainsZero() 
	{
		service.removeProtein(5);
		assertEquals(0, service.getTotal());
	}

	@Rule
    public ExpectedException trown = ExpectedException.none();
	
	@Test
	@Category(GoodTestsCategory.class)
	public void WhenGoalIsSetToLessThanZeroExceptionIsThrown() throws InvalidGoalException
	{
	    trown.expect(InvalidGoalException.class);
	    trown.expectMessage(containsString("Goal"));
		service.setGoal(-5);
	}

	@Rule
    public Timeout timeout = new Timeout(20);
	
	@Test
	@Category(BadTestsCategory.class)
	public void BadTest()
	{
		for(int i = 0; i < 10000000; i++)
			service.addProtein(1);
	}
}
