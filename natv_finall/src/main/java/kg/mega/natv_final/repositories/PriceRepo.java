package kg.mega.natv_final.repositories;

import kg.mega.natv_final.models.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<Price,Long> {
    @Query(value = "select * from tb_price where channel_channel_id = :id",nativeQuery = true)
    Price getPriceById(Long id);
    @Query(value = "select price_per_symbol from tb_price where channel_channel_id = :id",nativeQuery = true)
    double getPricePerSymbol(Long id);
}
