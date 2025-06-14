import { RolCreateDTO } from '../../infraestructure/dto/rol/rolCreate.dto';
import { RolReadDTO } from '../../infraestructure/dto/rol/rolRead.dto';
import { Rol } from '../models/rol.model';

export class RolMapper {
  static fromApiToDomain(apiRol: RolReadDTO): Rol {
    return {
      idRol: apiRol.idRol,
      name: apiRol.name,
    };
  }

  static fromDomainToApi(rol: Rol): RolCreateDTO {
    return {
      name: rol.name,
    };
  }
}
