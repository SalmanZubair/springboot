package io.javabrains.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
@SuppressWarnings("unused")
public class MovieCatalogResource {

	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private WebClient.Builder builder;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		System.out.println(userId);
		UserRating ratings = restTemplate.getForObject("http://ratings-data-service/rating/user/"+userId, UserRating.class);
System.out.println(ratings.toString());
		return ratings.getUserRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);

			/*
			 * Movie movie =
			 * builder.build().get().uri("http://localhost:8081/movies/" +
			 * rating.getMovieId()).retrieve() .bodyToMono(Movie.class).block();
			 */
			return new CatalogItem(movie.getName(), "desc", rating.getRating());
		}).collect(Collectors.toList());

	}
}
