//package com.squad_5.recursos.Recursos;
//
//import com.squad_5.recursos.Recursos.Models.Horas;
//import com.squad_5.recursos.Recursos.Models.HorasACargarDTO;
//import com.squad_5.recursos.Recursos.RecursosApplication;
//import com.squad_5.recursos.Recursos.Services.HorasService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import java.util.List;
//
//@ContextConfiguration(classes = RecursosApplication.class)
//@WebAppConfiguration
//@SpringBootTest
//public class CargaHorasServicesTest {
//
//
//    HorasService horasService;
//
//
//    public List<Horas> getHorasByLegajo(int cuit) {
//        return horasService.getHorasByLegajo(cuit);
//    }
//
//    public void deleteHoras(int id) {
//        horasService.deleteHoras(id);
//    }
//
//    public Horas updateHoras(int id, Horas horas) {
//        return horasService.updateHoras(id, horas);
//    }
//
//    public Horas cargarHoras(HorasACargarDTO horas) {
//        return horasService.cargarHoras(horas);
//    }
//
//
//
//
//}
