# Algoritmo Coloração de Grafos

Este algoritmo foi desenvolvido com o intuito de demonstrar o problema da coloração de grafos, neste caso, usando o algoritmo guloso como exemplo.

O algoritmo guloso colore os vértices em ordem, tentando usar o menor número de cores possível, resolvendo o problema ao tomar decisões localmente ótimas, esperando que isso leve a uma solução aceitável.

## Como funciona?

- Estratégia local:
Para cada vértice, o algoritmo atribui a ele a primeira cor disponível que não conflita com os vértices adjacentes.

- Decisão independente:
O algorítmo não analisa o grafo completo para encontrar o menor número de cores necessário, ele simplesmente escolhe uma cor válida para o vértice atual, sem considerar se isso pode levar ao uso desnecessário de mais cores no futuro.

## Limitações:

O algoritmo guloso **não garante** o uso do númeor mínimo de cores possíveis, podendo usar mais cores que o necessário como nos casos de:

- O grafo for processado em uma ordem desfavorável

- O grafo contiver uma alta densidade de arestas

## Como compilar?

### Windows

Gere o .jar com o comando ".\gradlew clean build"

### Linux

Gere o .jar com o comando "./gradlew clean build"

## Como executar?

Após gerar o .jar, ele será enviado a pasta build/libs, basta executar o arquivo :D 
