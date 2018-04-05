export class Authority {
  /**
   * keeps track of the permissions of a user
   * @param id the id of the authority
   * @param username the username of the user
   * @param authority the permissions of the user
   */
  constructor(
    public id?: number,
    public username?: string,
    public authority?: string
  ) {}
}
