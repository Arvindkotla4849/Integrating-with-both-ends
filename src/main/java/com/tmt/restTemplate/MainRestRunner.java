package com.tmt.restTemplate;

import Model.Book;
import Service.BookRestService;

  public class MainRestRunner
  {
      public static void main(String[] args)
      {
          BookRestService bookRestService = new BookRestService();
         Book bookRental=new Book();
         /* Book bookRental=new Book(10,"blaster","BK",true,14);
          Book bookRental1=new Book(11,"King","MS",false,18);
          */
        // Book bookRental3=new Book(5764,"india","hyderabad",true,15);
        // bookRestService.createBook(bookRental);
        //bookRestService.getAllBook("http://localhost:8080/book/byAuthorName/", display);
         // bookRestService.getByAuthor(bookRental);
         bookRestService.deleteById();
      }

  }
