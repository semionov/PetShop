package PetShop.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guest")

public class GuestController {
		
@Autowired
GuestRepository guestRepository;
		
	//CRUD OPS:

	//READ
	@RequestMapping("/allGuests")
		public Iterable<Guest> getAllGuests() {

			return guestRepository.findAll();
		}
	
		//  CREATE 
		
		@RequestMapping("/newGuest")
		public String newGuest() {

			return "signin";
		}
		
		@RequestMapping("/addGuest")
		public String insertGuest(Guest guest) {
			
			guestRepository.save(guest);
			
			return "mysafespace";
		}
	
		// READ 
		@RequestMapping("/getGuest/{id}")
		public Guest findById(@PathVariable int id) {

			Optional<Guest> guestFound = guestRepository.findById(id);

			if (guestFound.isPresent()) {

				return guestFound.get();
			}

			return null;
		}
		
	

		//  DELETE
		@RequestMapping("/deleteGuest/{id}")
		public void deleteGuest(@PathVariable int id) {

			Optional<Guest> guestFound = guestRepository.findById(id);

			if (guestFound.isPresent()) {

				guestRepository.deleteById(id);
			}

		}

		// UPADATE 
		@RequestMapping("/updateGuest/{id}")
		public void updateGuest(Guest guest, @PathVariable int id) {

			Optional<Guest> guestFound = guestRepository.findById(id);

			if (guestFound.isPresent()) {

				if (!guest.getName().equals(guestFound.get().getName()))
					guestFound.get().setName(guest.getName());
				

				if (!guest.getSurname().equals(guestFound.get().getSurname()))
					guestFound.get().setSurname(guest.getSurname());  

				if (guest.getAge() != guestFound.get().getAge())
					guestFound.get().setAge(guest.getAge());

				if (!guest.getPhoneNumber().equals(guestFound.get().getPhoneNumber()))
					guestFound.get().setPhoneNumber(guest.getPhoneNumber());
				
				
				if (!guest.getEmail().equals(guestFound.get().getEmail()))
					guestFound.get().setEmail(guest.getEmail());

				guestRepository.save(guestFound.get());
			}
		}
		
	}
	

