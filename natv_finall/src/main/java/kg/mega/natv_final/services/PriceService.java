package kg.mega.natv_final.services;

import kg.mega.natv_final.models.dto.crud.PriceDto;
import kg.mega.natv_final.models.entities.Price;

public interface PriceService {
    PriceDto save(PriceDto priceDto);

    Price findById(Long id);
}
