package sys.service;

import sys.entity.Offer;

import java.util.List;

public interface OfferService {
    Offer saveOffer(Offer offer);

    Offer getOfferById(Long offerId);

    void deleteOffer(Long offerId);

    List getListOfOffersForOrder(Long orderId);
}
