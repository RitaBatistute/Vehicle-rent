package com.rita.interfaces.model.model.services;

import com.rita.interfaces.model.entities.VehicleRental;
import com.rita.interfaces.model.entities.Invoice;

import java.time.Duration;

public class RentalService {

    private Double pricePerHour;
    private Double pricePerDay;

    private TaxService taxService;

    public void processInvoice(VehicleRental vehicleRental, Double pricePerHour, Double pricePerDay, TaxService taxService){

        double minutes = Duration.between(vehicleRental.getStart(), vehicleRental.getFinish()).toMinutes();
        double hours = minutes / 60.0;

        double basicPayment;
        if (hours <= 12.0){
            basicPayment = pricePerHour * Math.ceil(hours);
        }
        else {
            basicPayment = pricePerDay * Math.ceil(hours / 24.0);
        }

        double tax = taxService.tax(basicPayment);

        vehicleRental.setInvoice(new Invoice(basicPayment, tax));
    }
}