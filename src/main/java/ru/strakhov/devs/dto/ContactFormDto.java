package ru.strakhov.devs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactFormDto {
    @NotBlank(message = "Имя обязательно для заполнения")
    @Size(min = 2, max = 50, message = "Имя должно содержать от 2 до 50 символов")
    private String name;

    @NotBlank(message = "Email обязателен для заполнения")
    @Email(message = "Введите корректный email адрес")
    private String email;

    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Введите корректный номер телефона")
    private String phone;

    @NotBlank(message = "Сообщение обязательно для заполнения")
    @Size(min = 10, max = 500, message = "Сообщение должно содержать от 10 до 500 символов")
    private String message;
}