package com.creativepage.moviecatalogservice.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.creativepage.moviecatalogservice.models.CatalogItem;
import com.creativepage.moviecatalogservice.models.Movie;
import com.creativepage.moviecatalogservice.models.Rating;
import com.creativepage.moviecatalogservice.models.UserRating;;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		//get all movie ids
		
		//Commented becuase now it gonna retrive from rating-data-service
		UserRating userratings = restTemplate.getForObject("http://rating-data-service/ratingsdata/user/"+userId, UserRating.class);
		List<Rating> ratings = userratings.getUserRating();
		//= Arrays.asList(
//				new Rating("1234", 4),
//				new Rating("5678", 3));
		
		//For each movie id call movie info service  and get details
		
		return ratings.stream().map(rating-> {
 		   Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
//			Movie movie = webClientBuilder.build()
//			.get()
//			.uri("http://localhost:8082/movies/"+rating.getMovieId())
//			.retrieve()
//			.bodyToMono(Movie.class)
//			.block();
			
			return new CatalogItem(movie.getName(), "Amir Khan", rating.getRating());
		}).collect(Collectors.toList());
		
		//Put them all together
//		return Collections.singletonList(
//				new CatalogItem("Sarfarosh", "Amir Khan", 3)
//				);
		
	}
}
