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
		System.out.println(courseName);
		while(temp!=null) {
			System.out.print(temp+"\n");
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
				break;
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
		
	public void deleteBlock() {
		Block temp = head;
		while(temp!=null && temp.next()!=null) {
			if(!temp.next().isEqual(temp)) {
				//bad is last
				if(temp.next().next()==null) {
					temp.updateNext(null);
				}
				else{
					updateBlock(temp);
				}
			}
			temp = temp.next();
		}

	}
	
	public void updateBlock(Block temp) {
		//next next is a good one
		if(temp.next().next().isEqual(temp.next())) {
			temp.next().next().setPreviousHash(temp.getCurrentHash());
			temp.updateNext(temp.next().next());
		}else {
			temp.updateNext(null);
		}
	}
}
