# test-doubles
Projeto simples exemplificando os 3 principais 'Test Doubles' do TDD: Mock, Stub e Fake

## O que é Test Double?
Test Double é qualquer objeto que finge ser um objeto real para fins de testes. São usados para simular uma dependência externa ao nosso *SUT (System under Test)*, ou qualquer outro elemento real em um teste. A palavra double remete a Dublê de Cinema.

### Mocks
Mocks são objetos que utilizamos para “simular” **interações de saída** com dependências externas ao nosso teste. Essas interações de saída são chamadas que o nosso teste realiza para mudar o seu estado.

Com mocks podemos controlar e inspecionar as chamadas para essa *falsa dependência*. O Mock simula seu comportamento verificando se um ou mais métodos foram ou não chamados, a ordem de chamadas destes métodos, se esses métodos foram chamados com os argumentos certos, e quantas vezes foram chamados.

**Para que devemos usar Mocks?**
- Para testar se um ou mais métodos de uma dependência externa foi chamado corretamente;
- Testar quantas vezes esses métodos foram chamados;
- Testar se esses métodos foram chamados com os parâmetros corretos.

**Para que não devemos usar Mocks?**
- Para testar valores retornados por uma função;
- Para testar comportamentos de uma função.

### Stubs
Stubs são objetos que usamos para simular **interações de chegada** de alguma dependência externa ao *SUT*. Diferente do Mock, stubs são objetos com respostas prontas para serem usados no nosso teste. Eles não sabem responder quantas vezes um método de uma dependência externa foi ou não chamado e quais parâmetros foram usados, apenas trazem resposta prontas.

**Para que devemos usar Stubs?**
- Para testar retornos de uma dependência externa;
- Testar o comportamento do nosso SUT frente aos diferentes retornos da API. Por exemplo, retornos de sucesso, falhas ou exceções.

### Fakes
Fakes são objetos implementados de maneira funcional, mas não da mesma forma que em produção. Normalmente eles funcionam via *atalhos*, sendo uma versão mais simples do que o código de produção.
Um exemplo desses *atalhos* pode ser uma **implementação em memória** de uma base de dados. Esta implementação falsa não envolverá banco de dados, mas usará uma coleção simples de dados armazenados. Isso permite testes de integração de serviços sem ter que iniciar um banco de dados com requisições mais demoradas.

Créditos dos textos: [Pable R. Darle](https://medium.com/rd-shipit/test-doubles-mocks-stubs-fakes-spies-e-dummies-a5cdafcd0daf) e [Michal Lipski](https://blog.pragmatists.com/test-doubles-fakes-mocks-and-stubs-1a7491dfa3da)
