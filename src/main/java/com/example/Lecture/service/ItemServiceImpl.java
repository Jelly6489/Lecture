package com.example.Lecture.service;


import com.example.Lecture.entity.ItemMania;
import com.example.Lecture.repository.ItemManiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemManiaRepository itemManiaRepository;

    @Override
    public void gregister(ItemMania itemMania) throws Exception {
        itemManiaRepository.create(itemMania);
    }

    @Override
    public List<ItemMania> glist() throws Exception {
        return itemManiaRepository.glist();
    }
}
