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
	private AdminService adminService;

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
			vehicleTypeService.deleteAll();
			customerService.deleteAll();
			adminService.deleteAll();
			parkingSpaceService.deleteAll();

			// Create some customers:
			Customer c1 = new Customer("Jonas", "Backlund", "jonas@outlook.com", "555.1234", "jonas", "space123");
			customerService.addCustomer(c1);

			Customer c2 = new Customer("Stefan", "Lindell", "steffe@gov.au", "222265643", "stefan", "floor222");
			customerService.addCustomer(c2);

			Customer c3 = new Customer("Björn", "Borg", "bb@tennis.se", "11111133", "bjorn", "disc333");
			customerService.addCustomer(c3);

			// Create some admins:
			Admin a1 = new Admin("Lenny", "Bruce", "lenny@bbc.com", "08973247", "lenny", "motorzzz");
			adminService.addAdmin(a1);

			Admin a2 = new Admin("Bo", "Breddahl", "bosse@flashback.se", "3456666", "bo", "cykel");
			adminService.addAdmin(a2);

			Admin a3 = new Admin("Franny", "Middleston", "fran@flashback.se", "3453366", "franny", "bike");
			adminService.addAdmin(a3);

			// Create some vehicle types
			VehicleType typeCar = new VehicleType("Car");
			VehicleType typeMotorcycle = new VehicleType("Motorcycle");
			VehicleType typeBike = new VehicleType("Big rig truck & trailer");

			// Create some vehicles:
			Vehicle v1 = new Vehicle("JON-141", c1, typeCar);
			vehicleService.addVehicle(v1);

			Vehicle v2 = new Vehicle("TOP-221", c3, typeBike);
			vehicleService.addVehicle(v2);

			//Create some parkingspaces:
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			ParkingSpace p1 = new ParkingSpace(50, format.parse ( "2022-02-31" ), format.parse ( "2022-03-15" ), "Slottskogen 2");
			parkingSpaceService.addParkingSpace(p1);

			ParkingSpace p2 = new ParkingSpace(35, format.parse ( "2022-01-14" ), format.parse ( "2022-02-15" ), "Storgatan 52");
			parkingSpaceService.addParkingSpace(p2);

			ParkingSpace p3 = new ParkingSpace(35, format.parse ( "2022-02-01" ), format.parse ( "2022-02-07" ), "Sjömansgatan 11");
			parkingSpaceService.addParkingSpace(p3);

			//Create some rental tickets:
			RentalTicket t1 = new RentalTicket(c1, v1, p1);
			rentalTicketService.addRentalTicket(t1);

			RentalTicket t2 = new RentalTicket(c3, v2, p2);
			rentalTicketService.addRentalTicket(t2);
		};
	}
}
