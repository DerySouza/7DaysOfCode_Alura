package Desafio.API.Desafio_API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONObject;

public class Teste {
	
    public static void main( String[] args ) throws IOException, InterruptedException, ExecutionException {
    	 
    	Busca rankDeFilmes = new Busca();
        CompletableFuture<List<String>> asyncResult = rankDeFilmes.fetchReporterArea();
        
        asyncResult.get().forEach(System.out::println);
		 
    }
      
}
