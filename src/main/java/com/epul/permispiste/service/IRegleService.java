package com.epul.permispiste.service;

import com.epul.permispiste.domains.RegleEntity;
import java.util.Set;

public interface IRegleService {
    public Set<RegleEntity> getToutesLesRegles();
    public RegleEntity getUneRegleNum(int numRegle);
}
