
public class InsertToSortedCircleLinkedList {
	public static CNode insert7(CNode myList, int n) {
		// corner case if it is null
		if (myList == null) {
			return new CNode(n);
			} else if (myList.next == myList) { // only one element
		// 	add this node
				myList.next = new CNode(n);
		// 	the next's next reference points back to the head
				//so forms a cycle
				myList.next.next = myList;
		// 		check value and return the smaller one as head
				if (myList.val < n) {
					return myList;
				} else {
					return myList.next;
				}
			} else if (n < myList.val) {
		// 	if it is the smallest element
		// 	find tail and append
				CNode cur = myList;
				while (cur.next != myList) {
					cur = cur.next;
				}
		// 	add value after the tail
				cur.next = new CNode(n);
		// 	set the appended node's next to original header
				cur.next.next = myList;
		// 	because this is smallest value! And that's another
		//		reason we return List other than void
						return cur.next;
			}
		// 	find a position when node.val < n and node.next.val > n
		// 	or node.next == head (largest)
			CNode cur = myList;
			while (cur.next != myList && cur.next.val <= n) {
				cur = cur.next;
			}
			CNode curNext = cur.next;
			cur.next = new CNode(n);
		// 	made a copy of original next and assign it here
			cur.next.next = curNext;
		// 	return header position is unchanged
			return myList;
			}
		// 	SOL 2
		// 	case 1 : pre.val ¡Ü x ¡Ü cur.val:
		// 	Insert between pre and cur.
		// 	case 2 : x is the maximum or minimum value in the list:
		// 	Insert before the head. e.g. the head has the smallest value
			//and its pre.val > head.val.
		// 		case 3 : Traverses back to the starting point:
		// 	Insert before the starting point.
			public static CNode insert3(CNode head, int x) {
				if (head == null) {
					head = new CNode(x);
					head.next = head;
					return head;
				}
				CNode cur = head;
				CNode pre = null;
				do {
					pre = cur;
					cur = cur.next;
		// 	case 1
					if (x <= cur.val && x >= pre.val) {
						break;
					}
		// 	case 2
					if (pre.val > cur.val && (x < cur.val || x > pre.val))
					{
						break;
					}
				} while (cur != head); // when back to starting point, then
				//stop. For case 3
				CNode newNode = new CNode(x);
				newNode.next = cur;
				pre.next = newNode;
				return newNode;
			}
			public static CNode insert4(CNode head, int x)
			{
				if(head ==null){
					head = new CNode(x);
					head.next = head;
					return head;
				}
				CNode curr = head;
				while(curr.next.val >= curr.val){
					curr = curr.next;
				}
				CNode pre = curr;
				
				head = curr.next;
				if(head.val>x){
					pre.next = new CNode(x);
					pre.next.next = head;
					head = pre.next;
				}else if(pre.val<x)
				{
					pre.next = new CNode(x);
					pre.next.next = head;
				}
				else{
					curr = head;
					CNode temp =curr;
					while(curr.val<x){
						temp = curr;
						curr = curr.next;
					}
					temp.next = new CNode(x);
					temp.next.next = curr;
					//System.out.println(x+"**");
				}
				return head;
				
			}
			public static void printNode(CNode head)
			{
				CNode curr = head.next;
				System.out.println(head.val);
				while(curr != head){
					System.out.println(curr.val);
					curr = curr.next;
				}
				System.out.println("------------");
			}
			public static void main(String[] args)
			{
				CNode head = new CNode(3);
				head.next = new CNode(4);
				head.next.next = new CNode(5);
				head.next.next.next = new CNode(5);
				head.next.next.next.next = new CNode(10);
				head.next.next.next.next.next = new CNode(16);
				head.next.next.next.next.next.next = new CNode(19);
				head.next.next.next.next.next.next.next = new CNode(2);
				head.next.next.next.next.next.next.next.next = head;
				printNode(head);
				printNode(insert7(head,10));
				//printNode(insert7(head,9));
				//printNode(insert4(head,17));
				//printNode(insert4(head,1));
			}
			public static class CNode {
				int val;
				CNode next;
				CNode(int x) {
					val = x;
				}
			}
	}
	