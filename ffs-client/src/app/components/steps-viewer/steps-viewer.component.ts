import { Component, EventEmitter, Input, IterableDiffers, Output } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { RecipeService } from '../../services/recipe.service';

@Component({
  selector: 'app-steps-viewer',
  templateUrl: './steps-viewer.component.html',
  styleUrls: ['./steps-viewer.component.css']
})
export class StepsViewerComponent {
  /**
   * The list of steps
   */
  @Input() steps;
  /**
   * Whether or not the steps can be edited
   */
  @Input() canEdit = false;
  /**
   * Emits the ID of the step to remove
   */
  @Output() remove: EventEmitter<any> = new EventEmitter();

  /**
   * Removes a step at the given index
   * @param index The index of the step to remove
   */
  removeStep(index: number): void {
    this.remove.emit(this.steps[index].id);
    this.steps.splice(index, 1);
  }

}
