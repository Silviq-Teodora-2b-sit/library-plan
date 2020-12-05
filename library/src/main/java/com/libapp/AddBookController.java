package com.libapp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.scene.control.TextField;


import com.libapp.controllersFunctions.CommonFunctions;
import com.libapp.controllersFunctions.CommonFunctionsImpl;
import com.libapp.service.HibernateUtil;
import com.libapp.service.Service;
import com.libapp.service.ServiceImpl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
public class AddBookController implements Initializable {
	 private Logger LOGGER=LogManager.getLogger(SignInController.class);

	@FXML
    private TextField tx_title;

     @FXML
	 private TextField tx_Copies;

	 @FXML
	 private TextField tx_Status;
	  
    @FXML
    private ComboBox cb_genre;
    ObservableList<String> searchGenre = FXCollections.observableArrayList();
    ObservableList<String> searchAuthor = FXCollections.observableArrayList();
    ObservableList<String> searchPublisher = FXCollections.observableArrayList();

   @FXML
    private ComboBox cb_author;

    @FXML
    private ComboBox cb_Publisher;

  private String genreString=null;
  private String authorString=null;
  private String publisherString=null;
  private Genre genre=null;
  private Author author=null;
  private Publisher publisher=null;
  Service<Genre> genreService = new ServiceImpl<Genre>(Genre.class, HibernateUtil.getSessionFactory());
  Service<Author> authorService = new ServiceImpl<Author>(Author.class, HibernateUtil.getSessionFactory());
  Service<Publisher> publisherService = new ServiceImpl<Publisher>(Publisher.class, HibernateUtil.getSessionFactory());
  Service<Book> bookService = new ServiceImpl<Book>(Book.class, HibernateUtil.getSessionFactory());
  Map<Integer, Object> data = new HashMap<Integer, Object>();
  private CommonFunctions windowFunction;
    @FXML
    void SelectGenre(ActionEvent event) {
         genreString=(String) cb_genre.getValue();
         data.put(0, genreString);
         genre=genreService.namedQuery("Genre.getByName", data);
         data.clear();
         
    }
    @FXML
    void SaveBook(ActionEvent event) {
    	windowFunction=new CommonFunctionsImpl();
    	if(tx_title.getText().length()<2||tx_Copies.getText().length() <1 || tx_Status.getText().length()<4 || genre==null || author==null || publisher==null)
           {
           windowFunction.alertForSearchUser("Fill all filds!");
           }
   		
      	 else {
      		 User user=SignInController.saveUser;
      		 Book book=new Book(tx_title.getText(),genre,publisher,Integer.parseInt(tx_Copies.getText()),tx_Status.getText(),user);
      		 data.put(0,tx_title.getText());
      		 if(bookService.namedQuery("Book.getByTitle", data)==null)
      		 {
      		 bookService.save(book);
      		 windowFunction.alertForSearchUser("Save succsessfuly!");
      		LOGGER.info("User: "+ user.getUserName()+" save book in the DB!"+" Book "+book.getBookTitle());
      		 }
      		 else {
      			LOGGER.info("User: "+ user.getUserName()+" try to save in the DB but the book already exists!"+" Book "+book.getBookTitle());
      			windowFunction.alertForSearchUser("We already have this book!"); 
      		 }
      	 }
    	data.clear();
    }

    @FXML
    void SelectAuthor(ActionEvent event) {
    	authorString=(String) cb_author.getValue();
    	data.put(0, authorString);
        author=authorService.namedQuery("Author.getByName", data);
        data.clear();
     
    }
    
    @FXML
    void SelectPublisher(ActionEvent event) {
    	publisherString=(String) cb_Publisher.getValue();
    	data.put(0, publisherString);
        publisher=publisherService.namedQuery("Publisher.getByName", data);
        data.clear();
       
    }


@Override
public void initialize(URL location, ResourceBundle resources) {
	
	List<Genre> genres=genreService.query(null);
	  for (Genre g : genres) {
          searchGenre.add(g.getGenreName());
      }
	  cb_genre.setItems(searchGenre);
	 
	
	 List<Author> authors=authorService.query(null);
     for (Author a : authors) {
	 searchAuthor.add(a.getAuthorName());
	 }
     cb_author.setItems(searchAuthor);

	
	List<Publisher> publishers=publisherService.query(null);
	 for (Publisher p : publishers) {
     searchPublisher.add(p.getPublisherName());
   }
	 cb_Publisher.setItems(searchPublisher);
}

}
