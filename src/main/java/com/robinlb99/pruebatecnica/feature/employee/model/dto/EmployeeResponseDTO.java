package com.robinlb99.pruebatecnica.feature.employee.model.dto;

public record EmployeeResponseDTO(
    Integer id,
    String name,
    String position,
    Double salary
) {}
