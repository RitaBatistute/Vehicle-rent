package com.rita.interfaces.model.application;

import com.rita.interfaces.model.entities.VehicleRental;
import com.rita.interfaces.model.entities.Vehicle;
import com.rita.interfaces.model.model.services.BrazilTaxServices;
import com.rita.interfaces.model.model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Rent data");
        System.out.print("Vehicle model: ");
        String vehicleModel = sc.nextLine();

        System.out.print("CheckIn (dd/MM/yyyy hh:mm): ");
        LocalDateTime startRental = LocalDateTime.parse(sc.nextLine(), fmt);

        System.out.print("CheckOut (dd/MM/yyyy hh:mm): ");
        LocalDateTime finishRental = LocalDateTime.parse(sc.nextLine(), fmt);

        System.out.print("Price per hour: $");
        double pricePerHour = sc.nextDouble();

        System.out.print("Price per day: $");
        double pricePerDay = sc.nextDouble();

        VehicleRental cr = new VehicleRental(startRental, finishRental, new Vehicle(vehicleModel));

        RentalService rentalService = new RentalService();
        rentalService.processInvoice(cr, pricePerHour, pricePerDay, new BrazilTaxServices());

        System.out.println("Invoice");
        System.out.println("Basic payment: $" + String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Tax: $" + String.format("%.2f",cr.getInvoice().getTax()));
        System.out.println("Total payment: $" + String.format("%.2f",cr.getInvoice().getTotalPayment()));

        sc.close();
    }
}