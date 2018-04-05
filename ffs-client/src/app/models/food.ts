export class Food {
  /**
   * represents a food for an ingredient in a recipe
   * @param name the name of the food
   * @param id the id of the food
   */
  constructor(
    public name = '',
    public id?: number
  ) {}
}
