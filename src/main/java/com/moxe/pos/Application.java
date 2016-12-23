package com.moxe.pos;

import com.moxe.pos.dao.BasketDao;
import com.moxe.pos.dao.impl.BasketDaoImpl;
import com.moxe.pos.dao.impl.ItemDaoImpl;
import com.moxe.pos.domain.BasketItem;
import com.moxe.pos.dto.CheckoutResponse;
import com.moxe.pos.dto.ItemQuantity;
import com.moxe.pos.exception.PosException;
import com.moxe.pos.mapper.impl.BasketItemQuantityMapper;
import com.moxe.pos.service.BasketService;
import com.moxe.pos.service.CheckoutService;
import com.moxe.pos.service.impl.BasketServiceImpl;
import com.moxe.pos.service.impl.CheckoutServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * @since 12/22/16.
 */
public class Application {
    private final static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    private final BasketService basketService;
    private final CheckoutService checkoutService;
    private final BasketDao basketDao;

    private Application(final BasketDao basketDao, final BasketService basketService, final CheckoutService checkoutService) {
        this.basketDao = basketDao;
        this.basketService = basketService;
        this.checkoutService = checkoutService;
    }

    private BasketService getBasketService() {
        return basketService;
    }

    private CheckoutService getCheckoutService() {
        return checkoutService;
    }

    private BasketDao getBasketDao() {
        return basketDao;
    }

    public static void main(String[] args) {
        try {
            final Application application = new Application(new BasketDaoImpl(), new BasketServiceImpl(new ItemDaoImpl(), new BasketItemQuantityMapper()), new CheckoutServiceImpl());
            final Map<String, List<ItemQuantity>> basketMap = application.getBasketDao().getBaskets();

            for (Map.Entry<String, List<ItemQuantity>> basket : basketMap.entrySet()) {
                final List<BasketItem> basketItems = application.getBasketService().addItems(basket.getValue());

                final CheckoutResponse checkoutResponse = application.getCheckoutService().checkOut(basketItems);
                System.out.println("Output " + basket.getKey());

                System.out.println(application.getCheckoutService().listBasketItems(checkoutResponse.getBasketItems()));
                System.out.println(application.getCheckoutService().getQualifiedSalesTax(checkoutResponse.getSalesTax()));
                System.out.println(application.getCheckoutService().getQualifiedTotal(checkoutResponse.getTotal()));
            }

        } catch (final PosException exception) {
            LOGGER.error("Exception occurred. ", exception);
        }

    }
}
