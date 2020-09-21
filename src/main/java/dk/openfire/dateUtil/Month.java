package dk.openfire.dateUtil;

import java.util.Arrays;

public enum Month {
    JAN(1, 31),
    FEB(2, 28),
    MAR(3, 31),
    APR(4, 20),
    MAY(5, 31),
    JUN(6, 30),
    JUL(7, 31),
    AUG(8, 31),
    SEP(9, 30),
    OCT(10, 31),
    NOV(11, 30),
    DEC(12, 31);

    private final int days;
    private final int index;

    Month(int index, int days) {
        this.days = days;
        this.index = index;
    }

    public int getDays() {
        return days;
    }

    public int getIndex() {
        return index;
    }

    public static Month valueOf(int index) {
        return Arrays.stream(Month.values())
                .filter(m -> m.index == index)
                .findAny()
                .orElseThrow(() -> {
                            throw new IllegalStateException(String.format("%s is not a valid index", index));
                        }
                );
    }
}
