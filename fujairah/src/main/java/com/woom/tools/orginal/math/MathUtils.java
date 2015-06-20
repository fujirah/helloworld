package com.woom.tools.orginal.math;

import java.math.BigDecimal;

/**
 * Created by yuhao.zx on 15-1-19.
 */
public class MathUtils {
    public static BigDecimal convertRatioToDisplay(Long ratio) {
        if (ratio == null)
            return null;
        BigDecimal result = new BigDecimal(ratio).movePointLeft(2);
        result = result.setScale(2, BigDecimal.ROUND_HALF_UP);
        return result;
    }

    public static BigDecimal convertRatioToDisplay(Integer ratio) {
        if (ratio == null)
            return null;
        BigDecimal result = new BigDecimal(ratio).movePointLeft(2);
        result = result.setScale(2, BigDecimal.ROUND_HALF_UP);
        return result;
    }
}
