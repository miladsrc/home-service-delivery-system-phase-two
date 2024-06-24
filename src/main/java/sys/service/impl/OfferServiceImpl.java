package sys.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sys.entity.Offer;
import sys.exceptions.NotFoundException;
import sys.repository.OfferRepository;
import sys.service.OfferService;


@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    @Override
    public Offer saveOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public Offer getOfferById(Long offerId) {
        return offerRepository.findById(offerId)
                .orElseThrow(() -> new NotFoundException("Offer not found with ID: " + offerId));
    }

    @Override
    public void deleteOffer(Long offerId) {
        if (!offerRepository.findById(offerId).isPresent()) {
            throw new NotFoundException("Offer not found with ID: " + offerId);
        }
        offerRepository.deleteById(offerId);
    }



}

