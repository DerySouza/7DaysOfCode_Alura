package Desafio.API.Desafio_API;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.json.JSONArray;
import org.json.JSONObject;

public class Busca {
	
 private static final String API_URL = "https://imdb-api.com/en/API/Top250Movies/API_KEY";
    
	public CompletableFuture<List<String>> fetchReporterArea() {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(Busca::parse);
    }
	public static List<String> parse(String dados) {

        JSONObject filmes = new JSONObject(dados);

        List<String> list = new ArrayList<String>();
        JSONArray array = filmes.getJSONArray("items");

        for (int i = 0; i < array.length(); i++) {
            JSONObject fila = array.getJSONObject(i);
            
            list.add(fila.optString("rank") + "; " + fila.optString("title"));
        }
        
        return list;
    }
}
