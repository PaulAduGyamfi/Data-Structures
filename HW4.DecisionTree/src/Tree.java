public class Tree {

    private TreeNode root;
    private boolean nodeFound;

    public Tree(){
        this.root = new TreeNode();
    }

    public boolean addNode(String label, String prompt, String message, String parentLabel){
        TreeNode node = new TreeNode();
        if(root.getLeft() == null){
            addNodeLeft(node);
            return true;
        }
        else if(root.getMiddle() == null){
            addNodeMiddle(node);
            return true;
        }
        else if(root.getRight() == null){
            addNodeRight(node);
            return true;
        }
        return false;
    }

    public void addNodeLeft(TreeNode node){
        this.root.setLeft(node);
    }
    public void addNodeMiddle(TreeNode node){
        this.root.setMiddle(node);
    }
    public void addNodeRight(TreeNode node){
        this.root.setRight(node);
    }

    public TreeNode getNodeReference(String label){
        if(root.getLabel().equals(label)){
            return root;
        }
        return getNodeReference(root,label);
    }
    public TreeNode getNodeReference(TreeNode node,String labelll){
        if(node.getLeft()!=null) {
            getNodeReference(node.getLeft(), labelll);
        };
        if(nodeFound) {
            return node;
        }
        if(node.getMiddle()!=null) {
            getNodeReference(node.getMiddle(), labelll);
        }
        if(nodeFound) {
            return node;
        }
        if (node.getRight() != null) {
            getNodeReference(node.getRight(), labelll);
        }
        if(nodeFound) {
            return node;
        }
        if(node.getLabel().equals(labelll)){
            nodeFound = true;
            return node;
        }else{
            return null;
        }
    }

    public void preOrder(){

        System.out.println(root.getLabel());
        System.out.println(root.getMessage());
        System.out.println(root.getPrompt());

        if(root == null){
            return;
        }
        if(root.getLeft() != null){
            root = root.getLeft();
            preOrder();
        }
        if(root.getMiddle() != null){
            root = root.getMiddle();
            preOrder();
        }
        if(root.getRight() != null){
            root = root.getRight();
            preOrder();
        }

    }
}
