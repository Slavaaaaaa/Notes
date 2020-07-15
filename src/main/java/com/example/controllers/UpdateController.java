package com.example.controllers;

import com.example.da.IssueRepository;
import com.example.domain.IssueEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.example.da.ListRepository;
import com.example.domain.ListEntity;


@Controller
public class UpdateController {
    @Autowired
    private ListRepository listRep;
    @Autowired
    private IssueRepository issueRep;
    @GetMapping(value = {"/list/{id}/update"})
    public String updateForm(Model model, @PathVariable long id) {
        ListEntity list = listRep.findById(id);
        model.addAttribute("list", list);
        return "/update";
    }

    @RequestMapping(value = {"/list/{id}/update"}, method = {RequestMethod.POST})
    public String updateSubmit(Model model, @PathVariable long id, @ModelAttribute("list") ListEntity list) {
        ListEntity listToUpdate = listRep.findById(id);
        listToUpdate.setName(list.getName());
        listRep.save(listToUpdate);
        return "redirect:/list/" + id;
    }
    @GetMapping(value = {"/issue/{issueId}/update"})
    public String upIssueForm(Model model, @PathVariable long issueId){
        IssueEntity issue = issueRep.findById(issueId);
        model.addAttribute("issue", issue);

        return "/updateIssue";
    }

    @RequestMapping(value = {"/issue/{issueId}/update"}, method = RequestMethod.POST)
    public String upIssueSubmit(Model model, @PathVariable long issueId,
                               @ModelAttribute("issue") IssueEntity issue){
        IssueEntity issueToUpdate = issueRep.findById(issueId);
        issueToUpdate.setTitle(issue.getTitle());
        issueRep.save(issueToUpdate);
        Long id = issueToUpdate.getParentId();

        return "redirect:/list/" + id;
    }



}