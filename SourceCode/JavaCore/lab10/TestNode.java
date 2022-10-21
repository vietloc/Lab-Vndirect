public class TestNode {
    private static void test(Node<?>node){
        while(node!=null){
            System.out.println("value is '"+ node.getGetter()+"'");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node<String>root = new Node<>("Step1");
        Node<String>node1 = new Node<>("Step 2");
        Node<Integer>root2;
        root2 = new Node<Integer>(99, new Node<Integer>(23,new Node<Integer>(11)));
        test(root2);
        root.next = node1;

        test(root);
    }
}
