package source.lvl1.p01;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SourceTest {
    private static final Logger logger = Logger.getLogger(SourceTest.class.getName());

    @Test
    public void testNull() {
        logger.info("testing null arr");
        assertEquals(Source.bubbleSortArray(null), null);
    }

    @Test
    public void testEmpty() {}

    @Test
    public void testWithOnePositive() {}

    @Test
    public void testWithOneNegative() {}

    @Test
    public void testWithZero() {}

    @Test
    public void testUnsortedPositive() {}

    @Test
    public void  testUnsortedNegative() {}

    @Test
    public void testUnsorted() {}

    @Test
    public void testSortedPositive() {}

    @Test
    public void testSortedNegative() {}

    @Test
    public void testSorted() {}
}
