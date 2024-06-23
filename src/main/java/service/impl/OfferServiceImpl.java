package service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.OfferRepository;
import service.OfferService;


@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
}
