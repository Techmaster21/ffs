import { User } from './user';

export class Authority {
  constructor(
    public id?: number,
    public username?: string,
    public authority?: Authority,
    public users?: Array<User>
  ) {}
}
