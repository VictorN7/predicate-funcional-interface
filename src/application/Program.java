package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import entity.Product;
import util.ProductPredicate;

public class Program {

    public static void main(String[] args) {

        // Define o padrão de localização para formatação de números
        Locale.setDefault(Locale.US);

        // Criação da lista de produtos
        List<Product> list = new ArrayList<>();

        list.add(new Product("SSD", 90.0));
        list.add(new Product("Notebook", 800.0));
        list.add(new Product("Tablet", 400.0));
        list.add(new Product("Microphone", 50.0));

        // x representa cada Product da lista
        // removeIf remove os produtos cujo preço seja maior ou igual a 100
        // list.removeIf(x -> x.getPrice() >= 100);

        // ---------------------------------------------------
        // Diferentes formas de utilizar Predicate com removeIf

        // Utiliza uma implementação concreta da interface Predicate<Product>
        list.removeIf(new ProductPredicate());

        // Method reference apontando para um método estático da classe Product
        list.removeIf(Product::staticProductPredicate);

        // Method reference para um método de instância, aplicado a cada elemento da lista
        // Internamente equivale a: p -> p.nonstaticProductPredicate()
        list.removeIf(Product::nonstaticProductPredicate);

        // Expressão lambda atribuída a um Predicate e reutilizada no removeIf
        Predicate<Product> predicate = p -> p.getPrice() >= 100.0;
        list.removeIf(predicate);

        // Expressão lambda inline passada diretamente como argumento do removeIf
        list.removeIf(p -> p.getPrice() >= 100);

        // ---------------------------------------------------
        // Formas de percorrer a lista

        // Enhanced for (for-each tradicional)
        for (Product p : list) {
            System.out.println(p);
        }

        // A lista possui o método forEach
        // Method reference é uma forma abreviada da lambda que apenas delega para um método existente
        list.forEach(System.out::println);
    }
}