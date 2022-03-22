package com.sranjan.dsa.facebook;

public class SortedLinkedListMerge {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2,null);
		ListNode node1 = new ListNode(1,l1);
		ListNode l2 = new ListNode(3,null);
		ListNode node2 = new ListNode(2,l2);

		
		SortedLinkedListMerge slm = new SortedLinkedListMerge();
		ListNode mergedList = slm.mergeTwoLists(l1, l2);
		System.out.println(mergedList.val);
		System.out.println(mergedList.next.val);
	}
	
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1 == null && l2 != null) {
    		return l2;
    	}
    	if(l2== null && l1!= null) {
    		return l1;
    	}

    	ListNode dummyNode  = new ListNode(-1);
    	ListNode curr = dummyNode ;
    	
    	ListNode curr1 = l1;
    	ListNode curr2 = l2;
    	while(curr1!= null && curr2 != null) {
    		if(curr1.val < curr2.val ) {
    			curr.next = curr1;
    			curr1 = curr1.next;
    		}
    		else {
    			curr.next = curr2;
    			curr2 = curr2.next;
    		}
    		curr = curr.next;
    	}
    	
    	
    	
    	if(curr1 != null && curr2 == null) {
    		curr.next = curr1;
    	}
    	
    	
    	if(curr2 != null && curr1 == null) {
    		curr.next = curr2;
    	}
    	
		return dummyNode.next ;
        
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) return null;
        
        return mergeKLists(lists, 0, k-1);
    }
    
    

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (end - start == 0) return lists[start];
        if (end - start == 1) {
            return mergeLists(lists[start], lists[end]);
        }  
        
        int mid = start + ((end - start) / 2);
        ListNode listA = mergeKLists(lists, start, mid);
        ListNode listB = mergeKLists(lists, mid+1, end);
        
        return mergeLists(listA, listB);
    }

    
    
    public ListNode mergeLists(ListNode listA, ListNode listB) {
        if (listA == null) return listB;
        if (listB == null) return listA;
        
        if (listA.val < listB.val) {
            listA.next = mergeLists(listA.next, listB);
            return listA;
        } 
        else {
            listB.next = mergeLists(listA, listB.next);
            return listB;
        } 
    }
}
