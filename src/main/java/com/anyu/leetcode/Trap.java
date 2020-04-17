package com.anyu.leetcode;

public class Trap {
    public int trap(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int total = 0;
        int htest = height[0];
        int temcur = 0;
        int temtotal = 0;
        final int START = 0;
        final int UP = 1;
        final int DOWN = 2;
        int STATE = START;
        for (int cur = 1; cur < height.length; cur++) {
            int flag = height[cur] - height[cur - 1];
            switch (STATE) {
                case START:
                    if (flag >= 0) {
                        htest = height[cur];
                        temcur = cur;
                        STATE = START;
                    } else {
                        STATE = DOWN;
                        temtotal += htest - height[cur];
                    }
                    break;
                case UP:
                    if (flag >= 0) {
                        STATE = UP;
                        if (height[cur] <= htest)
                            temtotal += htest - height[cur];
                    } else {
                        STATE = DOWN;
                        if (height[cur - 1] >= htest) {
                            total += temtotal;
                        } else {
                            int u = (cur - 2 - temcur) * (htest - height[cur - 1]);
                            temtotal -= u;
                            total += temtotal;
                        }
                        htest = height[cur - 1];
                        temcur = cur;
                        temtotal = 0;
                    }
                    break;
                case DOWN:
                    if (height[cur] <= htest)
                        temtotal += htest - height[cur];
                    if (flag <= 0)
                        STATE = DOWN;
                    else
                        STATE = UP;
                    break;
            }
        }
        if (STATE == UP) {
            if (htest <= height[height.length - 1])
                total += temtotal;
            else {
                int u = (height.length - 1 - temcur) * (htest - height[height.length - 1]);
                temtotal -= u;
                total += temtotal;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();

//        System.out.println(trap.trap(new int[]{1,0,2}));
//        System.out.println(trap.trap(new int[]{4,2,3}));
        System.out.println(trap.trap(new int[]{5, 4, 1, 2}));
        System.out.println(trap.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
