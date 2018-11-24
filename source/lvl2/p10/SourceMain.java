package source.lvl2.p10;

import java.util.ArrayList;
import java.util.Collections;

import static source.lvl2.p10.Source.removeDuplicates;
import static source.lvl2.p10.Source.removeDuplicates2;
import static source.lvl2.p10.Source.removeDuplicates3;

public class SourceMain {
     public static void main(String[] args) {
        final ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, args);
        System.out.println(removeDuplicates(list));
        System.out.println(removeDuplicates2(list));
        System.out.println(removeDuplicates3(list));
    }
}
