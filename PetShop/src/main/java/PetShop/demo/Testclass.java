
 package PetShop.demo;
  
  
  import java.sql.Date; import java.text.SimpleDateFormat;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.boot.CommandLineRunner; import
  org.springframework.stereotype.Component;
  
  
  @Component public class Testclass implements CommandLineRunner{
  
  @Autowired public GuestRepository guestRepository;
  
  @Autowired public AnalisysRepository pcrRepository;
  
  
  public void run(String... args) throws Exception {
  
  //let's create and save objects from each class:
  
  //guests:
  
  Guest isa = new Guest ("isa", "hurtado", 28); Guest joan = new Guest ("joan",
  "perez", 50);
  
  guestRepository.save(isa); guestRepository.save(joan);
  
  System.out.println(isa);
  
  //pcr:
  
  SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
  
  Analisys pcr1 = new Analisys (formater.parse("2019-10-15") , true); Analisys pcr2 = new Analisys
  (new Date(0), false); Analisys pcr3 = new Analisys ();
  
  pcrRepository.save(pcr1); pcrRepository.save(pcr2); pcrRepository.save(pcr3);
  
  
  //let's assign pcrs to guests:
  
  isa.addPcr(pcr1); isa.addPcr(pcr2); joan.addPcr(pcr3);
  
  
  //let's save again our guests with new info: guestRepository.save(isa);
  guestRepository.save(joan);
  
  }
  
  
  }
 
