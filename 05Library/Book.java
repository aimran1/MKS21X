public class Book{

    //----------Fields-------------
    private String author, title, ISBN;

    //--------Constructors---------
    public Book(){}
    public Book(String aut, String tit, String ISBN){
	author = aut;
	title = tit;
	this.ISBN = ISBN;
    }

    //---------Getters and Setters-----------
    public String getAuthor(){
	return author;
    }
    public String getTitle(){
	return title;
    }
    public String getISBN(){
	return ISBN;
    }
    public String toString(){
	return title + "," + author + "," + ISBN; 
    }
}
