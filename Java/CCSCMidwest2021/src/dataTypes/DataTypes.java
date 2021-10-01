package dataTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

public class DataTypes {

	public static void main(String[] args) {
		
		//UnsafeArrayListDemo();
		//ArrayDemo();
		//HashMapDemo();
		//UnsafeHashMapDemo();
		//UnsafeHashSetDemo();
		//HashSetDemo();
		StringDemo();
	}
	public static void StringDemo() {
		System.out.println("String Demo");
		String myString = "12345";
		// Strings are immutable, so... not much to do
		// Demo the reference copy that takes place.
		String copyString = myString;
		myString = "I\'m different";
		System.out.println("myString: " + myString + ", copyString: " + copyString);
		
		// Indexable
		myString = "12345";
		System.out.println("Char at index 1 = " + myString.charAt(1));		// Can't use [ ] syntax
		
		
	}
	public static void HashSetDemo() {
		System.out.println("HashSet Demo");
		HashSet<String> myHashSet = new HashSet<String>();
		myHashSet.add("1");
		myHashSet.add("2");
		myHashSet.add("3.0");
		myHashSet.add("true");
		System.out.println(myHashSet.toString());
		for (String s : myHashSet) {
			System.out.println(s);
		}
	}
	public static void UnsafeHashSetDemo() {
		System.out.println("Unsafe HashSet Demo");
		HashSet myUnsafeHashSet = new HashSet();
		myUnsafeHashSet.add(1);
		myUnsafeHashSet.add("2");
		myUnsafeHashSet.add(3.0);
		myUnsafeHashSet.add(true);
		System.out.println(myUnsafeHashSet.toString());
		// Add a HashSet as an element
		HashSet newUnsafeHashSet = new HashSet();
		newUnsafeHashSet.add("New1");
		newUnsafeHashSet.add("New2");
		myUnsafeHashSet.add(newUnsafeHashSet);
		System.out.println(myUnsafeHashSet.toString());
		System.out.println("Iterating over the unsafe HashSet after adding a HashSet element to it...");
		for (Object o : myUnsafeHashSet) {
			System.out.println(o.toString());
		}
	}
	public static void HashMapDemo() {
		System.out.println("HashMap Demo");
		HashMap<String, String> myHashMap = new HashMap<String, String>();
		myHashMap.put("Key1", "Value1");
		myHashMap.put("Key2", "Value2");
		myHashMap.put("Key3", "Value3");
		myHashMap.put("Key4", "Value4");
		System.out.println(myHashMap);
		for (Entry<String, String> entry : myHashMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		// Replace a value associated with an existing key
		myHashMap.put("Key4", "Value4a");
		for (Entry<String, String> entry : myHashMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
	/**
	 * We can create a HashMap that permits heterogeneous keys. We do get warnings, but it still runs.
	 */
	public static void UnsafeHashMapDemo() {
		System.out.println("Unsfe HashMap Demo");
		HashMap myUnsafeHashMap = new HashMap();
		myUnsafeHashMap.put("Key1", "Value1");
		myUnsafeHashMap.put(2, "Value2");
		myUnsafeHashMap.put("Key3", "Value3");
		myUnsafeHashMap.put("Key4", "Value4");
		System.out.println(myUnsafeHashMap);
		for (Object entry : myUnsafeHashMap.entrySet()) {
			System.out.println(((Entry) entry).getKey() + ": " + ((Entry) entry).getValue());
		}
		// Replace a value associated with an existing key
		myUnsafeHashMap.put("Key4", "Value4a");
		for (Object entry : myUnsafeHashMap.entrySet()) {
			System.out.println(((Entry) entry).getKey() + ": " + ((Entry) entry).getValue());
		}
	}
	public static void ArrayDemo() {
		System.out.println("array Demo");
		int[] myArray = new int[] {1,2,3,4,5}; 
		Object[] myObjectArray =  new Object[] {1,"Hello", 42.5, true};
		System.out.println("Array of Object types: " + myObjectArray.toString());	// Just prints the reference
		for (Object o : myObjectArray) {System.out.println(o);}
		for (int i = 0; i < myObjectArray.length; i++) {System.out.println(myObjectArray[i]);}
	}
	public static void UnsafeArrayListDemo() {
		System.out.println("Unsafe ArrayList Demo");

		// Create an (unsafe) ArrayList and add to it another ArrayList as an element 
		
        ArrayList myUnsafeArrayList =  new ArrayList();
        myUnsafeArrayList.addAll(Arrays.asList(1,2,3,4,5,6,7, true));
        myUnsafeArrayList.add("hello");
        myUnsafeArrayList.add(100);      
        myUnsafeArrayList.add("end");
        System.out.println("Before add: " + myUnsafeArrayList.toString());
        System.out.println("Before add: " + myUnsafeArrayList.get(0));
        //System.out.println(myUnsafeArrayList[0]);   // Not supported
        
        myUnsafeArrayList.add(0, (new ArrayList(Arrays.asList("Hi", "Bye"))));
        System.out.println("Before add: " + myUnsafeArrayList.toString());
        System.out.println("After add: " + myUnsafeArrayList.get(0));
	}
}
