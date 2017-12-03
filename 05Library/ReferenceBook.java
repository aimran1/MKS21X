public class ReferenceBook extends LibraryBook{
  String collection;

  //-----------Constructors-----------
  public ReferenceBook(String aut, String tit, String I, String call, String coll){
    super(aut,tit,I,call);
    collection= coll;
  }

  //---------------Getters and Setters---------------
  public String getCollection(){
    return collection;
  }
  public void setCollection(String s){
    collection = s;
  }

  //----------------Methods-------------------

  public void checkout(String patron, String due){
    throw new UnsupportedOperationException("cannot check out a reference book");
  }

  public void returned(){
    throw new UnsupportedOperationException("reference book could not have been checked out -- return impossible");
  }

  public String circulationStatus(){
    return ("non-circulating reference book");
  }

  public String toString(){
    return super.toString() + " , " + collection;
  }

}
