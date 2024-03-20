package com.estsoft.blogjpa;

import org.junit.jupiter.api.*;

public class JUnitTest {
    @BeforeAll					// 전체 테스트를 시작하기 전 1회 실행
    public static void beforeAll() {
        System.out.println("@BeforeAll");
    }
    //JUnit 테스트 클래스의 경우 독립적으로 생성, 삭제 되기때문에
    //모든 테스트가 끝나기 전, 후에 실행되어야하는 beforeAll, afterAll 메소드의 경우
    //메소드 선언시 static 으로 선언해줘야한다.

    @BeforeEach					// 각각의 테스트 케이스를 실행하기 전마다 실행
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }

    @AfterAll						// 전체 테스트를 마치고 종료하기 전에 1회 실행
    public static void afterAll() {
        System.out.println("@AfterAll");
    }
    //beforeAll 과 같은 이유로 static

    @AfterEach						// 각각의 테스트 케이스를 종료하기 전마다 실행
    public void afterEach() {
        System.out.println("@AfterEach");
    }
}
