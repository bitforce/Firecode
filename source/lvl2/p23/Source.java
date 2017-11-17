package source.lvl2.p23;
class Source {
   /* ********************************************************************** */ 
    private static int betterFibonacci(int n) {
        int x = 0;
        int y = 1;
        int z = 1;
        for(int i = 0; i < n; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        return x;
    }
   /* ********************************************************************** */ 
    private static int betterFibonacci2(int n) {
        if(n < 1) return 0;
        if(n < 3) return 1;
        int x = 1;
        int y = 1;
        int z = x + y;
        while(n-->2){
            z = x + y;
            y = x;
            x = z;
        } 
        return z;
    }
   /* ********************************************************************** */ 
    public static void main(String[] args) {
        System.out.println(betterFibonacci(Integer.parseInt(args[0])));
        System.out.println(betterFibonacci2(Integer.parseInt(args[0])));
    } 
}
