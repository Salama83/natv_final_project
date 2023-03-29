package kg.mega.natv_final.mappers;

import kg.mega.natv_final.models.dto.crud.ChannelDto;
import kg.mega.natv_final.models.dto.crud.PriceDto;
import kg.mega.natv_final.models.entities.Channel;
import kg.mega.natv_final.models.entities.Price;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);
    Price priceDtoToPrice(PriceDto priceDto);
    PriceDto priceToPriceDto(Price price);

    @Component
    @Mapper
    interface ChannelMapper {
        ChannelMapper INSTANCE = Mappers.getMapper(ChannelMapper.class);
        //@Mapping(source = "channelId", target = "channelId")
        ChannelDto channelToChannelDto(Channel channel);


         Channel channelDtoToChannel(ChannelDto channelDto);
         List<ChannelDto> channelsToChannelDto(List<Channel> channels);
         @InheritInverseConfiguration
         List<Channel> channelDtosToChannel(List<ChannelDto> channelDto);

    }
}
