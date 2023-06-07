package com.rita.interfaces.model.entities;

import java.time.LocalDateTime;

public class VehicleRental {

    private LocalDateTime start;
    private LocalDateTime finish;

    private Vehicle vehicle;
    private Invoice invoice;

    public VehicleRental(LocalDateTime start, LocalDateTime finish, Vehicle vehicle) {
        this.start = start;
        this.finish = finish;
        this.vehicle = vehicle;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}