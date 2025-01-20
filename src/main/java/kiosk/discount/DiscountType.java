package kiosk.discount;

public enum DiscountType {
    NATIONAL(1, 0.10),
    SOLDIER(2, 0.05),
    STUDENT(3, 0.03),
    GENERAL(4, 0.00);

    private final int code;
    private final double discountRate;

    DiscountType(int code, double discountRate) {
        this.code = code;
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public static DiscountType fromCode(int code) {
        for (DiscountType type : values()) {
            if (type.code == code) return type;
        }
        return GENERAL; // 기본값은 일반
    }
}