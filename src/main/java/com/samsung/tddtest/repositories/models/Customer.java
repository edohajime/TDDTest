package com.samsung.tddtest.repositories.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    public String Name;
    public String CustomerNumber;
    public String Email;
}
