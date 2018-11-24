package source.lvl4.p13;

class Source {
    int swapOddEvenBits(final int X) {
        return (X & 0xAAAAA) >>> 1 | (X & 0x55555) << 1;
    }
}
