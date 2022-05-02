package com.zenika.academy.barbajavas.backFinalProject.domain.application;

import org.springframework.stereotype.Component;

@Component
public class WordCounter {
    public int countWord(String string){
        String[] words=string.split("\\s+");
        return words.length;
    }
}
