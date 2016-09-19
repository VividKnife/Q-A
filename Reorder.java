
public class Reorder {
			public static JNode reorder2(JNode head) {
				if (head == null || head.next == null || head.next.next ==
						null) {
					return head;
				}
				JNode fast = head.next;
				JNode slow = head;
				while (fast.next != null && fast.next.next != null) {
					fast = fast.next.next;
					slow = slow.next;
					
				}
				System.out.println("slow v"+slow.val);
				JNode pre = slow.next;
				JNode cur = pre.next;
				while (cur != null) {
					System.out.println("cur v------------------"+cur.val);
					
					pre.next = cur.next;
					pt(head);
					System.out.println("pre v"+pre.val);
					pt(head);
					cur.next = slow.next;
					System.out.println("slow v"+slow.val);
					pt(head);
					slow.next = cur;
					cur = pre.next;
					pt(head);
				}
				return head;
			}
			public static JNode reorder3(JNode head) {
				if (head == null || head.next == null) {
					return head;
				}
				JNode pre = findMidPre(head);
				JNode right = pre.next;
				pre.next = null;
				right = reverse(right);
				pre.next = right;
				return head;
			}
			public static JNode reverse(JNode node) {
				if (node == null) {
					return node;
				}
				JNode dummy = new JNode(0);
				while (node != null) {
					JNode tmp = node.next;
					node.next = dummy.next;
					dummy.next = node;
					node = tmp;
				}
				return dummy.next;
			}
			public static JNode findMidPre(JNode node) {
				if (node == null) {
					return node;
				}
				JNode fast = node.next;
				JNode slow = node;
				while (fast != null && fast.next != null &&
						fast.next.next != null) {
					fast = fast.next.next;
					slow = slow.next;
				}
				return slow;
			}
			public static class JNode {
				int val;
				JNode next;
				JNode(int x) {
					val = x;
				}
			}
			public static void pt(JNode x){
				while (x != null) {
					System.out.print(x.val);
					x = x.next;
				}
				System.out.print("\n");
			}
			public static void main(String[] args) {
				JNode n1 = new JNode(1);
				JNode n2 = new JNode(2);
				JNode n3 = new JNode(3);
				JNode n4 = new JNode(4);
				JNode n5 = new JNode(5);
				JNode n6 = new JNode(6);
				JNode n7 = new JNode(7);
				JNode n8 = new JNode(8);
				JNode n9 = new JNode(9);
				JNode n10 = new JNode(10);
				n1.next = n2;
				n2.next = n3;
				n3.next = n4;
				n4.next = n5;
				n5.next = n6;
				n6.next = n7;
				n7.next = n8;
				n8.next = n9;
				n9.next = n10;
				n10.next = null;
				JNode x = reorders(n1);
				while (x != null) {
					System.out.print(x.val);
					x = x.next;
				}
			}
		    public static JNode re(JNode node) {
		        JNode prev = null;
		        JNode current = node;
		        JNode next = null;
		        while (current != null) {
		            next = current.next;
		            current.next = prev;
		            prev = current;
		            current = next;
		        }
		        node = prev;
		        return node;
		    }
			public static JNode reorders(JNode head){
				if(head == null || head.next ==null || head.next.next ==null) return head;
				JNode slow = head;
				JNode fast = head;
				pt(slow);
				while(fast.next!=null&&fast.next.next!=null)
				{
					slow=slow.next;
					fast = fast.next.next;
					//pt(slow);
				}
				pt(slow);
				slow.next = re(slow.next);
		        return head;
			}
			
			
	}
	