package Project;

public class Airplane {
	private Person firstPassenger;
	private int deadlineDay;
	private int deadlineMonth;
	private int deadlineYear;
	private double MaxWeight;
	private int MaxSeats;
	private int currentNumberOfSeats;

	public Person getFirstPassenger() {
		return firstPassenger;
	}

	public void setFirstPassenger(Person firstPassenger) {
		this.firstPassenger = firstPassenger;
	}

	public int getDeadlineDay() {
		return deadlineDay;
	}

	public void setDeadlineDay(int deadlineDay) {
		this.deadlineDay = deadlineDay;
	}

	public int getDeadlineMonth() {
		return deadlineMonth;
	}

	public void setDeadlineMonth(int deadlineMonth) {
		this.deadlineMonth = deadlineMonth;
	}

	public int getDeadlineYear() {
		return deadlineYear;
	}

	public void setDeadlineYear(int deadlineYear) {
		this.deadlineYear = deadlineYear;
	}

	public double getMaxWeight() {
		return MaxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		MaxWeight = maxWeight;
	}

	public int getMaxSeats() {
		return MaxSeats;
	}

	public void setMaxSeats(int maxSeats) {
		MaxSeats = maxSeats;
	}

	public int getCurrentNumberOfSeats() {
		return currentNumberOfSeats;
	}

	public void setCurrentNumberOfSeats(int currentNumberOfSeats) {
		this.currentNumberOfSeats = currentNumberOfSeats;
	}

	public Airplane() {

	}

	public boolean isEmpty() {
		if (firstPassenger == null)
			return true;
		return false;
	}

	public boolean checkIfOnTime(Person P) {
		if (P.getDayRegistered() <= deadlineDay && P.getMonthRegistered() <= deadlineMonth
				&& P.getYearRegistered() <= deadlineYear)
			return true;
		return false;
	}

	public boolean checkIfEnoughSeats() {
		if (currentNumberOfSeats < MaxSeats)
			return true;
		return false;
	}

	public boolean checkWeight(Person P) {
		if (P.LuggageWeight() < MaxWeight)
			return true;
		return false;
	}

	public boolean CanGetOnPlane(Person P) {
		if (checkIfOnTime(P) && checkIfEnoughSeats() && checkWeight(P) && P.inGoodHealth() && P.isRightToTravel()
				&& P.securityScreening())
			return true;
		return false;
	}

	public boolean checkIfP1lessThanP2(Person P1, Person P2) {
		if (P1.getYearRegistered() < P2.getYearRegistered())
			return true;
		else if (P1.getYearRegistered() > P2.getYearRegistered())
			return false;
		else {
			if (P1.getMonthRegistered() < P2.getMonthRegistered())
				return true;
			else if (P1.getMonthRegistered() > P2.getMonthRegistered())
				return false;
			else {
				if (P1.getDayRegistered() < P2.getDayRegistered())
					return true;
				else if (P1.getDayRegistered() > P2.getDayRegistered())
					return false;
				else
					return true;
			}
		}
	}

	public boolean addToAirplane(Person P) {
		if (CanGetOnPlane(P)) {
			if (firstPassenger == null) {
				firstPassenger = P;
				currentNumberOfSeats++;
				return true;
			}	
			Person temp = firstPassenger;
			while (true) {
				if (checkIfP1lessThanP2(P, temp)) {
					if (temp.getRight() == null) {
						temp.setRight(P);
						currentNumberOfSeats++;
						System.out.println(""+P.getName()+" got on the plane");
						return true;
					} else {
						temp = temp.getRight();
					}
					
				} else {
					if (temp.getLeft() == null) {
						temp.setLeft(P);
						currentNumberOfSeats++;
						System.out.println(""+P.getName()+" got on the plane");
						return true;
					}
					temp = temp.getLeft();
				}
			}
			
		} else {
			System.out.println(P.getName()+" can't get on the airplane because:");
			if(this.currentNumberOfSeats==this.MaxSeats)
				System.out.println("This section is full");
				if(!this.checkIfOnTime(P))
					System.out.println("This person was late to register");
				if(!P.isRightToTravel())
					System.out.println("This person doesn't have the right to travel");
				if(!P.securityScreening())
					System.out.println("This person got caught in the security line with a banned thing or he/she didn't get checked in the security line");
				if(!P.inGoodHealth())
					System.out.println("The person's health doesn't permit to get on the plane");
			return false;
		}
	}


