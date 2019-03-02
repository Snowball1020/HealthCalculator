/*this application takes the user's name, age, gender, height, weight, and displays Maximum heart rate, Target heart rate,BMI number
 *and also tell you if you are overweight or not.
 * @Author Yuki Miyazawa
 * @Version 16th.Oct.2018
 */

import java.util.Scanner; // importing Scanner Class

public class NewHealthCalculator {

	static Scanner input = new Scanner(System.in);	// initialize Scanner method as class variable

	static final byte MINIMUM_AGE = 0; // setting minimum age you can type to, as constants
	static final byte MAXIMUM_AGE = 123; // setting maximum age you can type to, as constants

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String userName; // define student name
		byte age; // define student age
		String gender; // define student gender
		float height; // define student height
		float weight; // define student weight
		int maxHeartRate; // define Maximum Heart Rate
		float targetHeartRate1; // define the lowest Target Heart Rate
		float targetHeartRate2; // define the highest Target Heart Rate
		float bmi;// define bmi number

		displayPurpose();// display purpose of this application

		userName = getUserName(); // get user's name
		age = getAge(userName); // get user's age
		gender = getGender(userName); // get user's gender
		height = getHeight(userName); // get user's height
		weight = getWeight(userName); // get user's weight
		maxHeartRate = getMaxHeartRate(age);// get user's maximum heart rate
		targetHeartRate1 = getTargetHeartRate1(maxHeartRate); // get the lowest target heart rate
		targetHeartRate2 = getTargetHeartRate2(maxHeartRate); // get the highest target heart rate
		bmi = getBmi(weight,height); // get bmi number based on user's condition

		displayResult(userName, age, gender, height, weight, maxHeartRate, targetHeartRate1, targetHeartRate2, bmi);
	}// end of main method

	public static void displayPurpose(){ // this method displays the purpose of this application
		System.out.println("*******************************************************************************************************");
		System.out.println("			This application displays your health condition				  ");
		System.out.println("               (Your general information, Maximum / Target Heart Rate , and BMI)    ");
		System.out.println("*******************************************************************************************************");

	}// end of displayPurpose

	public static String getUserName(){ // this method asks user to put their name and return the value
		System.out.println("Please type your name");
		String userName = input.nextLine();
		return userName;
	}// end of getuserName

	public static byte getAge(String userName){ // this method asks user to put their age, and get "String userName" to specify the prompt message
		System.out.printf("Hello %s! please type your age (%d - %d): %n", userName, MINIMUM_AGE, MAXIMUM_AGE );
		byte age = input.nextByte();
		while(age < MINIMUM_AGE || age > MAXIMUM_AGE){
			System.out.printf("Invalid number! %s, please type your age (%d - %d): %n", userName, MINIMUM_AGE, MAXIMUM_AGE );
			age = input.nextByte();
		}
		return age;
	}// end of getAge

	public static String getGender(String userName){// this method asks user to put their gender, and get "String userName" to specify the prompt message
		System.out.printf("%s, please type your gender (type 'M' = male or 'F' = Female): %n", userName);
		String gender = input.next();
		while(gender.equals("M")|| (gender.equals("F"))){
		break;}
		while(!gender.equals("M") && !gender.equals("F")){
			System.out.printf("Invalid word! %s, please type your gender by typing 'M' or 'F': %n", userName);
			gender = input.next();
		}
		return gender;
	}// end of getGender

	public static float getHeight(String userName){// this method asks user to put their height, and get "String userName" to specify the prompt message
		System.out.printf("%s, please type your height (note: type based on inches ex:70.5): %n", userName);
		float height = input.nextFloat();
		return height;
	}// end of getHeight

	public static float getWeight(String userName){// this method asks user to put their weight, and get "String userName" to specify the prompt message
		System.out.printf("%s, please type your weight (note:tyoe based on pounds ex.120.5): %n", userName);
		float weight = input.nextFloat();
		return weight;
	}// end of getWeight


	/* this method displays a whole information and results for you.
	 *
	 */
	public static void displayResult(String userName, byte age, String gender, float height, float weight, int maxHeartRate, float targetHeartRate1,float targetHeartRate2, float bmi){

		System.out.println("--------------------Calculation is done--------------------");
		System.out.println("======================Your Condition=======================");
		System.out.printf("your name                    : %s%n", userName);
		System.out.printf("your age                     : %d%n", age);
		if(gender.equals("M")){
			System.out.println("your gender                  : Male");
		}else if(gender.equals("F")){
			System.out.println("your gender                  : Female");
		}
		System.out.printf("your height                  : %.1f inches %n", height);
		System.out.printf("your weight                  : %.1f pounds %n", weight);
		System.out.println("========================Results============================");
		System.out.printf("your maximum heart rate      : %d times per minutes %n", maxHeartRate);
		System.out.printf("your target heart rate range : %.1f - %.1f times per minutes %n",  targetHeartRate1, targetHeartRate2);
		System.out.printf("your BMI                     : %.1f %n", bmi);

		if(bmi>30){// this if statement differentiate your result based on your condition.
			System.out.println("your weight condition        : Obese");
		}else if(bmi>25.0 && bmi<29.9){
			System.out.println("your weight condition        : Overweight");
		}else if(bmi>18.5 && bmi<24.9){
			System.out.println("your weight condition        : Normal");
		}else if(bmi<18.4){
			System.out.println("your weight condition        : Underweight");
		}
		System.out.println("===========================================================");

	}; //end of displayResult

	public static int getMaxHeartRate(byte age){ // this method calculates maximum heart rate for the user
		int MaxHeartRate = 220 - age;
		return MaxHeartRate;
	}

	public static float getTargetHeartRate1(int maxHeartRate){ // this method calculates the lowest target heart rate for the user
		float targetHeartRate1 = maxHeartRate * 0.5f;
		return targetHeartRate1;
	}

	public static float getTargetHeartRate2(int maxHeartRate){ // this method calculates the highest target heart rate for the user
		float targetHeartRate2 = maxHeartRate * 0.8f;
		return targetHeartRate2;
	}


	public static float getBmi(float weight, float height){ // this method calculates BMI number for the user
		float bmi = (weight/(height*height)) * 730	;
		return bmi;
	}

}
