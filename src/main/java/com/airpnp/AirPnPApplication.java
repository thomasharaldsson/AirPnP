package com.airpnp;

import com.airpnp.data.CustomerRepository;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.domainmodel.Vehicle;
import com.airpnp.service.CustomerService;
import com.airpnp.service.ParkingSpaceService;
import com.airpnp.service.RentalTicketService;
import com.airpnp.service.VehicleService;
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

	public static void main(String[] args) {
		SpringApplication.run(AirPnPApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			System.out.println("Starting command line runner.");
			// Initialize database here
			System.out.println("Initialize database..");

			// Delete all vehicles and customers from database:
			vehicleService.deleteAll();
			customerService.deleteAll();
			parkingSpaceService.deleteAll();

			// Create some customers:
			Customer c1 = new Customer("Jonas", "Backlund", "jonas@outlook.com", "555.1234", "jonas", "space123");
			customerService.addCustomer(c1);

			Customer c2 = new Customer("Stefan", "Lindell", "steffe@gov.au", "222265643", "stefan", "floor222");
			customerService.addCustomer(c2);

			Customer c3 = new Customer("Björn", "Borg", "bb@tennis.se", "11111133", "bjorn", "disc333");
			customerService.addCustomer(c3);

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
		};
	}
}
