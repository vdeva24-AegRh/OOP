package Seminars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.print.DocFlavor;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyStackTest {
    private MyStack<String> stack;

    @BeforeEach
    public void init() {
        stack = new MyStack<>();
    }
    @Test
    public void testSize() {
        assertEquals(0 , stack.size());
        stack.add("1");
        assertEquals(1 ,stack.size());
        stack.add("abb");
        stack.add("vcc");
        assertEquals(3 , stack.size());
        stack.pop();
        stack.pop();
        assertEquals(1 , stack.size());
    }
    @Test
    public void testSizeMany() {
        for(int i = 1 ; i <= 8000 ; i ++) {
            stack.add("" + i);
            assertEquals(i , stack.size());
        }
        for(int i = 8000 ; i >= 1; i --) {
            stack.pop();
            assertEquals(i - 1 , stack.size());
        }
    }
    @Test
    public void testAdd() {
        stack.add("1");
        stack.add("2");
        stack.add("3");
        assertEquals(3 , stack.size());
        stack.pop();
        assertEquals(2 , stack.size());
    }
    @Test
    public void testPop() {
        stack.add("1");
        stack.add("2");
        stack.add("3");
        assertEquals("3", stack.pop());
        assertEquals("2", stack.pop());
    }
    @Test
    public void testPopEmpty() {
        assertThrows(RuntimeException.class , () -> stack.pop());
    }
    @Test
    public void testAddAll () {
        stack.addAll(Arrays.asList("aa" ,"bn" , "vg" , "jh"));
        assertEquals(4 , stack.size());
        assertEquals("jh" , stack.pop());
        assertEquals("vg" , stack.pop());
        assertEquals(2 , stack.size());
        stack.add("Targaryen");
        assertEquals(3 , stack.size());
    }
}
