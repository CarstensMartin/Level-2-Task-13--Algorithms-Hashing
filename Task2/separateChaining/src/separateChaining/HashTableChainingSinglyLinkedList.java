package separateChaining;

/* Class HashTableChainingSinglyLinkedList */
class HashTableChainingSinglyLinkedList {

	// Declare hash table
	private HashTableNode[] table;

	
	
	// Constructor
	public HashTableChainingSinglyLinkedList(int tableSize) {
		table = new HashTableNode[tableSize];
	}

	
	
	// Function to insert an element
	public void insert(int val) {

		// Use method to get hash value after modulus(bucket)
		int position = myhash(val);

		// Declare a new bucket table with the value inside
		HashTableNode bucketTable = new HashTableNode(val);

		// If the has position of the hash Table has a null value
		if (table[position] == null) {
			// Insert the new bucket table array in this position
			table[position] = bucketTable;
		}
		// else if there if there is already a value
		else {
			// next position place the existing bucket(merge)
			bucketTable.next = table[position];
			// The new created bucket with old values added place in correct position in array
			table[position] = bucketTable;
		}
	}

	
	
	// Method to remove an element
	public void remove(int val) {

		// get the hash value position(bucket) after modulus
		int position = myhash(val);

		// Declare start and end array (bucket) based on hash position
		HashTableNode start = table[position];
		HashTableNode end = start;

		// If the bucket is empty
		if (start == null) {
			// Display element not found & return
			System.out.println("\nElement not found\n");
			return;
		}

		// If first item is equals to value
		if (start.data == val) {
			// Update the bucket with all the values after is - start.next & exclude first
			table[position] = start.next;
			return;
		}

		// while end.next is not the last value(null)
		// Or not equal to the value to be found, continue running end.next
		while (end.next != null && end.next.data != val)

			// End is equal to previous end and 1 value moved on (next)
			end = end.next;

		// If end.next is at the end of the bucket (null)
		if (end.next == null) {
			// Display that element is not found & return
			System.out.println("\nElement not found\n");
			return;
		}

		// if next next is null then know its end
		if (end.next.next == null) {
			// next has value null 7 return
			end.next = null;
			return;
		}

		// Give the value for end.next the end. nex.next to capture the next position after the current
		end.next = end.next.next;
		// Table hash after modulus position remains same as start if end not found for while loop
		table[position] = start;

	}

	
	
	// Function to get hash value after Modules
	private int myhash(Integer x) {

		// Get the hashCode value
		// Modulus the value to fit in correct bucket
		int hashAfterMod = (x.hashCode()) % table.length;

		// Return the hash value after modulus
		return hashAfterMod;
	}

	
	
	// Method to print the table
	public void printHashTable() {
		// Print a space (blank line)
		System.out.println();

		// Run a for loop to print every bucket
		for (int i = 0; i < table.length; i++) {

			// Display on console which bucket it is
			System.out.print("Bucket " + i + ":  ");

			// Declare each bucket
			HashTableNode bucket = table[i];

			// While .next != empty (null) - run while loop
			while (bucket != null) {
				// Add the data in the bucket to console
				System.out.print(bucket.data + " ");
				// Get the next item
				bucket = bucket.next;
			}

			// Print a space (blank line)
			System.out.println();
		}
	}
}