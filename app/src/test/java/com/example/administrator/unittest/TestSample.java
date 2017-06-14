package com.example.administrator.unittest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@RunWith(Parameterized.class)
public class TestSample {

    {
        System.out.printf("init code block%n");

    }

    static {  // static 이라 가장 먼저 초기화 됨
        System.out.printf("static init code block%n");
    }


    public TestSample(){
        System.out.printf("initiate test class%n");
    }

    @BeforeClass
    public static void beforeClass(){  // static 이라서 가장 먼저 초기화 되는군
        System.out.printf("Create Test classes %n");
    }

    @Before
    public void before() {
        System.out.printf("Start Test %n");
    }

    int x, y, z;

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Integer[][]{
            {1,2,3},{2,3,5},{10,12,19},{10,20,30}
        });
    }

    public TestSample(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Test
    public void test1() {
        System.out.printf("Do Test%d %n",1);
        assertEquals(5, Calculator.sum(4,1));  // (기대값, 실제값)

    }

    @Test(expected = AssertionError.class)  // 이렇게 하면 오류가 나야 초록색이 나온다.
    public void test2() {
        System.out.printf("Do Test%d %n",2);
        assertEquals(5, Calculator.sum(6,3));
    }

    @Test(expected = AssertionError.class)
    public void test3() {
        String reason = "the result of sum does not equal";
        assertEquals(reason, 5, Calculator.sum(6,3));
    }

    @Test
    public void test4() {
        assertThat(Calculator.sum(3,5), is(10));
        assertThat("HelloWorld", startsWith("Hello"));
        assertThat("HelloWorld", both(startsWith("Hello")).and(endsWith("World")));
    }


    @Test
    public void test5() {
        System.out.printf("Do Test%d %n",1);
        assertEquals(z, Calculator.sum(x,y));  // (기대값, 실제값)

    }

    @Test(expected = AssertionError.class)  // 이렇게 하면 오류가 나야 초록색이 나온다.
    public void test6() {
        System.out.printf("Do Test%d %n",2);
        assertEquals(z, Calculator.sum(x,y));
    }

    @Test
    public void test7() {
        assertThat(Calculator.sum(x,y), is(z));
        assertThat("HelloWorld", startsWith("Hello"));
        assertThat("HelloWorld", both(startsWith("Hello")).and(endsWith("World")));
    }






    @After
    public void after() {
        System.out.printf("End Test %n");
    }

    @AfterClass
    public static void AfterClass(){
        System.out.printf("GC Test classes");
    }
}
