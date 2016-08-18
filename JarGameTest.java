package uitl.com;

import java.text.ParseException;
import java.util.Scanner;

public class JarGameTest {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Game game=new Game();
	
		boolean test=false;
		
		System.out.println("ADMINISTRATOR SETUP\n  ================");
		//loop to repeat the game
		inner :do{
			      test=false;
			      String number=null;
		          System.out.println("Name of Items in the Jar: ");
	        	  String str=input.nextLine();
		//try catch to control name of item and number max
		        try {
			        game.setMItem(str);
			        System.out.printf("Maximum number of %s that the Jar can Containst\n",game.getMItem());
		//boolean to help repeat the try catch
		
			        boolean tes=false;
	    //loop build for the try;
			            do{
				           try {
					         number=input.nextLine();
					         game.setNb_max(number);
				         	 tes=!tes;
					
				             } catch (IllegalArgumentException | ParseException e) {
				         	 System.err.println(e.getMessage());
					         continue ;
				             }
			              }while(!tes);
			
			
			       System.out.println("PLAYER\n==================");
			       game.fillJar();
				   game.startGame();
			     } catch (IsNotLetterArgument e) {
				  System.err.println(e.getMessage());
				  test=!test;
			     }
		
	            if(test) continue inner;
		        char resp;
	             do{
	         	    String in;
			        System.out.println("Do you want to Replay? Press Y(Yes)/N(No)");
			        in=input.nextLine();
			        resp= in.length()>0?in.toUpperCase().charAt(0):'a';
	              }while(resp!='Y'&& resp!='N');
	             
	      if (resp=='N') System.out.println("GOOD BYE!!!!");else test=!test;     
		}while(test);
			
					
		
		input.close();
	}

}
