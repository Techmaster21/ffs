import { Pantryitem } from './pantryitem';
import { User } from './user';

export class Pantry {
  /**
   * represents a users pantry
   * @param items a list of items in the pantry
   * @param user the user that owns the pantry
   * @param id the id of the pantry
   */
  constructor(
    public items: Array<Pantryitem> = [],
    public user?: User,
    public id?: number
  ) {}
}
