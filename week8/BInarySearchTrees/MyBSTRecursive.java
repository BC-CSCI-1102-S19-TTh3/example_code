import java.util.*;

public class MyBSTRecursive {

  // pointer to top of BST
  Node top;
  int size;

  // Node class has been moved to separate file
  // so it can work with BTreePrinter class.

  // Recursive search function
  public boolean searchBST (int searchterm, Node n) {

    // If you're at a null node, then your search failed.
    if (n == null) {
      return false;
    }

    // If your search term matches the current key, your search succeeded.
    if (searchterm == n.key) {
      System.out.println("Search term found: " + searchterm);
      return true;
    }
    // Otherwise, keep looking, in left subtree if smaller, right if bigger.
    else if (searchterm < n.key) {
      searchBST(searchterm, n.left);
    } else {
      searchBST(searchterm, n.right);
    }
    return false;
  }


  // Recursive insert methods.

  // First, a method to call the recursive method from the top.
  public void insertKey(int searchterm) {
    top = doInsertKey(searchterm, top);
  }

  // Then, ercursive function for inserting a new node.
  public Node doInsertKey (int searchterm, Node n) {

    // When you get to a null node, insert!
    if (n == null) return new Node(searchterm);

    // Otherwise, keep looking in the left subtree is smaller, right if bigger.
    if (searchterm < n.key){
      n.left = doInsertKey(searchterm, n.left);
    } else if (searchterm > n.key) {
      n.right = doInsertKey(searchterm, n.right);
    } else {
      // And return the current node if there's a match.
      System.out.println("Search term already in tree: " + searchterm);
      return n;
    }
    return n;
  }

  // Main method for testing.
  public static void main (String[] args) {
    MyBSTRecursive mybst = new MyBSTRecursive();
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
    mybst.insertKey(5);
    mybst.insertKey(5);

    mybst.searchBST(10, mybst.top);
    mybst.searchBST(5, mybst.top);
    mybst.searchBST(100, mybst.top);


    // This will print out small trees with keys < 2 chars.
    BTreePrinter.printNode(mybst.top);

  }

}
