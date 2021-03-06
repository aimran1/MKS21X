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
    else if (code.charAt(0) != '|'){
      throw new IllegalArgumentException();
    }
    else if (code.charAt(31) != '|'){
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < 32; i++){
      if (code.charAt(i) != '|' && code.charAt(i) != ':'){
        throw new IllegalArgumentException();
      }
    }

    //----------------Fields------------------
    String nums = "";
    code = code.substring(1,31);

    //-------------Check for valid numbers--------------
    for (int i = 0; i < 30;){
      int digit = -1;
      for (int j = 0; j < bar.length; j++){
        if (bar[j].equals(code.substring(i,i+5))){
          digit = j;
        }
      }
      if (digit < 0){
          throw new IllegalArgumentException();
      }
      nums += digit;
      i += 5;
    }

    //---------------Check for checkSum Exception--------------------
    if (!(code.substring(25,30).equals(bar[checkSum(nums.substring(0,5))]))){
      throw new IllegalArgumentException();
    }

    //-------------Return the Zip----------------
    return nums.substring(0,5);
  }

}
