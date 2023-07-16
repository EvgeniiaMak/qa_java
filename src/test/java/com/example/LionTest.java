package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private final boolean hasManeExpected;

    public LionTest(String sex, boolean hasManeExpected) {
        this.sex = sex;
        this.hasManeExpected = hasManeExpected;
    }

    @Mock
    Feline feline;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getKittensTest() {
        Lion lion = new Lion(feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void doesHaveManeTest() {
        try {
            Lion lion = new Lion(feline, sex);
            Assert.assertEquals(hasManeExpected, lion.doesHaveMane());
        } catch (Exception e) {
            System.out.println("Произошла ошибка во время выполнения");
        }

    }

    @Test
    public void doesHaveManeExceptionTest() {
        Assert.assertThrows(Exception.class, () -> new Lion(feline, "Male"));
    }

    @Test
    public void getFoodTest() {
        Lion lion = new Lion(feline);
        try {
            lion.getFood();
            Mockito.verify(feline).getFood("Хищник");
        } catch (Exception e) {
            System.out.println("Произошла ошибка во время выполнения");
        }
    }

    @Parameterized.Parameters
    public static Object[][] getSexAndHasManeData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }
}
