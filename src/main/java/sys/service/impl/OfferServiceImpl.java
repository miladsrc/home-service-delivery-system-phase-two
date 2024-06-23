package sys.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sys.repository.OfferRepository;
import sys.service.OfferService;


@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
}
