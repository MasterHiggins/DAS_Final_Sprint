package com.example.bstapp.controller;

import Sprint.Chris.model.BinarySearchTreeNode;
import Sprint.Chris.model.TreeData;
import Sprint.Chris.service.BinarySearchTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TreeController {

    @Autowired
    private BinarySearchTreeService treeService;

    @GetMapping("/enter-numbers")
    public String showInputForm() {
        return "enter-numbers";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam String numbers, Model model) throws Exception {
        List<Integer> numberList = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        BinarySearchTreeNode root = treeService.createTree(numberList);
        treeService.saveTreeData(numberList, root);

        model.addAttribute("tree", root);
        return "tree-view";
    }

    @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model) {
        List<TreeData> trees = treeService.getPreviousTrees();
        model.addAttribute("trees", trees);
        return "previous-trees";
    }
}
