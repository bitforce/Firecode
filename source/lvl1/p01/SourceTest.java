package source.lvl1.p01;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
class SourceTest {
    private static final Logger logger = Logger.getLogger(SourceTest.class.getName());
//    public static void main(String[] args) {
//        if(args[0].equals("test") && args.length == 1) return;
//        final int[] arr = new int[args.length];
//        for (int i = 0 ; i < args.length; i++)
//            arr[i] = Integer.parseInt(args[i]);
//        for (int i : Source.bubbleSortArray(arr))
//            System.out.print(i + " ");
//        System.out.println();
//        System.exit(0);
//    }


    @Test
    public void testNull() {
        logger.info("hey bitch");
        System.out.println("testing null array");
        final int[] arr = null;
        assertEquals(Source.bubbleSortArray(arr), null);
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
