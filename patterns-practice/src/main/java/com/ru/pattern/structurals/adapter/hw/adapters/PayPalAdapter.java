package com.ru.pattern.structurals.adapter.hw.adapters;

import com.ru.pattern.structurals.adapter.hw.PaymentProcessor;
import com.ru.pattern.structurals.adapter.hw.services.MeLiService;
import com.ru.pattern.structurals.adapter.hw.services.PayPalService;

public class PayPalAdapter implements PaymentProcessor {

    private PayPalService payPalService;

    public PayPalAdapter(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    @Override
    public void processPayment(double amount) {
        payPalService.sendPayment(amount);
    }

}
