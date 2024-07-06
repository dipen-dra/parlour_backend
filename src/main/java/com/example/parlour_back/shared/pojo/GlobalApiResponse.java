package com.example.parlour_back.shared.pojo;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor




public class GlobalApiResponse <T>{

    private String message;
    private Integer statusCode;
    private T data;




}