package com.ariescat.metis.framework.json;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author Ariescat
 * @version 2020/3/12 16:12
 */
public class MagicCircleItem {

    private int lv;
    private int exp;

    private Map<Integer, Integer> currency2limit = Maps.newHashMap();

    private Map<Short, SpiritItem> position2spirit = Maps.newHashMap();

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Map<Integer, Integer> getCurrency2limit() {
        return currency2limit;
    }

    public void setCurrency2limit(Map<Integer, Integer> currency2limit) {
        this.currency2limit = currency2limit;
    }

    public Map<Short, SpiritItem> getPosition2spirit() {
        return position2spirit;
    }

    public void setPosition2spirit(Map<Short, SpiritItem> position2spirit) {
        this.position2spirit = position2spirit;
    }

    static class SpiritItem {

        private int modelId;
        private int lv;

        public SpiritItem(int modelId, int lv) {
            this.modelId = modelId;
            this.lv = lv;
        }

        public int getModelId() {
            return modelId;
        }

        public int getLv() {
            return lv;
        }
    }
}
