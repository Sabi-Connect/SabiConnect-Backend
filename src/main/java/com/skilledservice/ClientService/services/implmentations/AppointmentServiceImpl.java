package com.skilledservice.ClientService.services.implmentations;

import com.skilledservice.ClientService.dto.requests.UpdateAppointmentRequest;
import com.skilledservice.ClientService.dto.responses.CancelAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.DeleteAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.UpdateAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.ViewAllAppointmentsResponse;
import com.skilledservice.ClientService.exceptions.AppointmentNotFoundException;
import com.skilledservice.ClientService.data.models.Appointment;
import com.skilledservice.ClientService.data.constants.AppointmentStatus;
import com.skilledservice.ClientService.data.repository.AppointmentRepository;
import com.skilledservice.ClientService.services.ServiceUtils.AppointmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private  final ModelMapper modelMapper;

    @Override
    public Appointment bookAppointment(BigDecimal bookAppointmentRequest) {
        Appointment appointment = modelMapper.map(bookAppointmentRequest, Appointment.class);
        appointment.setStatus(AppointmentStatus.WAITING);
        appointmentRepository.save(appointment);

        return appointment;

    }



    @Override
    public CancelAppointmentResponse cancelAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found"));
        appointment.setStatus(AppointmentStatus.CANCELLED);
        appointmentRepository.save(appointment);
        CancelAppointmentResponse response = new CancelAppointmentResponse();
        modelMapper.map(response, Appointment.class);
        response.setMessage("Appointment cancelled successfully");
        return response;

    }

    @Override
    public UpdateAppointmentResponse updateAppointment(UpdateAppointmentRequest request) {
        Appointment appointment = appointmentRepository.findById(request.getAppointmentId())
                .orElseThrow(()-> new AppointmentNotFoundException("No appointment found"));

        modelMapper.map(request, Appointment.class);
        appointment.setStatus(AppointmentStatus.UPDATED);
        appointmentRepository.save(appointment);

        UpdateAppointmentResponse response = new UpdateAppointmentResponse();
        response .setId(appointment.getId());
        response.setMessage("Appointment Updated");
        return response;
    }

    @Override
    public DeleteAppointmentResponse deleteAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(()-> new AppointmentNotFoundException("No appointment found"));
        appointmentRepository.delete(appointment);
        return new DeleteAppointmentResponse("Appointment deleted successfully");
    }

    @Override
    public List<ViewAllAppointmentsResponse> viewAllAppointment() {
        var  appointments = appointmentRepository.findAll();
        var response = List.of(modelMapper
                .map(appointments, ViewAllAppointmentsResponse[].class));

        return response;
    }

    @Override
    public void save(Appointment appointment) {
        appointmentRepository.save(appointment);

    }


}
