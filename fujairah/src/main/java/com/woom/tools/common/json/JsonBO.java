package com.woom.tools.common.json;

/**
 * Created by yuhao.zx on 2015/3/20.
 */
public class JsonBO {
    private String name;
    private String baseFee;
    private Long topFee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(String baseFee) {
        this.baseFee = baseFee;
    }

    public Long getTopFee() {
        return topFee;
    }

    public void setTopFee(Long topFee) {
        this.topFee = topFee;
    }
}
