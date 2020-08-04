package com.example.Lecture.service;

import com.example.Lecture.entity.PortTest;
import com.example.Lecture.repository.PortTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PortTestServiceImpl implements PortTestService {

    @Autowired
    private PortTestRepository portTestRepository;

    @Override
    public void pjoin(PortTest portTest) throws Exception {
        portTestRepository.pjoin(portTest);
    }

    @Override
    public List<PortTest> plist() throws Exception {
        return portTestRepository.plist();
    }

    @Override
    public void plogin(PortTest portTest) throws Exception {
        portTestRepository.plogin(portTest);
    }

}
