package separateChaining;

/* Node for singly linked list */
class HashTableNode {

	// Next keep blank value
	HashTableNode next;
	// Data to store each number added
	int data;

	/* Constructor */
	public HashTableNode(int x) {
		// Add number to the table
		data = x;
		// Keep an open value null at end to identify end of array table
		next = null;
	}
}