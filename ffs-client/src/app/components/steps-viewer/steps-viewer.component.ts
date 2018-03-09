import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-steps-viewer',
  templateUrl: './steps-viewer.component.html',
  styleUrls: ['./steps-viewer.component.css']
})
export class StepsViewerComponent {
  @Input() steps;
  @Input() canEdit = false;

  removeStep(index: number): void {
    this.steps.splice(index, 1);
  }

}
