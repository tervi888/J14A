package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void removeWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product prod1 = new Product(22, "маркер", 5000);
        Product prod2 = new Product(33, "краска", 3000);
        Product prod3 = new Product(44, "кисть", 50000);

        repo.add(prod1);
        repo.add(prod2);
        repo.add(prod3);
        repo.remove(33);
        Product[] expected = {prod1, prod3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void removeWhenProductNoExist() {
        ShopRepository repo = new ShopRepository();
        Product prod1 = new Product(22, "маркер", 5000);
        Product prod2 = new Product(33, "краска", 3000);
        Product prod3 = new Product(44, "кисть", 50000);

        repo.add(prod1);
        repo.add(prod2);
        repo.add(prod3);
        Assertions.assertThrows(RuntimeException.class, () -> repo.remove(55) );

    }
}
