import { PantryItem } from './pantryitem';
import { FFSer } from './ffser';

export class Pantry {
  constructor(
    public items: Array<PantryItem> = [],
    public ffser?: FFSer
  ) {}
}
