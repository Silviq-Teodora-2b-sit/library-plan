package com.libapp;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Author.getByName", query = "from Author where authorName=?")
@Table(name="AUTHOR")
public class Author {

	private int authorId;
	private String authorName;
	private Set<Book>books= new HashSet<>();
	
	
	@Id
	@Column(name="AuthorId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
	@SequenceGenerator(name = "author_generator", sequenceName = "AUTHOR_SEQUENCE",allocationSize = 1,initialValue = 1)
	public int getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	@Column(name = "authorName")
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	
	public Author(String authorName) {
		this.authorName = authorName;
	}

	
	public Author() {
		super();
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName +"]";
	}

	@ManyToMany(mappedBy = "bookAuthor",fetch = FetchType.EAGER)
	public Set<Book> getBooks() {
		return books;
	}

	
	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	
}