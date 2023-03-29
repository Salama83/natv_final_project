package kg.mega.natv_final.services;

import kg.mega.natv_final.models.dto.crud.ChannelDto;
import kg.mega.natv_final.models.dto.requests.request2.ChannelCalculateReqDto;
import kg.mega.natv_final.models.dto.responses.response1.ChannelListDto;
import kg.mega.natv_final.models.dto.responses.response2.ChannelCalculateResDto;
import kg.mega.natv_final.models.entities.Channel;

import java.util.List;

public interface ChannelService {
    List<ChannelListDto> findAll();

    ChannelDto save(ChannelDto channelDto);

    Channel findById(Long channelId);

    ChannelDto update(ChannelDto channelDto);

    ChannelCalculateResDto calculate(ChannelCalculateReqDto channelCalculateReqDto);
}
