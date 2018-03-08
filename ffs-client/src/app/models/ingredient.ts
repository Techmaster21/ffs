import { Food } from './food';
import { Unit } from './unit';

export class Ingredient {
  constructor(
    public food: Food = new Food(),
    public unit: Unit = new Unit(),
    public quantity?: number
  ) {}
}
