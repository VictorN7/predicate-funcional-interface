# 📘 Predicate, Lambda Expressions e Method Reference

Este código tem como objetivo **demonstrar de forma prática**, diferentes maneiras de utilizar a interface funcional **Predicate** em conjunto com o método `removeIf`, além de apresentar formas de percorrer coleções em Java.

O código é focado em **Java 8+**, explorando recursos de programação funcional aplicados às Collections.

---

## 🧠 Conceitos abordados

* Interface funcional **Predicate**
* Método `removeIf` da interface `Collection`
* **Expressões Lambda**
* **Method Reference** (métodos estáticos e de instância)
* Iteração com **enhanced for** e `forEach`
* Manipulação de listas com `ArrayList`

---

## 📂 Estrutura do projeto

```
src/
 ├── application/
 │    └── Program.java
 ├── entity/
 │    └── Product.java
 └── util/
      └── ProductPredicate.java
```

---

## 📦 Entidade Product

A classe `Product` representa um produto simples, contendo:

* `name` — nome do produto
* `price` — preço do produto

Essa entidade é utilizada para demonstrar:

* Comparações baseadas em regras de negócio
* Uso de `Predicate<Product>`
* Impressão dos objetos utilizando `toString()`

### ⚠️ IMPORTANTE: para operações como `remove`, `removeAll`, `contains` ou uso em `Set` e `Map`, é recomendado sobrescrever os métodos `equals()` e `hashCode()`.

---

## 🔍 Método removeIf

O método `removeIf` pertence à interface `Collection` e recebe um **Predicate** como argumento.

```java
boolean test(T t);
```

* Se o `Predicate` retornar `true`, o elemento é removido da coleção
* Se retornar `false`, o elemento é mantido

---

## 🧪 Diferentes formas de usar Predicate

O projeto demonstra **várias abordagens equivalentes**, todas removendo produtos cujo preço seja maior ou igual a 100.

### 🔹 1. Predicate em classe concreta

```java
list.removeIf(new ProductPredicate());
```

* A lógica de remoção está encapsulada em uma classe que implementa `Predicate<Product>`
* Abordagem mais verbosa, porém clara e reutilizável

---

### 🔹 2. Method reference para método estático

```java
list.removeIf(Product::staticProductPredicate);
```

* Referência direta a um método estático
* O método deve ter assinatura compatível com `Predicate<Product>`

---

### 🔹 3. Method reference para método de instância

```java
list.removeIf(Product::nonstaticProductPredicate);
```

Internamente, o Java interpreta como:

```java
p -> p.nonstaticProductPredicate();
```

---

### 🔹 4. Lambda atribuída a um Predicate

```java
Predicate<Product> predicate = p -> p.getPrice() >= 100.0;
list.removeIf(predicate);
```

* A expressão lambda pode ser reutilizada
* Útil quando a regra é aplicada em mais de um ponto

---

### 🔹 5. Lambda inline

```java
list.removeIf(p -> p.getPrice() >= 100);
```

* Forma mais concisa
* Ideal para regras simples e locais

---

## 🔁 Percorrendo a lista

### Enhanced for (for-each tradicional)

```java
for (Product p : list) {
    System.out.println(p);
}
```

* Estrutura clássica de iteração
* Clara e amplamente utilizada

---

### forEach com Method Reference

```java
list.forEach(System.out::println);
```

* Abordagem funcional
* Código mais enxuto e declarativo

---

## 📌 Objetivo

Este código foi criado com o objetivo de:

* Consolidar o uso de **Predicate e lambda expressions**
* Entender como o `removeIf` funciona internamente
* Comparar diferentes estilos de implementação
* Servir como material de estudo e revisão para Java intermediário

---
