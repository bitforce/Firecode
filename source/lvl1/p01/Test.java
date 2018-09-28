package source.lvl1.p01;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
class Test {
    public static void main(String[] args) {
        final int[] arr = new int[args.length];
        for (int i = 0 ; i < args.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        for (int i : Source.bubbleSortArray(arr))
            System.out.print(i + " ");
        System.out.println();
    }

    @Test
    public void nullArray() {
        System.out.println("testing null array");
        final int[] arr = null;
        assertEquals(Source.bubbleSortArray(arr), null);
    }
}
