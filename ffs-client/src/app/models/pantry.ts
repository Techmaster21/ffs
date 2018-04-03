import { Pantryitem } from './pantryitem';
import { User } from './user';

export class Pantry {
  constructor(
    public items: Array<Pantryitem> = [],
    public user?: User,
    public id?: number
  ) {}
}
