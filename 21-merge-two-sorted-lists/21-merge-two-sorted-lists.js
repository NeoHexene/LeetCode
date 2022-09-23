/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeTwoLists = function(list1, list2) {
   const head = new ListNode(null); // assigning address of first node (i.e. in empty list head is null)
   let x = head; // giving x the address of the first node
   while(list1 && list2){ // this will run until one of the list is null
       if(list1.val < list2.val){
           x.next = list1;
           list1 = list1.next;
       } else {
           x.next = list2;
           list2 = list2.next;
       }
       x = x.next;
   }
    if(!list1) {
        x.next = list2;
    }
    else {
        x.next = list1;
    }
    return head.next;
};