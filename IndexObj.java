/*
* Renee Veit
* 2/6/18
* Mr. Maroney
* Period 4
*/
public class IndexObj
{

 public int lineNumbers[];//including spaces
 public String word;
 public int numLines;//field to keep track of line numbers

 public IndexObj(String word, int lineNum){
 lineNumbers = new int[16];//16
 //changed line nums --> 80, got addresses
 this.word = word;
 //
 numLines = lineNum;
 lineNumbers[0] = lineNum;//nullpointerexception
 }

 public String getWord(){
 return word;
 }

 public int getLineNum(){
 return numLines;
 }
 //this method is never used
 public void setLineNum(int numOfLine){
 //am I returning anything? (should it be void)
 //each element in the lineNumbers array corresponds to
 //one individual word

 lineNumbers[numLines] = numOfLine;//JAVA ARRAYINDEXOUTOFBOUNDS 16
 numLines++;
 }

 public String toString(){
 //make sure you're printing an IndexObj obj
 /*print 1st # w/o comma
 * then print rest with
 * comma in loop
 */

 String str = "";
 int eachNum = 0;
 str+= word + ":";
 str += " " + lineNumbers[0];
 for(int i = 1; i < lineNumbers.length; i++){
 eachNum = lineNumbers[i];
 if(eachNum != 0)
 str += "," + eachNum ;
 //how to get each individual #
 //and separate it with a comma

 }


 //this is wrong, you need a for loop
 return str;
 }

}