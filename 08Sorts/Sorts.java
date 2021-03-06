import java.util.Arrays;

public class Sorts{

  public static String name(){
    return "10.Imran.Ahmed";
  }

  //-----------------Helper Methods---------------------
  private static void swap(int[]ary,int a, int b){
    int c =ary[a];
    ary[a] = ary[b];
    ary[b] = c;
  }

  public static boolean isSorted(int[]ary){
    for(int i = 0; i < ary.length - 1 ; i++){
      if(ary[i] > ary[i+1]){
        return false;
      }
    }
    return true;
  }


  //---------------Sort Functions---------------------
  public static void bogoSort(int[] ary){
    while(!isSorted(ary)){
      for(int i = 0 ; i < ary.length; i++){
        int temp = ary[i];
        int newSpot = (int)(Math.random()*ary.length);
        ary[i] = ary[newSpot];
        ary[newSpot] = temp;
      }
    }
  }

  public static void selectionSort(int[] ary){
    for (int i =0; i < ary.length; i++){
      int min = ary[i];
      int minInd = i;
      for (int j = i; j< ary.length; j++){
        if (ary[j] < min){
          min = ary[j];
          minInd = j;
        }
      }
      swap(ary,i,minInd);
    }
  }

  public static void insertionSort(int[] ary){
    for (int num = 0; num < ary.length; num++){
      int ind = num;
      int temp = ary[num];
      for (int i = num-1; i >= 0 && ary[i] > temp; i--){
        ary[i+1] = ary[i];
        ind = i;
      }
      ary[ind] = temp;
    }
  }

  public static void bubbleSort(int[] ary){
    for (int i = 0; i < ary.length; i++ ){
      for (int j = 1; j < ary.length - i; j++){
        if (ary[j - 1] > ary[j]){
          swap(ary,j, j-1);
        }
      }
    }
  }

  //-----------------TESTS-------------------
  //Time for selectionSort ---> about 1.7 seconds
  //Time for insertionSort ---> about 0.65 seconds
  //Time for bubbleSort    ---> about 8 seconds

  // public static void main(String[]args){
  // int[] randish = new int[50000];
  // for(int i = 0 ; i < randish.length; i++){
  //  randish[i] =(int)(Math.random()*100);
  // }
  // int a = 10, b = 20;
  // swap(a,b);
  // System.out.println(a + " " + b );
  // System.out.println(Arrays.toString(randish));
  // bogoSort(randish);
  // System.out.println(Arrays.toString(randish));
  // selectionSort(randish);
  // System.out.println(Arrays.toString(randish));
  // insertionSort(randish);
  // System.out.println(Arrays.toString(randish));
  // System.out.println(Arrays.toString(randish));
  // bubbleSort(randish);
  // System.out.println(Arrays.toString(randish));
  // }

}
