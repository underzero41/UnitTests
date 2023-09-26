package seminars.second.simple_shopping_cart;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    Shop shop;
    Cart cart;
    Product product;

    List<Product> getStoreItems() {
        List<Product> products = new ArrayList<>();

// Три массива Названия, Цены, Кол-во
        String[] productNames = {"bacon", "beef", "ham", "salmon", "carrot", "potato", "onion", "apple", "melon", "rice", "eggs", "yogurt"};
        Double[] productPrice = {170.00d, 250.00d, 200.00d, 150.00d, 15.00d, 30.00d, 20.00d, 59.00d, 88.00d, 100.00d, 80.00d, 55.00d};
        Integer[] stock = {10, 10, 10, 10, 10, 10, 10, 70, 13, 30, 40, 60};

        // Последовательно наполняем список продуктами
        for (int i = 0; i < productNames.length; i++) {
            products.add(new Product(i + 1, productNames[i], productPrice[i], stock[i]));
        }

        // тоже самое
        // Product product = new Product(1,"bacon", 170.00d, 10);
        // products.add(product);
        return products;
    }

    @BeforeEach
    void prepareData(){
        shop = new Shop(getStoreItems());
        cart = new Cart(shop);
    }


    @Test
    void getTotalPriceDifferentProductTest() {
        cart.addProductToCartByID(10);
        cart.addProductToCartByID(10);
        cart.addProductToCartByID(10);
        cart.removeProductByID(10);
        assertThat(cart.getTotalPrice()).isEqualTo(0);
    }

    @Test
    void getTotalQuantityShopTest() {
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(2);
        cart.addProductToCartByID(3);
        shop.getProductsShop().get(0).getQuantity();
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(9);
        assertThat(shop.getProductsShop().get(1).getQuantity()).isEqualTo(9);
        assertThat(shop.getProductsShop().get(2).getQuantity()).isEqualTo(9);
    }

    @Test
    void lastProductDisapearTest(){
        for (int i = 0; i < 11; i++) {
            cart.addProductToCartByID(1);
        }

        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(0);
        assertThat(cart.cartItems.get(0).getQuantity()).isEqualTo(10);
    }

    @Test
    void deleteProductIsReturnedToShop(){
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        assertThat(cart.cartItems.get(0).getQuantity()).isEqualTo(3);
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(7);

        cart.removeProductByID(1);
        cart.removeProductByID(1);
        assertThat(cart.cartItems.get(0).getQuantity()).isEqualTo(1);
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(9);
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, 100})
    void incorrectProductSelectionCausesExeption(int i){
        assertThatThrownBy(() -> cart.addProductToCartByID(i))
                .isInstanceOf(RuntimeException.class).describedAs("Не найдем продукт с id: " + i);
    }

    @Test
    @DisplayName("Advanced test for calculating TotalPrice")
    @RepeatedTest(10)
    @Timeout(value = 70, unit = TimeUnit.MILLISECONDS)
    void testAnnotation() throws InterruptedException{
        Thread.sleep(71);
        assertTrue(true);
    }
}