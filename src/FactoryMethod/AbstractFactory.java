package FactoryMethod;

public interface AbstractFactory {
    Brush getProduct(String className);
}
