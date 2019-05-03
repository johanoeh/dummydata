
package com.sundsvall.midalva.gen;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author ohhhhjoh
 */
public class NameGenerator {

    List<String> firstNames;
    List<String> lastNames;
    List<String> middleNames;

    public NameGenerator( List<String> firstNames, List<String> middleNames,List<String> lastNames) {
        this.firstNames = firstNames;
        this.lastNames = lastNames;
        this.middleNames = middleNames;
    }

    public String getNextRandomFirstName() {
        if (firstNames == null ||firstNames.isEmpty()) {
            return "";
        }
        return firstNames.get(ThreadLocalRandom.current().nextInt(0, firstNames.size()));
    }

    public String getNextRandomMiddleName() {
        if (middleNames == null || middleNames.isEmpty()) {
            return "";
        }
        return middleNames.get(ThreadLocalRandom.current().nextInt(0, middleNames.size()));
    }

    public String getNextRandomLastName() {
        if (lastNames == null || lastNames.isEmpty()) {
            return null;
        }
        return lastNames.get(ThreadLocalRandom.current().nextInt(0, lastNames.size()));
    }




    public List<String> getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(List<String> firstNames) {
        this.firstNames = firstNames;
    }

    public List<String> getLastNames() {
        return lastNames;
    }

    public void setLastNames(List<String> lastNames) {
        this.lastNames = lastNames;
    }

    public List<String> getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(List<String> middleNames) {
        this.middleNames = middleNames;
    }

}
