package kg.mega.natv_final.repositories;

import kg.mega.natv_final.models.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long> {
    @Query(value = "select * from  tb_discount where channel_channel_id = :id",nativeQuery = true)
    List<Discount> getDiscountsById(Long id);
}
