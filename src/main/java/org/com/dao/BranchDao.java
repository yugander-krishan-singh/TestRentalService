package org.com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.com.model.Branch;
import org.com.model.VehicleType;

public class BranchDao implements IBranchDao {
    private final Map<String, Branch> branchIdMap;
    private final Map<String, Branch> branchNameMap;

    public BranchDao() {
        this.branchIdMap = new HashMap<>();
        this.branchNameMap = new HashMap<>();
    }

    @Override
    public void storeBranch(Branch branch) {
        this.branchIdMap.put(branch.getId(), branch);
        this.branchNameMap.put(branch.getName(), branch);
    }

    @Override
    public Branch getBranchById(String branchId) {
        return this.branchIdMap.get(branchId);
    }

    @Override
    public Branch getBranchByName(String branchName) {
        return this.branchNameMap.get(branchName);
    }

    @Override
    public List<Branch> getAllBranches() {
        return new ArrayList<>(this.branchIdMap.values());
    }
}
