import { Ingredient } from './ingredient';

export class Recipe {
  name: string;
  description: string;
  instructions: string[];
  ingredients: Ingredient[];
  key?: number;
}
