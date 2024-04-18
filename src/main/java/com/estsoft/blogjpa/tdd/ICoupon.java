package com.estsoft.blogjpa.tdd;

public interface ICoupon {
    public String getName();                // 쿠폰 이름
    public boolean isValid();               // 쿠폰 유효 여부 확인
    public int getDiscountPercent();        // 할인율

}
