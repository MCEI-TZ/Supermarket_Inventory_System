import { Observable } from 'rxjs';
import { User } from '../models/user.model';

export abstract class UserRepository {
  abstract getUsers(): Observable<User[]>;

  abstract getUserById(id: number): Observable<User>;

  abstract createUser(user: User): Observable<User>;

  abstract updateUser(id: number, user: User): Observable<void>;

  abstract deleteUser(id: number): Observable<void>;
}
