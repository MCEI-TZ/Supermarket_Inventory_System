import { Observable } from 'rxjs';
import { Branch } from '../models/branch.model';

export abstract class BranchRepository {
  abstract getBranches(): Observable<Branch[]>;

  abstract getBranchById(id: number): Observable<Branch>;

  abstract createBranch(branch: Branch): Observable<Branch>;

  abstract updateBranch(id: number, branch: Branch): Observable<void>;

  abstract deleteBranch(id: number): Observable<void>;
}
