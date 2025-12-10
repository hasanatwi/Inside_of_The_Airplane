package Project;

public class Person {
	private String name;
	private int age;
	private Person left;
	private Person right;
	private Person next;
	private int dayRegistered;
	private int monthRegistered;
	private int yearRegistered;
	private boolean rightToTravel;
	private boolean securityScreening;
	private double luggageWeight;
	private boolean checkIfDisabled;
	private boolean isBusiness;
	private int minimumPay;
	private boolean extraPay;
	private boolean military;
	private boolean inGoodHealth;
	
	
	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public Person getNextPerson() {
		return next;
	}

	public void setNextPerson(Person P) {
		next = P;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setInGoodHealth(boolean value) {
		this.inGoodHealth = value;
	}

	public void setLeft(Person left) {
		this.left = left;
	}

	public void setRight(Person right) {
		this.right = right;
	}

	public void setDayRegistered(int dayRegistered) {
		this.dayRegistered = dayRegistered;
	}

	public void setMonthRegistered(int monthRegistered) {
		this.monthRegistered = monthRegistered;
	}

	public void setYearRegistered(int yearRegistered) {
		this.yearRegistered = yearRegistered;
	}

	public void setRightToTravel(boolean rightToTravel) {
		this.rightToTravel = rightToTravel;
	}

	public void setSecurityScreening(boolean securityScreening) {
		this.securityScreening = securityScreening;
	}

	public void setLuggageWeight(double luggageWeight) {
		this.luggageWeight = luggageWeight;
	}

	public void setCheckIfDisabled(boolean checkIfDisabled) {
		this.checkIfDisabled = checkIfDisabled;
	}

	public void setPersonClass(int N) {
		if(N==1)
		this.isBusiness = true;
		else
			this.isBusiness = false;
	}

	public void setMinimumPay(int minimumPay) {
		this.minimumPay = minimumPay;
	}

	public void setExtraPay(boolean extraPay) {
		this.extraPay = extraPay;
	}

	public void setMilitary(boolean military) {
		this.military = military;
	}

	public boolean inGoodHealth() {
		return inGoodHealth;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Person getLeft() {
		return left;
	}

	public Person getRight() {
		return right;
	}

	public int getDayRegistered() {
		return dayRegistered;
	}

	public int getMonthRegistered() {
		return monthRegistered;
	}

	public int getYearRegistered() {
		return yearRegistered;
	}

	public boolean isRightToTravel() {
		return rightToTravel;
	}

	public boolean securityScreening() {
		return securityScreening;
	}

	public double LuggageWeight() {
		return luggageWeight;
	}

	public boolean CheckIfDisabled() {
		return checkIfDisabled;
	}

	public boolean getBusinessClass() {
		return isBusiness;
	}

	public int getMinimumPay() {
		return minimumPay;
	}

	public boolean isExtraPay() {
		return extraPay;
	}

	public boolean isMilitary() {
		return military;
	}

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Registered Date: " + dayRegistered + "/" + monthRegistered + "/" + yearRegistered);
		System.out.println("Right to Travel: " + rightToTravel);
		System.out.println("Security Checked?: " + securityScreening);
		System.out.println("Luggage Weight: " + luggageWeight);
		System.out.println("Is he/she disabled? " + checkIfDisabled);
		System.out.println("Business Class: " + isBusiness);
		System.out.println("Minimum Pay: " + minimumPay);
		System.out.println("Did he/she pay extra?: " + extraPay);
		System.out.println("Military: " + military);
	}
}
