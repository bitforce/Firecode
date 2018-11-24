package source.lvl3.p10;

import java.util.ArrayList;

class Source {
    static ArrayList<Integer> findSpiral(final int[][] arr) {
        final ArrayList<Integer> list = new ArrayList<>();
        int clen = arr[0].length;
        int rlen = arr.length;
        int ridx = 0;
        int cidx = 0;
        int i;
        while(ridx < rlen && cidx < clen) {
            for(i = cidx; i < clen; ++i)
                list.add(arr[ridx][i]);
            ridx++;
            for(i = ridx; i < rlen; ++i)
                list.add(arr[i][clen-1]);
            clen--;
            if(ridx < rlen) {
                for(i = clen-1; i >= cidx; --i)
                    list.add(arr[rlen-1][i]);
                rlen--;
            }
            if(cidx < clen) {
                for(i = rlen-1; i >= ridx; --i)
                    list.add(arr[i][cidx]);
                cidx++;                
            } 
        }
        return list;
    }
}
