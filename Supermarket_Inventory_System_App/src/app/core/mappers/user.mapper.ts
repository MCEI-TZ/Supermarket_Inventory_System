import { UserCreateDTO } from '../../infraestructure/dto/user/userCreate.dto';
import { UserReadDTO } from '../../infraestructure/dto/user/userRead.dto';
import { Branch } from '../models/branch.model';
import { Rol } from '../models/rol.model';
import { User } from '../models/user.model';

export class UserMapper {
  static fromApiToDomain(apiUser: UserReadDTO): User {
    return {
      idUser: apiUser.idUser,
      username: apiUser.username,
      password: apiUser.password,
      email: apiUser.email,
      fullName: apiUser.fullName,
      rol: { name: apiUser.rolName } as Rol,
      branch: { name: apiUser.branchName } as Branch,
    };
  }

  static fromDomainToApi(user: User): UserCreateDTO {
    return {
      idBranch: user.branch.idBranch,
      idRol: user.rol.idRol,
      password: user.password,
      username: user.username,
      email: user.email,
      fullName: user.fullName,
    };
  }
}
