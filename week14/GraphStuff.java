import java.util.*;

public class GraphStuff {

  // Map from string (a city) to adjacency list (of neighboring cities)
  HashMap<String,ArrayList<String>> graph;

  // constructor for the class to initialize HashMap
  public GraphStuff() {
    this.graph = new HashMap<String,ArrayList<String>>();
  }

  // This creates a vertex in the graph for a and an empty adjacency list.
  public void createVertex(String s) {
    ArrayList<String> al = new ArrayList<String>();
    graph.put(s, al);
  }

  // This adds an edge between two cities, a and b.
  public void createEdge(String a, String b) {
    if (!graph.containsKey(a)) {
      createVertex(a);
    }
    if (!graph.containsKey(b)) {
      createVertex(b);
    }
    ArrayList<String> al = graph.get(a);
    al.add(b);
    graph.put(a, al);

    ArrayList<String> bl = graph.get(b);
    bl.add(a);
    graph.put(b, bl);
  }

  // This method performs a random walk of length=steps,
  // starting at city a, and returns a list of visited cities.
  public ArrayList<String> randomWalk(String a, int steps) {
    ArrayList<String> visited = new ArrayList<String>();
    while (steps > 0) {
      steps--;

      ArrayList<String> al = graph.get(a);
      int rando = (int)(Math.random() * al.size());
      String b = al.get(rando);
      System.out.println("Going from " + a + " to " + b);
      visited.add(b);
      a = b;
    }
    return visited;
  }

  // This prints out the shortest path between city a and city b.
  public void breadthFirstSearch(String a, String b) {

    // Keep track of which vertices you have visited.
    // Map each one to the vertex you got there from.
    HashMap<String,String> visited = new HashMap<String,String>();

    // Algorithm:
    // Create a queue
    LinkedList<String> queue = new LinkedList<String>();

    // Add your starting vertex, a, to the queue.
    queue.add(a);

    // Crucially, add the starting vertex to visited!
    visited.put(a, null);

    // While the queue is not empty
    while (!queue.isEmpty()) {

      // Poll off the first vertex.
      String current = queue.poll();

      // Get that vertex's adjacency list.
      ArrayList<String> al = graph.get(current);

      // Go through each vertex in the adjacency list for that city.
      for (String adjacent : al) {

        // If the current vertex matches the one you are looking for (b), yay!
        if (adjacent.equals(b)) {

          // Follow the path back using visited HashMap until you get to a
          while (adjacent != a) {
            System.out.println("We got to " + adjacent + " from " + current + ".");
            adjacent = current;
            current = visited.get(current);
          }
          return;
        }
        // Otherwise, check to see if you've visited that node already or
        // if it's already in the queue. If not, add it to the queue, and
        // add it to visited, along with where you came from (current).
        else {
          if (!queue.contains(adjacent) && !visited.containsKey(adjacent)) {
            queue.add(adjacent);
            visited.put(adjacent,current);
          }
        }
      }
    }
    return;
  }

  // Main method for testing.
  public static void main (String[] args) {
    GraphStuff gs = new GraphStuff();
    gs.createEdge("Boston", "New York");
    gs.createEdge("Boston", "Portland");
    gs.createEdge("Portland", "Bangor");
    gs.createEdge("Boston", "Nashua");
    gs.createEdge("Boston", "Albany");
    gs.createEdge("Nashua", "Portland");
    gs.createEdge("New York", "Albany");
    gs.createEdge("New York", "Philadelphia");
    gs.createEdge("New York", "Baltimore");
    gs.createEdge("New York", "Washington");
    gs.createEdge("Philadelphia", "Pittsburgh");
    gs.createEdge("Philadelphia", "Baltimore");
    System.out.println("Random walk!");
    ArrayList<String> cities = gs.randomWalk("New York", 10);
    System.out.println(cities + "\n");
    System.out.println("Shortest path!");
    gs.breadthFirstSearch("Nashua", "Pittsburgh");
  }

}
