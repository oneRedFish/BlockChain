import java.util.*;

public class BlockChain {
	private Block head = new Block (); // start the chain with the Genesis block
	private Block tail = head;
	private String courseName = "NotEntered";
	
	public BlockChain ( String courseName) {
		this.courseName = new String (courseName);
	}
	
	public void printBlockChain() {
		Block temp = head;
		while(temp!=null) {
			System.out.println(courseName+"\n"+temp);
			temp = temp.next();
		}
		
	}
	
	public boolean verifyChain() {
		Block temp = head;
		boolean state = true;
		while(temp!=null && temp.next()!=null) {
			if(temp.next().isEqual(temp))
			{
				state = true;
			}
			else {
				state = false;
			}
			temp = temp.next();
		}
		return state;
	}
	
	public void addBlock(Scanner keyboard) {
		Block newOne = new Block();
		if(newOne.addInfoToBlock(keyboard, tail.getCurrentHash())) {
			tail.updateNext(newOne);
			tail = newOne;
		}
	}
	
	public void addBadBlock(Scanner keyboard) {
		Random random = new Random();
		Block newOne = new Block();
		if (newOne.addInfoToBlock(keyboard, random.nextFloat())){
			// add to chain at tail
			tail.updateNext(newOne);
			tail = newOne;	
		}
		
	}
	
	

}
