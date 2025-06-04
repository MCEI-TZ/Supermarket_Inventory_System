import { Branch } from "./branch.model";
import { Rol } from "./rol.model";

export class User {
  constructor(
    public idUser: number,
    public username: string,
    public password: string,
    public email: string,
    public fullName: string,
    public rol: Rol,
    public branch: Branch
  ) {}
}
