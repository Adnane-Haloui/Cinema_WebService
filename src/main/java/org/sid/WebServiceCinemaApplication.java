package org.sid;

import org.sid.service.ICinemaInitService;
import org.sid.entities.Film;
import org.sid.entities.Salle;
import org.sid.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class WebServiceCinemaApplication implements CommandLineRunner{
	@Autowired 
	private ICinemaInitService cinemaService;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(WebServiceCinemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Film.class,Salle.class,Ticket.class);
		cinemaService.initVilles();
		cinemaService.initCinemas();
		cinemaService.initSalles();
		cinemaService.initPlaces();
		cinemaService.initSeances();
		cinemaService.initCategories();
		cinemaService.initFilms();
		cinemaService.initProjections();
		cinemaService.initTickets();
		
	}

}
