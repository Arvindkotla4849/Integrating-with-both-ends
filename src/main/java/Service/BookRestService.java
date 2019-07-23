package Service;

import Model.Book;
import org.eclipse.swt.widgets.Display;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookRestService {
    public RestTemplate restTemplate = null;

    public BookRestService() {
        this.restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        restTemplate.getMessageConverters().add(converter);
    }

    public void createBook(Book bookRental) {
        String url = "http://localhost:8089/bookRental";
       /* String body =  "{\n" +
                "  \"isbn\":5764,\t\n" +
                "  \"authorName\":\"india\",\n" +
                "  \"bookTitle\":\"hyderbad\",\n" +
                "  \"isAcademic\":\"true\",\n" +
                "  \"stock\":15\n" +
                "}";*/
        HttpHeaders headers = new HttpHeaders();
        List<MediaType> accept = new ArrayList<>();
        accept = Arrays.asList(MediaType.APPLICATION_JSON);
        headers.setAccept(accept);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Book> request = new HttpEntity<>(bookRental, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Book> responseEntity = null;
        try {

            responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, Book.class);
            System.out.println("Status code is " + responseEntity.getStatusCode());
            System.out.println(" response body is " + responseEntity.getBody());
            System.out.println("response header is " + responseEntity.getHeaders());
        } catch (HttpStatusCodeException e) {
            String string = e.getResponseBodyAsString();
        } catch (RestClientException e) {
            System.out.println("");
        }
    }

    public List<Book> getAllBook(String s, Display display) {

        String url = "http://localhost:8089/bookRental";

        HttpHeaders headers = new HttpHeaders();
        List<MediaType> accept = new ArrayList<>();
        accept.add(MediaType.APPLICATION_JSON);
        headers.setAccept(accept);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity(headers);

        ResponseEntity<List<Book>> responseEntity;
        ParameterizedTypeReference<List<Book>> parameterizedTypeReference = new ParameterizedTypeReference<List<Book>>() {
        };
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, parameterizedTypeReference);
            List<Book> books = responseEntity.getBody();
            for (Book book1 : books) {
                System.out.println(" " + book1.toString());
            }
            System.out.println("Status code is " + responseEntity.getStatusCode());
            //System.out.println(" response body is " +responseEntity.getBody());
            System.out.println("response header is " + responseEntity.getHeaders());
            return books;
        } catch (HttpStatusCodeException e) {

            String string = e.getResponseBodyAsString();
        } catch (RestClientException e) {

        }

        return null;
    }

    public void getByAuthor(String s, Display display) {
        String url = "http://localhost:8089/bookRental/byAuthor";
        HttpHeaders headers = new HttpHeaders();
        List<MediaType> accept = new ArrayList<>();
        accept.add(MediaType.APPLICATION_JSON);
        headers.setAccept(accept);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request;
        request = new HttpEntity<>(headers);
        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
            System.out.println("Status code is " + responseEntity.getStatusCode());
            System.out.println(" response body is " + responseEntity.getBody());
            System.out.println("response header is " + responseEntity.getHeaders());

        } catch (HttpStatusCodeException e) {
            String string = e.getResponseBodyAsString();
        } catch (RestClientException e) {
        }
    }

    public String deleteById() {

        String url = "http://localhost:8089/bookRental/delete/5";
        HttpHeaders headers = new HttpHeaders();
        List<MediaType> accept;
        accept = new ArrayList<>();
        accept.add(MediaType.APPLICATION_JSON);
        headers.setAccept(accept);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(headers);
        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);
            System.out.println("Status code is " + responseEntity.getStatusCode());
            System.out.println(" response body is " + responseEntity.getBody());
            System.out.println("response header is " + responseEntity.getHeaders());
            System.out.println("Book Deleted Successfully");
        } catch (HttpStatusCodeException e) {
            String string = e.getResponseBodyAsString();
        } catch (RestClientException e) {

        }
        return null;
    }

    public void getByAuthor(Book bookRental) {
    }
}