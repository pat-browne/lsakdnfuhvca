package com.techportal.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Patrick.Browne on 2/5/2016.
 */
public class MyTestResults {

    int passed;
    int failed;
    int skipped;

    public int getPassed(){
        return this.passed;
    }

    public int getFailed(){
        return this.failed;
    }

    public int getSkipped(){
        return this.skipped;
    }

    public int totalTests(){
        return (this.failed + this.passed + this.skipped);
    }

    public void incrementPassed(){
        this.passed++;
    }

    public void incrementFailed(){
        this.failed++;
    }

    public void incrementSkipped(){
        this.skipped++;
    }

    public void writeResultsCSV() {
        File file = new File("MyTestResults.csv");

        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bWriter = new BufferedWriter(fw)) {
            bWriter.write("PASSED," + this.passed + "\n");
            bWriter.write("FAILED,"+this.failed+"\n");
            bWriter.write("SKIPPED,"+this.skipped+"\n");
            bWriter.write("TOTAL,"+this.totalTests()+"\n");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void writeResultsText() {
        File file = new File("MyTestResults.txt");

        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bWriter = new BufferedWriter(fw)) {
            bWriter.write("PASSED="+this.passed+"\n");
            bWriter.write("FAILED="+this.failed+"\n");
            bWriter.write("SKIPPED="+this.skipped+"\n");
            bWriter.write("TOTAL="+this.totalTests()+"\n");
        } catch(IOException e){
            e.printStackTrace();
        }
    }






}
