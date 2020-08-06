package com.example.Lecture.service;

import com.example.Lecture.entity.PortTest;
import com.example.Lecture.repository.PortTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.util.List;


@Service
public class PortTestServiceImpl implements PortTestService {

    @Autowired
    private PortTestRepository portTestRepository;

    @Override
    public void join(PortTest portTest) throws Exception {
        portTestRepository.join(portTest);
    }

    @Override
    public List<PortTest> plist() throws Exception {
        return portTestRepository.plist();
    }

//    @Override
//    public PortTest login(PortTest portTest) throws Exception {
//        return portTestRepository.login(portTest);
//    }

}
