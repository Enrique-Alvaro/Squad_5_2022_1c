package com.squad_5.recursos.Recursos.Services;

import com.squad_5.recursos.Recursos.Models.HorasDia;
import com.squad_5.recursos.Recursos.Repositories.HorasDiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorasDiaService {

    @Autowired
    private HorasDiaRepository repo;

    public List<HorasDia> listAll() {
        return repo.findAll();
    }
}
