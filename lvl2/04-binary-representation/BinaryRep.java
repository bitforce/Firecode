class BinaryRep {
    private static String computeBinary(int val) {
        return Integer.toBinaryString(val);
    }
    private static String computeBinary2(int val) {
        if(val < 2) return Integer.toString(val);
        return computeBinary(val/2) + computeBinary(val%2);
    }
    private static String computeBinary3(int val) {
        if(val < 2) return Integer.toString(val);
        StringBuilder sb = new StringBuilder();
        while(val > 0) {
            sb.insert(0, val & 1);
            val = val >> 1;
        }
        return sb.toString();
    }
    private static String computeBinary4(int val) {
        if(val < 2) return Integer.toString(val);
        String binary = "";
        for(int i = val; i > 0; i /= 2) binary += (i % 2);
        return binary;
    }
    public static void main(String[] args) {
        System.out.println(computeBinary(Integer.parseInt(args[0])));
        System.out.println(computeBinary2(Integer.parseInt(args[0])));
        System.out.println(computeBinary3(Integer.parseInt(args[0])));
        System.out.println(computeBinary4(Integer.parseInt(args[0])));
    }
}
