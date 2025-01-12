package com.me.payment.paypal;

import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequiredArgsConstructor
@Slf4j
public class PaypalController {
    private final PaypalService paypalService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/payment/create")
    public RedirectView createPayment(
            @RequestParam("method") String method,
            @RequestParam("currency") String currency,
            @RequestParam("amount") String amount,
            @RequestParam("description") String description
    ) {
        try {
            String cancelUrl = "http://localhost:8080/payment/cancel";
            String successUrl = "http://localhost:8080/payment/success";
            Payment payment = paypalService.createPayment(Double.valueOf(amount), currency, method, "sale", description, cancelUrl, successUrl);
            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return new RedirectView(link.getHref());
                }
            }
        } catch (PayPalRESTException e) {
            log.error("error occured: ",e.getMessage());
        }
        return new RedirectView("/payment/error");
    }

    @GetMapping("/payment/success")
    public String paymentSuccess(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
         Payment payment   = paypalService.executePayment(paymentId, payerId);
         if (payment.getState().equals("approved")) {
             return "PaymentSuccess";
         }
        } catch (PayPalRESTException e) {
            log.error("error occured: ",e.getMessage());
        }
        return "PaymentSuccess";
    }

    @GetMapping("/payment/cancel")
    public String paymentCancel() {

        return "PaymentCancel";
    }
    
    @GetMapping("/payment/error")
    public String paymentError() {

        return "PaymentError";
    }
    
}
