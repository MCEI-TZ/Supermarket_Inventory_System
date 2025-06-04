import { Observable } from 'rxjs';
import { Rol } from '../models/rol.model';

export abstract class RoleRepository {
  abstract getRoles(): Observable<Rol[]>;

  abstract getRoleById(id: number): Observable<Rol>;

  abstract createRole(role: Rol): Observable<Rol>;

  abstract updateRole(id: number, role: Rol): Observable<void>;

  abstract deleteRole(id: number): Observable<void>;
}
