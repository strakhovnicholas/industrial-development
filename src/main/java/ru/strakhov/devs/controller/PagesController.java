package ru.strakhov.devs.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.strakhov.devs.dto.ContactFormDto;
import ru.strakhov.devs.dto.PropertyFormDto;

@Controller
public class PagesController {
    private static final Logger logger = LoggerFactory.getLogger(PagesController.class);

    @GetMapping("/")
    public String home(Model model) {
        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactFormDto());
        }
        if (!model.containsAttribute("propertyForm")) {
            model.addAttribute("propertyForm", new PropertyFormDto());
        }
        return "index";
    }

    @PostMapping("/contact")
    public String handleContact(
            @Valid @ModelAttribute("contactForm") ContactFormDto contactForm,
            BindingResult bindingResult,
            Model model
    ) {
        logger.debug("Обработка контактной формы: {}", contactForm);

        if (bindingResult.hasErrors()) {
            logger.warn("Ошибки валидации контактной формы:");
            bindingResult.getAllErrors()
                    .forEach(error -> logger.warn("- {}", error.getDefaultMessage()));
            model.addAttribute("propertyForm", new PropertyFormDto());
            return "index";
        }

        logger.info("Контактная форма валидна, перенаправление с success=contact");
        return "redirect:/?success=contact";
    }

    @PostMapping("/property")
    public String handleProperty(
            @Valid @ModelAttribute("propertyForm") PropertyFormDto propertyForm,
            BindingResult bindingResult,
            Model model
    ) {
        logger.debug("Обработка формы объекта: {}", propertyForm);

        if (bindingResult.hasErrors()) {
            logger.warn("Ошибки валидации формы объекта:");
            bindingResult.getAllErrors()
                    .forEach(error -> logger.warn("- {}", error.getDefaultMessage()));
            model.addAttribute("contactForm", new ContactFormDto());
            return "index";
        }

        logger.info("Форма объекта валидна, перенаправление с success=property");
        return "redirect:/?success=property";
    }
}
