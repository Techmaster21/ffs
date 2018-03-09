import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StepsViewerComponent } from './steps-viewer.component';

describe('StepsViewerComponent', () => {
  let component: StepsViewerComponent;
  let fixture: ComponentFixture<StepsViewerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StepsViewerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StepsViewerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
