package uitl.com;

import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private int numberInTheJar;
	private int numberOfGuess;
	private long timeElapse;
	private  String mItem;
	private  int mNb_max;
	Scanner input = new Scanner(System.in);
	
	public  void setMItem( String str) throws IsNotLetterArgument {
		
	for(char chr:str.toCharArray())
			if (!Character.isLetter(chr)) throw new IsNotLetterArgument("ERROR! Please enter a String of Letter please");
		  
	if(str.length()<=0)throw new IsNotLetterArgument("ERROR! Please enter a String of Letter please");
		
		 mItem=str;
		 }
	
	public String  getMItem(){
		return mItem;
	}
	

	    
	  public void setNb_max(String str) throws ParseException,IllegalArgumentException{
		  try{
			  int nbmax=Integer.parseInt(str);
			  if(nbmax<=0) throw new IllegalArgumentException(String.format("ERROR! the Jar must containe at least One %s ",mItem));
			  mNb_max=nbmax;
		      }catch(NumberFormatException e){
			  throw new ParseException("ERROR! Please Enter a Number\n",29);
		      }
	  }
	  
	   
	  public int getNb_max(){
		  return mNb_max ;
	  }
	  
	
  //filling the Jar with Random number between 1 and maximum number that the Jar can contain
	public void fillJar(){
		Random random = new Random();
		numberInTheJar = random.nextInt(mNb_max)+1;
	}
	//Time that the the Guess Start
	private  long timeStart(){
	return System.currentTimeMillis();
	}
	//Time that the guess End 
	private long timeEnd(){
		return System.currentTimeMillis();
	}
	

	
	
	
	

	
	//guesses 	
	public void startGame() {
		System.out.printf("your Goal is to guess how many %s are in the Jar\nYour guess should be between 1 and %d\n\n",
				mItem,mNb_max);
		System.out.println("Ready?");
		System.out.printf("Press Enter to Start Guessing)");
		input.nextLine();
		
		int nbGuess =0;
		numberOfGuess=0;
		boolean tre=true;
		long start=timeStart();
		
        do {
        	 try{
        		 System.out.printf("\nguess:");
			     nbGuess = Integer.parseInt(input.nextLine());
        	
		     	if (nbGuess<numberInTheJar) System.out.println("your guess is too low");
		    	if (nbGuess>numberInTheJar) System.out.println("your guess is too high");
		   	    numberOfGuess++;
			    if(nbGuess == numberInTheJar) tre=!tre;
        	
        	    }catch (NumberFormatException e){
         		System.err.println("ERROR please enter a Digit");
         		}
        	 
          } while (tre);
		  long end =timeEnd();
		  timeElapse = (end - start)/1000;
		  
	      System.out.printf("Congratulation! - You guessed that there are %d %s in the Jar!\n"
			+ " It took you %d guess (es) to get it Right and %d Seconds to Play the Game.\n\n"
			,nbGuess,mItem,numberOfGuess,timeElapse);
	
	
		
		
	}

	
		
		
	}
	

