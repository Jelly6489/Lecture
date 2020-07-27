package com.example.Lecture.service;


import com.example.Lecture.entity.ItemMania;

import java.util.List;

public interface ItemService {
    public void gregister(ItemMania itemMania) throws Exception;
    public List<ItemMania> glist() throws Exception;
}
