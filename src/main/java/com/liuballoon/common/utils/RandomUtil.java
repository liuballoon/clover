/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/25 20:44
 */
package com.liuballoon.common.utils;

import java.util.Random;

/**
 * 随机生成工具集
 */
public class RandomUtil {

    /**
     * 随机生成指定长度的字符串
     *
     * @param length 长度
     * @return
     */
    public static String generateString(int length) {
        Random random = new Random();
        StringBuilder res = new StringBuilder();
        for (var i = 0; i < length; i++) {
            int param = random.nextInt(2);
            switch (param) {
                case 0 -> res.append((char) random.nextInt(97, 123));
                case 1 -> res.append(random.nextInt(10));
            }
        }
        return res.toString();
    }
}
