package kg.mega.natv_final.repositories;

import kg.mega.natv_final.models.entities.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepo extends JpaRepository<Channel, Long> {
    @Query(value = "Select *  \n" +
            "from  tb_channel tb_ch\n" +
            "Where channel_status = true \n"+
            "ORDER BY channel_name asc",nativeQuery = true)
    List<Channel> findAllByChannelStatus();
    @Query (value = "select channel_status  from tb_channel " +
            "where  channel_id = :channelId", nativeQuery = true)
    boolean findByStatus(Long channelId);

}

