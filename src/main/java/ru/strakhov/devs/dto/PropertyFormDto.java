package ru.strakhov.devs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyFormDto {
    @NotBlank(message = "Название объекта обязательно для заполнения")
    @Size(min = 5, max = 100, message = "Название должно содержать от 5 до 100 символов")
    private String title;

    @NotBlank(message = "Адрес обязателен для заполнения")
    @Size(min = 10, max = 200, message = "Адрес должен содержать от 10 до 200 символов")
    private String address;

    @NotBlank(message = "Цена обязательна для заполнения")
    @Pattern(regexp = "^\\d+(\\.\\d{1,2})?$", message = "Введите корректную цену (например: 1000000 или 1000000.50)")
    private String price;

    @NotBlank(message = "Email владельца обязателен для заполнения")
    @Email(message = "Введите корректный email адрес владельца")
    private String ownerEmail;
}