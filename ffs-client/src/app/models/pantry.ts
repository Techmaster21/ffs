import { Pantryitem } from './pantryitem';
import { Ingredient } from './ingredient';
import { FFSer } from './ffser';

export class Pantry {
  constructor(
  public items: Array<Pantryitem> = [],
  public ffser: FFSer
  ) {}
}
