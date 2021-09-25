package com.codestream.cssubmitserver.parasite;

import lombok.Data;

import java.util.HashMap;

@Data
public class Pro1Solution {
    int room;
    HashMap<String,Integer> p1;
    int p2;
    int p3;
    int p4;

    public Pro1Solution() {
        this.room=1;
        this.p1=new HashMap<String,Integer>();
        this.p2=2;
        this.p3=3;
        this.p4=4;
    }
}
