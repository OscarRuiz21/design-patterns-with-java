package com.ru.pattern.structurals.adapter.hw.adapters;

import com.ru.pattern.structurals.adapter.hw.PaymentProcessor;
import com.ru.pattern.structurals.adapter.hw.services.MeLiService;

public class MeliAdapter implements PaymentProcessor {

    private MeLiService meLiService;

    public MeliAdapter(MeLiService meLiService) {
        this.meLiService = meLiService;
    }

    @Override
    public void processPayment(double amount) {
        meLiService.pay(amount);
    }
}
