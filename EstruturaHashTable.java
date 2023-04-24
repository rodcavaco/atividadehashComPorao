package hashColisao;

public class EstruturaHashTable implements EstruturaDeDados {

    private Integer tabela[];
    private Integer porao[];

    public EstruturaHashTable() {
        tabela = new Integer[1000];
        porao = new Integer[100];
    }

    @Override
    public boolean insert(int chave) {
        int posicao = chave % 1000;
        if (tabela[posicao] != null) {
            int posicaoPorao = posicao % 100;
            for (int i = 0; i < porao.length; i++) {
                if (porao[(posicaoPorao + i) % 100] == null) {
                    porao[(posicaoPorao + i) % 100] = chave;
                    return true;
                }
            }
            return false;
        }
        tabela[posicao] = chave;
        return true;
    }

    @Override
    public boolean delete(int chave) {
        int posicao = chave % 1000;
        if (tabela[posicao] != null && tabela[posicao] == chave) {
            tabela[posicao] = null;
            return true;
        } else {
            int posicaoPorao = posicao % 100;
            for (int i = 0; i < porao.length; i++) {
                if (porao[(posicaoPorao + i) % 100] != null && porao[(posicaoPorao + i) % 100] == chave) {
                    porao[(posicaoPorao + i) % 100] = null;
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public int search(int chave) {
        int posicao = chave % 1000;
        if (tabela[posicao] != null && tabela[posicao] == chave) {
            return posicao;
        } else {
            int posicaoPorao = posicao % 100;
            for (int i = 0; i < porao.length; i++) {
                if (porao[(posicaoPorao + i) % 100] != null && porao[(posicaoPorao + i) % 100] == chave) {
                    return i + 1000;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        EstruturaHashTable hashTable = new EstruturaHashTable();

        System.out.println (hashTable.insert(415));
        System.out.println (hashTable.insert(817));
        System.out.println (hashTable.insert(210));
        System.out.println (hashTable.insert(900));
        System.out.println (hashTable.insert(1184));

        System.out.println (hashTable.search(415));
        System.out.println (hashTable.search(817));
        System.out.println (hashTable.search(210));
        System.out.println (hashTable.search(789));
        System.out.println (hashTable.search(555));

        System.out.println (hashTable.delete(415));
        System.out.println (hashTable.delete(817));
        System.out.println (hashTable.delete(210));
        System.out.println (hashTable.delete(555));

        System.out.println (hashTable.search(415));
        System.out.println (hashTable.search(817));
        System.out.println (hashTable.search(210));
        System.out.println (hashTable.search(1184));
    }
}
