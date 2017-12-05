import java.util.*;
import java.io.*;

public class Barcode implements Comparable<Barcode>{

  String zip;
  String nums = "0123456789";

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

  public String getZip(){
    return zip;
  }

}
