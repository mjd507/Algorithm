public class _023_Merge_k_Sorted_Lists {

  public static ListNode mergeKLists(ListNode[] lists) {
    return partion(lists, 0, lists.length - 1);
  }

  public static ListNode partion(ListNode[] lists, int s, int e){
    if(s == e)  return lists[s];
    if(s < e){
      int q = (s + e)/2;
      ListNode l1 = partion(lists, s, q);
      ListNode l2 = partion(lists, q + 1, e);
      return mergeTwoList(l1,l2);
    }else
      return null;
  }

  public static ListNode mergeTwoList(ListNode a, ListNode b){
    ListNode ans = new ListNode(0);
    ListNode temp = ans;
    while(a != null && b != null){
      if(a.val < b.val){
        temp.next = a;
        a = a.next;
      }else{
        temp.next = b;
        b = b.next;
      }
      temp = temp.next;
    }
    if(a == null){
      temp.next = b;
    }
    if(b == null){
      temp.next = a;
    }
    return ans.next;
  }
}