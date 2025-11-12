package com.robinlb99.pruebatecnica.feature.employee.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeRequestDTO(
    @NotBlank(message = "El nombre es obligatorio") String name,
    @NotBlank(message = "La posición es obligatorio") String position,
    @NotNull(message = "El salario es obligatorio") Double salary
) {}
