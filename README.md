# Melhor de Todos - Avaliação N2

Aplicativo Android desenvolvido com Jetpack Compose para escolher aleatoriamente o "Melhor de Todos".

## Funcionalidades

### 1. Tela de Login
- Campos de usuário e senha
- Validação de campos preenchidos
- Design moderno com tema escuro
- Navegação para a tela principal após login

### 2. Tela Principal
- Mensagem: "Temos que escolher um novo Melhor de Todos!"
- Botão para escolher aleatoriamente um candidato
- Exibição do vencedor com imagem e nome
- Mensagem: "[Nome] é o novo Melhor de Todos!"

## Candidatos

O aplicativo possui 5 candidatos, cada um com sua cor representativa:

- **Guilherme** - Verde (guilherme.xml)
- **Cauã** - Azul (caua.xml)
- **Madu** - Rosa (madu.xml)
- **Pablo** - Laranja (pablo.xml)
- **Cachorro** - Roxo (cachorro.xml)

## Estrutura do Projeto

```
app/src/main/
├── java/com/outracoisa/melhordetodosn2/
│   ├── MainActivity.kt          # Activity principal com navegação
│   └── ui/theme/                # Tema do Jetpack Compose
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
├── res/
│   └── drawable/                # Imagens dos candidatos
│       ├── guilherme.xml
│       ├── caua.xml
│       ├── madu.xml
│       ├── pablo.xml
│       └── cachorro.xml
```

## Tecnologias Utilizadas

- **Kotlin**
- **Jetpack Compose** - UI moderna e declarativa
- **Material 3** - Design system do Google
- **Navigation Compose** - Navegação entre telas
- **Compose BOM** - Gerenciamento de versões do Compose

## Como Executar

1. Abra o projeto no Android Studio
2. Aguarde o Gradle sincronizar as dependências
3. Execute o aplicativo em um emulador ou dispositivo físico
4. Faça login (qualquer usuário/senha válidos)
5. Clique no botão para escolher o melhor de todos!

## Requisitos Atendidos

✅ Aplicativo funcional apresentado em sala
✅ Uso adequado de textos, ícones, cores e espaçamentos
✅ Tela de login vinculada à tela principal
✅ Escolha aleatória do "Melhor de Todos"
✅ Código-fonte no GitHub

## Observações

- As imagens dos candidatos são representadas por formas coloridas (XML drawables)
- Você pode substituir os arquivos XML em `res/drawable/` por imagens reais (PNG/JPG) se desejar
- O design segue um tema escuro moderno e profissional

---

**Desenvolvido para a disciplina de Programação para Dispositivos Móveis**
**Instituto Federal do Ceará - Campus Ceará**
