public class CirculatingBook extends LibraryBook{
  private String currentHolder, dueDate;

  //---------------Constructor----------------
  public CirculatingBook(String aut, String tit, String ibs, String call){
    super(aut,tit,ibs,call);
    currentHolder = null;
    dueDate = null;
  }

  //-------------Getters & Setters---------------
  public String getCurrentHolder(){
    return currentHolder;
  }
  public String getDueDate(){
    return dueDate;
  }

  public void setCurrentHolder(String s){
    currentHolder = s;
  }
  public void setDueDate(String s){
    dueDate = s;
  }

  //-----------------Methods----------------
  public void checkout(String patron, String due){
    setCurrentHolder(patron);
    setDueDate(due);
  }
  public void returned(){
    setCurrentHolder(null);
    setDueDate(null);
  }

  public String circulationStatus(){
    if (getCurrentHolder() == null && getDueDate() == null){
      return "book available on shelves";
    }
    else{
      return getCurrentHolder() + " , " + getDueDate();
    }
  }

  public String toString(){
    if (getCurrentHolder() == null && getDueDate() == null){
      return super.toString();
    }
    else {
      return super.toString() + " , " + circulationStatus();
    }
  }

}
