class Main{
    
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("In-order traversal:");
        bst.inorder();

        System.out.println("Pre-order traversal:");
        bst.preorder();

        System.out.println("Post-order traversal:");
        bst.postorder();

        System.out.println("Tree structure:");
        System.out.println(bst);

        System.out.println("Search for 40:");
        bst.search(40);

        System.out.println("Delete 40");
        bst.delete(40);

        System.out.println("In-order traversal after deleting 40:");
        bst.inorder();
    }
}