import { Ingredient } from './ingredient';
import { Cuisine } from './cuisine';
import { User } from './user';
import { Step } from './step';

export class Recipe {
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
