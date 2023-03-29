package kg.mega.natv_final.controllers.v1;

import io.swagger.annotations.ApiOperation;
import kg.mega.natv_final.models.dto.crud.ChannelDto;
import kg.mega.natv_final.models.dto.requests.request2.ChannelCalculateReqDto;
import kg.mega.natv_final.models.dto.responses.response1.ChannelListDto;
import kg.mega.natv_final.models.dto.responses.response2.ChannelCalculateResDto;
import kg.mega.natv_final.models.entities.Channel;
import kg.mega.natv_final.services.ChannelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/channel")
public class ChannelController {
    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }
    @ApiOperation("Получение списка каналов")
    @GetMapping("/list")
    List<ChannelListDto> findAll() {
        return channelService.findAll();
    }
    @ApiOperation("Сохранение каналов")
    @PostMapping("/save")
    public ChannelDto save(@RequestBody ChannelDto channelDto){
        return channelService.save(channelDto);
    }
    @ApiOperation("Поиск каналов по id")
    @GetMapping("/{channelId}")
    public Channel findById(@PathVariable Long channelId){
        return channelService.findById(channelId);
    }
    @ApiOperation("Обновления каналов")
    @PutMapping("/update")
    public ChannelDto update(@RequestBody ChannelDto channelDto){
        return channelService.update(channelDto);
    }
    @ApiOperation("Получение стоимости рекламы на одном канале")
    @GetMapping("/calculate")
    public ChannelCalculateResDto calculate(@RequestBody ChannelCalculateReqDto channelCalculateReqDto){
        return channelService.calculate(channelCalculateReqDto);
    }
}
