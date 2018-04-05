import { Authority } from './authority';

export class User {
  /**
   * Represents a user of foodstuffs and food stuff
   * @param id the id of the user
   * @param username the username of the user
   * @param authority the permissions level of the user
   */
  constructor(
    public id?: number,
    public username?: string,
    public authority?: Authority
  ) {}
}
