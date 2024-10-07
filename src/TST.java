public class TST {

    private Node root = new Node();
    private final int left = 0;
    private final int middle = 1;
    private final int right = 2;
    private class Node{

        char character;
        private Node[] children = new Node[3];
        Boolean isWord = false;
    }

    public boolean lookUp(String toLookUp){
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
        put(root, toPut, 0);
    }

    private void put(TST.Node currentNode, String toPut, int depth) {
        if (depth == toPut.length()) {
            currentNode.isWord = true;
            return;
        }

        char currentChar = toPut.charAt(depth);

        if (currentChar < currentNode.character) {
            if (currentNode.children[left] == null) {
                currentNode.children[left] = new TST.Node();
                currentNode.children[left].character = currentChar;
            }
            else if (currentChar == currentNode.children[left].character){
                put(currentNode.children[left], toPut, depth + 1);
            }

        }
        else if (currentChar > currentNode.character) {
            if (currentNode.children[right] == null) {
                currentNode.children[right] = new TST.Node();
                currentNode.children[right].character = currentChar;
            }
            else if (currentChar == currentNode.children[right].character)
            put(currentNode.children[right], toPut, depth + 1);
        }
        else {
            if (currentNode.children[middle] == null) {
                currentNode.children[middle] = new TST.Node();
                currentNode.children[middle].character = currentChar;
                put(currentNode.children[middle], toPut, depth + 1);
            }
            else{
                put(currentNode.children[middle], toPut, depth);
            }

        }
    }
}
