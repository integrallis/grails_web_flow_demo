class BillingController {

    def static creditcardFlow = {
        payed(){
           on("pay") {
               conversation.booking.paid = params.paid
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
}
