package OOP.workingWhitAbstraction.HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int days;
    private Seasons seasons;
    private DiscountType discountType;


    public PriceCalculator(double pricePerDay, int days, Seasons season, DiscountType discount) {
        this.seasons = season;
        this.days = days;
        this.discountType = discount;
        this.pricePerDay = pricePerDay;
    }
    public double calculatePrice() {

        return pricePerDay * days * seasons.getSeasonMultiplayer() * discountType.getDiscountType();
    }

}
