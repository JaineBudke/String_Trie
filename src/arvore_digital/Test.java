package arvore_digital;

public class Test {

    public static void main( String args[] ) {
    	
    	Trie trie = new Trie();
    	
    	int alphabet_size = 26; 
    	
    	String keys[] = {"helena", "olivia", "eduardo", "rodolfo", "maria", "jose", "joao", "pedro", "heleno", "helen"};
       
        Node root = new Node(alphabet_size);
        
        // inserção
        for (int i = 0; i < keys.length ; i++)
        	trie.insert(keys[i], root, alphabet_size);
        
        String[] alfabeto = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", 
        					 "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        
        // imprime chaves
        trie.printAllKeys(root, alfabeto, "");
        
        // busca
        boolean result = trie.search("heleno", root);
        System.out.println(result);
        
        // remocao
        Node node = trie.remove(root, "heleno", 0, alphabet_size);
        System.out.println(node);
        
        // busca
        result = trie.search("heleno", root);
        System.out.println(result);
        
        // imprime chaves
        trie.printAllKeys(root, alfabeto, "");
        
        
    }
	
}
