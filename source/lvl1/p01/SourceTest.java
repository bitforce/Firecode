package source.lvl1.p01;

import java.util.Arrays;
import java.util.logging.Logger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SourceTest {
    private static final Logger logger = Logger.getLogger(SourceTest.class.getName());

    @Test
    public void testNull() {
        logger.info("null");
        assertEquals(Source.bubbleSortArray(null), null);
    }

    @Test
    public void testEmpty() {
        logger.info("empty");
        assertEquals(Source.bubbleSortArray(new int[]{}).length, 0);
    }

    @Test
    public void testWithOnePositive() {
        logger.info("one positive");
        assertEquals(Source.bubbleSortArray(new int[]{1})[0], 1);
    }

    @Test
    public void testWithOneNegative() {
        logger.info("one negative");
        assertEquals(Source.bubbleSortArray(new int[]{-1})[0], -1);
    }

    @Test
    public void testWithZero() {
        logger.info("zero");
        assertEquals(Source.bubbleSortArray(new int[]{0})[0], 0);
    }

    @Test
    public void testUnsortedPositive() {
        logger.info("unsorted positive");
        assertTrue(Arrays.deepEquals(convertToBoxedArray(new int[]{3,1,2}),
                    new Integer[]{1,2,3}));
    }

    @Test
    public void  testUnsortedNegative() {
        logger.info("unsorted negative"); 
        assertTrue(Arrays.deepEquals(convertToBoxedArray(new int[]{-3,-1,-2}),
                new Integer[]{-3, -2, -1}));
    }

    @Test
    public void testUnsorted() {
        logger.info("unsorted"); 
        assertTrue(Arrays.deepEquals(convertToBoxedArray(new int[]{-3,1,-2}),
                    new Integer[]{-3, -2, 1}));
    }

    @Test
    public void testSortedPositive() {
        logger.info("sorted positive"); 
        assertTrue(Arrays.deepEquals(convertToBoxedArray(new int[]{3,2,1}),
                    new Integer[]{1,2,3}));

    }

    @Test
    public void testSortedNegative() {
        logger.info("sorted negative"); 
        assertTrue(Arrays.deepEquals(convertToBoxedArray(new int[]{-1,-2,-3}),
                    new Integer[]{-3,-2,-1}));

    }

    @Test
    public void testSorted() {
        logger.info("sorted positive"); 
        assertTrue(Arrays.deepEquals(convertToBoxedArray(new int[]{3,2,-1}),
                    new Integer[]{-1,2,3}));

    }

    /* ****************************************************************************************** */

    private Integer[] convertToBoxedArray(final int[] arr) {
        return Arrays.stream(Source.bubbleSortArray(arr)).boxed().toArray(Integer[]::new);
    }
}
