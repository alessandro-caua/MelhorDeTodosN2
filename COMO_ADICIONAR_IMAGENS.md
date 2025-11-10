# Como Adicionar Imagens Reais aos Candidatos

Atualmente, o aplicativo usa formas coloridas XML para representar os candidatos. Se você quiser usar fotos reais, siga estas instruções:

## Passo 1: Preparar as Imagens

1. Tenha as 5 fotos dos candidatos:
   - guilherme.jpg (ou .png)
   - caua.jpg
   - madu.jpg
   - pablo.jpg
   - cachorro.jpg

2. Redimensione as imagens para um tamanho razoável (ex: 500x500 pixels)

## Passo 2: Adicionar as Imagens ao Projeto

### Opção A: Usando o Android Studio
1. Abra o projeto no Android Studio
2. No painel esquerdo, navegue até `app/src/main/res/drawable`
3. Clique com botão direito em `drawable` → New → Image Asset
4. Ou simplesmente arraste as imagens para a pasta `drawable`

### Opção B: Manualmente
1. Copie os arquivos de imagem para:
   ```
   c:\Users\Aless\AndroidStudioProjects\MelhorDeTodosN2\app\src\main\res\drawable\
   ```

2. Renomeie os arquivos para corresponder aos nomes corretos:
   - guilherme.jpg → guilherme.jpg (substitui o guilherme.xml)
   - caua.jpg → caua.jpg (substitui o caua.xml)
   - madu.jpg → madu.jpg (substitui o madu.xml)
   - pablo.jpg → pablo.jpg (substitui o pablo.xml)
   - cachorro.jpg → cachorro.jpg (substitui o cachorro.xml)

## Passo 3: Deletar os XMLs Antigos

Delete os arquivos XML coloridos:
- guilherme.xml
- caua.xml
- madu.xml
- pablo.xml
- cachorro.xml

## Passo 4: Atualizar o Código (Opcional)

Se você usar arquivos JPG ou PNG, certifique-se de que os nomes no código estejam corretos. O Android automaticamente reconhece `.jpg` e `.png` e os torna acessíveis via `R.drawable.nome`.

No arquivo `MainActivity.kt`, a linha:
```kotlin
val pessoas = listOf(
    Pessoa("Guilherme", R.drawable.guilherme),
    Pessoa("Cauã", R.drawable.caua),
    ...
)
```

Já está correta e funcionará automaticamente!

## Dicas

- Use imagens quadradas (mesmo width e height)
- Mantenha o tamanho razoável (não mais que 1MB por imagem)
- Formato recomendado: PNG para melhor qualidade
- Nomes dos arquivos devem ser em minúsculas e sem caracteres especiais
- Use underscore (_) ao invés de espaços

## Nota Importante

⚠️ **ATENÇÃO**: No Android, nomes de recursos não podem ter acentos ou caracteres especiais!
- ✅ Correto: `caua.jpg`, `guilherme.png`
- ❌ Errado: `cauã.jpg`, `Guilherme.PNG`

Se o nome original tiver acento, você precisa removê-lo no nome do arquivo!
