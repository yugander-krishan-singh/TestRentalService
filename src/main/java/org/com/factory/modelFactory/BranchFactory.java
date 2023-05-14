package org.com.factory.modelFactory;

import org.com.model.Branch;

public class BranchFactory {
    public static Branch createBranch(String branchName, String cityId) {
        return new Branch(branchName, cityId);
    }
}
