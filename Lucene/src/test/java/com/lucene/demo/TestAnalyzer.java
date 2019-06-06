package com.lucene.demo;

import org.apache.lucene.analysis.TokenStream;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;

public class TestAnalyzer {
 
    public static void main(String[] args) throws IOException {
         
        IKAnalyzer analyzer = new IKAnalyzer();
        TokenStream ts= analyzer.tokenStream("name", "护眼带光源");
        ts.reset();
        while(ts.incrementToken()){
            System.out.println(ts.reflectAsString(false));
        }
    }
}