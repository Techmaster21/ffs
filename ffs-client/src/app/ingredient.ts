import { Food } from './food';
import { Unit } from './unit';

export class Ingredient {
  constructor(
    public food: Food,
    public unit: Unit,
    public quantity: number
  ) {}
}
