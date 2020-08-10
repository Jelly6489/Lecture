package com.example.Lecture.service;

import com.example.Lecture.entity.ItemMania;
import com.example.Lecture.entity.PortTest;

import java.util.List;

public interface PortTestService {
    public void join(PortTest portTest) throws Exception;
    public List<PortTest> plist() throws Exception;
    public boolean login(PortTest portTest) throws Exception;
    public boolean idcheck(PortTest portTest) throws Exception;
    public PortTest pread(Integer idNo) throws Exception;
    public void premove(Integer idNo) throws Exception;
    public void pmodify(PortTest portTest) throws Exception;
}
