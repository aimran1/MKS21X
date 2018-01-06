import java.util.*;
public class SuperArray{

  //Variables
  private int size = 0;
  private String[] data;

  //Constructors
  public SuperArray() {
    data = new String[10];
  }
  public SuperArray(int startingCapacity) {
    data = new String[startingCapacity];
  }

  //----------------------Phase 1 Methods------------------
  public void clear(){
    data = new String[10];
    size = 0;
  }

  public int size(){
    return size;
  }

  public boolean isEmpty(){
    if(size == 0){
        return true;
      }
    return false;
  }

  public boolean add(String str){
    if (data.length == size){
      resize();
    }
    String[] temp = new String[data.length];
    for (int i = 0; i < size;i++){
      temp[i] = data[i];
    }
    temp[size] = str;
    data = temp;
    size += 1;
    return true;
  }

  public String toString(){
    String str = "[";
    for (int i = 0; i < size(); i++){
      str = str + data[i];
      if (i != size() - 1){
        str  = str + ", ";
      }
    }
    return  str + "]" ;
  }

  public String get(int index){
    if (index < 0 || index >= size()) {
      return null;
      //throw new IndexOutOfBoundsException();
    }
    return data[index];
  }

  public String set(int index, String str){
    if(index < 0 || index >= size()){
      return null;
      ////throw new IndexOutOfBoundsException();
    }
    String temp = data[index];
    data[index] = str;
    return temp;
  }

  //-----------------------Phase 2----------------------------
  private void resize(){
    String[] temp= new String[data.length * 2];
    for (int i=0; i < data.length; i++){
      temp[i] = data[i];
    }
    data = temp;
  }

  //-----------------------Phase 3----------------------------
  public boolean contains(String target){
    for (int i = 0; i <size(); i++){
      if (data[i].equals(target)){
        return true;
      }
    }
    return false;
  }

  public int indexOf(String target){
    for (int i = 0; i < size(); i++){
      if (data[i].equals(target)){
        return i;
      }
    }
    return -1;
  }

  public int lastIndexOf(String target){
    for (int i = size; i >= 0; i--){
      if (target.equals(data[i])){
        return i;
      }
    }
    return -1;
    }

  public void add(int index, String str){
    if (index < 0 || index > size()){
	// System.out.println("Index Out of Bounds!");
      return;
      //throw new IndexOutofBoundsError();
    }
    if (size+1 == data.length){
      resize();
    }
    String[] temp = new String[data.length];
    for (int i = 0; i < size()+1; i++){
      if(i == index) {
        i++;
        }
      if (i < index){
        temp[i] = data[i];
      }
      else if (i > index){
        temp[i] = data[i-1];
      }
    }
    size += 1;
    temp[index] = str;
    data = temp;
  }

  public String remove(int index){
    if (index < 0 || index >=  size()){
      return "Index Out of Bounds!";
      //throw new IndexOutOfBoundsException();
    }
    String word = "";
    String[]temp = new String[size()];
    for (int i = 0; i < index; i++){
      temp[i] = data[i];
    }
    for (int i = index; i < size(); i++){
      temp[i] = data[i+1];
    }
    data = temp;
    size = size - 1;
    return word;
  }

  public boolean remove(String str){
    if (contains(str)){
      remove(indexOf(str));
      size = size -1;
      return true;
    }
    return false;
  }
}
