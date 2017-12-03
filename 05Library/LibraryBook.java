public abstract class LibraryBook
    extends Book
    implements Comparable<LibraryBook>
{
    //------------Fields------------
    String callNumber;

    //------------Constructors-------------
    public LibraryBook(String author, String title,
                       String ISBN, String callNumber){
      super(author,title,ISBN);
      this.callNumber = callNumber;
    }

    //-----------Getters and Setters-----------
    public String getCallNumber(){
      return callNumber;
    }

  public void setCallNumber(String s){
    callNumber = s;
  }

    //------------Methods-------------
    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();
  
  public int compareTo(LibraryBook other){
    return this.getCallNumber().compareTo(other.getCallNumber());
  }
  
  public String toString(){
    return super.toString() + " , " + getCallNumber();
  }
  
}
