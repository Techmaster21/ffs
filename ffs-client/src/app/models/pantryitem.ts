import { Food } from './food';
import { Unit } from './unit';

export class Pantryitem {
  constructor(
    public food: Food = new Food(),
    public unit: Unit = new Unit(),
    public quantity?: number
  ) {}
}
