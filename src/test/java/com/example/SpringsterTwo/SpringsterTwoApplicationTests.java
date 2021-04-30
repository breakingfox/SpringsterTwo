package com.example.SpringsterTwo;

import com.example.SpringsterTwo.repository.ProductRepository;
import com.example.SpringsterTwo.repository.RecipeRepository;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

@Slf4j
//@Transactional
@SpringBootTest
class SpringsterTwoApplicationTests {
    @Autowired
    ProductRepository productRepository;
    RecipeRepository recipeRepository;

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

//    @Test
//    void productFill() {
//        EasyRandomParameters parameters = new EasyRandomParameters();
//        Faker faker = new Faker(new Locale("ru"));
//
//        parameters.stringLengthRange(3, 5);
//        parameters.randomize(Integer.class, IntegerRangeRandomizer.aNewIntegerRangeRandomizer(0, 150));
//        parameters.randomize(Long.class, LongRangeRandomizer.aNewLongRangeRandomizer(0L, 150L));
//        parameters.randomize(String.class, () -> faker.food().dish());
//        parameters.excludeField(FieldPredicates.named("id"));
//        EasyRandom generator = new EasyRandom(parameters);
//        List<Product> products = generator.objects(Product.class, 5)
//                .collect(Collectors.toList());
//        for (Product x :
//                products)
//            log.info(String.valueOf(x));
//        assertEquals(5, products.size());
//        for (Product x :
//                products)
//            productRepository.save(x);
//    }
}
