import java.util.*;
import java.io.*;

public class WordSearch{

  //-------------------MAIN FUNCTION-------------------------

  public static void main(String[] args){

    int num = args.length; //Amount of Parameters
    int rows = 0, cols = 0, seed = 0;
    boolean  key = false;

    //Select Appropriate Constructor Based On Parameters Provided
    //Return Appropriate Error Messages for Incorrect Inputs

    if (num < 3){
      System.out.println("More parameters are required. Parameters required(in the following order): ROWS COLUMNS FILENAME");
      System.out.println("Additional parameters(in the following order): SEED KEY?");
      System.exit(1);
    }

    if (num == 3){

      //Check for Appropriate Fields
      try {
        rows = Integer.parseInt(args[0]);
        cols = Integer.parseInt(args[1]);
      }catch (NumberFormatException e){
        System.out.println("Please input integers in number form (1, 2, 3...)");
        System.exit(1);
      }

      //Use First Constructor
      WordSearch puzzle = new WordSearch(rows,cols,args[2]);
      System.out.println(puzzle);
    }

    if (num == 4){

      //Check for Appropriate Fields
      try {
        rows = Integer.parseInt(args[0]);
        cols = Integer.parseInt(args[1]);
        seed = Integer.parseInt(args[3]);
      }catch (NumberFormatException e){
        System.out.println("Please input integers in number form (1, 2, 3...) for the 1st, 2nd, and 4th parameters.");
        System.exit(1);
      }

      //Use Second Constructor
      WordSearch puzzle = new WordSearch(rows,cols,args[2],seed);
      System.out.println(puzzle);
    }

    if (num == 5){

      //Check for Appropriate Fields
      try{
        rows = Integer.parseInt(args[0]);
        cols = Integer.parseInt(args[1]);
        seed = Integer.parseInt(args[3]);
      }catch (NumberFormatException e){
        System.out.println("Please input integers in number form (1, 2, 3...) for the 1st, 2nd, and 4th parameters.");
        System.exit(1);
      }
      if (!args[4].equals("true") && !args[4].equals("false")){
        System.out.println("Please input 'true' in lowercase if you would like an answer key.");
      }

      //Use Third Constructor
      if (args[4].equals("true")){
        key =true;
      }
      WordSearch puzzle = new WordSearch(rows,cols,args[2],seed,key);
      System.out.println(puzzle);
    }

  }

  //~~~~~~~~~~~~~~~~~~Variables~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  private char[][]data; //Puzzle
  private char[][]key; //Answer Key
  private boolean keychoice = false;
  private Random randgen;
  private ArrayList<String>wordsToAdd = new ArrayList<String>();//Scanned File
  private ArrayList<String>wordsAdded = new ArrayList<String>();//Word Bank

  //~~~~~~~~~~~~~~~~~~~~~~CONSTRUCTORS~~~~~~~~~~~~~~~~~~~~~~~

  //Constructor for Regular Word Search.
  public WordSearch(int rows,int cols, String filename){

    data = new char[rows][cols];
    this.key = new char[rows][cols];

    //Does File Exist???
    try{
      File f = new File(filename);
      Scanner in = new Scanner(f);
      while (in.hasNext()){
        wordsToAdd.add(in.next().toUpperCase());
      }
    }catch(FileNotFoundException e){
      System.out.println("File not found: " + filename);
      System.exit(1);
    }

    randgen = new Random();//Create Seed
    addAllWords();
    System.out.println("Word Bank: " + wordsAdded);
    System.out.println("Seed: " + randgen.nextInt());

  }

  //Constructor for Puzzle with Seed and no Answer Key.
  public WordSearch(int rows,int cols, String filename, int randSeed){

    data = new char[rows][cols];
    this.key = new char[rows][cols];

    //Does File Exist???
    try{
      File f = new File(filename);
      Scanner in = new Scanner(f);
      while (in.hasNext()){
        wordsToAdd.add(in.next().toUpperCase());
      }
    }catch(FileNotFoundException e){
      System.out.println("File not found: " + filename);
      System.exit(1);
    }

    randgen = new Random(randSeed);//Incorporate Seed Input
    addAllWords();
    System.out.println("Word Bank: " + wordsAdded);
    System.out.println("Seed: " + randSeed);

  }