	public int height(Person P) {
		if (P == null)
			return 0;
		else
			return 1 + Math.max(height(P.getLeft()), height(P.getRight()));
	}

	public int getheight() {
		return height(firstPassenger);
	}

	public void displayAsBST() {
		displayAsBST(firstPassenger, 0);
	}

	public void displayAsBST(Person P, int level) {
		if (P != null) {
			displayAsBST(P.getRight(), level + 1);
			for (int i = 0; i < level; i++)
				System.out.print("\t");
			System.out.println("Name: " + P.getName() + "-- Age: " + P.getAge());
			displayAsBST(P.getLeft(), level + 1);
		}
	}

	public int countPassengers() {
		return countPassengers(firstPassenger);
	}

	public int countPassengers(Person P) {
		if (P == null)
			return 0;
		else
			return 1 + countPassengers(P.getLeft()) + countPassengers(P.getRight());
	}

	public void displayOldPassengers() {
		displayOldPassengers(firstPassenger, 0);
	}

	public void displayOldPassengers(Person P, int level) {
		if (P != null) {
			displayOldPassengers(P.getRight(), level + 1);
			if (P.getAge() > 70) {
				P.display();
				System.out.println();
			}
			displayOldPassengers(P.getLeft(), level + 1);
		}
	}


	public void displayPassengers() {
		displayPassengers(firstPassenger, 0);
	}

	public void displayPassengers(Person P, int level) {
		if (P != null) {
			displayPassengers(P.getRight(), level + 1);
			P.display();
			System.out.println();
			displayPassengers(P.getLeft(), level + 1);
		}
	}

	public boolean search(Person P) {
		if (firstPassenger == null)
			return false;
		else {
			Person temp = firstPassenger;
			while (true) {
				if (P.equals(temp))
					return true;
				else if (checkIfP1lessThanP2(P, temp)) {
					if (temp.getRight() == null) {

						System.out.println("The passenger is not found on the airplane");
						return false;
					} else
						temp = temp.getRight();
				} else {
					if (temp.getLeft() == null) {

						System.out.println("The person is not found on the airplane");
						return false;
					} else
						temp = temp.getLeft();
				}
			}
		}
	}

	public void removePerson(Person P) {
		Person temp = firstPassenger;
		Person parent = firstPassenger;
		boolean flag = false;
		while (!temp.equals(P)) {
			parent = temp;
			if (checkIfP1lessThanP2(P, parent)) {
				temp = temp.getRight();
				flag = true;
			} else {
				temp = temp.getLeft();
				flag = false;
			}
			if (temp == null) {
				return;
			}
		}
		if (temp.getLeft() == null && temp.getRight() == null) {
			if (temp.equals(firstPassenger))
				firstPassenger = null;
			else if (flag) {
				parent.setRight(null);
			} else {
				parent.setLeft(null);
			}
			currentNumberOfSeats--;
		} else if (!temp.getLeft().equals(null) && temp.getRight().equals(null)) {
			if (temp.equals(firstPassenger))
				firstPassenger = temp.getLeft();
			if (flag == false)
				parent.setLeft(temp.getLeft());
			else
				parent.setRight(temp.getLeft());
			currentNumberOfSeats--;
		} else if (temp.getLeft().equals(null) && !temp.getRight().equals(null)) {
			if (temp.equals(firstPassenger))
				firstPassenger = temp.getRight();
			if (flag == false)
				parent.setLeft(temp.getRight());
			else
				parent.setRight(temp.getRight());
			currentNumberOfSeats--;
		} else if (!temp.getLeft().equals(null) && !temp.getRight().equals(null)) {
			Person minParent = temp;
			Person minNode = temp.getRight();
			while (minNode.getLeft() != null) {
				minParent = minNode;
				minNode = minNode.getLeft();
			}
			if (minParent != temp) {
				minParent.setLeft(minNode.getRight());
			} else {
				temp.setRight(minNode.getRight());
			}
			minNode.setLeft(temp.getLeft());
			minNode.setRight(temp.getRight());
			if (parent == null)
				firstPassenger = minNode;
			else {
				if (flag)
					parent.setRight(minNode);
				else
					parent.setLeft(minNode);
			}
			currentNumberOfSeats--;
		}

	}

	public Person minValue(Person currentNode) {
		while (currentNode.getLeft() != null) {
			currentNode = currentNode.getLeft();
		}
		return currentNode;
	}
	public Person maxValue(Person currentNode) {
		while (currentNode.getRight() != null) {
			currentNode = currentNode.getRight();
		}
		return currentNode;
	}
}
