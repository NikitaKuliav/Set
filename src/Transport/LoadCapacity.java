package Transport;

public enum LoadCapacity {
    N1(0.0, 3.5),
    N2(3.6, 12.0),
    N3(13.0, 500.0);

    private Double min;
    private Double max;

    LoadCapacity(Double min, Double max) {
        this.min = min;
        this.max = max;
    }

    LoadCapacity() {

    }

    public Double getMin() {
        return min;
    }

    public Double getMax() {
        return max;
    }

    public static LoadCapacity getValue(Double value) {
        for (LoadCapacity e : LoadCapacity.values()) {
            if (value == null) {
                return N1;
            } else if (value >= e.getMin() && value <= e.getMax()) {

//                System.out.println(e);
                return e;
            }
        }
        return N1;

    }

    @Override
    public String toString() {
        if (min == null) {
            return "min= 0, max= 3.5";
        } else if (max == null) {
            return "min= 13, max= 500";
        }else {
            return "min=" + min +
                    ", max=" + max;
        }
    }
}