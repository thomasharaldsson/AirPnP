package com.airpnp;

import com.airpnp.data.CustomerRepository;
import com.airpnp.domainmodel.*;
import com.airpnp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AirPnPApplication {

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ParkingSpaceService parkingSpaceService;

	@Autowired
	private LenderService lenderService;

	@Autowired
	private RentalTicketService rentalTicketService;

	public static void main(String[] args) {
		SpringApplication.run(AirPnPApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			System.out.println("Starting command line runner.");
			// Initialize database here
			System.out.println("Initialize database..");

			// Delete all vehicles, customers and lenders from database:
			rentalTicketService.deleteAll();
			vehicleService.deleteAll();
			customerService.deleteAll();
			lenderService.deleteAll();
			parkingSpaceService.deleteAll();

			// Create some customers:
			Customer c1 = new Customer("Jonas", "Backlund", "jonas@outlook.com", "555.1234", "jonas", "space123");
			customerService.addCustomer(c1);

			Customer c2 = new Customer("Stefan", "Lindell", "steffe@gov.au", "222265643", "stefan", "floor222");
			customerService.addCustomer(c2);

			Customer c3 = new Customer("Björn", "Borg", "bb@tennis.se", "11111133", "bjorn", "disc333");
			customerService.addCustomer(c3);

			// Create some lenders:
			Lender l1 = new Lender("Lenny", "Bruce", "lenny@bbc.com", "08973247", "lenny", "motorzzz");
			lenderService.addLender(l1);

			Lender l2 = new Lender("Bo", "Breddahl", "bosse@flashback.se", "3456666", "bo", "cykel");
			lenderService.addLender(l2);

			Lender l3 = new Lender("Franny", "Middleston", "fran@flashback.se", "3453366", "franny", "bike");
			lenderService.addLender(l3);

			// Create some vehicles:
			Vehicle v1 = new Vehicle("JON-141", c1);
			vehicleService.addVehicle(v1);

			Vehicle v2 = new Vehicle("TOP-221", c3);
			vehicleService.addVehicle(v2);

			//Create some parkingspaces:
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			ParkingSpace p1 = new ParkingSpace(50, format.parse ( "2022-02-31" ), format.parse ( "2022-03-15" ), "Slottskogen 2");
			parkingSpaceService.addParkingSpace(p1);

			ParkingSpace p2 = new ParkingSpace(35, format.parse ( "2022-01-14" ), format.parse ( "2022-02-15" ), "Storgatan 52");
			parkingSpaceService.addParkingSpace(p2);

			ParkingSpace p3 = new ParkingSpace(35, format.parse ( "2022-02-01" ), format.parse ( "2022-02-07" ), "Sjömansgatan 11");
			parkingSpaceService.addParkingSpace(p2);

			//Create some rental tickets:
			RentalTicket t1 = new RentalTicket(c1, v1, p1);
			rentalTicketService.addRentalTicket(t1);

			RentalTicket t2 = new RentalTicket(c3, v2, p2);
			rentalTicketService.addRentalTicket(t1);
		};
	}
}
