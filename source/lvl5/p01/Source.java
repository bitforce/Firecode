package source.lvl5.p01;
import source.temp.graph.Graph;
import java.util.*;
class Source {
    /* ********************************************************************* */
    /* ********************************************************************* */
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        for(int i = 0; i < args.length; i++) { // subtract by the amount 
            int n = Integer.parseInt(args[i]); 
            if(n == 1) {
                graph.add(args[i+1]);
                i++;
            } else if(n == 2) {
                graph.add(args[i+1], args[i+2]);
                i += 2;
            } else throw new Error("\n\nInvalid integer argument, must be 1 or 2.\n");
        }
        System.out.println();
        graph.print();
    }
}
