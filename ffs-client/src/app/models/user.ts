import { Authority } from './authority';

export class User {
  constructor(
    public id?: number,
    public username?: string,
    public authority?: Authority
  ) {}
}
