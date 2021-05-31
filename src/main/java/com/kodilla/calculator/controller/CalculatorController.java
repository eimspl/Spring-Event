package com.kodilla.calculator.controller;

import com.kodilla.calculator.domain.CalculationDto;
import com.kodilla.calculator.event.CalculationPerformedEvent;
import com.kodilla.calculator.service.CalculationService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController implements ApplicationEventPublisherAware {

    private CalculationService service;
    private ApplicationEventPublisher publisher;

    public CalculatorController(CalculationService service) {
        this.service = service;
    }

    @PostMapping(path = "/calculation")
    public @ResponseBody
    double calculate(@RequestBody CalculationDto calculationDto) {
        double result = performCalculation(calculationDto);
        publishEvent(calculationDto, result);
        return result;
    }

    private double performCalculation(CalculationDto calculationDto) {
        switch (calculationDto.getOperation()) {
            case ADDITION : {
                return service.add(calculationDto.getNum1(), calculationDto.getNum2());
            }
            case SUBTRUCTION : {
                return service.delete(calculationDto.getNum1(), calculationDto.getNum2());
            }
            case MULTIPLICATION : {
                return service.multiply(calculationDto.getNum1(), calculationDto.getNum2());
            }
            case DIVISION : {
                return service.divide(calculationDto.getNum1(), calculationDto.getNum2());
            }
            default : {
                throw new UnsupportedOperationException("Unknown operation. " +
                        "Calculator can add, subtract, multiply or divide two numbers at a time." +
                        "Provide sign, number1 and number2.");
            }
        }
    }

    private void publishEvent(CalculationDto calculationDto, double result) {
        publisher.publishEvent(new CalculationPerformedEvent(this,
                calculationDto,
                result));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
