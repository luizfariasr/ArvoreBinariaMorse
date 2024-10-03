// Classe que representa um nó da árvore binária
class No {
    char valor;
    No esquerda, direita;

    public No(char valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}

// Classe principal que contém a árvore binária para código Morse
public class ArvoreBinariaMorse {
    private No raiz;

    // Construtor para inicializar a árvore com o nó raiz
    public ArvoreBinariaMorse() {
        raiz = new No(' '); // O nó raiz é vazio
        popularArvore();
    }

    // Método para popular a árvore com os códigos Morse
    private void popularArvore() {
        // Nível 1
        raiz.esquerda = new No('E');
        raiz.direita = new No('T');

        // Nível 2
        raiz.esquerda.esquerda = new No('I');
        raiz.esquerda.direita = new No('A');
        raiz.direita.esquerda = new No('N');
        raiz.direita.direita = new No('M');

        // Nível 3
        raiz.esquerda.esquerda.esquerda = new No('S');
        raiz.esquerda.esquerda.direita = new No('U');
        raiz.esquerda.direita.esquerda = new No('R');
        raiz.esquerda.direita.direita = new No('W');
        raiz.direita.esquerda.esquerda = new No('D');
        raiz.direita.esquerda.direita = new No('K');
        raiz.direita.direita.esquerda = new No('G');
        raiz.direita.direita.direita = new No('O');

        // Nível 4
        raiz.esquerda.esquerda.esquerda.esquerda = new No('H');
        raiz.esquerda.esquerda.esquerda.direita = new No('V');
        raiz.esquerda.esquerda.direita.direita = new No('F');
        raiz.esquerda.direita.direita.direita = new No('J');
        raiz.direita.esquerda.esquerda.esquerda = new No('B');
        raiz.direita.esquerda.esquerda.direita = new No('X');
        raiz.direita.esquerda.direita.esquerda = new No('C');
        raiz.direita.esquerda.direita.direita = new No('Y');
        raiz.direita.direita.esquerda.esquerda = new No('Z');
        raiz.direita.direita.esquerda.direita = new No('Q');
    }

    // Método para decodificar o código Morse em texto
    public String decodificarMorse(String codigo) {
        No atual = raiz;
        for (char sinal : codigo.toCharArray()) {
            if (sinal == '.') {
                atual = atual.esquerda;
            } else if (sinal == '-') {
                atual = atual.direita;
            }

            // Se não houver mais nós, retorna vazio
            if (atual == null) {
                return "";
            }
        }
        return String.valueOf(atual.valor);
    }

    // Método para codificar uma letra ou número em código Morse
    public String codificarTexto(String texto) {
        StringBuilder morse = new StringBuilder();
        for (char letra : texto.toUpperCase().toCharArray()) {
            morse.append(codificarLetra(letra)).append(" ");
        }
        return morse.toString().trim();
    }

    // Método auxiliar para codificar uma única letra em código Morse
    private String codificarLetra(char letra) {
        switch (letra) {
            case 'A': return ".-";
            case 'B': return "-...";
            case 'C': return "-.-.";
            case 'D': return "-..";
            case 'E': return ".";
            case 'F': return "..-.";
            case 'G': return "--.";
            case 'H': return "....";
            case 'I': return "..";
            case 'J': return ".---";
            case 'K': return "-.-";
            case 'L': return ".-..";
            case 'M': return "--";
            case 'N': return "-.";
            case 'O': return "---";
            case 'P': return ".--.";
            case 'Q': return "--.-";
            case 'R': return ".-.";
            case 'S': return "...";
            case 'T': return "-";
            case 'U': return "..-";
            case 'V': return "...-";
            case 'W': return ".--";
            case 'X': return "-..-";
            case 'Y': return "-.--";
            case 'Z': return "--..";
            case '1': return ".----";
            case '2': return "..---";
            case '3': return "...--";
            case '4': return "....-";
            case '5': return ".....";
            case '6': return "-....";
            case '7': return "--...";
            case '8': return "---..";
            case '9': return "----.";
            case '0': return "-----";
            default: return "";
        }
    }

    // Método principal para testes
    public static void main(String[] args) {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();

        // Exemplo de decodificação de código Morse
        String codigo = "..."; // S
        System.out.println("Decodificando Morse: " + codigo + " -> " + arvore.decodificarMorse(codigo));

        // Exemplo de codificação de texto
        String texto = "SOS";
        System.out.println("Codificando Texto: " + texto + " -> " + arvore.codificarTexto(texto));
    }
}
