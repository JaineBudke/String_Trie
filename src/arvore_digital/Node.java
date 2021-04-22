package arvore_digital;

public class Node {

    Node[] filhos;
    Boolean terminal;
    
    Node(int alphabet_size){
    	filhos = new Node[alphabet_size];
        terminal = false;
        
        for (int i = 0; i < alphabet_size; i++)
            filhos[i] = null;
    }
    
}
