import java.util.*;
import java.io.*;


class Phone implements Serializable {
	
	String first;
	String last;
	String number;
	
	Phone(String first,String last,String number) {
		this.first = first;
		this.last = last;
		this.number = number;
	}
	
	public String toString() {
		return first+" "+last+" "+number;
	}
}

class PhoneBook {
	

                Scanner s = new Scanner(System.in);
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
                File file = new File("Record.txt");
		File log = new File("Log.txt");
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		ListIterator li = null;
                Stack<String> st = new Stack<String>(); // used to show recent call


	public static boolean isNumeric(String string) {
		
	/*double intValue;
		String.format("Parsing string: \"%s\"", string);
		if(string == null || string.equals("")) {
			System.out.println("null input.");
			return false;
		}
		try {
			intValue = Integer.parseInt(string);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Input String is not numeric.");
		}
		return false;*/return true;
        
	}

        public void addcontact(ArrayList<Phone> pb)throws Exception
       {

          	System.out.println("How many numbers you want to add");
					int n = s.nextInt();
					for(int i=0;i<n;i++) {
						System.out.print("Enter first name:");
						String first = s1.next();
				
						System.out.print("Enter last name:");
						String last = s1.next();
					
						System.out.print("Enter number:");
						String number = s1.next();
						
					/*	while(!isNumeric(number)) {
							System.out.println();
							System.out.print("Enter number again: ");
							number = s1.next();
						}*/
						
						pb.add(new Phone(first,last,number));
					}
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(pb);
					oos.close();
        }
	
           public void display(ArrayList<Phone> pb)throws Exception
 {
if(file.isFile()) { 
					// if the file is available we will read it and save it in arraylist
						ois = new ObjectInputStream(new FileInputStream(file));
						pb = (ArrayList<Phone>)ois.readObject(); // casting to arraylsit
						ois.close();
						
						System.out.println("..............................");
						li = pb.listIterator();
						while(li.hasNext()) {
							System.out.println(li.next());
						}
						System.out.println("..............................");
					}else {
						System.out.println("File not exist..");
					}
 }

public void search(ArrayList<Phone> pb)throws Exception
{

					System.out.println("1.SEARCH BY NUMBER.");
					System.out.println("2.SEARCH BY NAME.");
					System.out.print("ENTER YOUR CHOICE:");
					int flag = s.nextInt();
					switch(flag) {
						case 1: // search by number
							String number = "";
							// to search we need to write the data from file to colloction
							if(file.isFile()) {
								if(file.isFile()) { 
								// check if file is avaiavle so we read it to array list
								ois = new ObjectInputStream(new FileInputStream(file));
								pb = (ArrayList<Phone>)ois.readObject(); // cast to arraylsit
								ois.close();
								}
								
								boolean found = false;
								System.out.println("Enter phone number to search");
								number = s1.next();
								
								while(!isNumeric(number)) {
									System.out.println();
									System.out.print("Enter number again: ");
									number = s1.next();
								}	
								
								System.out.println("..............................");
								li = pb.listIterator();
								while(li.hasNext()) {
									Phone p = (Phone)li.next();
									if(p.number.equals(number)) {
										System.out.println(p);
										found = true;
									}
								}
								if(!found) {
									System.out.println("Record not found...");
								}
								System.out.println("..............................");
							} else {
								System.out.println("File not exist..");
							}
						break;
						case 2: // search by name
							String fname = "";
							// to search we need to write the data from file to colloction
							if(file.isFile()) {
								if(file.isFile()) { 
								// check if file is avaiavle so we read it to array list
								ois = new ObjectInputStream(new FileInputStream(file));
								pb = (ArrayList<Phone>)ois.readObject(); // cast to arraylsit
								ois.close();
								}
								
								boolean foundf = false;
								System.out.println("Enter name to search");
								fname = s1.next();
								System.out.println("..............................");
								li = pb.listIterator();
								while(li.hasNext()) {
									Phone p = (Phone)li.next();
									if(p.first.equals(fname)) {
										System.out.println(p);
										foundf = true;
									}
								}
								if(!foundf) {
									System.out.println("Record not found...");
								}
								System.out.println("..............................");
							} else {
								System.out.println("File not exist..");
							}
						break;
					}
}

