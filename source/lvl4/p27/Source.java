package source.lvl4.p27;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static ArrayList<String> getPermutations(String s) {
        if(s == null) return null;
        if(s == "") return new ArrayList<>();
        return permute(new ArrayList<String>(), s, 0, s.length()-1);
    }
    private static ArrayList<String> permute(ArrayList<String> list, String string, int left, int right) {
        if(left != right) {
            for(int i = left; i <= right; i++) {
                string = swap(string, left, i);
                permute(list, string, left+1, right);
                string = swap(string, left, i);
            }
        } else list.add(string);
        return list;
    }
    private static String swap(String string, int i, int j) {
        char[] charr = string.toCharArray();
        char c = charr[i];
        charr[i] = charr[j];
        charr[j] = c;
        return String.valueOf(charr);
    }
    /* ********************************************************************* */
    private static ArrayList<String> getPermutations2(String s) {
        if(s == null) return null;
        ArrayList<String> permutations = new ArrayList<>();
        if(s.length() == 0) {
            permutations.add("");
            return permutations;
        }
        char c = s.charAt(0);
        String remainder = s.substring(1);
        ArrayList<String> words = getPermutations2(remainder);
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
    public static ArrayList<String> getPermutations3(String s) {
        ArrayList<String> res= new ArrayList<String>();
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
        HashSet<String> visited = new HashSet<String>();
        for(int i=0;i<s.length();i++){
            StringBuilder subString=new StringBuilder("");
            int indexOfChar=s.indexOf(s.charAt(i));
            subString.append(s.substring(0,indexOfChar));
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
    /* ********************************************************************* */
    public static void main(String[] args) {
        System.out.println(getPermutations(args[0]));
        System.out.println(getPermutations2(args[0]));
        System.out.println(getPermutations3(args[0]));
    }
}
