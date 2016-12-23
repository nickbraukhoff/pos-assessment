package com.moxe.pos.domain;

import org.apache.commons.lang3.StringUtils;

/**
 * @since 12/21/16.
 */
public class Item {
    private String id;
    private String name;
    private double price;
    private TradeType tradeType;
    private String packageType;
    private boolean grocery;
    private String size;

    public Item() {
    }

    public Item(final String id, final TradeType tradeType, final String name, final double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.tradeType = tradeType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TradeType getTradeType() {
        return tradeType;
    }

    public void setTradeType(TradeType tradeType) {
        this.tradeType = tradeType;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public boolean isGrocery() {
        return grocery;
    }

    public void setGrocery(boolean grocery) {
        this.grocery = grocery;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        if (tradeType.getValue() != null) {
            stringBuilder
                    .append(tradeType.getValue())
                    .append(" ");
        }
        if (StringUtils.isNotEmpty(size)) {
            stringBuilder
                    .append(size)
                    .append(" ");
        }
        if (StringUtils.isNotEmpty(packageType)) {
            stringBuilder
                    .append(packageType.toLowerCase())
                    .append(" of ");
        }
        stringBuilder.append(name)
                .append(": ");

        return stringBuilder.toString();
    }
}
