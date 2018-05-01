/**
 * 输入一个链表，输出该链表中倒数第 k 个结点。为了符合大多数人的习惯，
 * 本题从 1 开始计数，即链表的尾结点是倒数第一个结点。例如一个有 6 个结点的
 * 链表，从头结点依次是 1,2,3,4， 5,6。倒数第三个结点就是值为 4 的结点
 */
public class Test13 {


    public static void printReciprocal(MyNode head,int k){
        if(null == head || 0 == k){
            return;
        }
        MyNode temp = head;
        //利用差值，要获取倒数第k个，就先获取整数第k个节点设置为temp，然后一个从头节点开始，一个从正数第k个节点开始，
        //当temp到达最后一个节点的时候，head刚好停在倒数第k个节点的位置，画个图就可以一目了然
        for(int i = 0;i<k-1;i++){
            if(null != temp.next){
                temp = temp.next;
            }
            else{
                System.out.println("超出链表长度");
                return;
            }
        }

        while(null != temp.next){
            temp = temp.next;
            head = head.next;
        }

        System.out.println("倒数第 "+k+"个节点为："+head.data);

    }

    public static void main(String args[]){
        MyNode node1 = new MyNode(1);
        MyNode node2 = new MyNode(2);
        MyNode node3 = new MyNode(3);
        MyNode node4 = new MyNode(4);
        MyNode node5 = new MyNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printReciprocal(node1,2);
        while (null != node1){

            System.out.print(node1.data+" ");
            node1 = node1.next;
        }
    }
}
