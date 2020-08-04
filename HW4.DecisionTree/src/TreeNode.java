/**
 * This class represents a tree node
 *
 * @author Paul Adu-Gyamfi
 *
 */
public class TreeNode {

    private String label;
    private String message;
    private String prompt;

    private TreeNode left;
    private TreeNode middle;
    private TreeNode right;

    public TreeNode(){

        this.label = null;
        this.message = null;
        this.prompt = null;

        this.left = null;
        this.middle = null;
        this.right = null;
    }
    public TreeNode(String label,String message, String prompt){

        this.label = label;
        this.message = message;
        this.prompt = prompt;

        this.left = null;
        this.middle = null;
        this.right = null;
    }

    /**
     *
     * @return
     * node label
     */
    public String getLabel() {
        return label;
    }

    /**
     *
     * @param label
     * set label of the node
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     *
     * @return
     * node message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * set the message of the node
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * the prompt of the node
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     *
     * @param prompt
     * set the prompt of the node
     */
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    /**
     *
     * @return
     * get node's left child
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     *
     * @param left
     * set node's left child
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     *
     * @return
     * get node's middle child
     */
    public TreeNode getMiddle() {
        return middle;
    }

    /**
     *
     * @param middle
     * set node's middle child
     */
    public void setMiddle(TreeNode middle) {
        this.middle = middle;
    }

    /**
     *
     * @return
     * get node's right child
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     *
     * @param right
     * set node's right child
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     *
     * @return
     * true if node is a leaf else false
     */
    public boolean isLeaf(){
        return left == null && middle == null && right == null;
    }

}
