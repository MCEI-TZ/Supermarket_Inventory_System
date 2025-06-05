export interface UserCreateDTO {
  username: string;
  password: string;
  email?: string;
  fullName?: string;
  idRol: number;
  idBranch: number;
}
