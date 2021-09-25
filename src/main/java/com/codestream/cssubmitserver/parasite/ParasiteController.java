package com.codestream.cssubmitserver.parasite;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@RestController
public class ParasiteController {
    @PostMapping("/parasite")
    public List<Pro1Solution> problemOne(@RequestBody List<InputParasite> inputParasiteList){
        List<Pro1Solution> sol_final=new LinkedList<Pro1Solution>();
        for(int i=0;i<inputParasiteList.size();i++){
            sol_final.add(solveAllProblems(inputParasiteList.get(i)));
        }
        return sol_final;
    }
    @GetMapping("/parasite")
    public String show(InputParasite inputParasite){
        return "No problem All is well!!!";
    }

    @PostMapping("/problem1")
    public HashMap<String, Integer> solveProblemOne(@RequestBody InputParasite input){
        HashMap<String,Integer> ans=new HashMap<String,Integer>();
        for(int i=0;i<input.interestedIndividuals.length;i++) {
            int ans_i = ParasiteSolution.bfs(input.grid, input.interestedIndividuals[i]);
            ans.put(input.interestedIndividuals[i], ans_i);
        }
        return ans;
    }

    public int solveProblemTwo(InputParasite input){
        return new Parasite2(input.grid,"").timeA();
    }

    public int solveProblemThree(InputParasite input){
        return new Parasite3(input.grid).timeB();
    }

    public int solveProblemFour(InputParasite input){
        return new Parasite4(input.grid).timeC();
    }

    public Pro1Solution solveAllProblems(InputParasite input){
        Pro1Solution sol_this=new Pro1Solution();
        sol_this.room=input.room;
        sol_this.p1=solveProblemOne(input);
        sol_this.p2=solveProblemTwo(input);
        sol_this.p3=solveProblemThree(input);
        sol_this.p4=solveProblemFour(input);
        return sol_this;
    }


}

