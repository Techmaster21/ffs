import { Food } from './food';
import { Unit } from './unit';

export class Ingredient {
  /**
   * represents an ingredient in a recipe
   * @param the food used
   * @param unit the units the food is measured in
   * @param quantity the quantity of the food used
   */
  constructor(
    public food: Food = new Food(),
    public unit: Unit = new Unit(),
    public quantity?: number
  ) {}
}
