package source.lvl2.p04;

class Source {
    static String computeBinary(int val) {
        return Integer.toBinaryString(val);
    }
    /* ********************************************************************* */
    static String computeBinary2(int val) {
        if(val < 2) return Integer.toString(val);
        return computeBinary2(val/2) + computeBinary2(val%2);
    }
    /* ********************************************************************* */
    static String computeBinary3(int val) {
        if(val < 2) return Integer.toString(val);
        final StringBuilder sb = new StringBuilder();
        while(val > 0) {
            sb.insert(0, val & 1);
            val = val >> 1;
        }
        return sb.toString();
    }
    /* ********************************************************************* */
    static String computeBinary4(int val) {
        if(val < 2) return Integer.toString(val);
        final StringBuilder binary = new StringBuilder();
        for(int i = val; i > 0; i /= 2) binary.append(i % 2);
        return binary.toString();
    }
}
