package sys.service;

import sys.entity.Offer;

public interface OfferService {
    Offer saveOffer(Offer offer);

    Offer getOfferById(Long offerId);

    void deleteOffer(Long offerId);
}
