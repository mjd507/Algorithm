
public class _021_Merge_Two_Sorted_List{

	public static void main(String[] args) {
		
	}

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode ans = new ListNode(0);
    ListNode temp = ans;
    while(l1 != null && l2 != null){
      if(l1.val < l2.val){
        temp.next = l1;
        l1 = l1.next;
      }else {
        temp.next = l2;
        l2 = l2.next;
      }
      temp = temp.next;
    }
    if(l1 == null){
      temp.next = l2;
    }
    if(l2 == null){
      temp.next = l1;
    }
    return ans.next;
  }
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    
    ListNode node;
    if(l1.val < l2.val){
      node = l1;
      node.next = mergeTwoLists(l1.next, l2);
    }else {
      node = l2;
      node.next = mergeTwoLists(l1, l2.next);
    }
    return node;
  }
}