 public void delete(ArrayList<Phone> pb)throws Exception
{

					String numbers = "";
					// to search we need to write the data from file to colloction
					if(file.isFile()) {
						if(file.isFile()) { 
						// check if file is avaiavle so we read it to array list
						ois = new ObjectInputStream(new FileInputStream(file));
						pb = (ArrayList<Phone>)ois.readObject(); // cast to arraylsit
						ois.close();
						}
						
						boolean found = false;
						System.out.println("Enter phone number to delete");
						numbers = s1.next();
						
						while(!isNumeric(numbers)) {
							System.out.println();
							System.out.print("Enter number again: ");
							numbers = s1.next();
						}
						
						System.out.println("..............................");
						li = pb.listIterator();
						while(li.hasNext()) {
							Phone p = (Phone)li.next();
							if(p.number.equals(numbers)) {
								li.remove();
								found = true;
							}
						}
						if(found) { 
						// delete from linked list and update your file
							// update out file
							oos = new ObjectOutputStream(new FileOutputStream(file));
							oos.writeObject(pb);
							oos.close();
							System.out.println("Deleted succesfully>>");
						} else {
							System.out.println("Record not found...");
						}
						System.out.println("..............................");
					} else {
						System.out.println("File not exist..");
					}

}

public void modify(ArrayList<Phone> pb)throws Exception
{
String numberp = "";
					// to search we need to write the data from file to colloction
					if(file.isFile()) {
						if(file.isFile()) { 
						// check if file is avaiavle so we read it to array list
						ois = new ObjectInputStream(new FileInputStream(file));
						pb = (ArrayList<Phone>)ois.readObject(); // cast to arraylsit
						ois.close();
						}
						
						boolean found = false;
						System.out.println("Enter phone number to update");
						numberp = s1.next();
						while(!isNumeric(numberp)) {
							System.out.println();
							System.out.print("Enter number again: ");
							numberp = s1.next();
						}
						System.out.println("..............................");
						li = pb.listIterator();
						while(li.hasNext()) {
							Phone p = (Phone)li.next();
							if(p.number.equals(numberp)) {
								System.out.print("Enter new first name: ");
								String fst = s2.nextLine();
								System.out.print("Enter new last name: ");
								String lst = s2.nextLine();
								System.out.print("Enter new number: ");
								String num = s2.nextLine();
								while(!isNumeric(num)) {
									System.out.println();
									System.out.print("Enter number again: ");
									num = s1.next();
								}
								li.set(new Phone(fst,lst,num));
								found = true;
							}
						}
						if(found) { 
						// delete from linked list and update your file
							// update out file
							oos = new ObjectOutputStream(new FileOutputStream(file));
							oos.writeObject(pb);
							oos.close();
							System.out.println("updated succesfully>>");
						} else {
							System.out.println("Record not found...");
						}
						System.out.println("..............................");
					} else {
						System.out.println("File not exist..");
					}


}

public void sortAscending(ArrayList<Phone> pb)throws Exception
{
if(file.isFile()) { 
					// check if file is avaiavle so we read it to array list and print it
						ois = new ObjectInputStream(new FileInputStream(file));
						pb = (ArrayList<Phone>)ois.readObject(); // cast to arraylsit
						ois.close();
						Collections.sort(pb, new Comparator<Phone>() { 
						// sort on file
							// on which bases we will sort
							public int compare(Phone p1,Phone p2) {
								return p1.first.compareTo(p2.first);
							}
						});
						// writing the changes on the file
						oos = new ObjectOutputStream(new FileOutputStream(file));
						oos.writeObject(pb);
						oos.close();
						
						System.out.println("..............................");
						li = pb.listIterator();
						while(li.hasNext()) {
							System.out.println(li.next());
						}
						System.out.println("..............................");
					}else {
						System.out.println("File not exist..");
					}

}
public void sortDescending(ArrayList<Phone> pb)throws Exception
{
if(file.isFile()) { 
					// check if file is avaiavle so we read it to array list and print it
						ois = new ObjectInputStream(new FileInputStream(file));
						pb= (ArrayList<Phone>)ois.readObject(); // cast to arraylsit
						ois.close();
						Collections.sort(pb, new Comparator<Phone>() {
							// on which bases we will sort
							public int compare(Phone p1,Phone p2) {
								return p2.first.compareTo(p1.first);
							}
						});
						// writing the changes on the file
						oos = new ObjectOutputStream(new FileOutputStream(file));
						oos.writeObject(pb);
						oos.close();
						
						System.out.println("..............................");
						li = pb.listIterator();
						while(li.hasNext()) {
							System.out.println(li.next());
						}
						System.out.println("..............................");
					}else {
						System.out.println("File not exist..");
					}
}

public void recentcall(ArrayList<Phone> pb)throws Exception
{

if(log.isFile()) {
						
						if(file.isFile()) { 
						// check if file is avaiavle so we read it to the stack
						ois = new ObjectInputStream(new FileInputStream(log));
						st = (Stack<String>)ois.readObject(); // cast to Stack
						ois.close();
						}
						
						if(st.empty()) {
							System.err.println("Stack Empty....!");
						}
                                                while(!st.empty())
						{System.out.println("last number you have called is: "+st.pop());
						System.out.println();}
					}
					else {
						System.out.println("File not exist..");
					}
}
public void tocall(ArrayList<Phone> pb)throws Exception
{
String numberc = "";
					// if the number exist in our record it will show otherwise we will call directly
					if(file.isFile()) {
						if(file.isFile()) { 
						// check if file is avaiavle so we read it to array list
						ois = new ObjectInputStream(new FileInputStream(file));
						pb = (ArrayList<Phone>)ois.readObject(); // cast to arraylsit
						ois.close();
						}
						
						boolean found = false;
						System.out.println("Enter phone number to call");
						numberc = s1.next();
						while(!isNumeric(numberc)) {
							System.out.println();
							System.out.print("Enter number again: ");
							numberc = s1.next();
						}
						System.out.println("..............................");
						li = pb.listIterator();
						while(li.hasNext()) {
							Phone p = (Phone)li.next();
							if(p.number.equals(numberc)) {
								System.out.println(">>> CALLING......... <<<");
								System.out.println(p);
								st.add(numberc);
								found = true;
							}
						}
						if(!found) {
							System.out.println("Number is not exist in our record...");
							System.out.println(">>> CALLING......... <<<");
							st.add(numberc);
						}
						System.out.println("..............................");
						
						oos = new ObjectOutputStream(new FileOutputStream(log));
						oos.writeObject(st);
						oos.close();
						
					} else {
						System.out.println("File not exist..");
					}

}
	public static void main(String args[]) throws Exception {
		
               PhoneBook pd=new PhoneBook();
               boolean runMenu = false;
		int choice = -1;
		Scanner s = new Scanner(System.in);
		ArrayList<Phone> book = new ArrayList<Phone>(); // to save names and number
		File file = new File("Record.txt");
		File log = new File("Log.txt");
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		ListIterator li = null;
		
		
		if(file.isFile()) { 
			// check if file is avaiavle so we read it to array list
			ois = new ObjectInputStream(new FileInputStream(file));
			book = (ArrayList<Phone>)ois.readObject(); // cast to arraylsit
			ois.close();
		} // if file not exist we will write in it
		
		do{
			System.out.println("===================================");
			System.out.println("PRESS 1 TO ADD A CONTACT");
			System.out.println("PRESS 2 TO UPDATE A CONTACT");
			System.out.println("PRESS 3 TO DELETE A CONTACT");
			System.out.println("PRESS 4 TO SEARCH RESPECTIVE CONTACT");
			System.out.println("PRESS 5 TO DISPLAY YOUR PHONE BOOK");
			System.out.println("PRESS 6 TO REPRESNT CONTACT FROM A-Z");
			System.out.println("PRESS 7 TO REPRESNT CONTACT FROM Z-A");
                         System.out.println("PRESS 8 TO MAKE A CALL");
			System.out.println("PRESS 9 TO SHOW RECETLNY CONTACTED NUMBER");
			System.out.println("PRESS 0 TO EXIT PHONE BOOK");
			System.out.println("===================================");
			
				  System.out.print("MAKE A CHOICE : ");
                       choice = s.nextInt();		
			System.out.println();
			switch(choice) {
				case 1: // inserting a new record
				pd.addcontact(book);
				break;
				case 2: // modifying a record
					pd.modify(book);
				break;
				case 3: // deleting a record 
				pd.delete(book);
                                 break;
				case 4: // searching a record
				pd.search(book);
                                  break;
				case 5: // displaying all records
					pd.display(book);
				break;
				
				case 6: // sorting records in ascending order and displaying it
					pd.sortAscending(book);
				break;
				case 7: // sorting records in descending order and displaying it
					pd.sortDescending(book);
				break;
				case 8: // calling a number
					
					pd.tocall(book);
				break;
				case 9:  // showing who you recently called
					pd.recentcall(book);
				break;
                                 case 0:
                                        runMenu=true;
                                       break;
				default:
					if(choice!=0)
						System.out.println("YOUR CHOICE IS INVALID PLEASE ENTER AGAIN:");
					System.out.println();
				break;
			}
                          
                       
		}while(runMenu != true);
	}
}