  //Constructor for puzzle with Answer Key Included
  public WordSearch(int rows, int cols, String filename, int randSeed, boolean keychoice){

    data = new char[rows][cols];
    this.key = new char[rows][cols];

    //Does File Exist???
    try{
      File f = new File(filename);
      Scanner in = new Scanner(f);
      while (in.hasNext()){
        wordsToAdd.add(in.next().toUpperCase());
      }
    }catch(FileNotFoundException e){
      System.out.println("File not found: " + filename);
      System.exit(1);
    }

    randgen = new Random(randSeed);//Incorporate Seed Input
    addAllWords();
    System.out.println("Seed: " + randSeed);

    //Check if user wants key
    if (keychoice){
      this.keychoice = keychoice;
      System.out.println("Key:" + "\n" +  keyToString());
    }

    System.out.println("Word Bank: " + wordsAdded);

  }

  //~~~~~~~~~~~~~~~~~~~~~~METHODS~~~~~~~~~~~~~~~~~~~~~~


  //Removes Contents of Puzzle and Replaces with "_".
  private void clear(){
    for (int i = 0; i < data.length; i++){
      for (int j = 0; j < data[i].length; j++){
        data[i][j] = '_';
      }
    }
  }

  //Fills in Empty Spaces on WordSearch with Random Letters.
  private void fillIn(){
    char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    for (int i = 0; i < data.length; i++){
      for (int j = 0; j < data.length; j++){
        if(data[i][j] == '_'){
          data[i][j]=letters[randgen.nextInt(26)];
        }
      }
    }
  }

  //Formats Data for Printing.
  public String toString(){
    String search = "";
    for (int i = 0; i < data.length; i++){
      for (int j = 0; j < data[i].length; j++){
        search += " " + data[i][j];
      }
      search += '\n';
    }
    return search;
  }

  //Formats Answer Key for Printing.
  public String keyToString(){
    String search = "";
    for (int i = 0; i < key.length; i++){
      for (int j = 0; j < key[i].length; j++){
        search += " " + key[i][j];
      }
      search += '\n';
    }
    return search;
  }


  //------------------------Methods to ADD to Puzzle----------------------------


  private boolean addWord(int r, int c, String word, int rowIncrement, int colIncrement){

    int row = r, col = c; //Temporary rows and cols to check if the word fits.

    //Check for valid increments.
    if (rowIncrement < -1 || rowIncrement > 1 ||
        colIncrement < -1 || colIncrement > 1 ||
        (colIncrement == 0 && rowIncrement == 0)){
      return false;
    }

    //Check if each Character of Word Fits at the Appointed Locations
    try{
      for (int i =0; i < word.length(); i++){
        if (data[row][col]!='_' &&  data[row][col] != word.charAt(i)){
          return false;
        }
        row += rowIncrement;
        col += colIncrement;
      }
    }catch(IndexOutOfBoundsException e){
      return false;
    }

    //Word Fits ----> Add to the Puzzle
    for (int i = 0; i < word.length(); i++){
      data[r][c] = word.charAt(i);
      r+= rowIncrement;
      c+= colIncrement;
    }

    //Remove and Add words from the Appropriate Arraylists.
    wordsToAdd.remove(word);
    wordsAdded.add(word);
    return true;

  }

  private boolean addAllWords(){
    //remove any elements that may be found in data.
    clear();

    for (int i = 0; i < 10000; i++){

      //All words are added ----> make key and finish puzzle.
      if (wordsToAdd.size() == 0){
        for (int r = 0; r < data.length; r++){
          for (int c = 0; c < data.length; c++){
            key[r][c] = data[r][c];
          }
        }
        fillIn();
        return true;
      }

      //Add words in random order and in random locations within data.
      addWord(randgen.nextInt(data.length),
              randgen.nextInt(data[0].length),
              wordsToAdd.get(randgen.nextInt(wordsToAdd.size())),
              randgen.nextInt(3)-1,
              randgen.nextInt(3)-1);
    }

    //Create the Key for the Puzzle even though all Words are not added.
    for (int i = 0; i < data.length; i++){
      for (int j = 0; j < data.length; j++){
        key[i][j] = data[i][j];
      }
    }
    fillIn();
    return false;
  }

}
