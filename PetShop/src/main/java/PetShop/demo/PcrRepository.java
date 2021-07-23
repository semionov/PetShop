package PetShop.demo;

import org.springframework.data.repository.CrudRepository;

public interface PcrRepository extends CrudRepository<Pcr, Integer> {

//where Integer refers to @Id in entity Guest, which type of variable is it.

}
