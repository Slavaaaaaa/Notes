package com.example.controllers;

import java.util.Map;
import java.util.HashMap;

import com.example.da.ListRepository;
import com.example.domain.ListEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.da.ListRepository;
import com.example.domain.ListEntity;
import com.example.domain.IssueEntity;

@Controller
public class IndexController {
    @Autowired
    private ListRepository listRep;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String getIndex(Model model){
        Map<Long, ListEntity> lists = getLists();

        model.addAttribute("lists", lists.values());
        model.addAttribute("currentList", lists.get(null));

        return "index";
    }

    @RequestMapping(value = {"/list/{id}"}, method = RequestMethod.GET)
    public String getIndex(Model model, @PathVariable long id){
        Map<Long, ListEntity> lists = getLists();

        model.addAttribute("lists", lists.values());
        model.addAttribute("currentList", lists.get(null));

        return "index";
    }

    private Map<Long, ListEntity> getLists(){
        Map<Long, ListEntity> result = new HashMap<>();
        Iterable<ListEntity> lists = listRep.findAll();

        for (ListEntity entity: lists) {
            result.put(entity.getId(), entity);
        }
        return result;
    }
}

