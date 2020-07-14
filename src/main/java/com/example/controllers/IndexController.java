package com.example.controllers;

import java.util.*;

import com.example.da.IssueRepository;
import com.example.domain.IssueEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.da.ListRepository;
import com.example.domain.ListEntity;

@Controller
public class IndexController {
    @Autowired
    private ListRepository listRep;
    @Autowired
    private IssueRepository issueRep;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String getIndex(Model model){
        Map<Long, ListEntity> lists = getLists();
        Iterable<IssueEntity> issues = issueRep.findAll();

        model.addAttribute("lists", lists.values());
        model.addAttribute("currentList", lists.get(null));
        model.addAttribute("issues", issues);

        return "index";
    }

    @RequestMapping(value = {"/list/{id}"}, method = RequestMethod.GET)
    public String getIndex(Model model, @PathVariable Long id){
        Map<Long, ListEntity> lists = getLists();
        Map<Long, IssueEntity> issues = getIssues(id);

        model.addAttribute("lists", lists.values());
        model.addAttribute("currentList", lists.get(id));
        model.addAttribute("issues", issues.values());

        return "index";
    }

    private Map<Long, ListEntity> getLists(){
        Map<Long, ListEntity> result = new HashMap<>();
        Iterable<ListEntity> lists = listRep.findAll();

        result.put(null, new ListEntity("Все"));

        for (ListEntity entity: lists) {
            result.put(entity.getId(), entity);
        }
        return result;
    }

    private Map<Long, IssueEntity> getIssues(Long id){
        Map<Long, IssueEntity> result = new HashMap<>();
        Iterable<IssueEntity> issues = issueRep.findAll();

        for (IssueEntity entity: issues) {
            if (entity.getParentId() == id)
                result.put(entity.getId(), entity);
        }
        return result;
    }

    @RequestMapping(value = {"/list/{id}/delete"})
    public String removeList(@PathVariable Long id) {
        listRep.deleteById(id);
        return "redirect:/list";
    }
    @RequestMapping(value = {"/issue/{issueId}/delete"})
    public String removeIssue(@PathVariable Long issueId) {
        IssueEntity issue = issueRep.findById((long)issueId);
        Long id = issue.getParentId();
        issueRep.deleteById(issueId);
        return "redirect:/list/" + id;
    }
    @RequestMapping(value = "/list/addissue", method = RequestMethod.GET)
    public String issueForm(Model model) {
        model.addAttribute("addissue", new IssueEntity());
        return "addissue";
    }

    @RequestMapping(value = {"/list/addissue"}, method = RequestMethod.POST)
    public String categorySubmit(@ModelAttribute IssueEntity addissue, Model model){
        issueRep.save(new IssueEntity(addissue.getParentId(), addissue.getTitle()));
        return "redirect:/list/" + addissue.getParentId();
    }
}