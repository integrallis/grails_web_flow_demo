class BillingController {

    def static creditcardFlow = {
        payed(){
           on("pay") {
                log.info "-credit card flow pay -"
               conversation.booking.paid = params.paid
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
}
