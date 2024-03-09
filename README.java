# Binary-Search-tree-in-DSA-in-Java
create binary search trree and search and delete node operation in BST in DSA
public class BinarySearchtree {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data < val) {
            // right subtree
            root.right = insert(root.right, val);

        } else if (root.data > val) {
            // left subtree
            root.left = insert(root.left, val);
        }
        return root;
    }

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else if (root.data < key) {
            return search(root.right, key);
        } else {
            return true;
        }
    }

    public static Node delete(Node root, int val) {

        if (root.data == val) {
            // clase 1
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3
            Node IS = findinorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        }
        return root;
    }

    public static Node findinorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + "  ->  ");
        inorder(root.right);

    }

    public static void main(String[] args) {
        int val[] = { 5, 3, 2, 1, 7, 9 };
        Node root = null;
        for (int i = 0; i < val.length; i++) {
            root = insert(root, val[i]);
        }
        inorder(root);
        delete(root, 5);
        inorder(root);
        System.out.println(search(root, 19));

    }
}
