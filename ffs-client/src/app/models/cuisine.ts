export class Cuisine {
  /**
   * the cuisine of a recipe
   * @param name the name of the cuisine
   * @param id the id of the cuisine
   */
  constructor(
    public name = '',
    public id?: number
  ) {}
}
