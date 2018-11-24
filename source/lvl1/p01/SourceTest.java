package source.lvl1.p01;

import org.junit.Test;
import source.support.test.BaseTest;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SourceTest extends BaseTest {

    @Test
    public void testNull() {
        assertEquals(Source.bubbleSortArray(null), null);
    }

    @Test
    public void testEmpty() {
        assertEquals(Source.bubbleSortArray(new int[]{}).length, 0);
    }

    @Test
    public void testWithOnePositive() {
        assertEquals(Source.bubbleSortArray(new int[]{1})[0], 1);
    }

    @Test
    public void testWithOneNegative() {
        assertEquals(Source.bubbleSortArray(new int[]{-1})[0], -1);
    }

    @Test
    public void testWithZero() {
        assertEquals(Source.bubbleSortArray(new int[]{0})[0], 0);
    }

    @Test
    public void testUnsortedPositive() {
        assertTrue(Arrays.deepEquals(convertToBoxedArray(new int[]{3,1,2}),
                    new Integer[]{1,2,3}));
    }

    @Test
    public void  testUnsortedNegative() {
        assertTrue(Arrays.deepEquals(convertToBoxedArray(new int[]{-3,-1,-2}),
                new Integer[]{-3, -2, -1}));
    }

    @Test
    public void testUnsorted() {
        assertTrue(Arrays.deepEquals(convertToBoxedArray(new int[]{-3,1,-2}),
                    new Integer[]{-3, -2, 1}));
    }

    @Test
    public void testSortedPositive() {
        assertTrue(Arrays.deepEquals(convertToBoxedArray(new int[]{3,2,1}),
                    new Integer[]{1,2,3}));
    }

    @Test
    public void testSortedNegative() {
        assertTrue(Arrays.deepEquals(convertToBoxedArray(new int[]{-1,-2,-3}),
                    new Integer[]{-3,-2,-1}));
    }

    @Test
    public void testSorted() {
        assertTrue(Arrays.deepEquals(convertToBoxedArray(new int[]{3,2,-1}),
                    new Integer[]{-1,2,3}));
    }

    /* ******************************************************************************** */

    private Integer[] convertToBoxedArray(final int[] arr) {
        return Arrays.stream(Source.bubbleSortArray(arr)).boxed().toArray(Integer[]::new);
    }
}
