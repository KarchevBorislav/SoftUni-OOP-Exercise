package OOP.workingWhitAbstraction.HotelReservation;

public enum Seasons {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);
    private int seasonMultiplayer;

    Seasons(int seasonMultiplayer) {
        this.seasonMultiplayer = seasonMultiplayer;
    }

    public int getSeasonMultiplayer() {
        return seasonMultiplayer;
    }
    public static Seasons parse(String str){
        return Seasons.valueOf(str.toUpperCase());
    }

}
