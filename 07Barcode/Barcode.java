import java.util.*;
import java.io.*;

public class Barcode implements Comparable<Barcode>{

  private String zip;
  private String nums = "0123456789";
  private static String[] bar = {"||:::", ":::||", "::|:|", "::||:",":|::|",
                                 ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};

  //----------Constructors-------------
  public Barcode(String zip){
    if (zip.length() != 5){
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < zip.length(); i++){
      if(nums.indexOf(zip.substring(i,i+1)) < 0){
        throw new IllegalArgumentException();
      }
    }
    this.zip = zip;
  }

  //--------------Overridden Methods--------------
  public int compareTo(Barcode other){
    if (Integer.parseInt(this.getZip()) - Integer.parseInt(other.getZip()) > 0){
      return 1;
    }
    else if (Integer.parseInt(this.getZip()) - Integer.parseInt(other.getZip()) < 0){
      return -1;
    }
    else {
      return 0;
    }
  }

  public boolean equals(Barcode other){
    for (int i = 0; i < 5; i++){
      if (this.getZip().charAt(i) != other.getZip().charAt(i)){
        return false;
      }
    }
    return true;
  }

  //---------------Getters-----------------
  public String getZip(){
    return zip;
  }

  public String getCode(){
    return toCode(getZip());
  }

  public String toString(){
    return getCode() + " (" + getZip() + ")";
  }

  //--------------Other Methods-----------------


  //-----------CheckSum Helper Method-------------
  public static int checkSum(String zip){
    int sum = 0;
    for (int i = 0; i < 5; i++){
      sum += Integer.parseInt(zip.substring(i,i+1));
    }
    return sum % 10;
  }



  public static String toCode(String zip){
    String code = "|";
    for (int i = 0; i < 5; i++){
      code += bar[Integer.parseInt(zip.substring(i,i+1))];
    }
    return code + bar[checkSum(zip)] + "|";
  }



  public static String toZip(String code){

    //------------EXCEPTIONS-------------------
    if (code.length() != 32){
      throw new IllegalArgumentException();
    }
    if (code.charAt(0) != '|'){
      throw new IllegalArgumentException();
    }
    if (code.charAt(31) != '|'){
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < 32; i++){
      if (code.charAt(i) != '|' || code.charAt(i) != ':'){
        throw new IllegalArgumentException();
      }
    }

    //----------------Fields------------------
    String nums = "";
    code = code.substring(1,31);
    boolean valid = false;

    //-------------Check for valid numbers--------------
    for (int i = 0; i < 30;){
      for (int j = 0; j < bar.length; j++){
        if (bar[j].equals(code.substring(i,i+5))){
          valid = true;
        }
        if (j == 9 && valid == false){
          throw new IllegalArgumentException();
        }
        nums += j;
      }
      i += 5;
    }

    //---------------Check for checkSum Exception--------------------
    if (nums.charAt(5) != checkSum(nums.substring(0,5))){
      throw new IllegalArgumentException();
    }

    //-------------Return the Zip----------------
    return nums.substring(0,5);

  }

}













  //  public static void main(String[] args){

  //My Tests
    // Barcode home  = new Barcode("12345");
    // Barcode hous = new Barcode("12345");
    // System.out.println(home.compareTo(hous));
    // Barcode store = new Barcode("00000");
    // System.out.println(home.compareTo(store));
    // System.out.println(home);
    // System.out.println(hous);
    // System.out.println(store);
    // System.out.println(toZip("|:::||::|:|::||::|::|:|:|::|:|:|"));
    // System.out.println(toCode(00000));
    // System.out.println("|:::||::|:|::||::|::|:|:|::|:|:|".charAt(31));

  //Others Tests

    // Barcode a = new Barcode("11245");
    // Barcode b = new Barcode("38760");
    // Barcode c = new Barcode("11245");
    // Barcode d = new Barcode("00294");
    // System.out.println(a.getZip());//11245
    // System.out.println(d.getZip());//00234
    // System.out.println(a.getCode());// |:::||:::||::|:|:|::|:|:|:::||:|
    // System.out.println(a.toString());// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
    // System.out.println(b);// |::||:|::|:|:::|:||::||::::|::|| (38760)
    // System.out.println(c);// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
    // System.out.println(d);// |||:::||:::::|:||:|:::|::|:|:|:| (00294)
    // System.out.println(a.compareTo(b));// negative
    // System.out.println(a.compareTo(c));// 0
    // System.out.println(a.compareTo(d));// positive
    // System.out.println(a.equals(b));// false
    // System.out.println(a.equals(c));// true
    // System.out.println(a.equals(d));// false
    // Barcode y = new Barcode("11133");
    // Barcode x = new Barcode("11111");
    // Barcode z = new Barcode("11111");
    // System.out.println(y);
    // System.out.println(y.getZip());
    // System.out.println(y.getCode());
    // System.out.println(x.equals(y));
    // System.out.println(x.compareTo(y));
    // System.out.println(x.equals(z));
    // System.out.println(Barcode.toCode("00294")); // |||:::||:::::|:||:|:::|::|:|:|:|
    // System.out.println(Barcode.toCode("asdfd")); //Contains non-barcode characters, should throw IllegalArgumentException
    // System.out.println(Barcode.toCode("1234")); //Invalid length, should throw IllegalArgumentException
    // System.out.println(Barcode.toZip("|||:::||:::::|:||:|:::|::|:|:|:|")); //Should return 00294
    // System.out.println(Barcode.toZip("|:::||:::||::|:|:|::|:|:|:::||:")); //Invalid length, should throw IllegalArgumentException
    // System.out.println(Barcode.toZip("|:::||:::||::|:|:|::|:|:|:::||||")); //Incorrect checksum, should throw IllegalArgumentException
    // System.out.println(Barcode.toZip("|a::||:::||::|:|:|::|:|:|:::||:|")); //Contains non-barcode characters, should throw IllegalArgumentException
    // System.out.println(Barcode.toZip("::::||:::||::|:|:|::|:|:|:::||:|")); //First character is not '|', should throw IllegalArgumentException
    // System.out.println(Barcode.toZip("|:::||:::||::|:|:|::|:|:|:::||::")); //Last character is not '|', should throw IllegalArgumentException
    // System.out.println(Barcode.toZip("|::::::::||::|:|:|::|:|:|:::||:|")); //Invalid character sequence, should throw IllegalArgumentException
    // System.out.println("CODE THOROUGHLY TESTED");
  //  }
