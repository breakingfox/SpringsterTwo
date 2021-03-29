package com.example.SpringsterTwo;

import com.example.SpringsterTwo.entity.Product;
import com.example.SpringsterTwo.repository.ProductRepository;
import com.example.SpringsterTwo.repository.RecipeRepository;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.jeasy.random.randomizers.range.IntegerRangeRandomizer;
import org.jeasy.random.randomizers.range.LongRangeRandomizer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
//@Transactional
@SpringBootTest
class SpringsterTwoApplicationTests {
    @Autowired
    ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void fakerTest() {
        Faker faker = new Faker(new Locale("ru"));

        log.info("Мы зашли в тест");
        for (int i = 0; i < 15; i++)

            log.info(faker.food().dish());
    }

    @Test
    void productFill() {
        EasyRandomParameters parameters = new EasyRandomParameters();
        Faker faker = new Faker(new Locale("ru"));

        parameters.stringLengthRange(3, 5);
        parameters.randomize(Integer.class, IntegerRangeRandomizer.aNewIntegerRangeRandomizer(0, 150));
        parameters.randomize(Long.class, LongRangeRandomizer.aNewLongRangeRandomizer(0L, 150L));
        parameters.randomize(String.class, () -> faker.food().dish());
        parameters.excludeField(FieldPredicates.named("id"));
        EasyRandom generator = new EasyRandom(parameters);
        List<Product> products = generator.objects(Product.class, 5)
                .collect(Collectors.toList());
        for (Product x :
                products)
            log.info(String.valueOf(x));
        assertEquals(5, products.size());
        for (Product x :
                products)
            productRepository.save(x);
    }
}
