package com.skilledservice.ClientService.dto.requests;


import com.skilledservice.ClientService.data.constants.AppointmentStatus;
import com.skilledservice.ClientService.data.constants.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CancelAppointmentRequest {
    private Long appointmentId;
    private Category category;
    private AppointmentStatus status;

}
