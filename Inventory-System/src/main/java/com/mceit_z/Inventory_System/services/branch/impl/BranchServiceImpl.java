package com.mceit_z.Inventory_System.services.branch.impl;

import com.mceit_z.Inventory_System.models.Branch;
import org.springframework.stereotype.Service;
import com.mceit_z.Inventory_System.repo.IBranch;
import com.mceit_z.Inventory_System.services.branch.BranchService;
import com.mceit_z.Inventory_System.services.generic.Impl.GenericServiceIImpl;

@Service
public class BranchServiceImpl extends GenericServiceIImpl<Branch,Long, IBranch> implements BranchService{
}
