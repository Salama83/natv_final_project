package kg.mega.natv_final.mappers;

import kg.mega.natv_final.models.dto.crud.TextAddDto;
import kg.mega.natv_final.models.entities.Text;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TextAddMapper {
    TextAddMapper INSTANCE = Mappers.getMapper(TextAddMapper.class);
    Text text_addDtoToText_add(TextAddDto textAddDto);
    TextAddDto text_addToText_addDto(Text textAdd);
    List<Text> text_addDtosToText_add(List<TextAddDto> textAddDtos);
    @InheritInverseConfiguration
    List<TextAddDto> text_addToText_addDtos(List<Text> textAdds);
}
