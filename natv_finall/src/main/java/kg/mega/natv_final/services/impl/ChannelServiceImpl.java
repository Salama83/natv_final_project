package kg.mega.natv_final.services.impl;

import kg.mega.natv_final.mappers.PriceMapper;
import kg.mega.natv_final.models.dto.crud.ChannelDto;
import kg.mega.natv_final.models.dto.requests.request2.ChannelCalculateReqDto;
import kg.mega.natv_final.models.dto.responses.response1.ChannelListDto;
import kg.mega.natv_final.models.dto.responses.response1.DiscountListDto;
import kg.mega.natv_final.models.dto.responses.response2.ChannelCalculateResDto;
import kg.mega.natv_final.models.entities.Channel;
import kg.mega.natv_final.models.entities.Discount;
import kg.mega.natv_final.models.entities.Text;
import kg.mega.natv_final.repositories.ChannelRepo;
import kg.mega.natv_final.repositories.DiscountRepo;
import kg.mega.natv_final.repositories.PriceRepo;
import kg.mega.natv_final.repositories.TextAddRepo;
import kg.mega.natv_final.services.ChannelService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {
    private final ChannelRepo channelRepo;
    private final PriceRepo priceRepo;
    private final DiscountRepo discountRepo;
    private final TextAddRepo textAddRepo;


    public ChannelServiceImpl(ChannelRepo channelRepo, PriceRepo priceRepo, DiscountRepo discountRepo, TextAddRepo textAddRepo) {
        this.channelRepo = channelRepo;

        this.priceRepo = priceRepo;
        this.discountRepo = discountRepo;
        this.textAddRepo = textAddRepo;
    }

    @Override
    public List<ChannelListDto> findAll() {
        List<ChannelListDto> channelListDtos = new ArrayList<>();
        List<Channel> channels = channelRepo.findAllByChannelStatus();
        for (Channel i : channels) {
            ChannelListDto channelListDto = new ChannelListDto();
            channelListDto.setChannelName(i.getChannelName());
            channelListDto.setLogoPath(i.getLogoPath());
            if (priceRepo.getPriceById(i.getChannelId()) != null) {
                if (getDiscountsById(i.getChannelId()) != null) {
                    channelListDto.setPricePerSymbol(priceRepo.getPriceById(i.getChannelId()).getPricePerSymbol());
                    channelListDto.setDiscounts(getDiscountsById(i.getChannelId()));
                }
            }
            channelListDtos.add(channelListDto);
        }
        return channelListDtos;
    }

    public List<DiscountListDto> getDiscountsById(Long id) {
        List<Discount> discounts = discountRepo.getDiscountsById(id);
        List<DiscountListDto> discountListDtos = new ArrayList<>();
        for (Discount i : discounts) {
            if (i.getStartDate().before(new Date()) &&
                    i.getEndDate().after(new Date())) {
                DiscountListDto discountListDto = new DiscountListDto();
                discountListDto.setDiscount(i.getDiscount());
                discountListDto.setFromDayCount(i.getFromDayCount());
                discountListDtos.add(discountListDto);
            }
        }
        return discountListDtos;

    }

    @Override
    public ChannelDto save(ChannelDto channelDto) {
        Channel channel = PriceMapper.ChannelMapper.INSTANCE.channelDtoToChannel(channelDto);
        channel = channelRepo.save(channel);
        channelDto.setChannelId(channel.getChannelId());
        return channelDto;
    }

    @Override
    public Channel findById(Long channelId) {
        return channelRepo.findById(channelId).orElseThrow(() -> {
            return new RuntimeException("Такого канала не существует!");
        });
    }

    @Override
    public ChannelDto update(ChannelDto channelDto) {
        Channel existingChannel = channelRepo.findById(channelDto.getChannelId()).orElseThrow(() -> {
            return new RuntimeException("Такого канала не существует!");
        });
        existingChannel = PriceMapper.ChannelMapper.INSTANCE.channelDtoToChannel(channelDto);
        //update id is not null
        channelRepo.save(existingChannel);
        return channelDto;
    }

    @Override
    public ChannelCalculateResDto calculate(ChannelCalculateReqDto channelCalculateReqDto) {
        ChannelCalculateResDto channelCalculateResDto = new ChannelCalculateResDto();
        channelCalculateResDto.setText(channelCalculateReqDto.getText());
        if(channelCalculateReqDto.getText().length() < 20){
            String minimumText = "Текст должен содержать минимум 20 символов!";
            System.err.println(minimumText);
            channelCalculateResDto.setText(minimumText);
            return null;
        }
        Text text = new Text();
        text.setSymbolCount(channelCalculateReqDto.getText().length());
        text.setText(channelCalculateResDto.getText());
        textAddRepo.save(text);
        Discount discount = new Discount();
        discount.setFromDayCount(channelCalculateReqDto.getDaysCount());
        Channel channel = new Channel();
        channel.setChannelId(channelCalculateReqDto.getChannelId());
        discount.setChannel(channel);
        discountRepo.save(discount);

        channelCalculateResDto.setDaysCount(channelCalculateReqDto.getDaysCount());
        channelCalculateResDto.setChannelId(channelCalculateReqDto.getChannelId());
        boolean active = channelRepo.findByStatus(channelCalculateReqDto.getChannelId());
        try {
            if (active == false) ;
        } catch (Exception e) {
            System.err.println("This channel is not active!");
            throw new RuntimeException();
        }
        double discountApply;
        channelCalculateResDto.setPrice(channelCalculateReqDto.getText().replaceAll(" ", "").length()
                * priceRepo.getPricePerSymbol(channelCalculateResDto.getChannelId())
                * channelCalculateResDto.getDaysCount());
        if (channelCalculateResDto.getDaysCount() >= 3 && channelCalculateResDto.getDaysCount() < 7) {
            channelCalculateResDto.setPriceWithDiscount(discountApply = channelCalculateResDto.getPrice() - channelCalculateResDto.getPrice() * 0.05);
            discount.setDiscount(discountApply);

        }
        if (channelCalculateResDto.getDaysCount() >= 7 && channelCalculateResDto.getDaysCount() < 10) {
            channelCalculateResDto.setPriceWithDiscount( discountApply = channelCalculateResDto.getPrice() - channelCalculateResDto.getPrice() * 0.1);
            discount.setDiscount(discountApply);

        }
        if (channelCalculateResDto.getDaysCount() >= 10) {
            channelCalculateResDto.setPriceWithDiscount( discountApply = channelCalculateResDto.getPrice() - channelCalculateResDto.getPrice() * 0.15);
            discount.setDiscount(discountApply);

        }
        discountRepo.save(discount);
        return channelCalculateResDto;
    }
}
