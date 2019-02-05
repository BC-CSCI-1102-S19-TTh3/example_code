class PostFix {
  public static void main (String[] args) {
    StringStack stck = new StringStackLinkedList();

    String expression = "4 5 7 2 + - *";
    String[] parts = expression.split("\\s+");

    for (int i=0; i < parts.length; i++) {
      if (parts[i].equals("+")) {
        int n1 = Integer.parseInt(stck.pop());
        int n2 = Integer.parseInt(stck.pop());
        int n3 = n2 + n1;
        stck.push(Integer.toString(n3));
      } else if (parts[i].equals("-")) {
        int n1 = Integer.parseInt(stck.pop());
        int n2 = Integer.parseInt(stck.pop());
        int n3 = n2 - n1;
        stck.push(Integer.toString(n3));
      } else if (parts[i].equals("*")) {
        int n1 = Integer.parseInt(stck.pop());
        int n2 = Integer.parseInt(stck.pop());
        int n3 = n2 * n1;
        stck.push(Integer.toString(n3));
      } else if (parts[i].equals("/")) {
        int n1 = Integer.parseInt(stck.pop());
        int n2 = Integer.parseInt(stck.pop());
        int n3 = n2 / n1;
        stck.push(Integer.toString(n3));
      } else {
        stck.push(parts[i]);
      }
    }
    System.out.println(stck.pop());



  }


}
