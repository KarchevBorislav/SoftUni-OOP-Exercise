package OOP.workingWhitAbstraction.HotelReservation;

public enum DiscountType {
    VIP(0.8),
    SECOND_VISIT(0.9),
    NONE(1.0);
    private double discount;

    DiscountType(double discount) {
        this.discount = discount;
    }

    public double getDiscountType() {
        return discount;
    }

    public static DiscountType parse(String str) {
        switch (str) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalStateException("Unknown enum type " + str);
        }
    }
    }


