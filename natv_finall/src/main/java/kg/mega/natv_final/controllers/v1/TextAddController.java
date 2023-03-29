package kg.mega.natv_final.controllers.v1;

import kg.mega.natv_final.models.dto.crud.TextAddDto;
import kg.mega.natv_final.services.TextAddService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("text_add")
public class TextAddController {
    private final TextAddService textAddService;

    public TextAddController(TextAddService textAddService) {
        this.textAddService = textAddService;
    }
    @PostMapping("/save")
    public TextAddDto save(TextAddDto textAddDto){
        return textAddService.save(textAddDto);
    }
}
