package sys.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sys.entity.Offer;
import sys.entity.Order;
import sys.exceptions.NotFoundException;
import sys.repository.OfferRepository;
import sys.service.OfferService;
import sys.service.OrderService;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final OrderService orderService;

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

    @Override
    public List<Offer> getListOfOffersForOrder(Long orderId) {
        Order order = orderService.getOrderById(orderId);

        List<Offer> offers = order.getOffer()
                .stream()
                .toList();

        if (offers.isEmpty()) {
            throw new NotFoundException("no offers found");
        }

        return offers;
    }




}

