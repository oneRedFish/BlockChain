import java.util.*;

public class Block {
	private int date;  // part of data - in month day year format  (eg) 2152018
	private int studentNumber; // part of data
	private int grade;  // part of data
	private float previousHash;
	private float currentHash;
	private Block nextOne;
	
	public Block() {
		// create the Genesis block
		date = 2152018;
		studentNumber = 0;
		grade = 100;
		previousHash = 0f;
		currentHash = calculateHash();
		nextOne = null;
		
	}
	
	public float calculateHash() {
		return (date+studentNumber+grade)/88;
	}
	
	public String toString() {
		return "" + studentNumber + " " + grade + " " + date +  " current: " + currentHash + " previous: " + previousHash ;
	}
	
	public Block next() {
		return nextOne;
	}
	public float getCurrentHash() {
		return currentHash;
	}
	public float getPreviousHash() {
		return previousHash;
	}
	public void setPreviousHash(float previousHash) {
		this.previousHash = previousHash;
	}
	public boolean isEqual (Block temp) {
		return (previousHash == temp.currentHash);
	}
	public void updateNext(Block newOne) {
		nextOne = newOne;
	}
	
	public boolean addInfoToBlock(Scanner keyboard, float previousHash) {
		System.out.print ("Enter date: ");
		while (!keyboard.hasNextInt())  {
			System.out.print ("Invalid...enter an int for date: ");
			keyboard.next();
		}
		date = keyboard.nextInt();
		
		
		System.out.print ("Enter student number: ");
		while (!keyboard.hasNextInt())  {
			System.out.print ("Invalid...enter an int for student number: ");
			keyboard.next();
		}
		studentNumber = keyboard.nextInt();
		
		
		System.out.println ("Enter grade: ");
		while (!keyboard.hasNextInt())  {
			System.out.print ("Invalid...enter an int for grade: ");
			keyboard.next();
		}
		grade = keyboard.nextInt();
		
		currentHash = calculateHash();
		this.previousHash = previousHash;
		return true;
	}
	
}
