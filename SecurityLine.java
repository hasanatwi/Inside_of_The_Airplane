package Project;

import java.util.Random;

public class SecurityLine extends LinkedList {
	Random random = new Random();
	private int max;

	public SecurityLine() {
		super();
	}

	public void setMax(int max) {
		this.max = max;
	}

	public void insertAtBack(Person P) {
		System.out.println(P.getName()+" joined the security line");
		super.append(P);
	}

	public Person removeFromFront() {
		Random random = new Random();
		int randomNumber = random.nextInt(10);
		int threshold = 9;
		boolean result = randomNumber < threshold;
		if (result)
			System.out.println(super.getHead().getName()+" has passed the security test");
		else
			System.out.println(super.getHead().getName()+" has not passed the security test");
		super.getHead().setSecurityScreening(result);
		return super.removeFirst();
	}

	public void removeKPerson(int K) {
		super.remove(K);
	}

	public Person getFirst() {
		return super.getHead();
	}

	public Person getLast() {
		return super.getTail();
	}

	public int getLength() {
		return super.getLength();
	}

	public int getMax() {
		return max;
	}

	public void printSecurityLine() {
		if (!this.isEmpty()) {
			Person current = this.getFirst();
			while (current.getNextPerson() != null) {
				System.out.print(current.getName() + " (Age: " + current.getAge() + ") <--- ");
				current = current.getNextPerson();
			}
			System.out.print(current.getName() + " (Age: " + current.getAge() + ")");
		} else
			System.out.println("The security line is empty");
	}

	public boolean isEmpty() {
		return super.length == 0;
	}

	public void clearSecurityLine() {
		super.head = null;
		super.head = null;
		length = 0;
	}
}
