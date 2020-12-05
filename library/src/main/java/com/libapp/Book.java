package com.libapp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Book.getByTitle", query = "from Book where bookTitle=?")
@Table(name="BOOK")
public class Book {
	
	private int bookId;
    private String bookTitle;
    private Set<Author> bookAuthor = new HashSet<>();
    private Genre bookGenre;
    private Publisher bookPublisher;
    private int bookCopies ;
    private String bookStatus;
    private User userId;
	

    
    @Id
	@Column(name="BookId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
	@SequenceGenerator(name = "book_generator", sequenceName = "BOOK_SEQUENCE",allocationSize = 1,initialValue = 1)
	public int getBookId() {
		return bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "genreId", foreignKey = @ForeignKey(name = "GENREID_FK"))
	public Genre getBookGenre() {
		return bookGenre;
	}
	
	public void setBookGenre(Genre bookGenre) {
		this.bookGenre = bookGenre;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "publisherId", foreignKey = @ForeignKey(name = "PUBLISHERID_FK"))
	public Publisher getBookPublisher() {
		return bookPublisher;
	}
	
	public void setBookPublisher(Publisher bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	
	public int getBookCopies() {
		return bookCopies;
	}
	
	public void setBookCopies(int bookCopies) {
		this.bookCopies = bookCopies;
	}
	
	public String getBookStatus() {
		return bookStatus;
	}
	
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", foreignKey = @ForeignKey(name = "USERID_FK"))
	public User getUserId() {
		return userId;
	}
	
	public void setUserId(User userId) {
		this.userId = userId;
	}

	
	public Book() {
		super();
	}

	
	
	 @ManyToMany(fetch = FetchType.EAGER)

	public Set<Author> getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(Set<Author> bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	
	public Book(String bookTitle, Genre bookGenre, Publisher bookPublisher, int bookCopies,
			String bookStatus, User userId) {
		this.bookTitle = bookTitle;
		this.bookGenre = bookGenre;
		this.bookPublisher = bookPublisher;
		this.bookCopies = bookCopies;
		this.bookStatus = bookStatus;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle +  ", bookGenre="
				+ bookGenre + ", bookPublisher=" + bookPublisher + ", bookCopies=" + bookCopies + ", bookStatus="
				+ bookStatus + ", userId=" + userId + "]";
	}
    
    
	
}
