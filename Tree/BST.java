import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

class BST {

    private TreeNode root;

    public BST() {
        this.root = null;
    }

    public class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Insert method
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        }
        if (data < node.val) {
            node.left = insertRec(node.left, data);
        } else if (data > node.val) {
            node.right = insertRec(node.right, data);
        }
        return node;
    }

    // Search method
    public void search(int data) {
        if (searchRec(root, data)) {
            System.out.println("Node found");
        } else {
            System.out.println("Node not found");
        }
    }

    private boolean searchRec(TreeNode node, int data) {
        if (node == null) {
            return false;
        }
        if (node.val == data) {
            return true;
        }
        return data < node.val ? searchRec(node.left, data) : searchRec(node.right, data);
    }

    // In-order traversal
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(TreeNode node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.val + " , ");
            inorderRec(node.right);
        }
    }

    // Pre-order traversal
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " , ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    // Post-order traversal
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(TreeNode node) {
        if (node != null) {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.val + " , ");
        }
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "", root);
        return buffer.toString();
    }

    // Print method
    private void print(StringBuilder buffer, String prefix, String childrenPrefix, TreeNode node) {
        if (node == null) return;

        buffer.append(prefix);
        buffer.append(node.val);
        buffer.append('\n');

        List<TreeNode> children = new ArrayList<>();
        if (node.left != null) children.add(node.left);
        if (node.right != null) children.add(node.right);

        for (Iterator<TreeNode> it = children.iterator(); it.hasNext();) {
            TreeNode next = it.next();
            if (it.hasNext()) {
                print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ", next);
            } else {
                print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ", next);
            }
        }
    }

    // Delete method
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private TreeNode deleteRec(TreeNode node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.val) {
            node.left = deleteRec(node.left, data);
        } else if (data > node.val) {
            node.right = deleteRec(node.right, data);
        } else {
            // Node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Node with two children: get the inorder successor (smallest in the right subtree)
            node.val = minValue(node.right);

            // Delete the inorder successor
            node.right = deleteRec(node.right, node.val);
        }

        return node;
    }

    private int minValue(TreeNode node) {
        int min = node.val;
        while (node.left != null) {
            min = node.left.val;
            node = node.left;
        }
        return min;
    }

}
