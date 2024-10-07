public class TST {

    private Node root = new Node('a');
    private final int left = 0;
    private final int middle = 1;
    private final int right = 2;
    private class Node{
        char character;
        private Node[] children = new Node[3];
        Boolean isWord = false;
        private Node(char a){
            character = a;
        }

    }

    public boolean lookUp(String toLookUp){
//        System.out.println(toLookUp);
        return nodeGet(root,toLookUp,0);

    }


    private Boolean nodeGet(TST.Node currentNode, String toLookUp, int depth) {
        if (currentNode == null) {
            return false;
        }
        if (depth == toLookUp.length()) {
            return currentNode.isWord;
        }
        char currentChar = toLookUp.charAt(depth);
        if (currentChar < currentNode.character) {
            return nodeGet(currentNode.children[left], toLookUp, depth);
        }
        else if (currentChar > currentNode.character) {
            return nodeGet(currentNode.children[right], toLookUp, depth);
        }
        else {
            return nodeGet(currentNode.children[middle], toLookUp, depth + 1);
        }
    }

    public void insert(String toPut){
//        System.out.println(toPut);
        put(root, toPut, 0);
    }

    private void put(TST.Node currentNode, String toPut, int depth) {
        if (depth == toPut.length()) {
            currentNode.isWord = true;
            return;
        }
        char nextChar;
        char currentChar = toPut.charAt(depth);
        if (depth+1 < toPut.length()){
            nextChar = toPut.charAt(depth + 1);
        }
        else {
            nextChar = toPut.charAt(depth);
        }
        if (currentNode.children[middle] == null) {
            currentNode.children[middle] = new TST.Node(nextChar);
            put(currentNode.children[middle], toPut, depth + 1);
        }
        if (currentChar < currentNode.character) {
            if (currentNode.children[left] == null) {
                currentNode.children[left] = new TST.Node(currentChar);
            }
            put(currentNode.children[left], toPut, depth);


        }
        else if (currentChar > currentNode.character) {
            if (currentNode.children[right] == null) {
                currentNode.children[right] = new TST.Node(currentChar);
            }
            put(currentNode.children[right], toPut, depth);
        }
        else{
            put(currentNode.children[middle],toPut,depth + 1);
        }
    }
}
