
class Hotel implements java.io.Serializable {

    static hasMany = [bookings: Booking]
    String name
    String address
    String city
    String state
    String zip
    String country
    BigDecimal price

    String toString() {
        name
    }

    String cityState() {
        if (state?.length() > 0)
            city + ", " + state
        else
            city
     }
}

enum Amenity {
    OCEAN_VIEW, LATE_CHECKOUT, MINIBAR;
}
