import { Recipe } from './recipe';

export class Calendarevent {
  constructor(
    public date = new Date(),
    public recipe = new Recipe()
  ) {}
}
