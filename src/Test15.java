/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
 */
public class Test15 {

    public static MyNode merageList(MyNode list1,MyNode list2){

        if(null == list1 && null != list2){
            return list2;
        }
        if(null != list1 && null == list2){
            return list1;
        }
        if(null == list1 && null == list2){
            return null;
        }
        MyNode newHead = null;
        if(list1.data >= list2.data){
            newHead = list2;
            list2 = list2.next;
        }else {
            newHead = list1;
            list1 = list1.next;
        }
        MyNode temp = newHead;
        while(list1 != null && list2 != null){
            if(list1.data >= list2.data){
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }else{
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            }
        }
        if(list1 != null){
            temp.next = list1;
        }
        if(list2 != null){
            temp.next = list2;
        }

        return newHead;

    }

    public static void main(String args[]){
        MyNode node1 = new MyNode(1);
        MyNode node3 = new MyNode(3);
        MyNode node5 = new MyNode(5);

        node1.next = node3;
        node3.next = node5;

        MyNode node2 = new MyNode(2);
        MyNode node4 = new MyNode(4);
        MyNode node6 = new MyNode(6);

        node2.next = node4;
        node4.next = node6;

        MyNode node = merageList(node1,node2);

        while (node != null){
            System.out.print(node.data+" ");
            node = node.next;
        }
    }

}
