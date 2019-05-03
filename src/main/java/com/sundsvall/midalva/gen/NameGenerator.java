
package com.sundsvall.midalva.gen;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author ohhhhjoh
 */
public class NameGenerator {

    List<String> maleNames;
    List<String> lastNames;
    List<String> femaleNames;

    public NameGenerator( List<String> firstNames, List<String> femaleNames ,List<String> lastNames) {
        
        this.maleNames = firstNames;
        this.lastNames = lastNames;
        this.femaleNames = femaleNames;
   
    }

    public String getNextRandomMaleName() {
        if (maleNames == null ||maleNames.isEmpty()) {
            return "";
        }
        return maleNames.get(ThreadLocalRandom.current().nextInt(0, maleNames.size()));
    }

    public String getNextRandomLastName() {
        if (lastNames == null || lastNames.isEmpty()) {
            return null;
        }
        return lastNames.get(ThreadLocalRandom.current().nextInt(0, lastNames.size()));
    }
    
       public String getNextRandomFemaleName() {
        if (femaleNames == null || femaleNames.isEmpty()) {
            return null;
        }
        return femaleNames.get(ThreadLocalRandom.current().nextInt(0, femaleNames.size()));
    }




    public List<String> getMaleNames() {
        return maleNames;
    }

    public void setMaleNames(List<String> maleNames) {
        this.maleNames = maleNames;
    }

    public List<String> getLastNames() {
        return lastNames;
    }

    public void setLastNames(List<String> lastNames) {
        this.lastNames = lastNames;
    }

    public List<String> getFemaleNames() {
        return femaleNames;
    }

    public void setFemaleNames(List<String> femaleNames) {
        this.femaleNames = femaleNames;
    }

}
