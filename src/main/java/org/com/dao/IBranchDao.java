package org.com.dao;

import java.util.List;
import java.util.Map;

import org.com.model.Branch;
import org.com.model.VehicleType;

public interface IBranchDao {
    void storeBranch(Branch branch);

    Branch getBranchById(String branchId);

    Branch getBranchByName(String branchName);

    List<Branch> getAllBranches();
}
