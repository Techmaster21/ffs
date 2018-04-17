import { Food } from './food';
import { Unit } from './unit';

export class PantryItem {
  /**
   * represents an entry in a pantry
   * @param food the food being stored in the pantry
   * @param unit the units used to measure the food
   * @param quantity the quantity of the food in the pantry
   */
  constructor(
    public food: Food = new Food(),
    public unit: Unit = new Unit(),
    public quantity?: number
  ) {}
}
