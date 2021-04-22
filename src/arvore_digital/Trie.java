package arvore_digital;

public class Trie {

	/**
	 * Inserção de uma chave na árvore digital
	 * @param x Chave a ser inserida
	 * @param root Raíz da árvore
	 * @param alphabet_size tamanho do alfabeto
	 */
    public void insert(String x, Node root, int alphabet_size) {

        Node current = root;
        
        // busca pela posição da chave
        for (int pDig = 0; pDig < x.length(); pDig++) {
        	
            int j = x.charAt(pDig) - 'a'; // seja j a posição de d(h) na ordenação do alfabeto
            
            if (current.filhos[j] == null)
            	current.filhos[j] = new Node(alphabet_size);
       
            current = current.filhos[j];
        }
        
        // marca o node inserido como terminal
        current.terminal = true;
    }
    
    
    /**
     * Busca de uma chava em uma árvore digital
     * @param x Chave buscada
     * @param root Raíz da árvore
     * @return true se encontrar chave, false se nao encontrar
     */
    public boolean search(String x, Node root) {
    	
        Node current = root;
       
        // para cada digito da chave (pDig é a posicao do digito)
        for (int pDig = 0; pDig < x.length(); pDig++) {
        	
        	// posicao do digito d no alfabeto
			// por exemplo: o digito d = 2, então ele está na 1 posicao no alfabeto 2,3,4
        	// como o nosso alfabeto sao as letras de 'a' a 'z' podemos achar essa posicao 
        	// atraves da tabela ASCII
            int j = x.charAt( pDig ) - 'a';
            
            if (current.filhos[j] == null)
                return false; // o elemento nao esta na arvore
       
            current = current.filhos[j];
        }
        
        // verifica se o node eh terminal, se for achou, senao nao esta na arvore
        return (current != null && current.terminal);
        
    }

    /**
     * Verifica se um node tem filhos
     * @param node Node a ser checado
     * @param alphabet_size Tamanho do alfabeto
     * @return true se tiver, false se não tiver
     */
    public boolean hasChildren(Node node, int alphabet_size){
        
    	for (int i = 0; i < alphabet_size; i++) {
    		
    		if( node.filhos[i] != null ) {
    			return true;
    		}
    		
    	}
    	
    	return false;
    	
    }
    
    /**
     * Remoção de uma chave em árvore digital
     * @param node Node corrente analisado (inicia com a raíz)
     * @param x Chave a ser removida
     * @param pos Posição corrente analisada (inicia com 0)
     * @param alphabet_size Tamanho do alfabeto
     * @return o node removido
     */
    Node remove(Node node, String x, int pos, int alphabet_size){
     
    	// se a arvore eh vazia
    	if (node == null)
    		return null;
  
    	// se o ultimo caractere da chave estiver sendo processado
    	// ou seja, se a altura da árvore for o tamanho da chave
    	if ( pos == x.length() ) {
  

    		// set o marcador de terminal desse node para false
    		node.terminal = false;
    		
    		
    		// se o node corrente nao tiver filhos
    		// ou seja, nao eh prefixo de outra palavra
    		if ( !hasChildren(node, alphabet_size) ) {
    			node = null;
    		}
  
    		return node;
    		
    	}
    	
    	// se nao for o ultimo caractere da key, vamos para o filho
    	// para saber a posição do filho, o já conhecido uso do ASCII para obter o index
    	int j = x.charAt( pos ) - 'a';
    	node.filhos[j] = remove(node.filhos[j], x, pos + 1, alphabet_size);
    	
    	// se o node nao tiver nenhum filho (ja deletamos em outra iteracao)
    	// e tambem nao eh o fim de alguma outra palavra
    	if (!hasChildren(node, alphabet_size) && node.terminal == false) {
    		node = null;
    	}
  
    	return node;
    	
    }
    
    /**
     * Imprime todas as chaves
     * @param node Node corrente (inicia com a raíz)
     * @param alfabeto Alfabeto considerado
     * @param prefix Prefixo já percorrido (inicia com string vazia)
     */
    public void printAllKeys(Node node, String[] alfabeto, String prefix){
    	
    	// percorre todo o alfabeto
    	for (int alp = 0; alp < alfabeto.length; alp++) {
    		
    		if( node.filhos[alp] != null ){
    			
    			// imprime o prefixo com a letra quando o node for terminal
    			if( node.filhos[alp].terminal ){
    				System.out.println(prefix+alfabeto[alp]);	
    			}
    			// chamada recursiva para o node filho
    			printAllKeys(node.filhos[alp], alfabeto, prefix+alfabeto[alp]);
    			
    		}
    		
    	}
    	
    }
    
}
