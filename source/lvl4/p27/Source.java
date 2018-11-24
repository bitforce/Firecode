package source.lvl4.p27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Source {
    static ArrayList<String> getPermutations(final String s) {
        if(s == null) return null;
        if(s.equals("")) return new ArrayList<>();
        return permute(new ArrayList<>(), s, 0, s.length()-1);
    }
    private static ArrayList<String> permute(
            final ArrayList<String> list,
            String string,
            final int left,
            final int right) {
        if(left != right) {
            for(int i = left; i <= right; i++) {
                string = swap(string, left, i);
                permute(list, string, left+1, right);
                string = swap(string, left, i);
            }
        } else list.add(string);
        return list;
    }
    private static String swap(final String string, final int I, final int J) {
        char[] charr = string.toCharArray();
        char c = charr[I];
        charr[I] = charr[J];
        charr[J] = c;
        return String.valueOf(charr);
    }
    /* ********************************************************************* */
    static ArrayList<String> getPermutations2(final String s) {
        if(s == null) return null;
        final ArrayList<String> permutations = new ArrayList<>();
        if(s.length() == 0) {
            permutations.add("");
            return permutations;
        }
        final char c = s.charAt(0);
        final String remainder = s.substring(1);
        final ArrayList<String> words = getPermutations2(remainder);
        for(String word : words)
            for(int i = 0; i <= word.length(); i++)
                permutations.add(insertCharAt(word, c, i));
        return permutations;
    }
    private static String insertCharAt(String word, char c, int i) {
        return word.substring(0, i) + c + word.substring(i);
    }
    /* ********************************************************************* */
    private static HashMap<String,ArrayList<String>> memo = new HashMap<String,ArrayList<String>>();
    static ArrayList<String> getPermutations3(String s) {
        final ArrayList<String> res= new ArrayList<>();
        if(s==null ) return null;
        if(s.isEmpty()) return res;
        if(s.length()==1){
            res.add(s);
            memo.put(s,res);
            return res;
        }
        if(s.length()==2){
            res.add(s);
            res.add(s.charAt(1)+""+s.charAt(0));
            memo.put(s,res);
            return res;
        }
        if(memo.containsKey(s)) return memo.get(s);
        final HashSet<String> visited = new HashSet<String>();
        for(int i=0;i<s.length();i++){
            StringBuilder subString=new StringBuilder("");
            int indexOfChar=s.indexOf(s.charAt(i));
            subString.append(s, 0, indexOfChar);
            subString.append(s.substring(indexOfChar+1));
            for(String sub: getPermutations(subString.toString())){
                if(!visited.contains(sub+s.charAt(i))){
                    visited.add(sub+s.charAt(i));
                    res.add(sub+s.charAt(i));
                }
                if(!visited.contains(s.charAt(i)+sub)){
                    visited.add(s.charAt(i)+sub);
                    res.add(s.charAt(i)+sub);
                }
            }
            memo.put(s,res);
        }
        return res;
    }
}
