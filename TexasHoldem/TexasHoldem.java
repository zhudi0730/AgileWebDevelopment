package cn.edu.xjtu.gs.day0311;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhudi
 * @create 2020/3/11 - 17:06
 */

//扑克牌类
class Holdem {
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

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Holdem{" +
                "num='" + num + '\'' +
                '}';
    }
}

public class TexasHoldem {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Holdem> black = new ArrayList<>();
        ArrayList<Holdem> white = new ArrayList<>();
        System.out.print("输入:Black:");
        for (int i = 0; i < 5; i++) {
            black.add(new Holdem(scan.next()));
        }
        System.out.print("输入:White:");
        for (int i = 0; i < 5; i++) {
            white.add(new Holdem(scan.next()));
        }

        int flag = TexasHoldem.compare(black, white);
        if (flag == 0) {
            System.out.println("Black wins");
        }else if (flag == 1) {
            System.out.println("White wins");
        }else {
            System.out.println("Tie");
        }
    }

    //比较Black和White牌的大小
    public static int compare(ArrayList<Holdem> black, ArrayList<Holdem> white) {

        int blackFlag, whiteFlag;
        int[] blackNum = new int[5];
        int[] whiteNum = new int[5];
        char[] blackColor = new char[5];
        char[] whiteColor = new char[5];

        for (int i = 0; i < 5; i++) {
            blackNum[i] = black.get(i).getNum();
            whiteNum[i] = white.get(i).getNum();
            blackColor[i] = black.get(i).getColor();
            whiteColor[i] = white.get(i).getColor();
        }
        Arrays.sort(blackNum);
        Arrays.sort(whiteNum);
        Arrays.sort(blackColor);
        Arrays.sort(whiteColor);

        blackFlag = TexasHoldem.isType(blackNum, blackColor);
        whiteFlag = TexasHoldem.isType(whiteNum, whiteColor);

        TexasHoldem.reSort(blackNum, blackFlag);
        TexasHoldem.reSort(whiteNum, whiteFlag);

        if (blackFlag > whiteFlag) {
            return 0;
        }else if (blackFlag < whiteFlag) {
            return 1;
        }else {
            return TexasHoldem.compareSingle(blackNum, whiteNum);
        }
    }

    //对牌重新排序
    public static void reSort(int[] array, int typeFlag) {
        if (typeFlag == 2) {
            int k = 1;
            for (; array[k] != array[k - 1]; k++);
            bubbleSort(array, k - 1, k);
        }
        if (typeFlag == 3) {
            int k = 1;
            for (; array[k] != array[k - 1]; k++);
            bubbleSort(array, k - 1, k);
            k++;
            for (; array[k] != array[k - 1]; k++);
            bubbleSort(array, k - 1, k);
        }
        if (typeFlag == 4 || typeFlag == 7) {
            int k = 2;
            for (; array[k] != array[k - 1] && array[k] != array[k - 2]; k++);
            bubbleSort(array, k - 2, k);
        }
        if (typeFlag == 8) {
            if (array[4] != array[3])
                bubbleSort(array, 0, 3);
        }
    }

    //冒泡排序(改)
    public static void bubbleSort(int[] array, int left, int right) {
        for (int i = right; i >= left; i--) {
            int temp;
            for (int j = i + 1; j < array.length; j++) {
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }

    //比较牌的大小
    public static int compareSingle(int[] black, int[] white) {

        for (int i = black.length - 1; i >= 0; i--) {
            if (black[i] > white[i]) {
                return 0;
            }else if (black[i] < white[i]) {
                return 1;
            }
        }
        return 2;
    }

    //判断牌是哪种类型：1=散排 2=对子 3=两对 4=三条 5=顺子 6=同花 7=葫芦 8=铁支 9=同花顺
    public static int isType(int[] array, char[] color) {
        if (isStraight(array) && isFlush(color))
            return 9;
        if (isFourOfAKind(array))
            return 8;
        if (isFullHouse(array))
            return 7;
        if (isFlush(color))
            return 6;
        if (isStraight(array))
            return 5;
        if (isThreeOfAKind(array))
            return 4;
        if (isTwoPairs(array))
            return 3;
        if (isOnePair(array))
            return 2;
        return 1;
   }

    //判断index1到index2处的牌是否一样
    public static boolean isSame(int[] array, int index1, int index2) {
        for (int i = index1 + 1; i <= index2; i++) {
            if (array[index1] != array[i])
                return false;
        }
        return true;
    }

    //判断牌是否是顺子
    public static boolean isStraight(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] != array[i] + 1)
                return false;
        }
        return true;
    }

    //判断牌是否是同花
    public static boolean isFlush(char[] color) {
        for (int i = 1; i < color.length; i++) {
            if (color[0] != color[i])
                return false;
        }
        return true;
    }

    //判断牌是否是铁支
    public static boolean isFourOfAKind(int[] array) {
        if (isSame(array, 0, 3) || isSame(array, 1, 4))
            return true;
        return false;
    }

    //判断牌是否是葫芦
    public static boolean isFullHouse(int[] array) {
        if ((isSame(array, 0, 2) && isSame(array, 3, 4)) || (isSame(array, 0, 1) && isSame(array, 2, 4)))
            return true;
        return false;
    }

    //判断牌是否是三条
    public static boolean isThreeOfAKind(int[] array) {
        if (isSame(array, 0, 2) || isSame(array, 1, 3) || isSame(array, 2, 4))
            return true;
        return false;
    }

    //判断牌是否是两对
    public static boolean isTwoPairs(int[] array) {
        if ((isSame(array, 0, 1) && isSame(array, 2, 3)) || (isSame(array, 0, 1) && isSame(array, 3, 4)) || (isSame(array,1, 2) && isSame(array, 3, 4)))
            return true;
        return false;
    }

    //判断牌是否是一对
    public static boolean isOnePair(int[] array) {
        if (isSame(array, 0, 1) || isSame(array, 1, 2) || isSame(array, 2, 3) || isSame(array, 3, 4))
            return true;
        return false;
    }
}
