package test.cn.edu.xjtu.gs.day0311; 

import cn.edu.xjtu.gs.day0311.Holdem;
import org.junit.Assert;
import org.junit.Test;
/** 
* Holdem Tester. 
* 
* @author <Authors name> 
* @since <pre>03/14/2020</pre> 
* @version 1.0 
*/ 
public class HoldemTest {
    Holdem holdem = new Holdem("AD");

/** 
* 
* Method: getNum() 
* 
*/ 
@Test
public void testGetNum() throws Exception { 
//TODO: Test goes here...
    Assert.assertEquals("错误", 14, holdem.getNum());
} 

/** 
* 
* Method: getColor() 
* 
*/ 
@Test
public void testGetColor() throws Exception { 
//TODO: Test goes here...
    Assert.assertEquals("错误", 'D', holdem.getColor());
}

} 
