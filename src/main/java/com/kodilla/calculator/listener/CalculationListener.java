package com.kodilla.calculator.listener;

import com.kodilla.calculator.event.CalculationPerformedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CalculationListener implements ApplicationListener<CalculationPerformedEvent> {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void onApplicationEvent(CalculationPerformedEvent event) {
        logger.info(String.format("Performed %s: %s%s%s = %s",
                event.getOperation().name(),
                event.getNum1(),
                event.getOperation().getSign(),
                event.getNum2(),
                event.getResult()));
    }

}