package Project;

public class LinkedList {
	protected Person head;
	protected Person tail;
	protected int length;

	public LinkedList() {

	}

	public Person getHead() {
		return head;
	}

	public Person getTail() {
		return tail;
	}

	public int getLength() {
		return length;
	}
	public void append(Person P)
    {
        if(length==0)
        {
            head=P;
            tail=P;
        }
        else
        {
            tail.setNextPerson(P);
            tail=P;
        }
        length++;
    }
	public void prepend(Person newPerson) {
		if (length == 0) {
			head = newPerson;
			tail = newPerson;
		} else {
			newPerson.setNextPerson(head);
			head = newPerson;
		}
		length++;
	}

	public Person removeLast() {
		Person temp = head;
		Person pre = head;
		if (length == 0)
			return null;
		else {
			while (temp.getNextPerson() != null) {
				pre = temp;
				temp.setNextPerson(temp.getNextPerson());
			}
			tail = pre;
			temp.setNextPerson(null);
			length--;
			if (length == 0) {
				head = null;
				tail = null;
			}
			return temp;
		}
	}

	public Person get(int index) {
		if (index < 0 || index >= length)
			return null;
		Person temp = head;
		for (int i = 0; i < index; i++) {
			temp=(temp.getNextPerson());
		}
		return temp;
	}

	public Person remove(int index) {
		index--;
		if (index < 0 || index >= length)
			return null;
		if (index == 0)
			return removeFirst();
		else if (index == length - 1)
			return removeLast();
		else {
			Person pre = get(index - 1);
			Person temp = pre.getNextPerson();
			pre.setNextPerson(temp.getNextPerson());
			length--;
			return temp;
		}
	}

	public Person removeFirst() {
		Person temp=head;
		if (length == 0)
			System.out.println("The line is empty");
		else
			if(length==1)
			{
				head=null;
				tail=null;
			}
		else {
			head=head.getNextPerson();
			length--;
		}
			return temp;
}
}
