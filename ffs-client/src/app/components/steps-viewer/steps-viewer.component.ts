import { Component, Input } from '@angular/core';

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
   * Removes a step at the given index
   * @param index The index of the step to remove
   */
  removeStep(index: number): void {
    this.steps.splice(index, 1);
  }

}
