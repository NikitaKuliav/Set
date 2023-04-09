package Transport;

public enum Size {
    XS(10, 25),
    S(26, 50),
    M(51, 80),
    L(81, 120),
    XL(121, 150);

    private Integer min;
    private Integer max;

    Size(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    Size() {
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public static Size getValue(Integer value) {
        for (Size e : Size.values()) {
            if (value == null) {
                return XS;
            } else if (value >= e.getMin() && value <= e.getMax()) {
//                System.out.println(e);
                return e;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        if (min == null) {
            return "min = 10, max = 25";
        } else if (max == null) {
            return "min = 121, max = 150";
        } else {
            return "min=" + min +
                    ", max=" + max;
        }
    }
}
