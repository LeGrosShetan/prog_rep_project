package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.EmpruntEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
interface IEmpruntService {
           public List<EmpruntEntity> getTousLesEmprunts();
}


