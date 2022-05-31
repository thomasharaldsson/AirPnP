package com.airpnp;

import com.airpnp.domainmodel.*;
import com.airpnp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AirPnPApplication {

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private VehicleTypeService vehicleTypeService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ParkingSpaceService parkingSpaceService;

	@Autowired
	private RentalTicketService rentalTicketService;

	@Autowired
	private RatingService ratingService;

	public static void main(String[] args) {
		SpringApplication.run(AirPnPApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Initialize database here
			System.out.print("Initializing database... ");

			// Delete all vehicles, customers and lenders from database:

			rentalTicketService.deleteAll();
			vehicleService.deleteAll();
			vehicleTypeService.deleteAll();
			parkingSpaceService.deleteAll();
			customerService.deleteAll();
			ratingService.deleteAll();

			//create some ratings
			Rating r1 = new Rating(2);
			ratingService.addRating(r1);
			Rating r2 = new Rating(3);
			ratingService.addRating(r2);
			Rating r3 = new Rating(4);
			ratingService.addRating(r3);

			Rating rAdmin1 = new Rating(2);
			ratingService.addRating(rAdmin1);
			Rating rAdmin2 = new Rating(3);
			ratingService.addRating(rAdmin2);
			Rating rAdmin3 = new Rating(4);
			ratingService.addRating(rAdmin3);

			// Create some customers:
			Customer c1 = new Customer("Jonas", "Backlund", "jonas@outlook.com", "555.1234", "jonas", "space123", r1, false);
			customerService.addCustomer(c1);

			Customer c2 = new Customer("Stefan", "Lindell", "steffe@gov.au", "222265643", "stefan", "floor222",r2, false);
			customerService.addCustomer(c2);

			Customer c3 = new Customer("Björn", "Borg", "bb@tennis.se", "11111133", "bjorn", "disc333",r3, false);
			customerService.addCustomer(c3);

			// Create some admins:
			Customer a1 = new Customer("Lenny", "Bruce", "lenny@bbc.com", "08973247", "lenny", "motorzzz", rAdmin1, true);
			customerService.addCustomer(a1);

			Customer a2 = new Customer("Bo", "Breddahl", "bosse@flashback.se", "3456666", "bo", "cykel", rAdmin2, true);
			customerService.addCustomer(a2);

			Customer a3 = new Customer("Franny", "Middleston", "fran@flashback.se", "3453366", "franny", "bike", rAdmin3, true);
			customerService.addCustomer(a3);

			// Create some vehicle types
			VehicleType typeCar = new VehicleType("Car");
			vehicleTypeService.add(typeCar);

			VehicleType typeMotorcycle = new VehicleType("Motorcycle");
			vehicleTypeService.add(typeMotorcycle);

			VehicleType typeBike = new VehicleType("Big rig truck & trailer");
			vehicleTypeService.add(typeBike);

			// Create some vehicles
			Vehicle v1 = new Vehicle("JON-141", c1, typeCar);
			vehicleService.addVehicle(v1);

			Vehicle v2 = new Vehicle("TOP-226", c3, typeBike);
			vehicleService.addVehicle(v2);

			Vehicle v3 = new Vehicle("TOP-221", c3, typeMotorcycle);
			vehicleService.addVehicle(v3);

			Vehicle v4 = new Vehicle("LEN-1", a1, typeCar);
			vehicleService.addVehicle(v4);

			//Create some parkingspaces:
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			ParkingSpace p1 = new ParkingSpace(50, format.parse ( "2022-02-31" ), format.parse ( "2022-03-15" ), "Slottskogen 2", c1);
			parkingSpaceService.addParkingSpace(p1);

			ParkingSpace p2 = new ParkingSpace(35, format.parse ( "2022-01-14" ), format.parse ( "2022-02-15" ), "Storgatan 52", c1);
			parkingSpaceService.addParkingSpace(p2);

			ParkingSpace p3 = new ParkingSpace(35, format.parse ( "2022-02-01" ), format.parse ( "2022-02-07" ), "Sjömansgatan 11", c2);
			parkingSpaceService.addParkingSpace(p3);

			//Create some rental tickets
			RentalTicket t1 = new RentalTicket(c1, v1, p1);
			rentalTicketService.addRentalTicket(t1);

			RentalTicket t2 = new RentalTicket(c3, v2, p2);
			rentalTicketService.addRentalTicket(t2);

			//Test to check if availability still works if a portion of the parking space dates are free
			RentalTicket t3 = new RentalTicket(c2, v2, p3);
			rentalTicketService.addRentalTicket(t2);

			System.out.println("done.");
			System.out.println("Please open web UI from http://localhost:8080");
		};
	}
}
