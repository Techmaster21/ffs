import { Ingredient } from './ingredient';
import { Cuisine } from './cuisine';
import { User } from './user';
import { Step } from './step';

export class Recipe {
  /**
   * Represents a recipe that a user saved in the recipebook
   * @param name the name of the recipe
   * @param description the description of the recipe
   * @param ingredients a list of ingredients used in the recipe
   * @param steps a list of steps used in order to make the recipe
   * @param cuisine the cuisine of the recipe
   * @param prepTime the amount of time the recipe takes to prep
   * @param cookTime the amount of time the recipe takes to cook
   * @param user the user that owns the recipe
   * @param id the id of the recipe
   */
  constructor(
    public name = '',
    public description = '',
    public ingredients: Array<Ingredient> = [],
    public steps: Array<Step> = [],
    public cuisine: Cuisine = new Cuisine(),
    public prepTime?: string,
    public cookTime?: string,
    public user?: User,
    public id?: number
  ) {}
}
