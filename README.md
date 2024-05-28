# Componente Gerador de Certificados

## 📝 Visão Geral
O componente Gerador de Certificados foi desenvolvido para facilitar a criação de certificados para participantes de eventos. Ele permite a geração de certificados a partir de uma lista de participantes ou de um arquivo Excel contendo informações dos participantes. Os certificados são personalizados com base no tipo de evento e incluem detalhes do participante, como nome, nome do evento e horas de participação.

## 🚀 Uso
O componente consiste nas seguintes classes:

**`CertificateGenerator`**: Responsável por gerar certificados a partir de uma lista de participantes ou de um arquivo Excel.

**`Generator`**: Encarregado da criação e personalização dos certificados em formato PDF.

**`Participante`**: Representa um participante, armazenando seus detalhes, como nome, e-mail, nome do evento, arquivo de certificado e horas de participação.

**`ParticipanteService`**: Fornece funcionalidade para ler informações dos participantes de um arquivo Excel.

## 🎨 Recursos
- **Gerar Certificados a partir de uma Lista**: Permite a geração de certificados para uma lista de participantes fornecida pelo usuário.

- **Gerar Certificados a partir de um Arquivo Excel**: Possibilita a geração de certificados lendo as informações dos participantes de um arquivo Excel.

- **Design do Certificado Personalizável**: Os certificados são personalizados com base no tipo de evento, com imagens de fundo e formatação de texto diferentes.

- **Suporte à Concorrência**: Utiliza multithreading para melhorar o desempenho ao processar informações dos participantes a partir de arquivos Excel.
  
- **Gerar Certificados a partir de um Arquivo Excel**: Chame o método generateCertificatesFromFile, passando o arquivo Excel contendo as informações dos participantes.

- **Personalizar o Design do Certificado**: Modifique o método customizeCertificate na classe Generator para ajustar o design do certificado de acordo com suas necessidades.

## 🔍 Como Usar

Execute o comando de construção do Maven (`mvn package`) para gerar o arquivo JAR (ou Execute Como, Instalação Maven). O Maven irá compilar seu código, resolver dependências e criar o arquivo JAR de acordo com a configuração especificada no arquivo `pom.xml`; então, você poderá adicioná-lo ao seu projeto.

- **Instanciar `CertificateGenerator`**: Crie uma instância de CertificateGenerator fornecendo o caminho de saída onde os certificados gerados serão salvos.

- **Gerar Certificados a partir de uma Lista ou uma Planilha**: Chame o método `generateCertificatesFromList` ou `generateCertificatesFromFile`, passando uma lista de objetos Participante representando os participantes. Por exemplo:

```java
CertificateGenerator certificateGenerator = new CertificateGenerator("output/path");

List<Participante> participants = new ArrayList<>();
participants.add(new Participante("John Doe", "john@example.com", "Seminário de Engenharia de Software", 10));
participants.add(new Participante("Jane Smith", "jane@example.com", "Seminário de Engenharia de Software", 8));

certificateGenerator.generateCertificatesFromList(participants);

```

- **Referência de utilização**: https://github.com/CertificateGenerator/CertificateGeneratorSystem

## 🤝 Contribuições
Este projeto é de código aberto e aceita contribuições da comunidade. Se você deseja contribuir para a melhoria deste componente, você pode seguir estas etapas:

- **Fork do Repositório**: Faça um fork deste repositório para sua própria conta.

- **Clone o Repositório**: Clone o repositório forkado para sua máquina local.

- **Desenvolva**: Implemente as alterações, correções de bugs ou novos recursos em seu próprio fork.

- **Envie um Pull Request**: Quando estiver satisfeito com suas alterações, envie um Pull Request para o repositório original.

- **Revisão**: As alterações serão revisadas pelos mantenedores do projeto. Se necessário, ajustes podem ser solicitados.

- **Merge**: Após a revisão e aprovação, suas alterações serão mescladas ao repositório principal.

