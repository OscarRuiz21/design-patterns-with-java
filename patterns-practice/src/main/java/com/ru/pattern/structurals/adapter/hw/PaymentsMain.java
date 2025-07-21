package com.ru.pattern.structurals.adapter.hw;

import com.ru.pattern.structurals.adapter.hw.adapters.MeliAdapter;
import com.ru.pattern.structurals.adapter.hw.adapters.PayPalAdapter;
import com.ru.pattern.structurals.adapter.hw.adapters.StripeAdapter;
import com.ru.pattern.structurals.adapter.hw.services.MeLiService;
import com.ru.pattern.structurals.adapter.hw.services.PayPalService;
import com.ru.pattern.structurals.adapter.hw.services.StripeService;

public class PaymentsMain {

    public static void main(String[] args) {
        PaymentProcessor payPal = new PayPalAdapter(new PayPalService());

        PaymentProcessor meLi = new MeliAdapter(new MeLiService());

        PaymentProcessor stripe = new StripeAdapter(new StripeService());

        System.out.println("Using PayPal: ");
        payPal.processPayment(100);

        System.out.println("Using MeLi: ");
        meLi.processPayment(200);

        System.out.println("Using Stripe: ");
        stripe.processPayment(300);


    }
}
