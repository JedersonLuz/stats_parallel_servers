# stats_parallel_servers

Sistema distribuído, com uso de middleware, para realizar operações de estatística básica. Os serviços nos servidores utilizam uma interface RESTful para comunicação.

## Iniciando o sistema

### Requisitos

Possuir o Android Studio e o NetBeans EE instalados.

### Execução

Inicialmente, o IP do Middleware deve ser inserido no cliente android. Em seguida, os IPs dos servidores de média e mediana devem ser definidos no Middleware, para que ele envie as requisições para os hosts corretos.

Os números de entrada ficam no Middleware, sendo assim, podem ser manipulados por lá. Com a entrada estabelecida, as classes do projeto podem ser compiladas.

Para executar o servidor de Middleware:

    java Middleware
    
Para executar o servidor RESTful de média e mediana, é necessário fazer a implantação de cada projeto e depois executá-los.

Com os servidores prontos, é só pressionar o botão "Calcular" no app e os dados serão exibidos na tela.

## Desenvolvedores

* Açucena Rodrigues dos Santos Soares - [acucenarodrigues1998](<https://github.com/acucenarodrigues1998/>)
* Jederson Sousa Luz - [JedersonLuz](<https://github.com/JedersonLuz/>)
* Vitória de Carvalho Brito - [VitoriaCarvalho](<https://github.com/VitoriaCarvalho/>)

## Licença

[MIT](https://github.com/JedersonLuz/stats_parallel_servers/blob/master/LICENSE)
