package com.mygdx.game;

public class ConstantValue {
    static float stepSize = 64;
    public static float GetX(float x) {
        float val = 96, res = 96;
        int idx = 1;
        while (idx <= 13) {
            if (Math.abs(res - x ) > Math.abs(x - val)) res = val;
            val += stepSize;
            idx++;
        }

        return res;
    }
    public static float GetY(float y) {
        float val = 64, res = 64;
        int idx = 1;
        while (idx <= 11) {
            if (Math.abs(res - y ) > Math.abs(y - val)) res = val;
            val += stepSize;
            idx++;
        }

        return res;
    }
}
