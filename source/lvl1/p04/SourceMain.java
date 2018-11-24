package source.lvl1.p04;

public class SourceMain {
     public static void main(String[] args) {
        StringBuilder a = new StringBuilder();
        for(String s : args) a.append(s).append(" ");
        a = new StringBuilder(a.substring(0, a.length() - 2));
        System.out.println(Source.replace(a.toString(), args[args.length-1]));
    }
}
