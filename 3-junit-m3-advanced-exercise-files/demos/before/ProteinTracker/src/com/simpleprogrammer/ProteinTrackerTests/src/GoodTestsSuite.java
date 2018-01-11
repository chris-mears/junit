import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


//Annotation to set up a test suite that uses categories to filter test
@RunWith(Categories.class)
//Suite will include all GoodTestsCategory
@Categories.IncludeCategory(GoodTestsCategory.class)
//Suite will exclude all BadTestsCategory
@Categories.ExcludeCategory(BadTestsCategory.class)
//Still need to specify which test class to have apart of the suite.
@Suite.SuiteClasses({
        HelloJUnitTest.class,
        TrackingServiceTests.class
})
public class GoodTestsSuite {
}
