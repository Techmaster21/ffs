import { Pantryitem } from './pantryitem';
import { FFSer } from './ffser';

export class Pantry {
  constructor(
  public items: Array<Pantryitem> = [],
  public ffser?: FFSer
  ) {}
}
