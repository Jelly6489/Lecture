package com.example.Lecture.service;

import com.example.Lecture.entity.ItemMania;
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
    public void join(PortTest portTest) throws Exception {
        portTestRepository.join(portTest);
    }

    @Override
    public List<PortTest> plist() throws Exception {
        return portTestRepository.plist();
    }

    @Override
    public boolean login(PortTest portTest) throws Exception {
        return portTestRepository.login(portTest);
    }

    @Override
    public boolean idcheck(PortTest portTest) throws Exception {
        return portTestRepository.idcheck(portTest);
    }

    @Override
    public PortTest pread(Integer idNo) throws Exception {
        return portTestRepository.pread(idNo);
    }

    @Override
    public void premove(Integer idNo) throws Exception {
        portTestRepository.premove(idNo);
    }

    @Override
    public void pmodify(PortTest portTest) throws Exception {
        portTestRepository.pmodify(portTest);
    }
}
