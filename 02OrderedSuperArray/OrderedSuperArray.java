import java.util.*;

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
    add(value);
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





public static void runTest02(int testID){
  
  if(testID<0){
    System.out.println("Error in driver usage!");
    System.exit(0);
  }
  
  OrderedSuperArray s1 = new OrderedSuperArray();
  ArrayList<String> s2 = new ArrayList<>();
  
  try{
    if(testID == 0 ){
    }
    
    if(testID == 1 ){
      s1.add("4");
      s2.add("4");
      s1.add("1");
      s2.add("1");
      s1.add("0");
      s2.add("0");
    }
    
    if(testID == 2 ){
      s1.add("3");
      s2.add("3");
      s1.add("1");
      s2.add("1");
      s1.add("5");
      s2.add("5");
      s1.add("0");
      s2.add("0");
    }
    
    if(testID == 3 ){
      s1.add("1");
      s2.add("1");
      for(int i = 0; i < 10; i ++){
        String v = ""+(int)(Math.random()*1000);
        int in = (int)(Math.random()*s2.size());
        s1.add(in,v);
        s2.add(in,v);
      }
    }
    
    if(testID == 4 ){
      s1.add("1");
      s2.add("1");
      try{
        s1.set(0,"");
      } catch(UnsupportedOperationException e){
        
      }
    }
    
    if(testID == 5 ){
      try{
        s1.set(0,"");
      } catch(UnsupportedOperationException e){
        
      }
    }
    
    if(testID == 6 ){
      String[] x= {"adsf","b","X","C","fish","cat","Abby","break","romp"};
      s1 = new OrderedSuperArray(x);
      s2.addAll(Arrays.asList(x));
    }
    if(testID == 7 ){
      s1.add("1");
      s2.add("1");
      
      for(int i = 0; i < 1000;   i ++){
        String v = ""+(int)(Math.random()*1000);
        s1.add(v);
        s2.add(v);
      }
    }
    
    
  }catch(Exception f){
    s2.add("0");
    //f.printStackTrace();
  }
  
  Collections.sort(s2);
  if(equals(s1,s2)){
    System.out.println("Test "+testID+",PASS");
  }else{
    System.out.println("Test "+testID+",FAIL!");// "+s1+"!="+s2);
  }
}



//oops!

public static boolean equals(OrderedSuperArray s, ArrayList<String> a){
    if(s.size() == a.size()){
      for(int i = 0; i < s.size(); i++){
        if(s.get(i) != a.get(i)){
          return false;
        }
      }
      return true;
    }
    return false;
  }


    public static void main(String[] args){
  runTest02(0);
  runTest02(1);
  runTest02(2);
  runTest02(3);
  runTest02(4);
  runTest02(5);
  runTest02(6);
  runTest02(7); 
    }
    
}
