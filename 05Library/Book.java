public class Book{
    
    //----------Fields-------------
    private String author, title, ISBN;

    //--------Constructors---------
    public Book(){}
    public Book(String author, String title, String ISBN){
	this.author = author;
	this.title = title;
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

    
    public void setAuthor(String s){
	author = s;
    }
    public void setTitle(String s){
	title = s;
    }
    public void setISBN(String s){
	ISBN = s;
    }

    
    public String toString(){
	return this.getTitle() + " , " + this.getAuthor() + " , " + this.getISBN(); 
    }
}
