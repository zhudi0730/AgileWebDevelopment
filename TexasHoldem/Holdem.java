package cn.edu.xjtu.gs.day0311;

/**
 * @author zhudi
 * @create 2020/3/14 - 23:36
 */

//扑克牌类
public class Holdem {
    private String num;

    public Holdem(String num) {
        this.num = num;
    }

    public int getNum() {
        if (this.num.charAt(0) == 'A')
            return 14;
        if (this.num.charAt(0) == 'K')
            return 13;
        if (this.num.charAt(0) == 'Q')
            return 12;
        if (this.num.charAt(0) == 'J')
            return 11;
        if (this.num.charAt(0) == 'T')
            return 10;
        return this.num.charAt(0) - 48;
    }

    public char getColor() {
        return this.num.charAt(1);
    }

}
