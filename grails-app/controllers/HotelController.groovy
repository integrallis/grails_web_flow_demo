class HotelController {

    def index = {
        redirect(action:'bookingCart')
    }
    
    def creditcardFlow = BillingController.creditcardFlow

     def paypalFlow = {
        pay(){
           on("submit") {
               log.info "Was it paid - ${params.paid}"
           }.to "evaluatePayment"
        }

        evaluatePayment() {
            action {
                if (params.paid == 'yes') {
                    conversation.booking.paid = true
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
                log.info "-start the booking-"
                conversation.booking = null
                flow.hotel = null
                return false
            }
            on("success").to "findHotels"
        }
  
        findHotels{
            on("showHotels") {
                def hotels = Hotel.findAllByNameIlike("%${params.hotelName}%", [max: 10])
                log.info "Hotels found - ${hotels}, size - ${hotels.size()}"
                [hotelResults: hotels]
            }.to "hotelListPage"
        }

        hotelListPage{
            on("view") {
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
                log.info "- Save the booking information to the flow scope - "
                // save the booking
                def booking = new Booking(params)
                booking.hotel = flow.hotel
                conversation.booking = booking
            }.to "saveBooking"
            on("cancel").to "start"
        }

        // The default save action before custom flows
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
                log.info "-confirm hotel-"
                // persist the data
                def success = conversation.booking.save();
                if (!success) {
                    conversation.booking.validate()
                    conversation.booking.errors.allErrors.each {
                        log.info "Errors - ${it}"
                    }
                }
            }.to "finish"
            on("cancel").to "start"
        }

        saveBooking() {
            action{
                if (!conversation.booking.validate()) {
                    return bookingPage()
                } else {
                    if (params.paymentType == "creditCard") {
                        log.info "- Pay Via Credit Card -"
                        return creditcard()
                    } else {
                        log.info "pay via paypal"
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
