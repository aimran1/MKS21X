public class ReverseCharSequence implements CharSequence{

  String rev = "";

  //------------Main----------------
  public static void main(String[]args){
    ReverseCharSequence r = new ReverseCharSequence("DOGGO");
    System.out.println(r);
    System.out.println(r.charAt(2));
    System.out.println(r.length());
    System.out.println(r.substring(0,2));
  }

  // -----------Constructor---------------
  public ReverseCharSequence(String str){
    String newStr;
    for (int i = str.length() - 1; i > -1; i--){
      newStr += str.charAt(i);
    }       
    rev = newStr;
  }


  //------------Methods----------------
  public String toString(){
    String newStr = "";
    for (int i = 0; i < rev.length(); i++){
      newStr += rev.charAt(i);
    }
    return newStr;
  }

  public char charAt(int n){
    return rev.charAt(n);
  }

  public int length(){
    return rev.length();
  }

  public String subSequence(int start, int end){
    return rev.substring(start,end);
  }

}
