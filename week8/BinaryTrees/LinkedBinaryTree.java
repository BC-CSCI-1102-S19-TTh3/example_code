/* This is a dumb linked binary tree implementation.
All you can do is add a node to the bottom and travere it
in a few different ways.
*/

public class LinkedBinaryTree<T> {

  // instance variables
  // These are the same as in MinPQ
  Node top;
  int size;

  // Node class
  // Also like what you'll have in MinPQ
  class Node {
    T info;
    Node left;
    Node right;
    Node parent;

    Node(T info) {
      this.info = info;
    }
  }

  // Method to add a node to the next available place.
  // Note that this is *not* how you should do it in MinPQ!
  void add(T item) {

    // special case: when binary tree is empty
    if (size == 0) {
      top = new Node(item);
      size++;
      return;
    }

    // This finds the sequence of L's and R's needed to get
    // to the parent node of the item to be added.
    int parentID = (size+1)/2;  // parent will be new size / 2
    String pathToParent = "";
    while (parentID > 1) {
      if (parentID%2 == 1) {
        pathToParent = pathToParent + "R";
      } else {
        pathToParent = pathToParent + "L";
      }
      parentID = parentID/2;
    }

    // Once you have the sequence of L's nd R's, you
    // can follow that sequence down to the node that
    // will be the parent of the new node.
    Node addme = top; // start at the top
    String[] steps = pathToParent.split(""); // split the path
    for (String s : steps) {  // proceed from the top, following R and L
      if (s.equals("L")) {
        addme = addme.left;
      } else if (s.equals("R")) {
        addme = addme.right;
      }
    }

    // If the new size is even, the new node will be the left child.
    // If the new size is off, the new node will be the right child.
    if ((size+1)%2 == 0) {
      addme.left = new Node(item);
    } else {
      addme.right = new Node(item);
    }
    size++;
  }


  // These two methods below print out a level-order traversal.
  // They are very similar to the ones I gave you in MinPQ.
  public String toString() {
    StringBuilder sb=new StringBuilder();
    int height = (int)Math.ceil(Math.log(size+1) / Math.log(2));
    for (int i=1; i<=height; i++) {
      sb.append("level " + i + ": "+ printThisLevel(this.top, i) + "\n");
    }
    return sb.toString();
  }

  String printThisLevel (Node root, int level) {
    StringBuilder s = new StringBuilder();
    if (root == null)
      return s.toString();
    if (level == 1)
      s.append( root.info.toString());
    else if (level > 1) {
      s.append( printThisLevel(root.left, level-1));
      s.append( printThisLevel(root.right, level-1));
    }
    return s.toString();
  }

  // Here are our preOrder, inOrder, and postOrder methods
  // for traversing a binary tree.

  // preOrder
  void preOrder(Node n) {
    if (n==null) {
      return;
    }
    System.out.format("%s", n.info);
    preOrder(n.left);
    preOrder(n.right);
  }

  // inOrder
  void inOrder(Node n) {
    if (n==null) {
      return;
    }
    inOrder(n.left);
    System.out.format("%s", n.info);
    inOrder(n.right);
  }

  // postOrder
  void postOrder(Node n) {
    if (n==null) {
      return;
    }
    postOrder(n.left);
    postOrder(n.right);
    System.out.format("%s", n.info);
  }

  // Let's test this out!
  public static void main (String[] args) {
    LinkedBinaryTree<String> pt = new LinkedBinaryTree<String>();
    pt.add("b");
    System.out.println(pt.toString());
    pt.add("c");
    System.out.println(pt.toString());
    pt.add("d");
    System.out.println(pt.toString());
    pt.add("m");
    System.out.println(pt.toString());
    pt.add("a");
    System.out.println(pt.toString());
    pt.add("z");
    System.out.println(pt.toString());
    System.out.println("\nPre-order:");
    pt.preOrder(pt.top);
    System.out.println("\nIn-order:");
    pt.inOrder(pt.top);
    System.out.println("\nPost-order:");
    pt.postOrder(pt.top);
    System.out.println();
  }
}
