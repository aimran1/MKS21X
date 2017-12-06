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

  //---------------Getters-----------------
  public String getZip(){
    return zip;
  }

  public String getCode(){
    return "|" + toCode(zip) + "|";
  }

  public String toString(){
    return getCode() + "(" + getZip() + ")";
  }

  //--------------Other Methods-----------------
  public static String toCode(String zip){
    String code = "|";
    for (int i = 0; i < 5; i++){
      code += bar[Integer.parseInt(zip.substring(i,i+1))];
    }
    return code;
  }
}
