/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/25 20:44
 */
package com.liuballoon.common.utils;

import java.util.Random;

public class RandomUtil {

    /**
     * 随机生成昵称
     *
     * @return 昵称
     */
    public static String nickname() {
        String head = "temp_";
        int length = 14;
        Random random = new Random();
        StringBuilder nickname = new StringBuilder(head);
        for (int i = 0; i < length; i++) {
            int param = random.nextInt(2);
            switch (param) {
                case 0 -> nickname.append((char) random.nextInt(97, 123));
                case 1 -> nickname.append(random.nextInt(10));
            }
        }
        return nickname.toString();
    }
}
