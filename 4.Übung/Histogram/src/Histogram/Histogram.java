package Histogram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Histogram {

    private int[] charFrequencies;
    private int line;
    private int position;
    private FileReader reader;
    private BufferedReader textReader;
    private int numberOfLines;
    private int numberOfCharactersInLine;
    
    public static void main(String[] args)throws IOException{
    	Histogram histogram = new Histogram(args[0]);
    	histogram.goThroughChars();
        String text = histogram.printOutFrequencies();
        PrintWriter file = histogram.createTextFile(args[1]);
        file.println(text);
        file.close();
    }
    
    public Histogram(String filePath)throws IOException{
        try{
            charFrequencies = new int[26];         
            reader = new FileReader(filePath);
            textReader = new BufferedReader(reader);
            }catch(Exception e){
                e.printStackTrace();
            }
        
        
    }
    
    public int determineNumberOfCharactersInLine( int lineNr)throws IOException{
        try{
            numberOfCharactersInLine = 0;
            for(int i = 0; i<numberOfLines; i++){                   
                if(i==lineNr){ 
                    int character = textReader.read();
                    while((character != 13)&&(character != -1)){                        
                        character = textReader.read();
                        numberOfCharactersInLine++;
                    }
                }
                textReader.readLine();
            }           
        }catch(Exception e){
            e.printStackTrace();
        }
        return numberOfCharactersInLine;
    }
    
    public int determineNumberOfLinesInFile()throws IOException{
        try{            
            numberOfLines = 0;      
            while(textReader.readLine() != null){
                numberOfLines++;
            }           
        }catch(Exception e){
            e.printStackTrace();
        }
        return numberOfLines;
    }
    
    public int returnCharacter()throws IOException{        
        int charNumber = -1;        
        try{          
            for(int i=0; i<numberOfLines; i++){
                String currentLine = textReader.readLine();
                if(i == line){
                    if(currentLine != "")
                        charNumber = (int)currentLine.charAt(position); 
                    else{}    
                }            
            }           
        }catch(Exception e){
            e.printStackTrace();
        }
        return charNumber;
    }
    
    public PrintWriter createTextFile(String filename)throws IOException{
        PrintWriter newFile = null;
        try{
            newFile = new PrintWriter(filename /*"frequency"*/ +".txt");
        }catch(Exception e){            
            e.printStackTrace();
        }
        return newFile;
    }   
    
    
    public void writeIntIntoFile(int number, PrintWriter file){
        file.println(number);
    }   
    
    
    public void goThroughChars()throws IOException{
        try{
            textReader.mark(1500);
            line = 0;
            position = 0;
            determineNumberOfLinesInFile();
            for(int i=0; i<numberOfLines;i++){
                textReader.reset();
                position = 0;
                determineNumberOfCharactersInLine(i);
                for(int d=0;d<numberOfCharactersInLine;d++){
                    textReader.reset();
                    int currentChar = returnCharacter();                    
                    position++;
                    enterIntoArray(currentChar);
                    
                }
                line++;
            }
            }catch(Exception e){
                e.printStackTrace();
            }
    }
    
    public void enterIntoArray(int currentChar){
        if((currentChar < 91)&&(currentChar > 64))
            charFrequencies[currentChar-65]++;
        else if((currentChar > 96)&&(currentChar < 126)) 
            charFrequencies[currentChar-97]++;
        else{}    
    }
    
    public String printOutFrequencies(){
        String histogram = "";
        for(int i= 0; i<charFrequencies.length; i++){
            histogram = histogram + (char)(i+65) +" : ";
            String xes = "";
            for(int d = 0; d<charFrequencies[i];d++){
                xes = xes + "x";
            }
            histogram = histogram + xes + "\n";
        }
        return histogram;
    }
}
