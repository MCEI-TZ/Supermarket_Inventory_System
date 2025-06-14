import { BranchCreateDTO } from '../../infraestructure/dto/branch/branchCreate.dto';
import { BranchReadDTO } from '../../infraestructure/dto/branch/branchRead.dto';
import { Branch } from '../models/branch.model';

export class BranchMapper {
  static fromApiToDomain(apiBranch: BranchReadDTO): Branch {
    return {
      idBranch: apiBranch.idBranch,
      name: apiBranch.name,
      address: apiBranch.address,
      city: apiBranch.city,
      region: apiBranch.region,
    };
  }

  static fromDomainToApi(branch: Branch): BranchCreateDTO {
    return {
      name: branch.name,
      address: branch.address,
      city: branch.city,
      region: branch.region,
    };
  }
}
