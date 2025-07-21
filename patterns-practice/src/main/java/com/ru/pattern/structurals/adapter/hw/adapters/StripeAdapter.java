package com.ru.pattern.structurals.adapter.hw.adapters;

import com.ru.pattern.structurals.adapter.hw.PaymentProcessor;
import com.ru.pattern.structurals.adapter.hw.services.PayPalService;
import com.ru.pattern.structurals.adapter.hw.services.StripeService;

public class StripeAdapter implements PaymentProcessor {


    private StripeService stripeService;

    public StripeAdapter(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @Override
    public void processPayment(double amount) {
        stripeService.makeCharge(amount);
    }
}
