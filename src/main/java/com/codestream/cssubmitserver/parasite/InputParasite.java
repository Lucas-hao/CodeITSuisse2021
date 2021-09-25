package com.codestream.cssubmitserver.parasite;

import lombok.Data;

@Data
public class InputParasite {
    int room;
    int[][] grid;
    String[] interestedIndividuals;
}
