public abstract class LibraryBook
    extends Book
    implements Comparable<LibraryBook>
{
    //------------Fields------------
    String callNumber;

    //------------Constructors-------------
    public LibraryBook(String author, String title,
		       String ISBN, String callNumber){
	super();
	this.callNumber = callNumber;
    }

    //-----------Getters and Setters-----------
    public String getCallNumber(){
	return callNumber;
    }

    //------------Methods-------------
    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();
    public int compareTo(Book other){
	if (this.getCallNumber() - other.getCallNumber() < 0){
	    return -1;
	}
	else if (this.getCallNumber() - other.getCallNumber() == 0) {
	    return 0;
	}
	else {
	    return 1;
	}
    }
}
