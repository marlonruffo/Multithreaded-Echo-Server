# **Trabalho 1 da disciplina de Redes de Computadores DCC042-2022.3**

# Servidor Multithread com protocolo simples 



#### Desenvolvedores / matrícula:

* Marlon Ruffo Nascimento  202065165AC
* Matheus do Nascimento Pereira da Costa  201676003
* Deyvison Otaviano Fernandes  201976016

## Instruções:

 1) Run EchoServer.java (Servidor)
 2) Run EchoClient.java (Cliente)
 - Caso queira inicializar mais de um cliente, basta fazer o passo #2 novamente.
 3) Para enviar uma mensagem para o Servidor, é necessário que sua mensagem comece com a palavra "echo", prosseguido da mensagem desejada, (isso foi determinado pelo protocolo).
 4) Para finalizar uma conexão com um cliente, basta digitar "quit" e enviar a mensagem.

 - Cada vez que o passo #2 for efetuado, o Servidor recebe a mensagem indicando que um Cliente aceitou a conexão.

 - Se a mensagem enviada pelo Cliente começar com "echo", o servidor receberá com sucesso a mensagem e responderá o cliente com a mesma mensagem.

 - Se a mensagem enviada pelo Cliente não seguir o protocolo determinado, o Servidor receberá uma mensagem indicando a falha e o Cliente será informado que a mensagem pretendida não foi enviada por não ter o protocolo necessário.
 - Se a mensagem enviada pelo Cliente for "quit", o Cliente receberá a mensagem de que a conexão foi encerrada e o Servidor dirá que uma conexão com o cliente foi encerrada.

