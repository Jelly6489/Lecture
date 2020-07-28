package com.example.Lecture.service;

import com.example.Lecture.entity.ItemMania;

import java.util.List;

public interface ItemService {
    public void gregister(ItemMania itemMania) throws Exception;
    public List<ItemMania> glist() throws Exception;
    public ItemMania gread(Integer idNo) throws Exception;
    public void gremove(Integer idNo) throws Exception;
    public void gmodify(ItemMania itemMania) throws Exception;
}
