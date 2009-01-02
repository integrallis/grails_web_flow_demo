class HotelTests extends GroovyTestCase {

    void testFindSomeHotel() {
        // Hotels
        //Hotel.findAllWhere("name" : "W Hotel", max: 5)
        //Hotel.findAllByName("W Hotel", [max: 5])
        def hotels = Hotel.findAllByNameIlike("%Hotel%", [max: 5])
        assert hotels.size() == 3

        // limit thte hotels
        def hotels2 = Hotel.findAllByNameIlike("%Hotel%", [max: 2])
        assert hotels2.size() == 2
    }

    void setUp() {
        new Hotel(price: 199, name: 'Westin Diplomat', address: '3555 S. Ocean Drive', city: 'Hollywood', state: 'FL', zip: '33019', country: 'USA').save()
        new Hotel(price: 60, name: 'Jameson Inn', address:'890 Palm Bay Rd NE', city:'Palm Bay', state: 'FL', zip: '32905', country: 'USA').save()
        new Hotel(price: 199, name:'Chilworth Manor', address:'The Cottage, Southampton Business Park', city:'Southampton', state: 'Hants', zip: 'SO16 7JF', country: 'UK').save()
        new Hotel(price: 120, name:'Marriott Courtyard', address:'Tower Place, Buckhead', city:'Atlanta', state: 'GA', zip: '30305', country: 'USA').save()
        new Hotel(price: 180, name:'Doubletree', address:'Tower Place, Buckhead', city:'Atlanta', state: 'GA', zip: '30305', country: 'USA').save()
        new Hotel(price: 450, name:'W Hotel', address:'Union Square, Manhattan',city: 'NY', state: 'NY', zip: '10011', country: 'USA').save()
        new Hotel(price: 450, name:'W Hotel', address:'Lexington Ave, Manhattan', city:'NY', state: 'NY', zip: '10011', country: 'USA').save()
        new Hotel(price: 250, name:'Hotel Rouge', address:'1315 16th Street NW', city:'Washington', state: 'DC', zip: '20036', country: 'USA').save()
    }
}
