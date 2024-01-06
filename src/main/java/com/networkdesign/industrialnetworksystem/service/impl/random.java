package com.networkdesign.industrialnetworksystem.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class random {
    public static List<Double> getRandom() {
        Random random = new Random();
        // 正态分布的均值和标准差
        double mean = 25.0;
        double standardDeviation = 4.0;

        // 生成100个符合正态分布的随机数并输出
        List<Double> data = new ArrayList<>();
        final int MAX_COUNT = 10;
        for (int i = 0; i < MAX_COUNT; i++) {
            double randomValue = generateRandomNormalDistribution(random, mean, standardDeviation);
            double roundedValue = Math.round(randomValue * 100.0) / 100.0;
            data.add(roundedValue);
        }
        return data;
    }

    // 生成符合正态分布的随机数
    private static double generateRandomNormalDistribution(Random random, double mean, double standardDeviation) {
        // 使用 Box-Muller 变换生成正态分布随机数
        double u1 = random.nextDouble();
        double u2 = random.nextDouble();

        double z0 = Math.sqrt(-2.0 * Math.log(u1)) * Math.cos(2 * Math.PI * u2);

        // 将生成的随机数进行均值和标准差的缩放
        return mean + z0 * standardDeviation;
    }
}
