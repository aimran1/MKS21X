public class OrderedSuperArray extends SuperArray{
  String[] subData = new String[10];
  /*constructor initializes an empty List*/

  public OrderedSuperArray(){
    super();
  }

  public OrderedSuperArray(int capacity){
    super(capacity);
  }

  public OrderedSuperArray(String[] ary){
    for(int i = 0; i < ary.length; i++){
      add(ary[i]);
    }
  }


    //-----Overridden Methods------
  public void add(int index, String value){
    super.add(value);
  }

  public String set(int index, String element){
    throw new  UnsupportedOperationException();
  }


  //---------Index Locator Methods-----------
  private int findIndex(String target){
    int index = 0;
    for (int i = 0; i < size(); i++){
      if (isGreaterThan(target, get(i))){
        index++;
      }
    }
    return index;
  }


  private int findIndexBinary(String element){
    int start = 0, end = size();
    for (int i = findMid(0, size()); start - end >= 1;){
      if (element.equals(get(i))){
        return i;
      }
      else if (isGreaterThan(get(findMid(start,end)), element)){
        end = findMid(start, end);
        start = 0;
     }
     else {
       start = findMid(start,end) ;
       end = end;
     }
    }
    return start;
  }

  
  //-----------Helper Methods-------------
  public boolean isGreaterThan(String a, String b){
    if (a.compareTo(b) >  0){
      return true;
    }
    return false;
  }

  public int findMid(int start, int end){
    return (start + end ) / 2;
  }

  //--------------ADD SORTED-----------------
  public boolean add(String value){
    super.add(findIndex(value), value);
    return true;
    //you may still use super.add(index,value)
  }
}
