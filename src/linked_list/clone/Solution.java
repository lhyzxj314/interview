package linked_list.clone;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	private Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
	
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null)          // 递归终止条件1
            return null;
        if (map.containsKey(pHead)) // 递归终止条件2
            return map.get(pHead);
       
        // ����ͷ�ڵ�
        RandomListNode head = new RandomListNode(pHead.label);
        map.put(pHead, head);
        // 
        RandomListNode node1 = map.containsKey(pHead.next) ? map.get(pHead.next) : Clone(pHead.next);          
        RandomListNode node2 = map.containsKey(pHead.random) ? map.get(pHead.random) : Clone(pHead.random);
        head.next = node1;
        head.random = node2;
            
        return head;
    }

    
}