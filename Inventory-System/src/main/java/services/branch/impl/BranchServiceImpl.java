package services.branch.impl;

import models.Branch;
import org.springframework.stereotype.Service;
import repo.IBranch;
import services.branch.BranchService;
import services.generic.Impl.GenericServiceIImpl;

@Service
public class BranchServiceImpl extends GenericServiceIImpl<Branch,Long, IBranch> implements BranchService{
}
