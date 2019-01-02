/*
 * Renee Veit
 * Mr. Maroney
 * 1/12/18
 * Period 4
 */

import java.util.Scanner;
import java.io.*;
import java.util.*;
public class IndexMaker
{
    public ArrayList<IndexObj>indexter;
     
     //constructor to initiallize fields (and clean up syntax throughout class)
    public IndexMaker(){
        indexter = new ArrayList<IndexObj>();
    }
     //using the try catch to get user input
    public void readInFile(){
        try{
         Scanner fileIO = new Scanner(new File("fishyFish.txt")); 
         BufferedWriter out = new BufferedWriter(new FileWriter("OUTPUT.TXT"));
         
         String line; 
         ArrayList <String> tempWordList = new ArrayList<String>();//temp arrayList
         IndexObj indexterObj;
         int lineNum = 0;//LINE NUMBER
         
         while(fileIO.hasNext()){
             //hasNext vs hasNextLine
             //READ IN ONE LINE AT A TIME
             
             
             line = fileIO.nextLine();//***.next = next word, .nextLine = better
             
             String capital = capitalize(line);
             //CREATE OBJ WITH EACH NUM AND CAPITALIZED LINE
             
             tempWordList = readInWords(capital);
             
             //System.out.println(tempWordList);//testing output to 
             //see if temp array works
             
             lineNum++;//LINE NUMBER
             //how many lines are actually being read in?
             //fileIO.hasNext() stops at the last sentence, right?
             fillIndexter(tempWordList, lineNum);//should I read in tempWordList?//fill global indexter with indexObj's
            
             //indexter.add(indexterObj);
        }
 
        /*
        for(int i = 0; i < indexter.size(); i++){
            eachIndex = indexter.get(i);
            System.out.println(eachIndex);    
         }*/
         //don't print arrayList, print each object
        //System.out.println(indexter);//arrayList of IndexObj objects 
        
        for(IndexObj eachIndex : indexter){
            System.out.println(eachIndex);
        }
        
        out.close();//close = "cap" file
        
        fileIO.close();//forces program to write out everything to file
       }
       catch (IOException e){
          System.out.println("File error" +e);
          System.out.println("+e");
      }
    }
    
    //separating each word from the file
    public ArrayList<String> readInWords(String capitalLine){
       //need another temp array
       Scanner sentence = new Scanner(capitalLine);//using Scanner without try/catch
            
       ArrayList <String> tempWords = new ArrayList <String>();//tempArrayList
       
       String word;
       int counter = 0;
            
       while(sentence.hasNext()){
          word = sentence.next();
                
          //put words into array as they are being
          //separated from the sentence
          //wordByWord.set(counter, word);//can't do bc we haven't made a obj yet
                
          tempWords.add(word);
          //must sort words AS you put them into array

        }
       //out.close(); //close ("cap") file  
       //fileIO.close();//forces program to write out everything to file
       
       return tempWords;//tempArray
    }
    
    //*
    private void fillIndexter(ArrayList<String> tempWordList, int lineNumber){
        IndexObj indexObj;
        String capWord = "";
        String eachWord = "";
        String tempWord = "";
        
        for(int index = 0; index < tempWordList.size(); index++){
            //System.out.println(tempWordList);
            
            capWord = tempWordList.get(index);
            
            //should this be b4 or after if statement
            indexObj = new IndexObj(capWord, lineNumber);
            
            // number of lines is returning zero everytime
            //indexObj.setLineNum(lineNumber);
            //shouldn't have to do this each time,
            //lineNumber is set when you make indexObj
            
            
            if(indexter.size() == 0){//if list = empty
                indexter.add(indexObj);//add indexObjs to global arrayList
            }else{
                searchInsert(indexObj);
                //indexter.add(indexObj);//add indexObjs to global arrayList***
            }
            
            
        }
        //don't return
    }
    
    private void searchInsert(IndexObj indexObj){
        int counter = 0;
        boolean done = false;
        String wIndexter, wordIObj;
        int number = indexObj.getLineNum();
        //need indexter obj
        IndexObj arrayObj;
        
        
        wordIObj = indexObj.getWord();
        //is something wrong with the size of indexter? how is indexter growing?
        //also, index numbers are off
        //fish isn't working correctly
        while(counter < indexter.size() && !done){

            wIndexter = indexter.get(counter).getWord();
            arrayObj = indexter.get(counter);
            //check to see if word is repeated
            if(wordIObj.equals(wIndexter)){   
                //add line number to obj
                //indexObj.setLineNum(counter);//this is manipulating the wrong object
                arrayObj.setLineNum(number);
                done = true;

                //indexObj = indexter.get(counter);//
                //if s1 < s2
            } else if(wordIObj.compareTo(wIndexter) < 0){
                indexter.add(counter, indexObj);
                done = true;
            }
            counter++;//increase counter outside of if else statement
            
            
         }
         //insert last indexObj outside of while loop
        if(counter == indexter.size()) {
                //insert new indexObj into counter spot
                indexter.add(counter, indexObj);
        }
    }
    
    public String capitalize(String line){
        return line.toUpperCase();
    }
     

}