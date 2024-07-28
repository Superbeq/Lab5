package com.example.event.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class Event {

    private String id;

    private String description;

    private int capacity;
     @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;
     @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;
}