## Projeto Dicionário - POO

### Projeto 1 - Sistema de Tradução de Palavras de Informática (TRAIN)

*(grupo de 2 alunos)*

---

### **Objetivo**

Desenvolver na linguagem Java um sistema de tradução de palavras de informática (TRAIN), para realizar a tradução de palavras de informática de diferentes idiomas para o português e vice-versa. As palavras de um idioma x devem estar armazenadas em um arquivo texto `x.csv` no formato:

`palavraidioma;palavraportuguês`

---

### **Tarefas**

1. **Criar a classe Dicionario** com os seguintes métodos públicos:
    - **`Dicionario(x)`**
        
        Cria um objeto `Dicionario` e define o parâmetro `x` como sendo o idioma corrente. Lança exceção caso o idioma `x` não exista.
        
    - **`ArrayList<String> traduzirParaPortugues(termo)`**
        
        Realiza uma busca exata do termo nas palavras do idioma corrente e retorna uma lista das respectivas palavras traduzidas para o português (ou uma lista vazia).
        
    - **`ArrayList<String> traduzirParaIdioma(termo)`**
        
        Realiza uma busca exata do termo nas palavras em português e retorna uma lista das respectivas palavras traduzidas para o idioma corrente (ou uma lista vazia).
        
    - **`ArrayList<String> localizarPalavraIdioma(termo)`**
        
        Realiza uma busca parcial do termo nas palavras do idioma corrente e retorna uma lista das palavras encontradas (ou uma lista vazia).
        
    - **`ArrayList<String> localizarPalavraPortugues(termo)`**
        
        Realiza uma busca parcial do termo nas palavras em português e retorna uma lista das palavras encontradas (ou uma lista vazia).
        
    - **`ArrayList<String> getIdiomas()`**
        
        Retorna a lista de idiomas permitidos no sistema.
        
    - **`void setIdioma(x)`**
        
        Define o parâmetro `x` como sendo o idioma corrente. Lança exceção caso o idioma `x` não exista.
        
    
    **Observações:**
    
    - As palavras dos arquivos, bem como os termos de busca, não podem conter acentos, cedilha ou qualquer símbolo especial.
    - Uma palavra pode ter várias traduções tanto para um idioma quanto para o português.
    - Os idiomas são identificados por uma `String` (ex.: "inglês", "espanhol", "alemão").
    - Utilizar apenas `ArrayList` como lista e `Scanner` como leitor de arquivo.
    - Os arquivos dos idiomas devem ser colocados no pacote `dados`.
    - Os arquivos das imagens dos países devem ser colocados no pacote `imagens`.

---

1. **Criar a aplicação gráfica TelaDicionário** para manipular a classe `Dicionario` com os seguintes componentes visuais:
    
    a) **JFrame** com layout **Absolute**.
    
    b) **JTextField** para digitação da palavra a ser traduzida.
    
    c) **JButton** para:
    
    - Traduzir a palavra digitada (do idioma corrente para o português ou vice-versa).
    - Localizar a palavra digitada (no idioma corrente ou em português).
    
    d) **JTextArea** para exibir os resultados da tradução/localização da palavra digitada, juntamente com a quantidade de resultados.

    e) **JComboBox** para o usuário alterar o idioma corrente.
    f) **JLabel** para:
    - Exibir a imagem da bandeira do país do idioma corrente.
    - Exibir mensagens do sistema para o usuário.

---

### **Pontuação**

- **Classe Dicionario** - 30 pontos
- **Classe TelaDicionario** - 20 pontos
- **Apresentação individual** *(obrigatória para receber nota)* - 50 pontos