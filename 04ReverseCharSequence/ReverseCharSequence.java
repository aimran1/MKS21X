public class ReverseCharSequence implements CharSequence{

  String str = "";

  //------------Main----------------
  public static void main(String[]args){
    ReverseCharSequence r = new ReverseCharSequence("DOG");
    System.out.println(r);
  }

  // -----------Constructor---------------
  public ReverseCharSequence(String str){
    this.str = str;
    toString();
  }



  //------------Methods----------------
  public String toString(){
    String newStr = "";
    for (int i = str.length() - 1; i > -1; i--){
      newStr += str.charAt(i);
    }
    str = newStr;
    return str;
  }

  public char charAt(int n){
    return str.charAt(n);
  }

  public int length(){
    return str.length();
  }

  public String subSequence(int start, int end){
    String newStr = "";
    for (int i = start; i <end+1; i++){
      newStr += str.charAt(i);
    }
    return newStr;
  }

}
