package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodTest() {
        Cat cat = new Cat(feline);
        try {
            cat.getFood();
            Mockito.verify(feline).eatMeat();
        } catch (Exception e) {
            System.out.println("Произошла ошибка во время выполнения");
        }

    }

}
