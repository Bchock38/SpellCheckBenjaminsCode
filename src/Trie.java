public class Trie {
    private final static int radix = 256;
    private Node root = new Node();


    private static class Node {
        private boolean isword = false;
        private Node[] next = new Node[radix];
    }
    public boolean lookUp(String toLookUp){
        return nodeGet(root,toLookUp,0);
    }

    private Boolean nodeGet(Node currentNode, String toLookUp, int depth){
        if (currentNode == null){
            return false;
        }
        if (depth == toLookUp.length() && currentNode.isword){
            return true;
        }
        if (depth == toLookUp.length()){
            return false;
        }

        return nodeGet(currentNode.next[(int)toLookUp.charAt(depth)], toLookUp, depth+1);
    }

    public void insert(String toPut){
        put(root, toPut, 0);
    }

    private void put(Node currentNode, String toPut, int depth){
        if (depth == toPut.length()){
            currentNode.isword = true;
            return;
        }
        if (currentNode.next[(int)toPut.charAt(depth)] == null){
            currentNode.next[(int)toPut.charAt(depth)] = new Node();
        }
        put(currentNode.next[(int)toPut.charAt(depth)], toPut, depth+1);
    }
}
