import java.util.*;

public class MyBST {

  // pointer to top of BST
  Node top;
  int size;

  // Node class has been moved to separate file
  // so it can work with BTreePrinter class.

  // Search function
  public boolean searchBST (int searchterm) {

    // Make a pointer to the top
    Node n = top;

    // While your pointer is not null...
    while (n != null) {

      // If the current key is your search term, match and return.
      if (searchterm == n.key) {
        System.out.println("Found key: " + searchterm);
        return true;
      }

      // Otherwise look to the left your search term is smaller
      // or the the right if your search term in bigger.
      else if (searchterm < n.key) {
        n = n.left;
      } else {
        n = n.right;
      }
    }
    return false;
  }


  // Insert function -- very explicit.
  public boolean insertKey (int searchterm) {

    // Create a node to insert.
    Node insertNode = new Node (searchterm);

    // If top is null, make top point at new node.
    if (top == null) {
      top = insertNode;
      size++;
      return true;
    }

    // Inserting all other nodes

    // Make a pointer to tne top, and while it is not null
    Node n = top;
    while (n != null) {

      // If you find a match, return. You can't add a key you already have.
      if (searchterm == n.key) {
        System.out.println("Key already in BST: " + searchterm);
        return false;
      }

      // If your search term is smaller than current key, look
      // to see if there's a left child. If not, insert your new
      // node and return true. Otherwise look to the left.
      else if (searchterm < n.key) {
        if (n.left == null) {
          n.left = insertNode;
          size++;
          return true;
        } else {
          n = n.left;
        }
      }

      // As above, but in the case that the search term is larger
      // than the current key.
      else {
        if (n.right == null) {
          n.right = insertNode;
          size++;
          return true;
        } else {
          n = n.right;
        }
      }
    }

    // If manage to get all the way through and haven't returned,
    // something went wrong, so return false.
    return false;
  }

  // Main method for testing.
  public static void main (String[] args) {
    MyBST mybst = new MyBST();
    mybst.insertKey(5);
    mybst.insertKey(2);
    mybst.insertKey(10);
    mybst.insertKey(4);
    mybst.insertKey(15);
    mybst.insertKey(3);
    mybst.insertKey(16);
    mybst.insertKey(11);
    mybst.insertKey(2);
    mybst.insertKey(8);
    mybst.searchBST(10);
    mybst.searchBST(5);

    // This will print out small trees with small keys.
    BTreePrinter.printNode(mybst.top);

  }

}
