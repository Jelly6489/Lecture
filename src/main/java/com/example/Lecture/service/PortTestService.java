package com.example.Lecture.service;

import com.example.Lecture.entity.PortTest;

import java.util.List;

public interface PortTestService {
    public void pjoin(PortTest portTest) throws Exception;
    public List<PortTest> plist() throws Exception;
    public void plogin(PortTest portTest) throws Exception;

}
