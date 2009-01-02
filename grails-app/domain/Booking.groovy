class Booking implements java.io.Serializable {
    static belongsTo = Hotel
    
    //Customer customer
    Hotel hotel
    Date checkinDate
    Date checkoutDate
    boolean smoking = false
    boolean paid = false
    int beds
    //Amenity amenities

    static constraints = {
        beds(min:1)
    }
}
