package javaApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class consumeApi {

	public static void consumeApi() throws Exception {
		//Link Api
		String url = "https://alura-imdb-api.herokuapp.com/movies";
		URI endereco = URI.create(url);
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body(); 
		
		//Conversão javaParse
		javaParse parser = new javaParse();
		List<Map<String,String>> listaFilmes = parser.parse(body);
		System.out.println(listaFilmes.size()); 
		System.out.println(listaFilmes.get(0)); 
		
		for(Map<String,String>filmes:listaFilmes) {
			System.out.println(filmes.get("title"));
			System.out.println(filmes.get("image"));
			System.out.println(filmes.get("imDbRating"));
			System.out.println();
		}
	}
}
