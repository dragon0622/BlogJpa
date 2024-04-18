package com.estsoft.blogjpa;

import com.estsoft.blogjpa.tdd.ICoupon;
import com.estsoft.blogjpa.tdd.User;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void testAddCoupon() {
        User user = new User("area00", "pw");
        assertEquals(0, user.getTotalCouponCount()); // 쿠폰수령전

        ICoupon coupon = Mockito.mock(ICoupon.class);
        BDDMockito.given(coupon.isValid())
                .willReturn(true);        // isValid() 호출시 리턴값은 true

        user.addCoupon(coupon);
        assertEquals(1, user.getTotalCouponCount());
    }
}