package test.cn.edu.xjtu.gs.day0311; 

import cn.edu.xjtu.gs.day0311.Holdem;
import cn.edu.xjtu.gs.day0311.TexasHoldem;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/** 
* TexasHoldem Tester. 
* 
* @author <Authors name> 
* @since <pre>03/14/2020</pre> 
* @version 1.0 
*/ 
public class TexasHoldemTest {


/** 
* 
* Method: compare(ArrayList<Holdem> black, ArrayList<Holdem> white) 
* 
*/ 
@Test
public void testCompare() throws Exception { 
//TODO: Test goes here...
    ArrayList<Holdem> black = new ArrayList<>();
    black.add(new Holdem("AD"));
    black.add(new Holdem("KD"));
    black.add(new Holdem("QD"));
    black.add(new Holdem("JD"));
    black.add(new Holdem("TD"));

    ArrayList<Holdem> white = new ArrayList<>();
    white.add(new Holdem("9D"));
    white.add(new Holdem("9S"));
    white.add(new Holdem("9H"));
    white.add(new Holdem("9C"));
    white.add(new Holdem("AS"));

    Assert.assertEquals("错误",0, TexasHoldem.compare(black, white));
} 

/** 
* 
* Method: reSort(int[] array, int typeFlag) 
* 
*/ 
@Test
public void testReSort() throws Exception { 
//TODO: Test goes here...
    int[] arrayBefore = {2, 2, 3, 3, 9};
    int[] arrayAfter = {9, 2, 2, 3, 3};
    TexasHoldem.reSort(arrayBefore, 3);
    Assert.assertArrayEquals("错误", arrayAfter, arrayBefore);

} 

/** 
* 
* Method: bubbleSort(int[] array, int left, int right) 
* 
*/ 
@Test
public void testBubbleSort() throws Exception { 
//TODO: Test goes here...
    int[] arrayBefore = {6, 5, 4, 2, 3};
    int[] arrayAfter = {2, 3, 4, 5, 6};
    TexasHoldem.bubbleSort(arrayBefore, 0, 2);
    Assert.assertArrayEquals("错误", arrayAfter, arrayBefore);
} 

/** 
* 
* Method: compareSingle(int[] black, int[] white) 
* 
*/ 
@Test
public void testCompareSingle() throws Exception { 
//TODO: Test goes here...
    int[] black = {2, 11, 12, 13, 14};
    int[] white = {3, 11, 12, 13, 14};
    Assert.assertEquals("错误", 1, TexasHoldem.compareSingle(black, white));
} 

/** 
* 
* Method: isSame(int[] array, int index1, int index2) 
* 
*/ 
@Test
public void testIsSame() throws Exception { 
//TODO: Test goes here...
    int[] array = {2, 2, 2, 3, 4};
    Assert.assertTrue(TexasHoldem.isSame(array, 0, 2));
} 

} 
