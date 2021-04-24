package practise.inplacereversal;

/**
 * Given the head of a Singly LinkedList, reverse the LinkedList. Write a function to return the new head of
 * the reversed LinkedList.
 */
public class InPlaceReversalLinkList {

  public static void main(String[] args) {
    InPlaceReversalLinkList program = new InPlaceReversalLinkList();

  }

  public Node reverseLinkList(Node head) {
    Node prev = null;
    Node current = head;
    Node next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }

}

class Node {

  public int data;
  public Node next;

  public Node(int data, Node next) {
    this.data = data;
    this.next = next;
  }

}

