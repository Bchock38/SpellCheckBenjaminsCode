public class Trie {
    private final static int radix = 256;
    private Node root = new Node();


    private static class Node {
        private boolean isword;
        private Node[] next = new Node[radix];
    }
    public boolean lookUp(String toLookUp){


        return false;
    }

    private Boolean nodeGet(Node currentNode, String toLookUp, int depth){
        if (depth == toLookUp.length() && currentNode.isword){
            return true;
        }
        return false;
    }
}
