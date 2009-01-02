class HotelController {

    def index = {
        redirect(action:'bookingCart')
    }
    
    def creditcardFlow = BillingController.creditcardFlow

     def paypalFlow = {
        pay(){
           on("submit") {
               println "Was it paid - " + params.paid
           }.to "evaluatePayment"
        }

        evaluatePayment() {
            action {
                if (params.paid == 1) {
                    return paidInFull()
                } else {
                    return paymentDeclined()
                }
            }
            on("paidInFull").to "paidInFull"
            on("paymentDeclined").to "paymentDeclined"
        }

        paidInFull()
        paymentDeclined()
    }

    def bookingCartFlow = {
        
        start(){

            action{
                println "start the transaction"
                conversation.booking = null
                flow.hotel = null
                return false
            }
            on("success").to "findHotels"
        }
  
        findHotels{
            on("showHotels") {
                println "*** show ***"
                def hotels = Hotel.findAllByNameIlike("%${params.hotelName}%", [max: 10])
                println "Hotels found - ${hotels}, size - ${hotels.size()}"
                [hotelResults: hotels]
            }.to "hotelListPage"
        }

        hotelListPage{
            on("view") {
                println "view the hotel!!!!"
                flow.hotel = Hotel.get(params.id)
            }.to "hotelView"
            
            on("back").to "start"
        }

        hotelView {
            on("back").to "start"
            on("book") {

            }.to "bookingPage"
        }

        bookingPage {
            on("proceed") {
                println "- Save the booking information to the flow scope - "
                // save the booking
                def booking = new Booking(params)
                booking.hotel = flow.hotel
                conversation.booking = booking
                println "The booking - " + flow.booking
            }.to "saveBooking"
            on("cancel").to "start"
        }

        // The default save action
//        saveBooking() {
//            action{
//                if (flow.booking.validate()) {
//                    return confirmHotel()
//                } else {
//                    return bookingPage()
//                }
//            }
//            on("confirmHotel").to "confirmHotel"
//            on("bookingPage").to "bookingPage"
//        }

        confirmHotel {
            on("submit") {
                println "-confirm hotel-"
                //flow.booking.save()
            }.to "finish"
            on("cancel").to "start"
        }

        saveBooking() {
            action{
                if (!conversation.booking.validate()) {
                    return bookingPage()
                } else {
                    println "payment type - " + params.paymentType
                    println params.paymenType.equals("creditCard")
                    println params.paymenType == "creditCard"
                    if (params.paymentType == "creditCard") {
                        println "pay via credit card"
                        return creditcard()
                    } else {
                        println "pay via paypal"
                        return paypal()
                    }
                }
            }
            on("bookingPage").to "bookingPage"
            on("creditcard").to "creditcard"
            on("paypal").to "paypal"
        }

        // This has to be named paypal .. needs the same naming
        paypal {
            subflow(paypalFlow)
            on("paidInFull").to "confirmHotel"
            on("paymentDeclined").to "bookingPage"
        }

        creditcard {
            subflow(creditcardFlow)
            on("paidInFull").to "confirmHotel"
            on("paymentDeclined").to "bookingPage"
        }

        finish() {            
        }
    }

}
