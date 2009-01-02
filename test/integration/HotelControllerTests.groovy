class HotelControllerTests extends grails.test.WebFlowTestCase  {

    def getFlow() {
        new HotelController().bookingCartFlow
    }

    void testBookingCartFlow() {
        def viewSelection = startFlow()
        //test that you get the correct view to start
        assertEquals "findHotels", viewSelection.viewName

        // now pretend we are submitting a flow
        flow.params.hotelName = 'Hotel'
        viewSelection = signalEvent("showHotels")
        // check the return
        assertEquals "hotelListPage", viewSelection.viewName
        println "joe - " + flow
        println getFlowAttribute('hotelListPage')
    }
}
