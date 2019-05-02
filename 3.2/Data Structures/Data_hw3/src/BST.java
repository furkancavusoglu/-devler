import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/******************************************************
 * BST ADT.
 * Supported operations:
 * Insert
 * Delete
 * Find
 * Min
 * Max
 * Depth
 * Print
 ******************************************************/
public class BST {
    private BSTNode root;      /* Pointer to the root of the tree */
    private int noOfNodes;     /* No of nodes in the tree */

    /*******************************************************
     * Constructor: Initializes the BST
     *******************************************************/
    public BST() {
        root = null;
        noOfNodes = 0;
    }

    /*******************************************************
     * Returns a pointer to the root of the tree
     *******************************************************/
    public BSTNode Root() {
        return root;
    }

    /*******************************************************
     * Returns the number of nodes in the tree
     *******************************************************/
    public int NoOfNodes() {
        return noOfNodes;
    }

    /*******************************************************
     * Inserts the key into the BST. Returns a pointer to
     * the inserted node
     *******************************************************/
    public BSTNode Insert(int key) {
        noOfNodes++;
        BSTNode parent = null;
        BSTNode p = root;
        while (p != null) {
            parent = p;
            if (key == p.key) {
                p.count++;
                noOfNodes--;
                return p;
            } else if (key < p.key)
                p = p.left;
            else
                p = p.right;
        }
        BSTNode newNode = new BSTNode(0);
        newNode.key = key;
        newNode.left = newNode.right = null;
        if (root == null)
            root = newNode;
        else if (key < parent.key)
            parent.left = newNode;
        else
            parent.right = newNode;
        return p;
    } //end-Insert

    /*******************************************************
     * Deletes the key from the tree (if found). Returns
     * 0 if deletion succeeds, -1 if it fails
     *******************************************************/
    public int Delete(int key) {
        BSTNode node1;
        BSTNode node2 = null;
        BSTNode nodeN;
        BSTNode node3 = null;
        node1 = root;
        if (root == null) {
            return -1;
        } else if (root.key == key) {
            if (root.left != null && root.right != null) {
                nodeN = root.right;
                while (nodeN.left != null) {
                    node3 = nodeN;
                    nodeN = nodeN.left;
                }
                root.key = nodeN.key;
                if (node3 == null) {
                    node1.right = nodeN.right;
                } else {
                    if (nodeN.right != null)
                        node3.left = nodeN.right;
                    else
                        node3.left = null;
                }
            } else if (root.right != null && root.left == null) {
                root = root.right;
            } else if (root.left != null && root.right == null) {
                root = root.left;
            } else {
                root = null;
            }
            noOfNodes--;
            return 0;
        } else {
            while (node1 != null) {
                if (node1.key == key) {
                    if (node1.left != null && node1.right != null) {
                        nodeN = node1.right;
                        while (nodeN.left != null) {
                            node3 = nodeN;
                            nodeN = nodeN.left;
                        }
                        node1.key = nodeN.key;
                        if (node3 == null) {
                            node1.right = nodeN.right;
                        } else {
                            if (nodeN.right != null) {
                                node3.left = nodeN.right;
                                nodeN = null;
                            } else {
                                node3.left = null;
                                nodeN = null;
                            }
                        }
                    } else if (node1.right != null && node1.left == null) {
                        if (node2.left.key == node1.key)
                            node2.left = node1.right;
                        else
                            node2.right = node1.right;
                    } else if (node1.left != null && node1.right == null) {
                        if (node2.left.key == node1.key)
                            node2.left = node1.left;
                        else
                            node2.right = node1.left;
                    } else {
                        if (node2.left.key == node1.key)
                            node2.left = null;
                        else
                            node2.right = null;
                    }
                    noOfNodes--;
                    return 0;
                } else if (node1.key < key) {
                    node2 = node1;
                    node1 = node1.right;
                } else {
                    node2 = node1;
                    node1 = node1.left;
                }
            }
            return -1;
        }
    }//end-Delete

    /*******************************************************
     * Searches the BST for a key. Returns a pointer to the
     * node that contains the key (if found) or NULL if unsuccessful
     *******************************************************/
    public BSTNode Find(int key) {
        BSTNode current = root;
        while (current != null && key != current.key) {
            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (current == null) {
            return null;
        }
        return current;
    } //end-Find

    /*******************************************************
     * Returns a pointer to the node that contains the minimum key
     *******************************************************/
    public BSTNode Min() {
        BSTNode local = root;
        if (local == null)
            return null;
        while (local.left != null)
            local = local.left;
        return local;
    } //end-Min

    /*******************************************************
     * Returns a pointer to the node that contains the maximum key
     *******************************************************/
    public BSTNode Max() {
        BSTNode local = root;
        if (local == null)
            return null;
        while (local.right != null)
            local = local.right;
        return local;
    } //end-Max

    /*******************************************************
     * Returns the depth of tree. Depth of a tree is defined as
     * the depth of the deepest leaf node. Root is at depth 0
     *******************************************************/
    public int Depth() {
        if (root == null)
            return 0;
        Queue<BSTNode> queue = new LinkedList();
        queue.add(root);
        int depth = 0;
        while (true) {
            int count = queue.size();
            if (count == 0)
                return depth - 1;
            depth++;
            while (count > 0) {
                BSTNode newNode = queue.peek();
                queue.remove();
                if (newNode.left != null)
                    queue.add(newNode.left);
                if (newNode.right != null)
                    queue.add(newNode.right);
                count--;
            }
        }

    } //end-Depth

    /*******************************************************
     * Performs an inorder traversal of the tree and prints [key, count]
     * pairs in sorted order
     *******************************************************/
    public void Print() {
        printInorder(root);
    } //end-Print

    void printInorder(BSTNode node) {
        if (node == null)
            return;
        /* first recur on left child */
        printInorder(node.left);
        /* then print the data of node */
        System.out.print(node.key + " ");
        /* now recur on right child */
        printInorder(node.right);
    }
}